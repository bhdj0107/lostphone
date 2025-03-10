package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceAssigned extends AbstractEvent {

    private Long id;

    public DeviceAssigned(Device aggregate) {
        super(aggregate);
    }

    public DeviceAssigned() {
        super();
    }
}
//>>> DDD / Domain Event
