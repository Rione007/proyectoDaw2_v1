package cibertec.pe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_employee;
	private String nom_employee;
	private String ape_employee;
	private String email_employee;
	public int getCod_employee() {
		return cod_employee;
	}
	public void setCod_employee(int cod_employee) {
		this.cod_employee = cod_employee;
	}
	public String getNom_employee() {
		return nom_employee;
	}
	public void setNom_employee(String nom_employee) {
		this.nom_employee = nom_employee;
	}
	public String getApe_employee() {
		return ape_employee;
	}
	public void setApe_employee(String ape_employee) {
		this.ape_employee = ape_employee;
	}
	public String getEmail_employee() {
		return email_employee;
	}
	public void setEmail_employee(String email_employee) {
		this.email_employee = email_employee;
	}
	public Employee() {
	}
	
	
}
