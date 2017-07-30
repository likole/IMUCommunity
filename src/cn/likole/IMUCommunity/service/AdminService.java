package cn.likole.IMUCommunity.service;

import cn.likole.IMUCommunity.dao.CommentsDao;
import cn.likole.IMUCommunity.dao.LikesDao;
import cn.likole.IMUCommunity.dao.TucaoDao;
import cn.likole.IMUCommunity.dao.UserDao;
import cn.likole.IMUCommunity.dto.LikesAdminDto;
import cn.likole.IMUCommunity.dto.TucaoAdminDto;
import cn.likole.IMUCommunity.entity.Likes;
import cn.likole.IMUCommunity.entity.Tucao;
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

    public List<TucaoAdminDto> getTucaoList(){
        //获取所有吐槽
        List<Tucao> tucaos=tucaoDao.getAll();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<TucaoAdminDto>tucaoAdminDtos=new ArrayList<>();
        for(Tucao tucao:tucaos){
            TucaoAdminDto tucaoAdminDto=new TucaoAdminDto();
            //基本数据
            tucaoAdminDto.setComment_num(tucao.getCommentNum());
            tucaoAdminDto.setContent(tucao.getContent());
            tucaoAdminDto.setLike_num(tucao.getLikeNum());
            tucaoAdminDto.setName(userDao.getByUid(tucao.getUid()).getName());
            tucaoAdminDto.setTid(tucao.getTid());
            tucaoAdminDto.setUid(tucao.getUid());
            tucaoAdminDto.setTime(simpleDateFormat.format(tucao.getTime()));
            //喜欢数据
            List<Likes> likesList= likesDao.getAllByTid(tucao.getTid());
            List<LikesAdminDto> likesAdminDtos=new ArrayList<>();
            for(Likes likes:likesList){
                LikesAdminDto likesAdminDto=new LikesAdminDto();
                likesAdminDto.setUid(likes.getUid());
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
}
