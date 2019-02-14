package com.wxm.constants;


public enum CommonStatus{

    FAIL(-1, ""),

    SUCCESS(200,"成功"),
    
    PARAM_ERROR(400,"参数异常,请检查"),
    SERVER_ERROR(500,"服务器内部错误");
    
    private int    value;
    private String text; 

    private static final KV<Integer, CommonStatus> lookUp = new KV<Integer, CommonStatus>();

    static {
        for (CommonStatus status : CommonStatus.values()) {
            lookUp.put(status.getValue(), status);
        }
    }

    private CommonStatus(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return this.value;
    }

    public String getText() {
        return this.text;
    }
    
    public static CommonStatus of(Integer value) {
        return lookUp.get(value);
    }

}
