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

public final class pq
  extends c
{
  private final int height;
  private final int width;
  
  public pq()
  {
    GMTrace.i(16262759448576L, 121167);
    this.width = 108;
    this.height = 108;
    GMTrace.o(16262759448576L, 121167);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(16262893666304L, 121168);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(16262893666304L, 121168);
      return 0;
      GMTrace.o(16262893666304L, 121168);
      return 108;
      GMTrace.o(16262893666304L, 121168);
      return 108;
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
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(49152);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 17.0F, 0.0F, 1.0F, 17.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(24.38938F, 14.313926F);
      ((Path)localObject2).lineTo(24.378096F, 14.307363F);
      ((Path)localObject2).lineTo(34.425114F, 4.2603464F);
      ((Path)localObject2).cubicTo(36.105576F, 2.5798845F, 38.822918F, 2.5798845F, 40.50338F, 4.2603464F);
      ((Path)localObject2).lineTo(50.550396F, 14.307363F);
      ((Path)localObject2).lineTo(39.609516F, 20.671665F);
      ((Path)localObject2).cubicTo(38.322353F, 21.458263F, 36.677647F, 21.458263F, 35.318974F, 20.671665F);
      ((Path)localObject2).lineTo(24.41391F, 14.328196F);
      ((Path)localObject2).lineTo(24.449606F, 26.964458F);
      ((Path)localObject2).cubicTo(24.449606F, 28.501902F, 23.627253F, 29.932081F, 22.268581F, 30.718681F);
      ((Path)localObject2).lineTo(11.291947F, 37.011475F);
      ((Path)localObject2).lineTo(7.6449876F, 23.245989F);
      ((Path)localObject2).cubicTo(7.037161F, 20.9577F, 8.395832F, 18.597902F, 10.68412F, 17.990076F);
      ((Path)localObject2).lineTo(24.38938F, 14.313926F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(24.41391F, 59.658997F);
      ((Path)localObject2).lineTo(35.318974F, 53.31553F);
      ((Path)localObject2).cubicTo(36.677647F, 52.52893F, 38.322353F, 52.52893F, 39.64527F, 53.31553F);
      ((Path)localObject2).lineTo(50.586147F, 59.67983F);
      ((Path)localObject2).lineTo(40.50338F, 69.726845F);
      ((Path)localObject2).cubicTo(38.822918F, 71.40731F, 36.105576F, 71.40731F, 34.425114F, 69.726845F);
      ((Path)localObject2).lineTo(24.378096F, 59.67983F);
      ((Path)localObject2).lineTo(24.38938F, 59.673267F);
      ((Path)localObject2).lineTo(10.68412F, 55.997116F);
      ((Path)localObject2).cubicTo(8.395832F, 55.38929F, 7.037161F, 53.02949F, 7.6449876F, 50.741203F);
      ((Path)localObject2).lineTo(11.327702F, 37.011475F);
      ((Path)localObject2).lineTo(22.304335F, 43.304268F);
      ((Path)localObject2).cubicTo(23.627253F, 44.05511F, 24.449606F, 45.48529F, 24.449606F, 47.022736F);
      ((Path)localObject2).lineTo(24.41391F, 59.658997F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(52.695663F, 43.268513F);
      ((Path)localObject2).lineTo(63.6723F, 36.97572F);
      ((Path)localObject2).lineTo(67.35501F, 50.70545F);
      ((Path)localObject2).cubicTo(67.96284F, 52.993736F, 66.604164F, 55.353535F, 64.31588F, 55.96136F);
      ((Path)localObject2).lineTo(50.586147F, 59.644077F);
      ((Path)localObject2).lineTo(50.550396F, 46.98698F);
      ((Path)localObject2).cubicTo(50.51464F, 45.48529F, 51.336994F, 44.05511F, 52.695663F, 43.268513F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(50.550396F, 26.964458F);
      ((Path)localObject2).lineTo(50.586147F, 14.307363F);
      ((Path)localObject2).lineTo(64.31588F, 17.990076F);
      ((Path)localObject2).cubicTo(66.604164F, 18.597902F, 67.96284F, 20.9577F, 67.35501F, 23.245989F);
      ((Path)localObject2).lineTo(63.6723F, 36.97572F);
      ((Path)localObject2).lineTo(52.695663F, 30.682926F);
      ((Path)localObject2).cubicTo(51.336994F, 29.932081F, 50.51464F, 28.501902F, 50.550396F, 26.964458F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/pq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */