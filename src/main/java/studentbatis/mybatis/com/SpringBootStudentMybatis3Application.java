package studentbatis.mybatis.com;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;



import studentbatis.mybatis.com.entity.Student;

@MappedTypes(Student.class)
@MapperScan(basePackages = "studentbatis.mybatis.com")
@SpringBootApplication
public class SpringBootStudentMybatis3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudentMybatis3Application.class, args); 
	}

}






