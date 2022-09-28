package com.reggie.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author caishihao9
 * 通用返回结果，服务端响应的数据最后都会封装成此对象
 */
@Data
@ApiModel("返回结果")
public class R<T> implements Serializable {

    @ApiModelProperty("编码")
    //编码：1成功，0和其它数字为失败
    private Integer code;

    @ApiModelProperty("错误信息")
    //错误信息
    private String msg;

    @ApiModelProperty("数据")
    //数据
    private T data;

    @ApiModelProperty("动态数据")
    //动态数据
    private Map map = new HashMap();

    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
