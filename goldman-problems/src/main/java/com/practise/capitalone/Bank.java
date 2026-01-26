package com.practise.capitalone;

/*problem 2043 simple banking system
 * */
public class Bank {
    long[] balance;
    int n; // total accounts

    public Bank(long[] balance) {
        this.balance = balance;
        this.n = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isValidAccount(account1) || !isValidAccount(account2)) {
            return false;
        }

        // Check if account1 has sufficient balance
        if (balance[account1 - 1] < money) {
            return false;
        }

        // Perform the transfer
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValidAccount(account)) {
            return false;
        }
        balance[account - 1] = balance[account - 1] + money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValidAccount(account)) {
            return false;
        }

        // Check if account1 has sufficient balance
        if (balance[account - 1] < money) {
            return false;
        }


        balance[account - 1] = balance[account - 1] - money;
        return true;
    }

    private boolean isValidAccount(int account1) {
        return account1 >= 1 && account1 <= n;
    }
}
