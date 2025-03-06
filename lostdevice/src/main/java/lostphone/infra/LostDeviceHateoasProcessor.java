package lostphone.infra;

import lostphone.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class LostDeviceHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<LostDevice>> {

    @Override
    public EntityModel<LostDevice> process(EntityModel<LostDevice> model) {
        return model;
    }
}
