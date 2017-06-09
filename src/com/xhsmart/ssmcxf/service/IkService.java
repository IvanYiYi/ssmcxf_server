package com.xhsmart.ssmcxf.service;

import com.xhsmart.ssmcxf.common.PageModel;
import com.xhsmart.ssmcxf.entity.Ik;

import java.util.List;

/**
 * IkService
 *
 * @author YiPeng
 * @version 1.0
 * @email yipeng@china-xinghan.com
 * @date 2017-6-8 下午2:56:49
 */
public interface IkService {
    /**
     * 添加部门
     *
     * @param ik
     */
    void saveDept(Ik ik);

    /**
     * get data
     * @return Ik
     */
    List<Ik> get();

    /**
     * save ik
     */
    void saveIks();

    /**
     *
     * @param  model pageModel instance
     * @return Ik collection
     */
    List<Ik> getByPage(PageModel model);

    /**
     * get model
     * @return pageModel
     */
    PageModel getPageModel();

    /**
     * delete data
     */
    void delete(PageModel model);
}
