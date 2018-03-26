package com.cangelescu.wine.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_promo")
public class Promo implements Serializable{

	private static final long serialVersionUID = -3771513673857634560L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_stock_supplier", nullable = false)
	private StockSupplier stocksupplier;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dat_startDate")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dat_endDate")
	private Date endDate;
	
	@Column(name="dec_discount")
	private BigDecimal discount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StockSupplier getStocksupplier() {
		return stocksupplier;
	}

	public void setStocksupplier(StockSupplier stocksupplier) {
		this.stocksupplier = stocksupplier;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	
}
