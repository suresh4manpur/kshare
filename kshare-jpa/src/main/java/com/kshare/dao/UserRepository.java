package com.kshare.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kshare.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
