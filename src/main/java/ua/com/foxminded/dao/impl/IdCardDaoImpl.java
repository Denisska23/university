package ua.com.foxminded.dao.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.com.foxminded.dao.IdCardDAO;
import ua.com.foxminded.model.IdCard;

import java.util.List;


@RequiredArgsConstructor
public class IdCardDaoImpl implements IdCardDAO {

    private final SessionFactory sessionFactory;

    @Override
    public IdCard add(IdCard idCard) {
        Session session = sessionFactory.getCurrentSession();
        Integer id = (Integer) session.save(idCard);
        return getById(id);
    }

    @Override
    public IdCard getById(Integer id) {
        return sessionFactory.getCurrentSession().get(IdCard.class, id);
    }

    @Override
    public List<IdCard> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM IdCard").list();
    }

    @Override
    public IdCard update(IdCard idCard) {
        sessionFactory.getCurrentSession().update(idCard);
        return getById(idCard.getId());
    }

    @Override
    public void remove(IdCard idCard) {
        sessionFactory.getCurrentSession().delete(idCard);
    }
}
