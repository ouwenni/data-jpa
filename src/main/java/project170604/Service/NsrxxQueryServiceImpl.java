package project170604.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project170604.dao.NsrRepository;
import project170604.dao.NsrxxQueryService;
import project170604.domain.Nsrxx;
import project170604.domain.NsrxxQuery;

import javax.annotation.Resource;

/**
 * Created by lyp on 2017/6/8.
 */

@Service
public class NsrxxQueryServiceImpl implements NsrxxQueryService {

    @Resource
    NsrRepository nsrRepository;

    @Override
    public Page<Nsrxx> findNsrxxNoCriteria(int page, int size) {
        Pageable pageable = new PageRequest(page,size);
        return nsrRepository.findAll(pageable);
    }

    @Override
    public Page<Nsrxx> findNsrxxCriteria(int page, int size, NsrxxQuery nsrxxQuery) {
        return null;
    }
}
