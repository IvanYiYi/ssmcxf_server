package com.xhsmart.ssmcxf.service.impl;

import com.xhsmart.ssmcxf.common.PageModel;
import com.xhsmart.ssmcxf.entity_8.Ik_8;
import com.xhsmart.ssmcxf.mapper_8.IkMapper_8;
import com.xhsmart.ssmcxf.service.IkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * IkServiceImpl_8
 *
 * @author YiPeng
 * @version 1.0
 * @email yipeng@china-xinghan.com
 * @date 2016-3-4 下午2:58:07
 */
@Service(value = "ikService_8")
@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
public class IkServiceImpl_8 implements IkService {
    /**
     * 注入数据访问对象
     */
    @Resource(name = "ikMapper_8")
    private IkMapper_8 ikMapper;

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
        ikMapper.delete_8(model);
    }

    /**
     * add ik
     * @param ik
     */
    @Override
    public <T>void saveIk(T ik) {
        ikMapper.save_8((Ik_8) ik);
    }

    /**
     * @return ik collection
     */
    @Override
    public List<Ik_8> get() {
        return ikMapper.get_8();
    }

    /**
     * saveIk
     */
    @Override
    public void saveIks() {
        try {
            /** 统计查询 */
            int recordCount = ikMapper.count_8();
            if (recordCount == 0) {
                cxfService.saveIks(new ArrayList<com.xhsmart.ssmcxf.client_ws.Ik>());
            }
            /** 设置总记录条数 */
            model.setRecordCount(recordCount);
            cxfService.saveIks(ikMapper.findByPage_ws_8(model));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("分页查询公告时出现了异常！", ex);
        }
    }

    /**
     *
     * @return ik count
     */
    @Override
    public int count() {
        return ikMapper.count_8();
    }

    /**
     *
     * @param  model pageModel instance
     * @return ik collection
     */
    @Override
    public List<Ik_8> getByPage(PageModel model) {
        try {
            /** 统计查询 */
            int recordCount = ikMapper.count_8();
            if (recordCount == 0) {
                return new ArrayList<Ik_8>();
            }
            /** 设置总记录条数 */
            model.setRecordCount(recordCount);
            this.model = model;
            return ikMapper.findByPage_8(model);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("分页查询公告时出现了异常！", ex);
        }
    }

    /**
     *
     * @return pageModel
     */
    @Override
    public PageModel getPageModel() {
        if (model == null) {
            PageModel pageModel = new PageModel();
            pageModel.setRecordCount(ikMapper.count_8());
            return pageModel;
        }
        return model;
    }
}
