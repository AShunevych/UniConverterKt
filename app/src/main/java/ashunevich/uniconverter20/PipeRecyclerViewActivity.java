package ashunevich.uniconverter20;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PipeRecyclerViewActivity extends AppCompatActivity {

    String TAG = PipeRecyclerViewActivity.class.getSimpleName();
    private String LOCALE;
    private ArrayList<PipeRecyclerViewItem> listContentArr = new ArrayList<>();
    PipeRecyclerViewItem item = new PipeRecyclerViewItem();
    PipeRecyclerViewAdapter adapter;

    @BindView(R.id.pipeView)
    RecyclerView recyclerView;

    @BindView(R.id.exitButtonNPS)
    ImageButton exit_button;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.pipe_size_activity);
        LOCALE = Locale.getDefault().getDisplayLanguage();
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PipeRecyclerViewAdapter(listContentArr);
        recyclerView.setHasFixedSize(true);
        buildRecyclerWithJson();

        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        super.onCreate(savedInstanceState);
    }

    private void buildRecyclerWithJson(){
        if(LOCALE.equals("русский")){
            loadJsonToRecycler("pipeChar.json");
        }
        else{
            loadJsonToRecycler("pipeChar.json");
        }
    }


    private void loadJsonToRecycler(String loadJSON)  {
        try {
            JSONObject jsonObject = new JSONObject(loadJsonEvent(loadJSON));
            JSONArray message = jsonObject.getJSONArray("PipeConversion");
            Gson gson =new Gson();
            for (int i = 0; i <= message.length(); i++) {
                JSONObject temp =message.getJSONObject(i);
                item = gson.fromJson(temp.toString(), PipeRecyclerViewItem.class);
                listContentArr.add(item);
                adapter.notifyDataSetChanged();
                adapter.setListContent(listContentArr);
                recyclerView.setAdapter(adapter);
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        }


    }

    public String loadJsonEvent(String jsonName) {
        String json = null;
        try {
            InputStream inputStream = getApplicationContext().getAssets().open(jsonName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }


}
