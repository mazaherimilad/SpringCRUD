package com.RestApiAngular.Project.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestApiAngular.Project.users.bean.User;

@Repository
public interface UsersRepository extends JpaRepository<User , Long>{
	
	
}
