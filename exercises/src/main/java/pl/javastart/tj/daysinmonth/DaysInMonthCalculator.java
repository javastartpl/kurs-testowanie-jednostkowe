package pl.javastart.tj.daysinmonth;

public class DaysInMonthCalculator {

    public int geDayCount(int year, int month) {

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if(year % 4 == 0 && year % 100 != 0) return 29;
                return 28;
        }

        return 0;
    }
}
