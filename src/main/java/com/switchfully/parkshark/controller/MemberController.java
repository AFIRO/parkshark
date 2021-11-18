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
@RequestMapping(path = "/members")
public class MemberController {
    private final MemberService memberService;
    private final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDTO createMember(@RequestBody CreateMemberDTO dto) {
        logger.info("Create member called");
        return memberService.createMember(dto);
    }

    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<MemberDTO> getAllMembers(){
        logger.info("Get all members called");
        return memberService.getAllMembers();
    }

    @GetMapping(produces = "application/json", params = {"memberId"})
    @ResponseStatus(HttpStatus.OK)
    public MemberDTO getSpecificMemberById(@RequestParam(value = "memberId", required = false) String id){
        logger.info("Get specific member called on member id:" + id);
        return memberService.getSpecificMemberById(id);
    }
}
