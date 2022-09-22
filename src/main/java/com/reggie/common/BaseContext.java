package com.reggie.common;

/**
 * @author caishihao
 * @version 2021.1
 * @date 2022/9/16 13:26
 */
public class BaseContext {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
