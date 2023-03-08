package com.prajwal.passenger.entity;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Table(name = "passengers_new")
public class PassengerEntity {
	@Id
	@Column(name = "Id")
	@GeneratedValue
	private int Id;
	@Column(name = "name")
	private String name;
	@Column(name = "Start")
	private String Start;
	@Column(name = "Destination")
	private String Destination;
    @Column(name = "Date")
    private Date date;
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart() {
		return Start;
	}
	public void setStart(String start) {
		Start = start;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}

    public PassengerEntity(int id, String name, String start, String destination, Date date) {
		super();
		Id = id;
		this.name = name;
		Start = start;
		Destination = destination;
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	//	public List<Address> getAddress() {
//		return address;
//	}
//	public void setAddress(List<Address> address) {
//		this.address = address;
//	}
	public PassengerEntity() {}
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "fk_add_id")
//	private Address address;
//	public Address getAddress() {
//		return address;
//	}
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	
//	@OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_name",referencedColumnName = "name")
//    private List<Address> address;
	
}