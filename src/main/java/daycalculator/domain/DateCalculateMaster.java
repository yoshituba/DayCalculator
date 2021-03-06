package daycalculator.domain;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "date_calculate_master")
@Data
@NoArgsConstructor
public class DateCalculateMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date_id", nullable = false, unique = true)
    private String dateId;

    @NotNull
    @Column(name = "date_name", nullable = false, unique = true )
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
