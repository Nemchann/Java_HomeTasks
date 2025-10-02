import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankAccount {
    private final String fullName;
    private final String birthDate;
    private final String passportData;
    int[] accounts = new int[8];

    public BankAccount(String fullName, String birthDate, String passportData){

        boolean isName = (fullName != null) && !fullName.isEmpty();
        boolean isDate = (birthDate != null) && !birthDate.isEmpty();
        boolean isPassport = (passportData != null) && !passportData.isEmpty();

        if (!isName || !isDate || !isPassport){
            throw new IllegalArgumentException("This parameters can't be null or empty");
        }

        this.fullName = fullName;
        this.birthDate = birthDate;
        this.passportData = passportData;

    }

    public void addAccount(int account, int accountNum){
        if (accountNum > 8 || accountNum < 1){
            throw new IllegalArgumentException("U have got only 8 accounts");
        }
        if (account < 0){
            throw new IllegalArgumentException("U can't add negative sum");
        }
        else{
            accounts[accountNum - 1] += account;
        }
    }

    public int outMoney(int accountNum){
        int account;
        if (accountNum > 8 || accountNum < 1){
            throw new IllegalArgumentException("U have got only 8 accounts");
        }
        else{
            account = accounts[accountNum - 1];
            accounts[accountNum - 1] = 0;
        }
        return account;
    }

    public int[] getAccounts() {
        return Arrays.copyOf(this.accounts, this.accounts.length);
    }
}
