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

public final class ajz
  extends c
{
  private final int height;
  private final int width;
  
  public ajz()
  {
    GMTrace.i(15801318899712L, 117729);
    this.width = 24;
    this.height = 150;
    GMTrace.o(15801318899712L, 117729);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15801453117440L, 117730);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15801453117440L, 117730);
      return 0;
      GMTrace.o(15801453117440L, 117730);
      return 24;
      GMTrace.o(15801453117440L, 117730);
      return 150;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.d(paramVarArgs);
      c.c(paramVarArgs);
      Object localObject = c.g(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      Paint localPaint = c.g(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setColor(-1644826);
      Path localPath = c.h(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(24.0F, 0.0F);
      localPath.lineTo(24.0F, 150.0F);
      localPath.lineTo(0.0F, 150.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(7.0F, 66.0F);
      ((Path)localObject).lineTo(10.0F, 66.0F);
      ((Path)localObject).lineTo(10.0F, 84.0F);
      ((Path)localObject).lineTo(7.0F, 84.0F);
      ((Path)localObject).lineTo(7.0F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.0F, 66.0F);
      ((Path)localObject).lineTo(17.0F, 66.0F);
      ((Path)localObject).lineTo(17.0F, 84.0F);
      ((Path)localObject).lineTo(14.0F, 84.0F);
      ((Path)localObject).lineTo(14.0F, 66.0F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 51, 4);
      localPaint = c.a(localPaint, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/ajz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */