package com.yx.logistics;

import com.yx.logistics.data.config.CommonConfig;
import com.yx.logistics.data.config.DataSourceConfig;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * author : Guo LiXiao
 * date : 2017-5-27  16:57
 */


@ContextConfiguration(classes = {CommonConfig.class, DataSourceConfig.class})
@ActiveProfiles(value = "${build.env.name}")
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractTest {

    protected Logger log = LoggerFactory.getLogger(this.getClass());
}