package cn.likole.IMUCommunity.service;

import cn.likole.IMUCommunity.dao.NotificationDao;
import cn.likole.IMUCommunity.dao.OfficialAccountDao;
import cn.likole.IMUCommunity.dto.NotificationDto;
import cn.likole.IMUCommunity.entity.Notification;
import cn.likole.IMUCommunity.util.TimeFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by likole on 7/27/17.
 */
@Service
@Repository
public class NotificationService {

    @Autowired
    NotificationDao notificationDao;
    @Autowired
    OfficialAccountDao officialAccountDao;

    /**
     * 获取列表
     * @return
     */
    public List<NotificationDto> getList(){
        List<Notification> notifications=notificationDao.getList();
        List<NotificationDto> notificationDtos=new ArrayList<>();

        for (Notification notification:notifications){
            NotificationDto notificationDto=new NotificationDto();
            notificationDto.setOid(notification.getOid());
            notificationDto.setNid(notification.getNid());
            notificationDto.setContent(notification.getContent());
            notificationDto.setName(officialAccountDao.get(notification.getOid()).getName());
            notificationDto.setTime(TimeFormatUtil.formatTime(notification.getTime()));
            notificationDto.setImportant(notification.getImportant());
            notificationDto.setStick(notification.getStick());

            notificationDtos.add(notificationDto);
        }

        return notificationDtos;
    }

    /**
     * 获取自己的全部通知
     * @return
     */
    public List<NotificationDto> getByOid(int oid){
        List<Notification> notifications=notificationDao.getByOid(oid);
        List<NotificationDto> notificationDtos=new ArrayList<>();

        for (Notification notification:notifications){
            NotificationDto notificationDto=new NotificationDto();
            notificationDto.setOid(notification.getOid());
            notificationDto.setNid(notification.getNid());
            notificationDto.setContent(notification.getContent());
            notificationDto.setName(officialAccountDao.get(notification.getOid()).getName());
            notificationDto.setTime(TimeFormatUtil.formatTime(notification.getTime()));
            notificationDto.setImportant(notification.getImportant());
            notificationDto.setStick(notification.getStick());

            notificationDtos.add(notificationDto);
        }

        return notificationDtos;
    }
}
