package cn.likole.IMUCommunity.dao;

import cn.likole.IMUCommunity.entity.Comments;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by likole on 7/25/17.
 */
@Repository
public class CommentsDao extends HibernateDaoSupport{

    CommentsDao(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }

    public List<String> getByTid(int tid){
        return (List<String>) getHibernateTemplate().find("select content from Comments where tid=?",tid);
    }

    public void save(Comments comments){
        getHibernateTemplate().save(comments);
    }
}
