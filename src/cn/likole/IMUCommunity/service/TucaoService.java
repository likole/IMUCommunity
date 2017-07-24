package cn.likole.IMUCommunity.service;

import cn.likole.IMUCommunity.dao.TucaoDao;
import cn.likole.IMUCommunity.dao.UserDao;
import cn.likole.IMUCommunity.entity.Tucao;
import cn.likole.IMUCommunity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by likole on 7/24/17.
 */
@Service
@Transactional
public class TucaoService {

   @Autowired
   TucaoDao tucaoDao;
   @Autowired
   UserDao userDao;

    public int add(String token,String content){
        User tempUser;
        if((tempUser=userDao.getByToken(token))==null) return 101;

            Tucao newTucao=new Tucao();
            newTucao.setContent(content);
            newTucao.setUid(tempUser.getUid());
            newTucao.setTime(new Date());
            tucaoDao.add(newTucao);
        return 0;
    }

}
