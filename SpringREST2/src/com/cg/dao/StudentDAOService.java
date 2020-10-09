package com.cg.dao;

import com.cg.entities.Student;
import com.rest.StudentVm;

public interface StudentDAOService {
	public int saveStudent(StudentVm stud) throws Exception;
}
