package com.cg.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entities.Student;
import com.rest.StudentVm;

@Service
public class StudentDAOServiceImpl implements StudentDAOService{

	/*@Autowired
	private StudentRepository studentRepository;*/
	
	@Override
	public int saveStudent(StudentVm studentVm) throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("resources/Student.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		tx.begin();
		Student stud = new Student();
		stud.setId(studentVm.getId());
		stud.setName(stud.getName());
		stud.setMarks(studentVm.getMarks());
		int id = (int) session.save(stud);
		tx.commit();
		session.close();
		sf.close();
		
		return id;
	}
	
	/*@Override
	@Transactional(propagation= Propagation.REQUIRED)
	public Student saveStudent(Student student) throws Exception {
		return null;
	}*/

}
