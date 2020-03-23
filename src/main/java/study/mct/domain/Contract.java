package study.mct.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class Contract {

  @Id
  @GeneratedValue
  @Column(name ="contract_id")
  private Long id;

}
