package ua.com.foxminded.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.com.foxminded.dao.GroupDAO;
import ua.com.foxminded.model.Group;
import ua.com.foxminded.service.GroupService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupServiceImpl.class);

    private final GroupDAO groupDAO;

    @Override
    @Transactional
    public Group add(Group entity) {
        LOGGER.debug("method 'add' invoked with parameter '{}'", entity);
        Group group = groupDAO.add(entity);
        LOGGER.debug("method 'add(Group entity)' result: '{}'", group);
        return group;
    }

    @Override
    @Transactional
    public Group getById(Integer id) {
        LOGGER.debug("method 'getById' invoked with parameter '{}'", id);
        Group group = groupDAO.getById(id);
        LOGGER.debug("method 'getById(Integer id)' result: '{}'", group);
        return group;
    }

    @Override
    @Transactional
    public List<Group> getAll() {
        LOGGER.debug("method 'getAll' invoked");
        List<Group> groups = groupDAO.getAll();
        LOGGER.debug("method 'getAll()' result: '{}'", groups);
        return groups;
    }

    @Override
    @Transactional
    public Group update(Group entity) {
        LOGGER.debug("method 'update' invoked with parameter '{}'", entity);
        Group group = groupDAO.update(entity);
        LOGGER.debug("method 'update(Group entity)' result: '{}'", group);
        return group;
    }

    @Override
    @Transactional
    public void remove(Group entity) {
        LOGGER.debug("method 'remove' invoked with parameter '{}'", entity);
        groupDAO.remove(entity);
        LOGGER.debug("method 'remove(Group entity)' complete");
    }
}
