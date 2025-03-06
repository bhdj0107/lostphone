package lostphone.domain;

import java.util.*;
import lombok.*;
import lostphone.domain.*;
import lostphone.infra.AbstractEvent;

@Data
@ToString
public class DeviceBackupRequested extends AbstractEvent {

    private Long id;
}
