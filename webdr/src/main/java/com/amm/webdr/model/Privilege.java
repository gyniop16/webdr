package com.amm.webdr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({
	@NamedQuery(
	name = "getPrivilegeByPrivilegename",
	query = "from Privilege where privilegename = :privilegename "
	)
})

@Entity
@Table(name="Privilege")
public class Privilege implements Serializable{
	
	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="idPrivilege")
    @GeneratedValue
    private Integer idPrivilege;
	
	@Column(name="active", nullable=false)
	private Boolean active;
	
	@Size(min=1, max=100)
	@Column(name="privilegename", length=100, nullable=false)
	private String privilegename;
	
	@Column(name="description")
	private String description;
 
    public Integer getIdPrivilege() {
		return idPrivilege;
	}

	public void setIdPrivilege(Integer idPrivilege) {
		this.idPrivilege = idPrivilege;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getPrivilegename() {
		return privilegename;
	}

	public void setPrivilegename(String privilegename) {
		this.privilegename = privilegename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Privilege [privilegename=");
        builder.append(privilegename);
        builder.append("]");
        return builder.toString();
    }
}
