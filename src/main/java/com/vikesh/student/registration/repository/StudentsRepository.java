package com.vikesh.student.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vikesh.student.registration.model.StudentsData;

@Repository
public interface StudentsRepository extends JpaRepository<StudentsData, Long>{


}
