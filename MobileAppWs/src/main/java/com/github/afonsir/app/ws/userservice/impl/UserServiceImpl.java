package com.github.afonsir.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.afonsir.app.ws.shared.Utils;
import com.github.afonsir.app.ws.ui.models.request.UserRequestBody;
import com.github.afonsir.app.ws.ui.models.response.UserRest;
import com.github.afonsir.app.ws.userservice.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  Map<String, UserRest> users = new HashMap<>();
  Utils utils;

  public UserServiceImpl() {}

  @Autowired
  public UserServiceImpl(Utils utils) {
    this.utils = utils;
  }

  @Override
  public UserRest createUser(UserRequestBody userRequestBody) {
    String userId = utils.generateUserId();
    UserRest responseUser = new UserRest();

    responseUser.setUserId(userId);
    responseUser.setEmail(userRequestBody.getEmail());
    responseUser.setFirstName(userRequestBody.getFirstName());
    responseUser.setLastName(userRequestBody.getLastName());

    users.put(userId, responseUser);

    return responseUser;
  }
}
