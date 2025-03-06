package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class MemberRegistered extends AbstractEvent {

    private Long id;

    public MemberRegistered(Member aggregate) {
        super(aggregate);
    }

    public MemberRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
