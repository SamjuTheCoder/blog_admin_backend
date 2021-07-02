package com.magazine.backend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String phone;
	@Column
	private String address;
	@Column
	private String email;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private int active;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getFirstname()
	{
		return firstname;
	}
	
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname)
	{
		this.lastname=lastname;
	}
	
	public String getLastname()
	{
		return lastname;
	}
			
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return email;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone; 
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setAddress(String address)
	{
		this.address=address;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setActive(int active) {
		this.active=active;
	}
	
	public int getActive()
	{
		return active;
	}
	
	public Set<Role> getRoles() {
	  return roles;
	}

	public void setRoles(Set<Role> roles) {
	  this.roles = roles;
	}
}
