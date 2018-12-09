package daycalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import daycalculator.domain.DateCalculateMaster;

@Repository
public interface DateCalculateRepository extends JpaRepository<DateCalculateMaster, Long> {

}
