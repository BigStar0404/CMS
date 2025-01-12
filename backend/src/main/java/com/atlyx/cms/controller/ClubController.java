package com.atlyx.cms.controller;

import com.atlyx.cms.entity.Club;
import com.atlyx.cms.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {

    @Autowired
    private ClubService clubService;

    // 获取社团信息通过名称
    @GetMapping("/{name}")
    public ResponseEntity<Club> getClubByName(@PathVariable String name) {
        Optional<Club> clubOpt = clubService.findByName(name);
        return clubOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 创建新社团
    @PostMapping
    public ResponseEntity<Club> createClub(@RequestBody Club club) {
        Club savedClub = clubService.createClub(club);
        return ResponseEntity.ok(savedClub);
    }

    // 更新社团信息
    @PutMapping("/{id}")
    public ResponseEntity<Club> updateClub(@PathVariable Long id, @RequestBody Club clubDetails) {
        Optional<Club> clubOpt = clubService.findByName(clubDetails.getName());
        if (!clubOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Club club = clubOpt.get();
        // 更新字段
        club.setDescription(clubDetails.getDescription());
        // 其他字段更新
        Club updatedClub = clubService.updateClub(club);
        return ResponseEntity.ok(updatedClub);
    }

    // 删除社团
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable Long id) {
        clubService.deleteClub(id);
        return ResponseEntity.noContent().build();
    }

    // 其他社团相关的API
}
