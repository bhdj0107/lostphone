package lostphone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import lostphone.LostdeviceApplication;
import lostphone.domain.ContactModified;
import lostphone.domain.DeviceBackupRequested;
import lostphone.domain.DeviceInitializeRequested;
import lostphone.domain.IssueModified;
import lostphone.domain.LostIssueClosed;
import lostphone.domain.LostIssueCreated;
import lostphone.domain.StateChanged;

@Entity
@Table(name = "LostDevice_table")
@Data
//<<< DDD / Aggregate Root
public class LostDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long deviceId;

    private Long memberId;

    private String status;

    private String contact;

    @PostPersist
    public void onPostPersist() {
        ContactModified contactModified = new ContactModified(this);
        contactModified.publishAfterCommit();

        IssueModified issueModified = new IssueModified(this);
        issueModified.publishAfterCommit();

        LostIssueCreated lostIssueCreated = new LostIssueCreated(this);
        lostIssueCreated.publishAfterCommit();

        LostIssueClosed lostIssueClosed = new LostIssueClosed(this);
        lostIssueClosed.publishAfterCommit();

        StateChanged stateChanged = new StateChanged(this);
        stateChanged.publishAfterCommit();

        DeviceInitializeRequested deviceInitializeRequested = new DeviceInitializeRequested(
            this
        );
        deviceInitializeRequested.publishAfterCommit();

        DeviceBackupRequested deviceBackupRequested = new DeviceBackupRequested(
            this
        );
        deviceBackupRequested.publishAfterCommit();
    }

    public static LostDeviceRepository repository() {
        LostDeviceRepository lostDeviceRepository = LostdeviceApplication.applicationContext.getBean(
            LostDeviceRepository.class
        );
        return lostDeviceRepository;
    }
}
//>>> DDD / Aggregate Root
