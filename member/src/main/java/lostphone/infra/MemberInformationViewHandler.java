package lostphone.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import lostphone.config.kafka.KafkaProcessor;
import lostphone.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MemberInformationViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MemberInformationRepository memberInformationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenMemberRegistered_then_CREATE_1(
        @Payload MemberRegistered memberRegistered
    ) {
        try {
            if (!memberRegistered.validate()) return;

            // view 객체 생성
            MemberInformation memberInformation = new MemberInformation();
            // view 객체에 이벤트의 Value 를 set 함
            memberInformation.setId(memberRegistered.getId());
            // view 레파지 토리에 save
            memberInformationRepository.save(memberInformation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
