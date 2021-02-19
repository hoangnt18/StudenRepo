package studentbatis.mybatis.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studentbatis.mybatis.com.entity.Student;
import studentbatis.mybatis.com.service.StudentService;



@RestController
@RequestMapping(value = "/api/student")
public class StudentController{
	
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getListStudent(){
		List<Student> dtos = studentService.getListStudent();
		return new ResponseEntity<List<Student>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getByIdStudent(@PathVariable int id){
		try {
			Student student = studentService.getByIdStudent(id);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
	}
	@PostMapping("/add")
	public ResponseEntity<Object> insertStudent(@RequestBody Student dto, BindingResult result){
		try {
			if(result.hasErrors()) {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}else {
				studentService.insertStudent(dto);
				return new ResponseEntity<Object>(HttpStatus.CREATED);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Student> getByIdStudent(@PathVariable int id,@RequestBody Student dto){
		try {
			if(studentService.getByIdStudent(id)== null) {
				return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
			}
			studentService.updateStudent(dto);
			return new ResponseEntity<Student>(HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
		try {
			studentService.deleteStudent(id);
			return new ResponseEntity<Student>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
	}

	
}
