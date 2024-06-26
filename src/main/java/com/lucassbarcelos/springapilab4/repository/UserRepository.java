package com.lucassbarcelos.springapilab4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lucassbarcelos.springapilab4.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> getByName(String name);

    @Query("select u from User u where u.name = ?1")
    public Optional<User> getByNameQuery(String name);

    public List<User> getByNameContainsIgnoreCase(String name);

    @Query("select u from User u where u.name like %?1%")
    public List<User> getByNameLike(String name);

    public Optional<User> getByNameAndPassword(String name, String pasword);

    @Query("select u from User u where u.name = ?1 and u.password = ?2")
    public Optional<User> getByNameAndPasswordQuery(String name, String pasword);

    public List<User> getByAuthorizationsName(String authName);

    @Query("select u from User u join u.authorizations a where a.name = ?1")
    public List<User> getByAuthorizationsNameQuery(String authName);

    public Integer countByNameContains(String name);
}
