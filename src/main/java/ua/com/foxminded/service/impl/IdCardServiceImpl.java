package ua.com.foxminded.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.IdCardDAO;
import ua.com.foxminded.model.IdCard;
import ua.com.foxminded.service.IdCardService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class IdCardServiceImpl implements IdCardService {
    
    private final IdCardDAO idCardDAO;

    @Override
    public IdCard add(IdCard entity) {
        log.debug("method 'add' invoked with parameter '{}'", entity);
        IdCard idCard = idCardDAO.add(entity);
        log.debug("method 'add(IdCard entity)' result: '{}'", idCard);
        return idCard;
    }

    @Override
    public IdCard getById(Integer id) {
        log.debug("method 'getById' invoked with parameter '{}'", id);
        IdCard idCard = idCardDAO.getById(id);
        log.debug("method 'getById(Integer id)' result: '{}'", idCard);
        return idCard;
    }

    @Override
    public List<IdCard> getAll() {
        log.debug("method 'getAll' invoked");
        List<IdCard> idCards = idCardDAO.getAll();
        log.debug("method 'getAll()' result: '{}'", idCards);
        return idCards;
    }

    @Override
    public IdCard update(IdCard entity) {
        log.debug("method 'update' invoked with parameter '{}'", entity);
        IdCard idCard = idCardDAO.update(entity);
        log.debug("method 'update(IdCard entity)' result: '{}'", idCard);
        return idCard;
    }

    @Override
    public void remove(IdCard entity) {
        log.debug("method 'remove' invoked with parameter '{}'", entity);
        idCardDAO.remove(entity);
        log.debug("method 'remove' complete");
    }
}
