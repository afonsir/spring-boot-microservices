package com.github.afonsir.app.ws.mobileappws.ui.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateUserRequestBody {
  @NotBlank(message = "First name cannot be null")
  @Size(min = 2, message = "First name must be greater than 2 characters")
  private String firstName;

  @NotBlank(message = "Last name cannot be null")
  @Size(min = 2, message = "Last name must be greater than 2 characters")
  private String lastName;

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
