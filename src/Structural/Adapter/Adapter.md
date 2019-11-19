### 适配器模式
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
将一个类的借口转接成用户所期待的。
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
一个适配器使得因接口不兼容而不能在一起工作的类 能在一起工作，做法是将类自己的接口包裹在一个已存在的类中.

        例如，有一张手机上的内存卡，想放到电脑上看里面的照片和视频，
        但是电脑没办法直接读取内存卡的内容，所以你需要一个读卡器，这个读卡器就是适配器。


先定义接口：
```java
/**
* 内存卡
*/

public interface MemoryCard{
    public void readMemoryCard();
}



/**
* 电脑接口 
*/
public interface ComputerUSBSocket{
    public void readUSB();
}
```
实现电脑类和内存卡
```java

public class Memery implements MemoryCard{
    @Override
        public void readMemoryCard(){
            System.out.println("读取内存卡。。");
        }
}

```

定义适配器
```java
public class ComputerAdapter implements ComputerUSBSocket{
    
    private MemoryCard memory;
    
    public Adapter() {
        memory = new Memory();
    }
    
    @Override
    public void readUSB(){
        memory.readMemoryCard();
    } 
    
}

```

实现电脑类
```java
public class Computer extends ComputerAdater{
    //可以直接使用 readUSB方法
}
```


    另外一个例子，有一台三星手机，充电器为microUsb口， 一台iPhone，为lightning口，要使用三星充电器为iPhone充电。
先定义接口
 ```java
public interface MicroUsbInterface{
    public void chargeWithMicroUsb();
}

public interface LightningInterface{
    public void chargeWithLightening();
}
```     

定义具体实现类
```java
/**
* 三星手机充电器
* */
public class SamsungCharger implements MicroUsbInterface{
    @Override
    public void chargeWithMicroUsb(){
        System.out.println("使用MicroUsb口进行充电。。");
    }
}

/**
* 苹果手机充电器
* */

public class AppleCharger implements LightningInterface{
    @Override
    public void chargeWithLightening(){
        System.out.println("使用Lightning口进行充电。。");
    }
}
```  
定义手机
```java
public class IPhone{
    private LightningInterface lightningInterface;
    
    public IPhone(){}
    
    public IPhone(LightningInterface lightningInterface){
        this.lightningInterface = lightningInterface;
    }
    
    public void charge(){
        System.out.println("开始为iPhone充电。。");
        lightningInterface.chargeWithLightning();
        System.out.println("iPhone充电结束。。");
    }
}

public class SamsungPhone{
    private MicroUsbInterface microUsbInterface;
    
    public SamsungPhone(){}
    
    public SamsungPhone(MicroUsbInterface microUsbInterface){
        this.microUsbInterface =microUsbInterface;
    }
    
    public void charge(){
        System.out.println("开始为三星手机充电。。");
        microUsbInterface.chargeWithMicroUsb();
        System.out.println("三星手机充电结束。。");
    }
    
}

```

定义适配器
```java

public class Adapter implements Lightning{
    
    private MicroUsb microUsbSocket;
    
    public Adapter(MicroUsb microUsb){
        microUsbSocket = microUsb;
    }
    
    @Override
    public void chargeWithLightening(){
        microUsbSocket.chargeWithMicroUsb();
    }
}

```

```java
public class Main{
    public static void main(String[] args){
        Iphone iphone = new Iphone(new AppleCharger());
        iphone.charge();

        System.out.println("=======================");

        SamsungPhone samsungPhone = new SamsungPhone(new SamsungCharger());
        samsungPhone.charge();

        System.out.println("=======================");

        ChargerAdapter chargerAdapter = new ChargerAdapter(new SamsungCharger());
        Iphone iphoneWithSamsungCharger = new Iphone();
        iphoneWithSamsungCharger.setLightningInterface(chargerAdapter);
        iphoneWithSamsungCharger.charge();
        
    }
}
```