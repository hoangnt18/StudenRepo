package studentbatis.mybatis.com.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import studentbatis.mybatis.com.entity.*;

@Mapper
public interface UserMapper {
	
    @Select("SELECT * FROM USER;")
    List<User> getListUser();
	
	@Select("select *  from user where id = #{id}")
	User getUserById(int id);
	
	@Insert(" INSERT INTO USER (ID, NAME, EMAIL, PASSWORD, ROLE) VALUES (#{id}, #{name}, #{email}, #{password}, #{role})")
	int insertUser(User user);
	
	@Update("update user set name=#{name}, email=#{email}, role=#{role} where id=#{id};")
	int updateUser(User user);
	
	@Delete("delete from user where id = #{id}")
	int deleteUser(int id);

	@Select("select *  from user where email = #{email}")
	User findByEmail(String email);

}
