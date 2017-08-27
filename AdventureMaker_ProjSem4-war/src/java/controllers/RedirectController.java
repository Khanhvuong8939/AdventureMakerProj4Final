/*
 *  ================================= Java ================================
 *                         Welcome to RaeJas - KODG
 *  ============================== I Love Java ============================
 */


package controllers;

import entities.AccountDetailsFacadeLocal;
import entities.AccountsFacadeLocal;
import entities.GamesFacadeLocal;
import entities.GroupsFacadeLocal;
import entities.TeamsFacadeLocal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {
    
    @Autowired
    private AccountsFacadeLocal accountsFacadeLocal;
    
    @Autowired
    private AccountDetailsFacadeLocal accountDetailsFacadeLocal;
    
    @Autowired
    private GroupsFacadeLocal groupsFacadeLocal;
    
    @Autowired
    private GamesFacadeLocal gameFacadeLocal;
    
    @Autowired
    private TeamsFacadeLocal teamFacadeLocal;
    
    @RequestMapping(value = "/clientAction",params = {"action=Thông tin cá nhân"},method = RequestMethod.POST)
    private String redirectClientInf(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap){
        return "redirect:/showAccountDetails.html";
    }
    
    @RequestMapping(value = "/clientAction",params = {"action=Lịch sử trò chơi"},method = RequestMethod.POST)
    private String redirectClientGames(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap){
        return "redirect:/showGame.html";
    }
    
    @RequestMapping(value = "/clientAction",params = {"action=Nhóm"},method = RequestMethod.POST)
    private String redirectClientGroup(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap){
        modelMap.put("listGroup", groupsFacadeLocal.findAll());
        return "client/games/showGroup";
    }
    
    @RequestMapping(value = "/redirectEditAccountDetails",params = {"action=Cập nhật thông tin cá nhân"},method = RequestMethod.POST)
    private String redirectEditAccount(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap){
        String accID = request.getParameter("txtAccId");
        modelMap.put("accountDetais", accountDetailsFacadeLocal.find(accID));
        modelMap.put("listGroup", groupsFacadeLocal.findAll());
        return "/client/information/editInf";
    }
    
    @RequestMapping(value = "/redirectEditAccountDetails",params = {"action=Thay đổi mật khẩu"},method = RequestMethod.POST)
    private String redirectChangePassAccount(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap){
        String accID = request.getParameter("txtAccId");
        modelMap.put("txtAccID", accountsFacadeLocal.find(accID).getAccID());
        return "/client/information/changePass";
    }
    
    @RequestMapping(value="/loginAccounts", params = {"action=Đăng kí"}, method = RequestMethod.POST)
    private String redirectRegister(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        return "register";
    }
    
    @RequestMapping("/redirectCreateGame")
    private String redirectCreateGame(HttpServletRequest request,ModelMap modelMap){
        modelMap.put("txtAccID", request.getParameter("txtAccID"));
        return "client/games/createGame";
    }
    
    @RequestMapping("/redirectEditGame")
    private String redirectEditGame(HttpServletRequest request,ModelMap modelMap){
        modelMap.put("game", gameFacadeLocal.find(request.getParameter("id")));
        return "client/games/editGame";
    }
    
    @RequestMapping("/redirectCreateTeam")
    private String redirectCreateTeam(HttpServletRequest request,ModelMap modelMap){
        modelMap.put("game", gameFacadeLocal.find(request.getParameter("id")));
        modelMap.put("size", teamFacadeLocal.findByGameID(request.getParameter("id")).size());
        modelMap.put("listTeam", teamFacadeLocal.findByGameID(request.getParameter("id")));
        return "client/games/showTeam";
    }
    
    @RequestMapping("/goBackClient")
    private String redirectClient(){
        return "client/indexClient";
    }
    
    @RequestMapping(value="/redirectCreateGroup")
    private String redirectToCreateGroup(HttpServletRequest request, ModelMap modelMap){
        return "client/games/createGroup";
    }
}
