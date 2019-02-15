package com.wxm.constants;

public class ResultJson {
	private int code;
	private String info;
	private Object data;
	
	public ResultJson(){
	    this.code = CommonStatus.SUCCESS.getValue();
        this.info = CommonStatus.SUCCESS.getText();
	}
	
	public ResultJson(CommonStatus commonStatus){
		this.code = commonStatus.getValue();
		this.info = commonStatus.getText();
	}
	public ResultJson(CommonStatus commonStatus,Object data){
		this.code = commonStatus.getValue();
        this.info = commonStatus.getText();
		this.data = data;
	}
	
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String msg) {
		this.info = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
