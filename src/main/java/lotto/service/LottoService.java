package lotto.service;

import lotto.validation.DataValidation;

public class LottoService {
    DataValidation dataValidation = new DataValidation();
    public int checkMoney(String money){
        return dataValidation.isCheckMoney(money);
    }
}
