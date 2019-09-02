package ashunevich.uniconverter20;


import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public abstract class ConverterAdapter extends ConverterActivity {
    public ConverterAdapter(TextView resultView){
        this.resultView = resultView;
    }

    public static void ConvertValues(String txtFromSpinner1, String txtFromSpinner2 , Double enteredValue, TextView resultView) {
        final double NineDivFive = 9.0/5.0;
        final double FiveDivNine = 5.0/9.0;

        NumberFormat formatter = new DecimalFormat("###.########################");
                                                            //0.0000000000003861021585
        switch (txtFromSpinner1) {
            //area
            case "Square millimeter/mm²":
                switch (txtFromSpinner2) {
                    case "Square millimeter/mm²": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Square centimeter/cm²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.01)));break;
                    case "Square meter/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Square kilometer/km²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000000001)));break;
                    case "Hectare/ha": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000001)));break;
                    case "Square mile/mi²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000000003861021585)));break;
                    case "Acre/ac": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000002471053814)));break;
                    case "Square yard/yd²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001196)));break;
                    case "Square feet/ft²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000107639)));break;
                    case "Square inch/in²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0015500031)));break;
                }
                break;
            case "Square centimeter/cm²":
                switch (txtFromSpinner2) {
                    case "Square millimeter/mm²": resultView.setText(String.valueOf(formatter.format(enteredValue*100)));break;
                    case "Square centimeter/cm²": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Square meter/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Square kilometer/km²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000001)));break;
                    case "Hectare/ha": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000001)));break;
                    case "Square mile/mi²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000000003861021585)));break;
                    case "Acre/ac": resultView.setText(String.valueOf(formatter.format(enteredValue *0.00000002471053814)));break;
                    case "Square yard/yd²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000119599)));break;
                    case "Square feet/ft²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001076391)));break;
                    case "Square inch/in²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.15500031)));break;
                }
                break;
            case "Square meter/м²":
                switch (txtFromSpinner2) {
                    case "Square millimeter/mm²": resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Square centimeter/cm²": resultView.setText(String.valueOf(formatter.format(enteredValue * 10000.0)));break;
                    case "Square meter/м²": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Square kilometer/km²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Hectare/ha": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Square mile/mi²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000003861021585)));break;
                    case "Acre/ac": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0002471054)));break;
                    case "Square yard/yd²": resultView.setText(String.valueOf(formatter.format(enteredValue * 1.1959900463)));break;
                    case "Square feet/ft²": resultView.setText(String.valueOf(formatter.format(enteredValue * 10.763910417)));break;
                    case "Square inch/in²": resultView.setText(String.valueOf(formatter.format(enteredValue * 1550.0031)));break;
                }
                break;
            case "Square kilometer/km²":
                switch (txtFromSpinner2) {
                    case "Square millimeter/mm²": resultView.setText(String.valueOf(formatter.format(enteredValue*1000000000000.0)));break;
                    case "Square centimeter/cm²": resultView.setText(String.valueOf(formatter.format(enteredValue * 10000000000.0)));break;
                    case "Square meter/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Square kilometer/km²": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Hectare/ha": resultView.setText(String.valueOf(formatter.format(enteredValue * 100.0)));break;
                    case "Square mile/mi²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.3861021585)));break;
                    case "Acre/ac": resultView.setText(String.valueOf(formatter.format(enteredValue * 247.10538147)));break;
                    case "Square yard/yd²": resultView.setText(String.valueOf(formatter.format(enteredValue * 1195990.0463)));break;
                    case "Square feet/ft²": resultView.setText(String.valueOf(formatter.format(enteredValue * 10763910.417)));break;
                    case "Square inch/in²": resultView.setText(String.valueOf(formatter.format(enteredValue * 1550003100)));break;
                }
                break;
            case "Hectare/ha":
                switch (txtFromSpinner2) {
                    case "Square millimeter/mm²": resultView.setText(String.valueOf(formatter.format(enteredValue*10000000000.0)));break;
                    case "Square centimeter/cm²": resultView.setText(String.valueOf(formatter.format(enteredValue * 100000000)));break;
                    case "Square meter/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 10000)));break;
                    case "Square kilometer/km²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.01)));break;
                    case "Hectare/ha": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Square mile/mi²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0038610216)));break;
                    case "Acre/ac": resultView.setText(String.valueOf(formatter.format(enteredValue * 2.4710538147)));break;
                    case "Square yard/yd²": resultView.setText(String.valueOf(formatter.format(enteredValue * 11959.900463)));break;
                    case "Square feet/ft²": resultView.setText(String.valueOf(formatter.format(enteredValue * 107639.10417)));break;
                    case "Square inch/in²": resultView.setText(String.valueOf(formatter.format(enteredValue * 15500031)));break;
                }
                break;
            case "Square mile/mi²":
                switch (txtFromSpinner2) {
                    case "Square millimeter/mm²": resultView.setText(String.valueOf(formatter.format(enteredValue*2589988110336.0)));break;
                    case "Square centimeter/cm²": resultView.setText(String.valueOf(formatter.format(enteredValue * 25899881103.0)));break;
                    case "Square meter/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 2589988.1103)));break;
                    case "Square kilometer/km²": resultView.setText(String.valueOf(formatter.format(enteredValue * 2.5899881103)));break;
                    case "Hectare/ha": resultView.setText(String.valueOf(formatter.format(enteredValue * 258.99881103)));break;
                    case "Square mile/mi²": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Acre/ac": resultView.setText(String.valueOf(formatter.format(enteredValue * 640)));break;
                    case "Square yard/yd²": resultView.setText(String.valueOf(formatter.format(enteredValue * 3097600)));break;
                    case "Square feet/ft²": resultView.setText(String.valueOf(formatter.format(enteredValue * 27878400)));break;
                    case "Square inch/in²": resultView.setText(String.valueOf(formatter.format(enteredValue * 4014489600.0)));break;
                }
                break;
            case "Acre/ac":
                switch (txtFromSpinner2) {
                    case "Square millimeter/mm²": resultView.setText(String.valueOf(formatter.format(enteredValue*4046856422.4)));break;
                    case "Square centimeter/cm²": resultView.setText(String.valueOf(formatter.format(enteredValue * 40468564.224)));break;
                    case "Square meter/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 4046.8564224)));break;
                    case "Square kilometer/km²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0040468564)));break;
                    case "Hectare/ha": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.4046856422)));break;
                    case "Square mile/mi²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0015625)));break;
                    case "Acre/ac": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Square yard/yd²": resultView.setText(String.valueOf(formatter.format(enteredValue * 4840)));break;
                    case "Square feet/ft²": resultView.setText(String.valueOf(formatter.format(enteredValue * 43560)));break;
                    case "Square inch/in²": resultView.setText(String.valueOf(formatter.format(enteredValue * 6272640)));break;
                }
                break;
            case "Square yard/yd²":
                switch (txtFromSpinner2) {
                    case "Square millimeter/mm²": resultView.setText(String.valueOf(formatter.format(enteredValue*836127.36)));break;
                    case "Square centimeter/cm²": resultView.setText(String.valueOf(formatter.format(enteredValue * 8361.2736)));break;
                    case "Square meter/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.83612736)));break;
                    case "Square kilometer/km²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000008361273599)));break;
                    case "Hectare/ha": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000836127)));break;
                    case "Square mile/mi²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000003228305785)));break;
                    case "Acre/ac": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0002066116)));break;
                    case "Square yard/yd²": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Square feet/ft²": resultView.setText(String.valueOf(formatter.format(enteredValue * 9)));break;
                    case "Square inch/in²": resultView.setText(String.valueOf(formatter.format(enteredValue * 1296)));break;
                }
                break;
            case "Square feet/ft²":
                switch (txtFromSpinner2) {
                    case "Square millimeter/mm²": resultView.setText(String.valueOf(formatter.format(enteredValue*92903.04)));break;
                    case "Square centimeter/cm²": resultView.setText(String.valueOf(formatter.format(enteredValue * 929.0304)));break;
                    case "Square meter/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.09290304)));break;
                    case "Square kilometer/km²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000009290303999)));break;
                    case "Hectare/ha": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000092903)));break;
                    case "Square mile/mi²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000387006427)));break;
                    case "Acre/ac": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000229568)));break;
                    case "Square yard/yd²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1111111111)));break;
                    case "Square feet/ft²": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Square inch/in²": resultView.setText(String.valueOf(formatter.format(enteredValue * 144)));break;
                }
            case "Square inch/in²":
                switch (txtFromSpinner2) {
                    case "Square millimeter/mm²": resultView.setText(String.valueOf(formatter.format(enteredValue*645.16)));break;
                    case "Square centimeter/cm²": resultView.setText(String.valueOf(formatter.format(enteredValue * 6.4516)));break;
                    case "Square meter/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00064516)));break;
                    case "Square kilometer/km²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000000064516)));break;
                    case "Hectare/ha": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000064516)));break;
                    case "Square mile/mi²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000000290976686)));break;
                    case "Acre/ac": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000001594225079)));break;
                    case "Square yard/yd²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0007716049)));break;
                    case "Square feet/ft²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0069444444)));break;
                    case "Дюйм квадратний/д²": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
                //force
            case "Mlilinewton/mN":
                switch (txtFromSpinner2) {
                    case "Mlilinewton/mN":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Newton/N":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Kilonewton/kN":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Ton-force(metric)/tf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000001019716212)));break;
                    case "Gram-force/gf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1019)));break;
                    case "Kilogram-force/kgf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000101)));break;
                    case "Pond/p":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1019)));break;
                    case "Pound-force/lbf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00022)));break;
                    case "Ounce-force/ozf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00359)));break;
                    case "Ton-force (long)/tonf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000001003611353)));break;
                    case "Poundal/pdl":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00723)));break;
                }
                break;
            case "Newton/N":
                switch (txtFromSpinner2) {
                    case "Mlilinewton/mN":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Newton/N":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Kilonewton/kN":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Ton-force(metric)/tf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Gram-force/gf":resultView.setText(String.valueOf(formatter.format(enteredValue * 101.971)));break;
                    case "Kilogram-force/kgf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.10197)));break;
                    case "Pond/p":resultView.setText(String.valueOf(formatter.format(enteredValue * 101.971)));break;
                    case "Pound-force/lbf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.22480)));break;
                    case "Ounce-force/ozf":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.5969)));break;
                    case "Ton-force (long)/tonf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Poundal/pdl":resultView.setText(String.valueOf(formatter.format(enteredValue * 7.233)));break;
                }
                break;
            case "Kilonewton/kN":
                switch (txtFromSpinner2) {
                    case "Mlilinewton/mN":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Newton/N":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Kilonewton/kN":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Ton-force(metric)/tf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.101971)));break;
                    case "Gram-force/gf":resultView.setText(String.valueOf(formatter.format(enteredValue * 101971.6)));break;
                    case "Kilogram-force/kgf":resultView.setText(String.valueOf(formatter.format(enteredValue * 101.971)));break;
                    case "Pond/p":resultView.setText(String.valueOf(formatter.format(enteredValue * 101971.6)));break;
                    case "Pound-force/lbf":resultView.setText(String.valueOf(formatter.format(enteredValue * 224.81)));break;
                    case "Ounce-force/ozf":resultView.setText(String.valueOf(formatter.format(enteredValue * 3596.94)));break;
                    case "Ton-force (long)/tonf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1003)));break;
                    case "Poundal/pdl":resultView.setText(String.valueOf(formatter.format(enteredValue * 7233.01)));break;
                }
                break;
            case "Ton-force(metric)/tf":
                switch (txtFromSpinner2) {
                    case "Mlilinewton/mN":resultView.setText(String.valueOf(formatter.format(enteredValue * 9806650)));break;
                    case "Newton/N":resultView.setText(String.valueOf(formatter.format(enteredValue * 9806.65)));break;
                    case "Kilonewton/kN":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.80665)));break;
                    case "Ton-force(metric)/tf":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Gram-force/gf":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Kilogram-force/kgf":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Pond/p":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Pound-force/lbf":resultView.setText(String.valueOf(formatter.format(enteredValue * 2204.62)));break;
                    case "Ounce-force/ozf":resultView.setText(String.valueOf(formatter.format(enteredValue * 35273.96)));break;
                    case "Ton-force (long)/tonf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.9842)));break;
                    case "Poundal/pdl":resultView.setText(String.valueOf(formatter.format(enteredValue * 70931.63)));break;
                }
                break;
            case "Gram-force/gf":
                switch (txtFromSpinner2) {
                    case "Mlilinewton/mN":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.8066)));break;
                    case "Newton/N":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.009806)));break;
                    case "Kilonewton/kN":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000098067)));break;
                    case "Ton-force(metric)/tf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Gram-force/gf":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Kilogram-force/kgf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Pond/p":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000007039)));break;
                    case "Pound-force/lbf":resultView.setText(String.valueOf(formatter.format(enteredValue*0.002204)));break;
                    case "Ounce-force/ozf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.03527)));break;
                    case "Ton-force (long)/tonf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000009842065276)));break;
                    case "Poundal/pdl":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.07093)));break;
                }
                break;
            case "Kilogram-force/kgf":
                switch (txtFromSpinner2) {
                    case "Mlilinewton/mN":resultView.setText(String.valueOf(formatter.format(enteredValue *9806.65)));break;
                    case "Newton/N":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.80665)));break;
                    case "Kilonewton/kN":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0098066)));break;
                    case "Ton-force(metric)/tf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Gram-force/gf":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Kilogram-force/kgf":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Pond/p":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Pound-force/lbf":resultView.setText(String.valueOf(formatter.format(enteredValue * 2.20)));break;
                    case "Ounce-force/ozf":resultView.setText(String.valueOf(formatter.format(enteredValue * 35.273)));break;
                    case "Ton-force (long)/tonf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0009842)));break;
                    case "Poundal/pdl":resultView.setText(String.valueOf(formatter.format(enteredValue * 70.931)));break;
                }
                break;
            case "Pond/p":
                switch (txtFromSpinner2) {
                    case "Mlilinewton/mN":resultView.setText(String.valueOf(formatter.format(enteredValue *9.80665)));break;
                    case "Newton/N":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00980)));break;
                    case "Kilonewton/kN":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000098)));break;
                    case "Ton-force(metric)/tf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Gram-force/gf":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Kilogram-force/kgf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Pond/p":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Pound-force/lbf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.002204)));break;
                    case "Ounce-force/ozf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.03527)));break;
                    case "Ton-force (long)/tonf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000009842065276)));break;
                    case "Poundal/pdl":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.07093)));break;
                }
                break;
            case "Pound-force/lbf":
                switch (txtFromSpinner2) {
                    case "Mlilinewton/mN":resultView.setText(String.valueOf(formatter.format(enteredValue *4448.221)));break;
                    case "Newton/N":resultView.setText(String.valueOf(formatter.format(enteredValue * 4.448)));break;
                    case "Kilonewton/kN":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00444)));break;
                    case "Ton-force(metric)/tf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00045)));break;
                    case "Gram-force/gf":resultView.setText(String.valueOf(formatter.format(enteredValue * 453.59)));break;
                    case "Kilogram-force/kgf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.45359)));break;
                    case "Pond/p":resultView.setText(String.valueOf(formatter.format(enteredValue * 453.59)));break;
                    case "Pound-force/lbf":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Ounce-force/ozf":resultView.setText(String.valueOf(formatter.format(enteredValue * 16)));break;
                    case "Ton-force (long)/tonf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0004464)));break;
                    case "Poundal/pdl":resultView.setText(String.valueOf(formatter.format(enteredValue * 32.174)));break;
                }
                break;
            case "Ounce-force/ozf":
                switch (txtFromSpinner2) {
                    case "Mlilinewton/mN":resultView.setText(String.valueOf(formatter.format(enteredValue *278.013)));break;
                    case "Newton/N":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.27801)));break;
                    case "Kilonewton/kN":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0002780)));break;
                    case "Ton-force(metric)/tf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000283)));break;
                    case "Gram-force/gf":resultView.setText(String.valueOf(formatter.format(enteredValue * 28.349)));break;
                    case "Kilogram-force/kgf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.02834)));break;
                    case "Pond/p":resultView.setText(String.valueOf(formatter.format(enteredValue * 28.349)));break;
                    case "Pound-force/lbf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0625)));break;
                    case "Ounce-force/ozf":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Ton-force (long)/tonf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000279)));break;
                    case "Poundal/pdl":resultView.setText(String.valueOf(formatter.format(enteredValue * 2.010)));break;
                }
                break;
            case "Ton-force (long)/tonf":
                switch (txtFromSpinner2) {
                    case "Mlilinewton/mN":resultView.setText(String.valueOf(formatter.format(enteredValue *9964016.41)));break;
                    case "Newton/N":resultView.setText(String.valueOf(formatter.format(enteredValue * 9964.01)));break;
                    case "Kilonewton/kN":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.9640)));break;
                    case "Ton-force(metric)/tf":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.016)));break;
                    case "Gram-force/gf":resultView.setText(String.valueOf(formatter.format(enteredValue * 1016046.90)));break;
                    case "Kilogram-force/kgf":resultView.setText(String.valueOf(formatter.format(enteredValue * 1016.046)));break;
                    case "Pond/p":resultView.setText(String.valueOf(formatter.format(enteredValue * 1016046.90)));break;
                    case "Pound-force/lbf":resultView.setText(String.valueOf(formatter.format(enteredValue * 2240.0)));break;
                    case "Ounce-force/ozf":resultView.setText(String.valueOf(formatter.format(enteredValue * 35840.0)));break;
                    case "Ton-force (long)/tonf":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Poundal/pdl":resultView.setText(String.valueOf(formatter.format(enteredValue * 72069.86)));break;
                }
                break;
            case "Poundal/pdl":
                switch (txtFromSpinner2) {
                    case "Mlilinewton/mN":resultView.setText(String.valueOf(formatter.format(enteredValue *138.25)));break;
                    case "Newton/N":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.13825)));break;
                    case "Kilonewton/kN":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000138)));break;
                    case "Ton-force(metric)/tf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000140)));break;
                    case "Gram-force/gf":resultView.setText(String.valueOf(formatter.format(enteredValue * 14.09)));break;
                    case "Kilogram-force/kgf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.01409)));break;
                    case "Pond/p":resultView.setText(String.valueOf(formatter.format(enteredValue * 14.09)));break;
                    case "Pound-force/lbf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.03108)));break;
                    case "Ounce-force/ozf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.4972)));break;
                    case "Ton-force (long)/tonf":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000138)));break;
                    case "Poundal/pdl":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
            case "Millimetre/mm":
                switch (txtFromSpinner2){
                    case "Millimetre/mm":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Centimetre/sm":resultView.setText(String.valueOf(formatter.format(enteredValue*0.1)));break;
                    case "Metre/m":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Kilometre/km":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Inch/in":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03937)));break;
                    case "Foot/ft":resultView.setText(String.valueOf(formatter.format(enteredValue*0.003280)));break;
                    case "Yard/yd":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001093)));break;
                    case "Mile/mi":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000062137)));break;
                }
                break;
            case "Centimetre/sm":
                switch (txtFromSpinner2){
                    case "Millimetre/mm":resultView.setText(String.valueOf(formatter.format(enteredValue*10)));break;
                    case "Centimetre/sm":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Metre/m":resultView.setText(String.valueOf(formatter.format(enteredValue*0.01)));break;
                    case "Kilometre/km":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00001)));break;
                    case "Inch/in":resultView.setText(String.valueOf(formatter.format(enteredValue*0.3937)));break;
                    case "Foot/ft":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03280)));break;
                    case "Yard/yd":resultView.setText(String.valueOf(formatter.format(enteredValue*0.01093)));break;
                    case "Mile/mi":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000006213)));break;
                }
                break;
            case "Metre/m":
                switch (txtFromSpinner2){
                    case "Millimetre/mm":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Centimetre/sm":resultView.setText(String.valueOf(formatter.format(enteredValue*100)));break;
                    case "Metre/m":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Kilometre/km":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Inch/in":resultView.setText(String.valueOf(formatter.format(enteredValue*39.37007)));break;
                    case "Foot/ft":resultView.setText(String.valueOf(formatter.format(enteredValue*3.2808)));break;
                    case "Yard/yd":resultView.setText(String.valueOf(formatter.format(enteredValue*1.09361)));break;
                    case "Mile/mi":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00062137)));break;
                }
                break;
            case "Kilometre/km":
                switch (txtFromSpinner2){
                    case "Millimetre/mm":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Centimetre/sm":resultView.setText(String.valueOf(formatter.format(enteredValue*100000.0)));break;
                    case "Metre/m":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Kilometre/km":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Inch/in":resultView.setText(String.valueOf(formatter.format(enteredValue*39370.08)));break;
                    case "Foot/ft":resultView.setText(String.valueOf(formatter.format(enteredValue*3280.84)));break;
                    case "Yard/yd":resultView.setText(String.valueOf(formatter.format(enteredValue*1093.6132)));break;
                    case "Mile/mi":resultView.setText(String.valueOf(formatter.format(enteredValue*0.6214)));break;
                }
                break;
            case "Inch/in":
                switch (txtFromSpinner2){
                    case "Millimetre/mm":resultView.setText(String.valueOf(formatter.format(enteredValue*25.4)));break;
                    case "Centimetre/sm":resultView.setText(String.valueOf(formatter.format(enteredValue*2.54)));break;
                    case "Metre/m":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0254)));break;
                    case "Kilometre/km":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000254)));break;
                    case "Inch/in":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Foot/ft":resultView.setText(String.valueOf(formatter.format(enteredValue*0.08333)));break;
                    case "Yard/yd":resultView.setText(String.valueOf(formatter.format(enteredValue*0.02777)));break;
                    case "Mile/mi":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00001578)));break;
                }
                break;
            case "Foot/ft":
                switch (txtFromSpinner2){
                    case "Millimetre/mm":resultView.setText(String.valueOf(formatter.format(enteredValue*304.8)));break;
                    case "Centimetre/sm":resultView.setText(String.valueOf(formatter.format(enteredValue*30.48)));break;
                    case "Metre/m":resultView.setText(String.valueOf(formatter.format(enteredValue*0.3048)));break;
                    case "Kilometre/km":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0003048)));break;
                    case "Inch/in":resultView.setText(String.valueOf(formatter.format(enteredValue*12)));break;
                    case "Foot/ft":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Yard/yd":resultView.setText(String.valueOf(formatter.format(enteredValue*0.33333)));break;
                    case "Mile/mi":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001893936)));break;
                }
                break;
            case "Yard/yd":
                switch (txtFromSpinner2){
                    case "Millimetre/mm":resultView.setText(String.valueOf(formatter.format(enteredValue*914.4)));break;
                    case "Centimetre/sm":resultView.setText(String.valueOf(formatter.format(enteredValue*91.44)));break;
                    case "Metre/m":resultView.setText(String.valueOf(formatter.format(enteredValue*0.9144)));break;
                    case "Kilometre/km":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0009144)));break;
                    case "Inch/in":resultView.setText(String.valueOf(formatter.format(enteredValue*36)));break;
                    case "Foot/ft":resultView.setText(String.valueOf(formatter.format(enteredValue*3)));break;
                    case "Yard/yd":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Mile/mi":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0005681)));break;
                }
                break;
            case "Mile/mi":
                switch (txtFromSpinner2){
                    case "Millimetre/mm":resultView.setText(String.valueOf(formatter.format(enteredValue*1609347.21)));break;
                    case "Centimetre/sm":resultView.setText(String.valueOf(formatter.format(enteredValue*160934.72)));break;
                    case "Metre/m":resultView.setText(String.valueOf(formatter.format(enteredValue*1609.34)));break;
                    case "Kilometre/km":resultView.setText(String.valueOf(formatter.format(enteredValue*1.6093)));break;
                    case "Inch/in":resultView.setText(String.valueOf(formatter.format(enteredValue*63360.12)));break;
                    case "Foot/ft":resultView.setText(String.valueOf(formatter.format(enteredValue*5280.010)));break;
                    case "Yard/yd":resultView.setText(String.valueOf(formatter.format(enteredValue*1760)));break;
                    case "Mile/mi":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
            case "Milligram/mg":
                switch (txtFromSpinner2){
                    case "Gram/g":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001))); break;
                    case "Kilogram/kg":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001))); break;
                    case "Tonne/t":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001))); break;
                    case "Grain/gr":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0154))); break;
                    case "Ounce/oz":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000035))); break;
                    case "Pound/lb":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000022))); break;
                    case "Hundreweight/hw":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00000002))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001016))); break;
                    case "Milligram/mg":resultView.setText(String.valueOf(formatter.format(enteredValue)));
                }
                break;
            case "Gram/g":
                switch (txtFromSpinner2){
                    case "Milligram/mg":resultView.setText(String.valueOf(formatter.format(enteredValue*1000.0))); break;
                    case "Kilogram/kg":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001))); break;
                    case "Tonne/t": resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001))); break;
                    case "Grain/gr":resultView.setText(String.valueOf(formatter.format(enteredValue*15.43))); break;
                    case "Ounce/oz":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03527))); break;
                    case "Pound/lb":resultView.setText(String.valueOf(formatter.format(enteredValue*0.002204))); break;
                    case "Hundreweight/hw":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000196))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000009))); break;
                    case "Gram/g":resultView.setText(String.valueOf(formatter.format(enteredValue)));
                }
                break;
            case "Kilogram/kg":
                switch (txtFromSpinner2){
                    case "Milligram/mg":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0))); break;
                    case "Gram/g":resultView.setText(String.valueOf(formatter.format(enteredValue*1000.0))); break;
                    case "Tonne/t": //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue*0.001))); break;
                    case "Grain/gr":resultView.setText(String.valueOf(formatter.format(enteredValue*15432.35))); break;
                    case "Ounce/oz":resultView.setText(String.valueOf(formatter.format(enteredValue*35.27))); break;
                    case "Pound/lb":resultView.setText(String.valueOf(formatter.format(enteredValue*2.20))); break;
                    case "Hundreweight/hw":resultView.setText(String.valueOf(formatter.format(enteredValue*0.01968))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000984))); break;
                    case "Kilogram/kg":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Tonne/t":
                switch (txtFromSpinner2){
                    case "Milligram/mg":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000000.0))); break;
                    case "Gram/g":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0))); break;
                    case "Kilogram/kg": //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue*1000.0))); break;
                    case "Grain/gr":resultView.setText(String.valueOf(formatter.format(enteredValue*15432358.35))); break;
                    case "Ounce/oz":resultView.setText(String.valueOf(formatter.format(enteredValue*35273.96))); break;
                    case "Pound/lb":resultView.setText(String.valueOf(formatter.format(enteredValue*2204.62))); break;
                    case "Hundreweight/hw":resultView.setText(String.valueOf(formatter.format(enteredValue*19.68))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.9842))); break;
                    case "Tonne/t":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Grain/gr":
                switch (txtFromSpinner2){
                    case "Milligram/mg":resultView.setText(String.valueOf(formatter.format(enteredValue*64.79))); break;
                    case "Gram/g":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0647))); break;
                    case "Kilogram/kg":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000064))); break;
                    case "Tonne/t":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000065))); break;
                    case "Ounce/oz":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00228))); break;
                    case "Pound/lb":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000142857))); break;
                    case "Hundreweight/hw":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001429))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000064))); break;
                    case "Grain/gr":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Ounce/oz ":
                switch (txtFromSpinner2){
                    case "Milligram/mg":resultView.setText(String.valueOf(formatter.format(enteredValue*28349.52))); break;
                    case "Gram/g":resultView.setText(String.valueOf(formatter.format(enteredValue*28.349))); break;
                    case "Kilogram/kg": //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue*0.02834))); break;
                    case "Tonne/t":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00002835))); break;
                    case "Grain/gr":resultView.setText(String.valueOf(formatter.format(enteredValue*437.49))); break;
                    case "Pound/lb":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0625))); break;
                    case "Hundreweight/hw":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000558036))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000279022))); break;
                    case "Ounce/oz":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Pound/lb ":
                switch (txtFromSpinner2){
                    case "Milligram/mg":resultView.setText(String.valueOf(formatter.format(enteredValue*453592.37))); break;
                    case "Gram/g":resultView.setText(String.valueOf(formatter.format(enteredValue*453.59))); break;
                    case "Kilogram/kg":resultView.setText(String.valueOf(formatter.format(enteredValue*0.4535))); break;
                    case "Tonne/t":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0004535))); break;
                    case "Grain/gr":resultView.setText(String.valueOf(formatter.format(enteredValue*6999.99))); break;
                    case "Ounce/oz":resultView.setText(String.valueOf(formatter.format(enteredValue*16))); break;
                    case "Hundreweight/hw":resultView.setText(String.valueOf(formatter.format(enteredValue*0.008928571))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000446429))); break;
                    case "Pound/lb":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Hundreweight/hw ":
                switch (txtFromSpinner2){
                    case "Milligram/mg":resultView.setText(String.valueOf(formatter.format(enteredValue*50802345.44))); break;
                    case "Gram/g":resultView.setText(String.valueOf(formatter.format(enteredValue*50802.34))); break;
                    case "Kilogram/kg": resultView.setText(String.valueOf(formatter.format(enteredValue*50.80))); break;
                    case "Tonne/t":resultView.setText(String.valueOf(formatter.format(enteredValue*0.05080))); break;
                    case "Grain/gr":resultView.setText(String.valueOf(formatter.format(enteredValue*783999.999))); break;
                    case "Ounce/oz":resultView.setText(String.valueOf(formatter.format(enteredValue*1792))); break;
                    case "Pound/lb":resultView.setText(String.valueOf(formatter.format(enteredValue*112))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.05))); break;
                    case "Hundreweight/hw":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Ton(long)/tl ":
                switch (txtFromSpinner2){
                    case "Milligram/mg":resultView.setText(String.valueOf(formatter.format(enteredValue*1016046908.8))); break;
                    case "Gram/g":resultView.setText(String.valueOf(formatter.format(enteredValue*1016046.90))); break;
                    case "Kilogram/kg": //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue*1016.04))); break;
                    case "Tonne/t":resultView.setText(String.valueOf(formatter.format(enteredValue*1.016))); break;
                    case "Grain/gr":resultView.setText(String.valueOf(formatter.format(enteredValue*15679999.99))); break;
                    case "Ounce/oz":resultView.setText(String.valueOf(formatter.format(enteredValue*35840.0))); break;
                    case "Pound/lb":resultView.setText(String.valueOf(formatter.format(enteredValue*2240.0))); break;
                    case "Hundreweight/hw":resultView.setText(String.valueOf(formatter.format(enteredValue*20.0))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
            case "Meter/second[m/s]":
                switch (txtFromSpinner2) {
                    case "Meter/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Meter/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3600)));break;
                    case "Kilometer/second[km/s]":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Kilometer/hour[km/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.6)));break;
                    case "Mach(SI)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0033)));break;
                    case "Foot/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.28)));break;
                    case "Foot/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 11811.02)));break;
                    case "Mile/hour[mi/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 2.23)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.943)));break;
                }
                break;
            case "Meter/hour[m/h]":
                switch (txtFromSpinner2) {
                    case "Meter/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00027)));break;
                    case "Meter/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Kilometer/second[km/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000002777777777)));break;
                    case "Kilometer/hour[km/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Foot/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0009)));break;
                    case "Foot/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.28)));break;
                    case "Mile/hour[mi/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00062)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00053)));break;
                }
                break;
            case "Kilometer/second[km/s]":
                switch (txtFromSpinner2) {
                    case "Meter/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.277)));break;
                    case "Meter/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Kilometer/second[km/s]":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00027)));break;
                    case "Kilometer/hour[km/h]":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Foot/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.911)));break;
                    case "Foot/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3280.8)));break;
                    case "Mile/hour[mi/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.621)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.539)));break;

                }
                break;
            case "Kilometer/hour[km/h]":
                switch (txtFromSpinner2) {
                    case "Meter/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.2777)));break;
                    case "Meter/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Kilometer/second[km/s]":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00027)));break;
                    case "Kilometer/hour[km/h]":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Foot/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.911)));break;
                    case "Фут/година[ф/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3280.8)));break;
                    case "Mile/hour[mi/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.621)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.539)));break;
                }
                break;
            case "Foot/second[m/s]":
                switch (txtFromSpinner2) {
                    case "Meter/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.3048)));break;
                    case "Meter/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1097.28)));break;
                    case "Kilometer/second[km/s]":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0003048)));break;
                    case "Kilometer/hour[km/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.09728)));break;
                    case "Foot/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Foot/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3600)));break;
                    case "Mile/hour[mi/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.681)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.5924)));break;
                }
                break;
            case "Foot/hour[m/h]":
                switch (txtFromSpinner2) {
                    case "Meter/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000084)));break;
                    case "Meter/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.3)));break;
                    case "Kilometer/second[km/s]":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000008466666666)));break;
                    case "Kilometer/hour[km/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00030)));break;
                    case "Foot/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00027)));break;
                    case "Foot/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Mile/hour[mi/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00018)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00016)));break;

                }
                break;
            case "Mile/hour[mi/h]":
                switch (txtFromSpinner2) {
                    case "Meter/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.44)));break;
                    case "Meter/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1609.3)));break;
                    case "Kilometer/second[km/s]":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00044)));break;

                    case "Kilometer/hour[km/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.6)));break;

                    case "Foot/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.46)));break;
                    case "Foot/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 5280)));break;

                    case "Mile/hour[mi/h]":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.8689)));break;

                }
                break;
            case "Knot/kt":
                switch (txtFromSpinner2) {
                    case "Meter/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.514)));break;
                    case "Meter/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1852)));break;
                    case "Kilometer/second[km/s]":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00051)));break;
                    case "Kilometer/hour[km/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.852)));break;
                    case "Foot/second[m/s]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.687)));break;
                    case "Foot/hour[m/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 6076.11)));break;
                    case "Mile/hour[mi/h]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.150)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
                break;
            case "Celsius/°C":
                switch (txtFromSpinner2) {
                    case "Celsius/°C":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Fahrenheit/°F":resultView.setText(String.valueOf(formatter.format(enteredValue * NineDivFive +32)));break;
                    case "Kelvin/°K":resultView.setText(String.valueOf(formatter.format(enteredValue + 273.15)));break;
                    case "Rankine/°R":resultView.setText(String.valueOf(formatter.format(enteredValue * NineDivFive +491.76)));break;
                }
                break;
            case "Kelvin/°K":
                switch (txtFromSpinner2) {
                    case "Celsius/°C":resultView.setText(String.valueOf(formatter.format(enteredValue-273.15)));break;//here
                    case "Fahrenheit/°F":resultView.setText(String.valueOf(formatter.format((enteredValue-273.15)*NineDivFive +32)));break; //here
                    case "Kelvin/°K":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Rankine/°R":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.8)));break;
                }
                break;
            case "Rankine/°R"  :
                switch (txtFromSpinner2) {
                    case "Celsius/°C":resultView.setText(String.valueOf(formatter.format((enteredValue-491.67)*FiveDivNine)));break;//here
                    case "Fahrenheit/°F":resultView.setText(String.valueOf(formatter.format(enteredValue-459.67)));break;//here
                    case "Kelvin/°K":resultView.setText(String.valueOf(formatter.format(enteredValue*(5.0/9.0))));break;
                    case "Rankine/°R":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
                break;
            case "Fahrenheit/°F" :
                switch (txtFromSpinner2) {
                    case "Celsius/°C":resultView.setText(String.valueOf(formatter.format((enteredValue-32)*(5.0/9.0))));break;
                    case "Fahrenheit/°F":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Kelvin/°K":resultView.setText(String.valueOf(formatter.format((enteredValue-32.00)*(5.0/9.0)+273.15)));break;
                    case "Rankine/°R":resultView.setText(String.valueOf(formatter.format(enteredValue + 459.67)));break;
                }
            case "Seconds":
                switch (txtFromSpinner2) {
                    case "Seconds":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Minutes":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0166666667)));break;
                    case "Hour":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0002777778)));break;
                    case "Day":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000115741)));break;
                    case "Week":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000016534)));break;
                    case "Month":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000003805175038)));break;
                    case "Year":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00000003170979198)));break;
                }
                break;
            case "Minutes":
                switch (txtFromSpinner2) {
                    case "Seconds":resultView.setText(String.valueOf(formatter.format(enteredValue*60)));break;
                    case "Minutes":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Hour":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0166666667)));break;
                    case "Day":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0006944444)));break;
                    case "Week":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000992063)));break;
                    case "Month":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000228311)));break;
                    case "Year":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000019026)));break;
                }
                break;
            case "Hour":
                switch (txtFromSpinner2) {
                    case "Seconds":resultView.setText(String.valueOf(formatter.format(enteredValue*3600)));break;
                    case "Minutes":resultView.setText(String.valueOf(formatter.format(enteredValue*60)));break;
                    case "Hour":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Day":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0416666667)));break;
                    case "Week":resultView.setText(String.valueOf(formatter.format(enteredValue*0.005952381)));break;
                    case "Month":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001369863)));break;
                    case "Year":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001141553)));break;
                }
                break;
            case "Day":
                switch (txtFromSpinner2) {
                    case "Seconds":resultView.setText(String.valueOf(formatter.format(enteredValue*604800)));break;
                    case "Minutes":resultView.setText(String.valueOf(formatter.format(enteredValue*10080)));break;
                    case "Hour":resultView.setText(String.valueOf(formatter.format(enteredValue*168)));break;
                    case "Day":resultView.setText(String.valueOf(formatter.format(enteredValue*7)));break;
                    case "Week":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Month":resultView.setText(String.valueOf(formatter.format(enteredValue*0.23)));break;
                    case "Year":resultView.setText(String.valueOf(formatter.format(enteredValue*0.19)));break;
                }
                break;
            case "Week":
                switch (txtFromSpinner2) {
                    case "Seconds":resultView.setText(String.valueOf(formatter.format(enteredValue*604800)));break;
                    case "Minutes":resultView.setText(String.valueOf(formatter.format(enteredValue*10080)));break;
                    case "Hour":resultView.setText(String.valueOf(formatter.format(enteredValue*168)));break;
                    case "Day":resultView.setText(String.valueOf(formatter.format(enteredValue*7)));break;
                    case "Week":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Month":resultView.setText(String.valueOf(formatter.format(enteredValue*0.2301369863)));break;
                    case "Year":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0191780822)));break;
                }
                break;
            case "Month":
                switch (txtFromSpinner2) {
                    case "Seconds":resultView.setText(String.valueOf(formatter.format(enteredValue*2628000)));break;
                    case "Minutes":resultView.setText(String.valueOf(formatter.format(enteredValue*43800)));break;
                    case "Hour":resultView.setText(String.valueOf(formatter.format(enteredValue*730)));break;
                    case "Day":resultView.setText(String.valueOf(formatter.format(enteredValue*30.416666667)));break;
                    case "Week":resultView.setText(String.valueOf(formatter.format(enteredValue*4.3452380952)));break;
                    case "Month":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Year":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0833333333)));break;
                }
                break;
            case "Year":
                switch (txtFromSpinner2) {
                    case "Seconds":resultView.setText(String.valueOf(formatter.format(enteredValue*31536000)));break;
                    case "Minutes":resultView.setText(String.valueOf(formatter.format(enteredValue*525600)));break;
                    case "Hour":resultView.setText(String.valueOf(formatter.format(enteredValue*8760)));break;
                    case "Day":resultView.setText(String.valueOf(formatter.format(enteredValue*365)));break;
                    case "Week":resultView.setText(String.valueOf(formatter.format(enteredValue*52.142857143)));break;
                    case "Month":resultView.setText(String.valueOf(formatter.format(enteredValue*12)));break;
                    case "Year":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
            case "Cubic millimetre/mm³":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre/mm³":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Cubic centimetre/cm³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Cubic metre/m³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001)));break;
                    case "Milliliter/ml":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Liter/L":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Fluid ounce/fl oz":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000351951)));break;
                    case "Gill/gi":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000007039)));break;
                    case "Pint/pt":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000017598)));break;
                    case "Quart/qt":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000008798769931)));break;
                    case "Gallon/gal":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000002199692482)));break;
                    case "Barrel(UK)/bbl(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000006110256897)));break;
                }
                break;
            case "Cubic centimetre/cm³":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre/mm³":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Cubic centimetre/cm³":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Cubic metre/m³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Milliliter/ml":resultView.setText(String.valueOf(formatter.format(enteredValue*1)));break;
                    case "Liter/L":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Fluid ounce/fl oz":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0351950797)));break;
                    case "Gill/gi":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0070390159)));break;
                    case "Pint/pt":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001759754)));break;
                    case "Quart/qt":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000879877)));break;
                    case "Gallon/gal":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0002199692)));break;
                    case "Barrel(UK)/bbl(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000002199692482)));break;
                }
                break;
            case "Cubic metre/m³":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre/mm³":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0000)));break;
                    case "Cubic centimetre/cm³":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Cubic metre/m³":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Milliliter/ml":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Liter/L":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Fluid ounce/fl oz":resultView.setText(String.valueOf(formatter.format(enteredValue*35195.079728)));break;
                    case "Gill/gi":resultView.setText(String.valueOf(formatter.format(enteredValue*7039.0159456)));break;
                    case "Pint/pt":resultView.setText(String.valueOf(formatter.format(enteredValue*1759.7539864)));break;
                    case "Quart/qt":resultView.setText(String.valueOf(formatter.format(enteredValue*879.8769932)));break;
                    case "Gallon/gal":resultView.setText(String.valueOf(formatter.format(enteredValue*219.9692483)));break;
                    case "Barrel(UK)/bbl(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*6.1102568972)));break;
                }
                break;
            case "Milliliter/ml":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre/mm³":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Cubic centimetre/cm³":resultView.setText(String.valueOf(formatter.format(enteredValue*1)));break;
                    case "Cubic metre/m³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Milliliter/ml":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Liter/L":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Fluid ounce/fl oz":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0351950797)));break;
                    case "Gill/gi":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0070390159)));break;
                    case "Pint/pt":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001759754)));break;
                    case "Quart/qt":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000879877)));break;
                    case "Gallon/gal":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0002199692)));break;
                    case "Barrel(UK)/bbl(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000061103)));break;
                }
                break;
            case "Liter/L":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre/mm³":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Cubic centimetre/cm³":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Cubic metre/m³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Milliliter/ml":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Liter/L":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Fluid ounce/fl oz":resultView.setText(String.valueOf(formatter.format(enteredValue*35.195079728)));break;
                    case "Gill/gi":resultView.setText(String.valueOf(formatter.format(enteredValue*7.0390159456)));break;
                    case "Pint/pt":resultView.setText(String.valueOf(formatter.format(enteredValue*1.7597539864)));break;
                    case "Quart/qt":resultView.setText(String.valueOf(formatter.format(enteredValue*0.8798769932)));break;
                    case "Gallon/gal":resultView.setText(String.valueOf(formatter.format(enteredValue*0.2199692483)));break;
                    case "Barrel(UK)/bbl(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0061102569)));break;
                }
                break;
            case "Gill/gi":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre/mm³":resultView.setText(String.valueOf(formatter.format(enteredValue*142065.3125)));break;
                    case "Cubic centimetre/cm³":resultView.setText(String.valueOf(formatter.format(enteredValue*142.0653125)));break;
                    case "Cubic metre/m³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001420653)));break;
                    case "Milliliter/ml":resultView.setText(String.valueOf(formatter.format(enteredValue*142.0653125)));break;
                    case "Liter/L":resultView.setText(String.valueOf(formatter.format(enteredValue*0.1420653125)));break;
                    case "Fluid ounce/fl oz":resultView.setText(String.valueOf(formatter.format(enteredValue*5)));break;
                    case "Gill/gi":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Pint/pt":resultView.setText(String.valueOf(formatter.format(enteredValue*0.25)));break;
                    case "Quart/qt":resultView.setText(String.valueOf(formatter.format(enteredValue*0.125)));break;
                    case "Gallon/gal":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03125)));break;
                    case "Barrel(UK)/bbl(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0008680556)));break;
                }
                break;
            case "Fluid ounce/fl oz":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre/mm³":resultView.setText(String.valueOf(formatter.format(enteredValue*28413.0625)));break;
                    case "Cubic centimetre/cm³":resultView.setText(String.valueOf(formatter.format(enteredValue*28.4130625)));break;
                    case "Cubic metre/m³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000284131)));break;
                    case "Milliliter/ml":resultView.setText(String.valueOf(formatter.format(enteredValue*28.4130625)));break;
                    case "Liter/L":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0284130625)));break;
                    case "Fluid ounce/fl oz":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Gill/gi":resultView.setText(String.valueOf(formatter.format(enteredValue*0.2)));break;
                    case "Pint/pt":resultView.setText(String.valueOf(formatter.format(enteredValue*0.05)));break;
                    case "Quart/qt":resultView.setText(String.valueOf(formatter.format(enteredValue*0.025)));break;
                    case "Gallon/gal":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00625)));break;
                    case "Barrel(UK)/bbl(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001736111)));break;
                }
                break;
            case "Pint/pt":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre/mm³":resultView.setText(String.valueOf(formatter.format(enteredValue*568261.25)));break;
                    case "Cubic centimetre/cm³":resultView.setText(String.valueOf(formatter.format(enteredValue*568.26125)));break;
                    case "Cubic metre/m³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0005682613)));break;
                    case "Milliliter/ml":resultView.setText(String.valueOf(formatter.format(enteredValue*568.26125)));break;
                    case "Liter/L":resultView.setText(String.valueOf(formatter.format(enteredValue*0.56826125)));break;
                    case "Fluid ounce/fl oz":resultView.setText(String.valueOf(formatter.format(enteredValue*20)));break;
                    case "Gill/gi":resultView.setText(String.valueOf(formatter.format(enteredValue*4)));break;
                    case "Pint/pt":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Quart/qt":resultView.setText(String.valueOf(formatter.format(enteredValue*0.5)));break;
                    case "Gallon/gal":resultView.setText(String.valueOf(formatter.format(enteredValue*0.125)));break;
                    case "Barrel(UK)/bbl(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0034722222)));break;
                }
                break;
            case "Quart/qt":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre/mm³":resultView.setText(String.valueOf(formatter.format(enteredValue*1136522.5)));break;
                    case "Cubic centimetre/cm³":resultView.setText(String.valueOf(formatter.format(enteredValue*1136.5225)));break;
                    case "Cubic metre/m³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0011365225)));break;
                    case "Milliliter/ml":resultView.setText(String.valueOf(formatter.format(enteredValue*1136.5225)));break;
                    case "Liter/L":resultView.setText(String.valueOf(formatter.format(enteredValue*1.1365225)));break;
                    case "Fluid ounce/fl oz":resultView.setText(String.valueOf(formatter.format(enteredValue*40)));break;
                    case "Gill/gi":resultView.setText(String.valueOf(formatter.format(enteredValue*8)));break;
                    case "Pint/pt":resultView.setText(String.valueOf(formatter.format(enteredValue*2)));break;
                    case "Quart/qt":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Gallon/gal":resultView.setText(String.valueOf(formatter.format(enteredValue*0.25)));break;
                    case "Barrel(UK)/bbl(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0069444444)));break;
                }
                break;
            case "Gallon/gal":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre/mm³":resultView.setText(String.valueOf(formatter.format(enteredValue*4546090)));break;
                    case "Cubic centimetre/cm³":resultView.setText(String.valueOf(formatter.format(enteredValue*4546.09)));break;
                    case "Cubic metre/m³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00454609)));break;
                    case "Milliliter/ml":resultView.setText(String.valueOf(formatter.format(enteredValue*4546.09)));break;
                    case "Liter/L":resultView.setText(String.valueOf(formatter.format(enteredValue*3.785)));break;
                    case "Fluid ounce/fl oz":resultView.setText(String.valueOf(formatter.format(enteredValue*160)));break;
                    case "Gill/gi":resultView.setText(String.valueOf(formatter.format(enteredValue*32)));break;
                    case "Pint/pt":resultView.setText(String.valueOf(formatter.format(enteredValue*8)));break;
                    case "Quart/qt":resultView.setText(String.valueOf(formatter.format(enteredValue*4)));break;
                    case "Gallon/gal":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Barrel(UK)/bbl(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0277777778)));break;
                }
                break;
            case "Barrel(UK)/bbl(UK)":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre/mm³":resultView.setText(String.valueOf(formatter.format(enteredValue*163659240)));break;
                    case "Cubic centimetre/cm³":resultView.setText(String.valueOf(formatter.format(enteredValue*163659.24)));break;
                    case "Cubic metre/m³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.16365924)));break;
                    case "Milliliter/ml":resultView.setText(String.valueOf(formatter.format(enteredValue*4546.09)));break;
                    case "Liter/L":resultView.setText(String.valueOf(formatter.format(enteredValue*163.65924)));break;
                    case "Fluid ounce/fl oz":resultView.setText(String.valueOf(formatter.format(enteredValue*5760)));break;
                    case "Gill/gi":resultView.setText(String.valueOf(formatter.format(enteredValue*1152)));break;
                    case "Pint/pt":resultView.setText(String.valueOf(formatter.format(enteredValue*288)));break;
                    case "Quart/qt":resultView.setText(String.valueOf(formatter.format(enteredValue*144)));break;
                    case "Gallon/gal":resultView.setText(String.valueOf(formatter.format(enteredValue*36)));break;
                    case "Barrel(UK)/bbl(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
                break;
        }
    }

    public static void ConvertValues_Ukr(String txtFromSpinner1, String txtFromSpinner2 , Double enteredValue, TextView resultView) {
        NumberFormat formatter = new DecimalFormat("###.########################");
        //0.0000000000003861021585
        final double NineDivFive = 9.0/5.0;
        final double FiveDivNine = 5.0/9.0;

        switch (txtFromSpinner1) {
            //area
            case "Мілліметр квадратний/мм²":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний/мм²": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Сантіметр квадратний/см²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.01)));break;
                    case "Метр квадратний/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Кілометр квадратний/км²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000000001)));break;
                    case "Гектар/г": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000001)));break;
                    case "Міля квадратна/мі²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000000003861021585)));break;
                    case "Акр/а": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000002471053814)));break;
                    case "Ярд квадратний/ярд²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001196)));break;
                    case "Фут квадратний/ф²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000107639)));break;
                    case "Дюйм квадратний/д²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0015500031)));break;
                }
                break;
            case "Сантіметр квадратний/см²":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний/мм²": resultView.setText(String.valueOf(formatter.format(enteredValue*100)));break;
                    case "Сантіметр квадратний/см²": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Метр квадратний/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Кілометр квадратний/км²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000001)));break;
                    case "Гектар/г": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000001)));break;
                    case "Міля квадратна/мі²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000000003861021585)));break;
                    case "Акр/а": resultView.setText(String.valueOf(formatter.format(enteredValue *0.00000002471053814)));break;
                    case "Ярд квадратний/ярд²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000119599)));break;
                    case "Фут квадратний/ф²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001076391)));break;
                    case "Дюйм квадратний/д²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.15500031)));break;
                }
                break;
            case "Метр квадратний/м²":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний/мм²": resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Сантіметр квадратний/см²": resultView.setText(String.valueOf(formatter.format(enteredValue * 10000.0)));break;
                    case "Метр квадратний/м²": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Кілометр квадратний/км²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Гектар/г": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Міля квадратна/мі²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000003861021585)));break;
                    case "Акр/а": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0002471054)));break;
                    case "Ярд квадратний/ярд²": resultView.setText(String.valueOf(formatter.format(enteredValue * 1.1959900463)));break;
                    case "Фут квадратний/ф²": resultView.setText(String.valueOf(formatter.format(enteredValue * 10.763910417)));break;
                    case "Дюйм квадратний/д²": resultView.setText(String.valueOf(formatter.format(enteredValue * 1550.0031)));break;
                }
                break;
            case "Кілометр квадратний/км²":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний/мм²": resultView.setText(String.valueOf(formatter.format(enteredValue*1000000000000.0)));break;
                    case "Сантіметр квадратний/см²": resultView.setText(String.valueOf(formatter.format(enteredValue * 10000000000.0)));break;
                    case "Метр квадратний/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Кілометр квадратний/км²": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Гектар/г": resultView.setText(String.valueOf(formatter.format(enteredValue * 100.0)));break;
                    case "Міля квадратна/мі²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.3861021585)));break;
                    case "Акр/а": resultView.setText(String.valueOf(formatter.format(enteredValue * 247.10538147)));break;
                    case "Ярд квадратний/ярд²": resultView.setText(String.valueOf(formatter.format(enteredValue * 1195990.0463)));break;
                    case "Фут квадратний/ф²": resultView.setText(String.valueOf(formatter.format(enteredValue * 10763910.417)));break;
                    case "Дюйм квадратний/д²": resultView.setText(String.valueOf(formatter.format(enteredValue * 1550003100)));break;
                }
                break;
            case "Гектар/г":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний/мм²": resultView.setText(String.valueOf(formatter.format(enteredValue*10000000000.0)));break;
                    case "Сантіметр квадратний/см²": resultView.setText(String.valueOf(formatter.format(enteredValue * 100000000)));break;
                    case "Метр квадратний/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 10000)));break;
                    case "Кілометр квадратний/км²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.01)));break;
                    case "Гектар/г": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Міля квадратна/мі²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0038610216)));break;
                    case "Акр/а": resultView.setText(String.valueOf(formatter.format(enteredValue * 2.4710538147)));break;
                    case "Ярд квадратний/ярд²": resultView.setText(String.valueOf(formatter.format(enteredValue * 11959.900463)));break;
                    case "Фут квадратний/ф²": resultView.setText(String.valueOf(formatter.format(enteredValue * 107639.10417)));break;
                    case "Дюйм квадратний/д²": resultView.setText(String.valueOf(formatter.format(enteredValue * 15500031)));break;
                }
                break;
            case "Міля квадратна/мі²":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний/мм²": resultView.setText(String.valueOf(formatter.format(enteredValue*2589988110336.0)));break;
                    case "Сантіметр квадратний/см²": resultView.setText(String.valueOf(formatter.format(enteredValue * 25899881103.0)));break;
                    case "Метр квадратний/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 2589988.1103)));break;
                    case "Кілометр квадратний/км²": resultView.setText(String.valueOf(formatter.format(enteredValue * 2.5899881103)));break;
                    case "Гектар/г": resultView.setText(String.valueOf(formatter.format(enteredValue * 258.99881103)));break;
                    case "Міля квадратна/мі²": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Акр/а": resultView.setText(String.valueOf(formatter.format(enteredValue * 640)));break;
                    case "Ярд квадратний/ярд²": resultView.setText(String.valueOf(formatter.format(enteredValue * 3097600)));break;
                    case "Фут квадратний/ф²": resultView.setText(String.valueOf(formatter.format(enteredValue * 27878400)));break;
                    case "Дюйм квадратний/д²": resultView.setText(String.valueOf(formatter.format(enteredValue * 4014489600.0)));break;
                }
                break;
            case "Акр/а":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний/мм²": resultView.setText(String.valueOf(formatter.format(enteredValue*4046856422.4)));break;
                    case "Сантіметр квадратний/см²": resultView.setText(String.valueOf(formatter.format(enteredValue * 40468564.224)));break;
                    case "Метр квадратний/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 4046.8564224)));break;
                    case "Кілометр квадратний/км²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0040468564)));break;
                    case "Гектар/г": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.4046856422)));break;
                    case "Міля квадратна/мі²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0015625)));break;
                    case "Акр/а": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Ярд квадратний/ярд²": resultView.setText(String.valueOf(formatter.format(enteredValue * 4840)));break;
                    case "Фут квадратний/ф²": resultView.setText(String.valueOf(formatter.format(enteredValue * 43560)));break;
                    case "Дюйм квадратний/д²": resultView.setText(String.valueOf(formatter.format(enteredValue * 6272640)));break;
                }
                break;
            case "Ярд квадратний/ярд²":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний/мм²": resultView.setText(String.valueOf(formatter.format(enteredValue*836127.36)));break;
                    case "Сантіметр квадратний/см²": resultView.setText(String.valueOf(formatter.format(enteredValue * 8361.2736)));break;
                    case "Метр квадратний/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.83612736)));break;
                    case "Кілометр квадратний/км²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000008361273599)));break;
                    case "Гектар/г": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000836127)));break;
                    case "Міля квадратна/мі²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000003228305785)));break;
                    case "Акр/а": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0002066116)));break;
                    case "Ярд квадратний/ярд²": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Фут квадратний/ф²": resultView.setText(String.valueOf(formatter.format(enteredValue * 9)));break;
                    case "Дюйм квадратний/д²": resultView.setText(String.valueOf(formatter.format(enteredValue * 1296)));break;
                }
                break;
            case "Фут квадратний/ф²":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний/мм²": resultView.setText(String.valueOf(formatter.format(enteredValue*92903.04)));break;
                    case "Сантіметр квадратний/см²": resultView.setText(String.valueOf(formatter.format(enteredValue * 929.0304)));break;
                    case "Метр квадратний/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.09290304)));break;
                    case "Кілометр квадратний/км²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000009290303999)));break;
                    case "Гектар/г": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000092903)));break;
                    case "Міля квадратна/мі²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000387006427)));break;
                    case "Акр/а": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000229568)));break;
                    case "Ярд квадратний/ярд²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1111111111)));break;
                    case "Фут квадратний/ф²": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Дюйм квадратний/д²": resultView.setText(String.valueOf(formatter.format(enteredValue * 144)));break;
                }
            case "Дюйм квадратний/д²":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний/мм²": resultView.setText(String.valueOf(formatter.format(enteredValue*645.16)));break;
                    case "Сантіметр квадратний/см²": resultView.setText(String.valueOf(formatter.format(enteredValue * 6.4516)));break;
                    case "Метр квадратний/м²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00064516)));break;
                    case "Кілометр квадратний/км²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000000064516)));break;
                    case "Гектар/г": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000064516)));break;
                    case "Міля квадратна/мі²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000000290976686)));break;
                    case "Акр/а": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000001594225079)));break;
                    case "Ярд квадратний/ярд²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0007716049)));break;
                    case "Фут квадратний/ф²": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0069444444)));break;
                    case "Дюйм квадратний/д²": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
                //force
            case "Мілліньютон/мН":
                switch (txtFromSpinner2) {
                    case "Мілліньютон/мН":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Ньютон/Н":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Кілоньютон/кН":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Тонна-сила(метрична)/тс(м)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000001019716212)));break;
                    case "Грам-сила/гс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1019)));break;
                    case "Кілограм-сила/кгс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000101)));break;
                    case "Понд/п":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1019)));break;
                    case "Фунт-сила/фтс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00022)));break;
                    case "Унція-сила/уцс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00359)));break;
                    case "Тонна-сила(довга)/тс(д)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000001003611353)));break;
                    case "Паундаль/пдл":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00723)));break;
                }
                break;
            case "Ньютон/Н":
                switch (txtFromSpinner2) {
                    case "Мілліньютон/мН":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Ньютон/Н":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Кілоньютон/кН":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Тонна-сила(метрична)/тс(м)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Грам-сила/гс":resultView.setText(String.valueOf(formatter.format(enteredValue * 101.971)));break;
                    case "Кілограм-сила/кгс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.10197)));break;
                    case "Понд/п":resultView.setText(String.valueOf(formatter.format(enteredValue * 101.971)));break;
                    case "Фунт-сила/фтс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.22480)));break;
                    case "Унція-сила/уцс":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.5969)));break;
                    case "Тонна-сила(довга)/тс(д)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Паундаль/пдл":resultView.setText(String.valueOf(formatter.format(enteredValue * 7.233)));break;
                }
                break;
            case "Кілоньютон/кН":
                switch (txtFromSpinner2) {
                    case "Мілліньютон/мН":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Ньютон/Н":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Кілоньютон/кН":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Тонна-сила(метрична)/тс(м)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.101971)));break;
                    case "Грам-сила/гс":resultView.setText(String.valueOf(formatter.format(enteredValue * 101971.6)));break;
                    case "Кілограм-сила/кгс":resultView.setText(String.valueOf(formatter.format(enteredValue * 101.971)));break;
                    case "Понд/п":resultView.setText(String.valueOf(formatter.format(enteredValue * 101971.6)));break;
                    case "Фунт-сила/фтс":resultView.setText(String.valueOf(formatter.format(enteredValue * 224.81)));break;
                    case "Унція-сила/уцс":resultView.setText(String.valueOf(formatter.format(enteredValue * 3596.94)));break;
                    case "Тонна-сила(довга)/тс(д)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1003)));break;
                    case "Паундаль/пдл":resultView.setText(String.valueOf(formatter.format(enteredValue * 7233.01)));break;
                }
                break;
            case "Тонна-сила(метрична)/тс(м)":
                switch (txtFromSpinner2) {
                    case "Мілліньютон/мН":resultView.setText(String.valueOf(formatter.format(enteredValue * 9806650)));break;
                    case "Ньютон/Н":resultView.setText(String.valueOf(formatter.format(enteredValue * 9806.65)));break;
                    case "Кілоньютон/кН":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.80665)));break;
                    case "Тонна-сила(метрична)/тс(м)":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Грам-сила/гс":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Кілограм-сила/кгс":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Понд/п":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Фунт-сила/фтс":resultView.setText(String.valueOf(formatter.format(enteredValue * 2204.62)));break;
                    case "Унція-сила/уцс":resultView.setText(String.valueOf(formatter.format(enteredValue * 35273.96)));break;
                    case "Тонна-сила(довга)/тс(д)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.9842)));break;
                    case "Паундаль/пдл":resultView.setText(String.valueOf(formatter.format(enteredValue * 70931.63)));break;
                }
                break;
            case "Грам-сила/гс":
                switch (txtFromSpinner2) {
                    case "Мілліньютон/мН":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.8066)));break;
                    case "Ньютон/Н":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.009806)));break;
                    case "Кілоньютон/кН":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000098067)));break;
                    case "Тонна-сила(метрична)/тс(м)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Грам-сила/гс":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Кілограм-сила/кгс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Понд/п":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000007039)));break;
                    case "Фунт-сила/фтс":resultView.setText(String.valueOf(formatter.format(enteredValue*0.002204)));break;
                    case "Унція-сила/уцс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.03527)));break;
                    case "Тонна-сила(довга)/тс(д)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000009842065276)));break;
                    case "Паундаль/пдл":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.07093)));break;
                }
                break;
            case "Кілограм-сила/кгс":
                switch (txtFromSpinner2) {
                    case "Мілліньютон/мН":resultView.setText(String.valueOf(formatter.format(enteredValue *9806.65)));break;
                    case "Ньютон/Н":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.80665)));break;
                    case "Кілоньютон/кН":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0098066)));break;
                    case "Тонна-сила(метрична)/тс(м)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Грам-сила/гс":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Кілограм-сила/кгс":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Понд/п":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Фунт-сила/фтс":resultView.setText(String.valueOf(formatter.format(enteredValue * 2.20)));break;
                    case "Унція-сила/уцс":resultView.setText(String.valueOf(formatter.format(enteredValue * 35.273)));break;
                    case "Тонна-сила(довга)/тс(д)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0009842)));break;
                    case "Паундаль/пдл":resultView.setText(String.valueOf(formatter.format(enteredValue * 70.931)));break;
                }
                break;
            case "Понд/п":
                switch (txtFromSpinner2) {
                    case "Мілліньютон/мН":resultView.setText(String.valueOf(formatter.format(enteredValue *9.80665)));break;
                    case "Ньютон/Н":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00980)));break;
                    case "Кілоньютон/кН":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000098)));break;
                    case "Тонна-сила(метрична)/тс(м)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Грам-сила/гс":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Кілограм-сила/кгс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Понд/п":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Фунт-сила/фтс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.002204)));break;
                    case "Унція-сила/уцс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.03527)));break;
                    case "Тонна-сила(довга)/тс(д)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000009842065276)));break;
                    case "Паундаль/пдл":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.07093)));break;
                }
                break;
            case "Фунт-сила/фтс":
                switch (txtFromSpinner2) {
                    case "Мілліньютон/мН":resultView.setText(String.valueOf(formatter.format(enteredValue *4448.221)));break;
                    case "Ньютон/Н":resultView.setText(String.valueOf(formatter.format(enteredValue * 4.448)));break;
                    case "Кілоньютон/кН":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00444)));break;
                    case "Тонна-сила(метрична)/тс(м)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00045)));break;
                    case "Грам-сила/гс":resultView.setText(String.valueOf(formatter.format(enteredValue * 453.59)));break;
                    case "Кілограм-сила/кгс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.45359)));break;
                    case "Понд/п":resultView.setText(String.valueOf(formatter.format(enteredValue * 453.59)));break;
                    case "Фунт-сила/фтс":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Унція-сила/уцс":resultView.setText(String.valueOf(formatter.format(enteredValue * 16)));break;
                    case "Тонна-сила(довга)/тс(д)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0004464)));break;
                    case "Паундаль/пдл":resultView.setText(String.valueOf(formatter.format(enteredValue * 32.174)));break;
                }
                break;
            case "Унція-сила/уцс":
                switch (txtFromSpinner2) {
                    case "Мілліньютон/мН":resultView.setText(String.valueOf(formatter.format(enteredValue *278.013)));break;
                    case "Ньютон/Н":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.27801)));break;
                    case "Кілоньютон/кН":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0002780)));break;
                    case "Тонна-сила(метрична)/тс(м)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000283)));break;
                    case "Грам-сила/гс":resultView.setText(String.valueOf(formatter.format(enteredValue * 28.349)));break;
                    case "Кілограм-сила/кгс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.02834)));break;
                    case "Понд/п":resultView.setText(String.valueOf(formatter.format(enteredValue * 28.349)));break;
                    case "Фунт-сила/фтс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0625)));break;
                    case "Унція-сила/уцс":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Тонна-сила(довга)/тс(д)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000279)));break;
                    case "Паундаль/пдл":resultView.setText(String.valueOf(formatter.format(enteredValue * 2.010)));break;
                }
                break;
            case "Тонна-сила(довга)/тс(д)":
                switch (txtFromSpinner2) {
                    case "Мілліньютон/мН":resultView.setText(String.valueOf(formatter.format(enteredValue *9964016.41)));break;
                    case "Ньютон/Н":resultView.setText(String.valueOf(formatter.format(enteredValue * 9964.01)));break;
                    case "Кілоньютон/кН":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.9640)));break;
                    case "Тонна-сила(метрична)/тс(м)":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.016)));break;
                    case "Грам-сила/гс":resultView.setText(String.valueOf(formatter.format(enteredValue * 1016046.90)));break;
                    case "Кілограм-сила/кгс":resultView.setText(String.valueOf(formatter.format(enteredValue * 1016.046)));break;
                    case "Понд/п":resultView.setText(String.valueOf(formatter.format(enteredValue * 1016046.90)));break;
                    case "Фунт-сила/фтс":resultView.setText(String.valueOf(formatter.format(enteredValue * 2240.0)));break;
                    case "Унція-сила/уцс":resultView.setText(String.valueOf(formatter.format(enteredValue * 35840.0)));break;
                    case "Тонна-сила(довга)/тс(д)":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Паундаль/пдл":resultView.setText(String.valueOf(formatter.format(enteredValue * 72069.86)));break;
                }
                break;
            case "Паундаль/пдл":
                switch (txtFromSpinner2) {
                    case "Мілліньютон/мН":resultView.setText(String.valueOf(formatter.format(enteredValue *138.25)));break;
                    case "Ньютон/Н":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.13825)));break;
                    case "Кілоньютон/кН":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000138)));break;
                    case "Тонна-сила(метрична)/тс(м)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000140)));break;
                    case "Грам-сила/гс":resultView.setText(String.valueOf(formatter.format(enteredValue * 14.09)));break;
                    case "Кілограм-сила/кгс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.01409)));break;
                    case "Понд/п":resultView.setText(String.valueOf(formatter.format(enteredValue * 14.09)));break;
                    case "Фунт-сила/фтс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.03108)));break;
                    case "Унція-сила/уцс":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.4972)));break;
                    case "Тонна-сила(довга)/тс(д)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000138)));break;
                    case "Паундаль/пдл":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
            case "Мілліметр/мм":
                switch (txtFromSpinner2){
                    case "Мілліметр/мм":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Сантіметр/см":resultView.setText(String.valueOf(formatter.format(enteredValue*0.1)));break;
                    case "Метр/м":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Кілометр/км":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Дюйм/д":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03937)));break;
                    case "Фут/ф":resultView.setText(String.valueOf(formatter.format(enteredValue*0.003280)));break;
                    case "Ярд/яd":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001093)));break;
                    case "Міля/мі":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000062137)));break;
                }
                break;
            case "Сантіметр/см":
                switch (txtFromSpinner2){
                    case "Мілліметр/мм":resultView.setText(String.valueOf(formatter.format(enteredValue*10)));break;
                    case "Сантіметр/см":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Метр/м":resultView.setText(String.valueOf(formatter.format(enteredValue*0.01)));break;
                    case "Кілометр/км":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00001)));break;
                    case "Дюйм/д":resultView.setText(String.valueOf(formatter.format(enteredValue*0.3937)));break;
                    case "Фут/ф":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03280)));break;
                    case "Ярд/яd":resultView.setText(String.valueOf(formatter.format(enteredValue*0.01093)));break;
                    case "Міля/мі":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000006213)));break;
                }
                break;
            case "Метр/м":
                switch (txtFromSpinner2){
                    case "Мілліметр/мм":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Сантіметр/см":resultView.setText(String.valueOf(formatter.format(enteredValue*100)));break;
                    case "Метр/м":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Кілометр/км":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Дюйм/д":resultView.setText(String.valueOf(formatter.format(enteredValue*39.37007)));break;
                    case "Фут/ф":resultView.setText(String.valueOf(formatter.format(enteredValue*3.2808)));break;
                    case "Ярд/яd":resultView.setText(String.valueOf(formatter.format(enteredValue*1.09361)));break;
                    case "Міля/мі":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00062137)));break;
                }
                break;
            case "Кілометр/км":
                switch (txtFromSpinner2){
                    case "Мілліметр/мм":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Сантіметр/см":resultView.setText(String.valueOf(formatter.format(enteredValue*100000.0)));break;
                    case "Метр/м":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Кілометр/км":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Дюйм/д":resultView.setText(String.valueOf(formatter.format(enteredValue*39370.08)));break;
                    case "Фут/ф":resultView.setText(String.valueOf(formatter.format(enteredValue*3280.84)));break;
                    case "Ярд/яd":resultView.setText(String.valueOf(formatter.format(enteredValue*1093.6132)));break;
                    case "Міля/мі":resultView.setText(String.valueOf(formatter.format(enteredValue*0.6214)));break;
                }
                break;
            case "Дюйм/д":
                switch (txtFromSpinner2){
                    case "Мілліметр/мм":resultView.setText(String.valueOf(formatter.format(enteredValue*25.4)));break;
                    case "Сантіметр/см":resultView.setText(String.valueOf(formatter.format(enteredValue*2.54)));break;
                    case "Метр/м":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0254)));break;
                    case "Кілометр/км":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000254)));break;
                    case "Дюйм/д":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Фут/ф":resultView.setText(String.valueOf(formatter.format(enteredValue*0.08333)));break;
                    case "Ярд/яd":resultView.setText(String.valueOf(formatter.format(enteredValue*0.02777)));break;
                    case "Міля/мі":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00001578)));break;
                }
                break;
            case "Фут/ф":
                switch (txtFromSpinner2){
                    case "Мілліметр/мм":resultView.setText(String.valueOf(formatter.format(enteredValue*304.8)));break;
                    case "Сантіметр/см":resultView.setText(String.valueOf(formatter.format(enteredValue*30.48)));break;
                    case "Метр/м":resultView.setText(String.valueOf(formatter.format(enteredValue*0.3048)));break;
                    case "Кілометр/км":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0003048)));break;
                    case "Дюйм/д":resultView.setText(String.valueOf(formatter.format(enteredValue*12)));break;
                    case "Фут/ф":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Ярд/яd":resultView.setText(String.valueOf(formatter.format(enteredValue*0.33333)));break;
                    case "Міля/мі":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001893936)));break;
                }
                break;
            case "Ярд/яd":
                switch (txtFromSpinner2){
                    case "Мілліметр/мм":resultView.setText(String.valueOf(formatter.format(enteredValue*914.4)));break;
                    case "Сантіметр/см":resultView.setText(String.valueOf(formatter.format(enteredValue*91.44)));break;
                    case "Метр/м":resultView.setText(String.valueOf(formatter.format(enteredValue*0.9144)));break;
                    case "Кілометр/км":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0009144)));break;
                    case "Дюйм/д":resultView.setText(String.valueOf(formatter.format(enteredValue*36)));break;
                    case "Фут/ф":resultView.setText(String.valueOf(formatter.format(enteredValue*3)));break;
                    case "Ярд/яd":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Міля/мі":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0005681)));break;
                }
                break;
            case "Міля/мі":
                switch (txtFromSpinner2){
                    case "Мілліметр/мм":resultView.setText(String.valueOf(formatter.format(enteredValue*1609347.21)));break;
                    case "Сантіметр/см":resultView.setText(String.valueOf(formatter.format(enteredValue*160934.72)));break;
                    case "Метр/м":resultView.setText(String.valueOf(formatter.format(enteredValue*1609.34)));break;
                    case "Кілометр/км":resultView.setText(String.valueOf(formatter.format(enteredValue*1.6093)));break;
                    case "Дюйм/д":resultView.setText(String.valueOf(formatter.format(enteredValue*63360.12)));break;
                    case "Фут/ф":resultView.setText(String.valueOf(formatter.format(enteredValue*5280.010)));break;
                    case "Ярд/яd":resultView.setText(String.valueOf(formatter.format(enteredValue*1760)));break;
                    case "Міля/мі":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
            case "Мілліграм/мг":
                switch (txtFromSpinner2){
                    case "Грам/г":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001))); break;
                    case "Кілограм/кг":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001))); break;
                    case "Тонна/т":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001))); break;
                    case "Гран/гр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0154))); break;
                    case "Унція/унц":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000035))); break;
                    case "Фунт/фт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000022))); break;
                    case "Хандредвейт/хвт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00000002))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001016))); break;
                    case "Мілліграм/мг":resultView.setText(String.valueOf(formatter.format(enteredValue)));
                }
                break;
            case "Грам/г":
                switch (txtFromSpinner2){
                    case "Мілліграм/мг":resultView.setText(String.valueOf(formatter.format(enteredValue*1000.0))); break;
                    case "Кілограм/кг":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001))); break;
                    case "Тонна/т": resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001))); break;
                    case "Гран/гр":resultView.setText(String.valueOf(formatter.format(enteredValue*15.43))); break;
                    case "Унція/унц":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03527))); break;
                    case "Фунт/фт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.002204))); break;
                    case "Хандредвейт/хвт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000196))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000009))); break;
                    case "Грам/г":resultView.setText(String.valueOf(formatter.format(enteredValue)));
                }
                break;
            case "Кілограм/кг":
                switch (txtFromSpinner2){
                    case "Мілліграм/мг":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0))); break;
                    case "Грам/г":resultView.setText(String.valueOf(formatter.format(enteredValue*1000.0))); break;
                    case "Тонна/т": //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue*0.001))); break;
                    case "Гран/гр":resultView.setText(String.valueOf(formatter.format(enteredValue*15432.35))); break;
                    case "Унція/унц":resultView.setText(String.valueOf(formatter.format(enteredValue*35.27))); break;
                    case "Фунт/фт":resultView.setText(String.valueOf(formatter.format(enteredValue*2.20))); break;
                    case "Хандредвейт/хвт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.01968))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000984))); break;
                    case "Кілограм/кг":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Тонна/т":
                switch (txtFromSpinner2){
                    case "Мілліграм/мг":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000000.0))); break;
                    case "Грам/г":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0))); break;
                    case "Кілограм/кг": //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue*1000.0))); break;
                    case "Гран/гр":resultView.setText(String.valueOf(formatter.format(enteredValue*15432358.35))); break;
                    case "Унція/унц":resultView.setText(String.valueOf(formatter.format(enteredValue*35273.96))); break;
                    case "Фунт/фт":resultView.setText(String.valueOf(formatter.format(enteredValue*2204.62))); break;
                    case "Хандредвейт/хвт":resultView.setText(String.valueOf(formatter.format(enteredValue*19.68))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.9842))); break;
                    case "Тонна/т":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Гран/гр":
                switch (txtFromSpinner2){
                    case "Мілліграм/мг":resultView.setText(String.valueOf(formatter.format(enteredValue*64.79))); break;
                    case "Грам/г":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0647))); break;
                    case "Кілограм/кг":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000064))); break;
                    case "Тонна/т":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000065))); break;
                    case "Унція/унц":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00228))); break;
                    case "Фунт/фт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000142857))); break;
                    case "Хандредвейт/хвт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001429))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000064))); break;
                    case "Гран/гр":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Унція/унц ":
                switch (txtFromSpinner2){
                    case "Мілліграм/мг":resultView.setText(String.valueOf(formatter.format(enteredValue*28349.52))); break;
                    case "Грам/г":resultView.setText(String.valueOf(formatter.format(enteredValue*28.349))); break;
                    case "Кілограм/кг": //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue*0.02834))); break;
                    case "Тонна/т":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00002835))); break;
                    case "Гран/гр":resultView.setText(String.valueOf(formatter.format(enteredValue*437.49))); break;
                    case "Фунт/фт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0625))); break;
                    case "Хандредвейт/хвт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000558036))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000279022))); break;
                    case "Унція/унц":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Фунт/фт ":
                switch (txtFromSpinner2){
                    case "Мілліграм/мг":resultView.setText(String.valueOf(formatter.format(enteredValue*453592.37))); break;
                    case "Грам/г":resultView.setText(String.valueOf(formatter.format(enteredValue*453.59))); break;
                    case "Кілограм/кг":resultView.setText(String.valueOf(formatter.format(enteredValue*0.4535))); break;
                    case "Тонна/т":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0004535))); break;
                    case "Гран/гр":resultView.setText(String.valueOf(formatter.format(enteredValue*6999.99))); break;
                    case "Унція/унц":resultView.setText(String.valueOf(formatter.format(enteredValue*16))); break;
                    case "Хандредвейт/хвт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.008928571))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000446429))); break;
                    case "Фунт/фт":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Хандредвейт/хвт ":
                switch (txtFromSpinner2){
                    case "Мілліграм/мг":resultView.setText(String.valueOf(formatter.format(enteredValue*50802345.44))); break;
                    case "Грам/г":resultView.setText(String.valueOf(formatter.format(enteredValue*50802.34))); break;
                    case "Кілограм/кг": resultView.setText(String.valueOf(formatter.format(enteredValue*50.80))); break;
                    case "Тонна/т":resultView.setText(String.valueOf(formatter.format(enteredValue*0.05080))); break;
                    case "Гран/гр":resultView.setText(String.valueOf(formatter.format(enteredValue*783999.999))); break;
                    case "Унція/унц":resultView.setText(String.valueOf(formatter.format(enteredValue*1792))); break;
                    case "Фунт/фт":resultView.setText(String.valueOf(formatter.format(enteredValue*112))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue*0.05))); break;
                    case "Хандредвейт/хвт":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Ton(long)/tl ":
                switch (txtFromSpinner2){
                    case "Мілліграм/мг":resultView.setText(String.valueOf(formatter.format(enteredValue*1016046908.8))); break;
                    case "Грам/г":resultView.setText(String.valueOf(formatter.format(enteredValue*1016046.90))); break;
                    case "Кілограм/кг": //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue*1016.04))); break;
                    case "Тонна/т":resultView.setText(String.valueOf(formatter.format(enteredValue*1.016))); break;
                    case "Гран/гр":resultView.setText(String.valueOf(formatter.format(enteredValue*15679999.99))); break;
                    case "Унція/унц":resultView.setText(String.valueOf(formatter.format(enteredValue*35840.0))); break;
                    case "Фунт/фт":resultView.setText(String.valueOf(formatter.format(enteredValue*2240.0))); break;
                    case "Хандредвейт/хвт":resultView.setText(String.valueOf(formatter.format(enteredValue*20.0))); break;
                    case "Ton(long)/tl":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
            case "Метрів/секунда[м/с]":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда[м/с]":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Метрів/година[м/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3600)));break;
                    case "Кілометр/секунда[км/с]":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Кілометр/година[км/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.6)));break;
                    case "Фут/секунда[ф/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.28)));break;
                    case "Фут/година[ф/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 11811.02)));break;
                    case "Міль/година[міль/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 2.23)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.943)));break;
                }
                break;
            case "Метрів/година[м/г]":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда[м/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00027)));break;
                    case "Метрів/година[м/г]":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Кілометр/секунда[км/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000002777777777)));break;
                    case "Кілометр/година[км/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Фут/секунда[ф/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0009)));break;
                    case "Фут/година[ф/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.28)));break;
                    case "Міль/година[міль/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00062)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00053)));break;
                }
                break;
            case "Кілометр/секунда[км/с]":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда[м/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Метрів/година[м/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3600000)));break;
                    case "Кілометр/секунда[км/с]":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Кілометр/година[км/г]":resultView.setText(String.valueOf(formatter.format(enteredValue*3600)));break;
                    case "Фут/секунда[ф/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3280.83)));break;
                    case "Фут/година[ф/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 11811023.6)));break;
                    case "Міль/година[міль/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 2236.9)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue * 1943.8)));break;
                }
                break;
            case "Кілометр/година[км/г]":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда[м/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.2777)));break;
                    case "Метрів/година[м/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Кілометр/секунда[км/с]":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00027)));break;
                    case "Кілометр/година[км/г]":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Фут/секунда[ф/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.911)));break;
                    case "Фут/година[ф/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3280.8)));break;
                    case "Міль/година[міль/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.621)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.539)));break;
                }
                break;
            case "Фут/секунда[ф/с]":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда[м/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.3048)));break;
                    case "Метрів/година[м/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1097.28)));break;
                    case "Кілометр/секунда[км/с]":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0003048)));break;
                    case "Кілометр/година[км/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.09728)));break;
                    case "Фут/секунда[ф/с]":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Фут/година[ф/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 3600)));break;
                    case "Міль/година[міль/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.681)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.5924)));break;

                }
                break;
            case "Фут/година[ф/г]":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда[м/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000084)));break;
                    case "Метрів/година[м/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.3)));break;
                    case "Кілометр/секунда[км/с]":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000008466666666)));break;
                    case "Кілометр/година[км/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00030)));break;
                    case "Фут/секунда[ф/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00027)));break;
                    case "Фут/година[ф/г]":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Міль/година[міль/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00018)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00016)));break;

                }
                break;
            case "Міль/година[міль/г]":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда[м/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.44)));break;
                    case "Метрів/година[м/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1609.3)));break;
                    case "Кілометр/секунда[км/с]":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00044)));break;
                    case "Кілометр/година[км/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.6)));break;
                    case "Фут/секунда[ф/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.46)));break;
                    case "Фут/година[ф/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 5280)));break;
                    case "Міль/година[міль/г]":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.8689)));break;
                }
                break;
            case "Вузол/В":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда[м/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.514)));break;
                    case "Метрів/година[м/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1852)));break;
                    case "Кілометр/секунда[км/с]":      //check here
                        resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00051)));break;
                    case "Кілометр/година[км/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.852)));break;
                    case "Фут/секунда[ф/с]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.687)));break;
                    case "Фут/година[ф/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 6076.11)));break;
                    case "Міль/година[міль/г]":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.150)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
                break;
            case "Цельсій/°C":
                switch (txtFromSpinner2) {
                    case "Цельсій/°C":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Фаренгейт/°F":resultView.setText(String.valueOf(formatter.format(enteredValue * (9.0/5.0)+32)));break;
                    case "Кельвін/°K":resultView.setText(String.valueOf(formatter.format(enteredValue + 273.15)));break;
                    case "Ранкін/°R":resultView.setText(String.valueOf(formatter.format(enteredValue * (9.0/5.0)+491.76)));break;
                }
                break;
            case "Кельвін/°K":
                switch (txtFromSpinner2) {
                    case "Цельсій/°C":resultView.setText(String.valueOf(formatter.format(enteredValue-273.15)));break;//here
                    case "Фаренгейт/°F":resultView.setText(String.valueOf(formatter.format((enteredValue-273.15)*NineDivFive +32)));break; //here
                    case "Кельвін/°K":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Ранкін/°R":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.8)));break;
                }
                break;
            case "Ранкін/°R"  :
                switch (txtFromSpinner2) {
                    case "Цельсій/°C":resultView.setText(String.valueOf(formatter.format((enteredValue-491.67)*FiveDivNine)));break;//here
                    case "Фаренгейт/°F":resultView.setText(String.valueOf(formatter.format(enteredValue-459.67)));break;
                    case "Кельвін/°K":resultView.setText(String.valueOf(formatter.format(enteredValue*(5.0/9.0))));break;
                    case "Ранкін/°R":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
                break;
            case "Фаренгейт/°F" :
                switch (txtFromSpinner2) {
                    case "Цельсій/°C":resultView.setText(String.valueOf(formatter.format((enteredValue-32)*(5.0/9.0))));break;
                    case "Фаренгейт/°F":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Кельвін/°K":resultView.setText(String.valueOf(formatter.format((enteredValue-32.00)*(5.0/9.0)+273.15)));break;
                    case "Ранкін/°R":resultView.setText(String.valueOf(formatter.format(enteredValue + 459.67)));break;
                }
            case "Секунди":
                switch (txtFromSpinner2) {
                    case "Секунди":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Хвилини":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0166666667)));break;
                    case "Година":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0002777778)));break;
                    case "День":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000115741)));break;
                    case "Тиждень":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000016534)));break;
                    case "Місяц":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000003805175038)));break;
                    case "Рік":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00000003170979198)));break;
                }
                break;
            case "Хвилини":
                switch (txtFromSpinner2) {
                    case "Секунди":resultView.setText(String.valueOf(formatter.format(enteredValue*60)));break;
                    case "Хвилини":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Година":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0166666667)));break;
                    case "День":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0006944444)));break;
                    case "Тиждень":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000992063)));break;
                    case "Місяц":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000228311)));break;
                    case "Рік":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000019026)));break;
                }
                break;
            case "Година":
                switch (txtFromSpinner2) {
                    case "Секунди":resultView.setText(String.valueOf(formatter.format(enteredValue*3600)));break;
                    case "Хвилини":resultView.setText(String.valueOf(formatter.format(enteredValue*60)));break;
                    case "Година":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "День":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0416666667)));break;
                    case "Тиждень":resultView.setText(String.valueOf(formatter.format(enteredValue*0.005952381)));break;
                    case "Місяц":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001369863)));break;
                    case "Рік":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001141553)));break;
                }
                break;
            case "День":
                switch (txtFromSpinner2) {
                    case "Секунди":resultView.setText(String.valueOf(formatter.format(enteredValue*604800)));break;
                    case "Хвилини":resultView.setText(String.valueOf(formatter.format(enteredValue*10080)));break;
                    case "Година":resultView.setText(String.valueOf(formatter.format(enteredValue*168)));break;
                    case "День":resultView.setText(String.valueOf(formatter.format(enteredValue*7)));break;
                    case "Тиждень":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Місяц":resultView.setText(String.valueOf(formatter.format(enteredValue*0.23)));break;
                    case "Рік":resultView.setText(String.valueOf(formatter.format(enteredValue*0.19)));break;
                }
                break;
            case "Тиждень":
                switch (txtFromSpinner2) {
                    case "Секунди":resultView.setText(String.valueOf(formatter.format(enteredValue*604800)));break;
                    case "Хвилини":resultView.setText(String.valueOf(formatter.format(enteredValue*10080)));break;
                    case "Година":resultView.setText(String.valueOf(formatter.format(enteredValue*168)));break;
                    case "День":resultView.setText(String.valueOf(formatter.format(enteredValue*7)));break;
                    case "Тиждень":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Місяц":resultView.setText(String.valueOf(formatter.format(enteredValue*0.2301369863)));break;
                    case "Рік":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0191780822)));break;
                }
                break;
            case "Місяц":
                switch (txtFromSpinner2) {
                    case "Секунди":resultView.setText(String.valueOf(formatter.format(enteredValue*2628000)));break;
                    case "Хвилини":resultView.setText(String.valueOf(formatter.format(enteredValue*43800)));break;
                    case "Година":resultView.setText(String.valueOf(formatter.format(enteredValue*730)));break;
                    case "День":resultView.setText(String.valueOf(formatter.format(enteredValue*30.416666667)));break;
                    case "Тиждень":resultView.setText(String.valueOf(formatter.format(enteredValue*4.3452380952)));break;
                    case "Місяц":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Рік":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0833333333)));break;
                }
                break;
            case "Рік":
                switch (txtFromSpinner2) {
                    case "Секунди":resultView.setText(String.valueOf(formatter.format(enteredValue*31536000)));break;
                    case "Хвилини":resultView.setText(String.valueOf(formatter.format(enteredValue*525600)));break;
                    case "Година":resultView.setText(String.valueOf(formatter.format(enteredValue*8760)));break;
                    case "День":resultView.setText(String.valueOf(formatter.format(enteredValue*365)));break;
                    case "Тиждень":resultView.setText(String.valueOf(formatter.format(enteredValue*52.142857143)));break;
                    case "Місяц":resultView.setText(String.valueOf(formatter.format(enteredValue*12)));break;
                    case "Рік":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
            case "Мілліметр кубічний/мм³":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний/мм³":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Сантіметр кубічний/cм³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Метр кубічний/м³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001)));break;
                    case "Міллілітр/мл":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Літр/Л":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Унція рідка/унц(р)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000351951)));break;
                    case "Джил/дж":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000007039)));break;
                    case "Пінта/пт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000017598)));break;
                    case "Кварт/кт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000008798769931)));break;
                    case "Галлон/гал":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000002199692482)));break;
                    case "Баррель(UK)/б(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000006110256897)));break;
                }
                break;
            case "Сантіметр кубічний/cм³":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний/мм³":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Сантіметр кубічний/cм³":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Метр кубічний/м³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Міллілітр/мл":resultView.setText(String.valueOf(formatter.format(enteredValue*1)));break;
                    case "Літр/Л":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Унція рідка/унц(р)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0351950797)));break;
                    case "Джил/дж":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0070390159)));break;
                    case "Пінта/пт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001759754)));break;
                    case "Кварт/кт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000879877)));break;
                    case "Галлон/гал":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0002199692)));break;
                    case "Баррель(UK)/б(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000002199692482)));break;
                }
                break;
            case "Метр кубічний/м³":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний/мм³":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0000)));break;
                    case "Сантіметр кубічний/cм³":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Метр кубічний/м³":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Міллілітр/мл":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Літр/Л":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Унція рідка/унц(р)":resultView.setText(String.valueOf(formatter.format(enteredValue*35195.079728)));break;
                    case "Джил/дж":resultView.setText(String.valueOf(formatter.format(enteredValue*7039.0159456)));break;
                    case "Пінта/пт":resultView.setText(String.valueOf(formatter.format(enteredValue*1759.7539864)));break;
                    case "Кварт/кт":resultView.setText(String.valueOf(formatter.format(enteredValue*879.8769932)));break;
                    case "Галлон/гал":resultView.setText(String.valueOf(formatter.format(enteredValue*219.9692483)));break;
                    case "Баррель(UK)/б(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*6.1102568972)));break;
                }
                break;
            case "Міллілітр/мл":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний/мм³":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Сантіметр кубічний/cм³":resultView.setText(String.valueOf(formatter.format(enteredValue*1)));break;
                    case "Метр кубічний/м³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Міллілітр/мл":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Літр/Л":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Унція рідка/унц(р)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0351950797)));break;
                    case "Джил/дж":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0070390159)));break;
                    case "Пінта/пт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001759754)));break;
                    case "Кварт/кт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000879877)));break;
                    case "Галлон/гал":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0002199692)));break;
                    case "Баррель(UK)/б(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000061103)));break;
                }
                break;
            case "Літр/Л":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний/мм³":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Сантіметр кубічний/cм³":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Метр кубічний/м³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Міллілітр/мл":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Літр/Л":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Унція рідка/унц(р)":resultView.setText(String.valueOf(formatter.format(enteredValue*35.195079728)));break;
                    case "Джил/дж":resultView.setText(String.valueOf(formatter.format(enteredValue*7.0390159456)));break;
                    case "Пінта/пт":resultView.setText(String.valueOf(formatter.format(enteredValue*1.7597539864)));break;
                    case "Кварт/кт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.8798769932)));break;
                    case "Галлон/гал":resultView.setText(String.valueOf(formatter.format(enteredValue*0.2199692483)));break;
                    case "Баррель(UK)/б(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0061102569)));break;
                }
                break;
            case "Джил/дж":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний/мм³":resultView.setText(String.valueOf(formatter.format(enteredValue*142065.3125)));break;
                    case "Сантіметр кубічний/cм³":resultView.setText(String.valueOf(formatter.format(enteredValue*142.0653125)));break;
                    case "Метр кубічний/м³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001420653)));break;
                    case "Міллілітр/мл":resultView.setText(String.valueOf(formatter.format(enteredValue*142.0653125)));break;
                    case "Літр/Л":resultView.setText(String.valueOf(formatter.format(enteredValue*0.1420653125)));break;
                    case "Унція рідка/унц(р)":resultView.setText(String.valueOf(formatter.format(enteredValue*5)));break;
                    case "Джил/дж":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Пінта/пт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.25)));break;
                    case "Кварт/кт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.125)));break;
                    case "Галлон/гал":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03125)));break;
                    case "Баррель(UK)/б(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0008680556)));break;
                }
                break;
            case "Унція рідка/унц(р)":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний/мм³":resultView.setText(String.valueOf(formatter.format(enteredValue*28413.0625)));break;
                    case "Сантіметр кубічний/cм³":resultView.setText(String.valueOf(formatter.format(enteredValue*28.4130625)));break;
                    case "Метр кубічний/м³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000284131)));break;
                    case "Міллілітр/мл":resultView.setText(String.valueOf(formatter.format(enteredValue*28.4130625)));break;
                    case "Літр/Л":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0284130625)));break;
                    case "Унція рідка/унц(р)":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Джил/дж":resultView.setText(String.valueOf(formatter.format(enteredValue*0.2)));break;
                    case "Пінта/пт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.05)));break;
                    case "Кварт/кт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.025)));break;
                    case "Галлон/гал":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00625)));break;
                    case "Баррель(UK)/б(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001736111)));break;
                }
                break;
            case "Пінта/пт":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний/мм³":resultView.setText(String.valueOf(formatter.format(enteredValue*568261.25)));break;
                    case "Сантіметр кубічний/cм³":resultView.setText(String.valueOf(formatter.format(enteredValue*568.26125)));break;
                    case "Метр кубічний/м³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0005682613)));break;
                    case "Міллілітр/мл":resultView.setText(String.valueOf(formatter.format(enteredValue*568.26125)));break;
                    case "Літр/Л":resultView.setText(String.valueOf(formatter.format(enteredValue*0.56826125)));break;
                    case "Унція рідка/унц(р)":resultView.setText(String.valueOf(formatter.format(enteredValue*20)));break;
                    case "Джил/дж":resultView.setText(String.valueOf(formatter.format(enteredValue*4)));break;
                    case "Пінта/пт":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Кварт/кт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.5)));break;
                    case "Галлон/гал":resultView.setText(String.valueOf(formatter.format(enteredValue*0.125)));break;
                    case "Баррель(UK)/б(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0034722222)));break;
                }
                break;
            case "Кварт/кт":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний/мм³":resultView.setText(String.valueOf(formatter.format(enteredValue*1136522.5)));break;
                    case "Сантіметр кубічний/cм³":resultView.setText(String.valueOf(formatter.format(enteredValue*1136.5225)));break;
                    case "Метр кубічний/м³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0011365225)));break;
                    case "Міллілітр/мл":resultView.setText(String.valueOf(formatter.format(enteredValue*1136.5225)));break;
                    case "Літр/Л":resultView.setText(String.valueOf(formatter.format(enteredValue*1.1365225)));break;
                    case "Унція рідка/унц(р)":resultView.setText(String.valueOf(formatter.format(enteredValue*40)));break;
                    case "Джил/дж":resultView.setText(String.valueOf(formatter.format(enteredValue*8)));break;
                    case "Пінта/пт":resultView.setText(String.valueOf(formatter.format(enteredValue*2)));break;
                    case "Кварт/кт":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Галлон/гал":resultView.setText(String.valueOf(formatter.format(enteredValue*0.25)));break;
                    case "Баррель(UK)/б(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0069444444)));break;
                }
                break;
            case "Галлон/гал":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний/мм³":resultView.setText(String.valueOf(formatter.format(enteredValue*4546090)));break;
                    case "Сантіметр кубічний/cм³":resultView.setText(String.valueOf(formatter.format(enteredValue*4546.09)));break;
                    case "Метр кубічний/м³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00454609)));break;
                    case "Міллілітр/мл":resultView.setText(String.valueOf(formatter.format(enteredValue*4546.09)));break;
                    case "Літр/Л":resultView.setText(String.valueOf(formatter.format(enteredValue*3.785)));break;
                    case "Унція рідка/унц(р)":resultView.setText(String.valueOf(formatter.format(enteredValue*160)));break;
                    case "Джил/дж":resultView.setText(String.valueOf(formatter.format(enteredValue*32)));break;
                    case "Пінта/пт":resultView.setText(String.valueOf(formatter.format(enteredValue*8)));break;
                    case "Кварт/кт":resultView.setText(String.valueOf(formatter.format(enteredValue*4)));break;
                    case "Галлон/гал":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Баррель(UK)/б(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue*0.0277777778)));break;
                }
                break;
            case "Баррель(UK)/б(UK)":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний/мм³":resultView.setText(String.valueOf(formatter.format(enteredValue*163659240)));break;
                    case "Сантіметр кубічний/cм³":resultView.setText(String.valueOf(formatter.format(enteredValue*163659.24)));break;
                    case "Метр кубічний/м³":resultView.setText(String.valueOf(formatter.format(enteredValue*0.16365924)));break;
                    case "Міллілітр/мл":resultView.setText(String.valueOf(formatter.format(enteredValue*4546.09)));break;
                    case "Літр/Л":resultView.setText(String.valueOf(formatter.format(enteredValue*163.65924)));break;
                    case "Унція рідка/унц(р)":resultView.setText(String.valueOf(formatter.format(enteredValue*5760)));break;
                    case "Джил/дж":resultView.setText(String.valueOf(formatter.format(enteredValue*1152)));break;
                    case "Пінта/пт":resultView.setText(String.valueOf(formatter.format(enteredValue*288)));break;
                    case "Кварт/кт":resultView.setText(String.valueOf(formatter.format(enteredValue*144)));break;
                    case "Галлон/гал":resultView.setText(String.valueOf(formatter.format(enteredValue*36)));break;
                    case "Баррель(UK)/б(UK)" :resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
                break;
        }
    }

}

