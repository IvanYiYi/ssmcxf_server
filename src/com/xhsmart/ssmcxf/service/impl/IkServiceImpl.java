package com.xhsmart.ssmcxf.service.impl;

import com.xhsmart.ssmcxf.common.PageModel;
import com.xhsmart.ssmcxf.entity.Ik;
import com.xhsmart.ssmcxf.mapper.IkMapper;
import com.xhsmart.ssmcxf.service.IkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * IkServiceImpl
 *
 * @author YiPeng
 * @version 1.0
 * @email yipeng@china-xinghan.com
 * @date 2016-3-4 下午2:58:07
 */
@Service("ikService")
@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
public class IkServiceImpl implements IkService {
    /**
     * 注入数据访问对象
     */
    @Resource(name = "ikMapper")
    private IkMapper ikMapper;

    /**
     * 注入WS代理对象
     */
    @Resource(name = "cxfService_client")
    private com.xhsmart.ssmcxf.client_ws.CXFService cxfService;

    private PageModel model;

    /**
     * delete data
     */
    @Override
    public void delete(PageModel model) {
        ikMapper.delete(model);
    }

    /**
     * 添加部门
     *
     * @param ik
     */
    public void saveDept(Ik ik) {
        ikMapper.save(ik);
    }

    public List<Ik> get() {
        return ikMapper.get();
    }

    @Override
    public void saveIks() {
        try {
            /** 统计查询 */
            int recordCount = ikMapper.count();
            if (recordCount == 0) {
                cxfService.saveIks(new ArrayList<com.xhsmart.ssmcxf.client_ws.Ik>());
            }
            /** 设置总记录条数 */
            model.setRecordCount(recordCount);
            cxfService.saveIks(ikMapper.findByPage_add(model));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("分页查询公告时出现了异常！", ex);
        }
    }

    @Override
    public List<Ik> getByPage(PageModel model) {
        try {
            /** 统计查询 */
            int recordCount = ikMapper.count();
            if (recordCount == 0) {
                return new ArrayList<Ik>();
            }
            /** 设置总记录条数 */
            model.setRecordCount(recordCount);
            this.model = model;
            return ikMapper.findByPage(model);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("分页查询公告时出现了异常！", ex);
        }
    }

    @Override
    public PageModel getPageModel() {
        if (model == null) {
            PageModel pageModel = new PageModel();
            pageModel.setRecordCount(ikMapper.count());
            return pageModel;
        }
        return model;
    }
}
