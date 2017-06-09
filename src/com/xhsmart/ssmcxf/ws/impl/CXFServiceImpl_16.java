package com.xhsmart.ssmcxf.ws.impl;

import com.xhsmart.ssmcxf.common.PageModel;
import com.xhsmart.ssmcxf.entity_16.Ik_16;
import com.xhsmart.ssmcxf.service.IkService;
import com.xhsmart.ssmcxf.ws.CXFService;

import javax.jws.WebService;
import java.util.List;

/**
 * CXFServiceImpl_16
 *
 * @author YiPeng
 * @version 1.0
 * @email yipeng@china-xinghan.com
 * @date 2016-3-4 下午3:16:43
 */
@WebService(endpointInterface = "com.xhsmart.ssmcxf.ws.CXFService", serviceName = "itService")
public class CXFServiceImpl_16 implements CXFService {
    /**
     * 注入业务层对象
     */
    private IkService ikService_16;


    /**
     * Spring的setter注入
     */
    public void setIkService(IkService ikService) {
        this.ikService_16 = ikService;
    }

    /**
     * 保存方法
     *
     * @param ik
     * @return
     */
    @Override
    public <T>String saveIk(T ik) {
        try {
            ikService_16.saveIk(ik);
        } catch (Exception ex) {
            return "添加失败！";
        }
        return "添加成功！";
    }

    /**
     * get method
     */
    @Override
    public List<Ik_16> get() {
        return (List<Ik_16>)ikService_16.get();
    }

    /**
     * save iks
     */
    @Override
    public void saveIks() {
        ikService_16.saveIks();
    }

    /**
     *
     * @param model
     * @return ik collection
     */
    @Override
    public List<Ik_16> getByPage(PageModel model) {
        return (List<Ik_16>) ikService_16.getByPage(model);
    }

    /**
     *
     * @return pageModel
     */
    @Override
    public PageModel getPageModel() {
        return ikService_16.getPageModel();
    }

    /**
     * get count
     */
    @Override
    public int count() {
        return ikService_16.count();
    }

    /**
     * delete data
     */
    @Override
    public void delete(PageModel model) {
        ikService_16.delete(model);
    }


}