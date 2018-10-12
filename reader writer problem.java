package read.and.writer;
import java.util.concurrent.Semaphore;


public class ReadAndWriter {

   static int rc=0;
   static Semaphore s=new Semaphore(1);
   static Semaphore wrt=new Semaphore(1);
      
static class Reader implements Runnable
{
    public void run()
    {
      try
      {      
        s.acquire();
        rc=rc+1;
        if(rc==1)
          wrt.acquire();
          s.release();
          System.out.println(Thread.currentThread().getName()+" is reader");
          Thread.sleep(500);
           s.acquire();
        rc=rc-1;
        if(rc==0)
          wrt.release();
          s.release();
      }
      catch(Exception e)
      {
      
      }
    }
}
static class Writer implements Runnable
{
    public void run()
    {
        try{
        wrt.acquire();
        System.out.println("is Writer");
        Thread.sleep(1000);
          wrt.release();
    }
    catch(Exception e)
    {
    }
    }
}

    public static void main(String[] args) throws InterruptedException {
        Reader r=new Reader();
        Writer w=new Writer();
        Thread t1=new Thread(r);
       t1.setName("t1");
       t1.start();
       Thread t2=new Thread(r);
       t2.setName("t2");
       t2.start();
       Thread t3=new Thread(w);
       t3.start();
    }
}
