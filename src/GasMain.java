import java.util.Scanner;

public class GasMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GasExam myCar = new GasExam();
        System.out.println("가스를 충전해 주세요");
        myCar.setGas(scanner.nextInt());

        if (myCar.isGasLeft()) { // 가스 유뮤 확인
            myCar.run();
        }
    }// main
}// class
