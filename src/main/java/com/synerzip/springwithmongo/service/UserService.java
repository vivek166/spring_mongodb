package com.synerzip.springwithmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.WriteResult;
import com.synerzip.springwithmongo.model.User;

@Service
public class UserService {

	@Autowired
	MongoTemplate mongoTemplate;

	public List<User> getUsers() {
		return mongoTemplate.findAll(User.class);
	}

	public void saveUser(User user) {
		mongoTemplate.insert(user);
	}

	public User getUser(int userId) {
		return mongoTemplate.findOne(new Query(Criteria.where("userId").is(userId)),
				User.class);
	}

	public WriteResult updateUser(int userId, User user) {
		return mongoTemplate.updateFirst(
				new Query(Criteria.where("userId").is(userId)),
				Update.update("firstName", user.getFirstName()), User.class);
	}

	public void deleteUser(int userId) {
		mongoTemplate
				.remove(new Query(Criteria.where("userId").is(userId)), User.class);
	}

}