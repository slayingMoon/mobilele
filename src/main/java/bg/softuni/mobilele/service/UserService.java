package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.UserLoginDto;
import bg.softuni.mobilele.model.dto.UserRegisterDto;
import bg.softuni.mobilele.model.entity.User;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final CurrentUser currentUser;

    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.encoder = encoder;
    }

    public boolean login(UserLoginDto userLoginDto) {
        Optional<User> userOpt = userRepository
                .findByEmail(userLoginDto.getUsername());

        if (userOpt.isEmpty()) {
            LOGGER.info("User with name [{}] not found.", userLoginDto.getUsername());
            return false;
        }

        String rawPassword = userLoginDto.getPassword();
        String encodedPassword = userOpt.get().getPassword();

        boolean success = encoder.matches(rawPassword, encodedPassword);

        if (success) {
            login(userOpt.get());
        }else {
            logout();
        }

        return success;
    }

    private void login(User user) {
        currentUser
                .setLoggedIn(true)
                .setName(user.getFirstName() + " " + user.getLastName());
    }

    public void logout() {
        currentUser.clear();
    }

    public void registerAndLogin(UserRegisterDto userRegisterDto) {
        User newUser = new User()
                .setActive(true)
                .setEmail(userRegisterDto.getEmail())
                .setFirstName(userRegisterDto.getFirstName())
                .setLastName(userRegisterDto.getLastName())
                .setPassword(encoder.encode(userRegisterDto.getPassword()));

        newUser = userRepository.save(newUser);

        login(newUser);
    }
}
