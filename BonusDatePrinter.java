public class BonusDatePrinter {

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        for (int year = fromYear; year <= toYear; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= 31; day++) {
                    if (isValidDate(year, month, day) && isDateReversedTheSame(year, month, day)) {
                        System.out.printf("%04d-%02d-%02d%n", year, month, day);
                    }
                }
            }
        }
    }

    private static boolean isValidDate(int year, int month, int day) {
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        }
        return true;
    }

    private static boolean isDateReversedTheSame(int year, int month, int day) {
        String date = String.format("%04d%02d%02d", year, month, day);
        String reversedDate = new StringBuilder(date).reverse().toString();
        return date.equals(reversedDate);
    }

    public static void main(String[] args) {
        printBonusDatesBetween(2000, 2050);
    }
}