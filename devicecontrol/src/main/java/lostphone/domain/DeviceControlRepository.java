package lostphone.domain;

import lostphone.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "deviceControls",
    path = "deviceControls"
)
public interface DeviceControlRepository
    extends PagingAndSortingRepository<DeviceControl, Long> {}
