package com.github.afonsir.app.ws.mobileappws.userservice;

import com.github.afonsir.app.ws.mobileappws.ui.models.request.UserRequestBody;
import com.github.afonsir.app.ws.mobileappws.ui.models.response.UserRest;

public interface UserService {
  UserRest createUser(UserRequestBody userRequestBody);
}
