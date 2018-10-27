package example.com.testui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import android.util.Log;

/**
 * Created by chengjian on 18-10-10.
 */

/**
 * 设置不同形状的文字背景
 */
public class CircleBackGroundColorSpan extends ReplacementSpan {
    private int bgColor;
    private int textColor;
    private float shapePadding;

    public CircleBackGroundColorSpan(int bgColor, int textColor, float padding) {
        super();
        this.bgColor = bgColor;
        this.textColor = textColor;
        this.shapePadding = padding;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt
            fm) {
        return ((int) paint.measureText(text, start, end)) + 40;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int
            y, int bottom, Paint paint) {
        Log.d("chengjian_span", "draw: x=" + x + " y=" + y + " top=" + top + " bottom=" + bottom);
        int color1 = paint.getColor();
        paint.setColor(this.bgColor);
        float textHeight = (int) getFontHeight(paint);
        float textWidth = (int) paint.measureText(text, start, end);
        float radius = Math.max(textHeight, textWidth) + shapePadding * 2;
        canvas.drawCircle((x + textWidth) / 2, (bottom - top) / 2 + top + textHeight / 2, radius
                / 2, paint);
        paint.setColor(this.textColor);
        canvas.drawText(text, start, end, x + 20, y, paint);
    }

    public float getFontHeight(Paint paint) {
        Paint.FontMetrics fm = paint.getFontMetrics();
        return (fm.descent - fm.ascent) + 0.5f;
    }
}