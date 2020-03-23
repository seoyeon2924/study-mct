package study.mct.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.mct.domain.CmsAccount;
import study.mct.domain.Merchant;
import study.mct.repository.CmsAccountRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class CmsAccountService {

  private final CmsAccountRepository cmsAccountRepository;

  //가맹점 등록
  public String create(CmsAccount cmsAccount) {
    CmsAccount sevedcmsAccount = cmsAccountRepository.save(cmsAccount);
    return sevedcmsAccount.getId();
  }
}
