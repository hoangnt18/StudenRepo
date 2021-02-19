package studentbatis.mybatis.com.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;

import studentbatis.mybatis.com.entity.*;

@Mapper
public interface StudentMapper  {

	@Select("select * from student")
	List<Student> getListStudent();
	
	@Select("SELECT * FROM STUDENT WHERE STUDENTID = #{studentId};")
	Student getByIdStudent(int id);
	
	@Insert("INSERT INTO STUDENT(STUDENTID,NAME,ID,CLASSCODE) VALUES(#{studentId},#{name},#{classCode},#{userId});")
	int insertStudent(Student student);
	
	@Update("UPDATE STUDENT SET  NAME= #{name}, CLASSCODE = #{classCode}, ID=#{userId} WHERE STUDENTID = #{studentId}")
	int updateStudent(Student student);
	
	@Delete("DELETE FROM STUDENT WHERE STUDENTID = #{studentId};")
	int deleteStudent(int id);


   
}




