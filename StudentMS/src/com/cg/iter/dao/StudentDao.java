package com.cg.iter.dao;

import com.cg.iter.bean.Student;
public interface StudentDao {

	boolean create(Student stud);
	Student findStudentById(int id);
	boolean updateStudent(Student id);
	boolean deleteStudent(int id);
	
	

}
