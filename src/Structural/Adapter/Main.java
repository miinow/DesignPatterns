package Structural.Adapter;

public class Main {
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
