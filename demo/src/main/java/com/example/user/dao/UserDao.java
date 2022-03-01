package com.example.user.dao;

import com.example.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository< UserEntity, Long > {
    UserEntity findByUsername(String Username);
    UserEntity findByUsernameAndPhoneNo(String username , Long phoneNo);

}
