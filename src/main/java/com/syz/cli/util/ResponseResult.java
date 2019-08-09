package com.syz.cli.util;

import com.syz.cli.init.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: byl
 * Date: 2017-04-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResponseResult<T> implements Serializable {

    /**
     * 请求结果标识
     */
	private boolean success;

    /**
     * 请求结果数据体
     */
    private T data;

    /**
     * 请求返回消息
     */
    private String msg;


    /**
     * 静态工厂
     * 没msg的实体
     * @param data
     * @param <T>
     * @return
     */
    public static <T>  ResponseResult<T>  success(T data ){
        return new ResponseResult<T> ().setData(data).setSuccess(true);
    }

    /**
     * 静态工厂
     * @param data
     * @param msg
     * @param <T>
     * @return
     */
    public static <T>  ResponseResult<T>  success(T data ,String msg ){
        return new ResponseResult<T> ().setData(data).setMsg(msg).setSuccess(true);
    }

    /**
     * 静态工厂
     * @param msg
     * @param <T>
     * @return
     */
    public static <T>    ResponseResult<T>   error( String msg ){
        return new ResponseResult<T> ().setSuccess(false).setMsg(msg);
    }
}
