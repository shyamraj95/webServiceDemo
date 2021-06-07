package com.webServiceDemo.ws.services;

import com.webServiceDemo.ws.shared.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);
}
