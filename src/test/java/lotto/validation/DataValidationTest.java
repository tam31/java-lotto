package lotto.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataValidationTest {

    @DisplayName("입력받은 금액이 문자일경우 오류발생")
    @Test
    public void 입력값이숫자가_아닐때() throws Exception{
        //given 이런게 주어졋을때
        DataValidation dataValidation = new DataValidation();
        //when 이걸 실행하면
        assertThrows(IllegalArgumentException.class,
                () -> dataValidation.isCheckMoney("abc"));
    }
    @DisplayName("입력받은 금액 형 변환")
    @Test
    public void changeMoney() throws Exception{
        DataValidation dataValidation = new DataValidation();
        int money = dataValidation.changeMoney("1000");
        Assertions.assertEquals(1000,money);
    }

    @DisplayName("입력받은 금액이 1000천원 단위가 아닐경우")
    @Test
    public void checkMoney() throws Exception{
        DataValidation dataValidation = new DataValidation();
        assertThrows(IllegalArgumentException.class,
                ()-> dataValidation.checkMoney(1500));

    }
}