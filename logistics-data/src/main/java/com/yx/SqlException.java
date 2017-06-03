package com.yx;

import com.yx.common.code.Code;
import com.yx.common.exception.AbstractException;

/**
 * author : Guo LiXiao
 * date : 2017-5-31  11:37
 */

public class SqlException extends AbstractException {

    public SqlException() {
        super();
    }

    public SqlException(String message) {
        super(message);
    }

    public SqlException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlException(Throwable cause) {
        super(cause);
    }

    protected SqlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public SqlException(Code code) {
        super(code);
    }

}
