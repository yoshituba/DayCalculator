package daycalculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;
import daycalculator.domain.DateCalculateMaster;
import daycalculator.domain.ResultDate;
import daycalculator.repository.DateCalculateRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DateCalculateService {

    @Autowired
    private DateCalculateRepository repository;

    public List<DateCalculateMaster> search() {
        return repository.findAll();
    }

    public DateCalculateMaster searchByPK(Long id) {
        return repository.getOne(id);
    }

    public DateCalculateMaster save(DateCalculateMaster dateCalculateMaster) {
        return repository.save(dateCalculateMaster);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<ResultDate> createResultDate(List<DateCalculateMaster> dateCalculateMasters, LocalDate inputDate){

        List<ResultDate> resultDates = dateCalculateMasters.stream().map(master -> new ResultDate(master)).collect(Collectors.toList());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        resultDates.stream().forEach(r -> r.setResultDate(calculateResultDate(inputDate.format(dateTimeFormatter), r)));
        return resultDates;
    }

    public List<ResultDate> calculate(String inputDate){
        List<DateCalculateMaster> dateCalculateMasters = search();

        List<ResultDate> resultDates = dateCalculateMasters.stream().map(d -> new ResultDate(d)).collect(Collectors.toList());

        resultDates.stream().forEach(r -> r.setResultDate(calculateResultDate(inputDate, r)));

        return resultDates;

    }

    public LocalDate calculateResultDate(String inputDate, ResultDate resultDate){

        String[] dates = inputDate.split("/",0);

        Integer adjustmentYears = searchByPK(resultDate.getId()).getYear();
        Integer adjustmentMonths = searchByPK(resultDate.getId()).getMonth();
        Integer adjustmentDays = searchByPK(resultDate.getId()).getDay();

        LocalDate date = LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));

        return date.plusYears(adjustmentYears).plusMonths(adjustmentMonths).plusDays(adjustmentDays);

    }


}