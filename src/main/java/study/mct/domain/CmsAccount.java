package study.mct.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CmsAccount {

  @Id
  @Column(name = "account_id")
  private String id;

  @OneToOne(mappedBy = "cmsAccount")
  private Merchant merchant;
}
