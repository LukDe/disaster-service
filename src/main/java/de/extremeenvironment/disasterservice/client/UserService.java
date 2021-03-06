package de.extremeenvironment.disasterservice.client;

import de.extremeenvironment.disasterservice.domain.User;
import de.extremeenvironment.disasterservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by on 10.07.16.
 *
 * @author David Steiman
 */
@Service
public class UserService {
    private UserClient userClient;

    private UserRepository userRepository;

    @Inject
    public UserService(UserClient userClient, UserRepository userRepository) {
        this.userClient = userClient;
        this.userRepository = userRepository;
    }

    public User findOrCreateById(Long id) {
        return userRepository
            .findOneByUserId(id)
            .orElseGet(() -> userRepository.save(new User(userClient.getUserById(id).getId())));
    }

    public User findOrCreateByName(String name) {
        User user = userClient.getUserByName(name);
        return findOrCreateById(user.getId());
    }
}
