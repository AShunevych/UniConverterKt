package ashunevich.uniconverter20;


import android.widget.TextView;

public abstract class SphereAdapter_ukr extends SphereActivity {
    private static final Double PI = Math.PI;

    public SphereAdapter_ukr(TextView circleArea, TextView circleDiameter, TextView circleCirc, TextView circleRad, TextView sphereArea, TextView sphereVolume,
                             TextView hemiArea, TextView hemiVolume){
        this.circleArea = circleArea;
        this.circleDiameter = circleDiameter;
        this.circleCirc = circleCirc;
        this.circleRad = circleRad;
        this.sphereArea = sphereArea;
        this.sphereVolume = sphereVolume;
        this.hemiArea = hemiArea;
        this.hemiVolume = hemiVolume;
}

    public static void findParam (Double enteredvalue, String spinnerValue,TextView circleArea,
                            TextView circleDiameter, TextView circleCirc,
                            TextView circleRad,TextView sphereArea,TextView sphereVolume,
                            TextView hemiArea, TextView hemiVolume ) {

        double radDiam = enteredvalue/2;
        double radCirc = enteredvalue/(2*PI);
        double radArea = Math.sqrt(enteredvalue/PI);
        double radSphArea = Math.sqrt(enteredvalue/4*PI);
        double radSphVolume = Math.pow(((enteredvalue/PI)*(3.0/4.0)),1.0/3.0);

        switch (spinnerValue){
            case "Радіус":
                circleRad.setText
                        (String.valueOf(enteredvalue)); //radius
                circleDiameter.setText(
                        String.valueOf(enteredvalue*2)); //diameter
                circleCirc.setText
                        (String.valueOf(2*PI*enteredvalue));  // circumsference
                circleArea.setText
                        (String.valueOf(PI*Math.pow(enteredvalue,2))); // area
                sphereArea.setText
                        (String.valueOf(4*PI*Math.pow(enteredvalue,2))); // sphere area
                sphereVolume.setText
                        (String.valueOf((4.0/3.0) * PI * Math.pow( enteredvalue, 3 ))); //sphere volume
                hemiArea.setText
                        (String.valueOf(2.0*PI* Math.pow(enteredvalue,2))); // hemi sphere area
                hemiVolume.setText
                        (String.valueOf((2.0/3.0) * PI * Math.pow( enteredvalue, 3 )));// hemi sphere volume
                break; //+
            case "Діаметер":
                circleRad.setText
                        (String.valueOf(radDiam));
                circleDiameter.setText
                        (String.valueOf(enteredvalue));
                circleCirc.setText
                        (String.valueOf(2*PI*radDiam));  // circumsference
                circleArea.setText
                        (String.valueOf(PI*Math.pow(radDiam,2))); // area
                sphereArea.setText
                        (String.valueOf(4*PI*Math.pow(radDiam,2))); // sphere area
                sphereVolume.setText
                        (String.valueOf((4.0/3.0) * PI * Math.pow( radDiam, 3 ))); //sphere volume
                hemiArea.setText
                        (String.valueOf(2.0*PI* Math.pow(radDiam,2))); // hemi sphere area
                hemiVolume.setText
                        (String.valueOf((2.0/3.0) * PI * Math.pow( radDiam, 3 )));// hemi sphere volume
                break; //+
            case "Окружність":
                circleRad.setText
                        (String.valueOf(radCirc));
                circleDiameter.setText
                        (String.valueOf(radCirc*2));
                circleCirc.setText
                        (String.valueOf(enteredvalue));  // circumsference
                circleArea.setText
                        (String.valueOf(PI*Math.pow(radCirc,2))); // area
                sphereArea.setText
                        (String.valueOf(4*PI*Math.pow(radCirc,2))); // sphere area
                sphereVolume.setText
                        (String.valueOf((4.0/3.0) * PI * Math.pow( radCirc, 3 ))); //sphere volume
                hemiArea.setText
                        (String.valueOf(2.0*PI* Math.pow(radCirc,2))); //Curved surface area of hemisphere
                hemiVolume.setText
                        (String.valueOf((2.0/3.0) * PI * Math.pow( radCirc, 3 )));// hemi sphere volume
                break; //+
            case "Площа":
                circleRad.setText
                        (String.valueOf(radArea));
                circleDiameter.setText
                        (String.valueOf(radArea*2));
                circleArea.setText
                        (String.valueOf(enteredvalue));
                circleCirc.setText
                        (String.valueOf(2*PI*radArea));
                sphereArea.setText
                        (String.valueOf(4*PI*Math.pow(radArea,2)));
                sphereVolume.setText
                        (String.valueOf((4.0/3.0) * PI * Math.pow( radArea, 3 )));
                hemiArea.setText
                        (String.valueOf(2.0*PI* Math.pow(radArea,2))); // Curved surface area of hemisphere
                hemiVolume.setText
                        (String.valueOf((2.0/3.0) * PI * Math.pow( radArea, 3 )));
                break;
            case "Площа сфери":
                circleRad.setText
                        (String.valueOf(radSphArea));
                circleDiameter.setText
                        (String.valueOf(radSphArea*2));
                circleArea.setText
                        (String.valueOf(PI*Math.pow(radSphArea,2))); // area
                circleCirc.setText
                        (String.valueOf(2*PI*radSphArea));
                sphereArea.setText
                        (String.valueOf(enteredvalue));
                sphereVolume.setText
                        (String.valueOf((4.0/3.0) * PI * Math.pow( radSphArea, 3 )));
                hemiArea.setText
                        (String.valueOf(2.0*PI* Math.pow(radSphArea,2)));//Curved surface area of hemisphere
                hemiVolume.setText
                        (String.valueOf((2.0/3.0) * PI * Math.pow( radSphArea, 3 )));
                break;
            case "Об\\'єм cфери":
                circleRad.setText
                        (String.valueOf(radSphVolume));
                circleDiameter.setText
                        (String.valueOf(radSphVolume*2));
                circleArea.setText
                        (String.valueOf(PI*Math.pow(radSphVolume,2))); // area
                circleCirc.setText
                        (String.valueOf(2*PI*radSphVolume));
                sphereArea.setText
                        (String.valueOf(4*PI*Math.pow(radSphVolume,2)));
                sphereVolume.setText
                        (String.valueOf(enteredvalue));
                hemiArea.setText
                        (String.valueOf(2.0*PI* Math.pow(radSphVolume,2)));//Curved surface area of hemisphere
                hemiVolume.setText
                        (String.valueOf((2.0/3.0) * PI * Math.pow( radSphVolume, 3 )));
                break;
        }
        }

    }



