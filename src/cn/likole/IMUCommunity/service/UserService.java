package cn.likole.IMUCommunity.service;

import cn.likole.IMUCommunity.dao.UserDao;
import cn.likole.IMUCommunity.dto.UserDto;
import cn.likole.IMUCommunity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by likole on 7/25/17.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    UserDao userDao;


    public int register(String username,String password,int gender)
    {
        if(userDao.getByUsername(username)!=null) return 201;
        if(username.length()==0) return 205;
        if(password.length()!=32) return 202;
        User user=new User();
        user.setName(username);
        user.setPassword(password);
        user.setGender(gender);
        user.setToken(UUID.randomUUID().toString());
        userDao.save(user);
        return 0;
    }

    public int login(String name,String password){
        User user=userDao.getByUsername(name);
        if(user==null) return 203;
        if(!user.getPassword().equals(password)) return 204;
        return 0;
    }

    public String getToken(String name){
        return userDao.getByUsername(name).getToken();
    }

    public int edit(String token, int gender,String sid,String spassword){
        if(gender<0||gender>2) return 206;
        if(sid!=null&&(sid.length()!=0&&sid.length()!=10)) return 207;
       User user=  userDao.getByToken(token);
       user.setGender(gender);
       user.setSid(sid);
       user.setSpassword(spassword);
       return 0;
    }

    public UserDto get(String token){
        User user=userDao.getByToken(token);
        if(user==null) return null;

        UserDto userDto=new UserDto();
        userDto.setName(user.getName());
        userDto.setGender(user.getGender());
        userDto.setSid(user.getSid());
        userDto.setSpassword(user.getSpassword());

        return  userDto;
    }


}
