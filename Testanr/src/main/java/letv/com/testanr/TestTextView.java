/**
 *
 */

package letv.com.testanr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class TestTextView extends TextView {
    private static final String TAG = "Touch_TestTextView";

    /**
     * @param context
     * @param attrs
     */
    public TestTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver
                .OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
//                Log.d(TAG, "onGlobalLayout: w=" + getWidth() + " h=" + getHeight() + " this=" +
//                        getViewTreeObserver());
            }
        });
        // LayoutInflater factory = LayoutInflater.from(context);
        // RelativeLayout relativeLayout = (RelativeLayout) factory.inflate(
        // R.layout.ad_view_merge, this, true);
        // // ViewGroup viewGroup = (ViewGroup) inflate(context,
        // R.layout.ad_view,
        // // this);
        // ImageView imageView = new ImageView(context);
        // imageView.setId(11111);
        // imageView.setScaleType(ScaleType.FIT_XY);
        // imageView.setImageResource(R.drawable.a);
        // RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
        // LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        // relativeLayout.addView(imageView, 0, params);
        // relativeLayout.setBackgroundColor(Color.RED);
        // addView(relativeLayout);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasWindowFocus);
//        Log.d(TAG, "onWindowFocusChanged hasWindowFocus=" + hasWindowFocus);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        // TODO Auto-generated method stub
        super.onWindowVisibilityChanged(visibility);
//        Log.d(TAG, "onWindowVisibilityChanged visibility=" + visibility);
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
//        Log.d(TAG, "onVisibilityChanged visibility=" + visibility + "  changedView=" +
// changedView);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void onHoverChanged(boolean hovered) {
        super.onHoverChanged(hovered);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "TestTextView onTouchEvent action=" + event.getAction());
        boolean handle = super.onTouchEvent(event);
        updateSelection(event, (Spannable) mStaticLayout.getText(), mStaticLayout);
//        if (MotionEvent.ACTION_UP == event.getAction()) {
////            setScaleX((float) 3.0);
////            setScaleY((float) 3.0);
//            setVisibility(VISIBLE);
//        } else {
//            setVisibility(GONE);
////            setScaleX((float) 3.0);
////            setScaleY((float) 3.0);
//        }
////        invalidate();
        Log.d(TAG, "TestTextView onTouchEvent  handle=" + handle);
        return handle;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "TestTextView dispatchTouchEvent action=" + ev.getAction());
        boolean handle = super.dispatchTouchEvent(ev);
        Log.d(TAG, "TestTextView dispatchTouchEvent  handle=" + handle);
        return handle;
    }

    StaticLayout mStaticLayout;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.aa);
//        Drawable drawable = getResources().getDrawable(R.drawable.progress_btn_bg, null);
//        final Bitmap b = Bitmap.createBitmap(getWidth(),
//                getHeight(), Bitmap.Config.ARGB_8888);
//        Canvas canvas1 = new Canvas(b);
//        drawable.setBounds(0, 0, getWidth() + 0, getHeight());
//        drawable.draw(canvas1);
//        drawable.setBounds(0, 0, 200 + 0, getHeight());
//        canvas1.drawARGB(255, 255, 255, 0);
//        canvas.drawColor(Color.RED, PorterDuff.Mode.CLEAR);
//        canvas.scale(0.5f, 0.5f);
//        canvas.rotate(80);
//        canvas.translate(80,90);
//        canvas.clipRect(new Rect(0, 0, 100, 300));
//        canvas.translate(50, 0);
//        original.recycle();
//        /***********配置画笔*************/
//        Paint paint = new Paint();    //采用默认设置创建一个画笔
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//        paint.setAntiAlias(true);//使用抗锯齿功能
//        paint.setColor(0xFFA4C739);    //设置画笔的颜色为绿色
//        paint.setStyle(Paint.Style.FILL);//设置画笔类型为填充
//        LinearGradient gradient = new LinearGradient(0, 0, getMeasuredWidth(), 0, new
//                int[]{0x3fffffff, 0x8fffffff}, null,
//                Shader.TileMode.CLAMP);
////        canvas1.drawBitmap(original, 0, 0, paint);
////        GradientDrawable d = new GradientDrawable()
//        paint.setShader(gradient);
//        RectF rectf_head = new RectF(0, 0, 400, 400);//确定外切矩形范围
////        rectf_head.offset(100, 20);//使rectf_head所确定的矩形向右偏移100像素，向下偏移20像素
//        canvas.drawRoundRect(rectf_head, -90, 40, true, paint);//绘制圆弧，不含圆心
        /***********绘制圆弧*************/
//        RectF rectf_head = new RectF(150, 150, 400, 400);//确定外切矩形范围
////        rectf_head.offset(100, 20);//使rectf_head所确定的矩形向右偏移100像素，向下偏移20像素
//        canvas.drawArc(rectf_head, -90, 40, true, paint);//绘制圆弧，不含圆心
//        canvas.drawBitmap(b, new Rect(0, 0, 200, getHeight()) , null, null);
//        canvas.drawBitmap(b, new Rect(0, 0, 0, getHeight()), new Rect(0, 0, 0,
//                        getHeight()),
//                null);
//        drawable.draw(canvas);
//        Drawable drawable = getResources().getDrawable(R.drawable.progress_btn_bg,null);
//        canvas.drawRect(new Rect(0, 0, 800, 800), paint);
//        String termOfUse = getResources().getString(R.string.terms_of_use);
//        String privacyStr = getResources().getString(R.string.privacy_text);
//        SpannableString content = new SpannableString(getResources().getString(R.string
//                .europe_policy_description, termOfUse, privacyStr));
//        ClickableSpan clickableSpan = new ClickableSpan() {
//            @Override
//            public void onClick(View widget) {
//                Log.d(TAG, "onClick: 0000");
//            }
//        };
//        ClickableSpan clickableSpan1 = new ClickableSpan() {
//            @Override
//            public void onClick(View widget) {
//                Log.d(TAG, "onClick: 1111");
//            }
//        };
//        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
//        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#0099EE"));
//        int termIndex = content.toString().indexOf(termOfUse);
//        int privacyIndex = content.toString().indexOf(privacyStr);
//        content.setSpan(clickableSpan, termIndex, termIndex + termOfUse.length(), Spanned
//                .SPAN_INCLUSIVE_INCLUSIVE);
//        content.setSpan(clickableSpan1, privacyIndex, privacyIndex + privacyStr.length(), Spanned
//                .SPAN_INCLUSIVE_INCLUSIVE);
//        content.setSpan(colorSpan, termIndex, termIndex + termOfUse.length(), Spanned
//                .SPAN_INCLUSIVE_INCLUSIVE);
//        content.setSpan(colorSpan1, privacyIndex, privacyIndex + privacyStr.length(), Spanned
//                .SPAN_INCLUSIVE_INCLUSIVE);
//        TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
//        textPaint.setTextSize(45);
//        textPaint.setColor(Color.WHITE);
//        mStaticLayout = new StaticLayout(content, textPaint, 700,
//                Layout.Alignment.ALIGN_NORMAL, 1F, 0, false);
//        Log.d(TAG, "onDraw: height=" + mStaticLayout.getHeight() + " width=" + mStaticLayout
//                .getWidth());
//        canvas.save();
//        canvas.translate(100, 100);
//        mStaticLayout.draw(canvas);
//        Log.d(TAG, "onDraw: height=" + mStaticLayout.getHeight());
//        canvas.restore();
//        canvas.translate(0, 100);
//        mStaticLayout.draw(canvas);
//        canvas.translate(0, 400);
//        mStaticLayout.draw(canvas);
//        SpannableString spannableString = new SpannableString("设置文字的前景色为淡蓝色");
//        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
//        spannableString.setSpan(colorSpan, 9, spannableString.length(), Spanned
// .SPAN_INCLUSIVE_INCLUSIVE);
//        setText(spannableString);
    }

    private boolean updateSelection(MotionEvent event, Spannable buffer, Layout layout) {
        int action = event.getAction();

        if (action == MotionEvent.ACTION_UP ||
                action == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();
//
            x -= getPaddingLeft();
            y -= getPaddingTop();

            x += getScrollX();
            y += getScrollY();
            x -= 100;
            y -= 100;
            int line = layout.getLineForVertical(y);
            int off = layout.getOffsetForHorizontal(line, x);
            Log.d(TAG, "updateSelection: off=" + off + "  line=" + line);
            ClickableSpan[] link = buffer.getSpans(off, off, ClickableSpan.class);
            Log.d(TAG, "updateSelection: link.length=" + link.length);
            if (link.length != 0) {
                if (action == MotionEvent.ACTION_UP) {
                    link[0].onClick(this);
                } else {
                    Selection.setSelection(buffer,
                            buffer.getSpanStart(link[0]),
                            buffer.getSpanEnd(link[0]));
                }

                return true;
            } else {
                Selection.removeSelection(buffer);
            }
        }

        return false;
    }
}
