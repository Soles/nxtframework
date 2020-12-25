package com.newxton.nxtframework.dao;

import com.newxton.nxtframework.entity.NxtTenant;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (NxtTenant)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-24 13:13:19
 */
public interface NxtTenantDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    NxtTenant queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<NxtTenant> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param nxtTenant 实例对象
     * @return 对象列表
     */
    List<NxtTenant> queryAll(NxtTenant nxtTenant);

    /**
     * 新增数据
     *
     * @param nxtTenant 实例对象
     * @return 影响行数
     */
    int insert(NxtTenant nxtTenant);

    /**
     * 修改数据
     *
     * @param nxtTenant 实例对象
     * @return 影响行数
     */
    int update(NxtTenant nxtTenant);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}