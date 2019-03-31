package org.backincode.springwebflux.repository;

import org.backincode.springwebflux.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface EmployeeReactiveRepository extends ReactiveMongoRepository<Employee, String> {

	public Flux<Employee> findByRoleIgnoreCase(String role);
}
