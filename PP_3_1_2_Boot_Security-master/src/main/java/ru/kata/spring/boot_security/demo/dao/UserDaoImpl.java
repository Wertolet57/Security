package ru.kata.spring.boot_security.demo.dao;


import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
    @PersistenceContext()
    private EntityManager entityManager;
    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }
    @Override
    public void update(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }
    @Override
    public void delete(Long id) {
        entityManager.remove(getUser(id));
        entityManager.flush();
    }

    @Override
    public User findByUsername(String username) {
        return (User)entityManager.createQuery("from User u where u.firstname = :name")
                .setParameter("name", username).getResultList().get(0);
    }

}
