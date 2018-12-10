package daycalculator;

import daycalculator.domain.DateCalculateMaster;
import daycalculator.domain.ResultDate;
import daycalculator.repository.DateCalculateRepository;
import daycalculator.service.DateCalculateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DayCalculatorTests {

	private DateCalculateService service;

	private DateCalculateMaster master;

	private DateCalculateRepository repository;

	@Before
	public void before() throws Exception{
		service = new DateCalculateService();
		master = new DateCalculateMaster();
	}

	@Test
	public void 翌日の日付計算式に計算基準日20181208を渡して計算結果が20181209になること() throws Exception {
		master.setId(Long.valueOf(1));
		master.setDateId("D01");
		master.setDateName("翌日");
		master.setYear(0);
		master.setMonth(0);
		master.setDay(1);
		ResultDate resultDate = new ResultDate(master);

		LocalDate actual = service.calculateResultDate("2018/12/08", resultDate);

		assertThat(actual, is(LocalDate.of(2018,12,9)));
	}


}
