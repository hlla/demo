package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.svg.c;

public final class ahy
  extends c
{
  private final int height;
  private final int width;
  
  public ahy()
  {
    GMTrace.i(15741457793024L, 117283);
    this.width = 210;
    this.height = 72;
    GMTrace.o(15741457793024L, 117283);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15741592010752L, 117284);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15741592010752L, 117284);
      return 0;
      GMTrace.o(15741592010752L, 117284);
      return 210;
      GMTrace.o(15741592010752L, 117284);
      return 72;
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
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-6710887);
      Path localPath = c.h(paramVarArgs);
      localPath.moveTo(0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.3725824F, 5.3725824F, 0.0F, 12.0F, 0.0F);
      localPath.lineTo(198.0F, 0.0F);
      localPath.cubicTo(204.62741F, 0.0F, 210.0F, 5.3725824F, 210.0F, 12.0F);
      localPath.lineTo(210.0F, 60.0F);
      localPath.cubicTo(210.0F, 66.62742F, 204.62741F, 72.0F, 198.0F, 72.0F);
      localPath.lineTo(12.0F, 72.0F);
      localPath.cubicTo(5.3725824F, 72.0F, 0.0F, 66.62742F, 0.0F, 60.0F);
      localPath.lineTo(0.0F, 12.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(3.0F, 11.0F);
      ((Path)localObject).cubicTo(3.0F, 6.581722F, 6.581722F, 3.0F, 11.0F, 3.0F);
      ((Path)localObject).lineTo(97.0F, 3.0F);
      ((Path)localObject).cubicTo(101.41828F, 3.0F, 105.0F, 6.581722F, 105.0F, 11.0F);
      ((Path)localObject).lineTo(105.0F, 61.0F);
      ((Path)localObject).cubicTo(105.0F, 65.41828F, 101.41828F, 69.0F, 97.0F, 69.0F);
      ((Path)localObject).lineTo(11.0F, 69.0F);
      ((Path)localObject).cubicTo(6.581722F, 69.0F, 3.0F, 65.41828F, 3.0F, 61.0F);
      ((Path)localObject).lineTo(3.0F, 11.0F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/ahy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */