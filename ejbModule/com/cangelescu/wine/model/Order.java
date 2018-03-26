package com.cangelescu.wine.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_order")
public class Order implements Serializable{

	private static final long serialVersionUID = 2372719402833507102L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="dat_date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="int_orderNr")
	private int orderNr;
	
	@ManyToOne
	@JoinColumn(name = "id_clientB2C", nullable = false)
	private ClientB2C clientB2C;
	
	@OneToMany(mappedBy = "order")
	private List<OrderStock> orderStock;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getOrderNr() {
		return orderNr;
	}

	public void setOrderNr(int orderNr) {
		this.orderNr = orderNr;
	}

	public ClientB2C getClientB2C() {
		return clientB2C;
	}

	public void setClientB2C(ClientB2C clientB2C) {
		this.clientB2C = clientB2C;
	}

	public List<OrderStock> getOrderStock() {
		return orderStock;
	}

	public void setOrderStock(List<OrderStock> orderStock) {
		this.orderStock = orderStock;
	}

}
