package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.id= :id", User.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery(
                "SELECT u FROM User u", User.class
        ).getResultList();
    }

    @Override
    public void updateUser(int id, User user) {


        User userUpdated = getUser(id);

        userUpdated.setName(user.getName());
        userUpdated.setAge(user.getAge());

    }

    @Override
    public void deleteUser(int id) {
        Query query = entityManager.createQuery(
                "DELETE FROM User u WHERE u.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
