package cn.likole.IMUCommunity.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Created by likole on 7/24/17.
 */
@Controller
public class ErrorController extends ActionSupport {
    public String notFound() throws IOException {
        ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print("{\"code\":404,\"message\":\"Not Found\"}");
        return NONE;
    }
}
