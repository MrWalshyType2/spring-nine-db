package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Trainee;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Integer> {

	// The logic is implemented by Spring (use 'findByXXXX', filter applied on 'XXXX' value)
	public List<Trainee> findByTechnology(String tech);
	public List<Trainee> findByClient(String client);
	public List<Trainee> findByMarksGreaterThanEqual(int marks);
	
	// Using the @Query annotation allows writing of queries for a specific method
	// nativeQuery indicates whether it is pure SQL or not here
	@Query(value = "SELECT * FROM consultant WHERE salary = (SELECT MAX(salary) FROM consultant)", nativeQuery=true)
	public List<Trainee> maxSalary();
	
	@Query(value = "SELECT * FROM consultant WHERE salary = (SELECT MAX(salary) FROM consultant WHERE client = ?1) AND client = ?1", nativeQuery = true)
	public List<Trainee> maxClientConsultantSalary(String client);
	
	// ?1 indicates first parameter
	@Query(value="SELECT * FROM consultant WHERE salary = (SELECT MAX(salary) FROM consultant WHERE client=?1) AND client=?1", nativeQuery = true)
	public List<Trainee> maxSalaryClient(String client);
	
	@Query(value="SELECT count(*) FROM consultant WHERE client=?1 and technology=?2", nativeQuery = true)
	public int numOfTechConsultants(String client, String tech);
	
	@Query(value = "SELECT DISTINCT client FROM consultant", nativeQuery = true)
	public List<String> getAllClients();
	
	@Query(value = "SELECT * FROM consultant WHERE salary < (SELECT AVG(salary) FROM consultant WHERE client = ?1) AND client = ?1", nativeQuery = true)
	public List<Trainee> consultantsLessThanAvgSalary(String client);
	
	@Query(value = "SELECT * FROM consultant WHERE marks = (SELECT MAX(marks) FROM consultant WHERE client = ?1) AND client = ?1", nativeQuery = true)
	public List<Trainee> highestMarks(String client);
	
	@Query(value = "SELECT DISTINCT technology FROM consultant", nativeQuery = true)
	public List<String> getTechnologies();
}
