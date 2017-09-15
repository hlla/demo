package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;

public final class c
  extends Drawable
  implements Animatable
{
  private Resources Cu;
  private int RQ;
  private int aar;
  private final Paint fu;
  private ad jrx;
  public int kXF;
  private Context mContext;
  private float mHO;
  private float mHP;
  private boolean mHQ;
  private long mHZ;
  private final Runnable mIf;
  private final Runnable mIg;
  private volatile boolean mIq;
  private int mIr;
  private int mIs;
  private int[] mIt;
  private Bitmap mIu;
  private boolean mIv;
  public boolean mIw;
  private String mIx;
  public int mIy;
  private e mIz;
  private final Rect tZ;
  
  public c(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt, int[] paramArrayOfInt, String paramString)
  {
    GMTrace.i(12890807468032L, 96044);
    this.mIq = false;
    this.kXF = 0;
    this.mIu = null;
    this.mIv = false;
    this.mIw = true;
    this.mIy = 0;
    this.mHO = 1.0F;
    this.mHP = 1.0F;
    this.tZ = new Rect();
    this.fu = new Paint(6);
    this.jrx = new ad(Looper.getMainLooper());
    this.mHZ = 0L;
    this.mIg = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12883291275264L, 95988);
        if (SystemClock.uptimeMillis() >= c.a(c.this)) {
          c.this.invalidateSelf();
        }
        GMTrace.o(12883291275264L, 95988);
      }
    };
    this.mIf = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(12889733726208L, 96036);
        GMTrace.o(12889733726208L, 96036);
      }
    };
    this.mContext = paramContext;
    this.Cu = this.mContext.getResources();
    this.mIv = false;
    this.mIw = paramBoolean2;
    this.mIx = paramString;
    this.mIs = paramInt;
    this.mIt = paramArrayOfInt;
    if (!paramBoolean2)
    {
      this.mIu = nQ(yg(paramString));
      this.aar = this.mIu.getWidth();
      this.RQ = this.mIu.getHeight();
      if (this.mIt.length != 3) {
        break label250;
      }
    }
    label250:
    for (this.mIr = 300;; this.mIr = 100)
    {
      this.mIy = 0;
      GMTrace.o(12890807468032L, 96044);
      return;
      this.mIu = nQ(this.mIt[0]);
      break;
    }
  }
  
  private void d(Runnable paramRunnable, long paramLong)
  {
    GMTrace.i(12891075903488L, 96046);
    this.mHZ = (SystemClock.uptimeMillis() + paramLong);
    if (this.jrx != null) {
      this.jrx.postDelayed(paramRunnable, paramLong);
    }
    GMTrace.o(12891075903488L, 96046);
  }
  
  private Bitmap nQ(int paramInt)
  {
    GMTrace.i(12892418080768L, 96056);
    Bitmap localBitmap = BitmapFactory.decodeResource(this.Cu, paramInt);
    GMTrace.o(12892418080768L, 96056);
    return localBitmap;
  }
  
  private int yg(String paramString)
  {
    GMTrace.i(12892552298496L, 96057);
    paramString = paramString.split("\\.")[0];
    int i = this.Cu.getIdentifier(paramString, "drawable", this.mContext.getPackageName());
    GMTrace.o(12892552298496L, 96057);
    return i;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    GMTrace.i(12890941685760L, 96045);
    if (this.mHQ)
    {
      this.tZ.set(getBounds());
      this.mHO = (this.tZ.width() / this.aar);
      this.mHP = (this.tZ.height() / this.RQ);
      this.mHQ = false;
    }
    if (this.fu.getShader() == null)
    {
      paramCanvas.scale(this.mHO, this.mHP);
      if (this.mIv)
      {
        this.mIu = nQ(this.mIs);
        if ((this.mIu != null) && (!this.mIu.isRecycled()))
        {
          paramCanvas.drawBitmap(this.mIu, 0.0F, 0.0F, this.fu);
          GMTrace.o(12890941685760L, 96045);
        }
      }
      else if (!this.mIw)
      {
        this.mIu = nQ(yg(this.mIx));
        if ((this.mIu != null) && (!this.mIu.isRecycled()))
        {
          paramCanvas.drawBitmap(this.mIu, 0.0F, 0.0F, this.fu);
          GMTrace.o(12890941685760L, 96045);
        }
      }
      else
      {
        v.i("MicroMsg.GIF.MMGIFGameDrawable", "mCurrentIndex:%d mNextInvaliteTime:%d mLoop:%d", new Object[] { Integer.valueOf(this.kXF), Integer.valueOf(this.mIr), Integer.valueOf(this.mIy) });
        this.mIu = nQ(this.mIt[this.kXF]);
        if ((this.mIu != null) && (!this.mIu.isRecycled())) {
          paramCanvas.drawBitmap(this.mIu, 0.0F, 0.0F, this.fu);
        }
        this.kXF += 1;
        if (this.mIy < 3)
        {
          if (this.kXF >= this.mIt.length)
          {
            this.kXF = 0;
            this.mIy += 1;
          }
          d(this.mIg, this.mIr);
          GMTrace.o(12890941685760L, 96045);
          return;
        }
        this.mIw = false;
        d(this.mIg, this.mIr);
        d(this.mIf, 0L);
        GMTrace.o(12890941685760L, 96045);
      }
    }
    else
    {
      v.i("MicroMsg.GIF.MMGIFGameDrawable", "shader is not null.");
      paramCanvas.drawRect(this.tZ, this.fu);
    }
    GMTrace.o(12890941685760L, 96045);
  }
  
  protected final void finalize()
  {
    GMTrace.i(12892686516224L, 96058);
    this.mIz = null;
    super.finalize();
    GMTrace.o(12892686516224L, 96058);
  }
  
  public final int getIntrinsicHeight()
  {
    GMTrace.i(12891210121216L, 96047);
    int i = this.RQ;
    GMTrace.o(12891210121216L, 96047);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    GMTrace.i(12891344338944L, 96048);
    int i = this.aar;
    GMTrace.o(12891344338944L, 96048);
    return i;
  }
  
  public final int getOpacity()
  {
    GMTrace.i(12891746992128L, 96051);
    GMTrace.o(12891746992128L, 96051);
    return -2;
  }
  
  public final boolean isRunning()
  {
    GMTrace.i(12892283863040L, 96055);
    boolean bool = this.mIq;
    GMTrace.o(12892283863040L, 96055);
    return bool;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    GMTrace.i(12891881209856L, 96052);
    super.onBoundsChange(paramRect);
    this.mHQ = true;
    GMTrace.o(12891881209856L, 96052);
  }
  
  public final void setAlpha(int paramInt)
  {
    GMTrace.i(12891478556672L, 96049);
    this.fu.setAlpha(paramInt);
    GMTrace.o(12891478556672L, 96049);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    GMTrace.i(12891612774400L, 96050);
    this.fu.setColorFilter(paramColorFilter);
    GMTrace.o(12891612774400L, 96050);
  }
  
  public final void start()
  {
    GMTrace.i(12892015427584L, 96053);
    this.mIq = true;
    this.jrx.post(this.mIg);
    GMTrace.o(12892015427584L, 96053);
  }
  
  public final void stop()
  {
    GMTrace.i(12892149645312L, 96054);
    this.mIq = false;
    GMTrace.o(12892149645312L, 96054);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/gif/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */