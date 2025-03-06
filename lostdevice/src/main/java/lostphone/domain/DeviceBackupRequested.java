package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceBackupRequested extends AbstractEvent {

    private Long id;

    public DeviceBackupRequested(LostDevice aggregate) {
        super(aggregate);
    }

    public DeviceBackupRequested() {
        super();
    }
}
//>>> DDD / Domain Event
