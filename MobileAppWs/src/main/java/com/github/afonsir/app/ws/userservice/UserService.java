package com.github.afonsir.app.ws.userservice;

import com.github.afonsir.app.ws.ui.models.request.UserRequestBody;
import com.github.afonsir.app.ws.ui.models.response.UserRest;

public interface UserService {
  UserRest createUser(UserRequestBody userRequestBody);
}
