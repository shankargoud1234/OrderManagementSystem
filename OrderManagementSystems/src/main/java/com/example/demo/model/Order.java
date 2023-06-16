package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "OrderDetails")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long oId;
	@Enumerated(EnumType.STRING)
	private OrderType OrderType;
	@Enumerated(EnumType.STRING)
	private MarketIdentifierCode MarketIdentifierCode;
	private String ISIN;
	private int OrderSize;
	private double Priceperunit;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
	private User user;

	public Order() {

	}

	public Order(long oId, com.example.demo.model.OrderType orderType,
			com.example.demo.model.MarketIdentifierCode marketIdentifierCode, String iSIN, int orderSize,
			double priceperunit, User user) {
		super();
		this.oId = oId;
		OrderType = orderType;
		MarketIdentifierCode = marketIdentifierCode;
		ISIN = iSIN;
		OrderSize = orderSize;
		Priceperunit = priceperunit;
		this.user = user;
	}

	public long getoId() {
		return oId;
	}

	public void setoId(long oId) {
		this.oId = oId;
	}

	public OrderType getOrderType() {
		return OrderType;
	}

	public void setOrderType(OrderType orderType) {
		OrderType = orderType;
	}

	public MarketIdentifierCode getMarketIdentifierCode() {
		return MarketIdentifierCode;
	}

	public void setMarketIdentifierCode(MarketIdentifierCode marketIdentifierCode) {
		MarketIdentifierCode = marketIdentifierCode;
	}

	public String getISIN() {
		return ISIN;
	}

	public void setISIN(String iSIN) {
		ISIN = iSIN;
	}

	public int getOrderSize() {
		return OrderSize;
	}

	public void setOrderSize(int orderSize) {
		OrderSize = orderSize;
	}

	public double getPriceperunit() {
		return Priceperunit;
	}

	public void setPriceperunit(double priceperunit) {
		Priceperunit = priceperunit;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	}
