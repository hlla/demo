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

public final class qv
  extends c
{
  private final int height;
  private final int width;
  
  public qv()
  {
    GMTrace.i(15874870214656L, 118277);
    this.width = 96;
    this.height = 96;
    GMTrace.o(15874870214656L, 118277);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15875004432384L, 118278);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15875004432384L, 118278);
      return 0;
      GMTrace.o(15875004432384L, 118278);
      return 96;
      GMTrace.o(15875004432384L, 118278);
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.d(paramVarArgs);
      float[] arrayOfFloat = c.c(paramVarArgs);
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
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-1);
      Path localPath = c.h(paramVarArgs);
      localPath.moveTo(48.0F, 88.0F);
      localPath.cubicTo(70.09139F, 88.0F, 88.0F, 70.09139F, 88.0F, 48.0F);
      localPath.cubicTo(88.0F, 25.90861F, 70.09139F, 8.0F, 48.0F, 8.0F);
      localPath.cubicTo(25.90861F, 8.0F, 8.0F, 25.90861F, 8.0F, 48.0F);
      localPath.cubicTo(8.0F, 70.09139F, 25.90861F, 88.0F, 48.0F, 88.0F);
      localPath.close();
      localPath.moveTo(48.0F, 60.0F);
      localPath.cubicTo(54.62742F, 60.0F, 60.0F, 54.62742F, 60.0F, 48.0F);
      localPath.cubicTo(60.0F, 41.37258F, 54.62742F, 36.0F, 48.0F, 36.0F);
      localPath.cubicTo(41.37258F, 36.0F, 36.0F, 41.37258F, 36.0F, 48.0F);
      localPath.cubicTo(36.0F, 54.62742F, 41.37258F, 60.0F, 48.0F, 60.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 10.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-499359);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(0.0F, 2.6236634F);
      localPath.cubicTo(8.265033F, -0.6444683F, 17.53581F, -0.805361F, 25.990042F, 1.8393117F);
      localPath.cubicTo(25.980083F, 10.899578F, 25.960169F, 19.94979F, 26.0F, 29.0F);
      localPath.cubicTo(17.49598F, 20.04029F, 8.623516F, 11.452647F, 0.0F, 2.6236634F);
      localPath.lineTo(0.0F, 2.6236634F);
      localPath.lineTo(0.0F, 2.6236634F);
      localPath.lineTo(0.0F, 2.6236634F);
      localPath.lineTo(0.0F, 2.6236634F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-9676047);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 53.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(0.03728671F, 0.0F);
      localPath.cubicTo(8.154168F, 3.6518438F, 14.891579F, 10.052603F, 19.0F, 17.968275F);
      localPath.cubicTo(12.672432F, 24.30884F, 6.344863F, 30.669468F, 0.01729439F, 37.0F);
      localPath.cubicTo(0.01729439F, 24.670012F, -0.0326864F, 12.340022F, 0.03728671F, 0.0F);
      localPath.lineTo(0.03728671F, 0.0F);
      localPath.lineTo(0.03728671F, 0.0F);
      localPath.lineTo(0.03728671F, 0.0F);
      localPath.lineTo(0.03728671F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(49152);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 4.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(0.0F, 18.962732F);
      localPath.cubicTo(3.6939936F, 10.870102F, 10.040855F, 4.0662975F, 17.979437F, 0.0F);
      localPath.cubicTo(24.326298F, 6.324241F, 30.663149F, 12.648482F, 37.0F, 18.982716F);
      localPath.cubicTo(24.666666F, 18.982716F, 12.333333F, 19.03267F, 0.0F, 18.962732F);
      localPath.lineTo(0.0F, 18.962732F);
      localPath.lineTo(0.0F, 18.962732F);
      localPath.lineTo(0.0F, 18.962732F);
      localPath.lineTo(0.0F, 18.962732F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-12799249);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 47.0F, 0.0F, 1.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(-7.1054274E-15F, 26.0F);
      localPath.cubicTo(8.894916F, 17.439388F, 17.54834F, 8.640153F, 26.362759F, 0.0F);
      localPath.cubicTo(29.622887F, 8.262333F, 29.82413F, 17.538815F, 27.167728F, 26.0F);
      localPath.cubicTo(18.111818F, 25.990057F, 9.055909F, 25.980114F, -7.1054274E-15F, 26.0F);
      localPath.lineTo(-7.1054274E-15F, 26.0F);
      localPath.lineTo(-7.1054274E-15F, 26.0F);
      localPath.lineTo(-7.1054274E-15F, 26.0F);
      localPath.lineTo(-7.1054274E-15F, 26.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-1124019);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 26.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(1.8326316F, 0.01995395F);
      localPath.cubicTo(10.885068F, 0.00997698F, 19.937506F, 0.0399079F, 29.0F, 0.0F);
      localPath.cubicTo(19.977737F, 8.450499F, 11.448331F, 17.38987F, 2.5970595F, 26.0F);
      localPath.cubicTo(-0.6014681F, 17.729086F, -0.83280814F, 8.470453F, 1.8326316F, 0.01995395F);
      localPath.lineTo(1.8326316F, 0.01995395F);
      localPath.lineTo(1.8326316F, 0.01995395F);
      localPath.lineTo(1.8326316F, 0.01995395F);
      localPath.lineTo(1.8326316F, 0.01995395F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-5117108);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 36.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(0.0F, 19.053654F);
      localPath.cubicTo(6.3366494F, 12.69911F, 12.673299F, 6.354543F, 19.0F, 0.0F);
      localPath.cubicTo(18.850786F, 12.3300085F, 19.019896F, 24.669992F, 18.910471F, 37.0F);
      localPath.cubicTo(10.793194F, 33.378807F, 4.088482F, 26.94446F, 0.0F, 19.053654F);
      localPath.lineTo(0.0F, 19.053654F);
      localPath.lineTo(0.0F, 19.053654F);
      localPath.lineTo(0.0F, 19.053654F);
      localPath.lineTo(0.0F, 19.053654F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-10818218);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 26.0F, 0.0F, 1.0F, 47.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(0.0F, 7.1054274E-15F);
      localPath.cubicTo(8.487356F, 8.976492F, 17.383142F, 17.54085F, 26.0F, 26.386665F);
      localPath.cubicTo(17.7318F, 29.58322F, 8.457471F, 29.854626F, 0.01992337F, 27.160673F);
      localPath.cubicTo(0.00996169F, 18.103765F, 0.03984674F, 9.056909F, 0.0F, 7.1054274E-15F);
      localPath.lineTo(0.0F, 7.1054274E-15F);
      localPath.lineTo(0.0F, 7.1054274E-15F);
      localPath.lineTo(0.0F, 7.1054274E-15F);
      localPath.lineTo(0.0F, 7.1054274E-15F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-11083026);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 36.0F, 0.0F, 1.0F, 53.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(-7.1054274E-15F, 0.01226055F);
      ((Path)localObject2).cubicTo(12.333333F, 0.02224884F, 24.666666F, -0.0376809F, 37.0F, 0.04222542F);
      ((Path)localObject2).cubicTo(33.306007F, 8.122752F, 26.969156F, 14.944755F, 19.020563F, 19.0F);
      ((Path)localObject2).cubicTo(12.683712F, 12.667424F, 6.32684F, 6.3548245F, -7.1054274E-15F, 0.01226055F);
      ((Path)localObject2).lineTo(-7.1054274E-15F, 0.01226055F);
      ((Path)localObject2).lineTo(-7.1054274E-15F, 0.01226055F);
      ((Path)localObject2).lineTo(-7.1054274E-15F, 0.01226055F);
      ((Path)localObject2).lineTo(-7.1054274E-15F, 0.01226055F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/qv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */