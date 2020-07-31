package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Trainee;
import com.example.repository.TraineeRepository;

@Service
public class TraineeService {

	@Autowired
	TraineeRepository tRepo;
	
	public List<Trainee> getTrainees() {
		return tRepo.findAll();
	}
	
	public Trainee getTrainee(int id) {
		Optional<Trainee> trainee = tRepo.findById(id);
		
		if (trainee.get() != null) {
			return trainee.get();
		}
		return null;
	}
	
	public List<Trainee> getClientTrainees(String client) {
		return tRepo.findByClient(client);
	}
	
	public Trainee newTrainee(Trainee t) {
		return tRepo.save(t);
	}
	
	public List<Trainee> getTraineesByMarksGreaterThanOrEqual(int marks) {
		return tRepo.findByMarksGreaterThanEqual(marks);
	}
	
	public List<Trainee> getTraineesByTechnology(String tech) {
		return tRepo.findByTechnology(tech);
	}
	
	public String deleteTrainee(int id) {
		tRepo.deleteById(id);
		return "Deleted trainee consultant...";
	}
	
	public List<Trainee> getTraineesWithMaxSalary() {
		return tRepo.maxSalary();
	}
	
	public List<Trainee> getMaxClientConsultantSalary(String client) {
		return tRepo.maxClientConsultantSalary(client);
	}
	
	public List<Trainee> getTraineesWithMaxSalaryClient(String client) {
		return tRepo.maxSalaryClient(client);
	}
	
	public int getNumberOfTechConsultants(String client, String tech) {
		return tRepo.numOfTechConsultants(client, tech);
	}
	
	public List<String> listOfClients() {
		return tRepo.getAllClients();
	}
	
	public List<Trainee> consultantsEarningLessThanAvg(String client) {
		return tRepo.consultantsLessThanAvgSalary(client);
	}
	
	public List<String> getTechnologies() {
		return tRepo.getTechnologies();
	}
	
	public List<Trainee> getHighestMarks(String client) {
		return tRepo.highestMarks(client);
	}
}
