package jianzhiOffer;

import static jianzhiOffer.Questions2.Nested.*;

/**
 * Created by tangjian on 2016/12/7.
 */
public class Questions2 {

    /*
    饿汉模式
    private  static final Questions2 instance = new Questions2();
    public Questions2 getInstance(){
        return instance;
    }
    */
    //懒汉模式
  /*  private  static  Questions2 instance;
    public Questions2 getInstance(){

        if (instance != null )return instance;

        synchronized (Questions2.class) {
            if (instance == null)
                instance = new Questions2();
        }
        return instance ;
    }*/

  //枚举类
 public Nested getInstance(){
       return instance;
   }

    public static void main(String[] args) {
        Questions2 questions2 = new Questions2();

        Questions2.Nested.A a = new Questions2.Nested.A();

        Questions2.Nested.C c = questions2.getInstance().new C();
    }

    public class A implements B{

        @Override
        public void say() {

        }
    }

      enum Nested {
       instance;

       static  class A{
           public void say(){
               System.out.println("Hello");
           }

       }

         class C{
           public void say(){
               System.out.println("Hello");
           }

       }

       interface B{

           void say();
       }
        public static abstract  class D{
           abstract  void say();
       }

       class  E extends D implements B {
           @Override
           public void say() {

           }


       }

   }


}
