package com.api.rest.test.adn.TestAdnApiRest.dao;

import com.api.rest.test.adn.TestAdnApiRest.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Juan Aranda
 */
public interface IUsersRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    public User getUserByAuthtenticate( @Param("username") String userName,@Param("password") String pass);

    @Query(value = "select count(*) from USERS WHERE USERNAME = :username", nativeQuery = true)
    public Long countUser(@Param("username") String userName);

    @Query(value = "SELECT u FROM User u Where u.username = :username")
    public User getUserByUsername(@Param("username") String userName);
}
