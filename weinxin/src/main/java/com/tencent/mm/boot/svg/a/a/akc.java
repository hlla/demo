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

public final class akc
  extends c
{
  private final int height;
  private final int width;
  
  public akc()
  {
    GMTrace.i(15711929892864L, 117063);
    this.width = 255;
    this.height = 255;
    GMTrace.o(15711929892864L, 117063);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15712064110592L, 117064);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15712064110592L, 117064);
      return 0;
      GMTrace.o(15712064110592L, 117064);
      return 255;
      GMTrace.o(15712064110592L, 117064);
      return 255;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 74.0F, 0.0F, 1.0F, 65.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(98.000374F, 0.0F);
      ((Path)localObject2).lineTo(21.999622F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 0.0F);
      ((Path)localObject2).lineTo(12.0F, 12.0F);
      ((Path)localObject2).lineTo(12.0F, 10.000714F);
      ((Path)localObject2).lineTo(12.0F, 126.0F);
      ((Path)localObject2).lineTo(108.0F, 126.0F);
      ((Path)localObject2).lineTo(108.0F, 10.000714F);
      ((Path)localObject2).lineTo(108.0F, 12.0F);
      ((Path)localObject2).lineTo(96.0F, 0.0F);
      ((Path)localObject2).lineTo(98.000374F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(108.0F, 114.0F);
      ((Path)localObject2).lineTo(96.0F, 126.0F);
      ((Path)localObject2).lineTo(108.0F, 126.0F);
      ((Path)localObject2).lineTo(108.0F, 114.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(0.0F, 48.0F);
      ((Path)localObject2).lineTo(12.0F, 48.0F);
      ((Path)localObject2).lineTo(12.0F, 126.0F);
      ((Path)localObject2).lineTo(0.0F, 126.0F);
      ((Path)localObject2).lineTo(0.0F, 48.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(0.0F, 114.0F);
      ((Path)localObject2).lineTo(12.0F, 126.0F);
      ((Path)localObject2).lineTo(0.0F, 126.0F);
      ((Path)localObject2).lineTo(0.0F, 114.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(0.0F, 60.0F);
      ((Path)localObject2).lineTo(12.0F, 48.0F);
      ((Path)localObject2).lineTo(0.0F, 48.0F);
      ((Path)localObject2).lineTo(0.0F, 60.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(36.0F, 12.0F);
      ((Path)localObject2).lineTo(48.0F, 12.0F);
      ((Path)localObject2).lineTo(48.0F, 42.0F);
      ((Path)localObject2).lineTo(36.0F, 42.0F);
      ((Path)localObject2).lineTo(36.0F, 12.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(54.0F, 12.0F);
      ((Path)localObject2).lineTo(66.0F, 12.0F);
      ((Path)localObject2).lineTo(66.0F, 42.0F);
      ((Path)localObject2).lineTo(54.0F, 42.0F);
      ((Path)localObject2).lineTo(54.0F, 12.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(72.0F, 12.0F);
      ((Path)localObject2).lineTo(84.0F, 12.0F);
      ((Path)localObject2).lineTo(84.0F, 42.0F);
      ((Path)localObject2).lineTo(72.0F, 42.0F);
      ((Path)localObject2).lineTo(72.0F, 12.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/akc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */