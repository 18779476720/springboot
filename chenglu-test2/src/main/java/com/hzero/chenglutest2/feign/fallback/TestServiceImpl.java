package com.hzero.chenglutest2.feign.fallback;

import com.hzero.chenglutest2.entity.HgylPersonInfo;
import com.hzero.chenglutest2.feign.TestService;
import org.springframework.stereotype.Component;

/**
 * @program: springboot
 * @description: ${description}
 * @author: cheng-lu
 * @create: 2020-02-29 13:48
 */
@Component
public class TestServiceImpl implements TestService {
    private static final Object OBJECT = null;
/**
 * description: testlist
 * date: 2020/2/29 13:52
 *
 * @param hgylPersonInfo
 * @return java.lang.Object
 */
    @Override
    public Object testlist(HgylPersonInfo hgylPersonInfo) {
        return 1;
    }
    @Override
    public Object testLoad(int id) {
        return 1;
    }

    @Override
    public Object obj(Object object) {
        return 1;
    }
}
