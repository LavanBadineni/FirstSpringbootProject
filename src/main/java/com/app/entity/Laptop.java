package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long laptopId;
	private String laptopBrand;
	private String diplayType;
	
	
	  @OneToOne(mappedBy = "laptop") 
	  private HardDisk hardDisk;
	 
	public Laptop() {
		super();
	}
	public Laptop(Long laptopId, String laptopBrand, String diplayType) {
		super();
		this.laptopId = laptopId;
		this.laptopBrand = laptopBrand;
		this.diplayType = diplayType;
	}
	public Long getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(Long laptopId) {
		this.laptopId = laptopId;
	}
	public String getLaptopBrand() {
		return laptopBrand;
	}
	public void setLaptopBrand(String laptopBrand) {
		this.laptopBrand = laptopBrand;
	}
	public String getDiplayType() {
		return diplayType;
	}
	public void setDiplayType(String diplayType) {
		this.diplayType = diplayType;
	}
	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", laptopBrand=" + laptopBrand + ", diplayType=" + diplayType + "]";
	}
	
	
	
	

}
