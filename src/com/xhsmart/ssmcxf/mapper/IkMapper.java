package com.xhsmart.ssmcxf.mapper;

import com.xhsmart.ssmcxf.common.PageModel;
import com.xhsmart.ssmcxf.entity.Ik;
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
@Repository("ikMapper")
public interface IkMapper {

    @Insert("INSERT INTO `ik`(`key`)VALUES (#{key})")
    void save(Ik ik);

    @Select("SELECT * from ik")
    List<Ik> get();

    @Select("SELECT * from ik")
    List<com.xhsmart.ssmcxf.client_ws.Ik> get_ws();

    /**
     * 统计查询
     */
    @Select("select count(*) from ik")
    int count();

    /**
     * 分页查询
     */
    @Select("select * from ik limit #{startRow}, #{pageSize}")
    List<Ik> findByPage(PageModel pageModel);

    /**
     * 分页保存
     */
    @Select("select * from ik limit #{startRow}, #{pageSize}")
    List<com.xhsmart.ssmcxf.client_ws.Ik> findByPage_add(PageModel pageModel);

    /**
     * delete data
     */
    @Delete("delete from ik limit  #{pageSize}")
    void delete(PageModel model);

}
