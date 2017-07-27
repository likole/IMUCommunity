package cn.likole.IMUCommunity.service;

import cn.likole.IMUCommunity.dao.AskDao;
import cn.likole.IMUCommunity.dao.UserDao;
import cn.likole.IMUCommunity.dto.AskDto;
import cn.likole.IMUCommunity.entity.Ask;
import cn.likole.IMUCommunity.entity.User;
import cn.likole.IMUCommunity.util.TimeFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by likole on 7/27/17.
 */
@Service
@Transactional
public class AskService {

    @Autowired
    AskDao askDao;
    @Autowired
    UserDao userDao;


    /**
     * 获取咨询列表
     * @return
     */
    public List<AskDto> getList(){
        List<Ask> asks=askDao.getList();

        List<AskDto> askDtos=new ArrayList<>();

        for (Ask ask:asks){
            AskDto askDto=new AskDto();
            askDto.setAid(ask.getAid());
            askDto.setTitle(ask.getTitle());
            askDto.setTime(TimeFormatUtil.formatTime(ask.getTime()));
            askDto.setDetail(ask.getDetail());
            askDto.setName(userDao.getByUid(ask.getUid()).getName());

            askDtos.add(askDto);
        }

        return askDtos;
    }


    /**
     * 搜索
     * @param key
     * @return
     */
    public List<AskDto> search(String key){
        List<Ask> asks=askDao.getLike(key);

        List<AskDto> askDtos=new ArrayList<>();

        for (Ask ask:asks){
            AskDto askDto=new AskDto();
            askDto.setAid(ask.getAid());
            askDto.setTitle(ask.getTitle());
            askDto.setTime(TimeFormatUtil.formatTime(ask.getTime()));
            askDto.setDetail(ask.getDetail());
            askDto.setName(userDao.getByUid(ask.getUid()).getName());

            askDtos.add(askDto);
        }

        return askDtos;
    }


    /**
     * 获取自己咨询过的
     * @param token
     * @return
     */
    public List<AskDto> getSelfList(String token){
        User user=userDao.getByToken(token);
        if(user==null)return null;

        int uid=user.getUid();


        List<Ask> asks=askDao.getByUid(uid);
        List<AskDto> askDtos=new ArrayList<>();

        for (Ask ask:asks){
            AskDto askDto=new AskDto();
            askDto.setAid(ask.getAid());
            askDto.setTitle(ask.getTitle());
            askDto.setTime(TimeFormatUtil.formatTime(ask.getTime()));
            askDto.setDetail(ask.getDetail());
            askDto.setName(user.getName());

            askDtos.add(askDto);
        }

        return askDtos;
    }


    /**
     * 添加咨询
     * @param title
     * @param detail
     * @param token
     * @return
     */
    public int add(String title,String detail,String token){
        User user=userDao.getByToken(token);
        if(user==null)return 101;
        if(title==null)return 301;

        Ask ask=new Ask();
        ask.setTitle(title);
        ask.setDetail(detail);
        ask.setTime(new Date());
        ask.setUid(user.getUid());
        askDao.save(ask);
        return 0;
    }


    public int delete(int aid,String token){
        User user=userDao.getByToken(token);
        if(user==null)return 101;

        askDao.delete(aid);
        return 0;
    }

}
