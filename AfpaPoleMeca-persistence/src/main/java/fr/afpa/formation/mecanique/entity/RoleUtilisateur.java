package fr.afpa.formation.mecanique.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="RoleUtilisateur")
public class RoleUtilisateur {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="id_RoleUtilisateur")
	private Long id;
	
	@Column(name="role", nullable=false)
	private String role;
	
	public RoleUtilisateur() {}
		
	/**
	 * @param id
	 * @param role
	 */
	public RoleUtilisateur(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	
	/**
	 * @param role
	 */
	public RoleUtilisateur(String role) {
		super();
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
