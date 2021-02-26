package ru.job4j.ood.lsp;
/*
Отсутствие проверки состояния батареи в потомке ( нарушение инварианта)
 */
public class Phone {
    protected float batteryCharge;

    protected boolean isEnoughCharge() {
        return batteryCharge > 2.3;
    }

    public void dialNumber(String number) {
        if (isEnoughCharge()) {
            //dialingNumber
        }
    }
}

class SmartPhone extends Phone {

    @Override
    public void dialNumber(String number) {
        // dialingNumber
    }
}
