package com.webServiceDemo.ws.ui.contoller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webServiceDemo.ws.services.UserService;
import com.webServiceDemo.ws.shared.dto.UserDto;
import com.webServiceDemo.ws.ui.model.request.UserDetailsRequestModel;
import com.webServiceDemo.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
//@CrossOrigin(origins= {"http://localhost:8083", "http://localhost:8084"})
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping
	public String getUser() {
		return "get User was called";
	}
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
 		BeanUtils.copyProperties(userDetails, userDto);
//		ModelMapper modelMapper = new ModelMapper();
//		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
//		returnValue = modelMapper.map(createdUser, UserRest.class);

		return returnValue;
	}
	@DeleteMapping
	public String deleteUser() {
		return "User was deleted";
	}
}
