package com.cangelescu.wine.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_supplier")
public class Supplier implements Serializable {

	private static final long serialVersionUID = 412377181638626322L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="boo_visibility")
	private boolean visibility;
	
	@Column(name="txt_cellarName")
	private String cellarName;
	
	@Column(name="int_age")
	private int age;
	
	@OneToMany(mappedBy = "supplier")
	private List<StockSupplier> stockSupplier;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public String getCellarName() {
		return cellarName;
	}

	public void setCellarName(String cellarName) {
		this.cellarName = cellarName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<StockSupplier> getStockSupplier() {
		return stockSupplier;
	}

	public void setStockSupplier(List<StockSupplier> stockSupplier) {
		this.stockSupplier = stockSupplier;
	}
	
}
