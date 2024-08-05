package net.javaguides.springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "complaints")
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;

	@Column(name = "room_no")
	private String roomNo;

	@Column(name = "description")
	private String description;
	
	public Complaint() {
		
	}
	
	public Complaint(String firstName, String lastName, String email, String roomNo, String description) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roomNo = roomNo;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoomNo() { return roomNo;}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
