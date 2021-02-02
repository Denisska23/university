package ua.com.foxminded.dao.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.com.foxminded.dao.GroupDAO;
import ua.com.foxminded.model.Group;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GroupDaoImpl implements GroupDAO {

    private final SessionFactory sessionFactory;

    @Override
    public Group add(Group group) {
        Session session = sessionFactory.getCurrentSession();
        Integer id = (Integer) session.save(group);
        return getById(id);
    }

    @Override
    public Group getById(Integer id) {
        return sessionFactory.getCurrentSession().get(Group.class, id);
    }

    @Override
    public List<Group> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Group").list();
    }

    @Override
    @Nullable
    public Group update(Group group) {
        sessionFactory.getCurrentSession().update(group);
        return getById(group.getId());
    }

    @Override
    public void remove(Group group) {
        sessionFactory.getCurrentSession().delete(group);
    }
}
