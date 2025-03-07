package lostphone.domain;

import lostphone.domain.LostIssueCreated;
import lostphone.LostdeviceApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;


@Entity
@Table(name="LostDevice_table")
@Data

//<<< DDD / Aggregate Root
public class LostDevice  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private Long deviceId;
    
    
    
    
    private Long memberId;
    
    
    
    
    private String status;
    
    
    
    
    private String contact;

    @PostPersist
    public void onPostPersist(){
    Device device = LostDeviceApplication.applicationContext
        .getBean(lostphone.external.DeviceService.class)
        .deviceInfo(get??);


        LostIssueCreated lostIssueCreated = new LostIssueCreated(this);
        lostIssueCreated.publishAfterCommit();

    
    }

    public static LostDeviceRepository repository(){
        LostDeviceRepository lostDeviceRepository = LostdeviceApplication.applicationContext.getBean(LostDeviceRepository.class);
        return lostDeviceRepository;
    }



//<<< Clean Arch / Port Method
    public void closeLost(CloseLostCommand closeLostCommand){
        
        //implement business logic here:
        


        LostIssueClosed lostIssueClosed = new LostIssueClosed(this);
        lostIssueClosed.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void changeContact(ChangeContactCommand changeContactCommand){
        
        //implement business logic here:
        


        ContactModified contactModified = new ContactModified(this);
        contactModified.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void modifyIssue(ModifyIssueCommand modifyIssueCommand){
        
        //implement business logic here:
        


        IssueModified issueModified = new IssueModified(this);
        issueModified.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void issueAcquirement(IssueAcquirementCommand issueAcquirementCommand){
        
        //implement business logic here:
        


        StateChanged stateChanged = new StateChanged(this);
        stateChanged.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void triggerInitialize(TriggerInitializeCommand triggerInitializeCommand){
        
        //implement business logic here:
        


        DeviceInitializeRequested deviceInitializeRequested = new DeviceInitializeRequested(this);
        deviceInitializeRequested.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void backupDevice(BackupDeviceCommand backupDeviceCommand){
        
        //implement business logic here:
        


        DeviceBackupRequested deviceBackupRequested = new DeviceBackupRequested(this);
        deviceBackupRequested.publishAfterCommit();
    }
//>>> Clean Arch / Port Method



}
//>>> DDD / Aggregate Root
