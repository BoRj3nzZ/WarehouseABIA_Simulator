package warehousePBL;

import java.util.concurrent.Semaphore;

public class Barrier {

	Semaphore sEntry, sMutEx, sExit;
	int nTaskInBarrier;
	int N;
	static int cnt=0;
	
	public Barrier(int nEntry) {
		sEntry = new Semaphore(nEntry, true);
		sMutEx = new Semaphore(1, true);
		sExit = new Semaphore(0, true);
		nTaskInBarrier = 0;
		N = nEntry;
	}
	
	void waitInBarrier(){
		int x;
		
		try {
			sEntry.acquire();
			sMutEx.acquire();
			x=++nTaskInBarrier;
			sMutEx.release();
			if(x< N) sExit.acquire();
			else sExit.release(N-1);
			sMutEx.acquire();
			x=--nTaskInBarrier;
			sMutEx.release();
			if(x==0) sEntry.release(N);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
