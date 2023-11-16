package com.branddealshubdevverse.employeemgtsystemBE.data.repositories;

import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
