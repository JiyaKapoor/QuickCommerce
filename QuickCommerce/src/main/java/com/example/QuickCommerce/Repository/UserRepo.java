package com.example.QuickCommerce.Repository;

import com.example.QuickCommerce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
