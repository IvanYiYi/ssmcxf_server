package com.xhsmart.ssmcxf.mapper;

import com.xhsmart.ssmcxf.common.PageModel;
import com.xhsmart.ssmcxf.entity.Ik_32;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DeptMapper
 *
 * @author YiPeng
 * @version 1.0
 * @email yipeng@china-xinghan.com
 * @date 2016-3-4 下午2:54:24
 */
@Repository("ikMapper_32")
public interface IkMapper_32 {

    /**
     * ik32
     * @param ik
     */
    @Insert("INSERT INTO `ik32`(`key`)VALUES (#{key})")
    void save_32(Ik_32 ik);

    @Select("SELECT * from ik32")
    List<Ik_32> get_32();

    /**
     * request server
     * @return
     */
    @Select("SELECT * from ik32")
    List<com.xhsmart.ssmcxf.client_ws.Ik> get_ws_32();

    /**
     * 统计查询
     */
    @Select("select count(*) from ik32")
    int count_32();

    /**
     * 分页查询
     */
    @Select("select * from ik32 limit #{startRow}, #{pageSize}")
    List<Ik_32> findByPage_32(PageModel pageModel);

    /**
     * 分页保存
     */
    @Select("select * from ik32 limit #{startRow}, #{pageSize}")
    List<com.xhsmart.ssmcxf.client_ws.Ik> findByPage_ws_32(PageModel pageModel);

    /**
     * delete data
     */
    @Delete("delete from ik32 limit  #{pageSize}")
    void delete_32(PageModel model);

}
