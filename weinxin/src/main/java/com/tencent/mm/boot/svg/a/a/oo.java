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
import com.tencent.mm.svg.c;

public final class oo
  extends c
{
  private final int height;
  private final int width;
  
  public oo()
  {
    GMTrace.i(15780649369600L, 117575);
    this.width = 90;
    this.height = 90;
    GMTrace.o(15780649369600L, 117575);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15780783587328L, 117576);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15780783587328L, 117576);
      return 0;
      GMTrace.o(15780783587328L, 117576);
      return 90;
      GMTrace.o(15780783587328L, 117576);
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
      localPaint1 = c.a(localPaint2, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-9473160);
      localPaint1.setStrokeWidth(3.0F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 15.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 4.0F);
      ((Path)localObject2).cubicTo(0.0F, 1.7908609F, 1.7908609F, 0.0F, 4.0F, 0.0F);
      ((Path)localObject2).lineTo(76.0F, 0.0F);
      ((Path)localObject2).cubicTo(78.20914F, 0.0F, 80.0F, 1.7908609F, 80.0F, 4.0F);
      ((Path)localObject2).lineTo(80.0F, 56.0F);
      ((Path)localObject2).cubicTo(80.0F, 58.20914F, 78.20914F, 60.0F, 76.0F, 60.0F);
      ((Path)localObject2).lineTo(4.0F, 60.0F);
      ((Path)localObject2).cubicTo(1.7908609F, 60.0F, 0.0F, 58.20914F, 0.0F, 56.0F);
      ((Path)localObject2).lineTo(0.0F, 4.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(80.0F, 51.0F);
      ((Path)localObject2).lineTo(80.0F, 45.92958F);
      ((Path)localObject2).lineTo(59.042984F, 27.279974F);
      ((Path)localObject2).lineTo(46.04323F, 40.501663F);
      ((Path)localObject2).lineTo(25.050598F, 20.0F);
      ((Path)localObject2).lineTo(0.0F, 44.92958F);
      ((Path)localObject2).lineTo(0.0F, 50.0F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/oo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */