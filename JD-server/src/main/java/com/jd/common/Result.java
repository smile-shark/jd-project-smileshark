package com.jd.common;

import lombok.Data;

@Data
public class Result {
    private Boolean success;
    private Integer code;
    private String msg;
    private Object data;

    public Result setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }

    public static Result success(){
        Result result = new Result();
        return result.setSuccess(true)
                .setCode(200)
                .setMsg("操作成功");
    }
    public static Result success(Object data){
        Result result = new Result();
        return result.setSuccess(true)
                .setCode(200)
                .setMsg("操作成功")
                .setData(data);
    }
    public static Result error(){
        Result result = new Result();
        return result.setSuccess(false)
                .setCode(500)
                .setMsg("操作失败");
    }
}
