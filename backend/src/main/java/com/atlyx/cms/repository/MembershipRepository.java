package com.atlyx.cms.repository;

import com.atlyx.cms.entity.Membership;
import com.atlyx.cms.entity.User;
import com.atlyx.cms.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
    Optional<Membership> findByUserAndClub(User user, Club club);
    List<Membership> findByClub(Club club);
    List<Membership> findByUser(User user);
}
