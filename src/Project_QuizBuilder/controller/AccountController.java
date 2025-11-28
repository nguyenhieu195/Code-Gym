package Project_QuizBuilder.controller;

import Project_QuizBuilder.entity.Account;
import Project_QuizBuilder.service.AccountService;

import java.util.List;

public class AccountController {

    private AccountService serviceAccount;

    public AccountController() throws Exception {
        this.serviceAccount = new AccountService();
    }

    public boolean add(Account account) throws Exception {
        return  serviceAccount.add(account);
    }

    public boolean remove(Account account) throws Exception {
        return   serviceAccount.remove(account);
    }

    public List<Account> getListAccount() {
        return serviceAccount.getListAccount();
    }
}
