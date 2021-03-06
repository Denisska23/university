package ua.com.foxminded.dao.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.IdCardDAO;
import ua.com.foxminded.dao.IdCardRepo;
import ua.com.foxminded.model.IdCard;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class IdCardDaoAdapter implements IdCardDAO {

    private final IdCardRepo repository;

    @Override
    public IdCard add(IdCard idCard) {
        return repository.save(idCard);
    }

    @Override
    public IdCard getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<IdCard> getAll() {
        return repository.findAll();
    }

    @Override
    public IdCard update(IdCard idCard) {
        return repository.save(idCard);
    }

    @Override
    public void remove(IdCard idCard) {
        repository.delete(idCard);
    }
}
