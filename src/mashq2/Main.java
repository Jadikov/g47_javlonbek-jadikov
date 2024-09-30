package mashq2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 9, 1);

        long totalWorkingHours = calculateTotalWorkingHours(startDate, endDate);
        System.out.println("Olimning umumiy ishlagan soatlari: " + totalWorkingHours);
    }

    public static long calculateTotalWorkingHours(LocalDate startDate, LocalDate endDate) {
        long totalHours = 0;

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();

            if (dayOfWeek.getValue() >= DayOfWeek.MONDAY.getValue() && dayOfWeek.getValue() <= DayOfWeek.FRIDAY.getValue()) {
                totalHours += 8;
            }
            else if (dayOfWeek == DayOfWeek.SATURDAY) {
                totalHours += 4;
            }

            currentDate = currentDate.plusDays(1);
        }

        return totalHours;
    }
}
