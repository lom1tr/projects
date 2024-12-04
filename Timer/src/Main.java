import java.time.LocalTime;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие: ");
            System.out.println("1. Узнать текущее время");
            System.out.println("2. Создать таймер");
            System.out.println("3. Закрыть программу");

            String choice = sc.nextLine();
            System.out.println();

            if (choice.equals("1")) {
                System.out.println(nowTime());
                System.out.println();
            }

            if (choice.equals("2")) {
                System.out.println("Введите на сколько хотите поставить таймер(часы:минуты:секунды): ");
                String timer = sc.nextLine();
                String[] arr = timer.split(":");
                int hours = Integer.valueOf(arr[0]);
                int minutes = Integer.valueOf(arr[1]);
                int seconds = Integer.valueOf(arr[2]);
                LocalTime now = LocalTime.of(0, 0, 1);
                LocalTime after = afterTime(hours, minutes, seconds);
                System.out.println("Таймер запущен!");
                long j = 1;
                for (long i = after.toSecondOfDay(); i > 0; i--) {
                    TimeUnit.SECONDS.sleep(1);
                    LocalTime newTime = after.minusSeconds(j);
                    if (newTime.toSecondOfDay() == 0) {
                        System.out.println("00:00:00");
                        System.out.println("\nТаймер завершился!\n");
                        break;
                    } else {
                        System.out.println(newTime);
                        j++;
                    }
                }
            }
            if (choice.equals("3")) {
                System.out.println("Программа закрыта!");
                break;
            }
        }
    }

    public static LocalTime nowTime(){
        LocalTime nowTimeWithNano = LocalTime.now();
        LocalTime nullTime = LocalTime.of(0, 0, 0);
        LocalTime nowTime1 = nullTime.plusHours(nowTimeWithNano.getHour());
        LocalTime nowTime2 = nowTime1.plusMinutes(nowTimeWithNano.getMinute());
        LocalTime nowTime3 = nowTime2.plusSeconds(nowTimeWithNano.getSecond());
        return nowTime3;
    }
    public static LocalTime afterTime(int h, int m, int s) {
        LocalTime nowTimeWithNano = LocalTime.now();
        LocalTime nullTime = LocalTime.of(0, 0, 0);
        LocalTime nowTime1 = nullTime.plusHours(h);
        LocalTime nowTime2 = nowTime1.plusMinutes(m);
        LocalTime nowTime3 = nowTime2.plusSeconds(s);
        return nowTime3;
    }
}