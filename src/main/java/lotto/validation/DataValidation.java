package lotto.validation;

import java.util.ArrayList;
import java.util.List;

public class DataValidation {
    private static int unitMoney = 1000;

    public void isCheckNumber(String number){
        try{
            changeNumber(number);
        }catch (NumberFormatException n){
            System.out.println("[ERROR] 숫자을 입력하세요");
            throw new IllegalArgumentException();
        }
    }

    public int changeNumber(String number){
        return Integer.parseInt(number);
    }
    public void checkMoney(int money){
        if(money%unitMoney!=0){
            System.out.printf("[ERROR]%d원 단위로 나눌수 없습니다.",unitMoney);
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> isCheckNumbers(String numbers) {
        return splitNumbers(numbers);
    }

    private List<Integer> splitNumbers(String numbers) {
        try{
            String[] strNumbers = numbers.split(",");
            List<Integer> number = changeNumbers(strNumbers);
            return number;
        }catch (Exception e){
            System.out.println("[ERROR] 6가지의 숫자를 ','와 함께 써주세요");
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> changeNumbers(String[] strNumbers) {
        List<Integer> number = new ArrayList<>();
        for(String checkNumber:strNumbers){
            number.add(changeNumber(checkNumber));
        }
        return number;
    }

    public void isNotDuplicationNumber(int bonus, List<Integer> lottoNumbers) {
        if(lottoNumbers.contains(bonus)){
            System.out.println("[ERROR] 중복해서 쓸수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
}
