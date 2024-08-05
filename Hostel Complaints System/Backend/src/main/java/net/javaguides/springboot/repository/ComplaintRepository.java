package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entity.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long>{

}
