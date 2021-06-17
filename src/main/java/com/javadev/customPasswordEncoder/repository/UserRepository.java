package com.javadev.customPasswordEncoder.repository;

import com.javadev.customPasswordEncoder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
