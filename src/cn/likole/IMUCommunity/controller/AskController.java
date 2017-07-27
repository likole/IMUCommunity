package cn.likole.IMUCommunity.controller;

import cn.likole.IMUCommunity.entity.Ask;
import cn.likole.IMUCommunity.service.AskService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by likole on 7/27/17.
 */
@Controller
public class AskController extends ActionSupport implements ModelDriven<Ask> {

    @Autowired
    AskService askService;

    Ask ask=new Ask();

    @Override
    public Ask getModel() {
        return ask;
    }

    Map<String,Object> map=new HashMap<>();

    public Map<String, Object> getMap() {
        return map;
    }

    String token;
    String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getList(){
        setMessage(0);
        map.put("data",askService.getList());
        return SUCCESS;
    }

    public String getSelf(){
        setMessage(0);
        map.put("data",askService.getSelfList(token));
        return SUCCESS;
    }

    public String add(){
        setMessage(askService.add(ask.getTitle(),ask.getDetail(),token));
        return SUCCESS;
    }

    public String delete(){
        setMessage(askService.delete(ask.getAid(),token));
        return SUCCESS;
    }

    public String search(){
        setMessage(0);
        map.put("data",askService.search(key));
        return SUCCESS;
    }

    private void setMessage(int rsCode){
        map.put("status",rsCode);
        map.put("message",ErrorController.getErrorInfo(rsCode));
    }
}
