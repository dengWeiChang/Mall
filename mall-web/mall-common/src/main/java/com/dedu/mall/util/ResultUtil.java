package com.dedu.mall.util;

import com.dedu.mall.model.Result;
import com.dedu.mall.model.ResultCode;

import java.util.Objects;

public class ResultUtil {
    public static <T> T getResultData(Result<T> result) {
        if (null != result && Objects.equals(result.getCode(), ResultCode.SUCCESS.getCode())) {
            return result.getData();
        }
        return null;
    }
}
