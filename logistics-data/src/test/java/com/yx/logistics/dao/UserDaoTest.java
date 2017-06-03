package com.yx.logistics.dao;

import com.yx.logistics.AbstractTest;
import com.yx.logistics.data.user.dao.UserDao;
import com.yx.logistics.data.user.domain.UserDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * author : Guo LiXiao
 * date : 2017-5-27  16:59
 */

public class UserDaoTest extends AbstractTest {

    @Autowired
    UserDao userDao;

    @Test
    public void getTest(){

        UserDO userDO = userDao.get(1);
        log.info("userDO : {}", userDO);
    }
}
