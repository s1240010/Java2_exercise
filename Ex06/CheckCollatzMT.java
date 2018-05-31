import java.math.BigInteger;
import java.util.Date;


// The implementation of CheckCollatz.check() will be extremely slow
// if we try very large values for n.
// It is actually easy to share the computation on multiple threads,
// by spawning as many threads as cores and running the checks
// for an interval [lower, upper] on 1 core.
//
public class CheckCollatzMT implements Runnable {
    BigInteger bound,upper;
    boolean v;
    public CheckCollatzMT(BigInteger bound,BigInteger upper){
      this.bound = bound;
      this.upper = upper;
    }

    public boolean check(BigInteger upper) {
      //TODO complete
       int b1 = bound.intValue();
       int num = upper.intValue();
       for(int i=b1;i<num;i++){
        if(!(Collatz.check(BigInteger.valueOf(i)).valid)) {
          return false;
        }
      }
      return true;
    }


    public void run() {
      v = check(upper);
    }


  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage:");
      System.out.println("java CheckCollatzMT n num_threads");
      System.out.println("where positive integers i: 1<= i <= n will be checked");
      System.out.println("and num_threads is the number of threads to use");
      System.exit(1);
    }

    // TODO complete
    // Spawn num_threads,
    // each of them will verify the conjecture for i in [lower, upper]
    // where lower and upper are determined such that each thread has
    // approximately the same amount of work to perform.

    int upper      = Integer.parseInt(args[0]);
    int NUM_THREAD = Integer.parseInt(args[1]);


    CheckCollatzMT[] runnables = new CheckCollatzMT[NUM_THREAD];
    for ( int i = 0; i < NUM_THREAD; ++ i ) {
      if(i==NUM_THREAD-1){
        runnables[i]= new CheckCollatzMT(BigInteger.valueOf(i*(upper/NUM_THREAD)+1),BigInteger.valueOf(upper));
      }else{
        runnables[i]= new CheckCollatzMT(BigInteger.valueOf(i*(upper/NUM_THREAD)+1),BigInteger.valueOf((i+1)*(upper/NUM_THREAD)));
      }
    }


    // Create threads
    Thread[] threads = new Thread[NUM_THREAD];

    for ( int i = 0; i < NUM_THREAD; i++ ) {
      threads[i] = new Thread(runnables[i]);
    }
    long start_time = new Date().getTime();
    // Run threads
    for ( int i = 0; i < NUM_THREAD; ++ i ) {
      threads[i].start();
    }

   // Wait threads
   try {
    for ( int i = 0; i < NUM_THREAD; i++ ) {
      threads[i].join();
      }
    } catch(Exception e) {
    e.printStackTrace();
    }
    long end_time = new Date().getTime();
    boolean flag=true;
    for(int i=0;i<NUM_THREAD;i++)
      if(!(runnables[i].v))
        flag=false;

        System.out.println("Ellapsed time: " + (end_time-start_time) + "ms");

  if (flag) {
    System.out.println("The conjecture seems valid up to n="+upper);
  } else {
    System.out.println("The conjecture is not valid");
  }
}
}
