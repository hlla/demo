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

public final class aam
  extends c
{
  private final int height;
  private final int width;
  
  public aam()
  {
    GMTrace.i(15848295104512L, 118079);
    this.width = 66;
    this.height = 80;
    GMTrace.o(15848295104512L, 118079);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15848429322240L, 118080);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15848429322240L, 118080);
      return 0;
      GMTrace.o(15848429322240L, 118080);
      return 66;
      GMTrace.o(15848429322240L, 118080);
      return 80;
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
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8617594);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -416.0F, 0.0F, 1.0F, -1269.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(482.0F, 1311.7202F);
      ((Path)localObject2).lineTo(482.0F, 1271.9901F);
      ((Path)localObject2).cubicTo(482.0F, 1270.3384F, 480.65353F, 1269.0F, 478.9926F, 1269.0F);
      ((Path)localObject2).lineTo(419.0074F, 1269.0F);
      ((Path)localObject2).cubicTo(417.3483F, 1269.0F, 416.0F, 1270.3387F, 416.0F, 1271.9901F);
      ((Path)localObject2).lineTo(416.0F, 1346.0099F);
      ((Path)localObject2).cubicTo(416.0F, 1347.6616F, 417.34647F, 1349.0F, 419.0074F, 1349.0F);
      ((Path)localObject2).lineTo(478.9926F, 1349.0F);
      ((Path)localObject2).cubicTo(480.6517F, 1349.0F, 482.0F, 1347.6613F, 482.0F, 1346.0099F);
      ((Path)localObject2).lineTo(482.0F, 1316.9371F);
      ((Path)localObject2).lineTo(449.52548F, 1336.6007F);
      ((Path)localObject2).lineTo(449.2816F, 1336.748F);
      ((Path)localObject2).cubicTo(448.97964F, 1336.9077F, 448.63965F, 1337.0F, 448.2788F, 1337.0F);
      ((Path)localObject2).cubicTo(447.44376F, 1337.0F, 446.71753F, 1336.517F, 446.33582F, 1335.8048F);
      ((Path)localObject2).lineTo(446.18982F, 1335.4691F);
      ((Path)localObject2).lineTo(440.107F, 1321.471F);
      ((Path)localObject2).cubicTo(440.0408F, 1321.3179F, 440.0F, 1321.1458F, 440.0F, 1320.9784F);
      ((Path)localObject2).cubicTo(440.0F, 1320.3337F, 440.49866F, 1319.8098F, 441.1143F, 1319.8098F);
      ((Path)localObject2).cubicTo(441.36453F, 1319.8098F, 441.59482F, 1319.8964F, 441.7807F, 1320.0417F);
      ((Path)localObject2).lineTo(448.9588F, 1325.4017F);
      ((Path)localObject2).cubicTo(449.48376F, 1325.7621F, 450.11026F, 1325.9731F, 450.78394F, 1325.9731F);
      ((Path)localObject2).cubicTo(451.18558F, 1325.9731F, 451.5691F, 1325.8942F, 451.92633F, 1325.7583F);
      ((Path)localObject2).lineTo(482.0F, 1311.7202F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(428.0F, 1294.5F);
      ((Path)localObject2).lineTo(452.0F, 1294.5F);
      ((Path)localObject2).lineTo(452.0F, 1299.0F);
      ((Path)localObject2).lineTo(428.0F, 1299.0F);
      ((Path)localObject2).lineTo(428.0F, 1294.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(428.0F, 1281.0F);
      ((Path)localObject2).lineTo(452.0F, 1281.0F);
      ((Path)localObject2).lineTo(452.0F, 1285.5F);
      ((Path)localObject2).lineTo(428.0F, 1285.5F);
      ((Path)localObject2).lineTo(428.0F, 1281.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/aam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */