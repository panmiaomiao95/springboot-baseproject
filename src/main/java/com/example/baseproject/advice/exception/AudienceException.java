package com.example.baseproject.advice.exception;

import com.example.baseproject.common.enums.ResultEnum;

/**
 * 自定义异常类
 */
public class AudienceException extends RuntimeException {
    private Integer code;
    public AudienceException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}