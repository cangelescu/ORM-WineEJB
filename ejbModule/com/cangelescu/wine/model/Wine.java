package com.cangelescu.wine.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cangelescu.wine.util.WineType;

@Entity
@Table(name = "t_wine")
public class Wine implements Serializable{

	private static final long serialVersionUID = 4092986189730596158L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="dat_year")
	@Temporal(TemporalType.DATE)
	private Date year;
	
	@Column(name="txt_name")
	private String name;
	
	@Column(name="txt_description")
	private String description;
	
	@Column(name="txt_soi")
	private String soi;
	
	@Enumerated(EnumType.STRING)	
	@Column(name="txt_type")
	private WineType type;
	
	@OneToMany(mappedBy = "wine")
	private List<StockSupplier> stockSupplier;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSoi() {
		return soi;
	}

	public void setSoi(String soi) {
		this.soi = soi;
	}

	public WineType getType() {
		return type;
	}

	public void setType(WineType type) {
		this.type = type;
	}

	public List<StockSupplier> getStockSupplier() {
		return stockSupplier;
	}

	public void setStockSupplier(List<StockSupplier> stockSupplier) {
		this.stockSupplier = stockSupplier;
	}

}
