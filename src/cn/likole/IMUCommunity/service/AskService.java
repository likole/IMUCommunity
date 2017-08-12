package cn.likole.IMUCommunity.service;

import cn.likole.IMUCommunity.dao.AnswerDao;
import cn.likole.IMUCommunity.dao.AskDao;
import cn.likole.IMUCommunity.dao.UserDao;
import cn.likole.IMUCommunity.dto.AnswerDto;
import cn.likole.IMUCommunity.dto.AskDto;
import cn.likole.IMUCommunity.entity.Answer;
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
    @Autowired
    AnswerDao answerDao;


    /**
     * 获取咨询列表
     *
     * @return
     */
    public List<AskDto> getList(String token) {
        User self=null;

        if(token!=null) self=userDao.getByToken(token);

        List<Ask> asks = askDao.getList();

        List<AskDto> askDtos = new ArrayList<>();

        for (Ask ask : asks) {
            AskDto askDto = new AskDto();
            askDto.setAid(ask.getAid());
            askDto.setTitle(ask.getTitle());
            askDto.setTime(TimeFormatUtil.formatTime(ask.getTime()));
            askDto.setDetail(ask.getDetail());
            User user=userDao.getByUid(ask.getUid());
            askDto.setName(user.getName());
            askDto.setAvatar(user.getAvatar());
            if(self!=null) askDto.setSelf(self.getUid()==user.getUid());
            askDtos.add(askDto);
        }

        return askDtos;
    }


    /**
     * 搜索
     *
     * @param key
     * @return
     */
    public List<AskDto> search(String key,String token) {

        User self=null;

        if(token!=null) self=userDao.getByToken(token);

        List<Ask> asks = askDao.getLike(key);

        List<AskDto> askDtos = new ArrayList<>();

        for (Ask ask : asks) {
            AskDto askDto = new AskDto();
            askDto.setAid(ask.getAid());
            askDto.setTitle(ask.getTitle());
            askDto.setTime(TimeFormatUtil.formatTime(ask.getTime()));
            askDto.setDetail(ask.getDetail());
            User user=userDao.getByUid(ask.getUid());
            askDto.setName(user.getName());
            askDto.setAvatar(user.getAvatar());
            if(self!=null) askDto.setSelf(self.getUid()==user.getUid());

            askDtos.add(askDto);
        }

        return askDtos;
    }


    /**
     * 获取自己咨询过的
     *
     * @param token
     * @return
     */
    public List<AskDto> getSelfList(String token) {
        User user = userDao.getByToken(token);
        if (user == null) return null;

        int uid = user.getUid();


        List<Ask> asks = askDao.getByUid(uid);
        List<AskDto> askDtos = new ArrayList<>();

        for (Ask ask : asks) {
            AskDto askDto = new AskDto();
            askDto.setAid(ask.getAid());
            askDto.setTitle(ask.getTitle());
            askDto.setTime(TimeFormatUtil.formatTime(ask.getTime()));
            askDto.setDetail(ask.getDetail());
            askDto.setName(user.getName());
            askDto.setAvatar(user.getAvatar());
            askDto.setSelf(true);

            askDtos.add(askDto);
        }

        return askDtos;
    }


    /**
     * 添加咨询
     *
     * @param title
     * @param detail
     * @param token
     * @return
     */
    public int add(String title, String detail, String token) {
        User user = userDao.getByToken(token);
        if (user == null) return 101;
        if (title == null) return 301;

        Ask ask = new Ask();
        ask.setTitle(title);
        ask.setDetail(detail);
        ask.setTime(new Date());
        ask.setUid(user.getUid());
        askDao.save(ask);
        return 0;
    }


    /**
     * 编辑咨询
     * @param aid
     * @param token
     * @param detail
     * @return
     */
    public int edit(int aid,String token,String detail) {
        User user=userDao.getByToken(token);
        if(user==null) return 101;
        Ask ask=askDao.getByAid(aid);
        if(ask.getUid()!=user.getUid()) return 105;
        ask.setDetail(detail);
        return 0;
    }

    /**
     * 删除问题
     *
     * @param aid
     * @param token
     * @return
     */
    public int delete(int aid, String token) {
        User user = userDao.getByToken(token);
        if (user == null) return 101;

        askDao.delete(aid);
        return 0;
    }


    /**
     * 获取回答
     * @param aid
     * @return
     */
    public List<AnswerDto> getAnswers(int aid,String token) {
        User self=null;
        if(token!=null) self=userDao.getByToken(token);

        List<Answer> answers = answerDao.getByAid(aid);
        List<AnswerDto> answerDtos = new ArrayList<>();

        for (Answer answer : answers) {
            AnswerDto answerDto = new AnswerDto();
            answerDto.setId(answer.getAnsid());
            User user=userDao.getByUid(answer.getUid());
            answerDto.setName(user.getName());
            answerDto.setAvatar(user.getAvatar());
            if(self!=null) answerDto.setSelf(self.getUid()==user.getUid());
            answerDto.setContent(answer.getContent());
            answerDto.setTime(TimeFormatUtil.formatTime(answer.getTime()));

            answerDtos.add(answerDto);
        }
        return answerDtos;
    }


    /**
     * 添加回答
     * @param aid
     * @param token
     * @param content
     * @return
     */
    public int addAnswer(int aid,String token ,String content){
        User user=userDao.getByToken(token);
        if(user==null) return 101;
        if(content==null||content.equals("")) return 302;

        Answer answer=new Answer();
        answer.setAid(aid);
        answer.setContent(content);
        answer.setUid(user.getUid());
        answer.setTime(new Date());

        answerDao.add(answer);
        return 0;
    }


    /**
     * 编辑回答
     * @param ansid
     * @param token
     * @param content
     * @return
     */
    public int editAnswer(int ansid,String token ,String content){
        User user=userDao.getByToken(token);
        if(user==null) return 101;
        if(content==null||content.equals("")) return 302;

        Answer answer=answerDao.getByAnsid(ansid);
        if(answer==null) return 303;

        if(answer.getUid()==user.getUid()) answer.setContent(content);
        else return 105;

        return 0;
    }


    /**
     * 删除回答
     * @param ansid
     * @param token
     * @return
     */
    public int deleteAnswer(int ansid,String token){
        User user=userDao.getByToken(token);
        if(user==null) return 101;

        Answer answer=answerDao.getByAnsid(ansid);
        if(answer==null) return 303;

        if(answer.getUid()!=user.getUid()) return 105;

        answerDao.delete(ansid);

        return 0;
    }
}
