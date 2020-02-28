package com.hzero.chenglu.service;

import com.hzero.chenglu.entity.HgylPersonInfo;
import com.hzero.chenglu.unit.ReturnT;

import java.util.List;
import java.util.Map;

public interface HgylPersonInfoService {
    /**
     * 新增
     */
    public ReturnT insert(HgylPersonInfo hgylPersonInfo);

    /**
     * 删除
     */
    public ReturnT<String> delete(int id);

    /**
     * 更新
     */
    public ReturnT update(HgylPersonInfo hgylPersonInfo);

    /**
     * Load查询
     */
    public ReturnT load(int id);

    public ReturnT list(HgylPersonInfo HgylPersonInfo);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);
    /**
     * 批量插入
     */
    public ReturnT batchInsert(List<HgylPersonInfo> hgylPersonInfos);
}
