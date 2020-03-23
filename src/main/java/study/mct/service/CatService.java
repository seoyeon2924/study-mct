package study.mct.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.mct.domain.Cat;
import study.mct.repository.CatRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class CatService {

  private final CatRepository catRepository;

  public Long save(Cat cat) {
    Cat savedCat = catRepository.save(cat);
    return savedCat.getId();
  }

}
