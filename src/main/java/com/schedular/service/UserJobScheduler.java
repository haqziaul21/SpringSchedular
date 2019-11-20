package com.schedular.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.schedular.model.User;
import com.schedular.repository.UserRepo;

@Service
public class UserJobScheduler {

	Logger logger = LoggerFactory.getLogger(UserJobScheduler.class);

	private final UserRepo userRepo;

	public UserJobScheduler(final UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Scheduled(cron = "0/5 * * * * *")
	private void saveUser() {
		User user = new User();
		user.setName("User" + new Random(1233));

		userRepo.save(user);

		logger.info("User saved {}", new Date());
	}

	@Scheduled(fixedRate = 15000, initialDelay = 15000)
	private void fetchUsers() {
		List<User> users = userRepo.findAll();
		
		logger.error("Users fetched at {}, {}", new Date(), users.size());
	}
}
