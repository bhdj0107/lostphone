package lostphone.infra;

import java.util.List;
import lostphone.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "memberInformations",
    path = "memberInformations"
)
public interface MemberInformationRepository
    extends PagingAndSortingRepository<MemberInformation, Long> {}
