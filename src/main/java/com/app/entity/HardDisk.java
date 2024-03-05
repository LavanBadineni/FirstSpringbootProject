package com.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class HardDisk {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long hardDiskId;
	private String hardDiskBrand;
	private int size;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "laptop_id",referencedColumnName = "laptopId")
	private Laptop laptop;

	public HardDisk(Long hardDiskId, String hardDiskBrand, int size, Laptop laptop) {
		super();
		this.hardDiskId = hardDiskId;
		this.hardDiskBrand = hardDiskBrand;
		this.size = size;
		this.laptop = laptop;
	}

	public HardDisk() {
		super();
	}

	public Long getHardDiskId() {
		return hardDiskId;
	}

	public void setHardDiskId(Long hardDiskId) {
		this.hardDiskId = hardDiskId;
	}

	public String getHardDiskBrand() {
		return hardDiskBrand;
	}

	public void setHardDiskBrand(String hardDiskBrand) {
		this.hardDiskBrand = hardDiskBrand;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "HardDisk [hardDiskId=" + hardDiskId + ", hardDiskBrand=" + hardDiskBrand + ", size=" + size
				+ ", laptop=" + laptop + "]";
	}
	
	

}
