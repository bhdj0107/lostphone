package lostphone.domain;

import lostphone.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "lostDevices",
    path = "lostDevices"
)
public interface LostDeviceRepository
    extends PagingAndSortingRepository<LostDevice, Long> {}
