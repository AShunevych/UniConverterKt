package ashunevich.uniconverter20;


import android.content.res.Resources;
import android.util.Log;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;


public abstract class ConverterLogic extends ConverterActivity {
    public ConverterLogic(TextView resultView, HashMap<String, String> hm){
        this.hm = hm;
        this.resultView = resultView;
    }

    public static void ConvertValues(String txtFromSpinner1, String txtFromSpinner2 , Double enteredValue, TextView resultView) {
        final double NineDivFive = 9.0/5.0;
        final double FiveDivNine = 5.0/9.0;

        NumberFormat formatter = new DecimalFormat("###.########################");
                                                            //0.0000000000003861021585
        switch (txtFromSpinner1) {
            // area
            case "Square millimeter":
                switch (txtFromSpinner2) {
                    case "Square millimeter": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Square centimeter": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.01)));break;
                    case "Square meter": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Square kilometer": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000000001)));break;
                    case "Hectare": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000001)));break;
                    case "Square mile": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000000003861021585)));break;
                    case "Acre": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000002471053814)));break;
                    case "Square yard": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001196)));break;
                    case "Square feet": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000107639)));break;
                    case "Square inch": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0015500031)));break;
                }
                break;
            case "Square centimeter":
                switch (txtFromSpinner2) {
                    case "Square millimeter": resultView.setText(String.valueOf(formatter.format(enteredValue*100)));break;
                    case "Square centimeter": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Square meter": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Square kilometer": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000001)));break;
                    case "Hectare": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000001)));break;
                    case "Square mile": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000000003861021585)));break;
                    case "Acre": resultView.setText(String.valueOf(formatter.format(enteredValue *0.00000002471053814)));break;
                    case "Square yard": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000119599)));break;
                    case "Square feet": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001076391)));break;
                    case "Square inch": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.15500031)));break;
                }
                break;
            case "Square meter":
                switch (txtFromSpinner2) {
                    case "Square millimeter": resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Square centimeter": resultView.setText(String.valueOf(formatter.format(enteredValue * 10000.0)));break;
                    case "Square meter": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Square kilometer": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Hectare": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Square mile": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000003861021585)));break;
                    case "Acre": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0002471054)));break;
                    case "Square yard": resultView.setText(String.valueOf(formatter.format(enteredValue * 1.1959900463)));break;
                    case "Square feet": resultView.setText(String.valueOf(formatter.format(enteredValue * 10.763910417)));break;
                    case "Square inch": resultView.setText(String.valueOf(formatter.format(enteredValue * 1550.0031)));break;
                }
                break;
            case "Square kilometer":
                switch (txtFromSpinner2) {
                    case "Square millimeter": resultView.setText(String.valueOf(formatter.format(enteredValue*1000000000000.0)));break;
                    case "Square centimeter": resultView.setText(String.valueOf(formatter.format(enteredValue * 10000000000.0)));break;
                    case "Square meter": resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Square kilometer": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Hectare": resultView.setText(String.valueOf(formatter.format(enteredValue * 100.0)));break;
                    case "Square mile": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.3861021585)));break;
                    case "Acre": resultView.setText(String.valueOf(formatter.format(enteredValue * 247.10538147)));break;
                    case "Square yard": resultView.setText(String.valueOf(formatter.format(enteredValue * 1195990.0463)));break;
                    case "Square feet": resultView.setText(String.valueOf(formatter.format(enteredValue * 10763910.417)));break;
                    case "Square inch": resultView.setText(String.valueOf(formatter.format(enteredValue * 1550003100)));break;
                }
                break;
            case "Hectare":
                switch (txtFromSpinner2) {
                    case "Square millimeter": resultView.setText(String.valueOf(formatter.format(enteredValue*10000000000.0)));break;
                    case "Square centimeter": resultView.setText(String.valueOf(formatter.format(enteredValue * 100000000)));break;
                    case "Square meter": resultView.setText(String.valueOf(formatter.format(enteredValue * 10000)));break;
                    case "Square kilometer": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.01)));break;
                    case "Hectare": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Square mile": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0038610216)));break;
                    case "Acre": resultView.setText(String.valueOf(formatter.format(enteredValue * 2.4710538147)));break;
                    case "Square yard": resultView.setText(String.valueOf(formatter.format(enteredValue * 11959.900463)));break;
                    case "Square feet": resultView.setText(String.valueOf(formatter.format(enteredValue * 107639.10417)));break;
                    case "Square inch": resultView.setText(String.valueOf(formatter.format(enteredValue * 15500031)));break;
                }
                break;
            case "Square mile":
                switch (txtFromSpinner2) {
                    case "Square millimeter": resultView.setText(String.valueOf(formatter.format(enteredValue*2589988110336.0)));break;
                    case "Square centimeter": resultView.setText(String.valueOf(formatter.format(enteredValue * 25899881103.0)));break;
                    case "Square meter": resultView.setText(String.valueOf(formatter.format(enteredValue * 2589988.1103)));break;
                    case "Square kilometer": resultView.setText(String.valueOf(formatter.format(enteredValue * 2.5899881103)));break;
                    case "Hectare": resultView.setText(String.valueOf(formatter.format(enteredValue * 258.99881103)));break;
                    case "Square mile": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Acre": resultView.setText(String.valueOf(formatter.format(enteredValue * 640)));break;
                    case "Square yard": resultView.setText(String.valueOf(formatter.format(enteredValue * 3097600)));break;
                    case "Square feet": resultView.setText(String.valueOf(formatter.format(enteredValue * 27878400)));break;
                    case "Square inch": resultView.setText(String.valueOf(formatter.format(enteredValue * 4014489600.0)));break;
                }
                break;
            case "Acre":
                switch (txtFromSpinner2) {
                    case "Square millimeter": resultView.setText(String.valueOf(formatter.format(enteredValue*4046856422.4)));break;
                    case "Square centimeter": resultView.setText(String.valueOf(formatter.format(enteredValue * 40468564.224)));break;
                    case "Square meter": resultView.setText(String.valueOf(formatter.format(enteredValue * 4046.8564224)));break;
                    case "Square kilometer": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0040468564)));break;
                    case "Hectare": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.4046856422)));break;
                    case "Square mile": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0015625)));break;
                    case "Acre": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Square yard": resultView.setText(String.valueOf(formatter.format(enteredValue * 4840)));break;
                    case "Square feet": resultView.setText(String.valueOf(formatter.format(enteredValue * 43560)));break;
                    case "Square inch": resultView.setText(String.valueOf(formatter.format(enteredValue * 6272640)));break;
                }
                break;
            case "Square yard":
                switch (txtFromSpinner2) {
                    case "Square millimeter": resultView.setText(String.valueOf(formatter.format(enteredValue*836127.36)));break;
                    case "Square centimeter": resultView.setText(String.valueOf(formatter.format(enteredValue * 8361.2736)));break;
                    case "Square meter": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.83612736)));break;
                    case "Square kilometer": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000008361273599)));break;
                    case "Hectare": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000836127)));break;
                    case "Square mile": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000003228305785)));break;
                    case "Acre": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0002066116)));break;
                    case "Square yard": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Square feet": resultView.setText(String.valueOf(formatter.format(enteredValue * 9)));break;
                    case "Square inch": resultView.setText(String.valueOf(formatter.format(enteredValue * 1296)));break;
                }
                break;
            case "Square feet":
                switch (txtFromSpinner2) {
                    case "Square millimeter": resultView.setText(String.valueOf(formatter.format(enteredValue*92903.04)));break;
                    case "Square centimeter": resultView.setText(String.valueOf(formatter.format(enteredValue * 929.0304)));break;
                    case "Square meter": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.09290304)));break;
                    case "Square kilometer": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000009290303999)));break;
                    case "Hectare": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000092903)));break;
                    case "Square mile": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000387006427)));break;
                    case "Acre": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000229568)));break;
                    case "Square yard": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1111111111)));break;
                    case "Square feet": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Square inch": resultView.setText(String.valueOf(formatter.format(enteredValue * 144)));break;
                }
            case "Square inch":
                switch (txtFromSpinner2) {
                    case "Square millimeter": resultView.setText(String.valueOf(formatter.format(enteredValue*645.16)));break;
                    case "Square centimeter": resultView.setText(String.valueOf(formatter.format(enteredValue * 6.4516)));break;
                    case "Square meter": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00064516)));break;
                    case "Square kilometer": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000000064516)));break;
                    case "Hectare": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000064516)));break;
                    case "Square mile": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000000290976686)));break;
                    case "Acre": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000001594225079)));break;
                    case "Square yard": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0007716049)));break;
                    case "Square feet": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0069444444)));break;
                    case "Дюйм квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
            case "Mlilinewton":
                switch (txtFromSpinner2) {
                    case "Mlilinewton":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Newton":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Kilonewton":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Ton-force(metric)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000001019716212)));break;
                    case "Gram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1019)));break;
                    case "Kilogram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000101)));break;
                    case "Pond":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1019)));break;
                    case "Pound-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00022)));break;
                    case "Ounce-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00359)));break;
                    case "Ton-force (long)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000001003611353)));break;
                    case "Poundal":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00723)));break;
                }
                break;
            case "Newton":
                switch (txtFromSpinner2) {
                    case "Mlilinewton":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Newton":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Kilonewton":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Ton-force(metric)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Gram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 101.971)));break;
                    case "Kilogram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.10197)));break;
                    case "Pond":resultView.setText(String.valueOf(formatter.format(enteredValue * 101.971)));break;
                    case "Pound-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.22480)));break;
                    case "Ounce-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.5969)));break;
                    case "Ton-force (long)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Poundal":resultView.setText(String.valueOf(formatter.format(enteredValue * 7.233)));break;
                }
                break;
            case "Kilonewton":
                switch (txtFromSpinner2) {
                    case "Mlilinewton":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Newton":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Kilonewton":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Ton-force(metric)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.101971)));break;
                    case "Gram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 101971.6)));break;
                    case "Kilogram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 101.971)));break;
                    case "Pond":resultView.setText(String.valueOf(formatter.format(enteredValue * 101971.6)));break;
                    case "Pound-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 224.81)));break;
                    case "Ounce-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 3596.94)));break;
                    case "Ton-force (long)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1003)));break;
                    case "Poundal":resultView.setText(String.valueOf(formatter.format(enteredValue * 7233.01)));break;
                }
                break;
            case "Ton-force(metric)":
                switch (txtFromSpinner2) {
                    case "Mlilinewton":resultView.setText(String.valueOf(formatter.format(enteredValue * 9806650)));break;
                    case "Newton":resultView.setText(String.valueOf(formatter.format(enteredValue * 9806.65)));break;
                    case "Kilonewton":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.80665)));break;
                    case "Ton-force(metric)":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Gram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Kilogram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Pond":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Pound-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 2204.62)));break;
                    case "Ounce-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 35273.96)));break;
                    case "Ton-force (long)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.9842)));break;
                    case "Poundal":resultView.setText(String.valueOf(formatter.format(enteredValue * 70931.63)));break;
                }
                break;
            case "Gram-force":
                switch (txtFromSpinner2) {
                    case "Mlilinewton":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.8066)));break;
                    case "Newton":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.009806)));break;
                    case "Kilonewton":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000098067)));break;
                    case "Ton-force(metric)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Gram-force":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Kilogram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Pond":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000007039)));break;
                    case "Pound-force":resultView.setText(String.valueOf(formatter.format(enteredValue*0.002204)));break;
                    case "Ounce-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.03527)));break;
                    case "Ton-force (long)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000009842065276)));break;
                    case "Poundal":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.07093)));break;
                }
                break;
            case "Kilogram-force":
                switch (txtFromSpinner2) {
                    case "Mlilinewton":resultView.setText(String.valueOf(formatter.format(enteredValue *9806.65)));break;
                    case "Newton":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.80665)));break;
                    case "Kilonewton":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0098066)));break;
                    case "Ton-force(metric)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Gram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Kilogram-force":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Pond":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Pound-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 2.20)));break;
                    case "Ounce-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 35.273)));break;
                    case "Ton-force (long)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0009842)));break;
                    case "Poundal":resultView.setText(String.valueOf(formatter.format(enteredValue * 70.931)));break;
                }
                break;
            case "Pond":
                switch (txtFromSpinner2) {
                    case "Mlilinewton":resultView.setText(String.valueOf(formatter.format(enteredValue *9.80665)));break;
                    case "Newton":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00980)));break;
                    case "Kilonewton":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000098)));break;
                    case "Ton-force(metric)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Gram-force":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Kilogram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Pond":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Pound-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.002204)));break;
                    case "Ounce-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.03527)));break;
                    case "Ton-force (long)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000009842065276)));break;
                    case "Poundal":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.07093)));break;
                }
                break;
            case "Pound-force":
                switch (txtFromSpinner2) {
                    case "Mlilinewton":resultView.setText(String.valueOf(formatter.format(enteredValue *4448.221)));break;
                    case "Newton":resultView.setText(String.valueOf(formatter.format(enteredValue * 4.448)));break;
                    case "Kilonewton":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00444)));break;
                    case "Ton-force(metric)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00045)));break;
                    case "Gram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 453.59)));break;
                    case "Kilogram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.45359)));break;
                    case "Pond":resultView.setText(String.valueOf(formatter.format(enteredValue * 453.59)));break;
                    case "Pound-force":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Ounce-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 16)));break;
                    case "Ton-force (long)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0004464)));break;
                    case "Poundal":resultView.setText(String.valueOf(formatter.format(enteredValue * 32.174)));break;
                }
                break;
            case "Ounce-force":
                switch (txtFromSpinner2) {
                    case "Mlilinewton":resultView.setText(String.valueOf(formatter.format(enteredValue *278.013)));break;
                    case "Newton":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.27801)));break;
                    case "Kilonewton":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0002780)));break;
                    case "Ton-force(metric)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000283)));break;
                    case "Gram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 28.349)));break;
                    case "Kilogram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.02834)));break;
                    case "Pond":resultView.setText(String.valueOf(formatter.format(enteredValue * 28.349)));break;
                    case "Pound-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0625)));break;
                    case "Ounce-force":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Ton-force (long)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000279)));break;
                    case "Poundal":resultView.setText(String.valueOf(formatter.format(enteredValue * 2.010)));break;
                }
                break;
            case "Ton-force (long)":
                switch (txtFromSpinner2) {
                    case "Mlilinewton":resultView.setText(String.valueOf(formatter.format(enteredValue *9964016.41)));break;
                    case "Newton":resultView.setText(String.valueOf(formatter.format(enteredValue * 9964.01)));break;
                    case "Kilonewton":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.9640)));break;
                    case "Ton-force(metric)":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.016)));break;
                    case "Gram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 1016046.90)));break;
                    case "Kilogram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 1016.046)));break;
                    case "Pond":resultView.setText(String.valueOf(formatter.format(enteredValue * 1016046.90)));break;
                    case "Pound-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 2240.0)));break;
                    case "Ounce-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 35840.0)));break;
                    case "Ton-force (long)":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Poundal":resultView.setText(String.valueOf(formatter.format(enteredValue * 72069.86)));break;
                }
                break;
            case "Poundal":
                switch (txtFromSpinner2) {
                    case "Mlilinewton":resultView.setText(String.valueOf(formatter.format(enteredValue *138.25)));break;
                    case "Newton":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.13825)));break;
                    case "Kilonewton":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000138)));break;
                    case "Ton-force(metric)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000140)));break;
                    case "Gram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 14.09)));break;
                    case "Kilogram-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.01409)));break;
                    case "Pond":resultView.setText(String.valueOf(formatter.format(enteredValue * 14.09)));break;
                    case "Pound-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.03108)));break;
                    case "Ounce-force":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.4972)));break;
                    case "Ton-force (long)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000138)));break;
                    case "Poundal":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
            case "Millimetre":
                switch (txtFromSpinner2){
                    case "Millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.1)));break;
                    case "Metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Kilometre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Inch":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03937)));break;
                    case "Foot":resultView.setText(String.valueOf(formatter.format(enteredValue*0.003280)));break;
                    case "Yard":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001093)));break;
                    case "Mile":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000062137)));break;
                }
                break;
            case "Centimetre":
                switch (txtFromSpinner2){
                    case "Millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*10)));break;
                    case "Centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.01)));break;
                    case "Kilometre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00001)));break;
                    case "Inch":resultView.setText(String.valueOf(formatter.format(enteredValue*0.3937)));break;
                    case "Foot":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03280)));break;
                    case "Yard":resultView.setText(String.valueOf(formatter.format(enteredValue*0.01093)));break;
                    case "Mile":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000006213)));break;
                }
                break;
            case "Metre":
                switch (txtFromSpinner2){
                    case "Millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*100)));break;
                    case "Metre":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Kilometre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Inch":resultView.setText(String.valueOf(formatter.format(enteredValue*39.37007)));break;
                    case "Foot":resultView.setText(String.valueOf(formatter.format(enteredValue*3.2808)));break;
                    case "Yard":resultView.setText(String.valueOf(formatter.format(enteredValue*1.09361)));break;
                    case "Mile":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00062137)));break;
                }
                break;
            case "Kilometre":
                switch (txtFromSpinner2){
                    case "Millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*100000.0)));break;
                    case "Metre":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Kilometre":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Inch":resultView.setText(String.valueOf(formatter.format(enteredValue*39370.08)));break;
                    case "Foot":resultView.setText(String.valueOf(formatter.format(enteredValue*3280.84)));break;
                    case "Yard":resultView.setText(String.valueOf(formatter.format(enteredValue*1093.6132)));break;
                    case "Mile":resultView.setText(String.valueOf(formatter.format(enteredValue*0.6214)));break;
                }
                break;
            case "Inch":
                switch (txtFromSpinner2){
                    case "Millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*25.4)));break;
                    case "Centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*2.54)));break;
                    case "Metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0254)));break;
                    case "Kilometre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000254)));break;
                    case "Inch":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Foot":resultView.setText(String.valueOf(formatter.format(enteredValue*0.08333)));break;
                    case "Yard":resultView.setText(String.valueOf(formatter.format(enteredValue*0.02777)));break;
                    case "Mile":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00001578)));break;
                }
                break;
            case "Foot":
                switch (txtFromSpinner2){
                    case "Millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*304.8)));break;
                    case "Centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*30.48)));break;
                    case "Metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.3048)));break;
                    case "Kilometre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0003048)));break;
                    case "Inch":resultView.setText(String.valueOf(formatter.format(enteredValue*12)));break;
                    case "Foot":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Yard":resultView.setText(String.valueOf(formatter.format(enteredValue*0.33333)));break;
                    case "Mile":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001893936)));break;
                }
                break;
            case "Yard":
                switch (txtFromSpinner2){
                    case "Millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*914.4)));break;
                    case "Centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*91.44)));break;
                    case "Metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.9144)));break;
                    case "Kilometre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0009144)));break;
                    case "Inch":resultView.setText(String.valueOf(formatter.format(enteredValue*36)));break;
                    case "Foot":resultView.setText(String.valueOf(formatter.format(enteredValue*3)));break;
                    case "Yard":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Mile":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0005681)));break;
                }
                break;
            case "Mile":
                switch (txtFromSpinner2){
                    case "Millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*1609347.21)));break;
                    case "Centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*160934.72)));break;
                    case "Metre":resultView.setText(String.valueOf(formatter.format(enteredValue*1609.34)));break;
                    case "Kilometre":resultView.setText(String.valueOf(formatter.format(enteredValue*1.6093)));break;
                    case "Inch":resultView.setText(String.valueOf(formatter.format(enteredValue*63360.12)));break;
                    case "Foot":resultView.setText(String.valueOf(formatter.format(enteredValue*5280.010)));break;
                    case "Yard":resultView.setText(String.valueOf(formatter.format(enteredValue*1760)));break;
                    case "Mile":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
            case "Milligram":
                switch (txtFromSpinner2){
                    case "Gram":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001))); break;
                    case "Kilogram":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001))); break;
                    case "Tonne": resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001))); break;
                    case "Grain":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0154))); break;
                    case "Ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000035))); break;
                    case "Pound":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000022))); break;
                    case "Hundreweight":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00000002))); break;
                    case "Ton(long)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001016))); break;
                    case "Milligram":resultView.setText(String.valueOf(formatter.format(enteredValue)));
                }
                break;
            case "Gram":
                switch (txtFromSpinner2){
                    case "Milligram":resultView.setText(String.valueOf(formatter.format(enteredValue*1000.0))); break;
                    case "Kilogram":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001))); break;
                    case "Tonne": resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001))); break;
                    case "Grain":resultView.setText(String.valueOf(formatter.format(enteredValue*15.43))); break;
                    case "Ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03527))); break;
                    case "Pound":resultView.setText(String.valueOf(formatter.format(enteredValue*0.002204))); break;
                    case "Hundreweight":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000196))); break;
                    case "Ton(long)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000009))); break;
                    case "Gram":resultView.setText(String.valueOf(formatter.format(enteredValue)));
                }
                break;
            case "Kilogram":
                switch (txtFromSpinner2){
                    case "Milligram":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0))); break;
                    case "Gram":resultView.setText(String.valueOf(formatter.format(enteredValue*1000.0))); break;
                    case "Tonne":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001))); break;
                    case "Grain":resultView.setText(String.valueOf(formatter.format(enteredValue*15432.35))); break;
                    case "Ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*35.27))); break;
                    case "Pound":resultView.setText(String.valueOf(formatter.format(enteredValue*2.20))); break;
                    case "Hundreweight":resultView.setText(String.valueOf(formatter.format(enteredValue*0.01968))); break;
                    case "Ton(long)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000984))); break;
                    case "Kilogram":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Tonne":
                switch (txtFromSpinner2){
                    case "Milligram":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000000.0))); break;
                    case "Gram":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0))); break;
                    case "Kilogram":                    resultView.setText(String.valueOf(formatter.format(enteredValue*1000.0))); break;
                    case "Grain":resultView.setText(String.valueOf(formatter.format(enteredValue*15432358.35))); break;
                    case "Ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*35273.96))); break;
                    case "Pound":resultView.setText(String.valueOf(formatter.format(enteredValue*2204.62))); break;
                    case "Hundreweight":resultView.setText(String.valueOf(formatter.format(enteredValue*19.68))); break;
                    case "Ton(long)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.9842))); break;
                    case "Tonne":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Grain":
                switch (txtFromSpinner2){
                    case "Milligram":resultView.setText(String.valueOf(formatter.format(enteredValue*64.79))); break;
                    case "Gram":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0647))); break;
                    case "Kilogram":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000064))); break;
                    case "Tonne":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000065))); break;
                    case "Ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00228))); break;
                    case "Pound":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000142857))); break;
                    case "Hundreweight":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001429))); break;
                    case "Ton(long)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000064))); break;
                    case "Grain":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Ounce":
                switch (txtFromSpinner2){
                    case "Milligram":resultView.setText(String.valueOf(formatter.format(enteredValue*28349.52))); break;
                    case "Gram":resultView.setText(String.valueOf(formatter.format(enteredValue*28.349))); break;
                    case "Kilogram":resultView.setText(String.valueOf(formatter.format(enteredValue*0.02834))); break;
                    case "Tonne":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00002835))); break;
                    case "Grain":resultView.setText(String.valueOf(formatter.format(enteredValue*437.49))); break;
                    case "Pound":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0625))); break;
                    case "Hundreweight":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000558036))); break;
                    case "Ton(long)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000279022))); break;
                    case "Ounce":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Pound":
                switch (txtFromSpinner2){
                    case "Milligram":resultView.setText(String.valueOf(formatter.format(enteredValue*453592.37))); break;
                    case "Gram":resultView.setText(String.valueOf(formatter.format(enteredValue*453.59))); break;
                    case "Kilogram":resultView.setText(String.valueOf(formatter.format(enteredValue*0.4535))); break;
                    case "Tonne":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0004535))); break;
                    case "Grain":resultView.setText(String.valueOf(formatter.format(enteredValue*6999.99))); break;
                    case "Ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*16))); break;
                    case "Hundreweight":resultView.setText(String.valueOf(formatter.format(enteredValue*0.008928571))); break;
                    case "Ton(long)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000446429))); break;
                    case "Pound":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Hundreweight":
                switch (txtFromSpinner2){
                    case "Milligram":resultView.setText(String.valueOf(formatter.format(enteredValue*50802345.44))); break;
                    case "Gram":resultView.setText(String.valueOf(formatter.format(enteredValue*50802.34))); break;
                    case "Kilogram": resultView.setText(String.valueOf(formatter.format(enteredValue*50.80))); break;
                    case "Tonne":resultView.setText(String.valueOf(formatter.format(enteredValue*0.05080))); break;
                    case "Grain":resultView.setText(String.valueOf(formatter.format(enteredValue*783999.999))); break;
                    case "Ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*1792))); break;
                    case "Pound":resultView.setText(String.valueOf(formatter.format(enteredValue*112))); break;
                    case "Ton(long)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.05))); break;
                    case "Hundreweight":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Ton(long)":
                switch (txtFromSpinner2){
                    case "Milligram":resultView.setText(String.valueOf(formatter.format(enteredValue*1016046908.8))); break;
                    case "Gram":resultView.setText(String.valueOf(formatter.format(enteredValue*1016046.90))); break;
                    case "Kilogram":                    resultView.setText(String.valueOf(formatter.format(enteredValue*1016.04))); break;
                    case "Tonne":resultView.setText(String.valueOf(formatter.format(enteredValue*1.016))); break;
                    case "Grain":resultView.setText(String.valueOf(formatter.format(enteredValue*15679999.99))); break;
                    case "Ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*35840.0))); break;
                    case "Pound":resultView.setText(String.valueOf(formatter.format(enteredValue*2240.0))); break;
                    case "Hundreweight":resultView.setText(String.valueOf(formatter.format(enteredValue*20.0))); break;
                    case "Ton(long)":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
            case "Meter/second":
                switch (txtFromSpinner2) {
                    case "Meter/second":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Meter/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 3600)));break;
                    case "Kilometer/second":                    resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Kilometer/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.6)));break;
                    case "Mach(SI)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0033)));break;
                    case "Foot/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.28)));break;
                    case "Foot/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 11811.02)));break;
                    case "Mile/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 2.23)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.943)));break;
                }
                break;
            case "Meter/hour":
                switch (txtFromSpinner2) {
                    case "Meter/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00027)));break;
                    case "Meter/hour":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Kilometer/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000002777777777)));break;
                    case "Kilometer/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Foot/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0009)));break;
                    case "Foot/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.28)));break;
                    case "Mile/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00062)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00053)));break;
                }
                break;
            case "Kilometer/second":
                switch (txtFromSpinner2) {
                    case "Meter/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.277)));break;
                    case "Meter/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Kilometer/second":                    resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00027)));break;
                    case "Kilometer/hour":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Foot/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.911)));break;
                    case "Foot/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 3280.8)));break;
                    case "Mile/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.621)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.539)));break;
                }
                break;
            case "Kilometer/hour":
                switch (txtFromSpinner2) {
                    case "Meter/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.2777)));break;
                    case "Meter/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Kilometer/second":                    resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00027)));break;
                    case "Kilometer/hour":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Foot/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.911)));break;
                    case "Foot/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 3280.8)));break;
                    case "Mile/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.621)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.539)));break;
                }
                break;
            case "Foot/second":
                switch (txtFromSpinner2) {
                    case "Meter/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.3048)));break;
                    case "Meter/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 1097.28)));break;
                    case "Kilometer/second":                    resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0003048)));break;
                    case "Kilometer/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.09728)));break;
                    case "Foot/second":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Foot/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 3600)));break;
                    case "Mile/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.681)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.5924)));break;
                }
                break;
            case "Foot/hour":
                switch (txtFromSpinner2) {
                    case "Meter/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000084)));break;
                    case "Meter/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.3)));break;
                    case "Kilometer/second":                    resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000008466666666)));break;
                    case "Kilometer/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00030)));break;
                    case "Foot/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00027)));break;
                    case "Foot/hour":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Mile/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00018)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00016)));break;
                }
                break;
            case "Mile/hour":
                switch (txtFromSpinner2) {
                    case "Meter/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.44)));break;
                    case "Meter/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 1609.3)));break;
                    case "Kilometer/second":                    resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00044)));break;
                    case "Kilometer/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.6)));break;
                    case "Foot/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.46)));break;
                    case "Foot/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 5280)));break;
                    case "Mile/hour":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.8689)));break;
                }
                break;
            case "Knot/kt":
                switch (txtFromSpinner2) {
                    case "Meter/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.514)));break;
                    case "Meter/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 1852)));break;
                    case "Kilometer/second":                    resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00051)));break;
                    case "Kilometer/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.852)));break;
                    case "Foot/second":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.687)));break;
                    case "Foot/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 6076.11)));break;
                    case "Mile/hour":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.150)));break;
                    case "Knot/kt":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
                break;
            case "Celsius":
                switch (txtFromSpinner2) {
                    case "Celsius":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Fahrenheit":resultView.setText(String.valueOf(formatter.format(enteredValue * NineDivFive +32)));break;
                    case "Kelvin":resultView.setText(String.valueOf(formatter.format(enteredValue + 273.15)));break;
                    case "Rankine":resultView.setText(String.valueOf(formatter.format(enteredValue * NineDivFive +491.76)));break;
                }
                break;
            case "Kelvin":
                switch (txtFromSpinner2) {
                    case "Celsius":resultView.setText(String.valueOf(formatter.format(enteredValue-273.15)));break;//here
                    case "Fahrenheit":resultView.setText(String.valueOf(formatter.format((enteredValue-273.15)*NineDivFive +32)));break; //here
                    case "Kelvin":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Rankine":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.8)));break;
                }
                break;
            case "Rankine/°R"  :
                switch (txtFromSpinner2) {
                    case "Celsius":resultView.setText(String.valueOf(formatter.format((enteredValue-491.67)*FiveDivNine)));break;//here
                    case "Fahrenheit":resultView.setText(String.valueOf(formatter.format(enteredValue-459.67)));break;//here
                    case "Kelvin":resultView.setText(String.valueOf(formatter.format(enteredValue*(5.0/9.0))));break;
                    case "Rankine":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
                break;
            case "Fahrenheit/°F" :
                switch (txtFromSpinner2) {
                    case "Celsius":resultView.setText(String.valueOf(formatter.format((enteredValue-32)*(5.0/9.0))));break;
                    case "Fahrenheit":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Kelvin":resultView.setText(String.valueOf(formatter.format((enteredValue-32.00)*(5.0/9.0)+273.15)));break;
                    case "Rankine":resultView.setText(String.valueOf(formatter.format(enteredValue + 459.67)));break;
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
                    case "Cubic millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Cubic centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Cubic metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001)));break;
                    case "Milliliter":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Liter":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Fluid ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000351951)));break;
                    case "Gill":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000007039)));break;
                    case "Pint":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000017598)));break;
                    case "Quart":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000008798769931)));break;
                    case "Gallon":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000002199692482)));break;
                    case "Barrel(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000006110256897)));break;
                }
                break;
            case "Cubic centimetre":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Cubic centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Cubic metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Milliliter":resultView.setText(String.valueOf(formatter.format(enteredValue*1)));break;
                    case "Liter":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Fluid ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0351950797)));break;
                    case "Gill":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0070390159)));break;
                    case "Pint":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001759754)));break;
                    case "Quart":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000879877)));break;
                    case "Gallon":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0002199692)));break;
                    case "Barrel(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000002199692482)));break;
                }
                break;
            case "Cubic metre":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0000)));break;
                    case "Cubic centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Cubic metre":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Milliliter":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Liter":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Fluid ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*35195.079728)));break;
                    case "Gill":resultView.setText(String.valueOf(formatter.format(enteredValue*7039.0159456)));break;
                    case "Pint":resultView.setText(String.valueOf(formatter.format(enteredValue*1759.7539864)));break;
                    case "Quart":resultView.setText(String.valueOf(formatter.format(enteredValue*879.8769932)));break;
                    case "Gallon":resultView.setText(String.valueOf(formatter.format(enteredValue*219.9692483)));break;
                    case "Barrel(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*6.1102568972)));break;
                }
                break;
            case "Milliliter":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Cubic centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*1)));break;
                    case "Cubic metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Milliliter":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Liter":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Fluid ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0351950797)));break;
                    case "Gill":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0070390159)));break;
                    case "Pint":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001759754)));break;
                    case "Quart":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000879877)));break;
                    case "Gallon":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0002199692)));break;
                    case "Barrel(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000061103)));break;
                }
                break;
            case "Liter":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Cubic centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Cubic metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Milliliter":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Liter":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Fluid ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*35.195079728)));break;
                    case "Gill":resultView.setText(String.valueOf(formatter.format(enteredValue*7.0390159456)));break;
                    case "Pint":resultView.setText(String.valueOf(formatter.format(enteredValue*1.7597539864)));break;
                    case "Quart":resultView.setText(String.valueOf(formatter.format(enteredValue*0.8798769932)));break;
                    case "Gallon":resultView.setText(String.valueOf(formatter.format(enteredValue*0.2199692483)));break;
                    case "Barrel(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0061102569)));break;
                }
                break;
            case "Gill":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*142065.3125)));break;
                    case "Cubic centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*142.0653125)));break;
                    case "Cubic metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001420653)));break;
                    case "Milliliter":resultView.setText(String.valueOf(formatter.format(enteredValue*142.0653125)));break;
                    case "Liter":resultView.setText(String.valueOf(formatter.format(enteredValue*0.1420653125)));break;
                    case "Fluid ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*5)));break;
                    case "Gill":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Pint":resultView.setText(String.valueOf(formatter.format(enteredValue*0.25)));break;
                    case "Quart":resultView.setText(String.valueOf(formatter.format(enteredValue*0.125)));break;
                    case "Gallon":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03125)));break;
                    case "Barrel(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0008680556)));break;
                }
                break;
            case "Fluid ounce":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*28413.0625)));break;
                    case "Cubic centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*28.4130625)));break;
                    case "Cubic metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000284131)));break;
                    case "Milliliter":resultView.setText(String.valueOf(formatter.format(enteredValue*28.4130625)));break;
                    case "Liter":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0284130625)));break;
                    case "Fluid ounce":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Gill":resultView.setText(String.valueOf(formatter.format(enteredValue*0.2)));break;
                    case "Pint":resultView.setText(String.valueOf(formatter.format(enteredValue*0.05)));break;
                    case "Quart":resultView.setText(String.valueOf(formatter.format(enteredValue*0.025)));break;
                    case "Gallon":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00625)));break;
                    case "Barrel(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001736111)));break;
                }
                break;
            case "Pint":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*568261.25)));break;
                    case "Cubic centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*568.26125)));break;
                    case "Cubic metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0005682613)));break;
                    case "Milliliter":resultView.setText(String.valueOf(formatter.format(enteredValue*568.26125)));break;
                    case "Liter":resultView.setText(String.valueOf(formatter.format(enteredValue*0.56826125)));break;
                    case "Fluid ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*20)));break;
                    case "Gill":resultView.setText(String.valueOf(formatter.format(enteredValue*4)));break;
                    case "Pint":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Quart":resultView.setText(String.valueOf(formatter.format(enteredValue*0.5)));break;
                    case "Gallon":resultView.setText(String.valueOf(formatter.format(enteredValue*0.125)));break;
                    case "Barrel(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0034722222)));break;
                }
                break;
            case "Quart":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*1136522.5)));break;
                    case "Cubic centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*1136.5225)));break;
                    case "Cubic metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0011365225)));break;
                    case "Milliliter":resultView.setText(String.valueOf(formatter.format(enteredValue*1136.5225)));break;
                    case "Liter":resultView.setText(String.valueOf(formatter.format(enteredValue*1.1365225)));break;
                    case "Fluid ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*40)));break;
                    case "Gill":resultView.setText(String.valueOf(formatter.format(enteredValue*8)));break;
                    case "Pint":resultView.setText(String.valueOf(formatter.format(enteredValue*2)));break;
                    case "Quart":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Gallon":resultView.setText(String.valueOf(formatter.format(enteredValue*0.25)));break;
                    case "Barrel(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0069444444)));break;
                }
                break;
            case "Gallon":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*4546090)));break;
                    case "Cubic centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*4546.09)));break;
                    case "Cubic metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00454609)));break;
                    case "Milliliter":resultView.setText(String.valueOf(formatter.format(enteredValue*4546.09)));break;
                    case "Liter":resultView.setText(String.valueOf(formatter.format(enteredValue*3.785)));break;
                    case "Fluid ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*160)));break;
                    case "Gill":resultView.setText(String.valueOf(formatter.format(enteredValue*32)));break;
                    case "Pint":resultView.setText(String.valueOf(formatter.format(enteredValue*8)));break;
                    case "Quart":resultView.setText(String.valueOf(formatter.format(enteredValue*4)));break;
                    case "Gallon":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Barrel(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0277777778)));break;
                }
                break;
            case "Barrel(UK)":
                switch (txtFromSpinner2) {
                    case "Cubic millimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*163659240)));break;
                    case "Cubic centimetre":resultView.setText(String.valueOf(formatter.format(enteredValue*163659.24)));break;
                    case "Cubic metre":resultView.setText(String.valueOf(formatter.format(enteredValue*0.16365924)));break;
                    case "Milliliter":resultView.setText(String.valueOf(formatter.format(enteredValue*4546.09)));break;
                    case "Liter":resultView.setText(String.valueOf(formatter.format(enteredValue*163.65924)));break;
                    case "Fluid ounce":resultView.setText(String.valueOf(formatter.format(enteredValue*5760)));break;
                    case "Gill":resultView.setText(String.valueOf(formatter.format(enteredValue*1152)));break;
                    case "Pint":resultView.setText(String.valueOf(formatter.format(enteredValue*288)));break;
                    case "Quart":resultView.setText(String.valueOf(formatter.format(enteredValue*144)));break;
                    case "Gallon":resultView.setText(String.valueOf(formatter.format(enteredValue*36)));break;
                    case "Barrel(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
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
            case "Мілліметр квадратний":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Сантіметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.01)));break;
                    case "Метр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Кілометр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000000001)));break;
                    case "Гектар": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000001)));break;
                    case "Міля квадратна": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000000003861021585)));break;
                    case "Акр": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000002471053814)));break;
                    case "Ярд квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001196)));break;
                    case "Фут квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000107639)));break;
                    case "Дюйм квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0015500031)));break;
                }
                break;
            case "Сантіметр квадратний":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue*100)));break;
                    case "Сантіметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Метр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Кілометр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000000001)));break;
                    case "Гектар": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000001)));break;
                    case "Міля квадратна": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000000003861021585)));break;
                    case "Акр": resultView.setText(String.valueOf(formatter.format(enteredValue *0.00000002471053814)));break;
                    case "Ярд квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000119599)));break;
                    case "Фут квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001076391)));break;
                    case "Дюйм квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.15500031)));break;
                }
                break;
            case "Метр квадратний":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Сантіметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 10000.0)));break;
                    case "Метр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Кілометр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Гектар": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Міля квадратна": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000003861021585)));break;
                    case "Акр": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0002471054)));break;
                    case "Ярд квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 1.1959900463)));break;
                    case "Фут квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 10.763910417)));break;
                    case "Дюйм квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 1550.0031)));break;
                }
                break;
            case "Кілометр квадратний":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue*1000000000000.0)));break;
                    case "Сантіметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 10000000000.0)));break;
                    case "Метр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Кілометр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Гектар": resultView.setText(String.valueOf(formatter.format(enteredValue * 100.0)));break;
                    case "Міля квадратна": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.3861021585)));break;
                    case "Акр": resultView.setText(String.valueOf(formatter.format(enteredValue * 247.10538147)));break;
                    case "Ярд квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 1195990.0463)));break;
                    case "Фут квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 10763910.417)));break;
                    case "Дюйм квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 1550003100)));break;
                }
                break;
            case "Гектар":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue*10000000000.0)));break;
                    case "Сантіметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 100000000)));break;
                    case "Метр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 10000)));break;
                    case "Кілометр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.01)));break;
                    case "Гектар": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Міля квадратна": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0038610216)));break;
                    case "Акр": resultView.setText(String.valueOf(formatter.format(enteredValue * 2.4710538147)));break;
                    case "Ярд квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 11959.900463)));break;
                    case "Фут квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 107639.10417)));break;
                    case "Дюйм квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 15500031)));break;
                }
                break;
            case "Міля квадратна":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue*2589988110336.0)));break;
                    case "Сантіметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 25899881103.0)));break;
                    case "Метр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 2589988.1103)));break;
                    case "Кілометр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 2.5899881103)));break;
                    case "Гектар": resultView.setText(String.valueOf(formatter.format(enteredValue * 258.99881103)));break;
                    case "Міля квадратна": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Акр": resultView.setText(String.valueOf(formatter.format(enteredValue * 640)));break;
                    case "Ярд квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 3097600)));break;
                    case "Фут квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 27878400)));break;
                    case "Дюйм квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 4014489600.0)));break;
                }
                break;
            case "Акр":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue*4046856422.4)));break;
                    case "Сантіметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 40468564.224)));break;
                    case "Метр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 4046.8564224)));break;
                    case "Кілометр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0040468564)));break;
                    case "Гектар": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.4046856422)));break;
                    case "Міля квадратна": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0015625)));break;
                    case "Акр": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Ярд квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 4840)));break;
                    case "Фут квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 43560)));break;
                    case "Дюйм квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 6272640)));break;
                }
                break;
            case "Ярд квадратний":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue*836127.36)));break;
                    case "Сантіметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 8361.2736)));break;
                    case "Метр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.83612736)));break;
                    case "Кілометр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000008361273599)));break;
                    case "Гектар": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000836127)));break;
                    case "Міля квадратна": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000003228305785)));break;
                    case "Акр": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0002066116)));break;
                    case "Ярд квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Фут квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 9)));break;
                    case "Дюйм квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 1296)));break;
                }
                break;
            case "Фут квадратний":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue*92903.04)));break;
                    case "Сантіметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 929.0304)));break;
                    case "Метр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.09290304)));break;
                    case "Кілометр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000009290303999)));break;
                    case "Гектар": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000092903)));break;
                    case "Міля квадратна": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000387006427)));break;
                    case "Акр": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000229568)));break;
                    case "Ярд квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1111111111)));break;
                    case "Фут квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Дюйм квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 144)));break;
                }
            case "Дюйм квадратний":
                switch (txtFromSpinner2) {
                    case "Мілліметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue*645.16)));break;
                    case "Сантіметр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 6.4516)));break;
                    case "Метр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00064516)));break;
                    case "Кілометр квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000000064516)));break;
                    case "Гектар": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000064516)));break;
                    case "Міля квадратна": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000000000290976686)));break;
                    case "Акр": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000001594225079)));break;
                    case "Ярд квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0007716049)));break;
                    case "Фут квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0069444444)));break;
                    case "Дюйм квадратний": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
            case "Мілліньютон":
                switch (txtFromSpinner2) {
                    case "Мілліньютон":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Ньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Кілоньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Тонна-сила(метрична)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000001019716212)));break;
                    case "Грам-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1019)));break;
                    case "Кілограм-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000101)));break;
                    case "Понд":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1019)));break;
                    case "Фунт-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00022)));break;
                    case "Унція-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00359)));break;
                    case "Тонна-сила(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000001003611353)));break;
                    case "Паундаль":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00723)));break;
                }
                break;
            case "Ньютон":
                switch (txtFromSpinner2) {
                    case "Мілліньютон":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Ньютон":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Кілоньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Тонна-сила(метрична)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Грам-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 101.971)));break;
                    case "Кілограм-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.10197)));break;
                    case "Понд":resultView.setText(String.valueOf(formatter.format(enteredValue * 101.971)));break;
                    case "Фунт-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.22480)));break;
                    case "Унція-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.5969)));break;
                    case "Тонна-сила(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0001)));break;
                    case "Паундаль":resultView.setText(String.valueOf(formatter.format(enteredValue * 7.233)));break;
                }
                break;
            case "Кілоньютон":
                switch (txtFromSpinner2) {
                    case "Мілліньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Ньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Кілоньютон":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Тонна-сила(метрична)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.101971)));break;
                    case "Грам-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 101971.6)));break;
                    case "Кілограм-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 101.971)));break;
                    case "Понд":resultView.setText(String.valueOf(formatter.format(enteredValue * 101971.6)));break;
                    case "Фунт-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 224.81)));break;
                    case "Унція-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 3596.94)));break;
                    case "Тонна-сила(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.1003)));break;
                    case "Паундаль":resultView.setText(String.valueOf(formatter.format(enteredValue * 7233.01)));break;
                }
                break;
            case "Тонна-сила(метрична)":
                switch (txtFromSpinner2) {
                    case "Мілліньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 9806650)));break;
                    case "Ньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 9806.65)));break;
                    case "Кілоньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.80665)));break;
                    case "Тонна-сила(метрична)":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Грам-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Кілограм-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Понд":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000000.0)));break;
                    case "Фунт-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 2204.62)));break;
                    case "Унція-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 35273.96)));break;
                    case "Тонна-сила(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.9842)));break;
                    case "Паундаль":resultView.setText(String.valueOf(formatter.format(enteredValue * 70931.63)));break;
                }
                break;
            case "Грам-сила":
                switch (txtFromSpinner2) {
                    case "Мілліньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.8066)));break;
                    case "Ньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.009806)));break;
                    case "Кілоньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000098067)));break;
                    case "Тонна-сила(метрична)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Грам-сила":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Кілограм-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Понд":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000007039)));break;
                    case "Фунт-сила":resultView.setText(String.valueOf(formatter.format(enteredValue*0.002204)));break;
                    case "Унція-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.03527)));break;
                    case "Тонна-сила(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000009842065276)));break;
                    case "Паундаль":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.07093)));break;
                }
                break;
            case "Кілограм-сила":
                switch (txtFromSpinner2) {
                    case "Мілліньютон":resultView.setText(String.valueOf(formatter.format(enteredValue *9806.65)));break;
                    case "Ньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.80665)));break;
                    case "Кілоньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0098066)));break;
                    case "Тонна-сила(метрична)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Грам-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Кілограм-сила":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Понд":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Фунт-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 2.20)));break;
                    case "Унція-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 35.273)));break;
                    case "Тонна-сила(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0009842)));break;
                    case "Паундаль":resultView.setText(String.valueOf(formatter.format(enteredValue * 70.931)));break;
                }
                break;
            case "Понд":
                switch (txtFromSpinner2) {
                    case "Мілліньютон":resultView.setText(String.valueOf(formatter.format(enteredValue *9.80665)));break;
                    case "Ньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00980)));break;
                    case "Кілоньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000098)));break;
                    case "Тонна-сила(метрична)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000001)));break;
                    case "Грам-сила":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Кілограм-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Понд":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Фунт-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.002204)));break;
                    case "Унція-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.03527)));break;
                    case "Тонна-сила(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000009842065276)));break;
                    case "Паундаль":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.07093)));break;
                }
                break;
            case "Фунт-сила":
                switch (txtFromSpinner2) {
                    case "Мілліньютон":resultView.setText(String.valueOf(formatter.format(enteredValue *4448.221)));break;
                    case "Ньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 4.448)));break;
                    case "Кілоньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00444)));break;
                    case "Тонна-сила(метрична)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00045)));break;
                    case "Грам-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 453.59)));break;
                    case "Кілограм-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.45359)));break;
                    case "Понд":resultView.setText(String.valueOf(formatter.format(enteredValue * 453.59)));break;
                    case "Фунт-сила":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Унція-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 16)));break;
                    case "Тонна-сила(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0004464)));break;
                    case "Паундаль":resultView.setText(String.valueOf(formatter.format(enteredValue * 32.174)));break;
                }
                break;
            case "Унція-сила":
                switch (txtFromSpinner2) {
                    case "Мілліньютон":resultView.setText(String.valueOf(formatter.format(enteredValue *278.013)));break;
                    case "Ньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.27801)));break;
                    case "Кілоньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0002780)));break;
                    case "Тонна-сила(метрична)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000283)));break;
                    case "Грам-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 28.349)));break;
                    case "Кілограм-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.02834)));break;
                    case "Понд":resultView.setText(String.valueOf(formatter.format(enteredValue * 28.349)));break;
                    case "Фунт-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0625)));break;
                    case "Унція-сила":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Тонна-сила(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000279)));break;
                    case "Паундаль":resultView.setText(String.valueOf(formatter.format(enteredValue * 2.010)));break;
                }
                break;
            case "Тонна-сила(довга)":
                switch (txtFromSpinner2) {
                    case "Мілліньютон":resultView.setText(String.valueOf(formatter.format(enteredValue *9964016.41)));break;
                    case "Ньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 9964.01)));break;
                    case "Кілоньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 9.9640)));break;
                    case "Тонна-сила(метрична)":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.016)));break;
                    case "Грам-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 1016046.90)));break;
                    case "Кілограм-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 1016.046)));break;
                    case "Понд":resultView.setText(String.valueOf(formatter.format(enteredValue * 1016046.90)));break;
                    case "Фунт-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 2240.0)));break;
                    case "Унція-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 35840.0)));break;
                    case "Тонна-сила(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue )));break;
                    case "Паундаль":resultView.setText(String.valueOf(formatter.format(enteredValue * 72069.86)));break;
                }
                break;
            case "Паундаль":
                switch (txtFromSpinner2) {
                    case "Мілліньютон":resultView.setText(String.valueOf(formatter.format(enteredValue *138.25)));break;
                    case "Ньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.13825)));break;
                    case "Кілоньютон":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000138)));break;
                    case "Тонна-сила(метрична)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000140)));break;
                    case "Грам-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 14.09)));break;
                    case "Кілограм-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.01409)));break;
                    case "Понд":resultView.setText(String.valueOf(formatter.format(enteredValue * 14.09)));break;
                    case "Фунт-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.03108)));break;
                    case "Унція-сила":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.4972)));break;
                    case "Тонна-сила(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000138)));break;
                    case "Паундаль":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
            case "Мілліметр":
                switch (txtFromSpinner2){
                    case "Мілліметр":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Сантіметр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.1)));break;
                    case "Метр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Кілометр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Дюйм":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03937)));break;
                    case "Фут":resultView.setText(String.valueOf(formatter.format(enteredValue*0.003280)));break;
                    case "Ярд":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001093)));break;
                    case "Міля":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000062137)));break;
                }
                break;
            case "Сантіметр":
                switch (txtFromSpinner2){
                    case "Мілліметр":resultView.setText(String.valueOf(formatter.format(enteredValue*10)));break;
                    case "Сантіметр":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Метр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.01)));break;
                    case "Кілометр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00001)));break;
                    case "Дюйм":resultView.setText(String.valueOf(formatter.format(enteredValue*0.3937)));break;
                    case "Фут":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03280)));break;
                    case "Ярд":resultView.setText(String.valueOf(formatter.format(enteredValue*0.01093)));break;
                    case "Міля":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000006213)));break;
                }
                break;
            case "Метр":
                switch (txtFromSpinner2){
                    case "Мілліметр":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Сантіметр":resultView.setText(String.valueOf(formatter.format(enteredValue*100)));break;
                    case "Метр":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Кілометр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Дюйм":resultView.setText(String.valueOf(formatter.format(enteredValue*39.37007)));break;
                    case "Фут":resultView.setText(String.valueOf(formatter.format(enteredValue*3.2808)));break;
                    case "Ярд":resultView.setText(String.valueOf(formatter.format(enteredValue*1.09361)));break;
                    case "Міля":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00062137)));break;
                }
                break;
            case "Кілометр":
                switch (txtFromSpinner2){
                    case "Мілліметр":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Сантіметр":resultView.setText(String.valueOf(formatter.format(enteredValue*100000.0)));break;
                    case "Метр":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Кілометр":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Дюйм":resultView.setText(String.valueOf(formatter.format(enteredValue*39370.08)));break;
                    case "Фут":resultView.setText(String.valueOf(formatter.format(enteredValue*3280.84)));break;
                    case "Ярд":resultView.setText(String.valueOf(formatter.format(enteredValue*1093.6132)));break;
                    case "Міля":resultView.setText(String.valueOf(formatter.format(enteredValue*0.6214)));break;
                }
                break;
            case "Дюйм":
                switch (txtFromSpinner2){
                    case "Мілліметр":resultView.setText(String.valueOf(formatter.format(enteredValue*25.4)));break;
                    case "Сантіметр":resultView.setText(String.valueOf(formatter.format(enteredValue*2.54)));break;
                    case "Метр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0254)));break;
                    case "Кілометр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000254)));break;
                    case "Дюйм":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Фут":resultView.setText(String.valueOf(formatter.format(enteredValue*0.08333)));break;
                    case "Ярд":resultView.setText(String.valueOf(formatter.format(enteredValue*0.02777)));break;
                    case "Міля":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00001578)));break;
                }
                break;
            case "Фут":
                switch (txtFromSpinner2){
                    case "Мілліметр":resultView.setText(String.valueOf(formatter.format(enteredValue*304.8)));break;
                    case "Сантіметр":resultView.setText(String.valueOf(formatter.format(enteredValue*30.48)));break;
                    case "Метр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.3048)));break;
                    case "Кілометр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0003048)));break;
                    case "Дюйм":resultView.setText(String.valueOf(formatter.format(enteredValue*12)));break;
                    case "Фут":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Ярд":resultView.setText(String.valueOf(formatter.format(enteredValue*0.33333)));break;
                    case "Міля":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001893936)));break;
                }
                break;
            case "Ярд":
                switch (txtFromSpinner2){
                    case "Мілліметр":resultView.setText(String.valueOf(formatter.format(enteredValue*914.4)));break;
                    case "Сантіметр":resultView.setText(String.valueOf(formatter.format(enteredValue*91.44)));break;
                    case "Метр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.9144)));break;
                    case "Кілометр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0009144)));break;
                    case "Дюйм":resultView.setText(String.valueOf(formatter.format(enteredValue*36)));break;
                    case "Фут":resultView.setText(String.valueOf(formatter.format(enteredValue*3)));break;
                    case "Ярд":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Міля":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0005681)));break;
                }
                break;
            case "Міля":
                switch (txtFromSpinner2){
                    case "Мілліметр":resultView.setText(String.valueOf(formatter.format(enteredValue*1609347.21)));break;
                    case "Сантіметр":resultView.setText(String.valueOf(formatter.format(enteredValue*160934.72)));break;
                    case "Метр":resultView.setText(String.valueOf(formatter.format(enteredValue*1609.34)));break;
                    case "Кілометр":resultView.setText(String.valueOf(formatter.format(enteredValue*1.6093)));break;
                    case "Дюйм":resultView.setText(String.valueOf(formatter.format(enteredValue*63360.12)));break;
                    case "Фут":resultView.setText(String.valueOf(formatter.format(enteredValue*5280.010)));break;
                    case "Ярд":resultView.setText(String.valueOf(formatter.format(enteredValue*1760)));break;
                    case "Міля":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
            case "Мілліграм":
                switch (txtFromSpinner2){
                    case "Грам":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001))); break;
                    case "Кілограм":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001))); break;
                    case "Тонна":                    resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001))); break;
                    case "Гран":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0154))); break;
                    case "Унція":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000035))); break;
                    case "Фунт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000022))); break;
                    case "Хандредвейт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00000002))); break;
                    case "Ton(long)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001016))); break;
                    case "Мілліграм":resultView.setText(String.valueOf(formatter.format(enteredValue)));
                }
                break;
            case "Грам":
                switch (txtFromSpinner2){
                    case "Мілліграм":resultView.setText(String.valueOf(formatter.format(enteredValue*1000.0))); break;
                    case "Кілограм":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001))); break;
                    case "Тонна": resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001))); break;
                    case "Гран":resultView.setText(String.valueOf(formatter.format(enteredValue*15.43))); break;
                    case "Унція":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03527))); break;
                    case "Фунт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.002204))); break;
                    case "Хандредвейт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000196))); break;
                    case "Тонна(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000009))); break;
                    case "Грам":resultView.setText(String.valueOf(formatter.format(enteredValue)));
                }
                break;
            case "Кілограм":
                switch (txtFromSpinner2){
                    case "Мілліграм":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0))); break;
                    case "Грам":resultView.setText(String.valueOf(formatter.format(enteredValue*1000.0))); break;
                    case "Тонна":                    resultView.setText(String.valueOf(formatter.format(enteredValue*0.001))); break;
                    case "Гран":resultView.setText(String.valueOf(formatter.format(enteredValue*15432.35))); break;
                    case "Унція":resultView.setText(String.valueOf(formatter.format(enteredValue*35.27))); break;
                    case "Фунт":resultView.setText(String.valueOf(formatter.format(enteredValue*2.20))); break;
                    case "Хандредвейт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.01968))); break;
                    case "Тонна(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000984))); break;
                    case "Кілограм":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Тонна":
                switch (txtFromSpinner2){
                    case "Мілліграм":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000000.0))); break;
                    case "Грам":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0))); break;
                    case "Кілограм":                    resultView.setText(String.valueOf(formatter.format(enteredValue*1000.0))); break;
                    case "Гран":resultView.setText(String.valueOf(formatter.format(enteredValue*15432358.35))); break;
                    case "Унція":resultView.setText(String.valueOf(formatter.format(enteredValue*35273.96))); break;
                    case "Фунт":resultView.setText(String.valueOf(formatter.format(enteredValue*2204.62))); break;
                    case "Хандредвейт":resultView.setText(String.valueOf(formatter.format(enteredValue*19.68))); break;
                    case "Тонна(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.9842))); break;
                    case "Тонна":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Гран":
                switch (txtFromSpinner2){
                    case "Мілліграм":resultView.setText(String.valueOf(formatter.format(enteredValue*64.79))); break;
                    case "Грам":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0647))); break;
                    case "Кілограм":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000064))); break;
                    case "Тонна":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000065))); break;
                    case "Унція":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00228))); break;
                    case "Фунт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000142857))); break;
                    case "Хандредвейт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001429))); break;
                    case "Тонна(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000064))); break;
                    case "Гран":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Унція":
                switch (txtFromSpinner2){
                    case "Мілліграм":resultView.setText(String.valueOf(formatter.format(enteredValue*28349.52))); break;
                    case "Грам":resultView.setText(String.valueOf(formatter.format(enteredValue*28.349))); break;
                    case "Кілограм":                    resultView.setText(String.valueOf(formatter.format(enteredValue*0.02834))); break;
                    case "Тонна":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00002835))); break;
                    case "Гран":resultView.setText(String.valueOf(formatter.format(enteredValue*437.49))); break;
                    case "Фунт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0625))); break;
                    case "Хандредвейт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000558036))); break;
                    case "Тонна(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000279022))); break;
                    case "Унція":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Фунт":
                switch (txtFromSpinner2){
                    case "Мілліграм":resultView.setText(String.valueOf(formatter.format(enteredValue*453592.37))); break;
                    case "Грам":resultView.setText(String.valueOf(formatter.format(enteredValue*453.59))); break;
                    case "Кілограм":resultView.setText(String.valueOf(formatter.format(enteredValue*0.4535))); break;
                    case "Тонна":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0004535))); break;
                    case "Гран":resultView.setText(String.valueOf(formatter.format(enteredValue*6999.99))); break;
                    case "Унція":resultView.setText(String.valueOf(formatter.format(enteredValue*16))); break;
                    case "Хандредвейт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.008928571))); break;
                    case "Тонна(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000446429))); break;
                    case "Фунт":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case "Хандредвейт":
                switch (txtFromSpinner2){
                    case "Мілліграм":resultView.setText(String.valueOf(formatter.format(enteredValue*50802345.44))); break;
                    case "Грам":resultView.setText(String.valueOf(formatter.format(enteredValue*50802.34))); break;
                    case "Кілограм": resultView.setText(String.valueOf(formatter.format(enteredValue*50.80))); break;
                    case "Тонна":resultView.setText(String.valueOf(formatter.format(enteredValue*0.05080))); break;
                    case "Гран":resultView.setText(String.valueOf(formatter.format(enteredValue*783999.999))); break;
                    case "Унція":resultView.setText(String.valueOf(formatter.format(enteredValue*1792))); break;
                    case "Фунт":resultView.setText(String.valueOf(formatter.format(enteredValue*112))); break;
                    case "Тонна(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.05))); break;
                    case "Хандредвейт":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
                break;
            case  "Тонна(довга)":
                switch (txtFromSpinner2){
                    case "Мілліграм":resultView.setText(String.valueOf(formatter.format(enteredValue*1016046908.8))); break;
                    case "Грам":resultView.setText(String.valueOf(formatter.format(enteredValue*1016046.90))); break;
                    case "Кілограм":                    resultView.setText(String.valueOf(formatter.format(enteredValue*1016.04))); break;
                    case "Тонна":resultView.setText(String.valueOf(formatter.format(enteredValue*1.016))); break;
                    case "Гран":resultView.setText(String.valueOf(formatter.format(enteredValue*15679999.99))); break;
                    case "Унція":resultView.setText(String.valueOf(formatter.format(enteredValue*35840.0))); break;
                    case "Фунт":resultView.setText(String.valueOf(formatter.format(enteredValue*2240.0))); break;
                    case "Хандредвейт":resultView.setText(String.valueOf(formatter.format(enteredValue*20.0))); break;
                    case "Тонна(довга)":resultView.setText(String.valueOf(formatter.format(enteredValue))); break;
                }
            case "Метрів/секунда":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Метрів/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 3600)));break;
                    case "Кілометр/секунда":                    resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Кілометр/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.6)));break;
                    case "Фут/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.28)));break;
                    case "Фут/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 11811.02)));break;
                    case "Міль/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 2.23)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.943)));break;
                }
                break;
            case "Метрів/година":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00027)));break;
                    case "Метрів/година":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Кілометр/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0000002777777777)));break;
                    case "Кілометр/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.001)));break;
                    case "Фут/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0009)));break;
                    case "Фут/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 3.28)));break;
                    case "Міль/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00062)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00053)));break;
                }
                break;
            case "Кілометр/секунда":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Метрів/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 3600000)));break;
                    case "Кілометр/секунда":                    resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Кілометр/година":resultView.setText(String.valueOf(formatter.format(enteredValue*3600)));break;
                    case "Фут/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 3280.83)));break;
                    case "Фут/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 11811023.6)));break;
                    case "Міль/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 2236.9)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue * 1943.8)));break;
                }
                break;
            case "Кілометр/година":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.2777)));break;
                    case "Метрів/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 1000)));break;
                    case "Кілометр/секунда":                    resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00027)));break;
                    case "Кілометр/година":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Фут/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.911)));break;
                    case "Фут/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 3280.8)));break;
                    case "Міль/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.621)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.539)));break;
                }
                break;
            case "Фут/секунда":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.3048)));break;
                    case "Метрів/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 1097.28)));break;
                    case "Кілометр/секунда":                    resultView.setText(String.valueOf(formatter.format(enteredValue * 0.0003048)));break;
                    case "Кілометр/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.09728)));break;
                    case "Фут/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Фут/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 3600)));break;
                    case "Міль/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.681)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.5924)));break;
                }
                break;
            case "Фут/година":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.000084)));break;
                    case "Метрів/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.3)));break;
                    case "Кілометр/секунда":                    resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00000008466666666)));break;
                    case "Кілометр/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00030)));break;
                    case "Фут/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00027)));break;
                    case "Фут/година":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Міль/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00018)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00016)));break;
                }
                break;
            case "Міль/година":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.44)));break;
                    case "Метрів/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 1609.3)));break;
                    case "Кілометр/секунда":                    resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00044)));break;
                    case "Кілометр/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.6)));break;
                    case "Фут/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.46)));break;
                    case "Фут/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 5280)));break;
                    case "Міль/година":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.8689)));break;
                }
                break;
            case "Вузол/В":
                switch (txtFromSpinner2) {
                    case "Метрів/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 0.514)));break;
                    case "Метрів/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 1852)));break;
                    case "Кілометр/секунда":                    resultView.setText(String.valueOf(formatter.format(enteredValue * 0.00051)));break;
                    case "Кілометр/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.852)));break;
                    case "Фут/секунда":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.687)));break;
                    case "Фут/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 6076.11)));break;
                    case "Міль/година":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.150)));break;
                    case "Вузол/В":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
                break;
            case "Цельсій":
                switch (txtFromSpinner2) {
                    case "Цельсій":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Фаренгейт":resultView.setText(String.valueOf(formatter.format(enteredValue * (9.0/5.0)+32)));break;
                    case "Кельвін":resultView.setText(String.valueOf(formatter.format(enteredValue + 273.15)));break;
                    case "Ранкін":resultView.setText(String.valueOf(formatter.format(enteredValue * (9.0/5.0)+491.76)));break;
                }
                break;
            case "Кельвін":
                switch (txtFromSpinner2) {
                    case "Цельсій":resultView.setText(String.valueOf(formatter.format(enteredValue-273.15)));break;//here
                    case "Фаренгейт":resultView.setText(String.valueOf(formatter.format((enteredValue-273.15)*NineDivFive +32)));break; //here
                    case "Кельвін":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Ранкін":resultView.setText(String.valueOf(formatter.format(enteredValue * 1.8)));break;
                }
                break;
            case "Ранкін":
                switch (txtFromSpinner2) {
                    case "Цельсій":resultView.setText(String.valueOf(formatter.format((enteredValue-491.67)*FiveDivNine)));break;//here
                    case "Фаренгейт":resultView.setText(String.valueOf(formatter.format(enteredValue-459.67)));break;
                    case "Кельвін":resultView.setText(String.valueOf(formatter.format(enteredValue*(5.0/9.0))));break;
                    case "Ранкін":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
                break;
            case "Фаренгейт":
                switch (txtFromSpinner2) {
                    case "Цельсій":resultView.setText(String.valueOf(formatter.format((enteredValue-32)*(5.0/9.0))));break;
                    case "Фаренгейт":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Кельвін":resultView.setText(String.valueOf(formatter.format((enteredValue-32.00)*(5.0/9.0)+273.15)));break;
                    case "Ранкін":resultView.setText(String.valueOf(formatter.format(enteredValue + 459.67)));break;
                }
            case "Секунди":
                switch (txtFromSpinner2) {
                    case "Секунди": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Хвилини": resultView.setText(String.valueOf(formatter.format(enteredValue*0.0166666667)));break;
                    case "Година": resultView.setText(String.valueOf(formatter.format(enteredValue*0.0002777778)));break;
                    case "День": resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000115741)));break;
                    case "Тиждень": resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000016534)));break;
                    case "Місяц": resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000003805175038)));break;
                    case "Рік": resultView.setText(String.valueOf(formatter.format(enteredValue*0.00000003170979198)));break;
                }
                break;
            case "Хвилини":
                switch (txtFromSpinner2) {
                    case "Секунди": resultView.setText(String.valueOf(formatter.format(enteredValue*60)));break;
                    case "Хвилини": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Година": resultView.setText(String.valueOf(formatter.format(enteredValue*0.0166666667)));break;
                    case "День": resultView.setText(String.valueOf(formatter.format(enteredValue*0.0006944444)));break;
                    case "Тиждень": resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000992063)));break;
                    case "Місяц": resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000228311)));break;
                    case "Рік": resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000019026)));break;
                }
                break;
            case "Година":
                switch (txtFromSpinner2) {
                    case "Секунди": resultView.setText(String.valueOf(formatter.format(enteredValue*3600)));break;
                    case "Хвилини": resultView.setText(String.valueOf(formatter.format(enteredValue*60)));break;
                    case "Година": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "День": resultView.setText(String.valueOf(formatter.format(enteredValue*0.0416666667)));break;
                    case "Тиждень": resultView.setText(String.valueOf(formatter.format(enteredValue*0.005952381)));break;
                    case "Місяц": resultView.setText(String.valueOf(formatter.format(enteredValue*0.001369863)));break;
                    case "Рік": resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001141553)));break;
                }
                break;
            case "День":
                switch (txtFromSpinner2) {
                    case "Секунди": resultView.setText(String.valueOf(formatter.format(enteredValue*604800)));break;
                    case "Хвилини": resultView.setText(String.valueOf(formatter.format(enteredValue*10080)));break;
                    case "Година": resultView.setText(String.valueOf(formatter.format(enteredValue*168)));break;
                    case "День": resultView.setText(String.valueOf(formatter.format(enteredValue*7)));break;
                    case "Тиждень": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Місяц": resultView.setText(String.valueOf(formatter.format(enteredValue*0.23)));break;
                    case "Рік": resultView.setText(String.valueOf(formatter.format(enteredValue*0.19)));break;
                }
                break;
            case "Тиждень":
                switch (txtFromSpinner2) {
                    case "Секунди": resultView.setText(String.valueOf(formatter.format(enteredValue*604800)));break;
                    case "Хвилини": resultView.setText(String.valueOf(formatter.format(enteredValue*10080)));break;
                    case "Година": resultView.setText(String.valueOf(formatter.format(enteredValue*168)));break;
                    case "День": resultView.setText(String.valueOf(formatter.format(enteredValue*7)));break;
                    case "Тиждень": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Місяц": resultView.setText(String.valueOf(formatter.format(enteredValue*0.2301369863)));break;
                    case "Рік": resultView.setText(String.valueOf(formatter.format(enteredValue*0.0191780822)));break;
                }
                break;
            case "Місяц":
                switch (txtFromSpinner2) {
                    case "Секунди": resultView.setText(String.valueOf(formatter.format(enteredValue*2628000)));break;
                    case "Хвилини": resultView.setText(String.valueOf(formatter.format(enteredValue*43800)));break;
                    case "Година": resultView.setText(String.valueOf(formatter.format(enteredValue*730)));break;
                    case "День": resultView.setText(String.valueOf(formatter.format(enteredValue*30.416666667)));break;
                    case "Тиждень": resultView.setText(String.valueOf(formatter.format(enteredValue*4.3452380952)));break;
                    case "Місяц": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Рік": resultView.setText(String.valueOf(formatter.format(enteredValue*0.0833333333)));break;
                }
                break;
            case "Рік":
                switch (txtFromSpinner2) {
                    case "Секунди": resultView.setText(String.valueOf(formatter.format(enteredValue*31536000)));break;
                    case "Хвилини": resultView.setText(String.valueOf(formatter.format(enteredValue*525600)));break;
                    case "Година": resultView.setText(String.valueOf(formatter.format(enteredValue*8760)));break;
                    case "День": resultView.setText(String.valueOf(formatter.format(enteredValue*365)));break;
                    case "Тиждень": resultView.setText(String.valueOf(formatter.format(enteredValue*52.142857143)));break;
                    case "Місяц": resultView.setText(String.valueOf(formatter.format(enteredValue*12)));break;
                    case "Рік": resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
            case "Мілліметр кубічний":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Сантіметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Метр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000001)));break;
                    case "Міллілітр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Літр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Унція рідка":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000351951)));break;
                    case "Джил":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000007039)));break;
                    case "Пінта":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000017598)));break;
                    case "Кварт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000008798769931)));break;
                    case "Галлон":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000002199692482)));break;
                    case "Баррель(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000000006110256897)));break;
                }
                break;
            case "Сантіметр кубічний":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Сантіметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Метр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Міллілітр":resultView.setText(String.valueOf(formatter.format(enteredValue*1)));break;
                    case "Літр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Унція рідка":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0351950797)));break;
                    case "Джил":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0070390159)));break;
                    case "Пінта":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001759754)));break;
                    case "Кварт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000879877)));break;
                    case "Галлон":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0002199692)));break;
                    case "Баррель(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000002199692482)));break;
                }
                break;
            case "Метр кубічний":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0000)));break;
                    case "Сантіметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Метр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Міллілітр":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Літр":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Унція рідка":resultView.setText(String.valueOf(formatter.format(enteredValue*35195.079728)));break;
                    case "Джил":resultView.setText(String.valueOf(formatter.format(enteredValue*7039.0159456)));break;
                    case "Пінта":resultView.setText(String.valueOf(formatter.format(enteredValue*1759.7539864)));break;
                    case "Кварт":resultView.setText(String.valueOf(formatter.format(enteredValue*879.8769932)));break;
                    case "Галлон":resultView.setText(String.valueOf(formatter.format(enteredValue*219.9692483)));break;
                    case "Баррель(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*6.1102568972)));break;
                }
                break;
            case "Міллілітр":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Сантіметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*1)));break;
                    case "Метр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000001)));break;
                    case "Міллілітр":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Літр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Унція рідка":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0351950797)));break;
                    case "Джил":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0070390159)));break;
                    case "Пінта":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001759754)));break;
                    case "Кварт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.000879877)));break;
                    case "Галлон":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0002199692)));break;
                    case "Баррель(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000061103)));break;
                }
                break;
            case "Літр":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*1000000.0)));break;
                    case "Сантіметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Метр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*0.001)));break;
                    case "Міллілітр":resultView.setText(String.valueOf(formatter.format(enteredValue*1000)));break;
                    case "Літр":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Унція рідка":resultView.setText(String.valueOf(formatter.format(enteredValue*35.195079728)));break;
                    case "Джил":resultView.setText(String.valueOf(formatter.format(enteredValue*7.0390159456)));break;
                    case "Пінта":resultView.setText(String.valueOf(formatter.format(enteredValue*1.7597539864)));break;
                    case "Кварт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.8798769932)));break;
                    case "Галлон":resultView.setText(String.valueOf(formatter.format(enteredValue*0.2199692483)));break;
                    case "Баррель(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0061102569)));break;
                }
                break;
            case "Джил":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*142065.3125)));break;
                    case "Сантіметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*142.0653125)));break;
                    case "Метр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001420653)));break;
                    case "Міллілітр":resultView.setText(String.valueOf(formatter.format(enteredValue*142.0653125)));break;
                    case "Літр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.1420653125)));break;
                    case "Унція рідка":resultView.setText(String.valueOf(formatter.format(enteredValue*5)));break;
                    case "Джил":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Пінта":resultView.setText(String.valueOf(formatter.format(enteredValue*0.25)));break;
                    case "Кварт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.125)));break;
                    case "Галлон":resultView.setText(String.valueOf(formatter.format(enteredValue*0.03125)));break;
                    case "Баррель(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0008680556)));break;
                }
                break;
            case "Унція рідка":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*28413.0625)));break;
                    case "Сантіметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*28.4130625)));break;
                    case "Метр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0000284131)));break;
                    case "Міллілітр":resultView.setText(String.valueOf(formatter.format(enteredValue*28.4130625)));break;
                    case "Літр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0284130625)));break;
                    case "Унція рідка":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Джил":resultView.setText(String.valueOf(formatter.format(enteredValue*0.2)));break;
                    case "Пінта":resultView.setText(String.valueOf(formatter.format(enteredValue*0.05)));break;
                    case "Кварт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.025)));break;
                    case "Галлон":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00625)));break;
                    case "Баррель(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0001736111)));break;
                }
                break;
            case "Пінта":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*568261.25)));break;
                    case "Сантіметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*568.26125)));break;
                    case "Метр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0005682613)));break;
                    case "Міллілітр":resultView.setText(String.valueOf(formatter.format(enteredValue*568.26125)));break;
                    case "Літр":resultView.setText(String.valueOf(formatter.format(enteredValue*0.56826125)));break;
                    case "Унція рідка":resultView.setText(String.valueOf(formatter.format(enteredValue*20)));break;
                    case "Джил":resultView.setText(String.valueOf(formatter.format(enteredValue*4)));break;
                    case "Пінта":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Кварт":resultView.setText(String.valueOf(formatter.format(enteredValue*0.5)));break;
                    case "Галлон":resultView.setText(String.valueOf(formatter.format(enteredValue*0.125)));break;
                    case "Баррель(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0034722222)));break;
                }
                break;
            case "Кварт":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*1136522.5)));break;
                    case "Сантіметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*1136.5225)));break;
                    case "Метр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0011365225)));break;
                    case "Міллілітр":resultView.setText(String.valueOf(formatter.format(enteredValue*1136.5225)));break;
                    case "Літр":resultView.setText(String.valueOf(formatter.format(enteredValue*1.1365225)));break;
                    case "Унція рідка":resultView.setText(String.valueOf(formatter.format(enteredValue*40)));break;
                    case "Джил":resultView.setText(String.valueOf(formatter.format(enteredValue*8)));break;
                    case "Пінта":resultView.setText(String.valueOf(formatter.format(enteredValue*2)));break;
                    case "Кварт":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Галлон":resultView.setText(String.valueOf(formatter.format(enteredValue*0.25)));break;
                    case "Баррель(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0069444444)));break;
                }
                break;
            case "Галлон":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*4546090)));break;
                    case "Сантіметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*4546.09)));break;
                    case "Метр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*0.00454609)));break;
                    case "Міллілітр":resultView.setText(String.valueOf(formatter.format(enteredValue*4546.09)));break;
                    case "Літр":resultView.setText(String.valueOf(formatter.format(enteredValue*3.785)));break;
                    case "Унція рідка":resultView.setText(String.valueOf(formatter.format(enteredValue*160)));break;
                    case "Джил":resultView.setText(String.valueOf(formatter.format(enteredValue*32)));break;
                    case "Пінта":resultView.setText(String.valueOf(formatter.format(enteredValue*8)));break;
                    case "Кварт":resultView.setText(String.valueOf(formatter.format(enteredValue*4)));break;
                    case "Галлон":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                    case "Баррель(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue*0.0277777778)));break;
                }
                break;
            case "Баррель(UK)":
                switch (txtFromSpinner2) {
                    case "Мілліметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*163659240)));break;
                    case "Сантіметр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*163659.24)));break;
                    case "Метр кубічний":resultView.setText(String.valueOf(formatter.format(enteredValue*0.16365924)));break;
                    case "Міллілітр":resultView.setText(String.valueOf(formatter.format(enteredValue*4546.09)));break;
                    case "Літр":resultView.setText(String.valueOf(formatter.format(enteredValue*163.65924)));break;
                    case "Унція рідка":resultView.setText(String.valueOf(formatter.format(enteredValue*5760)));break;
                    case "Джил":resultView.setText(String.valueOf(formatter.format(enteredValue*1152)));break;
                    case "Пінта":resultView.setText(String.valueOf(formatter.format(enteredValue*288)));break;
                    case "Кварт":resultView.setText(String.valueOf(formatter.format(enteredValue*144)));break;
                    case "Галлон":resultView.setText(String.valueOf(formatter.format(enteredValue*36)));break;
                    case "Баррель(UK)":resultView.setText(String.valueOf(formatter.format(enteredValue)));break;
                }
                break;
        }
    }

    public static void convertCurrencyData(String txtFromSpinner1,
                                          String txtFromSpinner2 , Double enteredValue, TextView resultView
   , HashMap<String, String> hm ){

        try{
            double initRate = Double.valueOf(hm.get(txtFromSpinner1));
            double targetRate = Double.valueOf(hm.get(txtFromSpinner2));
            String resultFinal = String.valueOf((targetRate * enteredValue) / initRate);
            resultView.setText(resultFinal);
        }
        catch (Exception e){
            Log.d(" Exception","exeption catched") ;
        }
    }


    public static void setUnitsView(String spinnerTextValue,
                                    TextView measurementUnit){
        Resources resources = measurementUnit.getResources();
        switch (spinnerTextValue) {
            case "Milligram":   measurementUnit.setText(resources.getString(R.string.unit_Mg));break;
            case "Gram":   measurementUnit.setText(resources.getString(R.string.unit_G));break;
            case "Kilogram":   measurementUnit.setText(resources.getString(R.string.unit_Kg));break;
            case "Tonne":   measurementUnit.setText(resources.getString(R.string.unit_T));break;
            case "Grain":   measurementUnit.setText(resources.getString(R.string.unit_Gr));break;
            case "Ounce":   measurementUnit.setText(resources.getString(R.string.unit_Oz));break;
            case "Pound":   measurementUnit.setText(resources.getString(R.string.unit_Lb));break;
            case "Hundreweight":   measurementUnit.setText(resources.getString(R.string.unit_Hw));break;
            case "Ton(long)":   measurementUnit.setText(resources.getString(R.string.unit_Tl));break;
            case "Millimetre":   measurementUnit.setText(resources.getString(R.string.unit_Mm));break;
            case "Centimetre":   measurementUnit.setText(resources.getString(R.string.unit_Sm));break;
            case "Metre":   measurementUnit.setText(resources.getString(R.string.unit_M));break;
            case "Kilometre":   measurementUnit.setText(resources.getString(R.string.unit_Km));break;
            case "Inch":   measurementUnit.setText(resources.getString(R.string.unit_In));break;
            case "Foot":   measurementUnit.setText(resources.getString(R.string.unit_Ft));break;
            case "Yard":   measurementUnit.setText(resources.getString(R.string.unit_Yd));break;
            case "Mile":   measurementUnit.setText(resources.getString(R.string.unit_Mi));break;
            case "Celsius":   measurementUnit.setText(resources.getString(R.string.unit_c));break;
            case "Kelvin":   measurementUnit.setText(resources.getString(R.string.unit_k));break;
            case "Rankine":   measurementUnit.setText(resources.getString(R.string.unit_r));break;
            case "Fahrenheit":   measurementUnit.setText(resources.getString(R.string.unit_f));break;
            case "Square millimeter":   measurementUnit.setText(resources.getString(R.string.unit_Mm_Square));break;
            case "Square centimeter":   measurementUnit.setText(resources.getString(R.string.unit_Cm_Square));break;
            case "Square meter":   measurementUnit.setText(resources.getString(R.string.unit_М_Square));break;
            case "Square kilometer":   measurementUnit.setText(resources.getString(R.string.unit_Km_Square));break;
            case "Hectare":   measurementUnit.setText(resources.getString(R.string.unit_Ha));break;
            case "Square mile":   measurementUnit.setText(resources.getString(R.string.unit_Mi_Square));break;
            case "Square yard":   measurementUnit.setText(resources.getString(R.string.unit_Yd_Square));break;
            case "Square feet":   measurementUnit.setText(resources.getString(R.string.unit_Ft_Square));break;
            case "Square inch":   measurementUnit.setText(resources.getString(R.string.unit_In_Square));break;
            case "Acre":   measurementUnit.setText(resources.getString(R.string.unit_Ac));break;
            case "Seconds":measurementUnit.setText(resources.getString(R.string.unit_Seconds));break;
            case "Minutes":measurementUnit.setText(resources.getString(R.string.unit_Minutes));break;
            case "Hour":measurementUnit.setText(resources.getString(R.string.unit_Hour));break;
            case "Day":measurementUnit.setText(resources.getString(R.string.unit_Day));break;
            case "Week":measurementUnit.setText(resources.getString(R.string.unit_Week));break;
            case "Month":measurementUnit.setText(resources.getString(R.string.unit_Month));break;
            case "Year":measurementUnit.setText(resources.getString(R.string.unit_Year));break;
            case "Cubic millimetre":   measurementUnit.setText(resources.getString(R.string.unit_Mm_Cubic));break;
            case "Cubic centimetre":   measurementUnit.setText(resources.getString(R.string.unit_Cm_Cubic));break;
            case "Cubic metre":   measurementUnit.setText(resources.getString(R.string.unit_M_Cubic));break;
            case "Milliliter":   measurementUnit.setText(resources.getString(R.string.unit_Ml));break;
            case "Liter":   measurementUnit.setText(resources.getString(R.string.unit_L));break;
            case "Fluid ounce":   measurementUnit.setText(resources.getString(R.string.unit_Fl_oz));break;
            case "Barrel(UK)":   measurementUnit.setText(resources.getString(R.string.unit_Bbl_uk));break;
            case "Gill":   measurementUnit.setText(resources.getString(R.string.unit_Gi));break;
            case "Pint":   measurementUnit.setText(resources.getString(R.string.unit_Pt));break;
            case "Quart":   measurementUnit.setText(resources.getString(R.string.unit_Qt));break;
            case "Gallon":   measurementUnit.setText(resources.getString(R.string.unit_Gal));break;
            case "Mlilinewton":   measurementUnit.setText(resources.getString(R.string.unit_Mn));break;
            case "Newton":   measurementUnit.setText(resources.getString(R.string.unit_N));break;
            case "Kilonewton":   measurementUnit.setText(resources.getString(R.string.unit_Kn));break;
            case "Ton-force(metric)":   measurementUnit.setText(resources.getString(R.string.unit_Tf));break;
            case "Gram-force":   measurementUnit.setText(resources.getString(R.string.unit_Gf));break;
            case "Kilogram-force":   measurementUnit.setText(resources.getString(R.string.unit_Kgf));break;
            case "Pond":   measurementUnit.setText(resources.getString(R.string.unit_P));break;
            case "Pound-force":   measurementUnit.setText(resources.getString(R.string.unit_Lbf));break;
            case "Ounce-force":   measurementUnit.setText(resources.getString(R.string.unit_Ozf));break;
            case "Ton-force (long)":   measurementUnit.setText(resources.getString(R.string.unit_Tonf));break;
            case "Poundal":   measurementUnit.setText(resources.getString(R.string.unit_Pdl));break;
            case "Meter/second":   measurementUnit.setText(resources.getString(R.string.unit_M_s));break;
            case "Meter/hour":   measurementUnit.setText(resources.getString(R.string.unit_M_h));break;
            case "Kilometer/second":   measurementUnit.setText(resources.getString(R.string.unit_Km_s));break;
            case "Kilometer/hour":   measurementUnit.setText(resources.getString(R.string.unit_Km_h));break;
            case "Foot/second":   measurementUnit.setText(resources.getString(R.string.unit_F_s));break;
            case "Foot/hour":   measurementUnit.setText(resources.getString(R.string.unit_F_h));break;
            case "Mile/hour":   measurementUnit.setText(resources.getString(R.string.unit_Mi));break;
            case "Knot":   measurementUnit.setText(resources.getString(R.string.unit_Kt));break;
            case "United States Dollar":   measurementUnit.setText(resources.getString(R.string.unit_Usd));break;
            case "Great Britain Pound":   measurementUnit.setText(resources.getString(R.string.unit_Gbp));break;
            case "Indonesian rupiah":   measurementUnit.setText(resources.getString(R.string.unit_Ipr));break;
            case "Polish złoty":   measurementUnit.setText(resources.getString(R.string.unit_Pln));break;
            case "New Zealand dollar":   measurementUnit.setText(resources.getString(R.string.unit_Nzd));break;
            case "Russian Ruble":   measurementUnit.setText(resources.getString(R.string.unit_Rub));break;
//Ukrainian locale
            case "Мілліграм":    measurementUnit.setText(resources.getString(R.string.unit_Mg));break;
            case "Грам":    measurementUnit.setText(resources.getString(R.string.unit_G));break;
            case "Кілограм":    measurementUnit.setText(resources.getString(R.string.unit_Kg));break;
            case "Тонна":    measurementUnit.setText(resources.getString(R.string.unit_T));break;
            case "Гран":    measurementUnit.setText(resources.getString(R.string.unit_Gr));break;
            case "Унція":    measurementUnit.setText(resources.getString(R.string.unit_Oz));break;
            case "Фунт":    measurementUnit.setText(resources.getString(R.string.unit_Lb));break;
            case "Хандредвейт":    measurementUnit.setText(resources.getString(R.string.unit_Hw));break;
            case "Тонна(довга)":    measurementUnit.setText(resources.getString(R.string.unit_Tl));break;
            case "Мілліметр":    measurementUnit.setText(resources.getString(R.string.unit_Mm));break;
            case "Сантіметр":    measurementUnit.setText(resources.getString(R.string.unit_Sm));break;
            case "Метр":    measurementUnit.setText(resources.getString(R.string.unit_M));break;
            case "Кілометр":    measurementUnit.setText(resources.getString(R.string.unit_Km));break;
            case "Дюйм":    measurementUnit.setText(resources.getString(R.string.unit_In));break;
            case "Фут":    measurementUnit.setText(resources.getString(R.string.unit_Ft));break;
            case "Ярд":    measurementUnit.setText(resources.getString(R.string.unit_Yd));break;
            case "Міля":    measurementUnit.setText(resources.getString(R.string.unit_Mi));break;
            case "Цельсій":    measurementUnit.setText(resources.getString(R.string.unit_c));break;
            case "Кельвін":    measurementUnit.setText(resources.getString(R.string.unit_k));break;
            case "Ранкін":    measurementUnit.setText(resources.getString(R.string.unit_r));break;
            case "Фаренгейт":    measurementUnit.setText(resources.getString(R.string.unit_f));break;
            case "Мілліметр квадратний":    measurementUnit.setText(resources.getString(R.string.unit_Mm_Square));break;
            case "Сантіметр квадратний":    measurementUnit.setText(resources.getString(R.string.unit_Cm_Square));break;
            case "Метр квадратний":    measurementUnit.setText(resources.getString(R.string.unit_М_Square));break;
            case "Кілометр квадратний":    measurementUnit.setText(resources.getString(R.string.unit_Km_Square));break;
            case "Гектар":    measurementUnit.setText(resources.getString(R.string.unit_Ha));break;
            case "Міля квадратна":    measurementUnit.setText(resources.getString(R.string.unit_Mi_Square));break;
            case "Ярд квадратний":    measurementUnit.setText(resources.getString(R.string.unit_Yd_Square));break;
            case "Фут квадратний":    measurementUnit.setText(resources.getString(R.string.unit_Ft_Square));break;
            case "Дюйм квадратний":    measurementUnit.setText(resources.getString(R.string.unit_In_Square));break;
            case "Акр":    measurementUnit.setText(resources.getString(R.string.unit_Ac));break;
            case "Секунди"  :measurementUnit.setText(resources.getString(R.string.unit_Seconds));break;
            case "Хвилини"  :measurementUnit.setText(resources.getString(R.string.unit_Minutes));break;
            case "Година"  :measurementUnit.setText(resources.getString(R.string.unit_Hour));break;
            case "День"  :measurementUnit.setText(resources.getString(R.string.unit_Day));break;
            case "Тиждень"  :measurementUnit.setText(resources.getString(R.string.unit_Week));break;
            case "Місяц"  :measurementUnit.setText(resources.getString(R.string.unit_Month));break;
            case "Рік"  :measurementUnit.setText(resources.getString(R.string.unit_Year));break;
            case "Мілліметр кубічний":    measurementUnit.setText(resources.getString(R.string.unit_Mm_Cubic));break;
            case "Сантіметр кубічний":    measurementUnit.setText(resources.getString(R.string.unit_Cm_Cubic));break;
            case "Метр кубічний":    measurementUnit.setText(resources.getString(R.string.unit_M_Cubic));break;
            case "Міллілітр":    measurementUnit.setText(resources.getString(R.string.unit_Ml));break;
            case "Літр":    measurementUnit.setText(resources.getString(R.string.unit_L));break;
            case "Унція рідка":    measurementUnit.setText(resources.getString(R.string.unit_Fl_oz));break;
            case "Баррель(UK)":    measurementUnit.setText(resources.getString(R.string.unit_Bbl_uk));break;
            case "Джил":    measurementUnit.setText(resources.getString(R.string.unit_Gi));break;
            case "Пінта":    measurementUnit.setText(resources.getString(R.string.unit_Pt));break;
            case "Кварт":    measurementUnit.setText(resources.getString(R.string.unit_Qt));break;
            case "Галлон":    measurementUnit.setText(resources.getString(R.string.unit_Gal));break;
            case "Мілліньютон":    measurementUnit.setText(resources.getString(R.string.unit_Mn));break;
            case "Ньютон":    measurementUnit.setText(resources.getString(R.string.unit_N));break;
            case "Кілоньютон":    measurementUnit.setText(resources.getString(R.string.unit_Kn));break;
            case "Тонна-сила(метрична)":    measurementUnit.setText(resources.getString(R.string.unit_Tf));break;
            case "Грам-сила":    measurementUnit.setText(resources.getString(R.string.unit_Gf));break;
            case "Кілограм-сила":    measurementUnit.setText(resources.getString(R.string.unit_Kgf));break;
            case "Понд":    measurementUnit.setText(resources.getString(R.string.unit_P));break;
            case "Фунт-сила":    measurementUnit.setText(resources.getString(R.string.unit_Lbf));break;
            case "Унція-сила":    measurementUnit.setText(resources.getString(R.string.unit_Ozf));break;
            case "Тонна-сила(довга)":    measurementUnit.setText(resources.getString(R.string.unit_Tonf));break;
            case "Паундаль":    measurementUnit.setText(resources.getString(R.string.unit_Pdl));break;
            case "Метрів/секунда":    measurementUnit.setText(resources.getString(R.string.unit_M_s));break;
            case "Метрів/година":    measurementUnit.setText(resources.getString(R.string.unit_M_h));break;
            case "Кілометр/секунда":    measurementUnit.setText(resources.getString(R.string.unit_Km_s));break;
            case "Кілометр/година":    measurementUnit.setText(resources.getString(R.string.unit_Km_h));break;
            case "Фут/секунда":    measurementUnit.setText(resources.getString(R.string.unit_F_s));break;
            case "Фут/година":    measurementUnit.setText(resources.getString(R.string.unit_F_h));break;
            case "Міль/година":    measurementUnit.setText(resources.getString(R.string.unit_Mi));break;
            case "Вузол":    measurementUnit.setText(resources.getString(R.string.unit_Kt));break;
            case "Доллар США":    measurementUnit.setText(resources.getString(R.string.unit_Usd));break;
            case "Великобританський фунт":    measurementUnit.setText(resources.getString(R.string.unit_Gbp));break;
            case "Індозенійська Рупія":    measurementUnit.setText(resources.getString(R.string.unit_Ipr));break;
            case "Польский Злотий":    measurementUnit.setText(resources.getString(R.string.unit_Pln));break;
            case "Доллар НЗ":    measurementUnit.setText(resources.getString(R.string.unit_Nzd));break;
            case "Рубль":    measurementUnit.setText(resources.getString(R.string.unit_Rub));break;

        }
    }
}

