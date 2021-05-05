package dev.araz.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRole {
    @Query("INSERT INTO user_role (user_id, role_id) values (:userId, :roleId)")
    void insert(Long userId, Long roleId);

    @Query("DELETE FROM user_role WHERE user_id = :userId, role_id = :roleId")
    void delete(Long userId, Long roleId);
}
