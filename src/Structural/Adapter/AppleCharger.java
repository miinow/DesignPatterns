package Structural.Adapter;

public class AppleCharger implements LightningInterface {

    @Override
    public void chargeWithLightning(){
        System.out.println("正在使用Lightning接口充电。。");
    }

}
