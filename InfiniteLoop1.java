/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infiniteloop1;

import java.util.ArrayList;

/**
 * Very simple app to put arithmetic load on CPU
 * 
 * @author rox_lukas@wp.pl
 */
public class InfiniteLoop1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int threads = 8; //number of threads
        long period = 10000; //milliseconds of load 10000 = 10s
        ArrayList<Thread> hogs = new ArrayList<Thread>();
        
        for (int i = 0; i < threads; i++) {
            hogs.add(i, new Thread(new hog(period)));
            hogs.get(i).start();
        }
    }
    
}

/**
 * 
 * @author rox_lukas@wp.pl
 */
class hog implements Runnable {
    private long counter;
    private long period;
    private long tstart;
    
    hog(long period) {
        this.period = period;
        this.counter = 0;
        this.tstart = System.currentTimeMillis();
    }
    
    @Override
    public void run() {
        while (System.currentTimeMillis() < tstart + period) {
            counter++;
        }
        
        System.out.println("Done " + Long.toString(counter) + " cycles in " + Long.toString(period) + "ms " + Double.toString(counter/period) + "cycle/ms");
    }
}
