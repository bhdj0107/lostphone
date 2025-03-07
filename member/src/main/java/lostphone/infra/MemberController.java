package lostphone.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import lostphone.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/members")
@Transactional
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @RequestMapping(
        value = "/members/memberlogin",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Member memberLogin(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody MemberLoginCommand memberLoginCommand
    ) throws Exception {
        System.out.println("##### /member/memberLogin  called #####");
        Member member = new Member();
        member.memberLogin(memberLoginCommand);
        memberRepository.save(member);
        return member;
    }
}
//>>> Clean Arch / Inbound Adaptor
