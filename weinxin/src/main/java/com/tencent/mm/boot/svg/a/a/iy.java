package com.tencent.mm.boot.svg.a.a;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.svg.c;

public final class iy
  extends c
{
  private final int height;
  private final int width;
  
  public iy()
  {
    GMTrace.i(15828967751680L, 117935);
    this.width = 40;
    this.height = 40;
    GMTrace.o(15828967751680L, 117935);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15829101969408L, 117936);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15829101969408L, 117936);
      return 0;
      GMTrace.o(15829101969408L, 117936);
      return 40;
      GMTrace.o(15829101969408L, 117936);
      return 40;
      paramVarArgs = (Looper)paramVarArgs[1];
      c.d(paramVarArgs);
      c.c(paramVarArgs);
      Paint localPaint1 = c.g(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.g(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/iy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */