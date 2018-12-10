package daycalculator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

@Getter
@Setter
@AllArgsConstructor
public class ResultDate {
    // TODO: サロゲートキーをもたせる必要なし。Viewに表示するIDは列番号を表すstat#countに直すこと
    private Long id;

    private String dateId;

    private String dateName;

    private String calculateFormula;

    private LocalDate resultDate;

    public ResultDate(DateCalculateMaster master) {
        this.id = master.getId();
        this.dateId = master.getDateId();
        this.dateName = master.getDateName();
        this.calculateFormula = convertMasterToCalculateFormula(master);
    }

    public String convertMasterToCalculateFormula(DateCalculateMaster master){
        List<Integer> formulaInfo = Arrays.asList(master.getYear(), master.getMonth(), master.getDay());

        StringJoiner joiner = new StringJoiner("/");

        formulaInfo.stream().forEach(e -> joiner.add(String.valueOf(e)));

        return joiner.toString();
    }


}
