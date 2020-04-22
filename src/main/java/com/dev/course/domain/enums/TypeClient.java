package com.dev.course.domain.enums;

public enum TypeClient {
	PESSOA_FISICA(1,"Pessoa Física"),
	PESSOA_JURIDICA(2, "Pessoa Jurídica");
	
	private int code;
	private String description;
	
	TypeClient(int code, String description){
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static TypeClient toEnum(Integer value) {
		if(value == null) {
			return null;
		}
		for(TypeClient type : TypeClient.values()) {
			if(value.equals(type.getCode())) {
				return type;
			}
		}
		throw new IllegalArgumentException("Code invalid "+value);
	}
}
