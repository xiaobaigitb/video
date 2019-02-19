package com.zhiyou.video.vo;

/**
 * @author Mr.lu
 * @Title: ResponseVo
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/18:21:26
 */
public class ResponseVo<T> {
    private Integer code;
    private String message;
    private T data;

    public ResponseVo() {
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseVo(Integer code, String message, T data) {

        this.code = code;
        this.message = message;
        this.data = data;
    }
}
