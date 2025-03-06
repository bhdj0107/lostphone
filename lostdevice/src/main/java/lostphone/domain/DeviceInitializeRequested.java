package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceInitializeRequested extends AbstractEvent {

    private Long id;

    public DeviceInitializeRequested(LostDevice aggregate) {
        super(aggregate);
    }

    public DeviceInitializeRequested() {
        super();
    }
}
//>>> DDD / Domain Event
