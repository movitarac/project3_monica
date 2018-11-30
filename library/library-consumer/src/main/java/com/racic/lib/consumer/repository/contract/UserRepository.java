package com.racic.lib.consumer.repository.contract;

import com.racic.lib.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
