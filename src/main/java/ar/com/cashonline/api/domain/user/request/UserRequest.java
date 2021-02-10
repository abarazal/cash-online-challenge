package ar.com.cashonline.api.domain.user.request;

import javax.validation.constraints.NotEmpty;

public class UserRequest {

	@NotEmpty
	private String email;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
