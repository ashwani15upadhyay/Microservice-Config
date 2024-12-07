package com.User_Service.User_Service.repositories;

import com.User_Service.User_Service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
