package study.mct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.mct.domain.CmsAccount;

public interface CmsAccountRepository extends JpaRepository<CmsAccount, Long> {

}
