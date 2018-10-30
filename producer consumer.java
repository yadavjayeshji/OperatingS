
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ WITHOUT THREAD
package javaapplication2;
import java.util.Scanner;
 */
public class producerconsumer {
  static int mtext=1;
static int e=5;
static int f=0;
static int wait(int s){
    return --s;
}
static int signal(int s){
    return ++s;
}
static void producer(){
    mtext = wait(mtext);
    f=signal(f);
    e=wait(e);
    System.out.println("producer is producing");
    mtext=signal(mtext);    
}
static void consumer(){
    mtext=wait(mtext);
    f=wait(f);
    e=signal(e);
    System.out.println("cosumer is consuming");
    mtext=signal(mtext);
}
    public static void main(String[] args) {
        while(true){
            System.out.println("enter 1 for producer");
            System.out.println("rnter 2 for consumer");
         Scanner sc=new Scanner(System.in);
         int ch=sc.nextInt();
         switch(ch){
             case 1:
                 if(mtext==1 && f!=5)
                     producer();
                 else
                     System.out.println("producer is waiting");
                 break;
             case 2:
                 if(mtext==1 && e!=5)
                 consumer();
                 else
                     System.out.println("consumer is waiting");
                 break;
             case 3:
                 System.exit(02);
        }
        }
    }
}
    
    

