package com.faisal.chatApp.dao;

import com.faisal.chatApp.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
