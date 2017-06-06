package project170604.dao;

import project170604.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lyp on 2017/6/3.
 */

@Repository
public interface UserRepository extends JpaRepository<SysUser, Integer>{

    SysUser findByUsername(String username);

}
