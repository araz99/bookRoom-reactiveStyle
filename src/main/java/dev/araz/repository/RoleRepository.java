package dev.araz.repository;

import dev.araz.entity.Role;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RoleRepository extends ReactiveCrudRepository<Role, Long> {
}