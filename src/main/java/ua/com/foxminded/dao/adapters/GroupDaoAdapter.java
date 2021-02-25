package ua.com.foxminded.dao.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.GroupDAO;
import ua.com.foxminded.dao.GroupRepo;
import ua.com.foxminded.model.Group;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GroupDaoAdapter implements GroupDAO {

    private final GroupRepo repository;

    @Override
    public Group add(Group group) {
        return repository.save(group);
    }

    @Override
    public Group getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public List<Group> getAll() {
        return repository.findAll();
    }

    @Override
    public Group update(Group group) {
        return repository.save(group);
    }

    @Override
    public void remove(Group group) {
        repository.delete(group);
    }
}
