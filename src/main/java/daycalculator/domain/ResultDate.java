package daycalculator.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ResultDate {

    private Long id;

    private String dateId;

    private String dateName;

    private LocalDate resultDate;

    private String calculateFormula;

    public ResultDate(DateCalculateMaster dateCalculateMaster, LocalDate date) {
        this.id = dateCalculateMaster.getId();
        this.dateId = dateCalculateMaster.getDateId();
        this.dateName = dateCalculateMaster.getDateName();
        this.resultDate = date;
        resultDate = resultDate.plusDays(dateCalculateMaster.getDay());
        resultDate = resultDate.plusMonths(dateCalculateMaster.getMonth());
        resultDate = resultDate.plusYears(dateCalculateMaster.getYear());
        this.calculateFormula = dateCalculateMaster.getYear() + "/" + dateCalculateMaster.getMonth() + "/" + dateCalculateMaster.getDay();
    }

}
