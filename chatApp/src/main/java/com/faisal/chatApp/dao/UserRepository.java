package com.faisal.chatApp.dao;

import com.faisal.chatApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
