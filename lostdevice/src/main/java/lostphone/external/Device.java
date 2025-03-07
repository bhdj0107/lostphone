package lostphone.external;

import java.util.Date;
import lombok.Data;

@Data
public class Device {

    private Long id;
    private String deviceName;
    private String status;
    private String latitude;
    private String longitude;
    private String information;
}
