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

public final class ea
  extends c
{
  private final int height;
  private final int width;
  
  public ea()
  {
    GMTrace.i(15709782409216L, 117047);
    this.width = 168;
    this.height = 168;
    GMTrace.o(15709782409216L, 117047);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15709916626944L, 117048);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15709916626944L, 117048);
      return 0;
      GMTrace.o(15709916626944L, 117048);
      return 168;
      GMTrace.o(15709916626944L, 117048);
      return 168;
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
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-4079167);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.h(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(168.0F, 0.0F);
      localPath.lineTo(168.0F, 168.0F);
      localPath.lineTo(0.0F, 168.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localPath.moveTo(3.0F, 3.0F);
      localPath.lineTo(3.0F, 165.0F);
      localPath.lineTo(165.0F, 165.0F);
      localPath.lineTo(165.0F, 3.0F);
      localPath.lineTo(3.0F, 3.0F);
      localPath.lineTo(3.0F, 3.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-6974059);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 33.0F, 0.0F, 1.0F, 33.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(46.0F, 0.0F);
      ((Path)localObject2).lineTo(56.0F, 0.0F);
      ((Path)localObject2).lineTo(56.0F, 46.0F);
      ((Path)localObject2).lineTo(102.0F, 46.0F);
      ((Path)localObject2).lineTo(102.0F, 56.0F);
      ((Path)localObject2).lineTo(56.0F, 56.0F);
      ((Path)localObject2).lineTo(56.0F, 102.0F);
      ((Path)localObject2).lineTo(46.0F, 102.0F);
      ((Path)localObject2).lineTo(46.0F, 56.0F);
      ((Path)localObject2).lineTo(0.0F, 56.0F);
      ((Path)localObject2).lineTo(0.0F, 46.0F);
      ((Path)localObject2).lineTo(46.0F, 46.0F);
      ((Path)localObject2).lineTo(46.0F, 0.0F);
      ((Path)localObject2).lineTo(46.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/ea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */