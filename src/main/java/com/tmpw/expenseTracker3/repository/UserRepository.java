package com.tmpw.expenseTracker3.repository;


import com.tmpw.expenseTracker3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
