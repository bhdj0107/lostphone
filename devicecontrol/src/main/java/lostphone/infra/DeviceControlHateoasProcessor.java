package lostphone.infra;

import lostphone.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DeviceControlHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DeviceControl>> {

    @Override
    public EntityModel<DeviceControl> process(
        EntityModel<DeviceControl> model
    ) {
        return model;
    }
}
