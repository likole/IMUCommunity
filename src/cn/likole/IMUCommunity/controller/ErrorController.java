package cn.likole.IMUCommunity.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by likole on 7/24/17.
 */
@Controller
public class ErrorController extends ActionSupport {
    public String notFound() throws IOException {
        ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print("{\"status\":404,\"message\":\"Not Found\"}");
        return NONE;
    }

    public  static Map<Integer,String> errorInfo;

    static {
        errorInfo = new HashMap<>();
        errorInfo.put(101, "token值无效");
        errorInfo.put(102, "您已经喜欢过了");
        errorInfo.put(103, "该吐槽不存在或违规");
        errorInfo.put(104, "评论不能少于3字");
        errorInfo.put(105, "权限不足");
        errorInfo.put(201,"用户名已存在");
        errorInfo.put(202,"密码不符合要求");
        errorInfo.put(203,"用户名不存在");
        errorInfo.put(204,"密码错误");
        errorInfo.put(205,"用户名不能为空");
        errorInfo.put(206,"性别信息有误");
        errorInfo.put(207,"学号有误");
        errorInfo.put(301,"标题不能为空");
        errorInfo.put(302,"内容不能为空");
        errorInfo.put(303,"该评论不存在");
        errorInfo.put(401,"文件过大");
    }

    public  static String getErrorInfo(int code)
    {
        if(errorInfo.containsKey(code))
            return errorInfo.get(code);
        return null;
    }

}
