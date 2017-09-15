package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.svg.c;

public final class rg
  extends c
{
  private final int height;
  private final int width;
  
  public rg()
  {
    GMTrace.i(15812593188864L, 117813);
    this.width = 216;
    this.height = 216;
    GMTrace.o(15812593188864L, 117813);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15812727406592L, 117814);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15812727406592L, 117814);
      return 0;
      GMTrace.o(15812727406592L, 117814);
      return 216;
      GMTrace.o(15812727406592L, 117814);
      return 216;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.d(paramVarArgs);
      c.c(paramVarArgs);
      Paint localPaint = c.g(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.g(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 40.0F);
      ((Path)localObject).cubicTo(0.0F, 17.90861F, 17.90861F, 0.0F, 40.0F, 0.0F);
      ((Path)localObject).lineTo(176.0F, 0.0F);
      ((Path)localObject).cubicTo(198.09138F, 0.0F, 216.0F, 17.90861F, 216.0F, 40.0F);
      ((Path)localObject).lineTo(216.0F, 176.0F);
      ((Path)localObject).cubicTo(216.0F, 198.09138F, 198.09138F, 216.0F, 176.0F, 216.0F);
      ((Path)localObject).lineTo(40.0F, 216.0F);
      ((Path)localObject).cubicTo(17.90861F, 216.0F, 0.0F, 198.09138F, 0.0F, 176.0F);
      ((Path)localObject).lineTo(0.0F, 40.0F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/rg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */