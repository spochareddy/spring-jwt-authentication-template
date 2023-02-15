package com.sindalah.repository;

import org.springframework.data.repository.CrudRepository;

import com.sindalah.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
