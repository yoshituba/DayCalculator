package tabledemo.tabledemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tabledemo.tabledemo.domain.DateCalculateMaster;
import tabledemo.tabledemo.domain.ResultDate;
import tabledemo.tabledemo.repository.DateCalculateRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DateCalculateService {
    @Autowired
    private DateCalculateRepository dateCalculateRepository;

    public List<DateCalculateMaster> findAll() {
        return dateCalculateRepository.findAll();
    }

    public DateCalculateMaster getOne(Long id) {
        return dateCalculateRepository.getOne(id);
    }

    public DateCalculateMaster save(DateCalculateMaster dateCalculateMaster) {
        return dateCalculateRepository.save(dateCalculateMaster);
    }

    public void deleteById(Long id) {
        dateCalculateRepository.deleteById(id);
    }

    public List<ResultDate> createResultDate(List<DateCalculateMaster> dateCalculateMasters, LocalDate inputDate){
        List<ResultDate> resultDates = dateCalculateMasters.stream().map(d -> new ResultDate(d, inputDate)).collect(Collectors.toList());

        return resultDates;

    }

    public List<ResultDate> calculateResultDate(String inputDate){
        List<DateCalculateMaster> dateCalculateMasters = findAll();

        String[] dates = inputDate.split("/",0);

        LocalDate date = LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");


        List<ResultDate> resultDates = dateCalculateMasters.stream().map(d -> new ResultDate(d, date)).collect(Collectors.toList());

        return resultDates;

    }
}