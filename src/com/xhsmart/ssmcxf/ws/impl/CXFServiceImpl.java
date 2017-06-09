package com.xhsmart.ssmcxf.ws.impl;

import com.xhsmart.ssmcxf.common.PageModel;
import com.xhsmart.ssmcxf.entity.Ik;
import com.xhsmart.ssmcxf.service.IkService;
import com.xhsmart.ssmcxf.ws.CXFService;

import javax.jws.WebService;
import java.util.List;

/**
 * CXFServiceImpl
 *
 * @author YiPeng
 * @version 1.0
 * @email yipeng@china-xinghan.com
 * @date 2016-3-4 下午3:16:43
 */
@WebService(endpointInterface = "com.xhsmart.ssmcxf.ws.CXFService", serviceName = "itService")
public class CXFServiceImpl implements CXFService {
    /**
     * 注入业务层对象
     */
    private IkService ikService;


    /**
     * Spring的setter注入
     */
    public void setIkService(IkService ikService) {
        this.ikService = ikService;
    }

    /**
     * 保存方法
     *
     * @param ik
     * @return
     */
    public String saveIk(Ik ik) {
        try {
            ikService.saveDept(ik);
        } catch (Exception ex) {
            return "添加失败！";
        }
        return "添加成功！";
    }

    /**
     * get method
     */
    public List<Ik> get() {
        return ikService.get();
    }

    /**
     * save depts
     */
    public void saveIks() {
        ikService.saveIks();
    }

    @Override
    public List<Ik> getByPage(PageModel model) {
        return ikService.getByPage(model);
    }

    @Override
    public PageModel getPageModel() {
        return ikService.getPageModel();
    }

    /**
     * delete date
     */
    @Override
    public void delete(PageModel model) {
        ikService.delete(model);
    }


}