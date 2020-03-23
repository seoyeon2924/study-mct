package study.mct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.mct.domain.CmsAccount;
import study.mct.domain.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {


}
