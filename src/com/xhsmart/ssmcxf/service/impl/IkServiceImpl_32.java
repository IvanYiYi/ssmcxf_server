package com.xhsmart.ssmcxf.service.impl;

import com.xhsmart.ssmcxf.common.PageModel;
import com.xhsmart.ssmcxf.entity.Ik_32;
import com.xhsmart.ssmcxf.mapper.IkMapper_32;
import com.xhsmart.ssmcxf.service.IkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * IkServiceImpl_32
 *
 * @author YiPeng
 * @version 1.0
 * @email yipeng@china-xinghan.com
 * @date 2016-3-4 下午2:58:07
 */
@Service("ikService_32")
@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
public class IkServiceImpl_32 implements IkService {
    /**
     * 注入数据访问对象
     */
    @Resource(name = "ikMapper_32")
    private IkMapper_32 ikMapper;

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
        ikMapper.delete_32(model);
    }
    /**
     * add ik
     *
     * @param ik
     */
    @Override
    public <T>void saveIk(T ik) {
        ikMapper.save_32((Ik_32)ik);
    }

    /**
     * GET
     * @return
     */
    @Override
    public List<Ik_32> get() {
        return ikMapper.get_32();
    }

    /**
     * save iks
     */
    @Override
    public void saveIks() {
        try {
            /** 统计查询 */
            int recordCount = ikMapper.count_32();
            if (recordCount == 0) {
                cxfService.saveIks(new ArrayList<com.xhsmart.ssmcxf.client_ws.Ik>());
            }
            /** 设置总记录条数 */
            model.setRecordCount(recordCount);
            cxfService.saveIks(ikMapper.findByPage_ws_32(model));
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
        return ikMapper.count_32();
    }

    /**
     *
     * @param  model pageModel instance
     * @return ik collection
     */
    @Override
    public List<Ik_32> getByPage(PageModel model) {
        try {
            /** 统计查询 */
            int recordCount = ikMapper.count_32();
            if (recordCount == 0) {
                return new ArrayList<Ik_32>();
            }
            /** 设置总记录条数 */
            model.setRecordCount(recordCount);
            this.model = model;
            return ikMapper.findByPage_32(model);
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
            pageModel.setRecordCount(ikMapper.count_32());
            return pageModel;
        }
        return model;
    }
}
