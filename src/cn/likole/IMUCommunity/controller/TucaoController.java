package cn.likole.IMUCommunity.controller;

import cn.likole.IMUCommunity.dto.TucaoDto;
import cn.likole.IMUCommunity.service.TucaoService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by likole on 7/24/17.
 */
@Controller
@Scope("prototype")
public class TucaoController extends ActionSupport {

    @Autowired
    TucaoService tucaoService;

    Map<String,Object> map=new HashMap<String,Object>();
    TucaoDto data;

    public Map<String, Object> getMap() {
        return map;
    }

    public TucaoDto getData() {
        return data;
    }

    public void setData(TucaoDto data) {
        this.data = data;
    }

    public String add(){
        int rsCode = tucaoService.add(data.getToken(),data.getContent());
        setMessage(rsCode);
        return SUCCESS;
    }

    private void setMessage(int rsCode)
    {
        map.put("status",rsCode);
        switch (rsCode){
            case 101:
                map.put("message","token值无效!");
                break;
        }
    }
}
