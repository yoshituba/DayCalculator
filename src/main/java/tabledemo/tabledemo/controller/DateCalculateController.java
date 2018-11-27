package tabledemo.tabledemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tabledemo.tabledemo.domain.DateCalculateMaster;
import tabledemo.tabledemo.domain.ResultDate;
import tabledemo.tabledemo.service.DateCalculateService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/datecalculate")
public class DateCalculateController {

    @Autowired
    private DateCalculateService dateCalculateService;

    @GetMapping
    public String index(Model model){
        List<DateCalculateMaster> dateCalculateMasters = dateCalculateService.findAll();
        LocalDate initialDate = LocalDate.now();

        List<ResultDate> resultDates = dateCalculateService.createResultDate(dateCalculateMasters, initialDate);

        model.addAttribute("resultDates", resultDates);

        return "datecalculate/index";
    }

    @GetMapping("new")
    public String create(Model model){
        return "datecalculate/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        DateCalculateMaster dateCalculateMaster = dateCalculateService.getOne(id);
        model.addAttribute("dateCalculateMaster", dateCalculateMaster);

        return "datecalculate/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model){
        DateCalculateMaster dateCalculateMaster = dateCalculateService.getOne(id);

        model.addAttribute("dateCalculateMaster", dateCalculateMaster);

        return "datecalculate/show";
    }

    @PostMapping("calculate")
    public String calculate(@ModelAttribute("baseDate") String baseDate, Model model){
        List<ResultDate> resultDates = dateCalculateService.calculateResultDate(baseDate);
        model.addAttribute("resultDates", resultDates);
        return "datecalculate/index";
    }

    @PostMapping
    public String create(@ModelAttribute DateCalculateMaster dateCalculateMaster){
        dateCalculateService.save(dateCalculateMaster);

        return "redirect:datecalculate";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute DateCalculateMaster dateCalculateMaster){
        dateCalculateMaster.setId(id);
        dateCalculateService.save(dateCalculateMaster);

        return "redirect:/datecalculate";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id){
        dateCalculateService.deleteById(id);
        return "redirect:/datecalculate";
    }
}
