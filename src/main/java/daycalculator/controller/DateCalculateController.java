package daycalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import daycalculator.domain.DateCalculateMaster;
import daycalculator.domain.ResultDate;
import daycalculator.service.DateCalculateService;

import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/datecalculate")
public class DateCalculateController {

    //利用するサービスの意図がControllerから明確にわかるのでサービスの変数名はこの場合はserviceでよい
    @Autowired
    private DateCalculateService service;

    @GetMapping
    public String index(Model model){
        List<DateCalculateMaster> dateCalculateMasters = service.search();
        LocalDate initialDate = LocalDate.now();

        List<ResultDate> resultDates = service.createResultDate(dateCalculateMasters, initialDate);

        model.addAttribute("resultDates", resultDates);

        return "datecalculate/index";
    }

    @GetMapping("new")
    public String create(Model model){
        return "datecalculate/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        DateCalculateMaster result = service.searchByPK(id);
        model.addAttribute("result", result);

        return "datecalculate/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model){
        DateCalculateMaster dateCalculateMaster = service.searchByPK(id);

        model.addAttribute("dateCalculateMaster", dateCalculateMaster);

        return "datecalculate/show";
    }

    @PostMapping("calculate")
    public String calculate(@ModelAttribute("baseDate") String baseDate, Model model){
        List<ResultDate> resultDates = service.calculate(baseDate);
        model.addAttribute("resultDates", resultDates);
        return "datecalculate/index";
    }

    @PostMapping
    public String create(@ModelAttribute DateCalculateMaster dateCalculateMaster){
        try{
            service.save(dateCalculateMaster);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("重複エラー");
            return "redirect:datecalculate";
        }
        return "redirect:datecalculate";
    }

    @PutMapping("{id}")
    public String save(@PathVariable Long id, @ModelAttribute DateCalculateMaster dateCalculateMaster) throws Exception {
        dateCalculateMaster.setId(id);
        service.save(dateCalculateMaster);

        return "redirect:/datecalculate";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id){
        service.deleteById(id);
        return "redirect:/datecalculate";
    }
}
