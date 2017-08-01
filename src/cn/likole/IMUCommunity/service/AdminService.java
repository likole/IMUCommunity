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
            User user=userDao.getByUid(tucao.getUid());
            tucaoAdminDto.setName(user.getName());
            tucaoAdminDto.setAvatar(user.getAvatar());
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
     * 删除吐槽
     * @param tid
     */
    public void delTucao(int tid){
        tucaoDao.delete(tid);
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
     * 删除咨询
     * @param aid
     */
    public void delAsk(int aid){
        askDao.delete(aid);
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

    /**
     * 置顶/取消置顶
     * @param nid
     */
    public void notificationStick(int nid){
        Notification notification= notificationDao.getByNid(nid);
        notification.setStick((notification.getStick()&0xFF)==1?(byte)0:(byte)1);
    }

    /**
     * 获取官方帐号信息
     * @param oid
     * @return
     */
    public OfficialAccount getNameByOid(int oid){
        return officialAccountDao.get(oid);
    }


    /**
     * 总览
     * @return
     */
    public DashDto dash(){
        DashDto dashDto=new DashDto();
        dashDto.setUser_num(userDao.getNum());
        dashDto.setTucao_num(tucaoDao.getNum());
        dashDto.setLike_num(likesDao.getNum());
        dashDto.setComment_num(commentsDao.getNum());
        dashDto.setAsk_num(askDao.getNum());
        dashDto.setAnswer_num(answerDao.getNum());
        dashDto.setOffice_num(officialAccountDao.getNum());
        dashDto.setNotification_num(notificationDao.getNum());
        return dashDto;
    }

    /**
     * 获取官方帐号列表
     * @return
     */
    public List<OfficialAccount> getOfficialAccounts(){
        return officialAccountDao.getList();
    }

    /**
     * 编辑官方帐号
     * @param oid
     * @param name
     * @param type
     * @param description
     */
    public void officeEdit(int oid,String name,int type,String description){
        OfficialAccount officialAccount=officialAccountDao.get(oid);
        officialAccount.setName(name);
        officialAccount.setType(type);
        officialAccount.setDescription(description);
    }
}
