package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;

public class j
  extends BitmapDrawable
  implements d.a
{
  protected static final Paint hgO;
  protected static final ad hgP;
  private Runnable hgR;
  private Paint jVY;
  protected final a ouZ;
  private Rect rect;
  protected float sHA;
  private PaintFlagsDrawFilter sHB;
  private Path sHC;
  protected boolean sHu;
  protected boolean sHv;
  private int sHw;
  private int sHx;
  protected boolean sHy;
  protected boolean sHz;
  protected String tag;
  
  static
  {
    GMTrace.i(1180176482304L, 8793);
    Paint localPaint = new Paint();
    hgO = localPaint;
    localPaint.setAntiAlias(true);
    hgO.setFilterBitmap(true);
    hgP = new ad(Looper.getMainLooper());
    GMTrace.o(1180176482304L, 8793);
  }
  
  public j(a parama, String paramString)
  {
    super(parama.nZ());
    GMTrace.i(1178968522752L, 8784);
    this.sHu = false;
    this.sHv = false;
    this.sHw = 0;
    this.sHx = 0;
    this.sHA = 1.0F;
    this.rect = new Rect();
    this.sHB = new PaintFlagsDrawFilter(0, 3);
    this.jVY = new Paint();
    this.jVY.setStyle(Paint.Style.STROKE);
    this.jVY.setFlags(1);
    this.jVY.setAntiAlias(true);
    this.sHC = new Path();
    this.hgR = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1157091033088L, 8621);
        j.this.invalidateSelf();
        GMTrace.o(1157091033088L, 8621);
      }
    };
    this.ouZ = parama;
    this.tag = paramString;
    this.ouZ.a(this);
    GMTrace.o(1178968522752L, 8784);
  }
  
  public j(a parama, String paramString, boolean paramBoolean)
  {
    super(parama.nZ());
    GMTrace.i(1179102740480L, 8785);
    this.sHu = false;
    this.sHv = false;
    this.sHw = 0;
    this.sHx = 0;
    this.sHA = 1.0F;
    this.rect = new Rect();
    this.sHB = new PaintFlagsDrawFilter(0, 3);
    this.jVY = new Paint();
    this.jVY.setStyle(Paint.Style.STROKE);
    this.jVY.setFlags(1);
    this.jVY.setAntiAlias(true);
    this.sHC = new Path();
    this.hgR = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1157091033088L, 8621);
        j.this.invalidateSelf();
        GMTrace.o(1157091033088L, 8621);
      }
    };
    this.sHu = false;
    this.ouZ = parama;
    this.tag = paramString;
    this.ouZ.a(this);
    GMTrace.o(1179102740480L, 8785);
  }
  
  public final void MB(String paramString)
  {
    GMTrace.i(1179236958208L, 8786);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(1179236958208L, 8786);
      return;
    }
    if (!paramString.equals(this.tag))
    {
      this.tag = paramString;
      hgP.post(this.hgR);
    }
    GMTrace.o(1179236958208L, 8786);
  }
  
  public final void bDZ()
  {
    GMTrace.i(1179773829120L, 8790);
    this.sHy = true;
    GMTrace.o(1179773829120L, 8790);
  }
  
  public final void bEa()
  {
    GMTrace.i(1179908046848L, 8791);
    if (!this.sHy)
    {
      GMTrace.o(1179908046848L, 8791);
      return;
    }
    this.sHy = false;
    if (this.sHz)
    {
      this.sHz = false;
      invalidateSelf();
    }
    GMTrace.o(1179908046848L, 8791);
  }
  
  public void draw(Canvas paramCanvas)
  {
    GMTrace.i(1179505393664L, 8788);
    Bitmap localBitmap;
    if (this.sHv)
    {
      localBitmap = this.ouZ.a(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        break label222;
      }
      localBitmap = this.ouZ.nZ();
      if (!this.sHy) {
        break label214;
      }
      this.sHz = true;
    }
    for (;;)
    {
      Rect localRect2 = getBounds();
      Rect localRect1 = null;
      if ((this.sHA > 1.0F) || (this.sHu))
      {
        int i = localBitmap.getHeight() / 15 / 2;
        int j = localBitmap.getWidth() / 15 / 2;
        localRect1 = new Rect(j, i, localBitmap.getWidth() - j, localBitmap.getHeight() - i);
      }
      paramCanvas.drawBitmap(localBitmap, localRect1, localRect2, hgO);
      GMTrace.o(1179505393664L, 8788);
      return;
      if (this.sHy)
      {
        localBitmap = this.ouZ.bg(this.tag);
        break;
      }
      localBitmap = this.ouZ.bf(this.tag);
      break;
      label214:
      this.sHz = false;
      continue;
      label222:
      this.sHz = false;
    }
  }
  
  public void ho(String paramString)
  {
    GMTrace.i(1179639611392L, 8789);
    if ((paramString == null) || (!paramString.equals(this.tag)))
    {
      GMTrace.o(1179639611392L, 8789);
      return;
    }
    v.v("MicroMsg.SDK.LazyBitmapDrawable", "notifyChanged :%s", new Object[] { paramString });
    hgP.post(this.hgR);
    GMTrace.o(1179639611392L, 8789);
  }
  
  public final void jj(boolean paramBoolean)
  {
    GMTrace.i(1179371175936L, 8787);
    this.sHv = paramBoolean;
    GMTrace.o(1179371175936L, 8787);
  }
  
  public void onScrollStateChanged(boolean paramBoolean)
  {
    GMTrace.i(1180042264576L, 8792);
    if (paramBoolean)
    {
      this.sHy = true;
      GMTrace.o(1180042264576L, 8792);
      return;
    }
    bEa();
    GMTrace.o(1180042264576L, 8792);
  }
  
  public static abstract interface a
  {
    public abstract Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void a(j paramj);
    
    public abstract Bitmap bf(String paramString);
    
    public abstract Bitmap bg(String paramString);
    
    public abstract Bitmap nZ();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */