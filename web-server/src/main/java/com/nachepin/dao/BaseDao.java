package com.nachepin.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.nachepin.api.dto.PageList;
import com.nachepin.api.dto.PageParam;

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


    public PageList<T> paginate(String sql, PageParam pageParam, Object... paras) {
        Long totalRow = jdbcTemplate.queryForObject(getCountSQL(sql), Long.class, paras);
        int perSize = pageParam.getPerSize();
        int curNo = pageParam.getCurNo();
        if(totalRow == null) {
            return PageList.EMPTY;
        }

        List list = jdbcTemplate.query(sql + pageParam.buildSQL(), rowMapper, paras);
        return new PageList(list, totalRow, perSize, curNo);
    }

    public static String getCountSQL(String sql) {
        String temp = sql.toLowerCase();
        int selectIndex = temp.indexOf("select ");
        int fromIndex = sql.toLowerCase().indexOf("from ");

        for(int index = temp.indexOf("select ", selectIndex + 7); index != -1 && index < fromIndex; index = temp.indexOf("select ", index + 7)) {
            fromIndex = temp.indexOf("from ", fromIndex + 5);
        }

        int orderIndex = sql.lastIndexOf("order by");
        return orderIndex != -1?"select count(1) " + sql.substring(fromIndex, orderIndex):"select count(1) " + sql.substring(fromIndex);
    }

}
