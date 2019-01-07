package com.swaggerranger.my.shop.web.admin.dao;

import com.swaggerranger.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbContentDao {

    /**
     * @return
     * @throws
     * @Description 获取全部信息
     * @Param
     */
    List<TbContent> selectAll();

    /**
     * @Description 新增
     * @Param
     * @return
     * @exception
     */
    void insert( TbContent tbContent );

    /**
     * @Description 根据id删除
     * @Param
     * @return
     * @exception
     */
    void delete( Long id );

    /**
     * @Description 根据id获取单个信息
     * @Param
     * @return
     * @exception
     */
    TbContent getById( long id );

    /**
     * @Description 更新
     * @Param
     * @return
     * @exception
     */
    void update( TbContent tbContent );

    /**
     * @Description 批量删除
     * @Param       String[] ids
     * @return      void
     */
    void deleteMulti( String[] ids );

    /**
     * @return      List<TbUser>
     * @throws
     * @Description 分页查询
     * @Param params:需要两个参数：数据开始位置start和每页数据条数length
     */
    List<TbContent> page( Map<String, Object> params );

    /**
     * @Description 查询数据库总数据数量
     * @Param
     * @return
     * @exception
     */
    int count( TbContent tbContent );
}
