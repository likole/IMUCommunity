package cn.likole.IMUCommunity.dao;

import cn.likole.IMUCommunity.entity.Answer;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by likole on 7/27/17.
 */
@Repository
public class AnswerDao extends HibernateDaoSupport{

    AnswerDao(SessionFactory sessionFactory){
        setSessionFactory(sessionFactory);
    }

    public void add(Answer answer){
        getHibernateTemplate().save(answer);
    }

    public void delete(int ansid){
        getHibernateTemplate().bulkUpdate("delete from Answer where ansid =?",ansid);
    }

    public List<Answer> getByAid(int aid){
        return (List<Answer>) getHibernateTemplate().find("from Answer where aid=?",aid);
    }

    public Answer getByAnsid(int ansid){
        List<Answer> answers= (List<Answer>) getHibernateTemplate().find("from Answer where ansid=?",ansid);
        if(answers.size()>0) return answers.get(0);
        return null;
    }
}
