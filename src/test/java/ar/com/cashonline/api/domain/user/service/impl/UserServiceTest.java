package ar.com.cashonline.api.domain.user.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import ar.com.cashonline.api.domain.loan.entity.Loan;
import ar.com.cashonline.api.domain.user.dto.UserDTO;
import ar.com.cashonline.api.domain.user.entity.User;
import ar.com.cashonline.api.domain.user.repository.UserRepository;
import ar.com.cashonline.api.domain.user.request.UserRequest;
import ar.com.cashonline.api.exception.ResourceNotFoundException;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	private static final Long USER_ID = 7L;
	private static final String USER_EMAIL = "carlos.gomez@gmail.com";
	private static final String USER_FIRST_NAME = "Carlos";
	private static final String USER_LAST_NAME = "Gómez";
	private static final Long FAIL_USER_ID = 66L;

	@Mock
	private UserRepository userRepository;
	
	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private UserService userService;

	private User mockUser;
	private UserDTO mockDto;
	
	@BeforeEach
	void beforeEach() {
		this.mockUser = createMockUser();
		this.mockDto = createMockUserDto();
	}

	@Test
	void testFindUserById() {
		when(userRepository.findById(USER_ID)).thenReturn(Optional.of(mockUser));
		when(modelMapper.map(Mockito.any(User.class), Mockito.any())).thenReturn(mockDto);
		
		UserDTO userDto = userService.findUserById(USER_ID);
		assertEquals(USER_EMAIL, userDto.getEmail());
	}

	@Test
	void testCreateUser() {
		when(userRepository.save(Mockito.any(User.class))).thenReturn(mockUser);
		when(modelMapper.map(Mockito.any(User.class), Mockito.any())).thenReturn(mockDto);
		
		UserDTO userDto = userService.createUser(createMockUserRequest());
		assertEquals(USER_FIRST_NAME, userDto.getFirstName());
		assertEquals(USER_LAST_NAME, userDto.getLastName());
	}

	@Test
	void testDeleteUser() {
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			userService.deleteUser(FAIL_USER_ID);
		});
	}

	private User createMockUser() {
		User user = new User();
		user.setId(USER_ID);
		user.setEmail(USER_EMAIL);
		user.setFirstName(USER_FIRST_NAME);
		user.setLastName(USER_LAST_NAME);
		user.addLoan(createMockLoan());
		return user;
	}

	private Loan createMockLoan() {
		Loan loan = new Loan();
		loan.setId(14L);
		loan.setTotal(13000.00);
		return loan;
	}

	private UserRequest createMockUserRequest() {
		UserRequest userRequest = new UserRequest();
		userRequest.setEmail(USER_EMAIL);
		userRequest.setFirstName(USER_FIRST_NAME);
		userRequest.setLastName(USER_LAST_NAME);
		return userRequest;
	}
	
	private UserDTO createMockUserDto() {
		UserDTO userDto = new UserDTO();
		userDto.setId(USER_ID);
		userDto.setEmail(USER_EMAIL);
		userDto.setFirstName(USER_FIRST_NAME);
		userDto.setLastName(USER_LAST_NAME);
		return userDto;
	}

}
