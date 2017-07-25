package cn.likole.IMUCommunity.service;

import cn.likole.IMUCommunity.dao.UserDao;
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


    public int register(String username,String password)
    {
        if(userDao.getByUsername(username)!=null) return 201;
        if(password.length()!=32) return 202;
        User user=new User();
        user.setName(username);
        user.setPassword(password);
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
}
