package lostphone.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "device", url = "${api.url.device}")
public interface DeviceInfoService {
    @GetMapping(path = "/deviceInfos")
    public List<DeviceInfo> getDeviceInfo();

    @GetMapping(path = "/deviceInfos/{id}")
    public DeviceInfo getDeviceInfo(@PathVariable("id") Long id);
}
