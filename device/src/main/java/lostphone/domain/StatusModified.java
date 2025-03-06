package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class StatusModified extends AbstractEvent {

    private Long id;

    public StatusModified(Device aggregate) {
        super(aggregate);
    }

    public StatusModified() {
        super();
    }
}
//>>> DDD / Domain Event
