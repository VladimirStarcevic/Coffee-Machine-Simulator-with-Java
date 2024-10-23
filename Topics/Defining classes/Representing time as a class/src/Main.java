import java.util.Scanner;
class Time {
    public int hours;
    public int minutes;
    public int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int hour = getValidTimeComponents(scanner, "hours", 0, 23);
            int minute = getValidTimeComponents(scanner, "minutes", 0, 59);
            int second = getValidTimeComponents(scanner, "seconds", 0, 59);

            Time time = new Time(hour, minute, second);
            System.out.println(time);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }


    }

    private static int getValidTimeComponents(Scanner scanner, String component, int minValue, int maxValue) {
        int value = scanner.nextInt();
        if (value < minValue || value > maxValue) {
            throw new IllegalArgumentException(String.format("%s should be between %d and %d", component, minValue, maxValue));
        }
        return value;
    }

}

