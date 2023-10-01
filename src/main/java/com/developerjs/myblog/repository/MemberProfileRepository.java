package com.developerjs.myblog.repository;

import com.developerjs.myblog.entity.MemberProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberProfileRepository extends JpaRepository<MemberProfile, Long> {

    Optional<MemberProfile> findByMemberEmail(String memberEmail);
}
