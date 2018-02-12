package com.xjd.web.dao;

import com.xjd.web.po.User;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */
@Repository
public class UserDao {
    @Autowired
    private HibernateTemplate ht;

    public void insert(User user) {
        ht.save(user);
    }

    public List findUser(User user) {
        return ht.findByExample(user);
    }

    public User findUser(String name) {
        String sql = "From User where name=?";
        return (User) ht.find(sql, name).get(0);
    }

    public List<User> find() {
        return ht.find("from User order by  id desc");
    }
    public void addUser(User user){
        ht.save(user);
    }
    public void insertUser(
    ) {

        synchronized (this) {
            User user = new User();
            user.setName("xjd" + this.find().get(0).getId());
            user.setPassword("321" + System.currentTimeMillis());
            ht.save(user);
        }


    }

    public List<Object[]> findUser() {
     final String sql="select user_1.name,user_2.name,user_1.id from user user_1,user user_2 where  user_1.id<198 and user_2.id=user_1.id";
      return   ht.execute(new HibernateCallback<List<Object[]>>() {
            /**
             * Gets called by {@code HibernateTemplate.execute} with an active
             * Hibernate {@code Session}. Does not need to care about activating
             * or closing the {@code Session}, or handling transactions.
             * <p/>
             * <p>If called without a thread-bound Hibernate transaction (initiated
             * by HibernateTransactionManager), the code will simply get executed on the
             * underlying JDBC connection with its transactional semantics. If Hibernate
             * is configured to use a JTA-aware DataSource, the JDBC connection and thus
             * the callback code will be transactional if a JTA transaction is active.
             * <p/>
             * <p>Allows for returning a result object created within the callback,
             * i.e. a domain object or a collection of domain objects.
             * A thrown custom RuntimeException is treated as an application exception:
             * It gets propagated to the caller of the template.
             *
             * @param session active Hibernate session
             * @return a result object, or {@code null} if none
             * @throws HibernateException if thrown by the Hibernate API
             * @throws SQLException       if thrown by Hibernate-exposed JDBC API
             * @see HibernateTemplate#execute
             * @see HibernateTemplate#executeFind
             */
            public List<Object[]> doInHibernate(Session session) throws HibernateException, SQLException {
               SQLQuery q= session.createSQLQuery(sql);
                return q.list();
            }
        });

    }
}
