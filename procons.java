
package procon;
import java.util.ArrayList;
import java.util.List;

public class ProCon {

    public static void main(String[] args) {
        
  List<Integer> b=new ArrayList<Integer>();
   Thread p=new  Thread(new Produce(b));
   Thread c=new  Thread(new Consumer(b));
    p.start();   
    c.start();
    }
    
}
class Produce implements Runnable 
{
    List<Integer> b=null;
    private int i;
    final int maxs=5;
    Produce(List<Integer> b)
    {
    this.b=b;
    }

public void Produce(int i) throws InterruptedException
{
synchronized(b)
{
while(b.size()==maxs)
  {
    System.out.println("Producer is waiting ");
    b.wait();
  }
}
synchronized(b)
{
    b.add(i);
    System.out.println("Producer is producing");
    Thread.sleep(500);
    b.notify();
 }}
public void run()
{
  try
   {
      while(true)
       {
         i++;
        Produce(i);
       }
}
catch(Exception e)
{
   System.out.println(e);
}
}}
class Consumer implements Runnable 
{
    List<Integer> b=null;
    private int i;
    final int maxs=5;
    Consumer(List<Integer> b)
    {
    this.b=b;
    }
public void Consumer(int i) throws InterruptedException
{
synchronized(b)
{
while(b.isEmpty())
  {
    System.out.println("Consumer is waiting ");
    b.wait();
  }
}
synchronized(b)
{
    b.remove(i);
    System.out.println("Consumer is consuming");
    Thread.sleep(40);
    b.notify();
 }}
public void run()
{
  try
   {
      while(true)
       {
         i--;
         Consumer(i);
       }
}
catch(Exception e)
{
   System.out.println(e);
}
}}
