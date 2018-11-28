package warehousePBL;

public class SomeMeetingTask {	
	final int N_THREADS=3;
	
	TaskThread threads[];
	Barrier barrier;
	
	public SomeMeetingTask() {
		threads = new TaskThread[N_THREADS];
		barrier = new Barrier(N_THREADS);
		for(int i = 0;i<N_THREADS;i++){
			threads[i] = new TaskThread(i,barrier);
			threads[i].start();
		}
		for(int i = 0;i<N_THREADS;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
    public static void main( String[] args )
    {
        SomeMeetingTask task = new SomeMeetingTask();
    }
}


/*int main()
{
  pthread_t idThreads[N_THREADS];
  char str[128];
  int i;
  Barrier barrier;

  initBarrier(&barrier, N_THREADS);
  for(i=0;i<N_THREADS;i++) pthread_create(&idThreads[i],NULL,function,(void*)&barrier);
  for(i=0;i<N_THREADS;i++) pthread_join(idThreads[i],NULL);
  cleanBarrier(&barrier);
  printf("type \"Return\" to finish");
  fgets(str,sizeof(str),stdin);
  return 0;
}

void* function(void* arg)
{
  int i;

  PBarrier pBarrier=(PBarrier)arg;

  for(i=0;i<N_THREADS;i++)
  {
    sleep(i+1);
    waitInBarrier(pBarrier);
    printf("Thread: %d\n",i);
  }
  return 0;
}*/