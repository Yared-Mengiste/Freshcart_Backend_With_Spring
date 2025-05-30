package com.shop.freshcart.repository;

import com.shop.freshcart.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE LOWER(u.subcity) = LOWER(:subcity) " +
            "AND (u.accountType.id = 3 OR LOWER(u.accountType.name) = 'driver')")
    List<User> findDriversBySubcity(@Param("subcity") String subcity);

}
