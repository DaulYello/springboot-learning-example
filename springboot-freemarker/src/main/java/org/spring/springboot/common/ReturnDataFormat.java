package org.spring.springboot.common;

import java.io.Serializable;

public class ReturnDataFormat<T> implements Serializable {

    //业务状态, 正常1，异常0
    private Long status;
    //error_code 状态值：200 极为成功，其他数值代表失败
    private Long code;
    //error_msg 错误信息，若status为200时，为success
    private String msg;

    //content 返回体报文的出参，使用泛型兼容不同的类型
    private T data;

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
