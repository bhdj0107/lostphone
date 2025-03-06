package lostphone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import lostphone.MemberApplication;
import lostphone.domain.MemberLogined;
import lostphone.domain.MemberRegistered;

@Entity
@Table(name = "Member_table")
@Data
//<<< DDD / Aggregate Root
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String contact;

    @PostPersist
    public void onPostPersist() {
        MemberRegistered memberRegistered = new MemberRegistered(this);
        memberRegistered.publishAfterCommit();

        MemberLogined memberLogined = new MemberLogined(this);
        memberLogined.publishAfterCommit();
    }

    public static MemberRepository repository() {
        MemberRepository memberRepository = MemberApplication.applicationContext.getBean(
            MemberRepository.class
        );
        return memberRepository;
    }
}
//>>> DDD / Aggregate Root
