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

public final class ajf
  extends c
{
  private final int height;
  private final int width;
  
  public ajf()
  {
    GMTrace.i(17571516514304L, 130918);
    this.width = 96;
    this.height = 96;
    GMTrace.o(17571516514304L, 130918);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(17571650732032L, 130919);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(17571650732032L, 130919);
      return 0;
      GMTrace.o(17571650732032L, 130919);
      return 96;
      GMTrace.o(17571650732032L, 130919);
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
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      Path localPath = c.h(paramVarArgs);
      localPath.moveTo(46.62213F, 76.7455F);
      localPath.cubicTo(46.62213F, 76.7455F, 27.0F, 57.136356F, 27.0F, 41.21418F);
      localPath.cubicTo(27.0F, 29.446882F, 36.40202F, 20.0F, 48.304348F, 20.0F);
      localPath.cubicTo(59.59798F, 20.0F, 69.0F, 29.446882F, 69.0F, 41.21418F);
      localPath.cubicTo(69.0F, 57.136356F, 49.37787F, 76.7455F, 49.37787F, 76.7455F);
      localPath.cubicTo(48.628487F, 77.53978F, 47.383106F, 77.54187F, 46.62213F, 76.7455F);
      localPath.close();
      localPath.moveTo(48.0F, 48.0905F);
      localPath.cubicTo(51.865993F, 48.0905F, 55.0F, 44.94636F, 55.0F, 41.067875F);
      localPath.cubicTo(55.0F, 37.189384F, 51.865993F, 34.04525F, 48.0F, 34.04525F);
      localPath.cubicTo(44.134007F, 34.04525F, 41.0F, 37.189384F, 41.0F, 41.067875F);
      localPath.cubicTo(41.0F, 44.94636F, 44.134007F, 48.0905F, 48.0F, 48.0905F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(46.62213F, 76.7455F);
      ((Path)localObject).cubicTo(46.62213F, 76.7455F, 27.0F, 57.136356F, 27.0F, 41.21418F);
      ((Path)localObject).cubicTo(27.0F, 29.446882F, 36.40202F, 20.0F, 48.304348F, 20.0F);
      ((Path)localObject).cubicTo(59.59798F, 20.0F, 69.0F, 29.446882F, 69.0F, 41.21418F);
      ((Path)localObject).cubicTo(69.0F, 57.136356F, 49.37787F, 76.7455F, 49.37787F, 76.7455F);
      ((Path)localObject).cubicTo(48.628487F, 77.53978F, 47.383106F, 77.54187F, 46.62213F, 76.7455F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 48.0905F);
      ((Path)localObject).cubicTo(51.865993F, 48.0905F, 55.0F, 44.94636F, 55.0F, 41.067875F);
      ((Path)localObject).cubicTo(55.0F, 37.189384F, 51.865993F, 34.04525F, 48.0F, 34.04525F);
      ((Path)localObject).cubicTo(44.134007F, 34.04525F, 41.0F, 37.189384F, 41.0F, 41.067875F);
      ((Path)localObject).cubicTo(41.0F, 44.94636F, 44.134007F, 48.0905F, 48.0F, 48.0905F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/ajf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */