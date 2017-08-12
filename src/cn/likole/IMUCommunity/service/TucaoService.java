package cn.likole.IMUCommunity.service;

import cn.likole.IMUCommunity.dao.CommentsDao;
import cn.likole.IMUCommunity.dao.LikesDao;
import cn.likole.IMUCommunity.dao.TucaoDao;
import cn.likole.IMUCommunity.dao.UserDao;
import cn.likole.IMUCommunity.dto.TucaoCommentDto;
import cn.likole.IMUCommunity.dto.TucaoItemDto;
import cn.likole.IMUCommunity.dto.TucaoListDto;
import cn.likole.IMUCommunity.entity.Comments;
import cn.likole.IMUCommunity.entity.Likes;
import cn.likole.IMUCommunity.entity.Tucao;
import cn.likole.IMUCommunity.entity.User;
import cn.likole.IMUCommunity.util.TimeFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Autowired
    LikesDao likesDao;
    @Autowired
    CommentsDao commentsDao;

    /**
     * 添加吐槽
     *
     * @param token
     * @param content
     * @return
     */
    public int add(String token, String content) {
        User tempUser;
        if ((tempUser = userDao.getByToken(token)) == null) return 101;

        Tucao newTucao = new Tucao();
        newTucao.setContent(content);
        newTucao.setUid(tempUser.getUid());
        newTucao.setTime(new Date());
        tucaoDao.add(newTucao);
        return 0;
    }

    /**
     * 编辑吐槽
     *
     * @param token
     * @param tid
     * @param content
     * @return
     */
    public int edit(String token, int tid, String content) {
        User tempUser = userDao.getByToken(token);
        if (tempUser == null) return 101;

        Tucao tucao = tucaoDao.getByTid(tid);
        if (tucao == null) return 103;
        if (tucao.getUid() != tempUser.getUid()) return 105;
        tucao.setContent(content);

        return 0;
    }

    /**
     * 删除吐槽
     *
     * @param token
     * @param tid
     * @return
     */
    public int delete(String token, int tid) {
        User tempUser = userDao.getByToken(token);
        if (tempUser == null) return 101;

        Tucao tucao = tucaoDao.getByTid(tid);
        if (tucao == null) return 103;
        if (tucao.getUid() != tempUser.getUid()) return 105;

        tucaoDao.delete(tid);

        return 0;
    }

    /**
     * 获取喜欢过的吐槽
     *
     * @param selfToken
     * @return
     */
    public List<TucaoListDto> getLiked(String selfToken) {
        //获取uid
        User self = userDao.getByToken(selfToken);
        if (selfToken == null) return null;
        int uid = self.getUid();

        List<Likes> likesList = likesDao.getAllByUid(uid);

        List<TucaoListDto> tucaoListDtos = new ArrayList<>();

        for (Likes like : likesList) {
            Tucao tucao = tucaoDao.getByTid(like.getTid());
            TucaoListDto tucaoListDto = new TucaoListDto();
            tucaoListDto.setTime(TimeFormatUtil.formatTime(tucao.getTime()));
            tucaoListDto.setId(tucao.getTid());
            tucaoListDto.setComment_num(tucao.getCommentNum());
            tucaoListDto.setLike_num(tucao.getCommentNum());
            tucaoListDto.setContent(tucao.getContent());
            tucaoListDto.setLiked(true);
            tucaoListDto.setGender(userDao.getByUid(tucao.getUid()).getGender());

            tucaoListDtos.add(tucaoListDto);
        }

        return tucaoListDtos;
    }


    /**
     * 获取所有吐槽
     *
     * @param offset
     * @param limit
     * @param selfToken 标注是否喜欢过
     * @return
     */
    public List<TucaoListDto> getList(int offset, int limit, String selfToken) {
        List<TucaoListDto> rs = new ArrayList<>();
        List<Tucao> tmp = tucaoDao.getList(offset, limit);

        int showLiked = 0;//是否返回已经喜欢
        int uid = 0;//自己的uid

        if (selfToken != null) {
            User self = userDao.getByToken(selfToken);
            if (self != null) {
                uid = self.getUid();
                showLiked = 1;
            }
        }

        for (Tucao tucao : tmp) {
            TucaoListDto rsTmp = new TucaoListDto();

            rsTmp.setId(tucao.getTid());
            rsTmp.setContent(tucao.getContent());
            rsTmp.setLike_num(tucao.getLikeNum());
            rsTmp.setComment_num(tucao.getCommentNum());
            rsTmp.setTime(TimeFormatUtil.formatTime(tucao.getTime()));
            rsTmp.setGender(userDao.getByUid(tucao.getUid()).getGender());
            //喜欢
            if (showLiked == 1)
                rsTmp.setLiked(likesDao.exist(tucao.getTid(), uid));

            rs.add(rsTmp);
        }

        return rs;
    }


    /**
     * 喜欢
     *
     * @param tid
     * @param selfToken
     * @return
     */
    public int like(int tid, String selfToken) {
        //获取uid
        User self = userDao.getByToken(selfToken);
        if (self == null) return 101;
        int uid = self.getUid();

        //是否已喜欢过
        if (likesDao.exist(tid, uid)) return 102;

        //喜欢
        Likes tmp = new Likes();
        tmp.setTid(tid);
        tmp.setUid(uid);
        likesDao.save(tmp);

        //更新喜欢值
        Tucao tucao = tucaoDao.getByTid(tid);
        tucao.setLikeNum(tucao.getLikeNum() + 1);
        return 0;
    }


    /**
     * 添加评论
     *
     * @param tid
     * @param comment
     * @return
     */
    public int addComment(int tid, String comment,String token) {

        Tucao tucao=tucaoDao.getByTid(tid);
        if (tucao == null) return 103;
        if (comment.length() < 3) return 104;

        User user=userDao.getByToken(token);
        if(user==null) return 101;

        Comments comments = new Comments();
        comments.setTid(tid);
        comments.setContent(comment);
        comments.setUid(user.getUid());
        tucao.setCommentNum(tucao.getCommentNum()+1);
        commentsDao.save(comments);

        return 0;
    }


    /**
     * 获取吐槽详情
     *
     * @param tid
     * @return
     */
    public TucaoItemDto getItem(int tid, String token) {
        boolean login = false;
        int uid = 0;
        User user = userDao.getByToken(token);
        if (user != null) {
            login = true;
            uid = user.getUid();
        }

        Tucao tucao = tucaoDao.getByTid(tid);
        if(tucao==null) return null;
        TucaoItemDto tucaoItemDto = new TucaoItemDto();

        tucaoItemDto.setTid(tid);
        tucaoItemDto.setContent(tucao.getContent());
        tucaoItemDto.setLike_num(tucao.getLikeNum());
        tucaoItemDto.setTime(TimeFormatUtil.formatTime(tucao.getTime()));
        tucaoItemDto.setGender(userDao.getByUid(tucao.getUid()).getGender());

        if (login == true) {
            //是否喜欢过
            tucaoItemDto.setLiked(likesDao.exist(tid, uid));
            //是否为自己的
            tucaoItemDto.setSelf(tucao.getUid() == uid);
        }


        //评论
        List<Comments> tucaoComments=commentsDao.getAllByTid(tid);
        List<TucaoCommentDto> tucaoComments1=new ArrayList<>();

        for(Comments comments:tucaoComments)
        {
            tucaoComments1.add(comments2tucaoComment(comments));
        }

        tucaoItemDto.setComments(tucaoComments1);

        return tucaoItemDto;
    }


    /**
     * 吐槽评论填充
     * @param comments
     * @return
     */
    private TucaoCommentDto comments2tucaoComment(Comments comments)
    {
        TucaoCommentDto tucaoCommentDto=new TucaoCommentDto();
        tucaoCommentDto.setGender(userDao.getByUid(comments.getUid()).getGender());
        tucaoCommentDto.setComments(comments.getContent());
        return tucaoCommentDto;
    }


}
