package com.atlyx.cms.repository;

import com.atlyx.cms.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByName(String name);
}
