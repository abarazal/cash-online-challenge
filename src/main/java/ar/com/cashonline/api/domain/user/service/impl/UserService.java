package ar.com.cashonline.api.domain.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.cashonline.api.domain.user.dto.UserDTO;
import ar.com.cashonline.api.domain.user.entity.User;
import ar.com.cashonline.api.domain.user.repository.UserRepository;
import ar.com.cashonline.api.domain.user.request.UserRequest;
import ar.com.cashonline.api.domain.user.service.IUserService;
import ar.com.cashonline.api.exception.ResourceNotFoundException;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO findUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return modelMapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO createUser(UserRequest userRequest) {
		User user = new User(userRequest.getEmail(), userRequest.getFirstName(), userRequest.getLastName());
		User newUser = userRepository.save(user);
		return modelMapper.map(newUser, UserDTO.class);
	}

	@Override
	public void deleteUser(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userRepository.delete(user);
	}

}
