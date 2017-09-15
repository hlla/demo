package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class vb
  extends c
{
  private final int height;
  private final int width;
  
  public vb()
  {
    GMTrace.i(15899297841152L, 118459);
    this.width = 18;
    this.height = 38;
    GMTrace.o(15899297841152L, 118459);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15899432058880L, 118460);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15899432058880L, 118460);
      return 0;
      GMTrace.o(15899432058880L, 118460);
      return 18;
      GMTrace.o(15899432058880L, 118460);
      return 38;
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-6710887);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(6.0F, 0.0F);
      ((Path)localObject).cubicTo(10.03F, 6.2841287F, 13.99F, 12.663152F, 18.0F, 19.0F);
      ((Path)localObject).cubicTo(13.97F, 25.305216F, 10.03F, 31.673697F, 6.0F, 38.0F);
      ((Path)localObject).lineTo(0.0F, 38.0F);
      ((Path)localObject).cubicTo(3.97F, 31.642065F, 8.0F, 25.326303F, 12.0F, 19.0F);
      ((Path)localObject).cubicTo(8.01F, 12.673696F, 4.04F, 6.336848F, 0.0F, 0.0F);
      ((Path)localObject).lineTo(6.0F, 0.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/vb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */