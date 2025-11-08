package com.xxx.base.exception;

/**
 * 自定义异常： 业务异常
 * 只要Service业务中要手动抛出异常，都可以抛出该异常
 * 和系统自带的运行时异常区分开来
 */
public class BusinessException extends RuntimeException{
    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}