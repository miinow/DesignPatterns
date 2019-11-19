package Structural.Adapter;

public class SamsungPhone {

    private MicroUsbInterface microUsbInterface;

    public SamsungPhone(){}
    public SamsungPhone(MicroUsbInterface microUsbInterface){
        this.microUsbInterface = microUsbInterface;
    }

    public void charge(){
        System.out.println("开始为三星手机充电。");
        microUsbInterface.chargeWithMicroUsb();
        System.out.println("三星手机充电结束。");
    }

}
