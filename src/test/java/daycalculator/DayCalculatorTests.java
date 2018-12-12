package daycalculator;

import daycalculator.domain.DateCalculateMaster;
import daycalculator.domain.ResultDate;
import daycalculator.repository.DateCalculateRepository;
import daycalculator.service.DateCalculateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DayCalculatorTests {

	private static Long TEST_ID = 1L;

	@Autowired
	@InjectMocks
	private DateCalculateService service;

	private DateCalculateMaster master;

	@Mock
	private DateCalculateRepository repository;

	@Before
	public void before() throws Exception{
		MockitoAnnotations.initMocks(this);
		this.master = new DateCalculateMaster();
	}

	@Test
	public void 翌日の日付計算式に計算基準日20181208を渡して計算結果が20181209になること() throws Exception {
		master.setId(TEST_ID);
		master.setDateId("D01");
		master.setDateName("翌日");
		master.setYear(0);
		master.setMonth(0);
		master.setDay(1);
		when(repository.getOne(TEST_ID)).thenReturn(this.master);


		ResultDate resultDate = new ResultDate(master);

		LocalDate actual = service.calculateResultDate("2018/12/08", resultDate);

		assertThat(actual, is(LocalDate.of(2018,12,9)));
	}


}
