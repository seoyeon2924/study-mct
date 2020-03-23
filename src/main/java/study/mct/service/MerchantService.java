package study.mct.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.mct.domain.Merchant;
import study.mct.repository.CatRepository;
import study.mct.repository.CmsAccountRepository;
import study.mct.repository.MerchantRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MerchantService {

  private final MerchantRepository merchantRepository;
  private final CmsAccountRepository cmsAccountRepository;
  private final CatRepository catRepository;

  //가맹점 등록
  public Long create(Merchant merchant) {
    Merchant savedMerchant = merchantRepository.save(merchant);
    return savedMerchant.getId();
  }


  public void updateMerchantName(Long id, String merchantName) {
    Optional<Merchant> merchant;
    merchant = merchantRepository.findById(id);
    merchant.get().setMerchantName(merchantName);
  }

  public void updateMerchantCLS(Long id, String merchantCLS) {
    Optional<Merchant> merchant;
    merchant = merchantRepository.findById(id);
    merchant.get().setMerchantCLS(merchantCLS);
  }

  public Merchant findOne(Long id) {
    Optional<Merchant> merchant = merchantRepository.findById(id);
    return merchant.get();
  }

  public List<Merchant> findMerchants(){
    List<Merchant> all = merchantRepository.findAll();
    return all;
  }
}
