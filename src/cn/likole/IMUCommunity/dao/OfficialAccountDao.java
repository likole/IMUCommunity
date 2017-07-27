package cn.likole.IMUCommunity.dao;

import cn.likole.IMUCommunity.entity.OfficialAccount;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by likole on 7/27/17.
 */
@Repository
public class OfficialAccountDao extends HibernateDaoSupport{

    OfficialAccountDao(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }

    public OfficialAccount get(int oid){
        List<OfficialAccount> list=
                (List<OfficialAccount>) getHibernateTemplate().find("from OfficialAccount where oid=?",oid);
        if(list.size()>0) return list.get(0);
        return null;
    }
}
