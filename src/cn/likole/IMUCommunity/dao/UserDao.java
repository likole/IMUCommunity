package cn.likole.IMUCommunity.dao;

import cn.likole.IMUCommunity.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by likole on 7/24/17.
 */
@Repository
public class UserDao extends HibernateDaoSupport {

    UserDao(SessionFactory sessionFactory){
       super.setSessionFactory(sessionFactory);
    }

    public User getByToken(String token)
    {
        List<User> list= (List<User>) getHibernateTemplate().find("from User where token=?",token);
        if(list.size()==0) return null;
        return list.get(0);
    }

    public User getByUsername(String name){
        List<User> list= (List<User>) getHibernateTemplate().find("from User where name=?",name);
        if(list.size()==0) return null;
        return list.get(0);
    }

    public User getByUid(int uid){
        List<User> list= (List<User>) getHibernateTemplate().find("from User where uid=?",uid);
        if(list.size()==0) return null;
        return list.get(0);
    }

    public void save(User user)
    {
        this.getHibernateTemplate().save(user);
    }
}
