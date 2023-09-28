package lotto.validation;

import java.util.ArrayList;
import java.util.List;

public class DataValidation {
    private static int unitMoney = 1000;

    public int isCheckNumber(String number){
        try{
            int result = changeNumber(number);
            return result;
        }catch (NumberFormatException n){
            throw new IllegalArgumentException("[ERROR] 숫자을 입력하세요");
        }
    }

    public int changeNumber(String number){
        return Integer.parseInt(number);
    }
    public void checkMoney(int money){
        if(money%unitMoney!=0){
            throw new IllegalArgumentException(String.format("[ERROR]%d원 단위로 나눌수 없습니다.",unitMoney));
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
        }catch (ArrayIndexOutOfBoundsException a){
            throw new IllegalArgumentException("[ERROR] 6가지의 숫자를 ','와 함께 써주세요");
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 6가지의 숫자를 ','와 함께 써주세요");
        }
    }

    private List<Integer> changeNumbers(String[] strNumbers) {
        List<Integer> number = new ArrayList<>();
        for(String checkNumber:strNumbers){
            number.add(isCheckNumber(checkNumber));
        }
        return number;
    }

    public void isNotDuplicationNumber(int bonus, List<Integer> lottoNumbers) {
        if(lottoNumbers.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 중복해서 쓸수 없습니다.");
        }
    }
}
