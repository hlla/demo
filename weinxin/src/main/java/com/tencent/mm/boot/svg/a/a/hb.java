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

public final class hb
  extends c
{
  private final int height;
  private final int width;
  
  public hb()
  {
    GMTrace.i(15910035259392L, 118539);
    this.width = 144;
    this.height = 144;
    GMTrace.o(15910035259392L, 118539);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15910169477120L, 118540);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15910169477120L, 118540);
      return 0;
      GMTrace.o(15910169477120L, 118540);
      return 144;
      GMTrace.o(15910169477120L, 118540);
      return 144;
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
      localPaint.setColor(-9276814);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(120.0F, 12.0F);
      ((Path)localObject).lineTo(24.0F, 12.0F);
      ((Path)localObject).cubicTo(17.4F, 12.0F, 12.06F, 17.4F, 12.06F, 24.0F);
      ((Path)localObject).lineTo(12.0F, 132.0F);
      ((Path)localObject).lineTo(36.0F, 108.0F);
      ((Path)localObject).lineTo(120.0F, 108.0F);
      ((Path)localObject).cubicTo(126.6F, 108.0F, 132.0F, 102.6F, 132.0F, 96.0F);
      ((Path)localObject).lineTo(132.0F, 24.0F);
      ((Path)localObject).cubicTo(132.0F, 17.4F, 126.6F, 12.0F, 120.0F, 12.0F);
      ((Path)localObject).lineTo(120.0F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(108.0F, 84.0F);
      ((Path)localObject).lineTo(36.0F, 84.0F);
      ((Path)localObject).lineTo(36.0F, 72.0F);
      ((Path)localObject).lineTo(108.0F, 72.0F);
      ((Path)localObject).lineTo(108.0F, 84.0F);
      ((Path)localObject).lineTo(108.0F, 84.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(108.0F, 66.0F);
      ((Path)localObject).lineTo(36.0F, 66.0F);
      ((Path)localObject).lineTo(36.0F, 54.0F);
      ((Path)localObject).lineTo(108.0F, 54.0F);
      ((Path)localObject).lineTo(108.0F, 66.0F);
      ((Path)localObject).lineTo(108.0F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(108.0F, 48.0F);
      ((Path)localObject).lineTo(36.0F, 48.0F);
      ((Path)localObject).lineTo(36.0F, 36.0F);
      ((Path)localObject).lineTo(108.0F, 36.0F);
      ((Path)localObject).lineTo(108.0F, 48.0F);
      ((Path)localObject).lineTo(108.0F, 48.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/hb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */