package ashunevich.uniconverter20;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class SharedPreferenceManager {
    protected Context mContext;
    protected SharedPreferences mSettings;
    protected SharedPreferences.Editor mEditor;

    @SuppressLint("CommitPrefEdits")
    public SharedPreferenceManager(Context ctx, String prefFileName) {
        mContext = ctx;
        mSettings = mContext.getSharedPreferences(prefFileName,
                Context.MODE_PRIVATE);
        mEditor = mSettings.edit();
    }

    public void setValue(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    public String getValue(String key, String defaultValue) {
        return mSettings.getString(key, defaultValue);
    }

    public HashMap<String,String> getHashMap(String key){
        Type typeOfHashMap = new TypeToken<HashMap<String, String>>() { }.getType();
        String JSONHash = mSettings.getString(key,"");
        return new Gson().fromJson(JSONHash, typeOfHashMap);
    }


}
