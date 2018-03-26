package com.cangelescu.wine.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_clientB2B")
public class ClientB2B extends User {
	
	private static final long serialVersionUID = 9102465389698841551L;
	
	@Column(name="boo_visibility")
	private boolean visibility;
	
	@Column(name="txt_companyName")
	private String companyName;
	
	@Column(name="txt_cui")
	private String cui;
	
	@Column(name="boo_subscribed")
	private boolean subscribed;
	
	@OneToMany(mappedBy = "clientB2B")
	private List<StockClientB2B> stockClientB2B;

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCui() {
		return cui;
	}

	public void setCui(String cui) {
		this.cui = cui;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public List<StockClientB2B> getStockClientB2B() {
		return stockClientB2B;
	}

	public void setStockClientB2B(List<StockClientB2B> stockClientB2B) {
		this.stockClientB2B = stockClientB2B;
	}

}
