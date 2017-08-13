package cn.likole.IMUCommunity.controller;

import cn.likole.IMUCommunity.entity.User;
import cn.likole.IMUCommunity.service.UserService;
import cn.likole.IMUCommunity.util.COSUtil;
import cn.likole.IMUCommunity.util.MD5Util;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.request.UploadFileRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
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

    private File file;
    private String fileFileName;
    private String fileContentType;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    @Autowired
    UserService userService;

    public Map<String, Object> getMap() {
        return map;
    }

    public String register(){
        int rsCode=userService.register(user.getName(),user.getPassword(),user.getGender());
        setMessage(rsCode);
        if(rsCode==0)map.put("token",userService.getToken(user.getName()));
        return SUCCESS;
    }

    public String login(){
        int rsCode=userService.login(user.getName(),user.getPassword());
        setMessage(rsCode);
        if(rsCode==0) map.put("token",userService.getToken(user.getName()));
        return SUCCESS;
    }

    public String edit(){
        setMessage(userService.edit(user.getToken(),user.getGender(),user.getSid(),user.getSpassword()));
        return SUCCESS;
    }

    public String getInfo(){
        setMessage(0);
        map.put("data",userService.get(user.getToken()));
        return  SUCCESS;
    }

    public String setAvatar() throws IOException, NoSuchAlgorithmException {
        //限制长度
        if(file.length()>5000000)
        {
            setMessage(401);
            return SUCCESS;
        }

        //获取路径
        String path= ServletActionContext.getServletContext().getRealPath("/avatar");
        String fileName=MD5Util.encode(fileFileName+ Calendar.getInstance().getTimeInMillis())+fileFileName.substring(fileFileName.lastIndexOf('.'));

        //限制格式
        Image image= ImageIO.read(file);
        if(image==null)
        {
            setMessage(402);
            return SUCCESS;
        }

        //本地存储

//        InputStream inputStream=new FileInputStream(file);
//        OutputStream outputStream=new FileOutputStream(new File(path,fileName));
//
//        byte[] bytes=new byte[1024];
//
//        int len=0;
//
//        while (-1!=(len=inputStream.read(bytes,0,bytes.length))){
//            outputStream.write(bytes);
//        }
//
//        inputStream.close();
//        outputStream.close();


        //云端存储
        COSClient cosClient= COSUtil.getClient();
        UploadFileRequest uploadFileRequest = new UploadFileRequest("imucommunity", "/avatar/"+fileName, path+File.separator+fileName);
        String uploadFileRet = cosClient.uploadFile(uploadFileRequest);

        setMessage(userService.setAvatar(user.getToken(),fileName));
        return SUCCESS;
    }

    private void setMessage(int rsCode)
    {
        map.put("status",rsCode);
        map.put("message",ErrorController.getErrorInfo(rsCode));
    }
}
