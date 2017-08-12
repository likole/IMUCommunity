package cn.likole.IMUCommunity.dao;

import cn.likole.IMUCommunity.entity.Tucao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Tucao> getList(int offset,int limit){
        return this.getHibernateTemplate().execute(new HibernateCallback<List<Tucao>>() {
            @Override
            public List<Tucao> doInHibernate(Session session) throws HibernateException {
                return session.createQuery("from Tucao order by tid desc ").setFirstResult(offset).setMaxResults(limit).list();
            }
        });
    }

    public List<Tucao> getByUid(int uid)
    {
        return (List<Tucao>) getHibernateTemplate().find("from Tucao where uid=?",uid);
    }

    public List<Tucao> getAll(){
       return (List<Tucao>) getHibernateTemplate().find("from Tucao order by tid desc ");
    }

    public Tucao getByTid(int tid){
        List<Tucao> rs= (List<Tucao>) this.getHibernateTemplate().find("from Tucao where tid=?",tid);
        if(rs.size()>0) return rs.get(0);
        return null;
    }

    public void delete(int tid){
        getHibernateTemplate().bulkUpdate("delete from Tucao where tid=?",tid);
    }

    public int getNum(){
        return ((Long)getHibernateTemplate().iterate("select count(*) from Tucao ").next()).intValue();
    }
}
