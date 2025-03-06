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
    NotificationRepository notificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StateChanged'"
    )
    public void wheneverStateChanged_Notify2Owner(
        @Payload StateChanged stateChanged
    ) {
        StateChanged event = stateChanged;
        System.out.println(
            "\n\n##### listener Notify2Owner : " + stateChanged + "\n\n"
        );

        // Sample Logic //
        Notification.notify2Owner(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LocationChanged'"
    )
    public void wheneverLocationChanged_Notify2Owner(
        @Payload LocationChanged locationChanged
    ) {
        LocationChanged event = locationChanged;
        System.out.println(
            "\n\n##### listener Notify2Owner : " + locationChanged + "\n\n"
        );

        // Sample Logic //
        Notification.notify2Owner(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
