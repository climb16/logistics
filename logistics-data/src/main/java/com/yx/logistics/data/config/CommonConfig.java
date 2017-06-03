package com.yx.logistics.data.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * author : Guo LiXiao
 * date : 2017-6-1  13:07
 */

@Configuration
@ComponentScan(basePackages = {"com.yx.logistics.data.*.dao"})
public class CommonConfig {
}
