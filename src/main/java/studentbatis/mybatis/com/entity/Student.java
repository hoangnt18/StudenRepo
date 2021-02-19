package studentbatis.mybatis.com.entity;

import java.util.HashSet;
import java.util.Set;

public class Student {
	
	private Integer studentId;
	private String name;
	private String classCode;
	private String userId;
	
	
	public Student() {
		super();
	}

	public Student(String name, String classCode, String userId) {
		super();
		this.name = name;
		this.classCode = classCode;
		this.userId = userId;
	}

	public Student(Integer studentId, String name, String classCode, String userId) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.classCode = classCode;
		this.userId = userId;
	}

	public Integer getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getClassCode() {
		return classCode;
	}
	
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}



	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", name=" + name + ", classCode=" + classCode + ", userId="
				+ userId + "]";
	}
	
}
