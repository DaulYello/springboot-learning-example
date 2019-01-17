package org.spring.springboot.common;


public class ResultUtils {

    /**
     * 请求成功
     * @param o
     * @return
     */
    public static ReturnDataFormat requestSuccess(Object o){
        ReturnDataFormat result = new ReturnDataFormat();
        result.setStatus(1L);
        result.setCode(200L);
        result.setMsg("请求成功");
        result.setData(o);
        return result;
    }

    public static ReturnDataFormat requestSuccess(){
        return requestSuccess(null);
    }

    /**
     * 请求失败
     * @param e
     * @return
     */
    public static ReturnDataFormat requestErro(Exception e){
        ReturnDataFormat result = new ReturnDataFormat();
        result.setStatus(0L);
        result.setCode((long)e.hashCode());
        result.setMsg(e.getMessage());
        result.setData(null);
        return result;
    }
}
