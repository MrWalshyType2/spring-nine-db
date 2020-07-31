package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Trainee;
import com.example.service.TraineeService;

@CrossOrigin
@RestController
public class TraineeController {
	
	@Autowired
	TraineeService tService;

	@GetMapping("/client/show/all")
	public List<String> listAllClients() {
		return tService.listOfClients();
	}
	
	@GetMapping("/client/consultants/c/{client}")
	public List<Trainee> getConsultantList(@PathVariable String client) {
		return tService.getClientTrainees(client);
	}
	
	@GetMapping("/client/consultants/m/{marks}")
	public List<Trainee> getConsultantByMarksGreaterThan(@PathVariable int marks) {
		return tService.getTraineesByMarksGreaterThanOrEqual(marks);
	}
	
	@GetMapping("/max/salary")
	public List<Trainee> traineeWithMaxSalary() {
		return tService.getTraineesWithMaxSalary();
	}
	
	@GetMapping("/client/max/salary/c/{client}")
	public List<Trainee> traineeWithMaxSalary(@PathVariable String client) {
		return tService.getTraineesWithMaxSalaryClient(client);
	}
	
	@GetMapping("/client/number/consultants/{client}/{tech}")
	public int numOfConsultants(@PathVariable String client, @PathVariable String tech) {
		return tService.getNumberOfTechConsultants(client, tech);
	}
	
	@GetMapping("/client/salary/lessavg/{client}")
	public List<Trainee> traineesLessThanAvg(@PathVariable String client) {
		return tService.consultantsEarningLessThanAvg(client);
	}
	
	@GetMapping("/client/maxSalary/{client}")
	public List<Trainee> maxClientConsultantSalary(@PathVariable String client) {
		return tService.getMaxClientConsultantSalary(client);
	}
	
	@GetMapping("/tech/consultants/{tech}")
	public List<Trainee> getConsultantListTect(@PathVariable String tech) {
		return tService.getTraineesByTechnology(tech);
	}
	
	@GetMapping("/tech")
	public List<String> getTechnologies() {
		return tService.getTechnologies();
	}
	
	@GetMapping("/client/highestmarks/{client}")
	public List<Trainee> getHighestMarks(@PathVariable String client) {
		return tService.getHighestMarks(client);
	}
	
	@PostMapping("/consultant/new")
	public Trainee newConsultant(@RequestBody Trainee trainee) {
		return tService.newTrainee(trainee);
	}
}
