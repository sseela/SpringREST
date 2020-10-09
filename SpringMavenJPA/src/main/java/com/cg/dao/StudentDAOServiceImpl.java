package com.cg.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entities.Student;
import com.cg.repositories.StudentRepository;
import com.rest.StudentVm;

@Service
public class StudentDAOServiceImpl implements StudentDAOService{

	@Autowired
	private StudentRepository studentRepository; 
	
	@Override
	@Transactional(propagation= Propagation.REQUIRED, readOnly = true)
	public StudentVm saveStudent(StudentVm studentVm) throws Exception {
		
		//assembler to convert Vm to Entity type
		Student stud = new Student();
		stud.setId(studentVm.getId());
		stud.setMarks(studentVm.getMarks());
		stud.setName(studentVm.getName());
		
		//save can only save object of type iterable of Entity
		List<Student> list = new ArrayList<>();
		list.add(stud);
		
		List<Student> returnedList = studentRepository.save(list);
		
		//assembler to convert back entity type to vm
		Student student = returnedList.get(0);
		StudentVm vm = new StudentVm();
		vm.setId(student.getId());
		vm.setMarks(student.getMarks());
		vm.setName(student.getName());
		
		return vm;
	}

}
