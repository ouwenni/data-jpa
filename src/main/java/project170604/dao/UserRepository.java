package project170604.dao;

import project170604.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lyp on 2017/6/3.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    User findByUsername(String username);

}
