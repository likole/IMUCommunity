package cn.likole.IMUCommunity.dao;

import cn.likole.IMUCommunity.entity.Likes;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by likole on 7/25/17.
 */
@Repository
public class LikesDao extends HibernateDaoSupport {

    LikesDao(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    public boolean exist(int tid,int uid){
        return this.getHibernateTemplate().find("from Likes where tid=? and uid=?",tid,uid).size()!=0;
    }

    public void save(Likes like){
        this.getHibernateTemplate().save(like);
    }

    public List<Likes> getAllByUid(int uid){
        return (List<Likes>) this.getHibernateTemplate().find("from Likes where uid=?",uid);
    }
}
