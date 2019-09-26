package ashunevich.uniconverter20;

import com.google.gson.annotations.SerializedName;

public class PipeRecyclerViewItem {

    @SerializedName("inch")
    private String inch;
    @SerializedName("mm")
    private String mm;


    public String getInch() {
        return inch;
    }

    public String getMm() {
        return mm;
    }

    public String getDim() {
        return dim;
    }

    @SerializedName("dim")
    private String dim;


    public PipeRecyclerViewItem() {

    }



}
