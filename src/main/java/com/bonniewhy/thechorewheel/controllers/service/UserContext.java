package com.bonniewhy.thechorewheel.controllers.service;

import com.bonniewhy.thechorewheel.models.User;

public interface UserContext {

    User getCurrentUser();
    void setCurrentUser(User user);

}
