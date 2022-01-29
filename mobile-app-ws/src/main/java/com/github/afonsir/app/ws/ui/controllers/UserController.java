package com.github.afonsir.app.ws.ui.controllers;

import com.github.afonsir.app.ws.ui.models.response.UserRest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

  @GetMapping()
  public String getUsers(
    @RequestParam(value = "page", defaultValue = "1") int page,
    @RequestParam(value = "limit", defaultValue = "50") int limit,
    @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort
  ) {
    return "GET user was called with page " + page + " and limit " + limit;
  }

  @GetMapping(path = "/{userId}")
  public UserRest getUser(@PathVariable String userId) {

    UserRest responseUser = new UserRest();

    responseUser.setEmail("afonso.costa@mail.com");
    responseUser.setFirstName("Afonso");
    responseUser.setLastName("Costa");

    return responseUser;
  }

  @PostMapping
  public String createUser() {
    return "CREATE user was called";
  }

  @PutMapping
  public String updateUser() {
    return "UPDATE user was called";
  }

  @DeleteMapping
  public String deleteUser() {
    return "DELETE user was called";
  }
}