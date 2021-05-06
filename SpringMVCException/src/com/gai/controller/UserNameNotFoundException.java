package com.gai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "用户被拒绝", value = HttpStatus.NOT_ACCEPTABLE)
public class UserNameNotFoundException extends RuntimeException {

}
