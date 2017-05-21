package bwie.com.mytextview.City;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by $USER_NAME on 2017/5/18.
 */

public class MyGridview extends GridView {
    public MyGridview(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyGridview(Context context) {
        this(context,null);
    }

    public MyGridview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /*int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);*/
    }
}
