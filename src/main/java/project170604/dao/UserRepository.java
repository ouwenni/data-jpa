package project170604.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import project170604.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by lyp on 2017/6/3.
 */

@Repository
public interface UserRepository extends JpaRepository<SysUser, Integer>{

    SysUser findByUsername(String username);

    @Query(value = "select u.* from sysUser u where u.dept like %?1%" ,nativeQuery=true)
    List<SysUser> findAllByDeptLike(String dept);

    @Modifying
    @Query(value = "update datajpa.sysuser set username = ?1 , cname = ?2 , password = ?3, dept = ?4 where id = ?5",nativeQuery = true)
    @Transactional
    void updateById(String username,String cname, String password,String dept,int id);

    @Modifying
    @Transactional
    void deleteSysUserByUsername(String username);

}
