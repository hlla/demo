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

public final class zj
  extends c
{
  private final int height;
  private final int width;
  
  public zj()
  {
    GMTrace.i(15862253748224L, 118183);
    this.width = 96;
    this.height = 96;
    GMTrace.o(15862253748224L, 118183);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15862387965952L, 118184);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15862387965952L, 118184);
      return 0;
      GMTrace.o(15862387965952L, 118184);
      return 96;
      GMTrace.o(15862387965952L, 118184);
      return 96;
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
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 21.0F, 0.0F, 1.0F, 18.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.h(paramVarArgs);
      ((Path)localObject3).moveTo(21.14F, 1.2F);
      ((Path)localObject3).cubicTo(25.04F, 0.82F, 28.99F, 0.82F, 32.89F, 1.2F);
      ((Path)localObject3).cubicTo(33.54F, 2.09F, 34.15F, 3.01F, 34.7F, 3.97F);
      ((Path)localObject3).cubicTo(40.12F, 4.19F, 45.57F, 3.66F, 50.97F, 4.21F);
      ((Path)localObject3).cubicTo(53.78F, 5.17F, 52.77F, 8.74F, 53.09F, 11.0F);
      ((Path)localObject3).lineTo(0.91F, 11.0F);
      ((Path)localObject3).cubicTo(1.23F, 8.75F, 0.21F, 5.22F, 2.98F, 4.22F);
      ((Path)localObject3).cubicTo(8.39F, 3.65F, 13.86F, 4.2F, 19.3F, 3.97F);
      ((Path)localObject3).cubicTo(19.84F, 3.0F, 20.46F, 2.07F, 21.14F, 1.2F);
      ((Path)localObject3).lineTo(21.14F, 1.2F);
      ((Path)localObject3).lineTo(21.14F, 1.2F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(38.983093F, 49.0F);
      ((Path)localObject2).lineTo(39.0F, 49.0F);
      ((Path)localObject2).lineTo(39.0F, 25.0F);
      ((Path)localObject2).lineTo(38.983974F, 25.0F);
      ((Path)localObject2).cubicTo(38.98398F, 24.998188F, 38.983982F, 24.996376F, 38.983982F, 24.994562F);
      ((Path)localObject2).cubicTo(38.983982F, 23.89054F, 38.089172F, 22.99555F, 36.985374F, 22.99555F);
      ((Path)localObject2).cubicTo(35.881573F, 22.99555F, 34.986767F, 23.89054F, 34.986767F, 24.994562F);
      ((Path)localObject2).cubicTo(34.986767F, 25.072788F, 34.99126F, 25.149965F, 35.0F, 25.22585F);
      ((Path)localObject2).lineTo(35.0F, 48.828903F);
      ((Path)localObject2).cubicTo(34.99126F, 48.904785F, 34.986767F, 48.981964F, 34.986767F, 49.06019F);
      ((Path)localObject2).cubicTo(34.986767F, 50.16421F, 35.881573F, 51.0592F, 36.985374F, 51.0592F);
      ((Path)localObject2).cubicTo(38.089172F, 51.0592F, 38.983982F, 50.16421F, 38.983982F, 49.06019F);
      ((Path)localObject2).cubicTo(38.983982F, 49.040054F, 38.983685F, 49.01999F, 38.983093F, 49.0F);
      ((Path)localObject2).lineTo(38.983093F, 49.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.983091F, 49.0F);
      ((Path)localObject2).lineTo(19.0F, 49.0F);
      ((Path)localObject2).lineTo(19.0F, 25.0F);
      ((Path)localObject2).lineTo(18.983973F, 25.0F);
      ((Path)localObject2).cubicTo(18.983978F, 24.998188F, 18.98398F, 24.996376F, 18.98398F, 24.994562F);
      ((Path)localObject2).cubicTo(18.98398F, 23.89054F, 18.089174F, 22.99555F, 16.985374F, 22.99555F);
      ((Path)localObject2).cubicTo(15.881574F, 22.99555F, 14.986767F, 23.89054F, 14.986767F, 24.994562F);
      ((Path)localObject2).cubicTo(14.986767F, 25.072788F, 14.99126F, 25.149965F, 15.0F, 25.22585F);
      ((Path)localObject2).lineTo(15.0F, 48.828903F);
      ((Path)localObject2).cubicTo(14.99126F, 48.904785F, 14.986767F, 48.981964F, 14.986767F, 49.06019F);
      ((Path)localObject2).cubicTo(14.986767F, 50.16421F, 15.881574F, 51.0592F, 16.985374F, 51.0592F);
      ((Path)localObject2).cubicTo(18.089174F, 51.0592F, 18.98398F, 50.16421F, 18.98398F, 49.06019F);
      ((Path)localObject2).cubicTo(18.98398F, 49.040054F, 18.983683F, 49.01999F, 18.983091F, 49.0F);
      ((Path)localObject2).lineTo(18.983091F, 49.0F);
      ((Path)localObject2).lineTo(18.983091F, 49.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(28.983091F, 49.0F);
      ((Path)localObject2).lineTo(29.0F, 49.0F);
      ((Path)localObject2).lineTo(29.0F, 25.0F);
      ((Path)localObject2).lineTo(28.983973F, 25.0F);
      ((Path)localObject2).cubicTo(28.983978F, 24.998188F, 28.98398F, 24.996376F, 28.98398F, 24.994562F);
      ((Path)localObject2).cubicTo(28.98398F, 23.89054F, 28.089174F, 22.99555F, 26.985374F, 22.99555F);
      ((Path)localObject2).cubicTo(25.881573F, 22.99555F, 24.986767F, 23.89054F, 24.986767F, 24.994562F);
      ((Path)localObject2).cubicTo(24.986767F, 25.072788F, 24.991259F, 25.149965F, 25.0F, 25.22585F);
      ((Path)localObject2).lineTo(25.0F, 48.828903F);
      ((Path)localObject2).cubicTo(24.991259F, 48.904785F, 24.986767F, 48.981964F, 24.986767F, 49.06019F);
      ((Path)localObject2).cubicTo(24.986767F, 50.16421F, 25.881573F, 51.0592F, 26.985374F, 51.0592F);
      ((Path)localObject2).cubicTo(28.089174F, 51.0592F, 28.98398F, 50.16421F, 28.98398F, 49.06019F);
      ((Path)localObject2).cubicTo(28.98398F, 49.040054F, 28.983683F, 49.01999F, 28.983091F, 49.0F);
      ((Path)localObject2).lineTo(28.983091F, 49.0F);
      ((Path)localObject2).lineTo(28.983091F, 49.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(47.98549F, 14.0F);
      ((Path)localObject2).cubicTo(47.965504F, 28.023064F, 48.01547F, 42.056126F, 47.9755F, 56.07919F);
      ((Path)localObject2).cubicTo(48.175358F, 57.828323F, 47.146076F, 59.987255F, 45.12748F, 59.8973F);
      ((Path)localObject2).cubicTo(33.395657F, 60.087208F, 21.653841F, 59.93728F, 9.912025F, 59.967266F);
      ((Path)localObject2).cubicTo(8.113279F, 60.207146F, 5.9747696F, 59.117687F, 6.094686F, 57.058704F);
      ((Path)localObject2).cubicTo(5.8948255F, 42.715797F, 6.084693F, 28.352901F, 6.014742F, 14.0F);
      ((Path)localObject2).lineTo(47.98549F, 14.0F);
      ((Path)localObject2).lineTo(47.98549F, 14.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/zj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */