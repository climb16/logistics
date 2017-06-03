package com.yx.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @param <T>
 */
public interface BaseDao<T> {


    /**
     * 获取记录数量，默认调用 count
     * @return
     */
    Long getCount();

    /**
     * 获取记录数量
     * @param sqlId
     * @param obj
     * @return
     */
    Long getCount(Serializable sqlId, Object obj);

    /**
     * 查询全部记录 默认调用 find
     * @return
     */
    List<T> find();

    /**
     * 根据条件查询记录
     * @param sqlId
     * @param sqlId
     * @return
     */
    List<T> find(Serializable sqlId, Object obj);

    /**
     * 查询单条记录 默认调用 get
     * @param id
     * @return
     */
    T get(Serializable id);

    /**
     * 查询单条记录
     * @param sqlId
     * @param obj
     * @return
     */
    T get(Serializable sqlId, Object obj);


    /**
     * 插入 默认调用 insert
     * @param entity
     * @return
     */
    Long insert(T entity);

    /**
     * 插入
     * @param sqlId
     * @param entity
     * @return
     */
    Long insert(Serializable sqlId, T entity);

    /**
     * 批量插入 默认调用 insertBatch
     * @param entities
     * @return
     */
    Long insertBatch(List<T> entities);


    /**
     * 批量插入
     * @param sqlId
     * @param entities
     * @return
     */
    Long insertBatch(Serializable sqlId, List<T> entities);


    /**
     * 更新 默认调用 update
     * @param entity
     * @return
     */
    Long update(T entity);

    /**
     * 更新
     * @param sqlId
     * @param obj
     * @return
     */
    Long update(Serializable sqlId, Object obj);

    /**
     * 批量更新 默认调用 updateBatch
     * @param objs
     * @return
     */
    Long updateBatch(List<Object> objs);

    /**
     * 批量更新
     * @param sqlId
     * @param objs
     * @return
     */
    Long updateBatch(Serializable sqlId, List<Object> objs);


    /**
     * 删除 默认调用 delete
     * @param id
     * @return
     */
    Long delete(Serializable id);

    /**
     * 删除
     * @param sqlId
     * @param obj
     * @return
     */
    Long delete(Serializable sqlId, Object obj);

    /**
     * 批量删除 默认调用 deleteBatch
     * @param objs
     * @return
     */
    Long deleteBatch(List<Object> objs);

    /**
     * 批量删除
     * @param sqlId
     * @param objs
     * @return
     */
    Long deleteBatch(Serializable sqlId, List<Object> objs);
}
