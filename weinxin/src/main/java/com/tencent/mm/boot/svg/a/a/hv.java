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

public final class hv
  extends c
{
  private final int height;
  private final int width;
  
  public hv()
  {
    GMTrace.i(18925236518912L, 141004);
    this.width = 36;
    this.height = 28;
    GMTrace.o(18925236518912L, 141004);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(18925370736640L, 141005);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(18925370736640L, 141005);
      return 0;
      GMTrace.o(18925370736640L, 141005);
      return 36;
      GMTrace.o(18925370736640L, 141005);
      return 28;
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
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.ROUND);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-10258787);
      ((Paint)localObject2).setStrokeWidth(2.0F);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -573.0F, 0.0F, 1.0F, -727.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 140.0F, 0.0F, 1.0F, 722.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 434.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      Path localPath = c.h(paramVarArgs);
      localPath.moveTo(4.5945945F, 13.324325F);
      localPath.cubicTo(4.5945945F, 6.4324327F, 10.2F, 0.827027F, 17.091892F, 0.827027F);
      localPath.cubicTo(21.962162F, 0.827027F, 26.18919F, 3.5837839F, 28.302702F, 7.718919F);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(10.383783F, 9.372973F);
      localPath.lineTo(4.5945945F, 13.324325F);
      localPath.lineTo(0.64324325F, 7.5351353F);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 5.513514F, 0.0F, 1.0F, 12.864865F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.h(paramVarArgs);
      ((Path)localObject3).moveTo(24.075676F, 0.0F);
      ((Path)localObject3).cubicTo(24.075676F, 6.891892F, 18.47027F, 12.497297F, 11.578379F, 12.497297F);
      ((Path)localObject3).cubicTo(6.708108F, 12.497297F, 2.3891892F, 9.648648F, 0.36756757F, 5.5135136F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(18.194595F, 3.9513514F);
      ((Path)localObject2).lineTo(24.075676F, 0.0F);
      ((Path)localObject2).lineTo(28.027027F, 5.881081F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/hv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */