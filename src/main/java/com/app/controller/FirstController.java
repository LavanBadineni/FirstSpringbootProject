package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.bean.Student;

@RestController
public class FirstController {
	
	
	
	

	@GetMapping("/getName")
	public ResponseEntity getName() {
		
	List<Student> allStudent=getAllStudentsData();
	
		return new ResponseEntity<Student>(allStudent.get(0),HttpStatus.BAD_REQUEST);
	}

	
	@GetMapping("/getStudnetById/{id}")
	public ResponseEntity getStudnetById(@PathVariable int id) {
		
		if(id>3) {
			
			return new ResponseEntity<>("Please check your id",HttpStatus.BAD_REQUEST);
		}
		
	List<Student> allStudent=getAllStudentsData();
	
	return new ResponseEntity<Student>(allStudent.stream().filter(st->st.getId()==id).findFirst().get(),HttpStatus.OK);
	}
	
	
	
	private List<Student> getAllStudentsData() {
	Student s1 = new Student();
		
		s1.setId(1);
		s1.setName("Lavan");
		s1.setCourse("MA English");
		
		List hobbies=new ArrayList();
		hobbies.add("playing");
		hobbies.add("walking");
		s1.setHobbies(hobbies);
       Student s2 = new Student();
		
		s2.setId(2);
		s2.setName("chandu");
		s2.setCourse("mtech");
		
		/*
		 * List hobbies=new ArrayList(); hobbies.add("running"); hobbies.add("jumping");
		 */
		s2.setHobbies(hobbies);
		 Student s3 = new Student();
			
			s3.setId(3);
			s3.setName("raju");
			s3.setCourse("bsc");
			
			/*
			 * List hobbies=new ArrayList(); hobbies.add("running"); hobbies.add("jumping");
			 */
			s3.setHobbies(hobbies);
		
		List<Student> allStudnet=new ArrayList<>();
		
		allStudnet.add(s1);allStudnet.add(s2);allStudnet.add(s3);
		return allStudnet;
	}
	
	
	
	
	

}
