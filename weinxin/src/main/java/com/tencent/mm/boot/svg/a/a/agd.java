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

public final class agd
  extends c
{
  private final int height;
  private final int width;
  
  public agd()
  {
    GMTrace.i(15857153474560L, 118145);
    this.width = 30;
    this.height = 30;
    GMTrace.o(15857153474560L, 118145);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15857287692288L, 118146);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15857287692288L, 118146);
      return 0;
      GMTrace.o(15857287692288L, 118146);
      return 30;
      GMTrace.o(15857287692288L, 118146);
      return 30;
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
      localCanvas.saveLayerAlpha(null, 76, 4);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(17.0625F, 15.0F);
      ((Path)localObject).lineTo(26.0F, 6.0625F);
      ((Path)localObject).lineTo(23.9375F, 4.0F);
      ((Path)localObject).lineTo(15.0F, 12.9375F);
      ((Path)localObject).lineTo(6.0625F, 4.0F);
      ((Path)localObject).lineTo(4.0F, 6.0625F);
      ((Path)localObject).lineTo(12.9375F, 15.0F);
      ((Path)localObject).lineTo(4.0F, 23.9375F);
      ((Path)localObject).lineTo(6.0625F, 26.0F);
      ((Path)localObject).lineTo(15.0F, 17.0625F);
      ((Path)localObject).lineTo(23.9375F, 26.0F);
      ((Path)localObject).lineTo(26.0F, 23.9375F);
      ((Path)localObject).lineTo(17.0625F, 15.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/agd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */