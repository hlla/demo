package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.sdk.platformtools.ad;

class SendDataToDeviceProgressBar
  extends ImageView
{
  private int bottom;
  private Paint fu;
  private ad hgD;
  private int left;
  private int liS;
  private int liT;
  private Runnable liU;
  private int mAm;
  private Context mContext;
  private int right;
  private int top;
  
  public SendDataToDeviceProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(2174595629056L, 16202);
    GMTrace.o(2174595629056L, 16202);
  }
  
  public SendDataToDeviceProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(2174729846784L, 16203);
    this.liS = 2;
    this.left = -1;
    this.top = -1;
    this.right = -1;
    this.bottom = -1;
    this.liT = -1;
    this.mAm = 10;
    this.liU = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2252307693568L, 16781);
        SendDataToDeviceProgressBar.this.invalidate();
        GMTrace.o(2252307693568L, 16781);
      }
    };
    setImageResource(R.g.biB);
    this.mContext = paramContext;
    this.fu = new Paint();
    this.fu.setAntiAlias(true);
    this.fu.setStyle(Paint.Style.STROKE);
    this.left = this.mContext.getResources().getDimensionPixelSize(R.f.baU);
    this.top = this.left;
    this.liT = this.mContext.getResources().getDimensionPixelSize(R.f.baV);
    this.hgD = new ad(Looper.getMainLooper());
    GMTrace.o(2174729846784L, 16203);
  }
  
  public final int getProgress()
  {
    GMTrace.i(2174998282240L, 16205);
    int i = (int)(this.liS / 360.0F * 100.0F);
    GMTrace.o(2174998282240L, 16205);
    return i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(2175132499968L, 16206);
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    this.fu.setColor(this.mContext.getResources().getColor(R.e.aVu));
    this.fu.setStrokeWidth(this.liT);
    if (this.right == -1) {
      this.right = (i * 2 - this.left);
    }
    if (this.bottom == -1) {
      this.bottom = this.right;
    }
    RectF localRectF = new RectF(this.left, this.top, this.right, this.bottom);
    paramCanvas.drawArc(localRectF, 270.0F, this.liS, false, this.fu);
    int j = this.liS + 270;
    i = j;
    if (j > 360) {
      i = j - 360;
    }
    this.fu.setColor(this.mContext.getResources().getColor(R.e.aVt));
    paramCanvas.drawArc(localRectF, i, 360 - this.liS, false, this.fu);
    GMTrace.o(2175132499968L, 16206);
  }
  
  public final void setProgress(int paramInt)
  {
    GMTrace.i(2174864064512L, 16204);
    int i = paramInt;
    if (paramInt >= 100) {
      i = 100;
    }
    this.liS = ((int)(i / 100.0F * 360.0F));
    this.hgD.removeCallbacks(this.liU);
    this.hgD.postDelayed(this.liU, 0L);
    GMTrace.o(2174864064512L, 16204);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/SendDataToDeviceProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */