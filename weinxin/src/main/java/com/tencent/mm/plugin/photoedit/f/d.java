package com.tencent.mm.plugin.photoedit.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.plugin.photoedit.g.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;

public final class d
  implements Cloneable
{
  private static int okV;
  private static Paint okW;
  private float gj;
  private Path mU;
  private LinkedList<b> ojh;
  public a oji;
  
  static
  {
    GMTrace.i(9922179760128L, 73926);
    okV = a.ad(12.0F);
    Paint localPaint = new Paint();
    okW = localPaint;
    localPaint.setAntiAlias(true);
    okW.setStyle(Paint.Style.STROKE);
    okW.setColor(-16776961);
    okW.setStrokeCap(Paint.Cap.ROUND);
    GMTrace.o(9922179760128L, 73926);
  }
  
  public d(a parama, Path paramPath, float paramFloat)
  {
    GMTrace.i(9921642889216L, 73922);
    this.oji = parama;
    this.mU = paramPath;
    this.gj = paramFloat;
    okW.setStrokeWidth(a.ad(34.0F) * paramFloat);
    GMTrace.o(9921642889216L, 73922);
  }
  
  public d(a parama, LinkedList<b> paramLinkedList, float paramFloat)
  {
    GMTrace.i(9921777106944L, 73923);
    this.oji = parama;
    this.ojh = paramLinkedList;
    this.gj = paramFloat;
    okW.setStrokeWidth(a.ad(34.0F) * paramFloat);
    GMTrace.o(9921777106944L, 73923);
  }
  
  public static void clear()
  {
    GMTrace.i(9922045542400L, 73925);
    GMTrace.o(9922045542400L, 73925);
  }
  
  public final void a(Canvas paramCanvas, Object... paramVarArgs)
  {
    GMTrace.i(9921911324672L, 73924);
    if (this.oji == a.okX)
    {
      paramVarArgs = (Bitmap)paramVarArgs[0];
      if ((paramVarArgs != null) && (!paramVarArgs.isRecycled()))
      {
        paramCanvas.saveLayer(0.0F, 0.0F, paramVarArgs.getWidth(), paramVarArgs.getHeight(), null, 31);
        paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        paramCanvas.drawPath(this.mU, okW);
        okW.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paramCanvas.drawBitmap(paramVarArgs, 0.0F, 0.0F, okW);
        okW.setXfermode(null);
        paramCanvas.restore();
      }
      GMTrace.o(9921911324672L, 73924);
      return;
    }
    float f1;
    int j;
    float f5;
    Object localObject;
    float f4;
    float f3;
    float f2;
    if (this.oji == a.okY)
    {
      if (this.ojh.size() <= 0)
      {
        GMTrace.o(9921911324672L, 73924);
        return;
      }
      paramVarArgs = (b)this.ojh.getLast();
      f1 = paramVarArgs.ola;
      int i = paramVarArgs.color;
      j = (int)(Math.random() * 100.0D);
      f5 = okV * f1;
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeResource(aa.getContext().getResources(), R.g.bhe, (BitmapFactory.Options)localObject);
      ((BitmapFactory.Options)localObject).inSampleSize = a.a((BitmapFactory.Options)localObject, Math.round(((BitmapFactory.Options)localObject).outWidth * f1 * 0.7F), Math.round(((BitmapFactory.Options)localObject).outHeight * f1 * 0.7F));
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      localObject = BitmapFactory.decodeResource(aa.getContext().getResources(), R.g.bhe, (BitmapFactory.Options)localObject);
      v.i("MicroMsg.MosaicItem", "%s", new Object[] { Float.valueOf(f1 * 0.7F) });
      okW.setStyle(Paint.Style.FILL);
      okW.setColorFilter(new LightingColorFilter(i, 1));
      f4 = paramVarArgs.centerX - ((Bitmap)localObject).getWidth() / 2;
      f3 = paramVarArgs.centerY - ((Bitmap)localObject).getHeight() / 2;
      if ((j <= 0) || (j > 20)) {
        break label448;
      }
      f2 = f4 + f5;
      f1 = f3 + f5;
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.rotate(-paramVarArgs.rotation, paramVarArgs.centerX, paramVarArgs.centerY);
      paramCanvas.drawBitmap((Bitmap)localObject, f2, f1, okW);
      paramCanvas.restore();
      okW.setStyle(Paint.Style.STROKE);
      okW.setColorFilter(null);
      GMTrace.o(9921911324672L, 73924);
      return;
      label448:
      f1 = f3;
      f2 = f4;
      if (80 < j)
      {
        f2 = f4 - f5;
        f1 = f3 - f5;
      }
    }
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(9917213704192L, 73889);
      okX = new a("ONE", 0);
      okY = new a("TWO", 1);
      okZ = new a[] { okX, okY };
      GMTrace.o(9917213704192L, 73889);
    }
    
    private a()
    {
      GMTrace.i(9917079486464L, 73888);
      GMTrace.o(9917079486464L, 73888);
    }
  }
  
  public static final class b
  {
    public float centerX;
    public float centerY;
    public int color;
    public float ola;
    public float rotation;
    
    public b(float paramFloat1, int paramInt, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      GMTrace.i(9920971800576L, 73917);
      this.ola = 0.0F;
      this.rotation = 0.0F;
      this.color = 0;
      this.ola = paramFloat1;
      this.color = paramInt;
      this.rotation = paramFloat2;
      this.centerX = paramFloat3;
      this.centerY = paramFloat4;
      GMTrace.o(9920971800576L, 73917);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/photoedit/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */