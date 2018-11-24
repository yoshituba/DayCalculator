package tabledemo.tabledemo.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

    public Long getId() {
        return id;
    }

    public String getDateId() {
        return dateId;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    public String getDateName() {
        return dateName;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }

    public LocalDate getResultDate() {
        return resultDate;
    }

    public void setResultDate(LocalDate resultDate) {
        this.resultDate = resultDate;
    }

    public String getCalculateFormula() {
        return calculateFormula;
    }

    public void setCalculateFormula(String calculateFormula) {
        this.calculateFormula = calculateFormula;
    }

    @Override
    public String toString() {
        return "ResultDate{" +
                "id=" + id +
                ", dateId='" + dateId + '\'' +
                ", dateName='" + dateName + '\'' +
                ", resultDate=" + resultDate +
                ", calculateFormula='" + calculateFormula + '\'' +
                '}';
    }
}
