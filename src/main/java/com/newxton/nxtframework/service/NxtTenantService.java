package com.newxton.nxtframework.service;

import com.newxton.nxtframework.entity.NxtTenant;
import java.util.List;

/**
 * (NxtTenant)表服务接口
 *
 * @author makejava
 * @since 2020-12-24 13:13:19
 */
public interface NxtTenantService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    NxtTenant queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<NxtTenant> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param nxtTenant 实例对象
     * @return 实例对象
     */
    NxtTenant insert(NxtTenant nxtTenant);

    /**
     * 修改数据
     *
     * @param nxtTenant 实例对象
     * @return 实例对象
     */
    NxtTenant update(NxtTenant nxtTenant);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}