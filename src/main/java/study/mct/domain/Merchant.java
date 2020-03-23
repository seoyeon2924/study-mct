package study.mct.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import study.mct.domain.status.CreditStatus;
import study.mct.domain.status.PrgStatus;

@Entity
@Getter
@Setter
public class Merchant {

  @Id
  @GeneratedValue
  @Column(name = "merchant_no")
  private Long id;

  private String merchantName; // 가맹점명
  private String merchantCLS; // 가맹점분류
  private String merchantFlag; // 가맹점구분
  private String merchant;

  private Long coopcoCode;

  @Enumerated
  private CreditStatus creditStatus; // 신용상태

  @Enumerated
  private PrgStatus prgStatus; // 진행상태

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "account_id")
  private CmsAccount cmsAccount;

  @OneToMany(mappedBy = "merchant")
  private List<Cat> cats = new ArrayList<>();


}
