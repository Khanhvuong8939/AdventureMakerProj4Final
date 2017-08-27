/*
 *  ================================= Java ================================
 *                         Welcome to RaeJas - KODG
 *  ============================== I Love Java ============================
 */
package controllers;

import com.sun.corba.se.spi.orb.OperationFactory;
import entities.AccountDetails;
import entities.AccountDetailsFacadeLocal;
import entities.Accounts;
import entities.AccountsFacadeLocal;
import entities.GameDetails;
import entities.GameDetailsFacadeLocal;
import entities.Games;
import entities.GamesFacadeLocal;
import entities.Groups;
import entities.GroupsFacadeLocal;
import entities.Stations;
import entities.StationsFacadeLocal;
import entities.Teams;
import entities.TeamsFacadeLocal;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@MultipartConfig(maxFileSize = 10 * 1024 * 1024, maxRequestSize = 20 * 1024 * 1024, fileSizeThreshold = 5 * 1024 * 1024)
public class InsertController {

    @Autowired
    private AccountsFacadeLocal accountsFacadeLocal;

    @Autowired
    private AccountDetailsFacadeLocal accountDetailsFacadeLocal;

    @Autowired
    private GamesFacadeLocal gamesFacadeLocal;

    @Autowired
    private GameDetailsFacadeLocal gameDetailsFacadeLocal;

    @Autowired
    private TeamsFacadeLocal teamsFacadeLocal;

    @Autowired
    private StationsFacadeLocal stationsFacadeLocal;

    @Autowired
    private GroupsFacadeLocal groupsFacadeLocal;
    
    //Đăng kí 1 account
    @RequestMapping("/register")
    private String register(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        String toGo = "register";
        if (accountsFacadeLocal.find(request.getParameter("txtID")) != null) {
            modelMap.put("message", "ID Existed");
        } else {
            Accounts acc = new Accounts(request.getParameter("txtID"), request.getParameter("txtPwd"), false, true);
            accountsFacadeLocal.create(acc);
            accountDetailsFacadeLocal.create(new AccountDetails(request.getParameter("txtID")));
            toGo = "index";
        }
        return toGo;
    }

    //Dăng kí nhiều account bằng file excel
    @RequestMapping("/registerFromExcel")
    private String registerFromExcel(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, @RequestParam("file") MultipartFile file) {
        String toGo = "index";
        try {
            List<Object> list = new ArrayList<>();
            InputStream inputStream = file.getInputStream();
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();

            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                list.clear();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            list.add(cell.getStringCellValue());
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            list.add(cell.getBooleanCellValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            list.add(cell.getNumericCellValue());
                            break;
                    }
                }
                System.out.println(" " + list.size());
                Accounts a = new Accounts(list.get(0).toString(), list.get(1).toString(), Boolean.parseBoolean(list.get(2).toString()), Boolean.parseBoolean(list.get(3).toString()));
                accountsFacadeLocal.create(a);
                accountDetailsFacadeLocal.create(new AccountDetails(a.getAccID()));
            }
            workbook.close();
            inputStream.close();
            return toGo;
        } catch (IOException ex) {
            Logger.getLogger(InsertController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toGo;
    }

    //Tạo 1 game
    @RequestMapping(value = "/createGame", params = {"action=Tiếp theo"}, method = RequestMethod.POST)
    private String createGameB1(HttpServletRequest request, ModelMap modelMap) {
        String accID = request.getSession().getAttribute("user").toString();
        String customWin = request.getParameter("selCustomWin");
        String description = request.getParameter("txtDescription");
        String gameName = request.getParameter("txtGameName");
        Games g = new Games(gamesFacadeLocal.newGameID());
        g.setAccID(accountsFacadeLocal.find(accID));
        g.setCustomWin(Boolean.parseBoolean(customWin));
        g.setDescription(description);
        g.setGameName(gameName);
        g.setStatus(Boolean.FALSE);
        gamesFacadeLocal.create(g);
        GameDetails gDetails = new GameDetails(g.getGameID());
        String txtStartTime = request.getParameter("txtStartTime");
        System.out.println(" " + txtStartTime);
        String txtEndTime = request.getParameter("txtEndTime");
        String locatStart = request.getParameter("txtLocatStart");
        String locatEnd = request.getParameter("txtLocatEnd");
        int amtP = Integer.parseInt(request.getParameter("txtAmtP"));
        int amtS = Integer.parseInt(request.getParameter("txtAmtS"));
        int amtT = Integer.parseInt(request.getParameter("txtAmtT"));
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy kk:mm:ss");
        try {
            gDetails.setStartTime(df.parse(txtStartTime));
            gDetails.setEndTime(df.parse(txtEndTime));
            gDetails.setLocationStart(locatStart);
            gDetails.setLocationEnd(locatEnd);
            gDetails.setAmtP(amtP);
            gDetails.setAmtS(amtS);

        } catch (ParseException ex) {
            Logger.getLogger(InsertController.class.getName()).log(Level.SEVERE, null, ex);
        }
        gameDetailsFacadeLocal.create(gDetails);
        g.setGameDetails(gDetails);
        gamesFacadeLocal.edit(g);
        for (int i = 0; i < amtS; i++) {
            Stations st = new Stations(stationsFacadeLocal.newStationID());
            st.setGameID(g);
            stationsFacadeLocal.create(st);
            g.getStationsCollection().add(st);
            gamesFacadeLocal.edit(g);
        }

        for (int i = 0; i < amtT; i++) {
            Teams t = new Teams(teamsFacadeLocal.newTeamID());
            t.setGameID(gamesFacadeLocal.find(g.getGameID()));
            t.setWin(Boolean.FALSE);
            teamsFacadeLocal.create(t);
            g.getTeamsCollection().add(t);
            gamesFacadeLocal.edit(g);
        }

        modelMap.put("listStation", stationsFacadeLocal.findByGameID(g.getGameID()));
        modelMap.put("listAccountID", accountsFacadeLocal.findByGroupID(accountsFacadeLocal.find(accID).getAccountDetails().getGroupID().getGroupID()));
        return "client/games/createGameB2";
    }

    @RequestMapping(value = "/createGame", params = {"action=Trở về"}, method = RequestMethod.POST)
    private String backToClient() {
        return "client/indexClient";
    }

    @RequestMapping("/createGameB2Controller")
    private String createGameB2Controller(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {

        String gameID = request.getParameter("txtGameID");
        List<Stations> listS = stationsFacadeLocal.findByGameID(gameID);
        for (int i = 0; i < listS.size(); i++) {
            String stID = listS.get(i).getStationID();
            System.out.println(" StationID " + listS.get(i).getStationID());
            listS.get(i).setLocationStation(request.getParameter("txtLocat" + stID));
            listS.get(i).setKeyQuestion(request.getParameter("txtQues" + stID));
            listS.get(i).setAccID(accountsFacadeLocal.find(request.getParameter("txtAcc" + stID)));
            stationsFacadeLocal.edit(listS.get(i));
        }
        modelMap.put("txtAccID", request.getParameter("txtAccID"));
        return "redirect:/showGame.html";
    }

    @RequestMapping("/createTeam")
    private String createTeam(HttpServletRequest request, ModelMap modelMap) {
        String gameID = request.getParameter("gameID");
        Games g = gamesFacadeLocal.find(gameID);
        String teamName = request.getParameter("teamName");
        String accID = request.getSession().getAttribute("user").toString();
        List<Teams> listTeam = teamsFacadeLocal.findByGameID(gameID);
        System.out.println(" List Team " + listTeam.size());
        for (Teams teams : listTeam) {
            if (teams.getTeamName() == null) {
                teams.setTeamName(teamName);
                Accounts a = accountsFacadeLocal.find(accID);
                a.getTeamsCollection().add(teams);
                accountsFacadeLocal.edit(a);
                teamsFacadeLocal.edit(teams);
                System.out.println(" Name " + teams.getTeamName());
                break;
            }
        }
        modelMap.put("game", gamesFacadeLocal.find(gameID));
        request.setAttribute("size", listTeam.size());
        modelMap.put("listTeam", listTeam);
        return "client/games/showTeam";
    }

    @RequestMapping("/createTeamB2")
    private String createTeamB2(HttpServletRequest request, ModelMap modelMap) {
        String teamID = request.getParameter("teamID");
        String message = "";
        String toGo = "client/games/showTeam";
        Accounts a = accountsFacadeLocal.find(request.getSession().getAttribute("user").toString());
        Teams t = teamsFacadeLocal.find(teamID);
        int amtP = t.getGameID().getGameDetails().getAmtP();
        List<Teams> listT = teamsFacadeLocal.findByGameID(t.getGameID().getGameID());
        if ((amtP / listT.size()) == t.getAccountsCollection().size() && listT.indexOf(t)!=(listT.size()-1)) {
            message = "Đội này đã đủ người, xin vui lòng chọn đội khác";
            modelMap.put("game", gamesFacadeLocal.find(t.getGameID().getGameID()));
            request.setAttribute("size", listT.size());
            modelMap.put("listTeam", listT);
            modelMap.put("message", message);
        } else {
            t.getAccountsCollection().add(a);
            a.getTeamsCollection().add(t);
            accountsFacadeLocal.edit(a);
            teamsFacadeLocal.edit(t);
            toGo = "redirect:/showGame.html";
        }
        return toGo;
    }
    
    @RequestMapping(value="/createGroup",params = {"action=Tạo nhóm"},method = RequestMethod.POST)
    private String createGroup(HttpServletRequest request,ModelMap modelMap){
        String groupName = request.getParameter("groupName");
        System.out.println(" "+groupName);
        String description = request.getParameter("description");
        Groups g = new Groups(groupsFacadeLocal.newGroupID());
        g.setGroupName(groupName);
        g.setDescription(description);
        AccountDetails a = accountDetailsFacadeLocal.find(request.getSession().getAttribute("user").toString());
        a.setGroupID(g);
        groupsFacadeLocal.create(g);
        g.getAccountDetailsCollection().add(a);
        groupsFacadeLocal.edit(g);
        accountDetailsFacadeLocal.edit(a);
        
        modelMap.put("listGroup", groupsFacadeLocal.findAll());
        return "/client/games/showGroup";
    }

    @RequestMapping(value="/createGroup",params = {"action=Trở về"},method = RequestMethod.POST)
    private String redirectBackToClient(HttpServletRequest request,ModelMap modelMap){
        return "client/indexClient";
    }
}
