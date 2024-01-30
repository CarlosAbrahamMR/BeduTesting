package com.spring.security.repository;

import com.spring.security.model.pending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingRepository extends JpaRepository<pending,Long> {
}
