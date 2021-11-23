package hu.me.iit.webalk.demo.service;

import hu.me.iit.webalk.demo.repository.LicitEntity;
import hu.me.iit.webalk.demo.repository.LicitRepository;
import org.springframework.stereotype.Service;

@Service
public class LicitServiceImpl implements LicitService {

    private final LicitRepository licitRepository;

    public LicitServiceImpl(LicitRepository licitRepository) {
        this.licitRepository = licitRepository;
    }

    @Override
    public int getHighestBid() {
        return licitRepository.findTopByOrderByLicitDesc().getLicit();
    }

    @Override
    public int getHighestBidForUser(Long userId) {
        return licitRepository.findTopByUseridAndOrderByLicitDesc(userId).getLicit();
    }

    @Override
    public void saveNewLicit(Long userId, Integer licit) {
        licitRepository.save(new LicitEntity(userId, licit));
    }
}
