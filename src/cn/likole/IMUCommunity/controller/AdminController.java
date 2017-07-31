package cn.likole.IMUCommunity.controller;

import cn.likole.IMUCommunity.dto.AskAdminDto;
import cn.likole.IMUCommunity.dto.NotificationDto;
import cn.likole.IMUCommunity.dto.TucaoAdminDto;
import cn.likole.IMUCommunity.entity.OfficialAccount;
import cn.likole.IMUCommunity.entity.User;
import cn.likole.IMUCommunity.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by likole on 7/28/17.
 */
public class AdminController extends ActionSupport {

    String username;
    String password;
    List<TucaoAdminDto> tucaoAdminDtos;
    List<User> users;
    List<AskAdminDto> askAdminDtos;
    AskAdminDto askAdminDto;
    int aid;
    int oid;
    OfficialAccount officialAccount;
    List<NotificationDto> notifications;


    public OfficialAccount getOfficialAccount() {
        return officialAccount;
    }

    public void setOfficialAccount(OfficialAccount officialAccount) {
        this.officialAccount = officialAccount;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public List<NotificationDto> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationDto> notifications) {
        this.notifications = notifications;
    }

    public List<TucaoAdminDto> getTucaoAdminDtos() {
        return tucaoAdminDtos;
    }

    public void setTucaoAdminDtos(List<TucaoAdminDto> tucaoAdminDtos) {
        this.tucaoAdminDtos = tucaoAdminDtos;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public AskAdminDto getAskAdminDto() {
        return askAdminDto;
    }

    public void setAskAdminDto(AskAdminDto askAdminDto) {
        this.askAdminDto = askAdminDto;
    }

    public List<AskAdminDto> getAskAdminDtos() {
        return askAdminDtos;
    }

    public void setAskAdminDtos(List<AskAdminDto> askAdminDtos) {
        this.askAdminDtos = askAdminDtos;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Autowired
    AdminService adminService;

    public String login(){
        HttpSession session=ServletActionContext.getRequest().getSession();

        if("login".equals( session.getAttribute("login"))) return SUCCESS;

        if("admin".equals(username)&&"123456".equals(password)){
            ServletActionContext.getRequest().getSession().setAttribute("login","login");
            return SUCCESS;
        }

        return INPUT;
    }

    public String tucao(){
        tucaoAdminDtos= adminService.getTucaoList();
        return SUCCESS;
    }

    public String user(){
        users=adminService.getUserList();
        return SUCCESS;
    }

    public String user_detail(){
        return SUCCESS;
    }

    public String ask(){
        askAdminDtos=adminService.getAskList();
        return SUCCESS;
    }

    public String ask_detail(){
        askAdminDto=adminService.getAskDetail(aid);
        return SUCCESS;
    }

    public String notification(){
        notifications=adminService.getList();
        return SUCCESS;
    }

    public String notification_o(){
        officialAccount=adminService.getNameByOid(oid);
        notifications=adminService.getByOid(oid);
        return SUCCESS;
    }
}
