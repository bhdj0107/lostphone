package lostphone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import lostphone.DevicecontrolApplication;

@Entity
@Table(name = "DeviceControl_table")
@Data
//<<< DDD / Aggregate Root
public class DeviceControl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public static DeviceControlRepository repository() {
        DeviceControlRepository deviceControlRepository = DevicecontrolApplication.applicationContext.getBean(
            DeviceControlRepository.class
        );
        return deviceControlRepository;
    }

    //<<< Clean Arch / Port Method
    public static void changeDeviceLockness(LostIssueCreated lostIssueCreated) {
        //implement business logic here:

        /** Example 1:  new item 
        DeviceControl deviceControl = new DeviceControl();
        repository().save(deviceControl);

        */

        /** Example 2:  finding and process
        

        repository().findById(lostIssueCreated.get???()).ifPresent(deviceControl->{
            
            deviceControl // do something
            repository().save(deviceControl);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void changeDeviceLockness(LostIssueClosed lostIssueClosed) {
        //implement business logic here:

        /** Example 1:  new item 
        DeviceControl deviceControl = new DeviceControl();
        repository().save(deviceControl);

        */

        /** Example 2:  finding and process
        

        repository().findById(lostIssueClosed.get???()).ifPresent(deviceControl->{
            
            deviceControl // do something
            repository().save(deviceControl);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void changeDisplayedOwnerContact(
        ContactModified contactModified
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        DeviceControl deviceControl = new DeviceControl();
        repository().save(deviceControl);

        */

        /** Example 2:  finding and process
        

        repository().findById(contactModified.get???()).ifPresent(deviceControl->{
            
            deviceControl // do something
            repository().save(deviceControl);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void initializeDevice(
        DeviceInitializeRequested deviceInitializeRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        DeviceControl deviceControl = new DeviceControl();
        repository().save(deviceControl);

        */

        /** Example 2:  finding and process
        

        repository().findById(deviceInitializeRequested.get???()).ifPresent(deviceControl->{
            
            deviceControl // do something
            repository().save(deviceControl);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void backupDevice(
        DeviceBackupRequested deviceBackupRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        DeviceControl deviceControl = new DeviceControl();
        repository().save(deviceControl);

        */

        /** Example 2:  finding and process
        

        repository().findById(deviceBackupRequested.get???()).ifPresent(deviceControl->{
            
            deviceControl // do something
            repository().save(deviceControl);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
