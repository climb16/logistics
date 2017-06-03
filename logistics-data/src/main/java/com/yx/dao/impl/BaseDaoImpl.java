package com.yx.dao.impl;

import com.yx.dao.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;


/**
 *
 * @param <T>
 */
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements
        BaseDao<T> {

    private String mapperNameSpace;

    public BaseDaoImpl(){
        mapperNameSpace =  this.getClass().getInterfaces()[0].getName();
        mapperNameSpace = mapperNameSpace.replaceAll("dao", "mapper");
        mapperNameSpace = mapperNameSpace.replaceAll("Dao", "Mapper");
    }

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public Long getCount() {
        return getCount("count", null);
    }

    @Override
    public Long getCount(Serializable sqlId, Object obj) {
        return getSqlSession().selectOne(mapperNameSpace + "." + sqlId, obj);
    }

    @Override
    public List<T> find() {
        return find("find", null);
    }

    @Override
    public List<T> find(Serializable sqlId, Object obj) {
        return getSqlSession().selectList(mapperNameSpace + "." + sqlId, obj);
    }

    @Override
    public T get(Serializable id) {
        return get("get", null);
    }

    @Override
    public T get(Serializable sqlId, Object obj) {
        return getSqlSession().selectOne(mapperNameSpace + "." + sqlId, obj);
    }

    @Override
    public Long insert(T entity) {
        return insert("insert", null);
    }

    @Override
    public Long insert(Serializable sqlId, T entity) {
        return (long)getSqlSession().insert(mapperNameSpace + "." + sqlId, entity);
    }

    @Override
    public Long insertBatch(List<T> entities) {
        return insertBatch("insertBatch", null);
    }

    @Override
    public Long insertBatch(Serializable sqlId, List<T> entities) {
        return (long)getSqlSession().insert(mapperNameSpace + "." + sqlId, entities);
    }

    @Override
    public Long update(T entity) {
        return update("update", null);
    }

    @Override
    public Long update(Serializable sqlId, Object obj) {
        return (long)getSqlSession().update(mapperNameSpace + "." + sqlId, obj);
    }

    @Override
    public Long updateBatch(List<Object> objs) {
        return updateBatch("updateBatch", objs);
    }

    @Override
    public Long updateBatch(Serializable sqlId, List<Object> objs) {
        return (long)getSqlSession().update(mapperNameSpace + "." + sqlId, objs);
    }

    @Override
    public Long delete(Serializable id) {
        return delete("delete", id);
    }

    @Override
    public Long delete(Serializable sqlId, Object obj) {
        return (long)getSqlSession().delete(mapperNameSpace + "." + sqlId, obj);
    }

    @Override
    public Long deleteBatch(List<Object> objs) {
        return deleteBatch("deleteBatch", objs);
    }

    @Override
    public Long deleteBatch(Serializable sqlId, List<Object> objs) {
        return (long)getSqlSession().delete(mapperNameSpace + "." + sqlId, objs);
    }
}
