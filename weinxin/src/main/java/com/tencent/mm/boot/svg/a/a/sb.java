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

public final class sb
  extends c
{
  private final int height;
  private final int width;
  
  public sb()
  {
    GMTrace.i(15701997780992L, 116989);
    this.width = 48;
    this.height = 60;
    GMTrace.o(15701997780992L, 116989);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15702131998720L, 116990);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15702131998720L, 116990);
      return 0;
      GMTrace.o(15702131998720L, 116990);
      return 48;
      GMTrace.o(15702131998720L, 116990);
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(2.0F, 55.19479F);
      ((Path)localObject).cubicTo(2.0F, 57.400494F, 3.5235274F, 58.24533F, 5.3961477F, 57.085964F);
      ((Path)localObject).lineTo(44.789597F, 32.69689F);
      ((Path)localObject).cubicTo(46.665234F, 31.535654F, 46.68837F, 29.615736F, 44.8456F, 28.411467F);
      ((Path)localObject).lineTo(5.340144F, 2.594247F);
      ((Path)localObject).cubicTo(3.4954336F, 1.3887097F, 2.0F, 2.202605F, 2.0F, 4.4052105F);
      ((Path)localObject).lineTo(2.0F, 55.19479F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/sb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */