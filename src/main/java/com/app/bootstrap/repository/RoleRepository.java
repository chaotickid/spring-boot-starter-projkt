package com.app.bootstrap.repository;

import java.util.Optional;

import com.app.bootstrap.models.ERole;
import com.app.bootstrap.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
