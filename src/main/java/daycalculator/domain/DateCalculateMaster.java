package daycalculator.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "date_calculate_master")
@Getter
@Setter
@NoArgsConstructor
public class DateCalculateMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date_id", nullable = false)
    private String dateId;

    @NotNull
    @Column(name = "date_name", nullable = false)
    private String dateName;

    @NotNull
    @Column(name = "year", nullable = false)
    private Integer year;

    @NotNull
    @Column(name = "month", nullable = false)
    private Integer month;

    @NotNull
    @Column(name = "day", nullable = false)
    private Integer day;

}
