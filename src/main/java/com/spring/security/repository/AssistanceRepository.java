package com.spring.security.repository;
import com.spring.security.model.Assistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistanceRepository extends JpaRepository<Assistance,Long>{
}
