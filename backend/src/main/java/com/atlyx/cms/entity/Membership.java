// src/main/java/com/atlyx/cms/entity/Membership.java

package com.atlyx.cms.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Memberships", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "club_id"})
})
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 关联用户
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 关联社团
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.MEMBER;

    @Column(nullable = false, updatable = false)
    private LocalDateTime joined_at;

    // 枚举类型定义
    public enum Role {
        PRESIDENT,
        VICE_PRESIDENT,
        MEMBER
    }

    // 构造函数
    public Membership() {}

    public Membership(User user, Club club, Role role) {
        this.user = user;
        this.club = club;
        this.role = role;
    }

    // Getter 和 Setter 方法

    public Long getId() {
        return id;
    }

    // 通常不需要为 ID 提供 Setter，因为它是自动生成的
    // 如果需要，可以取消注释以下方法
    /*
    public void setId(Long id) {
        this.id = id;
    }
    */

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getJoined_at() {
        return joined_at;
    }

    public void setJoined_at(LocalDateTime joined_at) {
        this.joined_at = joined_at;
    }

    // 生命周期回调方法
    @PrePersist
    protected void onCreate() {
        this.joined_at = LocalDateTime.now();
    }
}
