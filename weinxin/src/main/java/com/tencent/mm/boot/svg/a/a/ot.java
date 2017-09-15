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

public final class ot
  extends c
{
  private final int height;
  private final int width;
  
  public ot()
  {
    GMTrace.i(15757832355840L, 117405);
    this.width = 90;
    this.height = 90;
    GMTrace.o(15757832355840L, 117405);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15757966573568L, 117406);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15757966573568L, 117406);
      return 0;
      GMTrace.o(15757966573568L, 117406);
      return 90;
      GMTrace.o(15757966573568L, 117406);
      return 90;
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
      localPaint1.setColor(-13917627);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 17.0F, 0.0F, 1.0F, 10.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(25.826185F, 69.26216F);
      ((Path)localObject2).cubicTo(27.02675F, 70.278595F, 28.996534F, 70.27632F, 30.197113F, 69.24175F);
      ((Path)localObject2).cubicTo(30.197113F, 69.24175F, 56.0F, 48.740444F, 56.0F, 27.843023F);
      ((Path)localObject2).cubicTo(56.0F, 12.398772F, 43.463974F, 0.0F, 28.405798F, 0.0F);
      ((Path)localObject2).cubicTo(12.536027F, 0.0F, 0.0F, 12.398772F, 0.0F, 27.843023F);
      ((Path)localObject2).cubicTo(0.0F, 48.740444F, 25.826185F, 69.26216F, 25.826185F, 69.26216F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(28.0F, 37.0F);
      ((Path)localObject2).cubicTo(32.970562F, 37.0F, 37.0F, 32.970562F, 37.0F, 28.0F);
      ((Path)localObject2).cubicTo(37.0F, 23.029438F, 32.970562F, 19.0F, 28.0F, 19.0F);
      ((Path)localObject2).cubicTo(23.029438F, 19.0F, 19.0F, 23.029438F, 19.0F, 28.0F);
      ((Path)localObject2).cubicTo(19.0F, 32.970562F, 23.029438F, 37.0F, 28.0F, 37.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/ot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */