package ashunevich.uniconverter20;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends DialogFragment {

    @BindView(R.id.calc_Info)
    TextView calc;
    @BindView(R.id.api_info)
    TextView api;
    @BindView(R.id.version_Info)
    TextView versionInfo;

    public DialogActivity (){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @NonNull
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle(getResources().getString(R.string.about));
        View view = inflater.inflate(R.layout.custom_dialog_layout, container, false);
        ButterKnife.bind(this, view);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.AppThemeDefaultNoBar);
        setVersion();
        setLinks();
        return view;

    }


    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }

    private void setLinks(){
        String math_text = "<a href='http://mathparser.org/'> MathParser </a>";
        calc.setText(Html.fromHtml(math_text));
        calc.setClickable(true);
        calc.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://openrates.io/'> Openrate.io </a>";
        api.setText(Html.fromHtml(text));
        api.setClickable(true);
        api.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void setVersion(){
      String versionNAme = BuildConfig.VERSION_NAME;
      versionInfo.setText(versionNAme);
    }

    @OnClick({R.id.ok_button})
    public void setViewOnClickEvent(View view) {
        switch (view.getId()) {
            case R.id.ok_button:
               dismiss();
                break;
        }
    }
}

