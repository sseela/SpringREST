package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.dao.StudentDAOService;
import com.cg.entities.Student;

@Controller
public class RestController {
	
	@Autowired
	private StudentDAOService studentDAO;
	
	@RequestMapping(value="/hello", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String sample() {
		
		return "hello world";
	}
	
	/*saving the data in DB using configuration file and no mapping file and using hibernate*/
	
	@RequestMapping(value="/saveStudent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody StudentVm saveStudent(@RequestBody StudentVm studentVm) {
		StudentVm vm = null;
		try {
			vm = studentDAO.saveStudent(studentVm);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return vm;
	}
}

