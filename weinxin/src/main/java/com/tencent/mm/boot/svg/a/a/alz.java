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

public final class alz
  extends c
{
  private final int height;
  private final int width;
  
  public alz()
  {
    GMTrace.i(17575811481600L, 130950);
    this.width = 36;
    this.height = 42;
    GMTrace.o(17575811481600L, 130950);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(17575945699328L, 130951);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(17575945699328L, 130951);
      return 0;
      GMTrace.o(17575945699328L, 130951);
      return 36;
      GMTrace.o(17575945699328L, 130951);
      return 42;
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
      localPaint.setColor(-352965);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.h(paramVarArgs);
      localPath.moveTo(10.8F, 34.663235F);
      localPath.cubicTo(10.8F, 34.42369F, 10.99419F, 34.2295F, 11.233735F, 34.2295F);
      localPath.lineTo(24.766266F, 34.2295F);
      localPath.cubicTo(25.005812F, 34.2295F, 25.2F, 34.42369F, 25.2F, 34.663235F);
      localPath.lineTo(25.2F, 36.195766F);
      localPath.cubicTo(25.2F, 36.43531F, 25.005812F, 36.6295F, 24.766266F, 36.6295F);
      localPath.lineTo(11.233735F, 36.6295F);
      localPath.cubicTo(10.99419F, 36.6295F, 10.8F, 36.43531F, 10.8F, 36.195766F);
      localPath.lineTo(10.8F, 34.663235F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(27.390879F, 33.116867F);
      localPath.cubicTo(27.726053F, 32.8283F, 28.047869F, 32.52449F, 28.355242F, 32.206463F);
      localPath.cubicTo(30.932549F, 29.539848F, 32.4F, 25.983932F, 32.4F, 22.2F);
      localPath.cubicTo(32.4F, 14.2471F, 25.9529F, 7.8F, 18.0F, 7.8F);
      localPath.cubicTo(10.0471F, 7.8F, 3.6F, 14.2471F, 3.6F, 22.2F);
      localPath.cubicTo(3.6F, 26.00756F, 5.0859246F, 29.583832F, 7.691916F, 32.255028F);
      localPath.cubicTo(7.9839187F, 32.554337F, 8.288776F, 32.84089F, 8.605573F, 33.113808F);
      localPath.cubicTo(9.107681F, 33.546375F, 9.865385F, 33.49F, 10.297952F, 32.987892F);
      localPath.cubicTo(10.730517F, 32.485783F, 10.674143F, 31.72808F, 10.172034F, 31.295513F);
      localPath.cubicTo(9.907755F, 31.067837F, 9.653421F, 30.828775F, 9.40981F, 30.57907F);
      localPath.cubicTo(7.2368464F, 28.351734F, 6.0F, 25.374937F, 6.0F, 22.2F);
      localPath.cubicTo(6.0F, 15.572583F, 11.372583F, 10.2F, 18.0F, 10.2F);
      localPath.cubicTo(24.627417F, 10.2F, 30.0F, 15.572583F, 30.0F, 22.2F);
      localPath.cubicTo(30.0F, 25.355255F, 28.778545F, 28.315071F, 26.629532F, 30.538553F);
      localPath.cubicTo(26.373098F, 30.803873F, 26.104616F, 31.057335F, 25.825005F, 31.298063F);
      localPath.cubicTo(25.322758F, 31.730467F, 25.266136F, 32.48815F, 25.69854F, 32.990402F);
      localPath.cubicTo(26.130943F, 33.49265F, 26.88863F, 33.54927F, 27.390879F, 33.116867F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(14.451507F, 40.61775F);
      localPath.cubicTo(15.604354F, 40.785107F, 16.769964F, 40.8695F, 17.944061F, 40.8695F);
      localPath.cubicTo(19.138338F, 40.8695F, 20.323826F, 40.78218F, 21.496016F, 40.60905F);
      localPath.cubicTo(22.043661F, 40.528164F, 22.432756F, 39.931957F, 22.365084F, 39.277386F);
      localPath.cubicTo(22.29741F, 38.622814F, 21.798594F, 38.15775F, 21.250948F, 38.238636F);
      localPath.cubicTo(20.160011F, 38.399765F, 19.056368F, 38.481056F, 17.944061F, 38.481056F);
      localPath.cubicTo(16.850542F, 38.481056F, 15.7653885F, 38.40249F, 14.69244F, 38.24673F);
      localPath.cubicTo(14.144653F, 38.16721F, 13.64665F, 38.633514F, 13.580118F, 39.28825F);
      localPath.cubicTo(13.513587F, 39.94299F, 13.903721F, 40.538227F, 14.451507F, 40.61775F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(23.078135F, 25.76822F);
      localPath.cubicTo(23.50241F, 26.277353F, 24.259089F, 26.346142F, 24.76822F, 25.921865F);
      localPath.cubicTo(25.277353F, 25.49759F, 25.346142F, 24.740911F, 24.921865F, 24.23178F);
      localPath.lineTo(20.921865F, 19.431778F);
      localPath.cubicTo(20.44245F, 18.85648F, 19.559004F, 18.856F, 19.078966F, 19.430782F);
      localPath.lineTo(15.999788F, 23.117685F);
      localPath.lineTo(12.920861F, 19.432774F);
      localPath.cubicTo(12.495919F, 18.924196F, 11.739152F, 18.856396F, 11.230575F, 19.281338F);
      localPath.cubicTo(10.721997F, 19.70628F, 10.654198F, 20.463047F, 11.079139F, 20.971624F);
      localPath.lineTo(15.079139F, 25.75889F);
      localPath.cubicTo(15.558899F, 26.333075F, 16.441404F, 26.332975F, 16.921034F, 25.758682F);
      localPath.lineTo(19.998987F, 22.073246F);
      localPath.lineTo(23.078135F, 25.76822F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(16.8F, 2.6294985F);
      ((Path)localObject).cubicTo(16.8F, 1.9667568F, 17.337257F, 1.4294986F, 18.0F, 1.4294986F);
      ((Path)localObject).cubicTo(18.662743F, 1.4294986F, 19.2F, 1.9667568F, 19.2F, 2.6294985F);
      ((Path)localObject).lineTo(19.2F, 4.257601F);
      ((Path)localObject).cubicTo(19.2F, 4.920343F, 18.662743F, 5.457601F, 18.0F, 5.457601F);
      ((Path)localObject).cubicTo(17.337257F, 5.457601F, 16.8F, 4.920343F, 16.8F, 4.257601F);
      ((Path)localObject).lineTo(16.8F, 2.6294985F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(32.541836F, 9.06067F);
      ((Path)localObject).cubicTo(33.05688F, 8.643594F, 33.81252F, 8.723014F, 34.229595F, 9.238061F);
      ((Path)localObject).cubicTo(34.64667F, 9.753108F, 34.567253F, 10.508744F, 34.052204F, 10.92582F);
      ((Path)localObject).lineTo(32.78693F, 11.950418F);
      ((Path)localObject).cubicTo(32.271885F, 12.367496F, 31.516249F, 12.288075F, 31.09917F, 11.773028F);
      ((Path)localObject).cubicTo(30.682095F, 11.257981F, 30.761515F, 10.502345F, 31.276562F, 10.085268F);
      ((Path)localObject).lineTo(32.541836F, 9.06067F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(1.9477956F, 10.92582F);
      ((Path)localObject).cubicTo(1.4327486F, 10.508744F, 1.3533281F, 9.753108F, 1.7704049F, 9.238061F);
      ((Path)localObject).cubicTo(2.1874819F, 8.723014F, 2.9431176F, 8.643594F, 3.4581645F, 9.06067F);
      ((Path)localObject).lineTo(4.723438F, 10.085268F);
      ((Path)localObject).cubicTo(5.238485F, 10.502345F, 5.3179054F, 11.257981F, 4.9008284F, 11.773028F);
      ((Path)localObject).cubicTo(4.483752F, 12.288075F, 3.7281158F, 12.367496F, 3.213069F, 11.950418F);
      ((Path)localObject).lineTo(1.9477956F, 10.92582F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/alz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */