package com.cg.iter.dao;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Component;

import com.cg.iter.bean.Student;
import com.cg.iter.util.JUtil;

@Component
public class StudentDaoImpl implements StudentDao {

	private EntityManager em = JUtil.getEntityManager();

	@Override
	public boolean create(Student stud) {
		try {
		em.getTransaction().begin();
		em.persist(stud);
		em.getTransaction().commit();
		return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Student findStudentById(int id) {
		try {
			Student res = null;
			res = em.find(Student.class, id);
			return res;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public boolean updateStudent(Student student) {
		em.getTransaction().begin();
		em.merge(student);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteStudent(int id) {
		em.getTransaction().begin();
		em.remove(findStudentById(id));
		em.getTransaction().commit();
		return true;
	}

	
	

}
