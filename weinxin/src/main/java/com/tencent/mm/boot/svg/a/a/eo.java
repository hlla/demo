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

public final class eo
  extends c
{
  private final int height;
  private final int width;
  
  public eo()
  {
    GMTrace.i(15832457412608L, 117961);
    this.width = 438;
    this.height = 372;
    GMTrace.o(15832457412608L, 117961);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15832591630336L, 117962);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15832591630336L, 117962);
      return 0;
      GMTrace.o(15832591630336L, 117962);
      return 438;
      GMTrace.o(15832591630336L, 117962);
      return 372;
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
      ((Paint)localObject).setColor(-16777216);
      Path localPath = c.h(paramVarArgs);
      localPath.moveTo(133.0F, 120.0F);
      localPath.lineTo(133.0F, 45.0F);
      localPath.lineTo(305.0F, 45.0F);
      localPath.lineTo(305.0F, 318.0F);
      localPath.lineTo(133.0F, 318.0F);
      localPath.lineTo(133.0F, 225.46962F);
      localPath.lineTo(134.5F, 225.46962F);
      localPath.lineTo(134.5F, 316.5F);
      localPath.lineTo(303.5F, 316.5F);
      localPath.lineTo(303.5F, 46.5F);
      localPath.lineTo(134.5F, 46.5F);
      localPath.lineTo(134.5F, 120.0F);
      localPath.lineTo(133.0F, 120.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(120.0F, 120.0F);
      localPath.lineTo(120.0F, 21.991756F);
      localPath.cubicTo(120.0F, 13.170865F, 127.1606F, 6.0F, 135.99364F, 6.0F);
      localPath.lineTo(302.00635F, 6.0F);
      localPath.cubicTo(310.8361F, 6.0F, 318.0F, 13.159754F, 318.0F, 21.991756F);
      localPath.lineTo(318.0F, 350.00824F);
      localPath.cubicTo(318.0F, 358.82913F, 310.83942F, 366.0F, 302.00635F, 366.0F);
      localPath.lineTo(135.99364F, 366.0F);
      localPath.cubicTo(127.1639F, 366.0F, 120.0F, 358.84024F, 120.0F, 350.00824F);
      localPath.lineTo(120.0F, 225.46962F);
      localPath.lineTo(123.0F, 225.46962F);
      localPath.lineTo(123.0F, 350.00754F);
      localPath.cubicTo(123.0F, 357.18307F, 128.82472F, 363.0F, 136.00838F, 363.0F);
      localPath.lineTo(301.99164F, 363.0F);
      localPath.cubicTo(309.17596F, 363.0F, 315.0F, 357.18747F, 315.0F, 350.00754F);
      localPath.lineTo(315.0F, 21.992458F);
      localPath.cubicTo(315.0F, 14.816921F, 309.17526F, 9.0F, 301.99164F, 9.0F);
      localPath.lineTo(136.00838F, 9.0F);
      localPath.cubicTo(128.82405F, 9.0F, 123.0F, 14.812543F, 123.0F, 21.992458F);
      localPath.lineTo(123.0F, 120.0F);
      localPath.lineTo(120.0F, 120.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(206.0F, 24.0F);
      localPath.lineTo(232.0F, 24.0F);
      localPath.lineTo(232.0F, 27.0F);
      localPath.lineTo(206.0F, 27.0F);
      localPath.lineTo(206.0F, 24.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(60.651176F, 249.89926F);
      localPath.lineTo(60.595497F, 225.46962F);
      localPath.lineTo(33.888363F, 225.46962F);
      localPath.cubicTo(27.33306F, 225.46962F, 22.0F, 220.17123F, 22.0F, 213.65854F);
      localPath.lineTo(22.0F, 131.81108F);
      localPath.cubicTo(22.0F, 125.298386F, 27.33306F, 120.0F, 33.888363F, 120.0F);
      localPath.lineTo(160.11163F, 120.0F);
      localPath.cubicTo(166.66695F, 120.0F, 172.0F, 125.298386F, 172.0F, 131.81108F);
      localPath.lineTo(172.0F, 213.65854F);
      localPath.cubicTo(172.0F, 220.17123F, 166.66695F, 225.46962F, 160.11163F, 225.46962F);
      localPath.lineTo(97.138374F, 225.46962F);
      localPath.lineTo(69.358574F, 253.56952F);
      localPath.cubicTo(68.354385F, 254.50647F, 67.109116F, 254.99985F, 65.80787F, 255.0F);
      localPath.cubicTo(62.971363F, 255.0003F, 60.6581F, 252.7121F, 60.651176F, 249.89926F);
      localPath.close();
      localPath.moveTo(63.58853F, 247.54555F);
      localPath.lineTo(63.608063F, 222.6283F);
      localPath.lineTo(36.50444F, 222.48622F);
      localPath.cubicTo(28.85407F, 222.5878F, 25.13076F, 218.84735F, 25.09161F, 211.1126F);
      localPath.lineTo(25.0F, 134.37363F);
      localPath.cubicTo(25.132122F, 125.48259F, 30.013842F, 122.979996F, 36.41283F, 123.0F);
      localPath.lineTo(157.58717F, 123.0F);
      localPath.cubicTo(167.20503F, 123.0F, 169.02705F, 128.21953F, 169.0F, 134.37363F);
      localPath.lineTo(169.09161F, 211.1126F);
      localPath.cubicTo(169.11636F, 218.63168F, 166.0281F, 222.59373F, 157.67879F, 222.48622F);
      localPath.lineTo(95.95168F, 222.58171F);
      localPath.lineTo(68.555214F, 250.40294F);
      localPath.cubicTo(67.59119F, 251.30519F, 66.85377F, 251.84087F, 65.63155F, 251.84087F);
      localPath.cubicTo(63.608063F, 251.86566F, 63.595177F, 250.2542F, 63.58853F, 247.54555F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-15028967);
      localObject = c.h(paramVarArgs);
      ((Path)localObject).moveTo(97.0F, 204.0F);
      ((Path)localObject).cubicTo(115.225395F, 204.0F, 130.0F, 189.2254F, 130.0F, 171.0F);
      ((Path)localObject).cubicTo(130.0F, 152.7746F, 115.225395F, 138.0F, 97.0F, 138.0F);
      ((Path)localObject).cubicTo(78.774605F, 138.0F, 64.0F, 152.7746F, 64.0F, 171.0F);
      ((Path)localObject).cubicTo(64.0F, 189.2254F, 78.774605F, 204.0F, 97.0F, 204.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(97.0F, 201.0F);
      ((Path)localObject).cubicTo(113.56854F, 201.0F, 127.0F, 187.56854F, 127.0F, 171.0F);
      ((Path)localObject).cubicTo(127.0F, 154.43146F, 113.56854F, 141.0F, 97.0F, 141.0F);
      ((Path)localObject).cubicTo(80.43146F, 141.0F, 67.0F, 154.43146F, 67.0F, 171.0F);
      ((Path)localObject).cubicTo(67.0F, 187.56854F, 80.43146F, 201.0F, 97.0F, 201.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(82.31152F, 173.40608F);
      ((Path)localObject).cubicTo(81.86357F, 172.9451F, 81.729256F, 172.10045F, 82.01039F, 171.52182F);
      ((Path)localObject).lineTo(82.17488F, 171.18329F);
      ((Path)localObject).cubicTo(82.54736F, 170.41664F, 83.411705F, 170.20854F, 84.10319F, 170.71681F);
      ((Path)localObject).lineTo(91.037735F, 175.81412F);
      ((Path)localObject).cubicTo(91.730225F, 176.32314F, 92.825096F, 176.2897F, 93.4827F, 175.73987F);
      ((Path)localObject).lineTo(112.97404F, 159.44258F);
      ((Path)localObject).cubicTo(113.47103F, 159.02704F, 114.234566F, 159.05884F, 114.6887F, 159.52309F);
      ((Path)localObject).lineTo(114.48831F, 159.31824F);
      ((Path)localObject).cubicTo(114.9383F, 159.77824F, 114.941635F, 160.52068F, 114.4841F, 160.98842F);
      ((Path)localObject).lineTo(93.37062F, 182.57329F);
      ((Path)localObject).cubicTo(92.77469F, 183.18251F, 91.81399F, 183.1849F, 91.20749F, 182.56076F);
      ((Path)localObject).lineTo(82.31152F, 173.40608F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */