package daycalculator.controller;

import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import daycalculator.domain.DateCalculateMaster;
import daycalculator.domain.ResultDate;
import daycalculator.repository.DateCalculateRepository;
import daycalculator.service.DateCalculateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DateCalculateControllerTest {

    private static Long TEST_ID = 1L;

    @Autowired
    DateCalculateController controller;

    @Autowired
    DateCalculateService service;

    private MockMvc mockMVC;

    @Mock
    private DateCalculateRepository repository;

    private DateCalculateMaster master;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMVC = MockMvcBuilders.standaloneSetup(controller).build();
        this.master = new DateCalculateMaster();
        master.setId(TEST_ID);
        master.setDateId("hogehoge");
        master.setDateName("hogehoge");
        master.setYear(0);
        master.setMonth(0);
        master.setDay(0);

        when(repository.getOne(TEST_ID)).thenReturn(this.master);
    }
    @Test
    public void datecalculateにアクセスして正しいVIEWがかえってくるか() throws Exception {
        mockMVC.perform(get("/datecalculate")).andExpect(view().name("datecalculate/index"));
    }

    @Test
    public void datecalculateにアクセスしてHTTPステータスコードが正しいか() throws Exception{
        mockMVC.perform(get("/datecalculate")).andExpect((status().isOk()));
    }

    //TODO: 変数に正しい値が詰められているかをチェック
//    @Test
//    public void datecalculateにアクセスして正しい変数を詰められているのか() throws Exception{
//        List<DateCalculateMaster> dateCalculateMasters = service.search();
//        LocalDate initialDate = LocalDate.now();
//
//        List<ResultDate> resultDates = service.createResultDate(dateCalculateMasters, initialDate);
//
//        mockMVC.perform(get("/datecalculate"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("datecalculate/index"))
//                .andExpect(model().attribute("resultDates", resultDates));
//    }

    //TODO: POSTメソッドのテストがうまく実装できない
//    @Test
//    public void postメソッドのテスト() throws Exception{
//        Employee emp = createEmployee();
//
//        mvc.perform(post("datecalculate/calculate")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(toJson(emp)))
//                .andExpect(status().isOk());
//    }

}