package com.hzero.chenglu.service.impl;

import com.hzero.chenglu.dao.HgylPersonInfoDao;
import com.hzero.chenglu.entity.HgylPersonInfo;
import com.hzero.chenglu.service.HgylPersonInfoService;
import com.hzero.chenglu.unit.BusinessException;
import com.hzero.chenglu.unit.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@Service
public class HgylPersonInfoServiceImpl implements HgylPersonInfoService {
    @Autowired
    private HgylPersonInfoDao hgylPersonInfoDao;

    /**
     * 新增
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ReturnT insert(HgylPersonInfo hgylPersonInfo) {
        String msg = "";
        String code = "";
        Object datas = null;
        // valid
        if (hgylPersonInfo == null) {
            return ReturnT.build("00001", "数据不能为空");
        }
        System.out.println("dao插入");
        try {
            hgylPersonInfoDao.insert(hgylPersonInfo);
            datas = hgylPersonInfo;
        } catch (DataAccessException e) {
            code = "00001";
            msg = "更新失败";
            datas = e.getCause().toString();
            System.out.println("错误信息：" + e.getCause().toString());
        }
        if (code == "00001") {
            return ReturnT.build(code, msg, datas);

        }
//        return ReturnT.build("00000", "success", datas);
        return ReturnT.buildSuccess(datas);
    }

    /**
     * 批量插入
     */
    @Override
    public ReturnT batchInsert(List<HgylPersonInfo> hgylPersonInfos){
//        hgylPersonInfoDao.batchInsert(hgylPersonInfos);
        return ReturnT.buildSuccess(hgylPersonInfoDao.batchInsert(hgylPersonInfos));
    }

    /**
     * description: delete <br>
     * version: 1.0 <br>
     * date: 2020/2/27 16:27 <br>
     * author: objcat <br>
     *
    [id]
     * @return com.hzero.chenglu.unit.ReturnT<java.lang.String>
     */
    @Override
    public ReturnT<String> delete(int id) {
        int ret = hgylPersonInfoDao.delete(id);
        return ret > 0 ? ReturnT.build("00000", "删除成功") : ReturnT.build("11111", "删除失败");
    }

    /**
     * 更新
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ReturnT update(HgylPersonInfo hgylPersonInfo) {
        String msg = "";
        String code = "";
        String datas = "";
        

        int count = 0;

        try {
            count = hgylPersonInfoDao.update(hgylPersonInfo);
        } catch (Exception e) {
            code = "00001";
            msg = "更新失败";
            datas = BusinessException.class.toString();
            System.out.println(e.getMessage());
        }
        if (count == 0) {
            datas = BusinessException.class.toString();
            return ReturnT.build(code, msg, datas);
        } else {
            return ReturnT.buildSuccess;
        }
    }

    /**
     * Load查询
     */
    @Override
    public ReturnT load(int id) {
        System.out.println("service:" + id);
        return ReturnT.buildSuccess(hgylPersonInfoDao.load(id));
    }

    /**
     * Load查询
     */
    @Override
    public ReturnT list(HgylPersonInfo hgylPersonInfo) {
        return ReturnT.buildSuccess(hgylPersonInfoDao.list(hgylPersonInfo));
    }


    /**
     * 分页查询
     */
    @Override
    public Map<String, Object> pageList(int offset, int pagesize) {

        List<HgylPersonInfo> pageList = hgylPersonInfoDao.pageList(offset, pagesize);
        int totalCount = hgylPersonInfoDao.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();

        return result;
    }
}