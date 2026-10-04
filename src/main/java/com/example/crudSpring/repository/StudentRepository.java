package com.example.crudSpring.repository;

import com.example.crudSpring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> { // <data kaha se lena hai, primary key ka type>

}
