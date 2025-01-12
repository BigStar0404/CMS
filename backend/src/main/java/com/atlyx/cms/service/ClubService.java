package com.atlyx.cms.service;

import com.atlyx.cms.entity.Club;
import com.atlyx.cms.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    // 根据名称查找社团
    public Optional<Club> findByName(String name) {
        return clubRepository.findByName(name);
    }

    // 创建新社团
    public Club createClub(Club club) {
        return clubRepository.save(club);
    }

    // 更新社团信息
    public Club updateClub(Club club) {
        return clubRepository.save(club);
    }

    // 删除社团
    public void deleteClub(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    // 其他社团相关的方法
}
