package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostIssueClosed extends AbstractEvent {

    private Long id;

    public LostIssueClosed(LostDevice aggregate) {
        super(aggregate);
    }

    public LostIssueClosed() {
        super();
    }
}
//>>> DDD / Domain Event
