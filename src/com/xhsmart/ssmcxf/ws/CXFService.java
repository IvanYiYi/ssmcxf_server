package com.xhsmart.ssmcxf.ws;

import com.xhsmart.ssmcxf.common.PageModel;
import com.xhsmart.ssmcxf.entity.Ik;

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
     * 保存方法
     *
     * @param ik
     * @return
     */
    public String saveIk(Ik ik);

    /**
     * get all
     *
     * @return list collection
     */
    public List<Ik> get();

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
    public List<Ik> getByPage(PageModel model);

    /**
     * split entity
     * @return
     */
    public PageModel getPageModel();


    /**
     * delete date
     */
    public void delete(PageModel model);

}
