package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostIssueCreated extends AbstractEvent {

    private Long id;

    public LostIssueCreated(LostDevice aggregate) {
        super(aggregate);
    }

    public LostIssueCreated() {
        super();
    }
}
//>>> DDD / Domain Event
