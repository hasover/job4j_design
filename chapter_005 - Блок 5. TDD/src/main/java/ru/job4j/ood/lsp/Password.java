package ru.job4j.ood.lsp;

/*
Нарушения контракта LSP: усиление предусловия в подклассе
 */
public class Password {
    public void set (String password) {

    }
}

class SecurePassword extends Password {

    @Override
    public void set(String password) {
        if (password.length() <= 6) {
            throw new IllegalArgumentException("Password should be longer than 6!");
        }
    }
}
