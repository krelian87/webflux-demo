package org.backincode.springwebflux.repository;

import org.backincode.springwebflux.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends ReactiveMongoRepository<Employee, String>{

}
