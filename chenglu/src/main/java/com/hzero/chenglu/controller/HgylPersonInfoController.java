package com.hzero.chenglu.controller;

import cn.hutool.crypto.SecureUtil;
import com.hzero.chenglu.entity.HgylPersonInfo;
import com.hzero.chenglu.service.HgylPersonInfoService;
import com.hzero.chenglu.unit.ReturnT;
import com.hzero.chenglu.unit.excel.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * hgyl_person_info
 *
 * @author CHENG-LU 2020-02-22
 */
@RestController
@RequestMapping("/hzero")
@CrossOrigin
public class HgylPersonInfoController {

    @Autowired
    private HgylPersonInfoService hgylPersonInfoService;

    /**
     * 新增
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ReturnT insert(@RequestBody HgylPersonInfo hgylPersonInfo) {
        return hgylPersonInfoService.insert(hgylPersonInfo);
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ReturnT<String> delete(@PathVariable("id") Integer id) {
        System.out.println("id="+id);
        return hgylPersonInfoService.delete(id);
    }

    /**
     * 更新
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ReturnT<String> update(HgylPersonInfo hgylPersonInfo) {
        return hgylPersonInfoService.update(hgylPersonInfo);
    }

    /**
     * Load查询
     */

    @RequestMapping(value = "/load/{id}",method = RequestMethod.GET)
    public ReturnT load(@PathVariable("id") int id) {
        System.out.println("asdfadsf");
        return hgylPersonInfoService.load(id);
    }

    /**
     * 批量查询
     *
     * @param hgylPersonInfo
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ReturnT list(@RequestBody(required = false) HgylPersonInfo hgylPersonInfo) {
        System.out.println("asdfadsf");
        return hgylPersonInfoService.list(hgylPersonInfo);
    }

    @PostMapping(value = "/upload")
    public ReturnT<Integer> batchInsert(@RequestParam("file") MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        if (excelFile == null) {
            return ReturnT.build("00005", "文件不能为空");
        }
        String name = excelFile.getOriginalFilename();
        if (name.length() < 6 || !".xlsx".equals(name.substring(name.length() - 5))) {
            return ReturnT.build("00002", "文件格式错误");
        }
        //TODO 业务逻辑，通过excelFile.getInputStream()，处理Excel文件
        List<HgylPersonInfo> list = ExcelUtils.excelToShopIdList(excelFile.getInputStream());
        //循环调用插入过程
//        list.forEach(e -> {
//            System.out.println("list:"+e.getJobNum());
//            hgylPersonInfoService.insert(e);
//        });
        //批量插入过程在mapper.xml文件里面实现
        String a = SecureUtil.md5(String.valueOf(list.get(0).getId()));
        return hgylPersonInfoService.batchInsert(list);

    }


    /**
     * 分页查询
     */
    @RequestMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return hgylPersonInfoService.pageList(offset, pagesize);
    }

}
