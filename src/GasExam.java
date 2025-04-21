import java.util.Scanner;

public class GasExam {
//    자동차가 달릴 때 마다 gas를 소모
//    gas가 떨어졌다면 충전해야함
    Scanner scanner = new Scanner(System.in);
    private int gas; //가스 양

    /**
     * @return 현재 gas
     */
    public int getGas() {
        return gas;
    }

    /**
     * @param gas 재할당 할 값
     */
    public void setGas(int gas) {
        this.gas = gas;
    }

    /**
     * 사용자로부터 충전할 gas 양을 입력받아 gas에 더해줌
     */
    public void addGas() {
        System.out.print("충전할 양을 입력해주세요 : ");
        int input = scanner.nextInt();
        this.gas += input;
        System.out.printf("gas잔량 : %d\n", this.gas);
    }

    /**
     * @return gas가 4보다 작다면 true
     */
    public boolean isGaslack() {
        return gas < 4;
    }

    /**
     * @return gas가 0이라면 false 이외의 경우 true
     */
    public boolean isGasLeft() {
        if (gas == 0) {
            System.out.println("gas가 없습니다");
            return false;
        }
        System.out.println("gas가 있습니다");
        return true;
    }// isGasLeft

    public void run() {
        while (true) {
            if (gas > 0) {
                System.out.printf("달립니다\tgas잔량 : %d\n", gas); // 잔량 알림
                if (isGaslack()) { // 가스 부족 시 ( < 4 )
                    System.out.println("가스가 부족합니다\n1.주유소 방문\t2.계속 주행"); // 옵션 제공
                    int sel = scanner.nextInt(); // 사용자 입력
                    boolean exit = false; // exit flag
                    while(!exit) {
                        switch (sel) {
                            case 1 -> { // 1. 주유소 방문
                                addGas(); // 가스 충전
                                exit = true;
                            }
                            case 2 -> {exit = true;} // 2. 계속 주행
                            default -> { // invalid value
                                System.out.println("유효하지 않은 값입니다");
                            }
                        }// switch
                    }// while
                }// if
                this.gas--; // 가스 감소
                try { // 1초 휴식
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else { // gas <= 0
                System.out.printf("gas잔량 : %d\t사고 발생!!!", gas);
                break;
            }// if
        }// while
    }// run
}
