package com.bootcamp.demo.bc_mtr_station.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.bc_mtr_station.entity.LineEntity;

@Repository
public interface LineRepository extends JpaRepository<LineEntity, Long> {
  // ! Native Query (3rd approach - product specific)
  // ! JPQL (2nd approach)

  // ! JPA Methods (1st approach)
  // ! Hibernate is able to auto generate the SQL for "findByCode"
  // select * from mtr_lines where code = ?
  Optional<LineEntity> findByCode(String code);


}
