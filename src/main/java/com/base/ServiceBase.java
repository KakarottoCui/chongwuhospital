package com.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.util.CollectList;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import util.Request;

import java.util.List;

/**
 * 抽象Service基本类实现接口
 * @param <E>
 */
abstract public class ServiceBase<E> {

    /**
     * 虚函数,派生类必须继承
     * @return
     */
    abstract protected Mapper<E> getDao();

    /**
     * 搜索数据
     * @return
     */
    public List<E> select() {
        return getDao().select(null);
    }

    /**
     * 根据实体类搜索数据
     * @param y
     * @return
     */
    public List<E> select(E y) {
        return getDao().select(y);
    }

    /**
     * 根据主键获取实体类
     * @param id
     * @return
     */
    public E find(Object id) {
        return getDao().selectByPrimaryKey(id);
    }

    /**
     * 根据实体类获取实体类
     * @param id
     * @return
     */
    public E findEntity(E id)
    {
        return getDao().selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<E> selectPage(E obj, int page, int pageSize) {
        //int count = dao.selectCount(obj);

        PageHelper.startPage(page , pageSize , true);
        List<E> list = select(obj);
        PageInfo<E> pageInfo = new PageInfo<E>(list);
        new CollectList(pageInfo.getTotal() , pageSize , page);
        return list;
    }
    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<E> selectPageExample(Example obj , int page , int pageSize)
    {
        PageHelper.startPage(page , pageSize , true);
        List<E> list = getDao().selectByExample(obj);
        PageInfo<E> pageInfo = new PageInfo<E>(list);
        new CollectList(pageInfo.getTotal() , pageSize , page);
        return list;
    }

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id)
    {
        return getDao().deleteByPrimaryKey(id);
    }

    /**
     * 插入实体类
     * @param y
     * @return
     */
    public int insert(E y) {
        return getDao().insertSelective(y);
    }

    /**
     * 更新实体类
     * @param y
     * @return
     */
    public int update(E y) {
        return getDao().updateByPrimaryKeySelective(y);
    }
}
