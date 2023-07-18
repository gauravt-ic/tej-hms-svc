package com.bnymellon.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnymellon.hms.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
