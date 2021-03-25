package ashunevich.uniconverter20;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class DatePojo {
    @SerializedName("date")
    String date;


    public DatePojo(double rates, String date){
        this.date = date;
    }






}
