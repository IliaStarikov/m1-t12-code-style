import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().calculate();
    }
    double getComplexPercent(double amount, int depositPeriod) {
        double pay = amount * Math.pow((1 + 0.06 / 12), 12 * depositPeriod);
    return rounding(pay);
    }

    double getSimplePercent(double amount, int depositPeriod) {
    return rounding(amount + amount * 0.06 * depositPeriod);
    }

    double rounding(double value) {
        double scale = Math.pow(10, 2);
    return Math.round(value * scale) / scale;
    }

    void calculate() {
        int depositTerm;
        int action;

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scan.nextInt();

        System.out.println("Введите срок вклада в годах:");
        depositTerm = scan.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scan.nextInt();

        double depositAccumulations = 0;

        if (action == 1) {
            depositAccumulations = getSimplePercent(amount, depositTerm);
        } else if (action == 2) {
            depositAccumulations = getComplexPercent(amount, depositTerm);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositTerm + " лет превратятся в " + depositAccumulations);
    }
}
