package com.andruha.repository;

import com.andruha.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by andrusha on 29.07.17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserName(String userName);
}
