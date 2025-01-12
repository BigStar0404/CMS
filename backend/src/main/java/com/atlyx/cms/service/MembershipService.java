package com.atlyx.cms.service;

import com.atlyx.cms.entity.Membership;
import com.atlyx.cms.entity.User;
import com.atlyx.cms.entity.Club;
import com.atlyx.cms.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    // 根据用户和社团查找成员关系
    public Optional<Membership> findByUserAndClub(User user, Club club) {
        return membershipRepository.findByUserAndClub(user, club);
    }

    // 根据社团查找所有成员关系
    public List<Membership> findByClub(Club club) {
        return membershipRepository.findByClub(club);
    }

    // 根据用户查找所有成员关系
    public List<Membership> findByUser(User user) {
        return membershipRepository.findByUser(user);
    }

    // 创建新成员关系
    public Membership createMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

    // 更新成员关系
    public Membership updateMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

    // 删除成员关系
    public void deleteMembership(Long membershipId) {
        membershipRepository.deleteById(membershipId);
    }

    // 其他成员关系相关的方法
}
