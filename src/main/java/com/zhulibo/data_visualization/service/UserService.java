package com.zhulibo.data_visualization.service;

import com.zhulibo.data_visualization.entity.User;
import com.zhulibo.data_visualization.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Transactional
    public User registerUser(User user) throws Exception {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new Exception("用户名已存在");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new Exception("邮箱已注册");
        }
        // 加密密码
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User authenticate(String username, String rawPassword) throws Exception {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new Exception("用户不存在"));
        if (passwordEncoder.matches(rawPassword, user.getPassword())) {
            return user;
        } else {
            throw new Exception("密码错误");
        }
    }
}