package main.service;

import main.model.User;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
        return Streamable.of(repository.findAll()).stream().collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateUser(long id, User user) {
        User updateUser = new User(user.getName(), user.getAge());
        updateUser.setId(user.getId());
        repository.save(updateUser);
    }


    @Override
    @Transactional
    public void deleteUser(long id) {
        repository.deleteById(id);
    }
}
