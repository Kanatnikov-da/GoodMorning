package com.example.goodmorning.repository;

import com.example.goodmorning.domain.MyUser;
import com.example.goodmorning.domain.entiity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface UserRepo extends CrudRepository<UserEntity, Long > {
    MyUser findByUsername();
}
