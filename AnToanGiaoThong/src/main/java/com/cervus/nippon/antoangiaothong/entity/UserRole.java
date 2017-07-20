package com.cervus.nippon.antoangiaothong.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USER_ROLE database table.
 * 
 */
@Entity
@Table(name="USER_ROLE")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	//bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public UserRole() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}