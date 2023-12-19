package com.lead.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lead.demo.entity.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

	List<Lead> findByMobileNumber(Long mobileNumber);

}
