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

public final class ahj
  extends c
{
  private final int height;
  private final int width;
  
  public ahj()
  {
    GMTrace.i(17581717061632L, 130994);
    this.width = 42;
    this.height = 42;
    GMTrace.o(17581717061632L, 130994);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(17581851279360L, 130995);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(17581851279360L, 130995);
      return 0;
      GMTrace.o(17581851279360L, 130995);
      return 42;
      GMTrace.o(17581851279360L, 130995);
      return 42;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.d(paramVarArgs);
      Object localObject2 = c.c(paramVarArgs);
      Object localObject3 = c.g(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Paint localPaint = c.g(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localObject3 = c.a((Paint)localObject3, paramVarArgs);
      localPaint = c.a(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-4210753);
      localPaint.setColor(-4210753);
      localPaint.setStrokeWidth(0.5F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject3, paramVarArgs);
      localObject2 = c.a(localPaint, paramVarArgs);
      localObject3 = c.h(paramVarArgs);
      ((Path)localObject3).moveTo(29.854729F, 0.0F);
      ((Path)localObject3).cubicTo(27.832062F, 0.0F, 25.850395F, 0.525641F, 24.12419F, 1.5180513F);
      ((Path)localObject3).cubicTo(20.998728F, 3.3157437F, 19.132702F, 6.3665643F, 19.132702F, 9.679153F);
      ((Path)localObject3).lineTo(19.132702F, 26.694155F);
      ((Path)localObject3).cubicTo(19.132702F, 30.740538F, 15.359652F, 34.032104F, 10.722446F, 34.032104F);
      ((Path)localObject3).cubicTo(6.08419F, 34.032104F, 2.3111384F, 30.740538F, 2.3111384F, 26.694155F);
      ((Path)localObject3).cubicTo(2.3111384F, 23.83782F, 4.3054204F, 21.619616F, 7.114446F, 19.943872F);
      ((Path)localObject3).cubicTo(7.6916F, 19.600103F, 9.215959F, 18.792717F, 9.414651F, 18.448948F);
      ((Path)localObject3).cubicTo(9.431472F, 18.419514F, 9.434626F, 18.381666F, 9.447241F, 18.349077F);
      ((Path)localObject3).cubicTo(9.5302925F, 18.199795F, 9.591267F, 18.037897F, 9.591267F, 17.854975F);
      ((Path)localObject3).cubicTo(9.591267F, 17.287283F, 9.130805F, 16.82682F, 8.563113F, 16.82682F);
      ((Path)localObject3).cubicTo(8.337088F, 16.82682F, 8.118421F, 16.893051F, 7.9249845F, 16.992924F);
      ((Path)localObject3).cubicTo(7.801985F, 17.021307F, 7.6916F, 17.061256F, 7.607497F, 17.102257F);
      ((Path)localObject3).cubicTo(5.511241F, 18.135666F, 2.6443949F, 19.871334F, 1.310318F, 22.071667F);
      ((Path)localObject3).cubicTo(0.4524718F, 23.487743F, 4.2051284E-4F, 25.086744F, 4.2051284E-4F, 26.694155F);
      ((Path)localObject3).cubicTo(4.2051284E-4F, 32.03046F, 4.8089848F, 36.372257F, 10.722446F, 36.372257F);
      ((Path)localObject3).cubicTo(12.7430105F, 36.372257F, 14.724677F, 35.847668F, 16.452984F, 34.856308F);
      ((Path)localObject3).cubicTo(19.578445F, 33.057564F, 21.44342F, 30.005692F, 21.44342F, 26.694155F);
      ((Path)localObject3).lineTo(21.44342F, 9.679153F);
      ((Path)localObject3).cubicTo(21.44342F, 5.632769F, 25.217524F, 2.3422563F, 29.854729F, 2.3422563F);
      ((Path)localObject3).cubicTo(34.492985F, 2.3422563F, 38.267086F, 5.632769F, 38.267086F, 9.679153F);
      ((Path)localObject3).cubicTo(38.267086F, 12.642718F, 36.247574F, 15.298257F, 33.077957F, 16.458872F);
      ((Path)localObject3).cubicTo(32.311573F, 16.717487F, 31.451626F, 16.904615F, 30.964882F, 17.325129F);
      ((Path)localObject3).cubicTo(30.664215F, 17.524872F, 30.452908F, 17.850769F, 30.452908F, 18.239744F);
      ((Path)localObject3).cubicTo(30.452908F, 18.856846F, 31.021652F, 19.286821F, 31.638754F, 19.286821F);
      ((Path)localObject3).cubicTo(31.79855F, 19.286821F, 31.943626F, 19.256332F, 32.072933F, 19.20377F);
      ((Path)localObject3).cubicTo(32.330498F, 19.16382F, 32.62801F, 19.03346F, 32.927624F, 18.948307F);
      ((Path)localObject3).lineTo(33.138935F, 18.88418F);
      ((Path)localObject3).cubicTo(35.761883F, 18.119898F, 37.936985F, 16.49146F, 39.265804F, 14.299539F);
      ((Path)localObject3).cubicTo(40.124702F, 12.886616F, 40.576756F, 11.288667F, 40.576756F, 9.679153F);
      ((Path)localObject3).cubicTo(40.576756F, 4.341795F, 35.76714F, 0.0F, 29.854729F, 0.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/ahj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */