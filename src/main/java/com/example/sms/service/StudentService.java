package com.example.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sms.entity.StudentEntity;
import com.example.sms.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo stuRep;

	public String createStu(StudentEntity stu) {
		stuRep.save(stu);
		return "created";
	}

	public List<StudentEntity> getAll() {
		return stuRep.findAll();
	}

	public StudentEntity findByid(int id) {
		try {
			return stuRep.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	public String updatestu(StudentEntity stu) {
		try {
			StudentEntity getStu = stuRep.findById(stu.getId()).get();
			if (!stu.getName().isBlank()) {
				getStu.setName(stu.getName());
			}
			if (!stu.getCity().isBlank()) {
				getStu.setCity(stu.getCity());
			}
			if (!stu.getEmail().isBlank()) {
				getStu.setEmail(stu.getEmail());
			}
			stuRep.save(getStu);
			return "update successfully";
		} catch (Exception e) {
			return "no student found";
		}

	}

	public void deleteStudentById(Integer id) {
		stuRep.deleteById(id);
	}

}
