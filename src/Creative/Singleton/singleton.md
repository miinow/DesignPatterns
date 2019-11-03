##### 单例模式
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
只有一个实例， 使用场景如log。。。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
几种实现方式: 饿汉式， 懒汉式，静态内部类(推荐)
    
* 饿汉式, 类初始化时就在内存中创建了对象，不存在线程安全问题。
```java
    
public class EagerSingleton {
    
    //1 让构造函数私有，保证外部不能通过new来创建新的实例。
    private Singleton(){}
    
    //2 使用静态属性才存储唯一实例，为防止外部修改使用private关键字
    private static Singleton instance = new Singleton();
    
    //3 外部取得实例的方法
    public static Singleton getInstace(){
        return instance;
    }

}
```

  * 懒汉式， 对象用到时候在加载，
    可能会导致异常。
    不会在启动时就加载，不会浪费空间。
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
多线程时需要使用synchronized关键字，否则在多线程条件下，线程1正新建单例时，完成赋值操作之前，线程2会认为instance为空，会导致多个实例被创建。    

```java

    public class LazySingleton {
    
        private Singleton(){}
    
        private static Singleton instance;
    
        //多线程时需要使用synchronized关键字，否则会导致多实例被创建问题
        public static synchronized Singleton getInstace(){
            if(instance == null){
                    instance = new Singleton();
                }
            return instance;
        }
    
    }
        

```

* 静态内部类， 外部类加载时不需要立即加载内部类， 内部类则不必去初始化instance， 所以不占内存。也可以保证线程安全。

```java
    public class Singleton{
        
        private Singleton(){}
        
        private static class SingletonHolder{
            private static Singleton instance = new Singleton();
        }
        
        public static Singleton getInstance(){
            return SingletonHolder.instace;
        }
    
    }


```