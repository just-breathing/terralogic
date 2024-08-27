package assessment.terralogic.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import assessment.terralogic.authentication.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUserName(String username);
    @Modifying
    @Query(value = "UPDATE users SET user_name = :newUsername WHERE user_name = :oldUsername", nativeQuery = true)
    void updateUsername(@Param("oldUsername") String oldUsername, @Param("newUsername") String newUsername);

  
}