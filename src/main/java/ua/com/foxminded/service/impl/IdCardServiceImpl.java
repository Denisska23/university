package ua.com.foxminded.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.IdCardDAO;
import ua.com.foxminded.model.IdCard;
import ua.com.foxminded.service.IdCardService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IdCardServiceImpl implements IdCardService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IdCardServiceImpl.class);

    private final IdCardDAO idCardDAO;

    @Override
    public IdCard add(IdCard entity) {
        LOGGER.debug("method 'add' invoked with parameter '{}'", entity);
        IdCard idCard = idCardDAO.add(entity);
        LOGGER.debug("method 'add(IdCard entity)' result: '{}'", idCard);
        return idCard;
    }

    @Override
    public IdCard getById(Integer id) {
        LOGGER.debug("method 'getById' invoked with parameter '{}'", id);
        IdCard idCard = idCardDAO.getById(id);
        LOGGER.debug("method 'getById(Integer id)' result: '{}'", idCard);
        return idCard;
    }

    @Override
    public List<IdCard> getAll() {
        LOGGER.debug("method 'getAll' invoked");
        List<IdCard> idCards = idCardDAO.getAll();
        LOGGER.debug("method 'getAll()' result: '{}'", idCards);
        return idCards;
    }

    @Override
    public IdCard update(IdCard entity) {
        LOGGER.debug("method 'update' invoked with parameter '{}'", entity);
        IdCard idCard = idCardDAO.update(entity);
        LOGGER.debug("method 'update(IdCard entity)' result: '{}'", idCard);
        return idCard;
    }

    @Override
    public void remove(IdCard entity) {
        LOGGER.debug("method 'remove' invoked with parameter '{}'", entity);
        idCardDAO.remove(entity);
        LOGGER.debug("method 'remove' complete");
    }
}
