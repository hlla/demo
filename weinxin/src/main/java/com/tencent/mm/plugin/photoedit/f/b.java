package com.tencent.mm.plugin.photoedit.f;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.photoedit.g.a;

public final class b
  implements Cloneable
{
  private static Paint okE;
  private float gj;
  private Path mU;
  private float mw;
  private int sl;
  
  static
  {
    GMTrace.i(9921508671488L, 73921);
    Paint localPaint = new Paint();
    okE = localPaint;
    localPaint.setAntiAlias(true);
    okE.setStyle(Paint.Style.STROKE);
    okE.setStrokeCap(Paint.Cap.ROUND);
    GMTrace.o(9921508671488L, 73921);
  }
  
  public b(Path paramPath, float paramFloat, int paramInt)
  {
    GMTrace.i(9921106018304L, 73918);
    this.gj = 1.0F;
    this.mw = a.ad(5.0F);
    this.mU = paramPath;
    this.gj = paramFloat;
    this.sl = paramInt;
    GMTrace.o(9921106018304L, 73918);
  }
  
  public static void clear()
  {
    GMTrace.i(9921374453760L, 73920);
    GMTrace.o(9921374453760L, 73920);
  }
  
  public final void j(Canvas paramVarArgs)
  {
    GMTrace.i(9921240236032L, 73919);
    okE.setColor(this.sl);
    okE.setStrokeWidth(this.mw * this.gj);
    if (!this.mU.isEmpty()) {
      paramVarArgs.drawPath(this.mU, okE);
    }
    GMTrace.o(9921240236032L, 73919);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/photoedit/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */