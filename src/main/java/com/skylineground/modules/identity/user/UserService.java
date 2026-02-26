package com.skylineground.modules.identity.user;

import com.skylineground.modules.identity.user.dto.UserRequest;
import com.skylineground.modules.identity.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponse create(UserRequest dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new EmailAlreadyExistsException();
        }

        var user = userMapper.toEntity(dto);

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        var savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }
}
