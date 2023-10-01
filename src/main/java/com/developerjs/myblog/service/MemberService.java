package com.developerjs.myblog.service;

import com.developerjs.myblog.common.FileUtils;
import com.developerjs.myblog.dto.FileDto;
import com.developerjs.myblog.dto.Member;
import com.developerjs.myblog.dto.MemberProfileDto;
import com.developerjs.myblog.entity.MemberEntity;
import com.developerjs.myblog.entity.MemberProfile;
import com.developerjs.myblog.repository.MemberProfileRepository;
import com.developerjs.myblog.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@AllArgsConstructor
@Service
public class MemberService {

    MemberRepository memberRepository;
    MemberProfileRepository memberProfileRepository;

    private PasswordEncoder passwordEncoder;
    private FileUtils fileUtils;

    public void save(Member member){

        member.setMemberPw(passwordEncoder.encode(member.getMemberPw()));
        member.setMemberRegistTime(LocalDateTime.now());


        MemberEntity memberEntity = MemberEntity.builder()
                .email(member.getMemberEmail())
                .password(member.getMemberPw())
                .memberRegistTime(member.getMemberRegistTime())
                .build();

        memberRepository.save(memberEntity);
    }

    public MemberEntity findByMemberId(Long memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected member"));
    }

    public ResponseEntity<?> modifyMemberProfile(MemberProfileDto memberProfileDto, String memberEmail, MultipartFile memberProfilePicture) throws Exception {
        List<FileDto> fileDtos = new ArrayList<>();
        if(memberProfilePicture != null){
            List<MultipartFile> multipartFiles = new ArrayList<>();
            multipartFiles.add(memberProfilePicture);
            fileDtos = fileUtils.parseFileInfo(multipartFiles);
        }
        FileDto fileDto = fileDtos.get(0);

        MemberProfile memberProfile = memberProfileRepository.findByMemberEmail(memberEmail)
                .orElseGet(MemberProfile::createNewProfile);

        memberProfile.setMemberEmail(memberProfileDto.getMemberEmail());
        memberProfile.setMemberName(memberProfileDto.getMemberName());
        memberProfile.setMemberPhone(memberProfileDto.getMemberPhone());
        memberProfile.setMemberCompanyName(memberProfileDto.getMemberCompanyName());
        memberProfile.setMemberDuty(memberProfileDto.getMemberDuty());
        memberProfile.setMemberBiography(memberProfileDto.getMemberBiography());
        memberProfile.setOriginalFileName(fileDto.getOriginalFileName());
        memberProfile.setStoredFilePath(fileDto.getStoredFilePath());
        memberProfile.setImageSourcePath(fileDto.getImageSourcePath());
        memberProfile.setFileSize(fileDto.getFileSize());

        if(memberProfile.getId() == null){
            memberProfile.setCreatedDatetime(String.valueOf(LocalDateTime.now()));
        } else {
            memberProfile.setUpdatedDatetime(String.valueOf(LocalDateTime.now()));
        }

        memberProfileRepository.save(memberProfile);

        return ResponseEntity.ok("프로필 변경 완료");
    }

    public MemberProfileDto getProfile(String userEmail) {
        MemberProfile memberProfile = memberProfileRepository.findByMemberEmail(userEmail).orElseGet(MemberProfile::createNewProfile);
        MemberProfileDto memberProfileDto = getMemberProfileDto(memberProfile, userEmail);
        return memberProfileDto;
    }

    private static MemberProfileDto getMemberProfileDto(MemberProfile memberProfile, String memberEmail) {
        MemberProfileDto memberProfileDto = new MemberProfileDto();
        memberProfileDto.setMemberEmail(memberEmail);
        memberProfileDto.setMemberName(memberProfile.getMemberName());
        memberProfileDto.setMemberPhone(memberProfile.getMemberPhone());
        memberProfileDto.setMemberCompanyName(memberProfile.getMemberCompanyName());
        memberProfileDto.setMemberDuty(memberProfile.getMemberDuty());
        memberProfileDto.setMemberBiography(memberProfile.getMemberBiography());
        memberProfileDto.setImageSourcePath(memberProfile.getImageSourcePath());
        return memberProfileDto;
    }
}
