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

public final class ew
  extends c
{
  private final int height;
  private final int width;
  
  public ew()
  {
    GMTrace.i(15890976342016L, 118397);
    this.width = 476;
    this.height = 292;
    GMTrace.o(15890976342016L, 118397);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15891110559744L, 118398);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15891110559744L, 118398);
      return 0;
      GMTrace.o(15891110559744L, 118398);
      return 476;
      GMTrace.o(15891110559744L, 118398);
      return 292;
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
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 50.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-13158344);
      Path localPath = c.h(paramVarArgs);
      localPath.moveTo(256.0F, 278.731F);
      localPath.lineTo(256.0F, 284.001F);
      localPath.lineTo(118.0F, 284.001F);
      localPath.lineTo(118.0F, 278.731F);
      localPath.lineTo(171.0F, 273.731F);
      localPath.lineTo(171.0F, 240.001F);
      localPath.lineTo(203.0F, 240.001F);
      localPath.lineTo(203.0F, 273.731F);
      localPath.lineTo(256.0F, 278.731F);
      localPath.close();
      localPath.moveTo(206.0F, 240.0F);
      localPath.lineTo(318.985F, 240.0F);
      localPath.lineTo(318.985F, 237.001F);
      localPath.lineTo(206.0F, 237.001F);
      localPath.lineTo(168.0F, 237.0F);
      localPath.lineTo(14.006F, 237.001F);
      localPath.cubicTo(7.938F, 237.001F, 3.0F, 232.063F, 3.0F, 225.994F);
      localPath.lineTo(3.0F, 14.007F);
      localPath.cubicTo(3.0F, 7.938F, 7.938F, 3.001F, 14.006F, 3.001F);
      localPath.lineTo(359.993F, 3.001F);
      localPath.cubicTo(366.063F, 3.001F, 371.0F, 7.938F, 371.0F, 14.007F);
      localPath.lineTo(371.0F, 97.39F);
      localPath.lineTo(374.0F, 97.39F);
      localPath.lineTo(374.0F, 14.007F);
      localPath.cubicTo(374.0F, 6.266F, 367.729F, 0.0F, 359.993F, 0.0F);
      localPath.lineTo(14.007F, 0.0F);
      localPath.cubicTo(6.276F, 0.0F, 0.0F, 6.271F, 0.0F, 14.007F);
      localPath.lineTo(0.0F, 225.994F);
      localPath.cubicTo(0.0F, 233.735F, 6.271F, 240.0F, 14.007F, 240.0F);
      localPath.lineTo(168.0F, 240.0F);
      localPath.lineTo(168.0F, 271.0F);
      localPath.lineTo(115.0F, 276.0F);
      localPath.lineTo(115.0F, 287.0F);
      localPath.lineTo(259.0F, 287.0F);
      localPath.lineTo(259.0F, 276.0F);
      localPath.lineTo(206.0F, 271.0F);
      localPath.lineTo(206.0F, 240.0F);
      localPath.close();
      localPath.moveTo(317.9854F, 226.0006F);
      localPath.lineTo(14.0004F, 226.0006F);
      localPath.lineTo(14.0004F, 14.0006F);
      localPath.lineTo(360.0004F, 14.0006F);
      localPath.lineTo(360.0004F, 95.3906F);
      localPath.cubicTo(360.0004F, 95.3906F, 360.9994F, 97.02239F, 360.9994F, 95.01775F);
      localPath.lineTo(360.9994F, 13.0006F);
      localPath.lineTo(12.9994F, 13.0006F);
      localPath.lineTo(12.9994F, 227.0006F);
      localPath.lineTo(317.9854F, 227.0006F);
      localPath.lineTo(317.9854F, 226.0006F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-15028967);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(127.0975F, 100.5F);
      localPath.cubicTo(125.38675F, 100.5F, 124.0F, 99.4927F, 124.0F, 98.25005F);
      localPath.cubicTo(124.0F, 97.0073F, 125.38675F, 96.0F, 127.0975F, 96.0F);
      localPath.lineTo(225.9025F, 96.0F);
      localPath.cubicTo(227.61325F, 96.0F, 229.0F, 97.0073F, 229.0F, 98.24995F);
      localPath.cubicTo(229.0F, 99.492584F, 227.61325F, 100.5F, 225.9025F, 100.5F);
      localPath.lineTo(127.0975F, 100.5F);
      localPath.close();
      localPath.moveTo(246.283F, 124.68484F);
      localPath.lineTo(127.717F, 124.68484F);
      localPath.cubicTo(125.6641F, 124.68484F, 124.0F, 123.677536F, 124.0F, 122.43489F);
      localPath.lineTo(124.0F, 122.43478F);
      localPath.cubicTo(124.0F, 121.19213F, 125.6641F, 120.18484F, 127.717F, 120.18484F);
      localPath.lineTo(246.283F, 120.18484F);
      localPath.cubicTo(248.33589F, 120.18484F, 250.0F, 121.19213F, 250.0F, 122.43478F);
      localPath.lineTo(250.0F, 122.43489F);
      localPath.cubicTo(250.0F, 123.677536F, 248.33589F, 124.68484F, 246.283F, 124.68484F);
      localPath.lineTo(246.283F, 124.68484F);
      localPath.close();
      localPath.moveTo(187.79611F, 147.77036F);
      localPath.lineTo(127.70389F, 147.77036F);
      localPath.cubicTo(125.65823F, 147.77036F, 124.0F, 146.76303F, 124.0F, 145.52036F);
      localPath.lineTo(124.0F, 145.52036F);
      localPath.cubicTo(124.0F, 144.27768F, 125.65823F, 143.27036F, 127.70389F, 143.27036F);
      localPath.lineTo(187.79611F, 143.27036F);
      localPath.cubicTo(189.84177F, 143.27036F, 191.5F, 144.27768F, 191.5F, 145.52036F);
      localPath.lineTo(191.5F, 145.52036F);
      localPath.cubicTo(191.49982F, 146.76303F, 189.84158F, 147.77036F, 187.79611F, 147.77036F);
      localPath.lineTo(187.79611F, 147.77036F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 317.0F, 0.0F, 1.0F, 96.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-13092808);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(3.0F, 183.006F);
      localPath.lineTo(3.0F, 7.994F);
      localPath.cubicTo(3.0F, 5.24F, 5.243F, 3.0F, 8.0F, 3.0F);
      localPath.lineTo(98.0F, 3.0F);
      localPath.cubicTo(100.757F, 3.0F, 103.0F, 5.24F, 103.0F, 7.994F);
      localPath.lineTo(103.0F, 183.006F);
      localPath.cubicTo(103.0F, 185.76F, 100.757F, 188.0F, 98.0F, 188.0F);
      localPath.lineTo(8.0F, 188.0F);
      localPath.cubicTo(5.243F, 188.0F, 3.0F, 185.76F, 3.0F, 183.006F);
      localPath.lineTo(3.0F, 183.006F);
      localPath.close();
      localPath.moveTo(98.0F, 191.0F);
      localPath.cubicTo(102.418F, 191.0F, 106.0F, 187.418F, 106.0F, 183.006F);
      localPath.lineTo(106.0F, 7.994F);
      localPath.cubicTo(106.0F, 3.579F, 102.412F, 0.0F, 98.0F, 0.0F);
      localPath.lineTo(8.0F, 0.0F);
      localPath.cubicTo(3.582F, 0.0F, 0.0F, 3.582F, 0.0F, 7.994F);
      localPath.lineTo(0.0F, 183.006F);
      localPath.cubicTo(0.0F, 187.421F, 3.588F, 191.0F, 8.0F, 191.0F);
      localPath.lineTo(98.0F, 191.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 35.0F, 0.0F, 1.0F, 77.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-13092808);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 7.0F, 0.0F, 1.0F, 10.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.h(paramVarArgs);
      ((Path)localObject3).moveTo(1.0F, 157.0F);
      ((Path)localObject3).lineTo(91.0F, 157.0F);
      ((Path)localObject3).lineTo(91.0F, 11.0F);
      ((Path)localObject3).lineTo(1.0F, 11.0F);
      ((Path)localObject3).lineTo(1.0F, 157.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(0.0F, 158.0F);
      ((Path)localObject3).lineTo(92.0F, 158.0F);
      ((Path)localObject3).lineTo(92.0F, 10.0F);
      ((Path)localObject3).lineTo(0.0F, 10.0F);
      ((Path)localObject3).lineTo(0.0F, 158.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(39.0F, 3.0F);
      ((Path)localObject2).lineTo(53.0F, 3.0F);
      ((Path)localObject2).lineTo(53.0F, 0.0F);
      ((Path)localObject2).lineTo(39.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/ew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */