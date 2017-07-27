package cn.likole.IMUCommunity.dao;

import cn.likole.IMUCommunity.entity.Notification;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by likole on 7/27/17.
 */
@Repository
public class NotificationDao extends HibernateDaoSupport{

    NotificationDao(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }

    public List<Notification> getList(){
        return
                (List<Notification>) getHibernateTemplate().find("from Notification order by stick desc,time desc ");
    }

    public List<Notification> getByOid(int oid){
        return
                (List<Notification>) getHibernateTemplate().find("from Notification where oid=? order by stick desc , time desc ",oid);
    }

    public void save(Notification notification){
        getHibernateTemplate().save(notification);
    }
}
