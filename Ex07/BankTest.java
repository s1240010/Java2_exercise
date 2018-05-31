public class BankTest {
    public static final int N_ACCOUNTS = 5;
    public static final int INIT_BALANCE = 1000;


    public static void main(String args[]) {
    	Bank account = new Bank(N_ACCOUNTS,INIT_BALANCE);
    	Transfer[] transfer = new Transfer[N_ACCOUNTS];
    	for(int i=0;i<N_ACCOUNTS;++i){
    		transfer[i] = new Transfer(account,i,INIT_BALANCE); 
    	}
    	for(Transfer i : transfer){
    		i.start();
    	}

    }
}
