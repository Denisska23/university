package ua.com.foxminded.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.GroupDAO;
import ua.com.foxminded.exceptions.NotFoundException;
import ua.com.foxminded.exceptions.NotModifiedException;
import ua.com.foxminded.model.Group;
import ua.com.foxminded.service.GroupService;

import java.util.List;

import static java.util.Optional.ofNullable;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    
    private final GroupDAO groupDAO;

    @Override
    public Group add(Group entity) {
        log.debug("method 'add' invoked with parameter '{}'", entity);
        Group group = groupDAO.add(entity);
        log.debug("method 'add(Group entity)' result: '{}'", group);
        return group;
    }

    @Override
    public Group getById(Integer id) {
        log.debug("method 'getById' invoked with parameter '{}'", id);
        Group group = groupDAO.getById(id);
        log.debug("method 'getById(Integer id)' result: '{}'", group);
        return ofNullable(group)
                .orElseThrow(() -> new NotFoundException(String.format("Group with id %s not found!", id)));
    }

    @Override
    public List<Group> getAll() {
        log.debug("method 'getAll' invoked");
        List<Group> groups = groupDAO.getAll();
        log.debug("method 'getAll()' result: '{}'", groups);
        return ofNullable(groups)
                .orElseThrow(() -> new NotFoundException("List of groups is empty!"));
    }

    @Override
    public Group update(Group entity) {
        log.debug("method 'update' invoked with parameter '{}'", entity);
        Group group = groupDAO.update(entity);
        log.debug("method 'update(Group entity)' result: '{}'", group);
        return ofNullable(group)
                .orElseThrow(() -> new NotModifiedException("Group is not modified!"));
    }

    @Override
    public void remove(Group entity) {
        log.debug("method 'remove' invoked with parameter '{}'", entity);
        groupDAO.remove(entity);
        log.debug("method 'remove(Group entity)' complete");
    }
}
