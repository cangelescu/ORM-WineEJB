package com.cangelescu.wine.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_auto_restock")
public class AutoRestock implements Serializable {

	private static final long serialVersionUID = 6606020563416548119L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="boo_active")
	private boolean active;
	
	@Column(name="int_limit")
	private int limit;
	
	@ManyToOne
	@JoinColumn(name = "id_stock_clientB2B", nullable = false)
	private StockClientB2B stockClientB2B;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public StockClientB2B getStockClientB2B() {
		return stockClientB2B;
	}

	public void setStockClientB2B(StockClientB2B stockClientB2B) {
		this.stockClientB2B = stockClientB2B;
	}

}
