package com.xhsmart.ssmcxf.service.impl;

import com.xhsmart.ssmcxf.common.PageModel;
import com.xhsmart.ssmcxf.entity_16.Ik_16;
import com.xhsmart.ssmcxf.mapper_16.IkMapper_16;
import com.xhsmart.ssmcxf.service.IkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * IkServiceImpl_16
 *
 * @author YiPeng
 * @version 1.0
 * @email yipeng@china-xinghan.com
 * @date 2016-3-4 下午2:58:07
 */
@Service("ikService_16")
@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
public class IkServiceImpl_16 implements IkService {
    /**
     * 注入数据访问对象
     */
    @Resource(name = "ikMapper_16")
    private IkMapper_16 ikMapper16;

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
        ikMapper16.delete_16(model);
    }

    /**
     * add ik
     *
     * @param ik
     */
    @Override
    public <T>void saveIk(T ik) {
        ikMapper16.save_16((Ik_16) ik);
    }

    /**
     * get
     * @return Ik_16 collection
     */
    @Override
    public List<Ik_16> get() {
        return ikMapper16.get_16();
    }

    /**
     * save iks
     */
    @Override
    public void saveIks() {
        try {
            /** 统计查询 */
            int recordCount = ikMapper16.count_16();
            if (recordCount == 0) {
                cxfService.saveIks(new ArrayList<com.xhsmart.ssmcxf.client_ws.Ik>());
            }
            /** 设置总记录条数 */
            model.setRecordCount(recordCount);
            cxfService.saveIks(ikMapper16.findByPage_ws_16(model));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("分页查询公告时出现了异常！", ex);
        }
    }

    /**
     * get count
     * @return count
     */
    @Override
    public int count() {
        return ikMapper16.count_16();
    }

    /**
     *
     * @param  model pageModel instance
     * @return Ik_16 collection
     */
    @Override
    public List<Ik_16> getByPage(PageModel model) {
        try {
            /** 统计查询 */
            int recordCount = ikMapper16.count_16();
            if (recordCount == 0) {
                return new ArrayList<Ik_16>();
            }
            /** 设置总记录条数 */
            model.setRecordCount(recordCount);
            this.model = model;
            return ikMapper16.findByPage_16(model);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("分页查询公告时出现了异常！", ex);
        }
    }

    /**
     *
     * @return PageModel
     */
    @Override
    public PageModel getPageModel() {
        if (model == null) {
            PageModel pageModel = new PageModel();
            pageModel.setRecordCount(ikMapper16.count_16());
            return pageModel;
        }
        return model;
    }
}
