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
import com.tencent.mm.svg.c;

public final class alh
  extends c
{
  private final int height;
  private final int width;
  
  public alh()
  {
    GMTrace.i(15861180006400L, 118175);
    this.width = 90;
    this.height = 90;
    GMTrace.o(15861180006400L, 118175);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15861314224128L, 118176);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15861314224128L, 118176);
      return 0;
      GMTrace.o(15861314224128L, 118176);
      return 90;
      GMTrace.o(15861314224128L, 118176);
      return 90;
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
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      Paint localPaint3 = c.a(localPaint1, paramVarArgs);
      localPaint3.setColor(-7829368);
      Path localPath = c.h(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(90.0F, 0.0F);
      localPath.lineTo(90.0F, 90.0F);
      localPath.lineTo(0.0F, 90.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 25.0F, 0.0F, 1.0F, 17.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      ((Paint)localObject1).setStrokeWidth(4.0F);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(40.0F, 50.0F);
      ((Path)localObject2).cubicTo(40.0F, 51.162144F, 39.16621F, 52.0F, 38.0F, 52.0F);
      ((Path)localObject2).lineTo(2.0F, 52.0F);
      ((Path)localObject2).cubicTo(0.83545685F, 52.0F, 0.0F, 51.15074F, 0.0F, 50.0F);
      ((Path)localObject2).lineTo(0.0F, 2.0F);
      ((Path)localObject2).cubicTo(0.0F, 0.8378576F, 0.8337914F, 0.0F, 2.0F, 0.0F);
      ((Path)localObject2).lineTo(27.0F, 0.0F);
      ((Path)localObject2).lineTo(40.0F, 13.0F);
      ((Path)localObject2).lineTo(40.0F, 50.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(23.0F, 0.0F);
      ((Path)localObject2).lineTo(27.0F, 0.0F);
      ((Path)localObject2).lineTo(27.0F, 16.0F);
      ((Path)localObject2).lineTo(23.0F, 16.0F);
      ((Path)localObject2).lineTo(23.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.h(paramVarArgs);
      ((Path)localObject1).moveTo(23.0F, 13.0F);
      ((Path)localObject1).lineTo(40.0F, 13.0F);
      ((Path)localObject1).lineTo(40.0F, 17.0F);
      ((Path)localObject1).lineTo(23.0F, 17.0F);
      ((Path)localObject1).lineTo(23.0F, 13.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/alh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */