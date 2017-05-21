package bwie.com.mytextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.icu.util.Measure;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by $USER_NAME on 2017/5/16.
 */

public class Mytextview extends TextView {
    private String mText ;
    private int mTextColor;
    private int mTextSize;
    /**
     * 画笔,文本绘制范围
     */
    private Rect mBound;
    private Paint mPaint;
    public Mytextview(Context context) {
        this(context,null);
    }

    public Mytextview(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Mytextview(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public Mytextview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.Mytextview);
        mText = a.getString(R.styleable.Mytextview_text);
        mTextSize = a.getDimensionPixelSize(R.styleable.Mytextview_textsize, 20);
        mTextColor = a.getColor(R.styleable.Mytextview_textcolor, Color.BLACK);
        a.recycle();

        mBound = new Rect();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(mTextSize);
        mPaint.getTextBounds(mText, 0, mText.length(), mBound);


    }
    int viewWidth ;
    int viewHeight ;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode =   MeasureSpec.getMode(widthMeasureSpec);
        int heightMode =  MeasureSpec.getMode(heightMeasureSpec) ;
        int width =  MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        if(widthMode == MeasureSpec.EXACTLY){
            viewWidth = width ;
        } else {
            //计算出来内容的宽度 :  文件的宽度 ＋ 左右内间距
            viewWidth = mBound.width() + getPaddingLeft() + getPaddingRight() ;
        }

        if(heightMode == MeasureSpec.EXACTLY){
            viewHeight = height ;
        } else {
            Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();

            viewHeight = (int) Math.abs((fontMetrics.bottom - fontMetrics.top)) + getPaddingTop() + getPaddingBottom();
        }

        //设置当前view的尺寸
        setMeasuredDimension(viewWidth,viewHeight);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//               mPaint.setColor(Color.BLUE);
//        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);

        mPaint.setColor(mTextColor);
//        canvas.drawText(text,0,text.length(),viewWidth/2,viewHeight/2,mPaint);

//        getWidth() / 2 - mBound.width() / 2
        canvas.drawText(mText, 0, getHeight() / 2 + mBound.height() / 2, mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
        // 中线,做对比
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, mPaint);
    }
}
