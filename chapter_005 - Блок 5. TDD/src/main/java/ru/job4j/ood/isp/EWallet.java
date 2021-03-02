package ru.job4j.ood.isp;

// на анонимных кошельках нет инвормации о владельце
public interface EWallet {
    void sendMoney();
    void showBalance();
    void showOwner();
}

class Webmoney implements EWallet {

    @Override
    public void sendMoney() {

    }

    @Override
    public void showBalance() {

    }

    @Override
    public void showOwner() {

    }
}

class BitPay implements EWallet {

    @Override
    public void sendMoney() {

    }

    @Override
    public void showBalance() {

    }

    @Override
    public void showOwner() {
        throw new UnsupportedOperationException("anonymous wallet!");

    }
}
