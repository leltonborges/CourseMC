package com.dev.course.domain;
import java.util.Date;

import javax.persistence.Entity;

import com.dev.course.domain.enums.StatusPayment;

@Entity
public class PaymentWithBoleto extends Payment{
	private static final long serialVersionUID = 1L;
	
	private Date dateExpiration;
	private Date datePaymento;
	
	public PaymentWithBoleto() {
	}

	public PaymentWithBoleto(Integer id, StatusPayment status, Request request, Date dateExpiration, Date datePayment) {
		super(id, status, request);
		this.dateExpiration = dateExpiration;
		this.datePaymento = datePayment;
	}


	
}