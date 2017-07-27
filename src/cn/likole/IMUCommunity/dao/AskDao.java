package cn.likole.IMUCommunity.dao;

import cn.likole.IMUCommunity.entity.Ask;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by likole on 7/27/17.
 */
@Repository
public class AskDao extends HibernateDaoSupport{

    AskDao(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }

    public void save(Ask ask){
        getHibernateTemplate().save(ask);
    }

    public List<Ask> getList(){
        return (List<Ask>) getHibernateTemplate().find("from Ask order by time desc ");
    }

    public List<Ask> getByUid(int uid){
        return (List<Ask>) getHibernateTemplate().find("from Ask where uid=? order by time desc ",uid);
    }

    public void delete(int aid){
        getHibernateTemplate().bulkUpdate("delete from Ask where aid=?",aid);
    }

    public Ask getByAid(int aid){
        List<Ask> list= (List<Ask>) getHibernateTemplate().find("from Ask where aid=?",aid);
        if(list.size()>0) return list.get(0);
        return null;
    }

    public List<Ask> getLike(String key){
        List<Ask> list= (List<Ask>) getHibernateTemplate().find("from Ask where title like ? or detail like  ?",'%'+key+'%','%'+key+'%');
        return list;
    }
}
