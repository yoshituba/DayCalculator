package tabledemo.tabledemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tabledemo.tabledemo.domain.DateCalculateMaster;

@Repository
public interface DateCalculateRepository extends JpaRepository<DateCalculateMaster, Long> {

}
