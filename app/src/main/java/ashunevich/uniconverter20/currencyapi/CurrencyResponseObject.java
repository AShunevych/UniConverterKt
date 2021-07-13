package ashunevich.uniconverter20.currencyapi;

import com.google.gson.annotations.SerializedName;


public class CurrencyResponseObject {
    @SerializedName("date")
    String date;

    @SerializedName ("rates")
    CurrencyRateObject object;

    protected CurrencyResponseObject(CurrencyRateObject object, String date){
        this.object =object;
        this.date = date;
    }

}


class CurrencyRateObject{
    @SerializedName ("USD")
     double USD;
    @SerializedName ("GBP")
     double GBP;
    @SerializedName ("IDR")
     double IDR;
    @SerializedName ("PLN")
     double PLN;
    @SerializedName ("RUB")
     double RUB;

    protected double getRate(String currency ){
       switch (currency){
           case "USD": return USD;
           case "GBP": return GBP;
           case "IDR": return IDR;
           case "PLN": return PLN;
           case "RUB": return RUB;
           default:return 0.0;
       }
    }

}