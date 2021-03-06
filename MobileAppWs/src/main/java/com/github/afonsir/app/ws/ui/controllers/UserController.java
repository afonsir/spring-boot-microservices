package com.github.afonsir.app.ws.ui.controllers;

import java.util.HashMap;
import java.util.Map;

import com.github.afonsir.app.ws.ui.models.request.UpdateUserRequestBody;
import com.github.afonsir.app.ws.ui.models.request.UserRequestBody;
import com.github.afonsir.app.ws.ui.models.response.UserRest;
import com.github.afonsir.app.ws.userservice.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

  Map<String, UserRest> users = new HashMap<>();

  @Autowired
  UserService userService;

  @GetMapping()
  public String getUsers(
    @RequestParam(value = "page", defaultValue = "1") int page,
    @RequestParam(value = "limit", defaultValue = "50") int limit,
    @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort
  ) {
    return "GET user was called with page " + page + " and limit " + limit;
  }

  @GetMapping(
    path = "/{userId}",
    produces = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE
    }
  )
  public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
    if (users.containsKey(userId)) {
      return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  @PostMapping(
    consumes = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE
    },
    produces = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE
    }
  )
  public ResponseEntity<UserRest> createUser(
    @Valid @RequestBody UserRequestBody userRequestBody
  ) {
    UserRest responseUser = userService.createUser(userRequestBody);
    return new ResponseEntity<UserRest>(responseUser, HttpStatus.OK);
  }

  @PutMapping(
    path = "/{userId}",
    consumes = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE
    },
    produces = {
      MediaType.APPLICATION_JSON_VALUE,
      MediaType.APPLICATION_XML_VALUE
    }
  )
  public ResponseEntity<UserRest> updateUser(
    @PathVariable String userId,
    @Valid @RequestBody UpdateUserRequestBody updateUserRequestBody
  ) {
    UserRest responseUser = users.get(userId);

    responseUser.setFirstName(updateUserRequestBody.getFirstName());
    responseUser.setLastName(updateUserRequestBody.getLastName());

    users.put(userId, responseUser);

    return new ResponseEntity<UserRest>(responseUser, HttpStatus.OK);
  }

  @DeleteMapping(
    path = "/{userId}"
  )
  public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
    users.remove(userId);

    return ResponseEntity.noContent().build();
  }
}
