package com.nachepin.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @auther huwhy
 * @date 2016/4/26.
 */
public class BaseDao<T, PK extends Serializable> extends HibernateDaoSupport {

    protected Class<T> entityClass;

    protected RowMapper<T> rowMapper;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public BaseDao() {
        Type type = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) type).getActualTypeArguments();
        this.entityClass = (Class<T>) params[0];
        this.rowMapper = new MyRowMapper<>(this.entityClass);
    }

    @Autowired
    public void setSessionFactory2(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public T get(PK id) {
        return getHibernateTemplate().get(entityClass, id);
    }

}
