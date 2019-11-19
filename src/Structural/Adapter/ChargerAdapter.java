package Structural.Adapter;

public class ChargerAdapter implements LightningInterface {
    private MicroUsbInterface microUsbInterface;

    public ChargerAdapter(){};

    public ChargerAdapter(MicroUsbInterface microUsbInterface){
        this.microUsbInterface = microUsbInterface;
    }

    @Override
    public void chargeWithLightning() {
        microUsbInterface.chargeWithMicroUsb();
    }
}
