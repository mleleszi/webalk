package hu.me.iit.webalk.demo.service;

import hu.me.iit.webalk.demo.repository.LicitEntity;
import hu.me.iit.webalk.demo.repository.LicitRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LicitServiceImpl implements LicitService {

    private final LicitRepository licitRepository;

    public LicitServiceImpl(LicitRepository licitRepository) {
        this.licitRepository = licitRepository;
    }

    @Override
    public int getHighestBid() {
        Optional<LicitEntity> result = licitRepository.findTopByOrderByLicitDesc();
        if(result.isEmpty()) return 0;
        return result.get().getLicit();

    }

    @Override
    public int getHighestBidForUser(Long userId) {
        Optional<LicitEntity> result = licitRepository.findTopByUserIdAndOrderByLicitDesc(userId);
        if(result.isEmpty()) return 0;
        return result.get().getLicit();
    }

    @Override
    public void saveNewLicit(Long userId, Integer licit) {
        licitRepository.save(new LicitEntity(userId, licit));
    }
}
