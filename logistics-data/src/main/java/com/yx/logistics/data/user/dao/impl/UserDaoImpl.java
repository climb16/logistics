package com.yx.logistics.data.user.dao.impl;

import com.yx.dao.impl.BaseDaoImpl;
import com.yx.logistics.data.user.dao.UserDao;
import com.yx.logistics.data.user.domain.UserDO;
import org.springframework.stereotype.Repository;

/**
 * author : Guo LiXiao
 * date : 2017-5-27  16:40
 */

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserDO> implements UserDao {


    @Override
    public UserDO get(Integer userId) {

        return super.get(userId);
    }
}
