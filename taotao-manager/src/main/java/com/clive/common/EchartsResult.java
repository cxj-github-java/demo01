package com.clive.common;

public class EchartsResult {
	private String name;
	@Override
	public String toString() {
		return "EchartsResult [name=" + name + ", value=" + value + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	private Integer value;
}
