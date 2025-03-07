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
// @RequestMapping(value="/lostDevices")
@Transactional
public class LostDeviceController {

    @Autowired
    LostDeviceRepository lostDeviceRepository;

    @RequestMapping(
        value = "/lostDevices/{id}/closelost",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8"
    )
    public LostDevice closeLost(
        @PathVariable(value = "id") Long id,
        @RequestBody CloseLostCommand closeLostCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /lostDevice/closeLost  called #####");
        Optional<LostDevice> optionalLostDevice = lostDeviceRepository.findById(
            id
        );

        optionalLostDevice.orElseThrow(() -> new Exception("No Entity Found"));
        LostDevice lostDevice = optionalLostDevice.get();
        lostDevice.closeLost(closeLostCommand);

        lostDeviceRepository.delete(lostDevice);
        return lostDevice;
    }

    @RequestMapping(
        value = "/lostDevices/{id}/changecontact",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public LostDevice changeContact(
        @PathVariable(value = "id") Long id,
        @RequestBody ChangeContactCommand changeContactCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /lostDevice/changeContact  called #####");
        Optional<LostDevice> optionalLostDevice = lostDeviceRepository.findById(
            id
        );

        optionalLostDevice.orElseThrow(() -> new Exception("No Entity Found"));
        LostDevice lostDevice = optionalLostDevice.get();
        lostDevice.changeContact(changeContactCommand);

        lostDeviceRepository.save(lostDevice);
        return lostDevice;
    }

    @RequestMapping(
        value = "/lostDevices/{id}/modifyissue",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public LostDevice modifyIssue(
        @PathVariable(value = "id") Long id,
        @RequestBody ModifyIssueCommand modifyIssueCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /lostDevice/modifyIssue  called #####");
        Optional<LostDevice> optionalLostDevice = lostDeviceRepository.findById(
            id
        );

        optionalLostDevice.orElseThrow(() -> new Exception("No Entity Found"));
        LostDevice lostDevice = optionalLostDevice.get();
        lostDevice.modifyIssue(modifyIssueCommand);

        lostDeviceRepository.save(lostDevice);
        return lostDevice;
    }

    @RequestMapping(
        value = "/lostDevices/{id}/issueacquirement",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public LostDevice issueAcquirement(
        @PathVariable(value = "id") Long id,
        @RequestBody IssueAcquirementCommand issueAcquirementCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /lostDevice/issueAcquirement  called #####");
        Optional<LostDevice> optionalLostDevice = lostDeviceRepository.findById(
            id
        );

        optionalLostDevice.orElseThrow(() -> new Exception("No Entity Found"));
        LostDevice lostDevice = optionalLostDevice.get();
        lostDevice.issueAcquirement(issueAcquirementCommand);

        lostDeviceRepository.save(lostDevice);
        return lostDevice;
    }

    @RequestMapping(
        value = "/lostDevices/triggerinitialize",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public LostDevice triggerInitialize(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody TriggerInitializeCommand triggerInitializeCommand
    ) throws Exception {
        System.out.println("##### /lostDevice/triggerInitialize  called #####");
        LostDevice lostDevice = new LostDevice();
        lostDevice.triggerInitialize(triggerInitializeCommand);
        lostDeviceRepository.save(lostDevice);
        return lostDevice;
    }

    @RequestMapping(
        value = "/lostDevices/backupdevice",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public LostDevice backupDevice(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody BackupDeviceCommand backupDeviceCommand
    ) throws Exception {
        System.out.println("##### /lostDevice/backupDevice  called #####");
        LostDevice lostDevice = new LostDevice();
        lostDevice.backupDevice(backupDeviceCommand);
        lostDeviceRepository.save(lostDevice);
        return lostDevice;
    }
}
//>>> Clean Arch / Inbound Adaptor
