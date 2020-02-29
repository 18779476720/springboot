package com.hzero.chenglutest2.feign;

import com.hzero.chenglutest2.entity.HgylPersonInfo;
import com.hzero.chenglutest2.feign.fallback.TestServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @program: springboot
 * @description: ${description}
 * @author: cheng-lu
 * @create: 2020-02-29 13:39
 */
@FeignClient(name = "cheng-lu", fallback = TestServiceImpl.class)
public interface TestService {

    /**
     * description: testlist
     * date: 2020/2/29 16:14
     *
     * @param hgylPersonInfo
     * @return java.lang.Object
     */

    @PostMapping("/hzero/list")
    public Object testlist(HgylPersonInfo hgylPersonInfo);

    /**
     * description: testLoad
     * date: 2020/2/29 16:14
     *
     * @param id
     * @return java.lang.Object
     */
    @GetMapping("/hzero/load/{id}")
    public Object testLoad(@PathVariable("id") int id);
}
