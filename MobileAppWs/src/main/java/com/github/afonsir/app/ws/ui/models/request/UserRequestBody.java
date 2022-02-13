package com.github.afonsir.app.ws.ui.models.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestBody {
  @NotBlank(message = "First name cannot be null")
  @Size(min = 2, message = "First name must be greater than 2 characters")
  private String firstName;

  @NotBlank(message = "Last name cannot be null")
  @Size(min = 2, message = "Last name must be greater than 2 characters")
  private String lastName;

  @NotBlank(message = "Email cannot be null")
  @Email
  private String email;

  @NotBlank(message = "Password cannot be null")
  @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
  private String password;

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }  

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
