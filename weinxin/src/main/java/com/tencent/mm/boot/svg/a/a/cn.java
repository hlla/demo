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

public final class cn
  extends c
{
  private final int height;
  private final int width;
  
  public cn()
  {
    GMTrace.i(15765348548608L, 117461);
    this.width = 47;
    this.height = 41;
    GMTrace.o(15765348548608L, 117461);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15765482766336L, 117462);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15765482766336L, 117462);
      return 0;
      GMTrace.o(15765482766336L, 117462);
      return 47;
      GMTrace.o(15765482766336L, 117462);
      return 41;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.d(paramVarArgs);
      float[] arrayOfFloat = c.c(paramVarArgs);
      Paint localPaint = c.g(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.g(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -126.0F, 0.0F, 1.0F, -1631.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 127.0F, 0.0F, 1.0F, 1631.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-10526881);
      ((Paint)localObject1).setStrokeWidth(6.0F);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(0.27375567F, 36.99819F);
      ((Path)localObject2).cubicTo(-0.9820049F, 39.20833F, 0.05327524F, 41.0F, 2.6142578F, 41.0F);
      ((Path)localObject2).lineTo(43.385742F, 41.0F);
      ((Path)localObject2).cubicTo(45.934128F, 41.0F, 46.981197F, 39.20691F, 45.726246F, 36.99819F);
      ((Path)localObject2).lineTo(25.273756F, 1.00181F);
      ((Path)localObject2).cubicTo(24.017996F, -1.2083286F, 21.981197F, -1.2069088F, 20.726244F, 1.00181F);
      ((Path)localObject2).lineTo(0.27375567F, 36.99819F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-10526881);
      localObject1 = c.h(paramVarArgs);
      ((Path)localObject1).moveTo(22.22413F, 14.0F);
      ((Path)localObject1).cubicTo(21.548061F, 14.0F, 21.041523F, 14.548094F, 21.093502F, 15.234215F);
      ((Path)localObject1).lineTo(22.120932F, 28.7963F);
      ((Path)localObject1).cubicTo(22.14619F, 29.129715F, 22.437256F, 29.4F, 22.777334F, 29.4F);
      ((Path)localObject1).lineTo(22.722666F, 29.4F);
      ((Path)localObject1).cubicTo(23.059927F, 29.4F, 23.353582F, 29.132704F, 23.379068F, 28.7963F);
      ((Path)localObject1).lineTo(24.406498F, 15.234215F);
      ((Path)localObject1).cubicTo(24.458138F, 14.552577F, 23.953125F, 14.0F, 23.27587F, 14.0F);
      ((Path)localObject1).lineTo(22.22413F, 14.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(23.0F, 35.0F);
      ((Path)localObject1).cubicTo(24.10457F, 35.0F, 25.0F, 34.10457F, 25.0F, 33.0F);
      ((Path)localObject1).cubicTo(25.0F, 31.89543F, 24.10457F, 31.0F, 23.0F, 31.0F);
      ((Path)localObject1).cubicTo(21.89543F, 31.0F, 21.0F, 31.89543F, 21.0F, 33.0F);
      ((Path)localObject1).cubicTo(21.0F, 34.10457F, 21.89543F, 35.0F, 23.0F, 35.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */