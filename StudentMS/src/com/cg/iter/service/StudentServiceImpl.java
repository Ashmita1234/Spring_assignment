package com.cg.iter.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.bean.Student;
import com.cg.iter.dao.StudentDao;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
    private StudentDao sDao;
	public StudentServiceImpl() {
		System.out.println("stud service constr");
	}
	@Override
	public boolean create(Student stud) {
		return sDao.create(stud);
	}
	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return sDao.findStudentById(id);
	}
	@Override
	public boolean updateStudent(Student stud) {
		// TODO Auto-generated method stub
		return sDao.updateStudent(stud);
	}
	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		return sDao.deleteStudent(id);
	}
	
	
   
}