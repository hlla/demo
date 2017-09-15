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

public final class adm
  extends c
{
  private final int height;
  private final int width;
  
  public adm()
  {
    GMTrace.i(15813666930688L, 117821);
    this.width = 63;
    this.height = 63;
    GMTrace.o(15813666930688L, 117821);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15813801148416L, 117822);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15813801148416L, 117822);
      return 0;
      GMTrace.o(15813801148416L, 117822);
      return 63;
      GMTrace.o(15813801148416L, 117822);
      return 63;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.d(paramVarArgs);
      Object localObject3 = c.c(paramVarArgs);
      Paint localPaint = c.g(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.g(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 9.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.h(paramVarArgs);
      ((Path)localObject3).moveTo(13.508636F, 0.0F);
      ((Path)localObject3).cubicTo(12.67544F, 0.0F, 12.0F, 0.6709508F, 12.0F, 1.5062541F);
      ((Path)localObject3).lineTo(12.0F, 4.342712F);
      ((Path)localObject3).cubicTo(12.0F, 5.174593F, 12.66642F, 5.8489656F, 13.508636F, 5.8489656F);
      ((Path)localObject3).lineTo(27.491364F, 5.8489656F);
      ((Path)localObject3).cubicTo(28.32456F, 5.8489656F, 29.0F, 5.178015F, 29.0F, 4.342712F);
      ((Path)localObject3).lineTo(29.0F, 1.5062541F);
      ((Path)localObject3).cubicTo(29.0F, 0.6743729F, 28.33358F, 0.0F, 27.491364F, 0.0F);
      ((Path)localObject3).lineTo(13.508636F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      ((Paint)localObject1).setStrokeWidth(10.0F);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(3.0F, 7.0F);
      ((Path)localObject2).cubicTo(3.0F, 5.8954306F, 3.8954306F, 5.0F, 5.0F, 5.0F);
      ((Path)localObject2).lineTo(36.0F, 5.0F);
      ((Path)localObject2).cubicTo(37.10457F, 5.0F, 38.0F, 5.8954306F, 38.0F, 7.0F);
      ((Path)localObject2).lineTo(38.0F, 44.0F);
      ((Path)localObject2).cubicTo(38.0F, 45.10457F, 37.10457F, 46.0F, 36.0F, 46.0F);
      ((Path)localObject2).lineTo(5.0F, 46.0F);
      ((Path)localObject2).cubicTo(3.8954306F, 46.0F, 3.0F, 45.10457F, 3.0F, 44.0F);
      ((Path)localObject2).lineTo(3.0F, 7.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(14.0F, 16.0F);
      ((Path)localObject2).cubicTo(14.0F, 15.447715F, 14.447715F, 15.0F, 15.0F, 15.0F);
      ((Path)localObject2).lineTo(16.0F, 15.0F);
      ((Path)localObject2).cubicTo(16.552284F, 15.0F, 17.0F, 15.447715F, 17.0F, 16.0F);
      ((Path)localObject2).lineTo(17.0F, 34.0F);
      ((Path)localObject2).cubicTo(17.0F, 34.552284F, 16.552284F, 35.0F, 16.0F, 35.0F);
      ((Path)localObject2).lineTo(15.0F, 35.0F);
      ((Path)localObject2).cubicTo(14.447715F, 35.0F, 14.0F, 34.552284F, 14.0F, 34.0F);
      ((Path)localObject2).lineTo(14.0F, 16.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 16.0F);
      ((Path)localObject2).cubicTo(24.0F, 15.447715F, 24.447716F, 15.0F, 25.0F, 15.0F);
      ((Path)localObject2).lineTo(26.0F, 15.0F);
      ((Path)localObject2).cubicTo(26.552284F, 15.0F, 27.0F, 15.447715F, 27.0F, 16.0F);
      ((Path)localObject2).lineTo(27.0F, 34.0F);
      ((Path)localObject2).cubicTo(27.0F, 34.552284F, 26.552284F, 35.0F, 26.0F, 35.0F);
      ((Path)localObject2).lineTo(25.0F, 35.0F);
      ((Path)localObject2).cubicTo(24.447716F, 35.0F, 24.0F, 34.552284F, 24.0F, 34.0F);
      ((Path)localObject2).lineTo(24.0F, 16.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject1 = c.h(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 6.5F);
      ((Path)localObject1).cubicTo(0.0F, 5.6715727F, 0.6715728F, 5.0F, 1.5F, 5.0F);
      ((Path)localObject1).lineTo(39.5F, 5.0F);
      ((Path)localObject1).cubicTo(40.328426F, 5.0F, 41.0F, 5.6715727F, 41.0F, 6.5F);
      ((Path)localObject1).lineTo(41.0F, 6.5F);
      ((Path)localObject1).cubicTo(41.0F, 7.3284273F, 40.328426F, 8.0F, 39.5F, 8.0F);
      ((Path)localObject1).lineTo(1.5F, 8.0F);
      ((Path)localObject1).cubicTo(0.6715728F, 8.0F, 0.0F, 7.3284273F, 0.0F, 6.5F);
      ((Path)localObject1).lineTo(0.0F, 6.5F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/adm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */