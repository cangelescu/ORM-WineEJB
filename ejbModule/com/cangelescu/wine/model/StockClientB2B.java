package com.cangelescu.wine.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_stock_clientB2B")
public class StockClientB2B implements Serializable{

	private static final long serialVersionUID = 4027630805439663759L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="dec_price")
	private BigDecimal price;
	
	@Column(name="int_quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "id_clientB2B", nullable = false)
	private ClientB2B clientB2B;
	
	@OneToMany(mappedBy = "stockClientB2B")
	private List<AutoRestock> autoRestock;
	
	@OneToMany(mappedBy = "stockClientB2B")
	private List<OrderStock> orderStock;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ClientB2B getClientB2B() {
		return clientB2B;
	}

	public void setClientB2B(ClientB2B clientB2B) {
		this.clientB2B = clientB2B;
	}

	public List<AutoRestock> getAutoRestock() {
		return autoRestock;
	}

	public void setAutoRestock(List<AutoRestock> autoRestock) {
		this.autoRestock = autoRestock;
	}

	public List<OrderStock> getOrderStock() {
		return orderStock;
	}

	public void setOrderStock(List<OrderStock> orderStock) {
		this.orderStock = orderStock;
	}

}
