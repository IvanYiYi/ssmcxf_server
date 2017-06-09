package com.xhsmart.ssmcxf.ws;

import com.xhsmart.ssmcxf.common.PageModel;

import javax.jws.WebService;
import java.util.List;

/**
 * CXFService
 *
 * @author YiPeng
 * @version 1.0
 * @email yipeng@china-xinghan.com
 * @date 2016-3-4 下午3:16:21
 */
@WebService
public interface CXFService {
    /**
     * save
     *
     * @param ik
     * @return
     */
    public <T>String saveIk(T ik);

    /**
     * get all
     *
     * @return list collection
     */
    public List<?> get();

    /**
     * save dept
     */
    public void saveIks();

    /**
     * split select
     *
     * @param model
     * @return
     */
    public List<?> getByPage(PageModel model);

    /**
     * split entity
     * @return
     */
    public PageModel getPageModel();


    /**
     * delete date
     */
    public void delete(PageModel model);

    /**
     * get count
     */
    public int count();

}
