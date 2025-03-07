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
public class DeviceInfoViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DeviceInfoRepository deviceInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeviceAssigned_then_CREATE_1(
        @Payload DeviceAssigned deviceAssigned
    ) {
        try {
            if (!deviceAssigned.validate()) return;

            // view 객체 생성
            DeviceInfo deviceInfo = new DeviceInfo();
            // view 객체에 이벤트의 Value 를 set 함
            deviceInfo.setId(deviceAssigned.getId());
            deviceInfo.setDeviceName(deviceAssigned.getDeviceName());
            deviceInfo.setStatus(deviceAssigned.getStatus());
            deviceInfo.setLatitude(deviceAssigned.getLatitude());
            deviceInfo.setLongitude(deviceAssigned.getLongitude());
            deviceInfo.setInformation(deviceAssigned.getInformation());
            // view 레파지 토리에 save
            deviceInfoRepository.save(deviceInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenInformModified_then_UPDATE_1(
        @Payload InformModified informModified
    ) {
        try {
            if (!informModified.validate()) return;
            // view 객체 조회
            Optional<DeviceInfo> deviceInfoOptional = deviceInfoRepository.findById(
                informModified.getId()
            );

            if (deviceInfoOptional.isPresent()) {
                DeviceInfo deviceInfo = deviceInfoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                deviceInfo.setInformation(informModified.getInformation());
                // view 레파지 토리에 save
                deviceInfoRepository.save(deviceInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenStatusModified_then_UPDATE_2(
        @Payload StatusModified statusModified
    ) {
        try {
            if (!statusModified.validate()) return;
            // view 객체 조회
            Optional<DeviceInfo> deviceInfoOptional = deviceInfoRepository.findById(
                statusModified.getId()
            );

            if (deviceInfoOptional.isPresent()) {
                DeviceInfo deviceInfo = deviceInfoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                deviceInfo.setStatus(statusModified.getStatus());
                // view 레파지 토리에 save
                deviceInfoRepository.save(deviceInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLocationChanged_then_UPDATE_3(
        @Payload LocationChanged locationChanged
    ) {
        try {
            if (!locationChanged.validate()) return;
            // view 객체 조회
            Optional<DeviceInfo> deviceInfoOptional = deviceInfoRepository.findById(
                locationChanged.getId()
            );

            if (deviceInfoOptional.isPresent()) {
                DeviceInfo deviceInfo = deviceInfoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                deviceInfo.setLatitude(locationChanged.getLatitude());
                deviceInfo.setLongitude(locationChanged.getLongitude());
                // view 레파지 토리에 save
                deviceInfoRepository.save(deviceInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeviceDeleted_then_DELETE_1(
        @Payload DeviceDeleted deviceDeleted
    ) {
        try {
            if (!deviceDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            deviceInfoRepository.deleteById(deviceDeleted.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
