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

public final class kh
  extends c
{
  private final int height;
  private final int width;
  
  public kh()
  {
    GMTrace.i(15782259982336L, 117587);
    this.width = 428;
    this.height = 292;
    GMTrace.o(15782259982336L, 117587);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15782394200064L, 117588);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15782394200064L, 117588);
      return 0;
      GMTrace.o(15782394200064L, 117588);
      return 428;
      GMTrace.o(15782394200064L, 117588);
      return 292;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.d(paramVarArgs);
      float[] arrayOfFloat = c.c(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.g(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-13158344);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Object localObject3 = c.a(localPaint, paramVarArgs);
      Path localPath = c.h(paramVarArgs);
      localPath.moveTo(374.0F, 14.0003F);
      localPath.cubicTo(374.0F, 6.2703F, 367.729F, 3.0E-4F, 359.993F, 3.0E-4F);
      localPath.lineTo(14.007F, 3.0E-4F);
      localPath.cubicTo(6.276F, 3.0E-4F, 0.0F, 6.2683F, 0.0F, 14.0003F);
      localPath.lineTo(0.0F, 234.0013F);
      localPath.cubicTo(0.0F, 241.7303F, 6.271F, 248.0003F, 14.007F, 248.0003F);
      localPath.lineTo(316.0F, 248.0003F);
      localPath.lineTo(316.0F, 245.0013F);
      localPath.lineTo(14.007F, 245.0013F);
      localPath.cubicTo(7.938F, 245.0013F, 3.0F, 240.0663F, 3.0F, 234.0013F);
      localPath.lineTo(3.0F, 199.0003F);
      localPath.lineTo(3.0F, 196.0003F);
      localPath.lineTo(3.0F, 14.0003F);
      localPath.cubicTo(3.0F, 7.9353F, 7.938F, 3.0013F, 14.007F, 3.0013F);
      localPath.lineTo(359.993F, 3.0013F);
      localPath.cubicTo(366.063F, 3.0013F, 371.0F, 7.9353F, 371.0F, 14.0003F);
      localPath.lineTo(371.0F, 97.0003F);
      localPath.lineTo(374.0F, 97.0003F);
      localPath.lineTo(374.0F, 14.0003F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject3 = c.h(paramVarArgs);
      ((Path)localObject3).moveTo(2.0F, 199.0F);
      ((Path)localObject3).lineTo(3.0F, 199.0F);
      ((Path)localObject3).lineTo(3.0F, 196.0F);
      ((Path)localObject3).lineTo(2.0F, 196.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 318.0F, 0.0F, 1.0F, 98.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-13092808);
      localObject3 = c.h(paramVarArgs);
      ((Path)localObject3).moveTo(3.0F, 183.006F);
      ((Path)localObject3).lineTo(3.0F, 7.994F);
      ((Path)localObject3).cubicTo(3.0F, 5.24F, 5.243F, 3.0F, 8.0F, 3.0F);
      ((Path)localObject3).lineTo(98.0F, 3.0F);
      ((Path)localObject3).cubicTo(100.757F, 3.0F, 103.0F, 5.24F, 103.0F, 7.994F);
      ((Path)localObject3).lineTo(103.0F, 183.006F);
      ((Path)localObject3).cubicTo(103.0F, 185.76F, 100.757F, 188.0F, 98.0F, 188.0F);
      ((Path)localObject3).lineTo(8.0F, 188.0F);
      ((Path)localObject3).cubicTo(5.243F, 188.0F, 3.0F, 185.76F, 3.0F, 183.006F);
      ((Path)localObject3).lineTo(3.0F, 183.006F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(98.0F, 191.0F);
      ((Path)localObject3).cubicTo(102.418F, 191.0F, 106.0F, 187.418F, 106.0F, 183.006F);
      ((Path)localObject3).lineTo(106.0F, 7.994F);
      ((Path)localObject3).cubicTo(106.0F, 3.579F, 102.412F, 0.0F, 98.0F, 0.0F);
      ((Path)localObject3).lineTo(8.0F, 0.0F);
      ((Path)localObject3).cubicTo(3.582F, 0.0F, 0.0F, 3.582F, 0.0F, 7.994F);
      ((Path)localObject3).lineTo(0.0F, 183.006F);
      ((Path)localObject3).cubicTo(0.0F, 187.421F, 3.588F, 191.0F, 8.0F, 191.0F);
      ((Path)localObject3).lineTo(98.0F, 191.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 35.0F, 0.0F, 1.0F, 77.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-13092808);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 7.0F, 0.0F, 1.0F, 10.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(37.6973F, 77.1417F);
      localPath.lineTo(38.0463F, 76.6867F);
      localPath.cubicTo(39.3783F, 74.9527F, 41.1253F, 73.8087F, 43.2393F, 73.2887F);
      localPath.lineTo(44.0003F, 73.1007F);
      localPath.lineTo(44.0003F, 69.4957F);
      localPath.cubicTo(44.0003F, 68.6717F, 44.6733F, 67.9997F, 45.5003F, 67.9997F);
      localPath.cubicTo(46.3273F, 67.9997F, 47.0003F, 68.6717F, 47.0003F, 69.4957F);
      localPath.lineTo(47.0003F, 73.0587F);
      localPath.lineTo(47.7853F, 73.2317F);
      localPath.cubicTo(51.3673F, 74.0207F, 55.7253F, 76.9507F, 56.1413F, 86.3337F);
      localPath.cubicTo(55.9003F, 91.3737F, 56.7243F, 94.8457F, 57.6673F, 97.1117F);
      localPath.lineTo(37.6973F, 77.1417F);
      localPath.lineTo(37.6973F, 77.1417F);
      localPath.close();
      localPath.moveTo(57.1403F, 86.3817F);
      localPath.cubicTo(56.6993F, 76.3377F, 51.8463F, 73.1027F, 48.0003F, 72.2557F);
      localPath.lineTo(48.0003F, 69.4957F);
      localPath.cubicTo(48.0003F, 68.1157F, 46.8803F, 66.9997F, 45.5003F, 66.9997F);
      localPath.cubicTo(44.1093F, 66.9997F, 43.0003F, 68.1177F, 43.0003F, 69.4957F);
      localPath.lineTo(43.0003F, 72.3177F);
      localPath.cubicTo(41.0833F, 72.7897F, 38.9513F, 73.8667F, 37.2533F, 76.0777F);
      localPath.lineTo(29.5703F, 68.3957F);
      localPath.lineTo(28.5533F, 69.4127F);
      localPath.lineTo(61.2383F, 102.0977F);
      localPath.lineTo(61.1303F, 102.2057F);
      localPath.lineTo(61.3463F, 102.2057F);
      localPath.lineTo(63.5873F, 104.4457F);
      localPath.lineTo(64.6043F, 103.4287F);
      localPath.lineTo(59.2253F, 98.0497F);
      localPath.cubicTo(58.0323F, 95.8927F, 56.8603F, 92.2417F, 57.1403F, 86.3817F);
      localPath.lineTo(57.1403F, 86.3817F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(35.123F, 86.4254F);
      localPath.cubicTo(35.186F, 84.9914F, 35.346F, 83.6534F, 35.599F, 82.4274F);
      localPath.lineTo(54.377F, 101.2054F);
      localPath.lineTo(30.86F, 101.2054F);
      localPath.cubicTo(32.193F, 100.0154F, 35.584F, 96.0194F, 35.123F, 86.4254F);
      localPath.lineTo(35.123F, 86.4254F);
      localPath.close();
      localPath.moveTo(35.063F, 80.4774F);
      localPath.cubicTo(34.56F, 82.1204F, 34.225F, 84.0714F, 34.124F, 86.3814F);
      localPath.cubicTo(34.663F, 97.6774F, 29.808F, 100.7664F, 29.808F, 100.7664F);
      localPath.lineTo(29.808F, 102.2054F);
      localPath.lineTo(56.791F, 102.2054F);
      localPath.lineTo(35.063F, 80.4774F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(1.0F, 157.0F);
      localPath.lineTo(91.0F, 157.0F);
      localPath.lineTo(91.0F, 11.0F);
      localPath.lineTo(1.0F, 11.0F);
      localPath.lineTo(1.0F, 157.0F);
      localPath.close();
      localPath.moveTo(0.0F, 158.0F);
      localPath.lineTo(92.0F, 158.0F);
      localPath.lineTo(92.0F, 10.0F);
      localPath.lineTo(0.0F, 10.0F);
      localPath.lineTo(0.0F, 158.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(46.0F, 174.0001F);
      localPath.cubicTo(42.691F, 174.0001F, 40.0F, 171.3091F, 40.0F, 168.0001F);
      localPath.cubicTo(40.0F, 164.6911F, 42.691F, 162.0001F, 46.0F, 162.0001F);
      localPath.cubicTo(49.309F, 162.0001F, 52.0F, 164.6911F, 52.0F, 168.0001F);
      localPath.cubicTo(52.0F, 171.3091F, 49.309F, 174.0001F, 46.0F, 174.0001F);
      localPath.moveTo(46.0F, 161.0001F);
      localPath.cubicTo(42.134F, 161.0001F, 39.0F, 164.1341F, 39.0F, 168.0001F);
      localPath.cubicTo(39.0F, 171.8661F, 42.134F, 175.0001F, 46.0F, 175.0001F);
      localPath.cubicTo(49.866F, 175.0001F, 53.0F, 171.8661F, 53.0F, 168.0001F);
      localPath.cubicTo(53.0F, 164.1341F, 49.866F, 161.0001F, 46.0F, 161.0001F);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject3 = c.h(paramVarArgs);
      ((Path)localObject3).moveTo(39.0F, 3.0F);
      ((Path)localObject3).lineTo(53.0F, 3.0F);
      ((Path)localObject3).lineTo(53.0F, 0.0F);
      ((Path)localObject3).lineTo(39.0F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-13158344);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 166.0F, 0.0F, 1.0F, 88.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(43.0895F, 21.9691F);
      localPath.lineTo(43.0895F, 49.9671F);
      localPath.lineTo(3.0895F, 49.9651F);
      localPath.lineTo(3.0895F, 21.9691F);
      localPath.lineTo(3.0905F, 21.9671F);
      localPath.lineTo(8.9995F, 21.9671F);
      localPath.lineTo(8.9995F, 18.9671F);
      localPath.lineTo(3.0905F, 18.9671F);
      localPath.cubicTo(1.4415F, 18.9671F, 0.0895F, 20.3111F, 0.0895F, 21.9691F);
      localPath.lineTo(0.0895F, 49.9651F);
      localPath.cubicTo(0.0895F, 51.6241F, 1.4335F, 52.9671F, 3.0905F, 52.9671F);
      localPath.lineTo(43.0895F, 52.9671F);
      localPath.cubicTo(44.7385F, 52.9671F, 46.0895F, 51.6231F, 46.0895F, 49.9651F);
      localPath.lineTo(46.0895F, 21.9691F);
      localPath.cubicTo(46.0895F, 20.3101F, 44.7465F, 18.9671F, 43.0895F, 18.9671F);
      localPath.lineTo(36.9995F, 18.9671F);
      localPath.lineTo(36.9995F, 21.9691F);
      localPath.lineTo(43.0895F, 21.9691F);
      localPath.lineTo(43.0895F, 21.9691F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(12.0F, 19.0F);
      localPath.lineTo(34.0F, 19.0F);
      localPath.lineTo(34.0F, 18.967F);
      localPath.lineTo(12.0F, 18.967F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(9.0F, 13.4978F);
      localPath.lineTo(9.0F, 18.9668F);
      localPath.lineTo(12.0F, 18.9668F);
      localPath.lineTo(12.0F, 13.4978F);
      localPath.cubicTo(12.0F, 7.7088F, 16.714F, 3.0008F, 22.508F, 3.0008F);
      localPath.lineTo(23.492F, 3.0008F);
      localPath.cubicTo(29.286F, 3.0008F, 34.0F, 7.7088F, 34.0F, 13.4978F);
      localPath.lineTo(34.0F, 18.9668F);
      localPath.lineTo(37.0F, 18.9668F);
      localPath.lineTo(37.0F, 13.4978F);
      localPath.cubicTo(37.0F, 6.0438F, 30.952F, -2.0E-4F, 23.492F, -2.0E-4F);
      localPath.lineTo(22.508F, -2.0E-4F);
      localPath.cubicTo(15.041F, -2.0E-4F, 9.0F, 6.0428F, 9.0F, 13.4978F);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localPath = c.h(paramVarArgs);
      localPath.moveTo(37.0F, 22.0F);
      localPath.lineTo(37.0F, 21.969F);
      localPath.lineTo(9.0F, 21.967F);
      localPath.lineTo(9.0F, 22.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject3 = c.h(paramVarArgs);
      ((Path)localObject3).moveTo(33.9997F, 19.0003F);
      ((Path)localObject3).lineTo(11.9997F, 19.0003F);
      ((Path)localObject3).lineTo(11.9997F, 18.9673F);
      ((Path)localObject3).lineTo(8.9997F, 18.9673F);
      ((Path)localObject3).lineTo(8.9997F, 21.9673F);
      ((Path)localObject3).lineTo(36.9997F, 21.9683F);
      ((Path)localObject3).lineTo(36.9997F, 18.9673F);
      ((Path)localObject3).lineTo(33.9997F, 18.9673F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-13158344);
      localObject3 = c.h(paramVarArgs);
      ((Path)localObject3).moveTo(5.0F, 200.0F);
      ((Path)localObject3).lineTo(318.0F, 200.0F);
      ((Path)localObject3).lineTo(318.0F, 197.0F);
      ((Path)localObject3).lineTo(5.0F, 197.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 131.0F, 0.0F, 1.0F, 246.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-13158344);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(26.0F, 0.0F);
      ((Path)localObject2).lineTo(22.0F, 33.0F);
      ((Path)localObject2).lineTo(0.0F, 37.0F);
      ((Path)localObject2).lineTo(0.0F, 44.0F);
      ((Path)localObject2).lineTo(115.0F, 44.0F);
      ((Path)localObject2).lineTo(115.0F, 37.0F);
      ((Path)localObject2).lineTo(93.0F, 33.0F);
      ((Path)localObject2).lineTo(89.0F, 0.0F);
      ((Path)localObject2).lineTo(26.0F, 0.0F);
      ((Path)localObject2).lineTo(26.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.0F, 39.504F);
      ((Path)localObject2).lineTo(24.712F, 35.556F);
      ((Path)localObject2).lineTo(28.658F, 3.0F);
      ((Path)localObject2).lineTo(86.342F, 3.0F);
      ((Path)localObject2).lineTo(90.288F, 35.556F);
      ((Path)localObject2).lineTo(112.0F, 39.504F);
      ((Path)localObject2).lineTo(112.0F, 41.0F);
      ((Path)localObject2).lineTo(3.0F, 41.0F);
      ((Path)localObject2).lineTo(3.0F, 39.504F);
      ((Path)localObject2).lineTo(3.0F, 39.504F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/kh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */