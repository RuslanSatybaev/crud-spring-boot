package main.service;

import main.model.User;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public User getUser(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void updateUser(long id, User user) {
        User updateUser = repository.findById(id).orElse(null);
        assert updateUser != null;
        updateUser.setName(user.getName());
        updateUser.setAge(user.getAge());
        repository.save(updateUser);
    }


    @Override
    @Transactional
    public void deleteUser(long id) {
        repository.deleteById(id);
    }
}
