package com.amm.webdr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({
	@NamedQuery(
	name = "getRoleByRolename",
	query = "from Role where rolename = :rolename "
	)
})

@Entity
@Table(name="Role")
public class Role {

	@Id
    @Column(name="idRole")
    @GeneratedValue
    private Integer idRole;
	
	@Column(name="active", nullable=false)
	private Boolean active;
	
	@Size(min=1, max=15)
	@Column(name="rolename", length=15, nullable=false)
	private String rolename;
	
	@Column(name="description")
	private String description;
	
	public Role(){
		
	}
		
	public Role(boolean active) {
		this.active = active;
	}
	
	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
