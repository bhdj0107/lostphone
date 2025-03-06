package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class StateChanged extends AbstractEvent {

    private Long id;

    public StateChanged(LostDevice aggregate) {
        super(aggregate);
    }

    public StateChanged() {
        super();
    }
}
//>>> DDD / Domain Event
