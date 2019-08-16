# synchronized
 三种锁方法： 类锁、方法锁、代码块锁
 
 代码块锁锁：
 ```java
 // 对象锁：形式1（代码块形式）
 public void Method2()
 {
     synchronized (this)
     {
         System.out.println("我是对象锁");
         try
         {
             Thread.sleep(500);
         } catch (InterruptedException e)
         {
             e.printStackTrace();
         }
     }
 
 }
 ```

##注意:
  同步代码块中的obj对象可以是任意对象,但要保证多个线程调用这个方法时,使用的obj对象是同一个,比如obj对象在方法体外部创建,多个线程调用这个方法时,obj对象就是同一个.
 ```java
public class Test 
{ 
 // 方法锁：形式1 
public synchronized void Method1() 
{ 
System.out.println(＂我是方法锁＂); 
try 
{ 
Thread.sleep(500); 
} catch (InterruptedException e) 
{ 
e.printStackTrace(); 
}
```
##注意:
   多线程时使用此锁肯定可以，但是效率较低
    
```java
   // 类锁：形式2
   public void Method２()
   {
       synchronized (Test.class)
       {
           System.out.println(＂我是类锁＂);
           try
           {
               Thread.sleep(500);
           } catch (InterruptedException e)
           {
               e.printStackTrace();
           }
   
       }
   
   }
```