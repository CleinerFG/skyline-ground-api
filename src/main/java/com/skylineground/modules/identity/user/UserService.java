package com.skylineground.modules.identity.user;

import com.fasterxml.uuid.impl.TimeBasedEpochGenerator;
import com.skylineground.modules.identity.user.dto.UserRequest;
import com.skylineground.modules.identity.user.dto.UserResponse;
import com.skylineground.modules.identity.user.exception.EmailAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final TimeBasedEpochGenerator uuidGenerator;

    public UserResponse create(UserRequest dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new EmailAlreadyExistsException();
        }

        var user = userMapper.toEntity(dto);
        user.setExternalId(uuidGenerator.generate());

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        var savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }
}
