package ashunevich.uniconverter20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class info extends AppCompatActivity {

    @BindView(R.id.api_url)
    TextView apiURl;
    @BindView(R.id.calc_url)
    TextView calcURl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);

        final String API_URL = "<a href=\"http://www.openrates.io/\">OpenRates.io</a>";
        final String CALC_URL = "<a href=\"http://mathparser.org/\">MathParser</a>";

        apiURl.setText(Html.fromHtml(API_URL));
        calcURl.setText(Html.fromHtml(CALC_URL));
        apiURl.setMovementMethod(LinkMovementMethod.getInstance());
        calcURl.setMovementMethod(LinkMovementMethod.getInstance());
    }


}

