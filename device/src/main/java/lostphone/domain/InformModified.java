package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InformModified extends AbstractEvent {

    private Long id;
    private String information;
    private String deviceName;

    public InformModified(Device aggregate) {
        super(aggregate);
    }

    public InformModified() {
        super();
    }
}
//>>> DDD / Domain Event
