package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class vt
  extends c
{
  private final int height;
  private final int width;
  
  public vt()
  {
    GMTrace.i(17573127127040L, 130930);
    this.width = 80;
    this.height = 69;
    GMTrace.o(17573127127040L, 130930);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(17573261344768L, 130931);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(17573261344768L, 130931);
      return 0;
      GMTrace.o(17573261344768L, 130931);
      return 80;
      GMTrace.o(17573261344768L, 130931);
      return 69;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.d(paramVarArgs);
      Object localObject2 = c.c(paramVarArgs);
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
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(48640);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -67.0F, 0.0F, 1.0F, -264.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(67.541016F, 329.11725F);
      ((Path)localObject2).lineTo(104.7274F, 265.6061F);
      ((Path)localObject2).cubicTo(105.979546F, 263.46756F, 108.01863F, 263.46173F, 109.27419F, 265.6061F);
      ((Path)localObject2).lineTo(146.46057F, 329.11725F);
      ((Path)localObject2).cubicTo(147.71272F, 331.2558F, 146.71822F, 333.0F, 144.23167F, 333.0F);
      ((Path)localObject2).lineTo(69.76992F, 333.0F);
      ((Path)localObject2).cubicTo(67.28949F, 333.0F, 66.28545F, 331.26163F, 67.541016F, 329.11725F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(105.08408F, 288.09476F);
      ((Path)localObject2).cubicTo(104.25631F, 288.09476F, 103.6169F, 288.77545F, 103.654755F, 289.5901F);
      ((Path)localObject2).lineTo(104.72356F, 312.58853F);
      ((Path)localObject2).lineTo(109.276726F, 312.58853F);
      ((Path)localObject2).lineTo(110.34553F, 289.5901F);
      ((Path)localObject2).cubicTo(110.3839F, 288.76425F, 109.73518F, 288.09476F, 108.9162F, 288.09476F);
      ((Path)localObject2).lineTo(105.08408F, 288.09476F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(107.00014F, 323.47464F);
      ((Path)localObject2).cubicTo(108.88612F, 323.47464F, 110.415016F, 321.95157F, 110.415016F, 320.07272F);
      ((Path)localObject2).cubicTo(110.415016F, 318.1939F, 108.88612F, 316.67084F, 107.00014F, 316.67084F);
      ((Path)localObject2).cubicTo(105.11416F, 316.67084F, 103.585266F, 318.1939F, 103.585266F, 320.07272F);
      ((Path)localObject2).cubicTo(103.585266F, 321.95157F, 105.11416F, 323.47464F, 107.00014F, 323.47464F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/vt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */