package com.hzero.chenglu.controller;

import cn.hutool.crypto.SecureUtil;
import com.hzero.chenglu.entity.A;
import com.hzero.chenglu.service.AService;
import com.hzero.chenglu.unit.ReturnT;
import com.hzero.chenglu.unit.excel.AExcelUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * (A)表控制层
 *
 * @author chenglu
 * @since 2020-03-08 16:46:39
 */
@RestController
@RequestMapping("/a")
public class AController {
    /**
     * 服务对象
     */
    @Resource
    private AService aService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne/{id}")
    public A selectOne(@PathVariable("id") Integer id) {
        return this.aService.queryById(id);
    }
    /**
     * 通过实体查询所有相关数据
     *
     * @param a 实例对象
     * @return 多条数据
     */
    @PostMapping("/queryAll")
    public List<A> queryAll(@RequestBody A a) {
        return this.aService.queryAll(a);
    }
    
    /**
     * 新增数据
     *
     * @param a 实例对象
     * @return 对象
     */
    @PostMapping("/insert")
    public A insert(@RequestBody A a) {
        return this.aService.insert(a);
    }
    
    /**
     * 更新数据
     *
     * @param a 实例对象
     * @return 对象
     */
    @PostMapping("/udpate")
    public A update(@RequestBody A a) {
        return this.aService.update(a);
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return boolean
     */
    @PostMapping("/delete/{id}")
    public boolean deleteById(@PathVariable("id") Integer id) {
        return this.aService.deleteById(id);
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
        List<A> list = AExcelUtils.excelToShopIdList(excelFile.getInputStream());
        //循环调用插入过程
//        list.forEach(e -> {
//            System.out.println("list:"+e.getJobNum());
//            hgylPersonInfoService.insert(e);
//        });
        //批量插入过程在mapper.xml文件里面实现
        String a = SecureUtil.md5(String.valueOf(list.get(0).getId()));
        return aService.batchInsert(list);

    }
}