package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by alexander on 25.12.15.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserById(Integer id);
    User getUserByLogin(String login);


}
