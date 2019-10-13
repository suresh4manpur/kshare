package com.kshare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kshare.entity.Employee;
import com.kshare.entity.ParckingSpace;
import com.kshare.entity.Person;

public interface ParkingSpaceRepository extends JpaRepository<ParckingSpace, Long>{

}
