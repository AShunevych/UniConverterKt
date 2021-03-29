package ashunevich.uniconverter20;


import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public abstract class Utils {

     static final String TAG = "ERROR-" ;

    static String PREFERENCE_NAME ="APP_PREF";
    static final String HASH_MAP="HashMAP";
    static final String SAVED_VALUE = "savedValue";
    static final String SAVED_RESULT = "saveResult";
    static final String SAVED_DATE = "saveDate";


     static void blockInput( EditText resultView, EditText valueEdit){
        resultView.setInputType(InputType.TYPE_NULL);
        valueEdit.setInputType(InputType.TYPE_NULL);
    }

     static void clearView (EditText valueEdit,TextView resultView){
        resultView.setText("");
        valueEdit.setText("");
    }


     static String getSpinnerValueString(Spinner spinner){
        return spinner.getSelectedItem().toString();
    }

     static void readAndSolve (EditText valueEdit, TextView resultView){
        if (TextUtils.isEmpty(valueEdit.getText().toString())) {
            resultView.setText("");
        }
         else {
            String getValue = valueEdit.getText().toString();
            Expression value = new Expression(getValue);
            String getResult = Double.toString(value.calculate());
            resultView.setText(getResult);
        }
    }

     static void checkBrackets (EditText valueEdit){
        if (valueEdit.getText().toString().contains("(")){
            valueEdit.append(")");
        }
        else{
            valueEdit.append("(");
        }
    }

    @SuppressLint("SetTextI18n")
     static void appendMinusPlus(EditText valueEdit){
      int x = valueEdit.getText().length();
       if (x != 15 | valueEdit.getText().toString().contains("-")){
            StringBuilder sb = new StringBuilder();
            if (valueEdit.getText().toString().contains("-")) {
                sb.append(valueEdit.getText().toString());
                sb.deleteCharAt(0);
                valueEdit.setText(sb.toString());
            }
            else {
                valueEdit.setText("-"+valueEdit.getText());
            }
        }
    }

     static void correctValue(EditText valueEdit, TextView resultEdit){
        int x = valueEdit.getText().length();
        if (x >0) {
            valueEdit.setText(removeLastChar(valueEdit.getText().toString()));
        }
        else{
            Log.d(TAG,"INVALID INPUT");
            clearView(valueEdit,resultEdit);
        }
    }

     static String removeLastChar(String str) {
        return removeLastChars(str);
    }

     static String removeLastChars(String str) {
        return str.substring(0, str.length() - 1);
    }

     static void measurementUnitsHandler(String spinnerTextValue,
                                               TextView measurementUnit){
        Resources resources = measurementUnit.getResources();
        switch (spinnerTextValue) {
            case "Milligram":
            case "Міліграм":
                measurementUnit.setText(resources.getString(R.string.unit_Mg));break;
            case "Gram":   measurementUnit.setText(resources.getString(R.string.unit_G));break;
            case "Kilogram":   measurementUnit.setText(resources.getString(R.string.unit_Kg));break;
            case "Tonne":   measurementUnit.setText(resources.getString(R.string.unit_T));break;
            case "Grain":   measurementUnit.setText(resources.getString(R.string.unit_Gr));break;
            case "Ounce":   measurementUnit.setText(resources.getString(R.string.unit_Oz));break;
            case "Pound":   measurementUnit.setText(resources.getString(R.string.unit_Lb));break;
            case "Hundredweight":   measurementUnit.setText(resources.getString(R.string.unit_Hw));break;
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
            case "Грам":    measurementUnit.setText(resources.getString(R.string.unit_G));break;
            case "Кілограм":    measurementUnit.setText(resources.getString(R.string.unit_Kg));break;
            case "Тонна":    measurementUnit.setText(resources.getString(R.string.unit_T));break;
            case "Гран":    measurementUnit.setText(resources.getString(R.string.unit_Gr));break;
            case "Унція":    measurementUnit.setText(resources.getString(R.string.unit_Oz));break;
            case "Фунт":    measurementUnit.setText(resources.getString(R.string.unit_Lb));break;
            case "Хандредвейт":    measurementUnit.setText(resources.getString(R.string.unit_Hw));break;
            case "Тонна(довга)":    measurementUnit.setText(resources.getString(R.string.unit_Tl));break;
            case "Міліметр":    measurementUnit.setText(resources.getString(R.string.unit_Mm));break;
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
            case "Міліметр квадратний":    measurementUnit.setText(resources.getString(R.string.unit_Mm_Square));break;
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
            case "Міліметр кубічний":    measurementUnit.setText(resources.getString(R.string.unit_Mm_Cubic));break;
            case "Сантіметр кубічний":    measurementUnit.setText(resources.getString(R.string.unit_Cm_Cubic));break;
            case "Метр кубічний":    measurementUnit.setText(resources.getString(R.string.unit_M_Cubic));break;
            case "Мілілітр":    measurementUnit.setText(resources.getString(R.string.unit_Ml));break;
            case "Літр":    measurementUnit.setText(resources.getString(R.string.unit_L));break;
            case "Унція рідка":    measurementUnit.setText(resources.getString(R.string.unit_Fl_oz));break;
            case "Баррель(UK)":    measurementUnit.setText(resources.getString(R.string.unit_Bbl_uk));break;
            case "Джил":    measurementUnit.setText(resources.getString(R.string.unit_Gi));break;
            case "Пінта":    measurementUnit.setText(resources.getString(R.string.unit_Pt));break;
            case "Кварт":    measurementUnit.setText(resources.getString(R.string.unit_Qt));break;
            case "Галлон":    measurementUnit.setText(resources.getString(R.string.unit_Gal));break;
            case "Міліньютон ":    measurementUnit.setText(resources.getString(R.string.unit_Mn));break;
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
        }
    }

    static void currencyUnitHandler(String spinnerTextValue,
                                        TextView measurementUnit) {
        Resources resources = measurementUnit.getResources ();
        switch (spinnerTextValue) {
            case "United States Dollar":
            case "Доллар США":
                measurementUnit.setText (resources.getString (R.string.unit_Usd));
                break;
            case "Great Britain Pound":
            case "Великобританський фунт":
                measurementUnit.setText (resources.getString (R.string.unit_Gbp));
                break;
            case "Indonesian rupiah":
            case "Індозенійська Рупія":
                measurementUnit.setText (resources.getString (R.string.unit_Ipr));
                break;
            case "Polish złoty":
            case "Польский Злотий":
                measurementUnit.setText (resources.getString (R.string.unit_Pln));
                break;
            case "New Zealand dollar":
            case "Доллар НЗ":
                measurementUnit.setText (resources.getString (R.string.unit_Nzd));
                break;
            case "Russian Ruble":
            case "Рубль":
                measurementUnit.setText (resources.getString (R.string.unit_Rub));
                break;
        }
    }

     static Double currencyConverter(Double value,Double targetRate, Double initRate ){
        return ((targetRate * value) / initRate);
    }

     static String returnDateString(TextView dateTextView){return dateTextView.getText().toString();}



}

