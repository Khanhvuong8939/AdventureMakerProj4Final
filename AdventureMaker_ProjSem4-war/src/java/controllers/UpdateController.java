/*
 *  ================================= Java ================================
 *                         Welcome to RaeJas - KODG
 *  ============================== I Love Java ============================
 */
package controllers;

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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UpdateController {

    @Autowired
    private AccountDetailsFacadeLocal accountDetailsFacadeLocal;

    @Autowired
    private AccountsFacadeLocal accountsFacadeLocal;

    @Autowired
    private GroupsFacadeLocal groupsFacadeLocal;
    
    @Autowired
    private GamesFacadeLocal gamesFacadeLocal;
    
    @Autowired
    private GameDetailsFacadeLocal gameDetailsFacadeLocal;
    
    @Autowired
    private StationsFacadeLocal stationsFacadeLocal;

    //đổi thông tin tài khoản.
    @RequestMapping(value="/editAccountDetails",params = {"action=Cập nhật"},method = RequestMethod.POST)
    private String editAccountDetails(HttpServletRequest request, ModelMap modelMap) {
        String accID = request.getParameter("txtAccId");
        AccountDetails accountDetails = accountDetailsFacadeLocal.find(accID);
        accountDetails.setAccFirstN(request.getParameter("txtFName"));
        accountDetails.setAccLastN(request.getParameter("txtLName"));
        accountDetails.setGroupID(groupsFacadeLocal.find(request.getParameter("selgroupID")));
        //convert Gender to data
        if (request.getParameter("txtGender").equals("Male")) {
            accountDetails.setGender(Boolean.FALSE);
        } else {
            accountDetails.setGender(Boolean.TRUE);
        }
        accountDetails.setDoB(request.getParameter("txtDob"));
        accountDetails.setEmail(request.getParameter("txtEmail"));
        accountDetails.setPhone(request.getParameter("txtPhone"));
        accountDetails.setAddress(request.getParameter("txtAddress"));
        accountDetails.setCompany(request.getParameter("txtCompany"));
        accountDetailsFacadeLocal.edit(accountDetails);
        modelMap.put("txtAccID", accID);
        return "redirect:/showAccountDetails.html";
    }
    
    @RequestMapping(value="/editAccountDetails",params = {"action=Trở về"},method = RequestMethod.POST)
    private String backtoClient(){
        return "client/indexClient";
    }

    @RequestMapping("/changePassword")
    private String changePass(HttpServletRequest request, ModelMap modelMap) {
        Accounts account = accountsFacadeLocal.find(request.getParameter("txtAccID"));
        account.setPassword(request.getParameter("txtPassword"));
        accountsFacadeLocal.edit(account);
        return "index";
    }
    
    @RequestMapping("/editGame")
    private String editGame(HttpServletRequest request, ModelMap modelMap){
        String gameID = request.getParameter("txtGameID");
        String customWin = request.getParameter("selCustomWin");
        String description = request.getParameter("txtDescription");
        String gameName = request.getParameter("txtGameName");
        Games g = gamesFacadeLocal.find(gameID);
//        g.setAccID(accountsFacadeLocal.find(accID));
        System.out.println(" Acc ID "+g.getAccID().getAccID());
        g.setCustomWin(Boolean.parseBoolean(customWin));
        g.setDescription(description);
        g.setGameName(gameName);
        g.setStatus(Boolean.FALSE);
        gamesFacadeLocal.edit(g);
        
        GameDetails gDetails = gameDetailsFacadeLocal.find(g.getGameID());
        String txtStartTime = request.getParameter("txtStartTime");
        String txtEndTime = request.getParameter("txtEndTime");
        String locatStart = request.getParameter("txtLocatStart");
        String locatEnd = request.getParameter("txtLocatEnd");
        int amtP = Integer.parseInt(request.getParameter("txtAmtP"));
        int amtS = Integer.parseInt(request.getParameter("txtAmtS"));
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy kk:mm:ss");
        try {
            gDetails.setStartTime(df.parse(txtStartTime));
            gDetails.setEndTime(df.parse(txtEndTime));
            gDetails.setLocationStart(locatStart);
            gDetails.setLocationEnd(locatEnd);
            gDetails.setAmtP(amtP);
            gDetails.setAmtS(amtS);
            g.setGameDetails(gDetails);
            System.out.println(" "+g.getGameDetails().getLocationStart());

        } catch (ParseException ex) {
            Logger.getLogger(InsertController.class.getName()).log(Level.SEVERE, null, ex);
        }
        gamesFacadeLocal.edit(g);
        gameDetailsFacadeLocal.edit(gDetails);
        modelMap.put("listStation", stationsFacadeLocal.findByGameID(g.getGameID()));
        modelMap.put("listAccountID",accountsFacadeLocal.findAll());
        return "client/games/editGameB2";
    }
    
    @RequestMapping("/editGameB2")
    private String editGameB2(HttpServletRequest request, ModelMap modelMap){
        String gameID = request.getParameter("txtGameID");
        List<Stations> listS = stationsFacadeLocal.findByGameID(gameID);
        for (int i = 0; i < listS.size(); i++) {
            String stID = listS.get(i).getStationID();
            System.out.println(" StationID "+listS.get(i).getStationID());
            listS.get(i).setLocationStation(request.getParameter("txtLocat"+stID));
            listS.get(i).setKeyQuestion(request.getParameter("txtQues"+stID));
            listS.get(i).setAccID(accountsFacadeLocal.find(request.getParameter("txtAcc"+stID)));
            stationsFacadeLocal.edit(listS.get(i));
        }
        modelMap.put("txtAccID", request.getParameter("txtAccID"));
        return "redirect:/showGame.html";
    }
}
