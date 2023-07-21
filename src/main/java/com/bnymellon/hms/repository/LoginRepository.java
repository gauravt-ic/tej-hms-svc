package com.bnymellon.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnymellon.hms.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

}
