package bwie.com.mytextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MyEditText et;
    private ABCDEFG_____ abc;
    private TextView dialog;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
//        mEtCityName = (EditTextWithDel) findViewById(R.id.et_search);
//        sideBar = (SideBar) findViewById(R.id.sidrbar);
//        dialog = (TextView) findViewById(R.id.dialog);
//        mTvTitle = (TextView) findViewById(R.id.tv_title);
//        sortListView = (ListView) findViewById(R.id.country_lvcountry);
        et = (MyEditText) findViewById(R.id.et);
        abc = (ABCDEFG_____) findViewById(R.id.abc);
        dialog = (TextView) findViewById(R.id.dialog);
        listView = (ListView) findViewById(R.id.lv);

        abc.setTextView(dialog);

    }
    private void initEvents() {
        //设置右侧触摸监听
     /*   abc.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    listView.setSelection(position + 1);
                }
            }
        });*/
    }
}
