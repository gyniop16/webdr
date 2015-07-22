package com.amm.webdr.model;

import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
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
public class Role implements Serializable{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

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
	
	/*Security*/
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "RolePrivilege",
               joinColumns = {@JoinColumn(name = "idRole") },
               inverseJoinColumns = {@JoinColumn(name = "idPrivilege")} 
    )
    @ForeignKey(name = "FK_Role_Privileges", 
                inverseName="FK_Privilege_Roles")      
    private Set<Privilege> privileges = new HashSet<Privilege>();
		
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

	public Set<Privilege> getPrivileges() {
		if(null == this.privileges){
			this.privileges = new HashSet<Privilege>();
		}
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	public String getAuthority() {
		return this.rolename;
	}
}
