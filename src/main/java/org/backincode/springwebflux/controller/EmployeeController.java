package org.backincode.springwebflux.controller;

import org.backincode.springwebflux.model.Employee;
import org.backincode.springwebflux.repository.EmployeeReactiveRepository;
import org.backincode.springwebflux.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired EmployeeRepo repository;
	@Autowired ReactiveMongoTemplate reactiveMongoTemplate;
	@Autowired EmployeeReactiveRepository reactRepo;
	
	@GetMapping("/{id}")
	public Mono<Employee> getEmployeeById(@PathVariable String id){
		return repository.findById(id);
	}
	
	@GetMapping("/reactive/{id}")
	public Mono<Employee> getReactiveEmployeeById(@PathVariable String id){
		return reactiveMongoTemplate.findById(id, Employee.class);
	}
	
	@GetMapping("/reactive/findByRole/{role}")
	public Flux<Employee> getReactiveEmployeesByRole(@PathVariable String role){
		return reactRepo.findByRoleIgnoreCase(role);
	}
	
	
	@GetMapping("/all")
	public Flux<Employee> getAllEmployees(){
		return repository.findAll();
	}
	
	@GetMapping("/reactive/all")
	public Flux<Employee> getReactiveAllEmployees(){
		return reactiveMongoTemplate.findAll(Employee.class);
	}
	
	@PostMapping
	public Mono<Employee> save(@RequestBody Employee emp){
		return repository.save(emp);
	}
	
	@PostMapping("/reactive")
	public Mono<Employee> Reactivesave(@RequestBody Employee emp){
		return reactiveMongoTemplate.save(emp);
	}
}
