package org.sid.app.repository;

import org.sid.app.entities.Defense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefenseRepository extends JpaRepository<Defense, Long> {

}
