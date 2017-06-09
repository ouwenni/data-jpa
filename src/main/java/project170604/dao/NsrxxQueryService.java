package project170604.dao;

import org.springframework.data.domain.Page;
import project170604.domain.Nsrxx;
import project170604.domain.NsrxxQuery;

/**
 * Created by lyp on 2017/6/8.
 */
public interface NsrxxQueryService {
    Page<Nsrxx> findNsrxxNoCriteria(int page,int size);
    Page<Nsrxx> findNsrxxCriteria(int page, int size, NsrxxQuery nsrxxQuery);
}
