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

public final class up
  extends c
{
  private final int height;
  private final int width;
  
  public up()
  {
    GMTrace.i(15806687608832L, 117769);
    this.width = 96;
    this.height = 96;
    GMTrace.o(15806687608832L, 117769);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15806821826560L, 117770);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15806821826560L, 117770);
      return 0;
      GMTrace.o(15806821826560L, 117770);
      return 96;
      GMTrace.o(15806821826560L, 117770);
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(31.0F, 26.001389F);
      ((Path)localObject).cubicTo(31.0F, 24.896053F, 31.895857F, 24.0F, 32.99739F, 24.0F);
      ((Path)localObject).lineTo(38.00261F, 24.0F);
      ((Path)localObject).cubicTo(39.105736F, 24.0F, 40.0F, 24.894938F, 40.0F, 26.001389F);
      ((Path)localObject).lineTo(40.0F, 69.99861F);
      ((Path)localObject).cubicTo(40.0F, 71.10395F, 39.10414F, 72.0F, 38.00261F, 72.0F);
      ((Path)localObject).lineTo(32.99739F, 72.0F);
      ((Path)localObject).cubicTo(31.894262F, 72.0F, 31.0F, 71.105064F, 31.0F, 69.99861F);
      ((Path)localObject).lineTo(31.0F, 26.001389F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(56.0F, 26.001389F);
      ((Path)localObject).cubicTo(56.0F, 24.896053F, 56.89586F, 24.0F, 57.99739F, 24.0F);
      ((Path)localObject).lineTo(63.00261F, 24.0F);
      ((Path)localObject).cubicTo(64.105736F, 24.0F, 65.0F, 24.894938F, 65.0F, 26.001389F);
      ((Path)localObject).lineTo(65.0F, 69.99861F);
      ((Path)localObject).cubicTo(65.0F, 71.10395F, 64.10414F, 72.0F, 63.00261F, 72.0F);
      ((Path)localObject).lineTo(57.99739F, 72.0F);
      ((Path)localObject).cubicTo(56.894264F, 72.0F, 56.0F, 71.105064F, 56.0F, 69.99861F);
      ((Path)localObject).lineTo(56.0F, 26.001389F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/up.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */