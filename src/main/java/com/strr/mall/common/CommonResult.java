package com.strr.mall.common;

public class CommonResult {
    /**
     * 状态
     */
    private boolean success;

    /**
     * 数据
     */
    private Object data;

    /**
     * 信息
     */
    private String message;

    public static final CommonResult SUCCESS = new CommonResult(true);
    public static final CommonResult FAILURE = new CommonResult(false);

    public CommonResult() { }

    private CommonResult(boolean success) {
        this.success = success;
    }

    public CommonResult withData(Object data) {
        this.success = true;
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
