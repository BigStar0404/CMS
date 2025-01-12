package com.atlyx.cms.controller;

import com.atlyx.cms.entity.Membership;
import com.atlyx.cms.entity.User;
import com.atlyx.cms.entity.Club;
import com.atlyx.cms.service.MembershipService;
import com.atlyx.cms.service.UserService;
import com.atlyx.cms.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/memberships")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @Autowired
    private UserService userService;

    @Autowired
    private ClubService clubService;

    // 创建成员关系
    @PostMapping
    public ResponseEntity<Membership> createMembership(@RequestParam Long userId, @RequestParam Long clubId, @RequestParam(required = false) Membership.Role role) {
        Optional<User> userOpt = userService.findByUsername(userId.toString());
        Optional<Club> clubOpt = clubService.findByName(clubId.toString());

        if (!userOpt.isPresent() || !clubOpt.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        User user = userOpt.get();
        Club club = clubOpt.get();

        Optional<Membership> existingMembership = membershipService.findByUserAndClub(user, club);
        if (existingMembership.isPresent()) {
            return ResponseEntity.badRequest().body(null);
        }

        Membership membership = new Membership();
        membership.setUser(user);
        membership.setClub(club);
        if (role != null) {
            membership.setRole(role);
        }
        Membership savedMembership = membershipService.createMembership(membership);
        return ResponseEntity.ok(savedMembership);
    }

    // 获取某个社团的所有成员
    @GetMapping("/club/{clubId}")
    public ResponseEntity<List<Membership>> getMembersByClub(@PathVariable Long clubId) {
        Optional<Club> clubOpt = clubService.findByName(clubId.toString());
        if (!clubOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        List<Membership> memberships = membershipService.findByClub(clubOpt.get());
        return ResponseEntity.ok(memberships);
    }

    // 获取某个用户的所有社团
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Membership>> getMembershipsByUser(@PathVariable Long userId) {
        Optional<User> userOpt = userService.findByUsername(userId.toString());
        if (!userOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        List<Membership> memberships = membershipService.findByUser(userOpt.get());
        return ResponseEntity.ok(memberships);
    }

    // 删除成员关系
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembership(@PathVariable Long id) {
        membershipService.deleteMembership(id);
        return ResponseEntity.noContent().build();
    }

    // 其他成员关系相关的API
}
