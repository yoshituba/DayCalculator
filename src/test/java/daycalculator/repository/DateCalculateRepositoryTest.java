package daycalculator.repository;

import daycalculator.domain.DateCalculateMaster;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DateCalculateRepositoryTest {

    @Autowired
    DateCalculateRepository sut;


    @Before
    public void setUp() throws Exception {
        insertDateCalculateMaster(createMaster(1L, "D01", "翌日", 0, 0, 1));
        insertDateCalculateMaster(createMaster(2L, "D02", "翌年", 1, 0, 0));
    }

    @Test
    public void 全件検索でリストを取得できること() throws Exception{
        List<DateCalculateMaster> actual = sut.findAll();

        assertThat(actual.size()).isEqualTo(2);
    }

    private DateCalculateMaster createMaster(Long id, String dateId, String dateName, int addYear, int addMonth, int addDay){
        DateCalculateMaster master =  new DateCalculateMaster();

        master.setId(id);
        master.setDateId(dateId);
        master.setDateName(dateName);
        master.setYear(addYear);
        master.setMonth(addMonth);
        master.setDay(addDay);

        return master;
    }

    private void insertDateCalculateMaster(DateCalculateMaster master){
        sut.save(master);
    }

}