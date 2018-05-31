
public class Transfer extends Thread{
    public Transfer(Bank bank, int from, int max_amount) {
            bank_ = bank;
            from_ = from;
            max_ = max_amount;
    }

    // COMPLETE
    public void run(){
    	while(true){
    		int To = (int) (Math.random() * BankTest.N_ACCOUNTS);
    		int maxAmount = (int)(Math.random() * this.max_);
    		bank_.transfer(from_,To,maxAmount);
    	}

    }

    private Bank bank_;
    private int from_;
    private int max_;
}
