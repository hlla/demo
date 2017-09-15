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

public final class abi
  extends c
{
  private final int height;
  private final int width;
  
  public abi()
  {
    GMTrace.i(15713272070144L, 117073);
    this.width = 120;
    this.height = 120;
    GMTrace.o(15713272070144L, 117073);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15713406287872L, 117074);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15713406287872L, 117074);
      return 0;
      GMTrace.o(15713406287872L, 117074);
      return 120;
      GMTrace.o(15713406287872L, 117074);
      return 120;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(76.0F, 81.0F);
      ((Path)localObject).lineTo(91.0F, 81.0F);
      ((Path)localObject).lineTo(91.0F, 85.0F);
      ((Path)localObject).lineTo(76.0F, 85.0F);
      ((Path)localObject).lineTo(76.0F, 89.0F);
      ((Path)localObject).lineTo(72.0F, 89.0F);
      ((Path)localObject).lineTo(72.0F, 77.0F);
      ((Path)localObject).lineTo(76.0F, 77.0F);
      ((Path)localObject).lineTo(76.0F, 81.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(68.0F, 81.0F);
      ((Path)localObject).lineTo(28.0F, 81.0F);
      ((Path)localObject).lineTo(28.0F, 85.0F);
      ((Path)localObject).lineTo(68.0F, 85.0F);
      ((Path)localObject).lineTo(68.0F, 81.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(50.0F, 60.0F);
      ((Path)localObject).lineTo(91.0F, 60.0F);
      ((Path)localObject).lineTo(91.0F, 64.0F);
      ((Path)localObject).lineTo(50.0F, 64.0F);
      ((Path)localObject).lineTo(50.0F, 68.0F);
      ((Path)localObject).lineTo(46.0F, 68.0F);
      ((Path)localObject).lineTo(46.0F, 56.0F);
      ((Path)localObject).lineTo(50.0F, 56.0F);
      ((Path)localObject).lineTo(50.0F, 60.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(42.0F, 60.0F);
      ((Path)localObject).lineTo(28.0F, 60.0F);
      ((Path)localObject).lineTo(28.0F, 64.0F);
      ((Path)localObject).lineTo(42.0F, 64.0F);
      ((Path)localObject).lineTo(42.0F, 60.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(76.0F, 39.0F);
      ((Path)localObject).lineTo(90.0F, 39.0F);
      ((Path)localObject).lineTo(90.0F, 43.0F);
      ((Path)localObject).lineTo(76.0F, 43.0F);
      ((Path)localObject).lineTo(76.0F, 47.0F);
      ((Path)localObject).lineTo(72.0F, 47.0F);
      ((Path)localObject).lineTo(72.0F, 35.0F);
      ((Path)localObject).lineTo(76.0F, 35.0F);
      ((Path)localObject).lineTo(76.0F, 39.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(68.0F, 39.0F);
      ((Path)localObject).lineTo(28.0F, 39.0F);
      ((Path)localObject).lineTo(28.0F, 43.0F);
      ((Path)localObject).lineTo(68.0F, 43.0F);
      ((Path)localObject).lineTo(68.0F, 39.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/abi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */