package cn.likole.IMUCommunity.controller;

import cn.likole.IMUCommunity.dto.TucaoAdminDto;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<TucaoAdminDto> getTucaoAdminDtos() {
        return tucaoAdminDtos;
    }

    public void setTucaoAdminDtos(List<TucaoAdminDto> tucaoAdminDtos) {
        this.tucaoAdminDtos = tucaoAdminDtos;
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

}
