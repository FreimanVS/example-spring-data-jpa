package com.vfreiman.lessons.springdataexamples.dao;

import com.vfreiman.lessons.springdataexamples.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

}
