package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class IssueModified extends AbstractEvent {

    private Long id;

    public IssueModified(LostDevice aggregate) {
        super(aggregate);
    }

    public IssueModified() {
        super();
    }
}
//>>> DDD / Domain Event
