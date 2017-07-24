package cn.likole.IMUCommunity.dao;

import cn.likole.IMUCommunity.entity.Tucao;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by likole on 7/24/17.
 */
@Repository
public class TucaoDao extends HibernateDaoSupport{

    TucaoDao(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }

    public void add(Tucao tucao)
    {
        this.getHibernateTemplate().save(tucao);
    }
}
