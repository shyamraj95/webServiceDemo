package com.webServiceDemo.ws.ui.contoller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webServiceDemo.ws.ui.model.request.UserDetailsRequestModel;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
//@CrossOrigin(origins= {"http://localhost:8083", "http://localhost:8084"})
public class UserController {
	@GetMapping
	public String getUser() {
		return "get User was called";
	}
	@PostMapping
	public String createUser(@RequestBody UserDetailsRequestModel userDetails) {
		return "create User was called";
	}
	@DeleteMapping
	public String deleteUser() {
		return "User was deleted";
	}
}
