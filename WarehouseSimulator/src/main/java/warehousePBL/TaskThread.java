package warehousePBL;

import java.util.Random;

public class TaskThread extends Thread{
	
	int threadId;
	Barrier barrier;
	Random r;
	
	
	public TaskThread(int id, Barrier barrier) {
		this.threadId=id;
		this.barrier=barrier;
		r = new Random();
	}
	

    @Override
    public void run() { 
    	System.out.println("Starting: "+threadId);
    	System.out.println("Thread "+threadId+" waits in barrier");
    	try {
			sleep(r.nextInt(10000));
			barrier.waitInBarrier();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread "+threadId+" exits");
    }
}
