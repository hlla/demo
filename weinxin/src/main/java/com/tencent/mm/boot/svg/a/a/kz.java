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

public final class kz
  extends c
{
  private final int height;
  private final int width;
  
  public kz()
  {
    GMTrace.i(15771522564096L, 117507);
    this.width = 63;
    this.height = 63;
    GMTrace.o(15771522564096L, 117507);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15771656781824L, 117508);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15771656781824L, 117508);
      return 0;
      GMTrace.o(15771656781824L, 117508);
      return 63;
      GMTrace.o(15771656781824L, 117508);
      return 63;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.d(paramVarArgs);
      Object localObject3 = c.c(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.g(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 9.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.h(paramVarArgs);
      ((Path)localObject3).moveTo(14.0F, 33.0F);
      ((Path)localObject3).lineTo(14.0F, -1.6370905E-11F);
      ((Path)localObject3).lineTo(9.0F, -1.6370905E-11F);
      ((Path)localObject3).lineTo(9.0F, 38.0F);
      ((Path)localObject3).lineTo(13.0F, 38.0F);
      ((Path)localObject3).lineTo(51.0F, 38.0F);
      ((Path)localObject3).lineTo(51.0F, 33.0F);
      ((Path)localObject3).lineTo(14.0F, 33.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(38.0F, 13.0F);
      ((Path)localObject2).lineTo(38.0F, 46.0F);
      ((Path)localObject2).lineTo(43.0F, 46.0F);
      ((Path)localObject2).lineTo(43.0F, 8.0F);
      ((Path)localObject2).lineTo(38.5F, 8.0F);
      ((Path)localObject2).lineTo(0.0F, 8.0F);
      ((Path)localObject2).lineTo(0.0F, 13.0F);
      ((Path)localObject2).lineTo(38.0F, 13.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/kz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */