package Structural.Adapter;

public class Iphone {

    public LightningInterface getLightningInterface() {
        return lightningInterface;
    }

    public void setLightningInterface(LightningInterface lightningInterface) {
        this.lightningInterface = lightningInterface;
    }

    private LightningInterface lightningInterface;

    public Iphone(){}
    public Iphone(LightningInterface lightningInterface){
        this.lightningInterface = lightningInterface;
    }

    public void charge(){
        System.out.println("iphone开始充电");
        lightningInterface.chargeWithLightning();
        System.out.println("iphone充电结束。");
    }

}
