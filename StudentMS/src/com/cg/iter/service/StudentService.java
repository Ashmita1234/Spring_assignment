package com.cg.iter.service;

import java.util.List;

import com.cg.iter.bean.Student;

public interface StudentService {

	boolean create(Student stud);

	Student findStudentById(int nextInt);

	boolean updateStudent(Student upStudent);

	boolean deleteStudent(int nextInt);


}
