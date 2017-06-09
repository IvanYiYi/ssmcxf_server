package com.xhsmart.ssmcxf.mapper_16;

import com.xhsmart.ssmcxf.common.PageModel;
import com.xhsmart.ssmcxf.entity_16.Ik_16;
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
@Repository("ikMapper_16")
public interface IkMapper_16 {
    /**
     * ik16
     * @param ik
     */
    @Insert("INSERT INTO `ik16`(`key`)VALUES (#{key})")
    void save_16(Ik_16 ik);

    @Select("SELECT * from ik16")
    List<Ik_16> get_16();

    /**
     * request server
     * @return
     */
    @Select("SELECT * from ik16")
    List<com.xhsmart.ssmcxf.client_ws.Ik> get_ws_16();

    /**
     * 统计查询
     */
    @Select("select count(*) from ik16")
    int count_16();

    /**
     * 分页查询
     */
    @Select("select * from ik16 limit #{startRow}, #{pageSize}")
    List<Ik_16> findByPage_16(PageModel pageModel);

    /**
     * 分页保存
     */
    @Select("select * from ik16 limit #{startRow}, #{pageSize}")
    List<com.xhsmart.ssmcxf.client_ws.Ik> findByPage_ws_16(PageModel pageModel);

    /**
     * delete data
     */
    @Delete("delete from ik16 limit  #{pageSize}")
    void delete_16(PageModel model);








}
