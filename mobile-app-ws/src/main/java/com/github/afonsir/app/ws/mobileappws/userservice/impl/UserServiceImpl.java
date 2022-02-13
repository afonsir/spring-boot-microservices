package com.github.afonsir.app.ws.mobileappws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.afonsir.app.ws.mobileappws.ui.models.request.UserRequestBody;
import com.github.afonsir.app.ws.mobileappws.ui.models.response.UserRest;
import com.github.afonsir.app.ws.mobileappws.userservice.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  Map<String, UserRest> users = new HashMap<>();

  @Override
  public UserRest createUser(UserRequestBody userRequestBody) {
    String userId = UUID.randomUUID().toString();
    UserRest responseUser = new UserRest();

    responseUser.setUserId(userId);
    responseUser.setEmail(userRequestBody.getEmail());
    responseUser.setFirstName(userRequestBody.getFirstName());
    responseUser.setLastName(userRequestBody.getLastName());

    users.put(userId, responseUser);

    return responseUser;
  }
}
