package com.guilhermecamara.taskapi.repository;

import com.guilhermecamara.taskapi.model.UserT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserT, Long> {
    UserT findByUsername(String username);
}
