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

public final class jn
  extends c
{
  private final int height;
  private final int width;
  
  public jn()
  {
    GMTrace.i(15720519827456L, 117127);
    this.width = 96;
    this.height = 96;
    GMTrace.o(15720519827456L, 117127);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15720654045184L, 117128);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15720654045184L, 117128);
      return 0;
      GMTrace.o(15720654045184L, 117128);
      return 96;
      GMTrace.o(15720654045184L, 117128);
      return 96;
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
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 20.0F, 0.0F, 1.0F, 20.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.a(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      ((Paint)localObject1).setStrokeWidth(6.0F);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 7.0F);
      ((Path)localObject2).cubicTo(0.0F, 5.3431454F, 1.3431456F, 4.0F, 3.0F, 4.0F);
      ((Path)localObject2).lineTo(53.0F, 4.0F);
      ((Path)localObject2).cubicTo(54.656853F, 4.0F, 56.0F, 5.3431454F, 56.0F, 7.0F);
      ((Path)localObject2).lineTo(56.0F, 53.0F);
      ((Path)localObject2).cubicTo(56.0F, 54.656853F, 54.656853F, 56.0F, 53.0F, 56.0F);
      ((Path)localObject2).lineTo(3.0F, 56.0F);
      ((Path)localObject2).cubicTo(1.3431456F, 56.0F, 0.0F, 54.656853F, 0.0F, 53.0F);
      ((Path)localObject2).lineTo(0.0F, 7.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(11.0F, 0.45000002F);
      ((Path)localObject2).cubicTo(11.0F, 0.20147187F, 11.201471F, 0.0F, 11.45F, 0.0F);
      ((Path)localObject2).lineTo(12.55F, 0.0F);
      ((Path)localObject2).cubicTo(12.798529F, 0.0F, 13.0F, 0.20147187F, 13.0F, 0.45000002F);
      ((Path)localObject2).lineTo(13.0F, 10.55F);
      ((Path)localObject2).cubicTo(13.0F, 10.798529F, 12.798529F, 11.0F, 12.55F, 11.0F);
      ((Path)localObject2).lineTo(11.45F, 11.0F);
      ((Path)localObject2).cubicTo(11.201471F, 11.0F, 11.0F, 10.798529F, 11.0F, 10.55F);
      ((Path)localObject2).lineTo(11.0F, 0.45000002F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(2.0F, 20.0F);
      ((Path)localObject2).lineTo(54.0F, 20.0F);
      ((Path)localObject2).lineTo(54.0F, 22.0F);
      ((Path)localObject2).lineTo(2.0F, 22.0F);
      ((Path)localObject2).lineTo(2.0F, 20.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(9.0F, 30.45F);
      ((Path)localObject2).cubicTo(9.0F, 30.201473F, 9.201471F, 30.0F, 9.45F, 30.0F);
      ((Path)localObject2).lineTo(17.55F, 30.0F);
      ((Path)localObject2).cubicTo(17.798527F, 30.0F, 18.0F, 30.201473F, 18.0F, 30.45F);
      ((Path)localObject2).lineTo(18.0F, 31.55F);
      ((Path)localObject2).cubicTo(18.0F, 31.798527F, 17.798527F, 32.0F, 17.55F, 32.0F);
      ((Path)localObject2).lineTo(9.45F, 32.0F);
      ((Path)localObject2).cubicTo(9.201471F, 32.0F, 9.0F, 31.798527F, 9.0F, 31.55F);
      ((Path)localObject2).lineTo(9.0F, 30.45F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 30.45F);
      ((Path)localObject2).cubicTo(24.0F, 30.201473F, 24.201473F, 30.0F, 24.45F, 30.0F);
      ((Path)localObject2).lineTo(32.55F, 30.0F);
      ((Path)localObject2).cubicTo(32.798527F, 30.0F, 33.0F, 30.201473F, 33.0F, 30.45F);
      ((Path)localObject2).lineTo(33.0F, 31.55F);
      ((Path)localObject2).cubicTo(33.0F, 31.798527F, 32.798527F, 32.0F, 32.55F, 32.0F);
      ((Path)localObject2).lineTo(24.45F, 32.0F);
      ((Path)localObject2).cubicTo(24.201473F, 32.0F, 24.0F, 31.798527F, 24.0F, 31.55F);
      ((Path)localObject2).lineTo(24.0F, 30.45F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(38.0F, 30.45F);
      ((Path)localObject2).cubicTo(38.0F, 30.201473F, 38.201473F, 30.0F, 38.45F, 30.0F);
      ((Path)localObject2).lineTo(46.55F, 30.0F);
      ((Path)localObject2).cubicTo(46.798527F, 30.0F, 47.0F, 30.201473F, 47.0F, 30.45F);
      ((Path)localObject2).lineTo(47.0F, 31.55F);
      ((Path)localObject2).cubicTo(47.0F, 31.798527F, 46.798527F, 32.0F, 46.55F, 32.0F);
      ((Path)localObject2).lineTo(38.45F, 32.0F);
      ((Path)localObject2).cubicTo(38.201473F, 32.0F, 38.0F, 31.798527F, 38.0F, 31.55F);
      ((Path)localObject2).lineTo(38.0F, 30.45F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(38.0F, 41.45F);
      ((Path)localObject2).cubicTo(38.0F, 41.201473F, 38.201473F, 41.0F, 38.45F, 41.0F);
      ((Path)localObject2).lineTo(46.55F, 41.0F);
      ((Path)localObject2).cubicTo(46.798527F, 41.0F, 47.0F, 41.201473F, 47.0F, 41.45F);
      ((Path)localObject2).lineTo(47.0F, 42.55F);
      ((Path)localObject2).cubicTo(47.0F, 42.798527F, 46.798527F, 43.0F, 46.55F, 43.0F);
      ((Path)localObject2).lineTo(38.45F, 43.0F);
      ((Path)localObject2).cubicTo(38.201473F, 43.0F, 38.0F, 42.798527F, 38.0F, 42.55F);
      ((Path)localObject2).lineTo(38.0F, 41.45F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 41.45F);
      ((Path)localObject2).cubicTo(24.0F, 41.201473F, 24.201473F, 41.0F, 24.45F, 41.0F);
      ((Path)localObject2).lineTo(32.55F, 41.0F);
      ((Path)localObject2).cubicTo(32.798527F, 41.0F, 33.0F, 41.201473F, 33.0F, 41.45F);
      ((Path)localObject2).lineTo(33.0F, 42.55F);
      ((Path)localObject2).cubicTo(33.0F, 42.798527F, 32.798527F, 43.0F, 32.55F, 43.0F);
      ((Path)localObject2).lineTo(24.45F, 43.0F);
      ((Path)localObject2).cubicTo(24.201473F, 43.0F, 24.0F, 42.798527F, 24.0F, 42.55F);
      ((Path)localObject2).lineTo(24.0F, 41.45F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(9.0F, 41.45F);
      ((Path)localObject2).cubicTo(9.0F, 41.201473F, 9.201471F, 41.0F, 9.45F, 41.0F);
      ((Path)localObject2).lineTo(17.55F, 41.0F);
      ((Path)localObject2).cubicTo(17.798527F, 41.0F, 18.0F, 41.201473F, 18.0F, 41.45F);
      ((Path)localObject2).lineTo(18.0F, 42.55F);
      ((Path)localObject2).cubicTo(18.0F, 42.798527F, 17.798527F, 43.0F, 17.55F, 43.0F);
      ((Path)localObject2).lineTo(9.45F, 43.0F);
      ((Path)localObject2).cubicTo(9.201471F, 43.0F, 9.0F, 42.798527F, 9.0F, 42.55F);
      ((Path)localObject2).lineTo(9.0F, 41.45F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.h(paramVarArgs);
      ((Path)localObject1).moveTo(43.0F, 0.45000002F);
      ((Path)localObject1).cubicTo(43.0F, 0.20147187F, 43.201473F, 0.0F, 43.45F, 0.0F);
      ((Path)localObject1).lineTo(44.55F, 0.0F);
      ((Path)localObject1).cubicTo(44.798527F, 0.0F, 45.0F, 0.20147187F, 45.0F, 0.45000002F);
      ((Path)localObject1).lineTo(45.0F, 10.55F);
      ((Path)localObject1).cubicTo(45.0F, 10.798529F, 44.798527F, 11.0F, 44.55F, 11.0F);
      ((Path)localObject1).lineTo(43.45F, 11.0F);
      ((Path)localObject1).cubicTo(43.201473F, 11.0F, 43.0F, 10.798529F, 43.0F, 10.55F);
      ((Path)localObject1).lineTo(43.0F, 0.45000002F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/jn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */