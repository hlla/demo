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

public final class oq
  extends c
{
  private final int height;
  private final int width;
  
  public oq()
  {
    GMTrace.i(15879702052864L, 118313);
    this.width = 90;
    this.height = 90;
    GMTrace.o(15879702052864L, 118313);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15879836270592L, 118314);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15879836270592L, 118314);
      return 0;
      GMTrace.o(15879836270592L, 118314);
      return 90;
      GMTrace.o(15879836270592L, 118314);
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
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 9.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-9473160);
      ((Paint)localObject1).setStrokeWidth(3.0F);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(60.0F, 69.37356F);
      ((Path)localObject2).cubicTo(60.0F, 70.83989F, 58.791004F, 72.0F, 57.29963F, 72.0F);
      ((Path)localObject2).lineTo(2.7003715F, 72.0F);
      ((Path)localObject2).cubicTo(1.2114124F, 72.0F, 0.0F, 70.824104F, 0.0F, 69.37356F);
      ((Path)localObject2).lineTo(0.0F, 2.6264412F);
      ((Path)localObject2).cubicTo(0.0F, 1.1601105F, 1.2089975F, 0.0F, 2.7003715F, 0.0F);
      ((Path)localObject2).lineTo(41.11628F, 0.0F);
      ((Path)localObject2).lineTo(60.0F, 18.327272F);
      ((Path)localObject2).lineTo(60.0F, 69.37356F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-9473160);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(39.0F, 2.0F);
      ((Path)localObject2).lineTo(42.0F, 2.0F);
      ((Path)localObject2).lineTo(42.0F, 20.0F);
      ((Path)localObject2).lineTo(39.0F, 20.0F);
      ((Path)localObject2).lineTo(39.0F, 2.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-9473160);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(39.0F, 19.0F);
      ((Path)localObject2).lineTo(58.0F, 19.0F);
      ((Path)localObject2).lineTo(58.0F, 22.0F);
      ((Path)localObject2).lineTo(39.0F, 22.0F);
      ((Path)localObject2).lineTo(39.0F, 19.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-9473160);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(9.0F, 38.0F);
      ((Path)localObject2).lineTo(33.0F, 38.0F);
      ((Path)localObject2).lineTo(33.0F, 41.0F);
      ((Path)localObject2).lineTo(9.0F, 41.0F);
      ((Path)localObject2).lineTo(9.0F, 38.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-9473160);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(9.0F, 47.0F);
      ((Path)localObject2).lineTo(51.0F, 47.0F);
      ((Path)localObject2).lineTo(51.0F, 50.0F);
      ((Path)localObject2).lineTo(9.0F, 50.0F);
      ((Path)localObject2).lineTo(9.0F, 47.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-9473160);
      localObject1 = c.h(paramVarArgs);
      ((Path)localObject1).moveTo(9.0F, 56.0F);
      ((Path)localObject1).lineTo(51.0F, 56.0F);
      ((Path)localObject1).lineTo(51.0F, 59.0F);
      ((Path)localObject1).lineTo(9.0F, 59.0F);
      ((Path)localObject1).lineTo(9.0F, 56.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/oq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */