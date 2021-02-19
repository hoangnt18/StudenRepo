package studentbatis.mybatis.com.controller;

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

import studentbatis.mybatis.com.entity.User;
import studentbatis.mybatis.com.service.UserService;



@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getListUser(){
		List<User> dtos = userService.getListUser();
		return new ResponseEntity<List<User>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		try {
			User dto = userService.getUserById(id);
			return new ResponseEntity<User>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
	@PostMapping("/add")
	public ResponseEntity<Object> insertUser(@RequestBody User dto, BindingResult result){
		try {
			if(result.hasErrors()) {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}else {
				userService.insertUser(dto);
				return new ResponseEntity<Object>(HttpStatus.CREATED);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User dto){
		try {
			if(userService.getUserById(id) == null) {
				return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
			}
			userService.updateUser(dto);
			return new ResponseEntity<User>(HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		try {
			userService.deleteUser(id);
			return new ResponseEntity<User>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}

}
