package studentbatis.mybatis.com.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import studentbatis.mybatis.com.entity.*;
import studentbatis.mybatis.com.repository.StudentMapper;
import studentbatis.mybatis.com.repository.UserMapper;

@Service
public class StudentService {

	@Autowired
	StudentMapper studentMapper;
	
	
	public List<Student> getListStudent() {
		List<Student> listStudent = studentMapper.getListStudent();
		return listStudent;
	}

	
	public Student getByIdStudent(Integer id) {
		Student student = studentMapper.getByIdStudent(id);
		if(student != null) {
			return student;
		}else {
			return null;
		}
	}

	public int insertStudent(Student student) {
		studentMapper.insertStudent(student);
		return 0;
	}

	
	public int updateStudent(Student student) {
		studentMapper.updateStudent(student);
		return 0;
	}

	
	public int deleteStudent(Integer id) {
		studentMapper.deleteStudent(id);
		return 0;
	}
	

}
