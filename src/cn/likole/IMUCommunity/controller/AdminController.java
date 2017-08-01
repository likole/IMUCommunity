package cn.likole.IMUCommunity.controller;

import cn.likole.IMUCommunity.dto.AskAdminDto;
import cn.likole.IMUCommunity.dto.DashDto;
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

    String username;//用户名
    String password;//密码
    List<TucaoAdminDto> tucaoAdminDtos;//吐槽列表
    List<User> users;//用户列表
    List<AskAdminDto> askAdminDtos;//咨询列表
    AskAdminDto askAdminDto;//咨询详情
    int aid;//咨询编号
    int oid=0;//官方帐号编号
    int tid;//吐槽编号
    int nid;//通知编号
    OfficialAccount officialAccount;//官方帐号信息
    List<NotificationDto> notifications;//通知列表
    DashDto dashDto;//总览
    List<OfficialAccount> officialAccounts;//官方帐号列表
    String name;
    int type;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OfficialAccount> getOfficialAccounts() {
        return officialAccounts;
    }

    public void setOfficialAccounts(List<OfficialAccount> officialAccounts) {
        this.officialAccounts = officialAccounts;
    }

    public DashDto getDashDto() {
        return dashDto;
    }

    public void setDashDto(DashDto dashDto) {
        this.dashDto = dashDto;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

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

    public String tucao_delete(){
        adminService.delTucao(tid);
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

    public String ask_delete(){
        adminService.delAsk(aid);
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

    public String notification_stick(){
        adminService.notificationStick(nid);
        if(oid!=0) return "o";
        return SUCCESS;
    }

    public String notification_o(){
        officialAccount=adminService.getNameByOid(oid);
        notifications=adminService.getByOid(oid);
        return SUCCESS;
    }

    public String dash(){
        dashDto=adminService.dash();
        return SUCCESS;
    }

    public String office(){
        officialAccounts=adminService.getOfficialAccounts();
        return SUCCESS;
    }

    public String office_edit(){
        adminService.officeEdit(oid,name,type,description);
        return SUCCESS;
    }
}
