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
	
	/*@RequestMapping(value="/hello", method=RequestMethod.POST)
	public @ResponseBody String sample2() {
		
		return "hello world";
	}*/
	
	/*@RequestMapping(value="/saveStudent", consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String saveStudent(@RequestBody StudentVm studentVm) {
		int id=0;
		try {
			id = studentDAO.saveStudent(studentVm);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "fuck";
	}*/
	
	@RequestMapping(value="/saveStudent", method=RequestMethod.PUT)
	public @ResponseBody String saveStudentWithGetAndRequestParams(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam(value="marks", required=false, defaultValue="200") int marks) {
		StudentVm vm = new StudentVm(id, name, marks);
		try {
			id = studentDAO.saveStudent(vm);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "fuck";
	}
	
	@RequestMapping(value="/another", method=RequestMethod.POST)
	public @ResponseBody String post() {
		
		return "fuck";
	}
	
	@RequestMapping(value="/saveStudentWithPathVariable/id/{id}/name/{name}/marks/{marks}", method=RequestMethod.GET)
	public @ResponseBody String saveStudentWithGetAndPathParams(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("marks") int marks) {
		StudentVm vm = new StudentVm(id, name, marks);
		try {
			id = studentDAO.saveStudent(vm);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "fuck";
	}
}

