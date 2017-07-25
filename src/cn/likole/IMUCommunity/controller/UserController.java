package cn.likole.IMUCommunity.controller;

import cn.likole.IMUCommunity.entity.User;
import cn.likole.IMUCommunity.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by likole on 7/25/17.
 */
@Controller
@Scope("prototype")
public class UserController extends ActionSupport implements ModelDriven<User> {
    Map<String,Object> map=new HashMap<>();

    User user=new User();

    @Override
    public User getModel() {
        return user;
    }

    @Autowired
    ErrorController errorController;

    @Autowired
    UserService userService;

    public Map<String, Object> getMap() {
        return map;
    }

    public String register(){
        setMessage(userService.register(user.getName(),user.getPassword()));
        return SUCCESS;
    }

    public String login(){
        int rsCode=userService.login(user.getName(),user.getPassword());
        setMessage(rsCode);
        if(rsCode==0) map.put("token",userService.getToken(user.getName()));
        return SUCCESS;
    }

    private void setMessage(int rsCode)
    {
        map.put("status",rsCode);
        map.put("message",errorController.getErrorInfo(rsCode));
    }
}
