package Creational.Singleton;

class LazySingleton {

    //每个类只能有一个实例，使用场景如log等

    //1 让构造函数私有，保证外部不能通过new来创建新的实例。
    private LazySingleton(){}

    //2 使用静态属性才存储唯一实例，为防止外部修改使用private关键字
    private static LazySingleton instance;

    //3 外部取得实例的方法
    public static synchronized LazySingleton getInstace(){

        if(instance == null){
            instance = new LazySingleton();
        }

        return instance;
    }

}


class EagerSingleton{

    private EagerSingleton(){}

    private static EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getInstance(){
        return instance;
    }

}

//内部类模式
public class Singleton{
    private Singleton(){}

    private static class SingletonHolder{
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }
}
