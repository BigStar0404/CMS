package com.atlyx.cms.controller;

import com.atlyx.cms.entity.User;
import com.atlyx.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 获取用户信息通过用户名
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> userOpt = userService.findByUsername(username);
        return userOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 创建新用户
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // 在此处可以添加输入验证和密码加密
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // 更新用户信息
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        Optional<User> userOpt = userService.findByUsername(userDetails.getUsername());
        if (!userOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        User user = userOpt.get();
        // 更新字段
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());
        // 其他字段更新
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // 其他用户相关的API
}
