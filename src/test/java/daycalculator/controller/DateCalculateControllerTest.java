package daycalculator.controller;

import daycalculator.domain.DateCalculateMaster;
import daycalculator.repository.DateCalculateRepository;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DateCalculateControllerTest {

    private static Long TEST_ID = 1L;

    @Autowired
    DateCalculateController controller;

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
    public void index() throws Exception {
        mockMVC.perform(get("/datecalculate")).andExpect(view().name("datecalculate/index"));
    }
}