package com.UserJpa.UserJPa.Repository;

import com.UserJpa.UserJPa.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
