package com.taemin.chat.user.repository;

import com.taemin.chat.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndProvider(String email, String provider);

}
