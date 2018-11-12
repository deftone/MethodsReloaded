public class Thermometer {

    private TemperaturScale scale;

    private Thermometer(TemperaturScale scale){
        this.scale = scale;
    }

    private static Thermometer newInstance(TemperaturScale scale){
        return new Thermometer(scale);
    }




    public static void main(String[] args) {

        //this is eaiser to understand
        Thermometer celsiusThermometer = Thermometer.newInstance(TemperaturScale.CELSIUS);
        //than e.g.
//        Thermometer celsiusThermometer = Thermometer.newInstance(true);

        Thermometer fahrenheitThermometer = Thermometer.newInstance(TemperaturScale.FAHRENHEIT);
    }
    

    //and can be expanded easily (e.g. KELVIN)
    private enum TemperaturScale{
        FAHRENHEIT,
        CELSIUS
    }
}
