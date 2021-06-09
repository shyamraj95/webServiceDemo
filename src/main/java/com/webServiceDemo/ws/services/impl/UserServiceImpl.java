package com.webServiceDemo.ws.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webServiceDemo.ws.io.entity.UserEntity;
import com.webServiceDemo.ws.io.repository.UserRepository;
import com.webServiceDemo.ws.services.UserService;
import com.webServiceDemo.ws.shared.dto.UserDto;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
	UserRepository userRepository;
	@Override
	public UserDto createUser(UserDto user) {
		UserEntity userEntity= new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setEncryptedPassword("password");
		userEntity.setUserId("id_1");
		userEntity.setEmailVerificationStatus(true);
		UserEntity storedUserDetails= userRepository.save(userEntity);
		UserDto returnValue=new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		return returnValue;
	}

}
