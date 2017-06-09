package com.xhsmart.ssmcxf.mapper_8;

import com.xhsmart.ssmcxf.common.PageModel;
import com.xhsmart.ssmcxf.entity_8.Ik_8;
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
@Repository("ikMapper_8")
public interface IkMapper_8 {

    /**
     * ik8
     * @param ik
     */
    @Insert("INSERT INTO `ik8`(`key`)VALUES (#{key})")
    void save_8(Ik_8 ik);

    @Select("SELECT * from ik8")
    List<Ik_8> get_8();

    /**
     * 统计查询
     */
    @Select("select count(*) from ik8")
    int count_8();

    /**
     * request server
     * @return
     */
    @Select("SELECT * from ik8")
    List<com.xhsmart.ssmcxf.client_ws.Ik> get_ws_8();

    /**
     * 分页查询
     */
    @Select("select * from ik8 limit #{startRow}, #{pageSize}")
    List<Ik_8> findByPage_8(PageModel pageModel);

    /**
     * 分页保存
     */
    @Select("select * from ik8 limit #{startRow}, #{pageSize}")
    List<com.xhsmart.ssmcxf.client_ws.Ik> findByPage_ws_8(PageModel pageModel);

    /**
     * delete data
     */
    @Delete("delete from ik8 limit  #{pageSize}")
    void delete_8(PageModel model);


}
