package com.synerzip.springwithmongo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.synerzip.springwithmongo.model.User;
import com.synerzip.springwithmongo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> gets() {
		return userService.getUsers();

	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User get(@PathVariable int userId) {
		return userService.getUser(userId);
	}

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public String add(@RequestBody User user) {
		userService.saveUser(user);
		return "record saved!!";
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT, headers = "Accept=application/json")
	@ResponseBody
	public String update(@RequestBody User user, @PathVariable int userId) {
		userService.updateUser(userId, user);
		return "record updated!!";
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable int userId) {
		userService.deleteUser(userId);
		return "user deleted";
	}
}
