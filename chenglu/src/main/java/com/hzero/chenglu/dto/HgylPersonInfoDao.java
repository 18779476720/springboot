package com.hzero.chenglu.dto;

import com.hzero.chenglu.entity.HgylPersonInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


import javax.persistence.Table;
import java.util.List;

/**
 * hgyl_person_info
 *
 * @author CHENG-LU 2020-02-22
 */
@Mapper
@Component(value = "HgylPersonInfoDao")
@Table(name = "hgyl_person_info")
public interface HgylPersonInfoDao {

    /**
     * 新增
     *
     * @param hgylPersonInfo
     */
    Long insert(HgylPersonInfo hgylPersonInfo);

    /**
     * 删除
     *
     * @param id
     */
    Integer delete(@Param("id") Integer id);

    /**
     * 更新
     *
     * @param
     */
    Integer update(HgylPersonInfo hgylPersonInfo);

    /**
     * 根据主键查询一个实体
     *
     * @param id
     */
    HgylPersonInfo selectByPrimaryKey(@Param("id") Integer id);

    /**
     * 分页查询Data
     *
     * @param offset
     * @param pageSize
     */
    List<HgylPersonInfo> pageList(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

    /**
     * 分页查询Count
     *
     * @param offset
     * @param pagesize
     */
    Integer pageListCount(int offset, int pagesize);

    /**
     * 查询全部
     * @param hgylPersonInfo
     * @return
     */

    List<HgylPersonInfo> list(HgylPersonInfo hgylPersonInfo);

    /**
     * 批量插入
     * @param hgylPersonInfos
     * @return
     */
    int batchInsert(List<HgylPersonInfo> hgylPersonInfos);

    HgylPersonInfo load(int id);
}