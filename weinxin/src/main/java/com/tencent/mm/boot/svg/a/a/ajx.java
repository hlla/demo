package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class ajx
  extends c
{
  private final int height;
  private final int width;
  
  public ajx()
  {
    GMTrace.i(15786286514176L, 117617);
    this.width = 96;
    this.height = 96;
    GMTrace.o(15786286514176L, 117617);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15786420731904L, 117618);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15786420731904L, 117618);
      return 0;
      GMTrace.o(15786420731904L, 117618);
      return 96;
      GMTrace.o(15786420731904L, 117618);
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.d(paramVarArgs);
      c.c(paramVarArgs);
      Paint localPaint = c.g(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.g(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-12799249);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(85.09563F, 39.728813F);
      ((Path)localObject).lineTo(69.08572F, 39.728813F);
      ((Path)localObject).lineTo(69.08572F, 35.441456F);
      ((Path)localObject).cubicTo(69.08572F, 34.95495F, 68.989655F, 34.49417F, 68.833855F, 34.064964F);
      ((Path)localObject).cubicTo(72.43834F, 32.391422F, 74.942856F, 28.754305F, 74.942856F, 24.525423F);
      ((Path)localObject).cubicTo(74.942856F, 18.711882F, 70.223175F, 14.0F, 64.4F, 14.0F);
      ((Path)localObject).cubicTo(58.576828F, 14.0F, 53.857143F, 18.711882F, 53.857143F, 24.525423F);
      ((Path)localObject).cubicTo(53.857143F, 28.755474F, 56.361656F, 32.392593F, 59.966145F, 34.064964F);
      ((Path)localObject).cubicTo(59.810345F, 34.49417F, 59.714287F, 34.95495F, 59.714287F, 35.441456F);
      ((Path)localObject).lineTo(59.714287F, 39.728813F);
      ((Path)localObject).lineTo(36.285713F, 39.728813F);
      ((Path)localObject).lineTo(36.285713F, 35.441456F);
      ((Path)localObject).cubicTo(36.285713F, 34.95495F, 36.189655F, 34.49417F, 36.033855F, 34.064964F);
      ((Path)localObject).cubicTo(39.638344F, 32.391422F, 42.142857F, 28.754305F, 42.142857F, 24.525423F);
      ((Path)localObject).cubicTo(42.142857F, 18.711882F, 37.423172F, 14.0F, 31.6F, 14.0F);
      ((Path)localObject).cubicTo(25.776829F, 14.0F, 21.057142F, 18.711882F, 21.057142F, 24.525423F);
      ((Path)localObject).cubicTo(21.057142F, 28.755474F, 23.561657F, 32.392593F, 27.166143F, 34.064964F);
      ((Path)localObject).cubicTo(27.010344F, 34.49417F, 26.914286F, 34.95495F, 26.914286F, 35.441456F);
      ((Path)localObject).lineTo(26.914286F, 39.728813F);
      ((Path)localObject).lineTo(10.904371F, 39.728813F);
      ((Path)localObject).cubicTo(8.747771F, 39.728813F, 7.0F, 41.561405F, 7.0F, 43.822033F);
      ((Path)localObject).cubicTo(7.0F, 46.08383F, 8.747771F, 47.915253F, 10.904371F, 47.915253F);
      ((Path)localObject).lineTo(26.914286F, 47.915253F);
      ((Path)localObject).lineTo(26.914286F, 50.575848F);
      ((Path)localObject).lineTo(12.7154F, 76.53739F);
      ((Path)localObject).cubicTo(11.685715F, 78.41793F, 12.2972F, 80.82591F, 14.080114F, 81.91354F);
      ((Path)localObject).cubicTo(15.863029F, 83.0F, 18.142628F, 82.35444F, 19.172314F, 80.4739F);
      ((Path)localObject).lineTo(31.115028F, 58.64066F);
      ((Path)localObject).lineTo(43.654F, 80.4739F);
      ((Path)localObject).cubicTo(44.550144F, 82.03283F, 46.345943F, 82.72517F, 48.00117F, 82.30415F);
      ((Path)localObject).cubicTo(49.655228F, 82.72517F, 51.451027F, 82.03283F, 52.34717F, 80.4739F);
      ((Path)localObject).lineTo(64.88615F, 58.64066F);
      ((Path)localObject).lineTo(76.82886F, 80.4739F);
      ((Path)localObject).cubicTo(77.85854F, 82.35444F, 80.13697F, 83.0F, 81.922226F, 81.91354F);
      ((Path)localObject).cubicTo(83.70397F, 80.82591F, 84.31546F, 78.4191F, 83.285774F, 76.53739F);
      ((Path)localObject).lineTo(69.08688F, 50.578186F);
      ((Path)localObject).lineTo(69.08688F, 47.915253F);
      ((Path)localObject).lineTo(85.0968F, 47.915253F);
      ((Path)localObject).cubicTo(87.2534F, 47.915253F, 89.001175F, 46.08383F, 89.001175F, 43.822033F);
      ((Path)localObject).cubicTo(89.0F, 41.561405F, 87.25223F, 39.728813F, 85.09563F, 39.728813F);
      ((Path)localObject).lineTo(85.09563F, 39.728813F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(47.99883F, 72.30032F);
      ((Path)localObject).lineTo(36.213085F, 51.776917F);
      ((Path)localObject).cubicTo(36.2576F, 51.536F, 36.285713F, 51.289238F, 36.285713F, 51.034286F);
      ((Path)localObject).lineTo(36.285713F, 47.915253F);
      ((Path)localObject).lineTo(59.714287F, 47.915253F);
      ((Path)localObject).lineTo(59.714287F, 51.034286F);
      ((Path)localObject).cubicTo(59.714287F, 51.289238F, 59.74123F, 51.536F, 59.786915F, 51.776917F);
      ((Path)localObject).lineTo(47.99883F, 72.30032F);
      ((Path)localObject).lineTo(47.99883F, 72.30032F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/ajx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */