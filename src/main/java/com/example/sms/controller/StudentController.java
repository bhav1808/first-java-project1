package com.example.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.entity.StudentEntity;
import com.example.sms.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService stuSer;

//	@GetMapping("/dd")
//	public String open() {
//		return "api hitted";
//	}

	@PostMapping("/create")
	public String createStu(@RequestBody StudentEntity stu) {
		return stuSer.createStu(stu);
	}

	@GetMapping("/list")
	public List<StudentEntity> getStu() {
		return stuSer.getAll();
	}

	@GetMapping("/findById")
	public StudentEntity getStuById(@RequestParam("id") int id) {
		return stuSer.findByid(id);
	}

	@PostMapping("/update")
	public String updateStu(@RequestBody StudentEntity stu) {
		return stuSer.updatestu(stu);
	}

	@GetMapping("/delete")
	public String deleteStu(@RequestParam("id") int id) {
		stuSer.deleteStudentById(id);
		return "deleted successfully";
	}

}
