package lostphone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import lostphone.DeviceApplication;
import lostphone.domain.DeviceAssigned;
import lostphone.domain.DeviceDeleted;
import lostphone.domain.LocationChanged;
import lostphone.domain.StatusModified;

@Entity
@Table(name = "Device_table")
@Data
//<<< DDD / Aggregate Root
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String deviceName;

    private String status;

    private String latitude;

    private String longitude;

    private String information;

    @PreRemove
    public void onPreRemove() {
        DeviceDeleted deviceDeleted = new DeviceDeleted(this);
        deviceDeleted.publishAfterCommit();
    }

    public static DeviceRepository repository() {
        DeviceRepository deviceRepository = DeviceApplication.applicationContext.getBean(
            DeviceRepository.class
        );
        return deviceRepository;
    }

    //<<< Clean Arch / Port Method
    public void modifyInform() {
        //implement business logic here:

        InformModified informModified = new InformModified(this);
        informModified.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void changeLocation(ChangeLocationCommand changeLocationCommand) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void changeStatus(LostIssueCreated lostIssueCreated) {
        //implement business logic here:

        /** Example 1:  new item 
        Device device = new Device();
        repository().save(device);

        StatusModified statusModified = new StatusModified(device);
        statusModified.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostIssueCreated.get???()).ifPresent(device->{
            
            device // do something
            repository().save(device);

            StatusModified statusModified = new StatusModified(device);
            statusModified.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void changeStatus(LostIssueClosed lostIssueClosed) {
        //implement business logic here:

        /** Example 1:  new item 
        Device device = new Device();
        repository().save(device);

        StatusModified statusModified = new StatusModified(device);
        statusModified.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostIssueClosed.get???()).ifPresent(device->{
            
            device // do something
            repository().save(device);

            StatusModified statusModified = new StatusModified(device);
            statusModified.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
