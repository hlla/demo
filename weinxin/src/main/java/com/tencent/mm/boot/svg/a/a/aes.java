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

public final class aes
  extends c
{
  private final int height;
  private final int width;
  
  public aes()
  {
    GMTrace.i(15944394997760L, 118795);
    this.width = 30;
    this.height = 30;
    GMTrace.o(15944394997760L, 118795);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15944529215488L, 118796);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15944529215488L, 118796);
      return 0;
      GMTrace.o(15944529215488L, 118796);
      return 30;
      GMTrace.o(15944529215488L, 118796);
      return 30;
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
      localPaint.setColor(-10000537);
      localCanvas.saveLayerAlpha(null, 128, 4);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 30.0F);
      ((Path)localObject).cubicTo(10.01F, 20.01F, 19.99F, 10.0F, 30.0F, 0.02F);
      ((Path)localObject).lineTo(30.0F, 30.0F);
      ((Path)localObject).lineTo(0.0F, 30.0F);
      ((Path)localObject).lineTo(0.0F, 30.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/aes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */