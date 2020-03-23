package study.mct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.mct.domain.Cat;

public interface CatRepository extends JpaRepository<Cat, Long> {

}
