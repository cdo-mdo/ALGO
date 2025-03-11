package testdate;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        
        // Before Java8
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -17);
        System.out.println(calendar.getTime().toString());
        
        LocalDate localDate = LocalDate.now().minusYears(18);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(date.toString());
        
    }
}
