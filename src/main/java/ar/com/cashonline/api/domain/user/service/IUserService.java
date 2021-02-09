package ar.com.cashonline.api.domain.user.service;

import ar.com.cashonline.api.domain.user.dto.UserDTO;
import ar.com.cashonline.api.domain.user.request.UserRequest;

public interface IUserService {

	UserDTO findUserById(Long id);

	UserDTO createUser(UserRequest userRequest);
	
	void deleteUser(Long id);
}
