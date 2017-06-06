package project170604.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project170604.domain.Nsrxx;

import java.util.List;

/**
 * Created by lyp on 2017/6/6.
 */

@Repository
public interface NsrRepository extends JpaRepository<Nsrxx,Integer>{
    List<Nsrxx> findByDept(String dept);
    Nsrxx findByNsrsbh(String nsrsbh);
}
