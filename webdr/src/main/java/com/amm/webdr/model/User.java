package com.amm.webdr.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.amm.webdr.service.validation.FieldMatch;

@NamedQueries({
	@NamedQuery(
	name = "getUserByUsername",
	query = "from User where username = :username "
	)
})

@FieldMatch.List({
    @FieldMatch(first = "password", second = "password2", message = "The password fields must match")
})

@Entity
@Table(name="User")
public class User {

	@Id
    @Column(name="idUser")
    @GeneratedValue
    private Integer idUser;

	@Column(name="active", nullable=false)
	private Boolean active;
	
	@Size(min=1, max=15)
	@Column(name="username", nullable=false, length=15)
    private String username;
	
	@Size(min=1, max=15)
	@Column(name="password", nullable=false, length=15)
    private String password;
	
	@Size(min=1, max=15)
	@Column(name = "password", insertable= false, updatable= false)
	private String password2;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole",
               joinColumns = {@JoinColumn(name = "idUser") },
               inverseJoinColumns = {@JoinColumn(name = "idRole")} 
    )
    @ForeignKey(name = "FK_User_Roles", 
                inverseName="FK_Role_Users")      
    private Set<Role> roles = new HashSet<Role>();
	
	public User(){
		
	}
	
	public User(boolean active) {
		this.active = active;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
