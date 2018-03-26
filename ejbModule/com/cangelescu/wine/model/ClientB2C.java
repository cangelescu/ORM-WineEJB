package com.cangelescu.wine.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_clientB2C")
public class ClientB2C extends User {

	private static final long serialVersionUID = 2908806487554685525L;
	
	@Column(name="txt_firstName")
	private String firstName;
	
	@Column(name="txt_lastName")
	private String lastName;
	
	@Column(name="dat_register")
	@Temporal(TemporalType.DATE)
	private Date registerDate;
	
	@Column(name="txt_cnp")
	private String cnp;
	
	@OneToMany(mappedBy = "clientB2C")
	private List<Order> orders;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
