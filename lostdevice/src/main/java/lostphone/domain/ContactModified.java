package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ContactModified extends AbstractEvent {

    private Long id;

    public ContactModified(LostDevice aggregate) {
        super(aggregate);
    }

    public ContactModified() {
        super();
    }
}
//>>> DDD / Domain Event
