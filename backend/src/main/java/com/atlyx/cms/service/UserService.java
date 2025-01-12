package com.atlyx.cms.service;

import com.atlyx.cms.entity.User;
import com.atlyx.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 根据用户名查找用户
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // 根据邮箱查找用户
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // 创建新用户
    public User createUser(User user) {
        // 这里可以添加密码加密逻辑，例如使用 BCrypt
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // 更新用户信息
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // 删除用户
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    // 其他用户相关的方法
}
