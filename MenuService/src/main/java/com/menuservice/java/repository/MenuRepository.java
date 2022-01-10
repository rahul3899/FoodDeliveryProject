package com.menuservice.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menuservice.java.model.HotelMenu;

@Repository
public interface MenuRepository extends JpaRepository<HotelMenu, Integer>{
	HotelMenu  findByNameContains(String name);

}
