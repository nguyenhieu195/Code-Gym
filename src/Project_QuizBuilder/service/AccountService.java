package Project_QuizBuilder.service;

import Project_QuizBuilder.entity.Account;
import Project_QuizBuilder.repository.AccountRepo;

import java.util.List;

public class AccountService {

    private AccountRepo repoAccount;

    public AccountService() throws Exception {
        repoAccount = new AccountRepo();
    }

    public boolean add(Account account) throws Exception {

        // check trùng username
        for (Account acc : repoAccount.getListAccount()) {
            if (acc.getUsername().equalsIgnoreCase(account.getUsername())) {
                throw new Exception("Username already exists!");
            }
        }

        repoAccount.addAccount(account);
        return true;
    }
    public boolean remove(Account account) throws Exception {

        boolean exists = false;

        for (Account acc : repoAccount.getListAccount()) {
            if (acc.getId().equals(account.getId())) {
                exists = true;
                break;
            }
        }

        if (!exists) {
            throw new Exception("Account does not exist!");
        }

        repoAccount.removeAccount(account);
        return true;
    }

    public List<Account> getListAccount() {
        return repoAccount.getListAccount();
    }
}