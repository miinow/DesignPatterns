package Structural.Adapter;

public class SamsungCharger implements MicroUsbInterface {
    @Override
    public void chargeWithMicroUsb() {
        System.out.println("正在使用MicroUsb接口充电。");
    }
}
