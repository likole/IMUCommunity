package cn.likole.IMUCommunity.controller;

import cn.likole.IMUCommunity.service.NotificationService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by likole on 7/27/17.
 */
@Controller
@Scope("prototype")
public class NotificationController extends ActionSupport{

    int oid;
    String content;
    int important;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImportant() {
        return important;
    }

    public void setImportant(int important) {
        this.important = important;
    }

    @Autowired
    NotificationService notificationService;

    Map<String,Object> map=new HashMap<>();

    public Map<String, Object> getMap() {
        return map;
    }

    public String getList(){
        setMessage(0);
        map.put("data",notificationService.getList());
        return SUCCESS;
    }

    public String getByOid(){
        setMessage(0);
        map.put("data",notificationService.getByOid(oid));
        return SUCCESS;
    }


    private void setMessage(int rsCode){
        map.put("status",rsCode);
        map.put("messge",ErrorController.getErrorInfo(rsCode));
    }
}
