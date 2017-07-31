package cn.likole.IMUCommunity.service;

import cn.likole.IMUCommunity.dao.*;
import cn.likole.IMUCommunity.dto.*;
import cn.likole.IMUCommunity.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by likole on 7/30/17.
 */
@Service
@Transactional
public class AdminService {

    @Autowired
    TucaoDao tucaoDao;
    @Autowired
    UserDao userDao;
    @Autowired
    LikesDao likesDao;
    @Autowired
    CommentsDao commentsDao;
    @Autowired
    AskDao askDao;
    @Autowired
    AnswerDao answerDao;
    @Autowired
    NotificationDao notificationDao;
    @Autowired
    OfficialAccountDao officialAccountDao;


    /**
     * 吐槽列表
     *
     * @return
     */
    public List<TucaoAdminDto> getTucaoList() {
        //获取所有吐槽
        List<Tucao> tucaos = tucaoDao.getAll();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<TucaoAdminDto> tucaoAdminDtos = new ArrayList<>();
        for (Tucao tucao : tucaos) {
            TucaoAdminDto tucaoAdminDto = new TucaoAdminDto();
            //基本数据
            tucaoAdminDto.setComment_num(tucao.getCommentNum());
            tucaoAdminDto.setContent(tucao.getContent());
            tucaoAdminDto.setLike_num(tucao.getLikeNum());
            //耗时操作
            tucaoAdminDto.setName(userDao.getByUid(tucao.getUid()).getName());
            tucaoAdminDto.setTid(tucao.getTid());
            tucaoAdminDto.setUid(tucao.getUid());
            tucaoAdminDto.setTime(simpleDateFormat.format(tucao.getTime()));
            //喜欢数据
            List<Likes> likesList = likesDao.getAllByTid(tucao.getTid());
            List<LikesAdminDto> likesAdminDtos = new ArrayList<>();
            for (Likes likes : likesList) {
                LikesAdminDto likesAdminDto = new LikesAdminDto();
                likesAdminDto.setUid(likes.getUid());
                //耗时操作
                likesAdminDto.setName(userDao.getByUid(likes.getUid()).getName());
                likesAdminDtos.add(likesAdminDto);
            }
            tucaoAdminDto.setLike(likesAdminDtos);
            //评论数据
            tucaoAdminDto.setComments(commentsDao.getAllByTid(tucao.getTid()));

            //添加完毕
            tucaoAdminDtos.add(tucaoAdminDto);
        }

        return tucaoAdminDtos;
    }


    /**
     * 用户列表
     *
     * @return
     */
    public List<User> getUserList() {
        return userDao.getAll();
    }

    /**
     * 咨询列表
     *
     * @return
     */
    public List<AskAdminDto> getAskList() {
        List<Ask> asks = askDao.getList();
        List<AskAdminDto> askAdminDtos = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //填充数据;
        for (Ask ask : asks) {
            AskAdminDto askAdminDto = new AskAdminDto();

            //基本数据
            askAdminDto.setAid(ask.getAid());
            askAdminDto.setDetail(ask.getDetail());
            askAdminDto.setTime(simpleDateFormat.format(ask.getTime()));
            askAdminDto.setTitle(ask.getTitle());
            askAdminDto.setUid(ask.getUid());
            //三行耗时操作
            User user = userDao.getByUid(ask.getUid());
            askAdminDto.setName(user.getName());
            askAdminDto.setAvatar(user.getAvatar());

//            //回答
//            List<Answer> answers= answerDao.getByAid(ask.getAid());
//            List<AnswerAdminDto> answerAdminDtos=new ArrayList<>();
//            for(Answer answer:answers){
//                AnswerAdminDto answerAdminDto=new AnswerAdminDto();
//                answerAdminDto.setAnsid(answer.getAnsid());
//                answerAdminDto.setAskid(answer.getAid());
//                answerAdminDto.setContent(answer.getContent());
//                answerAdminDto.setTime(simpleDateFormat.format(answer.getTime()));
//                answerAdminDto.setUid(answer.getUid());
//                //三行耗时操作
//                User user2=userDao.getByUid(ask.getUid());
//                answerAdminDto.setName(user2.getName());
//                answerAdminDto.setAvatar(user2.getAvatar());
//            }
//            askAdminDto.setAnswerAdminDtos(answerAdminDtos);

            //填充完毕
            askAdminDtos.add(askAdminDto);
        }
        return askAdminDtos;
    }


    /**
     * 咨询详情
     * @param aid
     * @return
     */
    public AskAdminDto getAskDetail(int aid) {
        Ask ask = askDao.getByAid(aid);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        AskAdminDto askAdminDto = new AskAdminDto();

        //基本数据
        askAdminDto.setAid(ask.getAid());
        askAdminDto.setDetail(ask.getDetail());
        askAdminDto.setTime(simpleDateFormat.format(ask.getTime()));
        askAdminDto.setTitle(ask.getTitle());
        askAdminDto.setUid(ask.getUid());
        //用户
        User user = userDao.getByUid(ask.getUid());
        askAdminDto.setName(user.getName());
        askAdminDto.setAvatar(user.getAvatar());
        //回答
        List<Answer> answers = answerDao.getByAid(ask.getAid());
        List<AnswerAdminDto> answerAdminDtos = new ArrayList<>();
        for (Answer answer : answers) {
            AnswerAdminDto answerAdminDto = new AnswerAdminDto();
            answerAdminDto.setAnsid(answer.getAnsid());
            answerAdminDto.setAskid(answer.getAid());
            answerAdminDto.setContent(answer.getContent());
            answerAdminDto.setTime(simpleDateFormat.format(answer.getTime()));
            answerAdminDto.setUid(answer.getUid());
            //三行耗时操作
            User user2 = userDao.getByUid(ask.getUid());
            answerAdminDto.setName(user2.getName());
            answerAdminDto.setAvatar(user2.getAvatar());

            //完毕
            answerAdminDtos.add(answerAdminDto);
        }
        askAdminDto.setAnswerAdminDtos(answerAdminDtos);

        return askAdminDto;
    }


    /**
     * 通知列表
     *
     * @return
     */
    public List<NotificationDto> getList() {
        List<Notification> notifications = notificationDao.getList();
        List<NotificationDto> notificationDtos = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (Notification notification : notifications) {
            NotificationDto notificationDto = new NotificationDto();
            notificationDto.setOid(notification.getOid());
            notificationDto.setNid(notification.getNid());
            notificationDto.setContent(notification.getContent());
            notificationDto.setName(officialAccountDao.get(notification.getOid()).getName());
            notificationDto.setTime(simpleDateFormat.format(notification.getTime()));
            notificationDto.setImportant(notification.getImportant());
            notificationDto.setStick(notification.getStick());

            notificationDtos.add(notificationDto);
        }

        return notificationDtos;
    }

    /**
     * 根据id获取通知
     *
     * @return
     */
    public List<NotificationDto> getByOid(int oid) {
        List<Notification> notifications = notificationDao.getByOid(oid);
        List<NotificationDto> notificationDtos = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (Notification notification : notifications) {
            NotificationDto notificationDto = new NotificationDto();
            notificationDto.setOid(notification.getOid());
            notificationDto.setNid(notification.getNid());
            notificationDto.setContent(notification.getContent());
            notificationDto.setName(officialAccountDao.get(notification.getOid()).getName());
            notificationDto.setTime(simpleDateFormat.format(notification.getTime()));
            notificationDto.setImportant(notification.getImportant());
            notificationDto.setStick(notification.getStick());

            notificationDtos.add(notificationDto);
        }

        return notificationDtos;
    }

    public OfficialAccount getNameByOid(int oid){
        return officialAccountDao.get(oid);
    }
}
