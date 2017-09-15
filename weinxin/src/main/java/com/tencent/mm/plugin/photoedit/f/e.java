package com.tencent.mm.plugin.photoedit.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class e
  extends c
{
  private static TextPaint gm;
  private static final float olb;
  private static final int olc;
  private static final int old;
  public SpannableString ole;
  public int sl;
  
  static
  {
    GMTrace.i(9917750575104L, 73893);
    olb = aa.getResources().getDimension(R.f.aZx);
    olc = (int)aa.getResources().getDimension(R.f.bak);
    old = (int)aa.getResources().getDimension(R.f.baL);
    TextPaint localTextPaint = new TextPaint(1);
    gm = localTextPaint;
    localTextPaint.setStrokeCap(Paint.Cap.ROUND);
    gm.setStyle(Paint.Style.FILL);
    gm.setDither(true);
    gm.setTextSize(olb);
    GMTrace.o(9917750575104L, 73893);
  }
  
  public e(Context paramContext, Matrix paramMatrix, String paramString, Rect paramRect, SpannableString paramSpannableString, int paramInt)
  {
    super(paramContext, paramMatrix, paramString, null, paramRect);
    GMTrace.i(9917347921920L, 73890);
    this.sl = -1;
    this.sl = paramInt;
    this.ole = paramSpannableString;
    GMTrace.o(9917347921920L, 73890);
  }
  
  protected final Bitmap aSB()
  {
    GMTrace.i(9917482139648L, 73891);
    gm.setColor(this.sl);
    Object localObject1 = h.b(this.mContext, this.ole, olb / 1.3F);
    int i;
    int k;
    int m;
    if (localObject1 == null)
    {
      i = 0;
      j = i + old * 2;
      i = j;
      if (j <= 0) {
        i = 1;
      }
      localObject1 = this.ole.toString().split("\n");
      k = (int)olb;
      m = localObject1.length;
      if (localObject1.length <= 1) {
        break label325;
      }
    }
    label325:
    for (int j = localObject1.length * olc;; j = 0)
    {
      localObject1 = Bitmap.createBitmap(i, j + k * m + old * 2, Bitmap.Config.ARGB_8888);
      Object localObject2 = new Canvas((Bitmap)localObject1);
      ((Canvas)localObject2).setDrawFilter(new PaintFlagsDrawFilter(0, 1));
      ((Canvas)localObject2).save();
      ((Canvas)localObject2).translate(old, old);
      new StaticLayout(h.b(this.mContext, this.ole, olb / 1.3F), gm, ((Canvas)localObject2).getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).draw((Canvas)localObject2);
      ((Canvas)localObject2).restore();
      v.i("MicroMsg.TextItem", "text:%s", new Object[] { this.ole });
      GMTrace.o(9917482139648L, 73891);
      return (Bitmap)localObject1;
      localObject2 = new TextView(this.mContext);
      ((TextView)localObject2).setTextSize(Math.round(olb / this.mContext.getResources().getDisplayMetrics().density));
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).measure(0, 0);
      v.i("MicroMsg.TextItem", "%s", new Object[] { Integer.valueOf(((TextView)localObject2).getMeasuredWidth()) });
      i = ((TextView)localObject2).getMeasuredWidth();
      break;
    }
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    GMTrace.i(9917616357376L, 73892);
    super.setSelected(paramBoolean);
    if (!paramBoolean) {
      this.okN = false;
    }
    GMTrace.o(9917616357376L, 73892);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/photoedit/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */