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

public final class me
  extends c
{
  private final int height;
  private final int width;
  
  public me()
  {
    GMTrace.i(15722667311104L, 117143);
    this.width = 96;
    this.height = 96;
    GMTrace.o(15722667311104L, 117143);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15722801528832L, 117144);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15722801528832L, 117144);
      return 0;
      GMTrace.o(15722801528832L, 117144);
      return 96;
      GMTrace.o(15722801528832L, 117144);
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.d(paramVarArgs);
      Object localObject2 = c.c(paramVarArgs);
      Paint localPaint = c.g(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.g(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.a((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localObject3 = c.h(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(96.0F, 0.0F);
      ((Path)localObject3).lineTo(96.0F, 96.0F);
      ((Path)localObject3).lineTo(0.0F, 96.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject2 = c.a((float[])localObject2, 0.70710677F, 0.70710677F, -19.882248F, -0.70710677F, 0.70710677F, 48.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.h(paramVarArgs);
      ((Path)localObject1).moveTo(50.0F, 24.0F);
      ((Path)localObject1).lineTo(46.0F, 24.0F);
      ((Path)localObject1).lineTo(46.0F, 46.0F);
      ((Path)localObject1).lineTo(24.0F, 46.0F);
      ((Path)localObject1).lineTo(24.0F, 50.0F);
      ((Path)localObject1).lineTo(46.0F, 50.0F);
      ((Path)localObject1).lineTo(46.0F, 72.0F);
      ((Path)localObject1).lineTo(50.0F, 72.0F);
      ((Path)localObject1).lineTo(50.0F, 50.0F);
      ((Path)localObject1).lineTo(72.0F, 50.0F);
      ((Path)localObject1).lineTo(72.0F, 46.0F);
      ((Path)localObject1).lineTo(50.0F, 46.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.saveLayerAlpha(null, 166, 4);
      localObject2 = c.a(localPaint, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/me.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */