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
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/closelost")
                .withRel("closelost")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/changecontact")
                .withRel("changecontact")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/modifyissue")
                .withRel("modifyissue")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/issueacquirement"
                )
                .withRel("issueacquirement")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/triggerinitialize"
                )
                .withRel("triggerinitialize")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/backupdevice")
                .withRel("backupdevice")
        );

        return model;
    }
}
