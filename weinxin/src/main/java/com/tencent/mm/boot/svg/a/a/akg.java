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

public final class akg
  extends c
{
  private final int height;
  private final int width;
  
  public akg()
  {
    GMTrace.i(16770505113600L, 124950);
    this.width = 120;
    this.height = 70;
    GMTrace.o(16770505113600L, 124950);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(16770639331328L, 124951);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(16770639331328L, 124951);
      return 0;
      GMTrace.o(16770639331328L, 124951);
      return 120;
      GMTrace.o(16770639331328L, 124951);
      return 70;
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
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 153, 4);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-9473160);
      localPaint.setStrokeWidth(5.0F);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(24.0F, 17.0F);
      ((Path)localObject).lineTo(60.0F, 53.0F);
      ((Path)localObject).lineTo(96.0F, 17.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/akg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */