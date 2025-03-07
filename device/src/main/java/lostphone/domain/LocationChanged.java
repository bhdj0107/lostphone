package lostphone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LocationChanged extends AbstractEvent {

    private Long id;
    private String latitude;
    private String longitude;

    public LocationChanged(Device aggregate) {
        super(aggregate);
    }

    public LocationChanged() {
        super();
    }
}
//>>> DDD / Domain Event
