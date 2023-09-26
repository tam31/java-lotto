package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 있는 로또의 숫자는 6개여야 합니다.");
        }
    }

    private void limitNumberSize(List<Integer> numbers){
        for(int number: numbers){
            isCheckExceptionNumber(number);
        }
    }

    private void isCheckExceptionNumber(int number) {
        if(number <1 || number >45){
            throw new IllegalArgumentException("[ERROR] 로또번호는 1~45까지여야 합니다.");
        }
    }

    private void checkDuplicationNumber(List<Integer> numbers){
        for(int number: numbers){
            numbers.remove(number);
            isCheckDuplication(numbers, number);
        }
    }

    private void isCheckDuplication(List<Integer> numbers, int number) {
        if(numbers.contains(number)){
            throw new IllegalArgumentException("[ERROR] 로또번호를 중복선택할 수 없습니다.");
        }
    }
}
