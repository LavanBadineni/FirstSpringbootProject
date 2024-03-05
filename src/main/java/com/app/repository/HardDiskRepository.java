package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.HardDisk;

public interface HardDiskRepository extends JpaRepository<HardDisk, Long> {

}
