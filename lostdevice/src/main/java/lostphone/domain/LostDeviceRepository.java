package lostphone.domain;

import java.util.Date;
import java.util.List;
import lostphone.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "lostDevices",
    path = "lostDevices"
)
public interface LostDeviceRepository
    extends PagingAndSortingRepository<LostDevice, Long> {}
