package lostphone.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "DeviceStatus_table")
@Data
public class DeviceStatus {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
