package lostphone.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import lostphone.config.kafka.KafkaProcessor;
import lostphone.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeviceControlRepository deviceControlRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostIssueCreated'"
    )
    public void wheneverLostIssueCreated_ChangeDeviceLockness(
        @Payload LostIssueCreated lostIssueCreated
    ) {
        LostIssueCreated event = lostIssueCreated;
        System.out.println(
            "\n\n##### listener ChangeDeviceLockness : " +
            lostIssueCreated +
            "\n\n"
        );

        // Sample Logic //
        DeviceControl.changeDeviceLockness(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostIssueClosed'"
    )
    public void wheneverLostIssueClosed_ChangeDeviceLockness(
        @Payload LostIssueClosed lostIssueClosed
    ) {
        LostIssueClosed event = lostIssueClosed;
        System.out.println(
            "\n\n##### listener ChangeDeviceLockness : " +
            lostIssueClosed +
            "\n\n"
        );

        // Sample Logic //
        DeviceControl.changeDeviceLockness(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ContactModified'"
    )
    public void wheneverContactModified_ChangeDisplayedOwnerContact(
        @Payload ContactModified contactModified
    ) {
        ContactModified event = contactModified;
        System.out.println(
            "\n\n##### listener ChangeDisplayedOwnerContact : " +
            contactModified +
            "\n\n"
        );

        // Sample Logic //
        DeviceControl.changeDisplayedOwnerContact(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeviceInitializeRequested'"
    )
    public void wheneverDeviceInitializeRequested_InitializeDevice(
        @Payload DeviceInitializeRequested deviceInitializeRequested
    ) {
        DeviceInitializeRequested event = deviceInitializeRequested;
        System.out.println(
            "\n\n##### listener InitializeDevice : " +
            deviceInitializeRequested +
            "\n\n"
        );

        // Sample Logic //
        DeviceControl.initializeDevice(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeviceBackupRequested'"
    )
    public void wheneverDeviceBackupRequested_BackupDevice(
        @Payload DeviceBackupRequested deviceBackupRequested
    ) {
        DeviceBackupRequested event = deviceBackupRequested;
        System.out.println(
            "\n\n##### listener BackupDevice : " +
            deviceBackupRequested +
            "\n\n"
        );

        // Sample Logic //
        DeviceControl.backupDevice(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
