package com.dedu.mall.model;

public enum ResultCode {
    FAILED("-1", "操作失败"),
    SUCCESS("0", "操作成功"),
    NO_DATA("1", "没有数据"),
    SYS_ERROR("2", "系统异常"),
    RESUBMIT("100", "重复提交"),
    PARAMS_ERROR("101", "请求参数错误");

    private String code;
    private String desc;

    ResultCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
