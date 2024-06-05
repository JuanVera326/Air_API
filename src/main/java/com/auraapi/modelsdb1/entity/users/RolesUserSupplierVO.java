package com.auraapi.modelsdb1.entity.users;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "role_user")
public class RolesUserSupplierVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
    private Long role_id;

    @Column(name = "name_role")
    private String name;
    
    @ManyToMany(mappedBy = "rol_enterprise_user")
    private Set<EnterpriseUserVO> users;
	    
	public RolesUserSupplierVO() {}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<EnterpriseUserVO> getUsers() {
		return users;
	}

	public void setUsers(Set<EnterpriseUserVO> users) {
		this.users = users;
	}

}
