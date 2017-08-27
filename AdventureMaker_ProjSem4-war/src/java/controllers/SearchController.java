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
import entities.Games;
import entities.GamesFacadeLocal;
import entities.GroupsFacadeLocal;
import entities.Teams;
import entities.TeamsFacadeLocal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {

    @Autowired
    private AccountsFacadeLocal accountsFacadeLocal;

    @Autowired
    private AccountDetailsFacadeLocal accountDetailsFacadeLocal;

    @Autowired
    private GamesFacadeLocal gamesFacadeLocal;

    @Autowired
    private GroupsFacadeLocal groupsFacadeLocal;
    
    @Autowired
    private TeamsFacadeLocal teamsFacadeLocal;

    //Kiểm tra việc đăng nhập và chuyển trang
    @RequestMapping(value="/loginAccounts", params = {"action=Đăng nhập"}, method = RequestMethod.POST)
    private String checkLoginAccounts(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        String toGo = "index";
        try {
            if (accountsFacadeLocal.checkLogin(request.getParameter("username"), request.getParameter("password"))) {

                HttpSession session = request.getSession();
                session.setAttribute("user", request.getParameter("username"));
                toGo = "/client/indexClient";
            }
        } catch (Exception e) {
            modelMap.put("message", "Invalid username or password!");
        }
        return toGo;
    }

    //Hiển thị các game trong hệ thống
    @RequestMapping("/showGame")
    private String showGame(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        String user = (String) request.getSession().getAttribute("user");
        List<Games> gamelist = gamesFacadeLocal.findAll();
        for (Games games : accountsFacadeLocal.find(user).getGamesCollection()) {
            if (gamelist.contains(games)) {
                gamelist.remove(games);
            }
        }
        System.out.println(" Size "+gamelist.size());
        modelMap.put("listOwner", accountsFacadeLocal.find(user).getGamesCollection());
        modelMap.put("listPlayer", gamelist);
        return "/client/games/showGame";
    }

//    Hiển thị thông tin chi tiết của một account dựa theo AccID lấy từ session
    @RequestMapping("/showAccountDetails")
    private String showAccountDetails(HttpServletRequest request, HttpServletRequest response, ModelMap modelMap) {
        String url = "/client/information/showInf";
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        try {
            if (accountDetailsFacadeLocal.find(user) != null) {
                url = "/client/information/showInf";
                modelMap.addAttribute("groupData", groupsFacadeLocal.findAll());
                modelMap.put("accountDetails", accountDetailsFacadeLocal.find(user));
                return url;
            } else {
                modelMap.put("message", "Cannot find AccountID: " + user);
                return url;
            }

        } catch (Exception e) {
            modelMap.put("message", "Cannot find AccountID: " + user);
            return url;
        }
    }
    
    @RequestMapping("/showgamedetails")
    private String showGameDetails(HttpServletRequest request, ModelMap modelMap) {
        String toGo = "/client/games/showGame";
        try {
            String id = request.getParameter("id");
            request.setAttribute("game", gamesFacadeLocal.find(id));
            request.setAttribute("listTeam",teamsFacadeLocal.findByGameID(id));
            toGo = "/client/games/showGameDetail";
        } catch (Exception e) {
            modelMap.put("message", "This user has no games yet");
        }
        return toGo;
    }
    
    @RequestMapping("/actionOnGroup")
    private String showMemOnGroup(HttpServletRequest request, ModelMap modelMap){
        String groupID = request.getParameter("groupID");
        modelMap.put("listMem", groupsFacadeLocal.find(groupID).getAccountDetailsCollection());
        modelMap.put("listGroup", groupsFacadeLocal.findAll());
        return "client/games/showGroup";
    }
    
    
    
    
}
