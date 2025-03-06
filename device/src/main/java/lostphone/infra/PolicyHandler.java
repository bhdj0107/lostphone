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
    DeviceRepository deviceRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostIssueCreated'"
    )
    public void wheneverLostIssueCreated_ChangeStatus(
        @Payload LostIssueCreated lostIssueCreated
    ) {
        LostIssueCreated event = lostIssueCreated;
        System.out.println(
            "\n\n##### listener ChangeStatus : " + lostIssueCreated + "\n\n"
        );

        // Sample Logic //
        Device.changeStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostIssueClosed'"
    )
    public void wheneverLostIssueClosed_ChangeStatus(
        @Payload LostIssueClosed lostIssueClosed
    ) {
        LostIssueClosed event = lostIssueClosed;
        System.out.println(
            "\n\n##### listener ChangeStatus : " + lostIssueClosed + "\n\n"
        );

        // Sample Logic //
        Device.changeStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
