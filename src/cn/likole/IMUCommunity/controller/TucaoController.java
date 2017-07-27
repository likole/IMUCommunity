package cn.likole.IMUCommunity.controller;

import cn.likole.IMUCommunity.dto.TucaoDto;
import cn.likole.IMUCommunity.dto.TucaoListDto;
import cn.likole.IMUCommunity.service.TucaoService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by likole on 7/24/17.
 */
@Controller
@Scope("prototype")
public class TucaoController extends ActionSupport {

    @Autowired
    TucaoService tucaoService;

    Map<String, Object> map = new HashMap<String, Object>();
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

    public String add() {
        int rsCode = tucaoService.add(data.getToken(), data.getContent());
        setMessage(rsCode);
        return SUCCESS;
    }

    public String edit(){
        setMessage(tucaoService.edit(data.getToken(),data.getTid(),data.getContent()));
        return SUCCESS;
    }

    public String delete(){
        setMessage(tucaoService.delete(data.getToken(),data.getTid()));
        return SUCCESS;
    }

    public String getList() {
        setMessage(0);
        List<TucaoListDto> rs = tucaoService.getList(data.getOffset(), data.getNum(),data.getSelfToken());
        map.put("data", rs);
        map.put("next", data.getOffset() + rs.size());
        return SUCCESS;
    }

    public String getLiked(){
        setMessage(0);
        map.put("data",tucaoService.getLiked(data.getSelfToken()));
        return SUCCESS;
    }

    public String like(){
        setMessage(tucaoService.like(data.getTid(),data.getSelfToken()));
        return  SUCCESS;
    }

    public String getItem(){
        setMessage(0);
        map.put("data",tucaoService.getItem(data.getTid(),data.getSelfToken()));
        return SUCCESS;
    }

    public String addComment(){
        setMessage(tucaoService.addComment(data.getTid(),data.getComment()));
        return  SUCCESS;
    }

    private void setMessage(int rsCode) {
        map.put("status", rsCode);
        map.put("message", ErrorController.getErrorInfo(rsCode));
    }
}
