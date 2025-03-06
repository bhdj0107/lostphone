package lostphone.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import lostphone.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/devices")
@Transactional
public class DeviceController {

    @Autowired
    DeviceRepository deviceRepository;

    @RequestMapping(
        value = "/devices/{id}/modifyinform",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Device modifyInform(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /device/modifyInform  called #####");
        Optional<Device> optionalDevice = deviceRepository.findById(id);

        optionalDevice.orElseThrow(() -> new Exception("No Entity Found"));
        Device device = optionalDevice.get();
        device.modifyInform();

        deviceRepository.save(device);
        return device;
    }

    @RequestMapping(
        value = "/devices/{id}/changelocation",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Device changeLocation(
        @PathVariable(value = "id") Long id,
        @RequestBody ChangeLocationCommand changeLocationCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /device/changeLocation  called #####");
        Optional<Device> optionalDevice = deviceRepository.findById(id);

        optionalDevice.orElseThrow(() -> new Exception("No Entity Found"));
        Device device = optionalDevice.get();
        device.changeLocation(changeLocationCommand);

        deviceRepository.save(device);
        return device;
    }
}
//>>> Clean Arch / Inbound Adaptor
