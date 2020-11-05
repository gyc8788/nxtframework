package com.newxton.nxtframework.service;

import com.newxton.nxtframework.entity.NxtDeliveryConfigItemRegion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (NxtDeliveryConfigItemRegion)表服务接口
 *
 * @author makejava
 * @since 2020-11-02 19:03:31
 */
public interface NxtDeliveryConfigItemRegionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    NxtDeliveryConfigItemRegion queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<NxtDeliveryConfigItemRegion> queryAllByLimit(int offset, int limit);

    /**
     * 根据idList查询多条记录
     *
     * @return 对象列表
     */
    List<NxtDeliveryConfigItemRegion> selectByConfigItemIdSet(@Param("idList") List<Long> idList);

    /**
     * 通过实体作为筛选条件查询Count
     *
     * @param nxtDeliveryConfigItemRegion 实例对象
     * @return 对象列表
     */
    Long queryCount(NxtDeliveryConfigItemRegion nxtDeliveryConfigItemRegion);

    /**
     * 新增数据
     *
     * @param nxtDeliveryConfigItemRegion 实例对象
     * @return 实例对象
     */
    NxtDeliveryConfigItemRegion insert(NxtDeliveryConfigItemRegion nxtDeliveryConfigItemRegion);

    /**
     * 修改数据
     *
     * @param nxtDeliveryConfigItemRegion 实例对象
     * @return 实例对象
     */
    NxtDeliveryConfigItemRegion update(NxtDeliveryConfigItemRegion nxtDeliveryConfigItemRegion);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 删除指定多个类型数据
     * @return 对象列表
     */
    void deleteByConfigItemIdSet(@Param("idList") List<Long> idList);

    /**
     * 删除指定多个类型数据
     * @return 对象列表
     */
    int deleteByIdSet(@Param("idList") List<Long> idList);

}