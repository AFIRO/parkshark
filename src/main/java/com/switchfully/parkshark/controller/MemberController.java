package com.switchfully.parkshark.controller;

import com.switchfully.parkshark.dto.CreateMemberDTO;
import com.switchfully.parkshark.dto.MemberDTO;
import com.switchfully.parkshark.service.MemberService;
import com.switchfully.parkshark.switchsecure.SecurityGuard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "members")
public class MemberController {
    private final MemberService memberService;
    private final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public MemberDTO createMember(@RequestBody CreateMemberDTO createMemberDTO) {
        logger.info("Attempting to create a member.");
        return memberService.createMember(createMemberDTO);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public List<MemberDTO> getAllMembers(){
        logger.info("Attempting to get all members.");
        return memberService.getAllMembers();
    }

    @GetMapping(path = "/{memberId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public MemberDTO getSpecificMemberById(@PathVariable int memberId){
        logger.info("Attempting to get specific member called on member id:" + memberId);
        return memberService.getSpecificMemberById(memberId);
    }
}
