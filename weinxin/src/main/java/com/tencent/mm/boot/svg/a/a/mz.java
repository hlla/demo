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

public final class mz
  extends c
{
  private final int height;
  private final int width;
  
  public mz()
  {
    GMTrace.i(15847489798144L, 118073);
    this.width = 60;
    this.height = 60;
    GMTrace.o(15847489798144L, 118073);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15847624015872L, 118074);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15847624015872L, 118074);
      return 0;
      GMTrace.o(15847624015872L, 118074);
      return 60;
      GMTrace.o(15847624015872L, 118074);
      return 60;
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
      localPaint.setColor(-16216826);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.h(paramVarArgs);
      localPath.moveTo(27.52F, 0.0F);
      localPath.lineTo(32.07F, 0.0F);
      localPath.cubicTo(46.45F, 0.9F, 58.83F, 13.19F, 60.0F, 27.52F);
      localPath.lineTo(60.0F, 32.08F);
      localPath.cubicTo(59.09F, 46.46F, 46.8F, 58.83F, 32.48F, 60.0F);
      localPath.lineTo(27.93F, 60.0F);
      localPath.cubicTo(13.55F, 59.1F, 1.17F, 46.81F, 0.0F, 32.48F);
      localPath.lineTo(0.0F, 27.93F);
      localPath.cubicTo(0.9F, 13.55F, 13.2F, 1.17F, 27.52F, 0.0F);
      localPath.lineTo(27.52F, 0.0F);
      localPath.lineTo(27.52F, 0.0F);
      localPath.close();
      localPath.moveTo(24.383501F, 3.6703784F);
      localPath.cubicTo(11.597891F, 6.255954F, 1.8089068F, 19.054052F, 3.117434F, 32.111706F);
      localPath.cubicTo(3.9265237F, 46.387276F, 17.730988F, 58.336826F, 32.024902F, 56.879322F);
      localPath.cubicTo(46.738342F, 56.09067F, 58.884674F, 41.515614F, 56.75707F, 26.890642F);
      localPath.cubicTo(55.318687F, 11.726592F, 39.286728F, 0.026614152F, 24.383501F, 3.6703784F);
      localPath.lineTo(24.383501F, 3.6703784F);
      localPath.lineTo(24.383501F, 3.6703784F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(25.0F, 15.0F);
      localPath.lineTo(36.0F, 15.0F);
      localPath.lineTo(36.0F, 31.0F);
      localPath.lineTo(25.0F, 31.0F);
      localPath.lineTo(25.0F, 15.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(14.176433F, 30.047743F);
      ((Path)localObject).lineTo(30.5319F, 46.112846F);
      ((Path)localObject).lineTo(46.914062F, 30.035374F);
      ((Path)localObject).lineTo(14.176433F, 30.047743F);
      ((Path)localObject).lineTo(14.176433F, 30.047743F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/mz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */