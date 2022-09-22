package com.reggie.common;

/**
 * @author caishihao
 * @version 2021.1
 * @date 2022/9/16 17:21
 */
public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
