package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        limitNumberSize(numbers);
        checkDuplicationNumber(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 선택할 수 있는 로또의 숫자는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void limitNumberSize(List<Integer> numbers){
        for(int number: numbers){
            isCheckExceptionNumber(number);
        }
    }

    private void isCheckExceptionNumber(int number) {
        if(number <1 || number >45){
            System.out.println("[ERROR] 로또번호는 1~45까지여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicationNumber(List<Integer> numbers){
        Set<Integer> duplication = new HashSet<>();
        for(int number: numbers){
            isCheckDuplication(duplication, number);
            duplication.add(number);
        }
    }

    private void isCheckDuplication(Set<Integer> duplication, int number) {
        if(duplication.contains(number)){
            System.out.println("[ERROR] 로또번호를 중복선택할 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers){
        numbers = new ArrayList<>(numbers);
        Collections.sort(numbers);
        return numbers;
    }
}
