package daycalculator.service;

import org.springframework.beans.factory.annotation.Autowired;
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
        return dateCalculateMasters.stream().map(d -> new ResultDate(d, inputDate)).collect(Collectors.toList());
    }

    public List<ResultDate> calculateResultDate(String inputDate){
        List<DateCalculateMaster> dateCalculateMasters = search();

        String[] dates = inputDate.split("/",0);

        LocalDate date = LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");


        return dateCalculateMasters.stream().map(d -> new ResultDate(d, date)).collect(Collectors.toList());

    }
}