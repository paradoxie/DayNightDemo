package cf.paradoxie.daynightdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEditText;
    private String[] tipsArray;
    private Button btnDay, btnNight, btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mEditText = (EditText) findViewById(R.id.et_main);
        mEditText.setHint(getRandomWelcomeTips());
        btnDay = (Button) findViewById(R.id.btn_day);
        btnDay.setOnClickListener(this);
        btnNight = (Button) findViewById(R.id.btn_night);
        btnNight.setOnClickListener(this);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    //随机hint
    private String getRandomWelcomeTips() {
        String welcome_tip = null;
        tipsArray = this.getResources().getStringArray(R.array.tips);
        int index = (int) (Math.random() * (tipsArray.length - 1));
        welcome_tip = tipsArray[index];
        return welcome_tip;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_day:
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);//切换夜间模式
                recreate();
                break;
            case R.id.btn_night:
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);//切换日间模式
                recreate();
                break;
            case R.id.btn:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
            default:
                break;

        }
    }
}
