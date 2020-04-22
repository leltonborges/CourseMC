package com.dev.course.domain.enums;

public enum StatusPayment {
	PENDING(1, "Pending"),
	SETTLED(2, "Settled"),
	CANCELED(3, "Canceled");
	
	private int code;
	private String description;
	
	private StatusPayment(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public static StatusPayment toEnum(Integer value) {
		if(value == null) {
			return null;
		}
		for(StatusPayment status : StatusPayment.values()) {
			if(value.equals(status.getCode())) {
				return status;
			}
		}
		throw new IllegalArgumentException("Code invalid "+ value );
	}
}
