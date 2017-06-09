package com.xhsmart.ssmcxf.service;

import com.xhsmart.ssmcxf.common.PageModel;

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
     * add ik
     *
     * @param ik
     */
    <T>void saveIk(T ik);

    /**
     * get data
     * @return Ik_16
     */
    List<?> get();

    /**
     * save ik
     */
    void saveIks();

    /**
     *
     * @param  model pageModel instance
     * @return Ik_16 collection
     */
    List<?> getByPage(PageModel model);

    /**
     * get model
     * @return pageModel
     */
    PageModel getPageModel();

    /**
     * delete data
     */
    void delete(PageModel model);

    /**
     * @return ik count
     */
    int count();
}
