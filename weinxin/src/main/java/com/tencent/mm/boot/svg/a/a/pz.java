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

public final class pz
  extends c
{
  private final int height;
  private final int width;
  
  public pz()
  {
    GMTrace.i(15816619720704L, 117843);
    this.width = 120;
    this.height = 120;
    GMTrace.o(15816619720704L, 117843);
  }
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(15816753938432L, 117844);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(15816753938432L, 117844);
      return 0;
      GMTrace.o(15816753938432L, 117844);
      return 120;
      GMTrace.o(15816753938432L, 117844);
      return 120;
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -1843.0F, 0.0F, 1.0F, -1426.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 1772.0F, 0.0F, 1.0F, 1222.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 71.0F, 0.0F, 1.0F, 204.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15028967);
      localObject2 = c.h(paramVarArgs);
      ((Path)localObject2).moveTo(60.0F, 0.0F);
      ((Path)localObject2).cubicTo(93.137085F, 0.0F, 120.0F, 26.862915F, 120.0F, 60.0F);
      ((Path)localObject2).cubicTo(120.0F, 93.137085F, 93.137085F, 120.0F, 60.0F, 120.0F);
      ((Path)localObject2).cubicTo(26.862915F, 120.0F, 0.0F, 93.137085F, 0.0F, 60.0F);
      ((Path)localObject2).cubicTo(0.0F, 26.862915F, 26.862915F, 0.0F, 60.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.h(paramVarArgs);
      ((Path)localObject1).moveTo(73.227135F, 59.73829F);
      ((Path)localObject1).cubicTo(73.08837F, 52.548607F, 67.2208F, 46.76208F, 59.99774F, 46.76208F);
      ((Path)localObject1).cubicTo(59.86049F, 46.76208F, 59.724487F, 46.76735F, 59.588238F, 46.772118F);
      ((Path)localObject1).cubicTo(59.282616F, 46.728207F, 58.966953F, 46.868473F, 58.8031F, 47.152515F);
      ((Path)localObject1).cubicTo(58.588062F, 47.524887F, 58.71553F, 48.000885F, 59.0879F, 48.215927F);
      ((Path)localObject1).cubicTo(59.211353F, 48.28719F, 59.345848F, 48.31755F, 59.478836F, 48.317047F);
      ((Path)localObject1).lineTo(59.478836F, 48.332104F);
      ((Path)localObject1).cubicTo(59.65097F, 48.324577F, 59.823853F, 48.319054F, 59.99774F, 48.319054F);
      ((Path)localObject1).cubicTo(66.360634F, 48.319054F, 71.531395F, 53.408516F, 71.66991F, 59.73829F);
      ((Path)localObject1).lineTo(71.67643F, 59.73829F);
      ((Path)localObject1).cubicTo(71.67643F, 72.66004F, 66.24421F, 84.30887F, 57.544724F, 92.53988F);
      ((Path)localObject1).cubicTo(57.311367F, 92.73736F, 57.142998F, 92.9248F, 57.142998F, 93.217125F);
      ((Path)localObject1).cubicTo(57.142998F, 93.6472F, 57.49153F, 93.995735F, 57.92161F, 93.995735F);
      ((Path)localObject1).cubicTo(58.225227F, 93.995735F, 58.47364F, 93.80679F, 58.47364F, 93.80679F);
      ((Path)localObject1).cubicTo(67.55603F, 85.284454F, 73.23366F, 73.17594F, 73.23366F, 59.73829F);
      ((Path)localObject1).lineTo(73.227135F, 59.73829F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(60.776356F, 59.73829F);
      ((Path)localObject1).cubicTo(60.776356F, 59.30821F, 60.427826F, 58.959675F, 59.99774F, 58.959675F);
      ((Path)localObject1).cubicTo(59.567913F, 58.959675F, 59.21913F, 59.30821F, 59.21913F, 59.73829F);
      ((Path)localObject1).cubicTo(59.21913F, 71.85609F, 52.62564F, 82.430466F, 42.832886F, 88.079735F);
      ((Path)localObject1).cubicTo(42.832886F, 88.079735F, 42.526764F, 88.26918F, 42.518982F, 88.62198F);
      ((Path)localObject1).cubicTo(42.50945F, 89.05181F, 42.769905F, 89.31979F, 43.20902F, 89.37475F);
      ((Path)localObject1).cubicTo(43.5159F, 89.41314F, 43.79844F, 89.3208F, 44.088F, 89.14063F);
      ((Path)localObject1).cubicTo(54.08099F, 83.15663F, 60.776356F, 72.23322F, 60.776356F, 59.73829F);
      ((Path)localObject1).lineTo(60.776356F, 59.73829F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(65.359955F, 77.14328F);
      ((Path)localObject1).cubicTo(65.51955F, 76.78396F, 65.38931F, 76.35563F, 65.04104F, 76.15464F);
      ((Path)localObject1).cubicTo(64.66866F, 75.9396F, 64.192665F, 76.06732F, 63.977627F, 76.43969F);
      ((Path)localObject1).cubicTo(63.95379F, 76.481094F, 63.935722F, 76.524F, 63.920166F, 76.56741F);
      ((Path)localObject1).lineTo(63.917404F, 76.566154F);
      ((Path)localObject1).cubicTo(61.239307F, 82.50373F, 57.19017F, 87.689804F, 52.171722F, 91.720116F);
      ((Path)localObject1).cubicTo(51.911766F, 91.89777F, 51.692963F, 92.11482F, 51.692963F, 92.43851F);
      ((Path)localObject1).cubicTo(51.692963F, 92.86859F, 52.041492F, 93.217125F, 52.471573F, 93.217125F);
      ((Path)localObject1).cubicTo(52.738556F, 93.217125F, 53.16663F, 92.92304F, 53.16663F, 92.92304F);
      ((Path)localObject1).cubicTo(58.38406F, 88.72812F, 62.590023F, 83.327515F, 65.36573F, 77.14554F);
      ((Path)localObject1).lineTo(65.359955F, 77.14328F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(64.92887F, 59.73829F);
      ((Path)localObject1).lineTo(64.915825F, 59.73829F);
      ((Path)localObject1).cubicTo(64.77982F, 57.13647F, 62.633434F, 55.066864F, 59.99774F, 55.066864F);
      ((Path)localObject1).cubicTo(57.362053F, 55.066864F, 55.215664F, 57.13647F, 55.079914F, 59.73829F);
      ((Path)localObject1).lineTo(55.066864F, 59.73829F);
      ((Path)localObject1).cubicTo(55.066864F, 71.13293F, 48.388813F, 80.96407F, 38.735073F, 85.542404F);
      ((Path)localObject1).cubicTo(38.735073F, 85.542404F, 38.276886F, 85.85806F, 38.531826F, 86.461784F);
      ((Path)localObject1).cubicTo(38.790527F, 87.081314F, 39.574657F, 86.8733F, 39.785934F, 86.760635F);
      ((Path)localObject1).cubicTo(49.757595F, 81.8556F, 56.624092F, 71.601906F, 56.624092F, 59.73829F);
      ((Path)localObject1).lineTo(56.63714F, 59.73829F);
      ((Path)localObject1).cubicTo(56.770126F, 57.996635F, 58.222218F, 56.62409F, 59.99774F, 56.62409F);
      ((Path)localObject1).cubicTo(61.77352F, 56.62409F, 63.225613F, 57.996635F, 63.3586F, 59.73829F);
      ((Path)localObject1).lineTo(63.371647F, 59.73829F);
      ((Path)localObject1).cubicTo(63.371647F, 72.35392F, 57.028328F, 83.48258F, 47.36179F, 90.1255F);
      ((Path)localObject1).cubicTo(47.005478F, 90.31796F, 46.764843F, 90.57516F, 46.764843F, 90.94326F);
      ((Path)localObject1).cubicTo(46.764843F, 91.373344F, 47.110615F, 91.6599F, 47.540695F, 91.6599F);
      ((Path)localObject1).cubicTo(47.77506F, 91.6599F, 48.04154F, 91.54949F, 48.04154F, 91.54949F);
      ((Path)localObject1).cubicTo(58.230244F, 84.6426F, 64.92887F, 72.9747F, 64.92887F, 59.73829F);
      ((Path)localObject1).lineTo(64.92887F, 59.73829F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(77.37965F, 59.73829F);
      ((Path)localObject1).cubicTo(77.240135F, 50.255173F, 69.51398F, 42.609566F, 59.99774F, 42.609566F);
      ((Path)localObject1).cubicTo(50.48176F, 42.609566F, 42.755604F, 50.255173F, 42.61609F, 59.73829F);
      ((Path)localObject1).lineTo(42.609566F, 59.73829F);
      ((Path)localObject1).cubicTo(42.609566F, 67.24388F, 37.46992F, 73.54681F, 30.518614F, 75.32534F);
      ((Path)localObject1).cubicTo(30.510836F, 75.32685F, 30.50356F, 75.329605F, 30.49603F, 75.33137F);
      ((Path)localObject1).cubicTo(30.472696F, 75.33739F, 30.450113F, 75.34441F, 30.427029F, 75.35018F);
      ((Path)localObject1).lineTo(30.42778F, 75.35269F);
      ((Path)localObject1).cubicTo(30.117891F, 75.45532F, 29.892815F, 75.74413F, 29.892815F, 76.0884F);
      ((Path)localObject1).cubicTo(29.892815F, 76.51848F, 30.241344F, 76.86701F, 30.671427F, 76.86701F);
      ((Path)localObject1).cubicTo(30.778318F, 76.86701F, 30.880194F, 76.84543F, 30.973036F, 76.80629F);
      ((Path)localObject1).lineTo(30.974289F, 76.809296F);
      ((Path)localObject1).cubicTo(38.562187F, 74.83429F, 44.16679F, 67.94471F, 44.16679F, 59.73829F);
      ((Path)localObject1).lineTo(44.173317F, 59.73829F);
      ((Path)localObject1).cubicTo(44.312576F, 51.115337F, 51.34167F, 44.16679F, 59.99774F, 44.16679F);
      ((Path)localObject1).cubicTo(68.65407F, 44.16679F, 75.68316F, 51.115337F, 75.822426F, 59.73829F);
      ((Path)localObject1).lineTo(75.82895F, 59.73829F);
      ((Path)localObject1).cubicTo(75.82895F, 72.42694F, 71.03231F, 83.99271F, 63.158363F, 92.73109F);
      ((Path)localObject1).cubicTo(63.158363F, 92.73109F, 62.977448F, 92.98953F, 62.977448F, 93.217125F);
      ((Path)localObject1).cubicTo(62.977448F, 93.6472F, 63.32598F, 93.995735F, 63.75606F, 93.995735F);
      ((Path)localObject1).cubicTo(64.12141F, 93.995735F, 64.38337F, 93.73202F, 64.644325F, 93.40356F);
      ((Path)localObject1).cubicTo(72.57097F, 84.43383F, 77.38617F, 72.64976F, 77.38617F, 59.73829F);
      ((Path)localObject1).lineTo(77.37965F, 59.73829F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(93.99248F, 59.73829F);
      ((Path)localObject1).cubicTo(93.91996F, 50.040634F, 89.786514F, 41.31054F, 83.20983F, 35.16068F);
      ((Path)localObject1).lineTo(83.20883F, 35.161682F);
      ((Path)localObject1).cubicTo(83.01863F, 34.963955F, 82.73208F, 34.87011F, 82.44803F, 34.94614F);
      ((Path)localObject1).cubicTo(82.03275F, 35.05755F, 81.78635F, 35.484367F, 81.89751F, 35.8999F);
      ((Path)localObject1).cubicTo(81.93239F, 36.029373F, 82.00039F, 36.13978F, 82.08645F, 36.23086F);
      ((Path)localObject1).lineTo(82.08018F, 36.236885F);
      ((Path)localObject1).cubicTo(88.39138F, 42.105713F, 92.36248F, 50.457165F, 92.43525F, 59.73829F);
      ((Path)localObject1).lineTo(92.438515F, 59.73829F);
      ((Path)localObject1).cubicTo(92.438515F, 64.52865F, 91.91985F, 69.196815F, 90.94929F, 73.697105F);
      ((Path)localObject1).cubicTo(90.86071F, 74.12342F, 90.85569F, 74.79088F, 91.66015F, 74.79088F);
      ((Path)localObject1).cubicTo(92.02198F, 74.79088F, 92.34542F, 74.599174F, 92.438515F, 74.19343F);
      ((Path)localObject1).cubicTo(93.44621F, 69.576706F, 93.98495F, 64.78484F, 93.99423F, 59.868015F);
      ((Path)localObject1).cubicTo(93.99398F, 59.824604F, 93.99272F, 59.781696F, 93.99248F, 59.73829F);
      ((Path)localObject1).lineTo(93.99248F, 59.73829F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(85.68443F, 59.73829F);
      ((Path)localObject1).cubicTo(85.54442F, 45.66856F, 74.10059F, 34.304783F, 59.99774F, 34.304783F);
      ((Path)localObject1).cubicTo(50.529686F, 34.304783F, 42.264046F, 39.42937F, 37.808918F, 47.053654F);
      ((Path)localObject1).cubicTo(37.765507F, 47.108105F, 37.731133F, 47.168076F, 37.704033F, 47.231056F);
      ((Path)localObject1).cubicTo(37.68998F, 47.255646F, 37.674923F, 47.279484F, 37.661125F, 47.304073F);
      ((Path)localObject1).lineTo(37.678688F, 47.28099F);
      ((Path)localObject1).lineTo(37.68446F, 47.284F);
      ((Path)localObject1).cubicTo(37.613197F, 47.490005F, 37.62524F, 47.723366F, 37.742672F, 47.926865F);
      ((Path)localObject1).cubicTo(37.957714F, 48.299232F, 38.433964F, 48.426952F, 38.806335F, 48.21191F);
      ((Path)localObject1).cubicTo(38.912224F, 48.15069F, 38.99578F, 48.06688F, 39.060017F, 47.97178F);
      ((Path)localObject1).lineTo(39.0698F, 47.976795F);
      ((Path)localObject1).cubicTo(43.235115F, 40.737183F, 51.04558F, 35.862007F, 59.99774F, 35.862007F);
      ((Path)localObject1).cubicTo(73.240685F, 35.862007F, 83.98744F, 46.528473F, 84.127205F, 59.73829F);
      ((Path)localObject1).lineTo(84.13047F, 59.73829F);
      ((Path)localObject1).cubicTo(84.13097F, 59.824856F, 84.13373F, 59.910923F, 84.13373F, 59.99774F);
      ((Path)localObject1).cubicTo(84.13373F, 69.94506F, 81.587364F, 79.29167F, 77.13174F, 87.44591F);
      ((Path)localObject1).cubicTo(77.01305F, 87.66797F, 76.88634F, 87.92341F, 76.93978F, 88.258644F);
      ((Path)localObject1).cubicTo(77.00753F, 88.68346F, 77.50486F, 88.80515F, 77.64562F, 88.80515F);
      ((Path)localObject1).cubicTo(78.02527F, 88.80515F, 78.20493F, 88.56753F, 78.40943F, 88.17358F);
      ((Path)localObject1).cubicTo(83.04447F, 79.7338F, 85.690956F, 70.046936F, 85.690956F, 59.73829F);
      ((Path)localObject1).lineTo(85.68443F, 59.73829F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(81.53191F, 59.73829F);
      ((Path)localObject1).cubicTo(81.47847F, 55.233727F, 80.03616F, 51.067158F, 77.62254F, 47.63253F);
      ((Path)localObject1).cubicTo(77.60598F, 47.557003F, 77.58114F, 47.482227F, 77.54049F, 47.41147F);
      ((Path)localObject1).cubicTo(77.32545F, 47.0391F, 76.8492F, 46.911633F, 76.47683F, 47.12667F);
      ((Path)localObject1).cubicTo(76.10446F, 47.341713F, 75.97699F, 47.81771F, 76.19203F, 48.190083F);
      ((Path)localObject1).cubicTo(76.20683F, 48.215927F, 76.225655F, 48.237507F, 76.242966F, 48.26084F);
      ((Path)localObject1).lineTo(76.19328F, 48.303497F);
      ((Path)localObject1).cubicTo(78.52335F, 51.526848F, 79.920235F, 55.469593F, 79.97494F, 59.73829F);
      ((Path)localObject1).lineTo(79.98146F, 59.73829F);
      ((Path)localObject1).cubicTo(79.98146F, 71.53541F, 76.15314F, 82.43448F, 69.68109F, 91.27624F);
      ((Path)localObject1).cubicTo(69.47484F, 91.536446F, 69.33482F, 91.77883F, 69.35766F, 92.031265F);
      ((Path)localObject1).cubicTo(69.39605F, 92.45959F, 69.68938F, 92.69821F, 70.11945F, 92.69821F);
      ((Path)localObject1).cubicTo(70.551796F, 92.69821F, 70.94248F, 92.195114F, 70.94624F, 92.19361F);
      ((Path)localObject1).cubicTo(77.60448F, 83.09491F, 81.53844F, 71.876915F, 81.53844F, 59.73829F);
      ((Path)localObject1).lineTo(81.53191F, 59.73829F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(89.79604F, 58.44077F);
      ((Path)localObject1).lineTo(89.78827F, 58.44077F);
      ((Path)localObject1).cubicTo(89.78852F, 58.30803F, 89.758156F, 58.173534F, 89.68715F, 58.05033F);
      ((Path)localObject1).cubicTo(89.47211F, 57.677963F, 88.99586F, 57.550495F, 88.62348F, 57.765285F);
      ((Path)localObject1).cubicTo(88.37382F, 57.909565F, 88.23731F, 58.171528F, 88.237564F, 58.44077F);
      ((Path)localObject1).lineTo(88.23707F, 58.44077F);
      ((Path)localObject1).cubicTo(88.237564F, 58.44679F, 88.237564F, 58.452812F, 88.23807F, 58.458836F);
      ((Path)localObject1).cubicTo(88.23857F, 58.487186F, 88.237816F, 58.515293F, 88.24183F, 58.543396F);
      ((Path)localObject1).cubicTo(88.26191F, 58.939854F, 88.275955F, 59.337814F, 88.279724F, 59.73829F);
      ((Path)localObject1).lineTo(88.28625F, 59.73829F);
      ((Path)localObject1).cubicTo(88.28625F, 67.344505F, 86.906425F, 74.62727F, 84.391426F, 81.35626F);
      ((Path)localObject1).cubicTo(84.391426F, 81.35626F, 84.11215F, 82.31705F, 85.1718F, 82.31705F);
      ((Path)localObject1).cubicTo(85.56323F, 82.31705F, 85.77777F, 82.02397F, 85.93912F, 81.6516F);
      ((Path)localObject1).cubicTo(88.45888F, 74.82199F, 89.84347F, 67.44286F, 89.84347F, 59.73829F);
      ((Path)localObject1).lineTo(89.83669F, 59.73829F);
      ((Path)localObject1).cubicTo(89.83318F, 59.30319F, 89.81813F, 58.8711F, 89.79604F, 58.44077F);
      ((Path)localObject1).lineTo(89.79604F, 58.44077F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(59.99774F, 30.152266F);
      ((Path)localObject1).cubicTo(59.562897F, 30.152266F, 59.130554F, 30.163557F, 58.700222F, 30.182125F);
      ((Path)localObject1).lineTo(58.700222F, 30.19442F);
      ((Path)localObject1).cubicTo(58.567486F, 30.19417F, 58.433243F, 30.224281F, 58.31004F, 30.295542F);
      ((Path)localObject1).cubicTo(57.93742F, 30.510584F, 57.80995F, 30.986584F, 58.02499F, 31.359203F);
      ((Path)localObject1).cubicTo(58.191605F, 31.647764F, 58.514793F, 31.786776F, 58.82543F, 31.735838F);
      ((Path)localObject1).cubicTo(59.214363F, 31.719778F, 59.604797F, 31.709492F, 59.99774F, 31.709492F);
      ((Path)localObject1).cubicTo(73.359116F, 31.709492F, 84.55252F, 40.9738F, 87.51391F, 53.42884F);
      ((Path)localObject1).lineTo(87.514404F, 53.42884F);
      ((Path)localObject1).cubicTo(87.530716F, 53.508636F, 87.55631F, 53.587677F, 87.59947F, 53.6622F);
      ((Path)localObject1).cubicTo(87.814514F, 54.03457F, 88.29051F, 54.162037F, 88.66288F, 53.946995F);
      ((Path)localObject1).cubicTo(88.93714F, 53.788666F, 89.077156F, 53.48881F, 89.04679F, 53.192974F);
      ((Path)localObject1).lineTo(89.05683F, 53.191467F);
      ((Path)localObject1).cubicTo(85.97751F, 39.988426F, 74.138985F, 30.152266F, 59.99774F, 30.152266F);
      ((Path)localObject1).lineTo(59.99774F, 30.152266F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(26.778364F, 60.5169F);
      ((Path)localObject1).cubicTo(27.54167F, 60.5169F, 27.560238F, 59.73829F, 27.560238F, 59.73829F);
      ((Path)localObject1).cubicTo(27.63426F, 50.32267F, 31.71953F, 41.86307F, 38.19057F, 35.9827F);
      ((Path)localObject1).lineTo(38.162716F, 35.948074F);
      ((Path)localObject1).cubicTo(38.340874F, 35.805298F, 38.45705F, 35.588753F, 38.45705F, 35.34285F);
      ((Path)localObject1).cubicTo(38.45705F, 34.91277F, 38.108517F, 34.564236F, 37.678688F, 34.564236F);
      ((Path)localObject1).cubicTo(37.389374F, 34.564236F, 37.139957F, 34.723824F, 37.005714F, 34.957935F);
      ((Path)localObject1).cubicTo(30.301817F, 41.117832F, 26.076532F, 49.93349F, 26.003263F, 59.73829F);
      ((Path)localObject1).cubicTo(26.003263F, 60.181416F, 26.2848F, 60.5169F, 26.778364F, 60.5169F);
      ((Path)localObject1).lineTo(26.778364F, 60.5169F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(31.709494F, 59.73829F);
      ((Path)localObject1).lineTo(31.716017F, 59.73829F);
      ((Path)localObject1).cubicTo(31.83646F, 46.40301F, 41.180313F, 35.271084F, 53.67876F, 32.4186F);
      ((Path)localObject1).lineTo(53.676502F, 32.404045F);
      ((Path)localObject1).cubicTo(53.75228F, 32.38748F, 53.82731F, 32.36264F, 53.898067F, 32.321743F);
      ((Path)localObject1).cubicTo(54.27044F, 32.1067F, 54.398155F, 31.630701F, 54.183117F, 31.258331F);
      ((Path)localObject1).cubicTo(53.986393F, 30.91758F, 53.57187F, 30.785091F, 53.217567F, 30.929121F);
      ((Path)localObject1).cubicTo(40.083782F, 33.981342F, 30.278984F, 45.70319F, 30.158792F, 59.73829F);
      ((Path)localObject1).lineTo(30.152267F, 59.73829F);
      ((Path)localObject1).cubicTo(30.152267F, 61.657345F, 28.663544F, 63.225105F, 26.778364F, 63.358597F);
      ((Path)localObject1).cubicTo(25.99147F, 63.358597F, 26.000002F, 64.15026F, 26.000002F, 64.15026F);
      ((Path)localObject1).cubicTo(26.000002F, 64.58034F, 26.346275F, 64.91758F, 26.995663F, 64.89424F);
      ((Path)localObject1).cubicTo(29.637123F, 64.65235F, 31.709494F, 62.44298F, 31.709494F, 59.73829F);
      ((Path)localObject1).lineTo(31.709494F, 59.73829F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(44.77051F, 78.134674F);
      ((Path)localObject1).cubicTo(44.796608F, 78.102806F, 44.8222F, 78.07018F, 44.84353F, 78.03355F);
      ((Path)localObject1).cubicTo(45.05857F, 77.66118F, 44.93085F, 77.18493F, 44.558483F, 76.96989F);
      ((Path)localObject1).cubicTo(44.18611F, 76.75485F, 43.70986F, 76.88257F, 43.49482F, 77.25494F);
      ((Path)localObject1).cubicTo(43.490807F, 77.262215F, 43.4888F, 77.26999F, 43.484783F, 77.27752F);
      ((Path)localObject1).lineTo(43.471737F, 77.26874F);
      ((Path)localObject1).cubicTo(41.251575F, 79.41488F, 38.627678F, 81.14624F, 35.721493F, 82.33135F);
      ((Path)localObject1).cubicTo(35.336327F, 82.4666F, 35.083397F, 82.71375F, 35.083397F, 83.09566F);
      ((Path)localObject1).cubicTo(35.083397F, 83.52574F, 35.431927F, 83.874275F, 35.86201F, 83.874275F);
      ((Path)localObject1).cubicTo(36.001774F, 83.874275F, 36.252445F, 83.791214F, 36.252445F, 83.791214F);
      ((Path)localObject1).cubicTo(39.47153F, 82.48743F, 42.36818F, 80.55557F, 44.79435F, 78.15048F);
      ((Path)localObject1).lineTo(44.77051F, 78.134674F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(42.609566F, 32.488102F);
      ((Path)localObject1).cubicTo(42.806793F, 32.488102F, 42.984695F, 32.412323F, 43.121952F, 32.29138F);
      ((Path)localObject1).cubicTo(48.038776F, 29.289595F, 53.815266F, 27.556974F, 59.99774F, 27.556974F);
      ((Path)localObject1).cubicTo(66.351105F, 27.556974F, 72.276886F, 29.384693F, 77.28028F, 32.541046F);
      ((Path)localObject1).lineTo(77.28881F, 32.529255F);
      ((Path)localObject1).cubicTo(77.46672F, 32.643173F, 77.68853F, 32.686584F, 77.90859F, 32.627617F);
      ((Path)localObject1).cubicTo(78.32387F, 32.516457F, 78.570274F, 32.089638F, 78.459114F, 31.67411F);
      ((Path)localObject1).cubicTo(78.393875F, 31.430967F, 78.21923F, 31.248547F, 78.00344F, 31.158966F);
      ((Path)localObject1).cubicTo(72.782F, 27.891705F, 66.61181F, 26.0F, 59.99774F, 26.0F);
      ((Path)localObject1).cubicTo(53.506126F, 26.0F, 47.44058F, 27.820944F, 42.28136F, 30.9778F);
      ((Path)localObject1).lineTo(42.29315F, 30.99938F);
      ((Path)localObject1).cubicTo(42.021152F, 31.120827F, 41.830956F, 31.392576F, 41.830956F, 31.709492F);
      ((Path)localObject1).cubicTo(41.830956F, 32.13932F, 42.179485F, 32.488102F, 42.609566F, 32.488102F);
      ((Path)localObject1).lineTo(42.609566F, 32.488102F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(65.77298F, 73.64943F);
      ((Path)localObject1).cubicTo(66.14535F, 73.86447F, 66.621346F, 73.73701F, 66.83639F, 73.36463F);
      ((Path)localObject1).cubicTo(66.84165F, 73.3556F, 66.84416F, 73.34632F, 66.84868F, 73.33729F);
      ((Path)localObject1).lineTo(66.85646F, 73.34004F);
      ((Path)localObject1).cubicTo(66.86449F, 73.315956F, 66.87202F, 73.29162F, 66.88004F, 73.267525F);
      ((Path)localObject1).cubicTo(66.89435F, 73.2329F, 66.90564F, 73.19802F, 66.91442F, 73.16264F);
      ((Path)localObject1).cubicTo(68.31708F, 68.94212F, 69.08114F, 64.43004F, 69.08114F, 59.73829F);
      ((Path)localObject1).lineTo(69.074615F, 59.73829F);
      ((Path)localObject1).cubicTo(68.93686F, 54.842037F, 64.92737F, 50.91435F, 59.99774F, 50.91435F);
      ((Path)localObject1).cubicTo(55.06812F, 50.91435F, 51.058628F, 54.842037F, 50.92087F, 59.73829F);
      ((Path)localObject1).lineTo(50.91435F, 59.73829F);
      ((Path)localObject1).cubicTo(50.91435F, 65.376015F, 48.998554F, 70.562836F, 45.786247F, 74.69227F);
      ((Path)localObject1).lineTo(45.808075F, 74.70331F);
      ((Path)localObject1).cubicTo(45.6244F, 75.0689F, 45.75262F, 75.5183F, 46.11169F, 75.725815F);
      ((Path)localObject1).cubicTo(46.484062F, 75.940605F, 46.96006F, 75.81313F, 47.175102F, 75.440765F);
      ((Path)localObject1).cubicTo(47.18338F, 75.42647F, 47.187897F, 75.411156F, 47.195175F, 75.39661F);
      ((Path)localObject1).lineTo(47.2027F, 75.40037F);
      ((Path)localObject1).cubicTo(50.507103F, 71.048874F, 52.471573F, 65.62518F, 52.471573F, 59.73829F);
      ((Path)localObject1).lineTo(52.484623F, 59.73829F);
      ((Path)localObject1).cubicTo(52.62263F, 55.702953F, 55.928783F, 52.471573F, 59.99774F, 52.471573F);
      ((Path)localObject1).cubicTo(64.066956F, 52.471573F, 67.37311F, 55.702953F, 67.511116F, 59.73829F);
      ((Path)localObject1).lineTo(67.52416F, 59.73829F);
      ((Path)localObject1).cubicTo(67.52416F, 64.30357F, 66.77441F, 68.69221F, 65.39684F, 72.792786F);
      ((Path)localObject1).lineTo(65.40788F, 72.79705F);
      ((Path)localObject1).cubicTo(65.3311F, 73.12274F, 65.4681F, 73.47353F, 65.77298F, 73.64943F);
      ((Path)localObject1).lineTo(65.77298F, 73.64943F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(40.014275F, 59.73829F);
      ((Path)localObject1).lineTo(40.020798F, 59.73829F);
      ((Path)localObject1).cubicTo(40.160564F, 48.821903F, 49.048237F, 40.014275F, 59.99774F, 40.014275F);
      ((Path)localObject1).cubicTo(65.29246F, 40.014275F, 70.100136F, 42.078865F, 73.67452F, 45.44022F);
      ((Path)localObject1).cubicTo(73.91265F, 45.725773F, 74.32718F, 45.808826F, 74.66015F, 45.61662F);
      ((Path)localObject1).cubicTo(75.03252F, 45.40158F, 75.15999F, 44.92558F, 74.94495F, 44.55321F);
      ((Path)localObject1).cubicTo(74.91057F, 44.493492F, 74.86766F, 44.442554F, 74.82124F, 44.39588F);
      ((Path)localObject1).lineTo(74.82952F, 44.3876F);
      ((Path)localObject1).cubicTo(70.967575F, 40.7151F, 65.74838F, 38.457047F, 59.99774F, 38.457047F);
      ((Path)localObject1).cubicTo(48.188328F, 38.457047F, 38.603336F, 47.961994F, 38.463825F, 59.73829F);
      ((Path)localObject1).lineTo(38.45705F, 59.73829F);
      ((Path)localObject1).cubicTo(38.45705F, 65.50524F, 34.36551F, 70.30915F, 28.92877F, 71.4245F);
      ((Path)localObject1).cubicTo(28.307987F, 71.54093F, 28.005625F, 71.81293F, 28.094954F, 72.39607F);
      ((Path)localObject1).cubicTo(28.20837F, 73.13605F, 29.004799F, 73.0013F, 29.004799F, 73.0013F);
      ((Path)localObject1).cubicTo(35.270084F, 71.83401F, 40.014275F, 66.34181F, 40.014275F, 59.73829F);
      ((Path)localObject1).lineTo(40.014275F, 59.73829F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(35.86201F, 59.73829F);
      ((Path)localObject1).lineTo(35.868534F, 59.73829F);
      ((Path)localObject1).cubicTo(35.89287F, 57.430805F, 36.241905F, 55.20136F, 36.87047F, 53.092354F);
      ((Path)localObject1).lineTo(36.85215F, 53.08257F);
      ((Path)localObject1).cubicTo(36.974598F, 52.853226F, 36.981373F, 52.56868F, 36.84186F, 52.32679F);
      ((Path)localObject1).cubicTo(36.62682F, 51.954422F, 36.15082F, 51.826954F, 35.778454F, 52.041992F);
      ((Path)localObject1).cubicTo(35.651485F, 52.11501F, 35.555885F, 52.2199F, 35.48964F, 52.339336F);
      ((Path)localObject1).lineTo(35.474834F, 52.331306F);
      ((Path)localObject1).cubicTo(35.463043F, 52.369194F, 35.453007F, 52.407837F, 35.44121F, 52.445976F);
      ((Path)localObject1).cubicTo(35.42741F, 52.483116F, 35.41612F, 52.5205F, 35.40809F, 52.559143F);
      ((Path)localObject1).cubicTo(34.720562F, 54.835514F, 34.33615F, 57.243366F, 34.31131F, 59.73829F);
      ((Path)localObject1).lineTo(34.304783F, 59.73829F);
      ((Path)localObject1).cubicTo(34.304783F, 63.84363F, 31.126348F, 67.20323F, 27.096785F, 67.49907F);
      ((Path)localObject1).cubicTo(27.096785F, 67.49907F, 26.466969F, 67.61173F, 26.51891F, 68.30277F);
      ((Path)localObject1).cubicTo(26.572355F, 69.01088F, 27.314585F, 69.03697F, 27.621212F, 69.00887F);
      ((Path)localObject1).cubicTo(32.26077F, 68.462616F, 35.86201F, 64.524635F, 35.86201F, 59.73829F);
      ((Path)localObject1).lineTo(35.86201F, 59.73829F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(48.319057F, 59.73829F);
      ((Path)localObject1).lineTo(48.32558F, 59.73829F);
      ((Path)localObject1).cubicTo(48.43097F, 54.931618F, 51.439278F, 50.842834F, 55.66657F, 49.15212F);
      ((Path)localObject1).lineTo(55.65578F, 49.092148F);
      ((Path)localObject1).cubicTo(55.90018F, 49.07082F, 56.130775F, 48.935574F, 56.262512F, 48.70698F);
      ((Path)localObject1).cubicTo(56.47755F, 48.334614F, 56.350082F, 47.85836F, 55.977715F, 47.643322F);
      ((Path)localObject1).cubicTo(55.69969F, 47.482983F, 55.363956F, 47.513596F, 55.122066F, 47.69426F);
      ((Path)localObject1).cubicTo(50.303856F, 49.60629F, 46.874245F, 54.26341F, 46.76861F, 59.73829F);
      ((Path)localObject1).lineTo(46.762085F, 59.73829F);
      ((Path)localObject1).cubicTo(46.762085F, 68.66159F, 40.984592F, 76.22842F, 32.968872F, 78.92232F);
      ((Path)localObject1).cubicTo(32.968872F, 78.92232F, 32.278584F, 79.12883F, 32.495132F, 79.86327F);
      ((Path)localObject1).cubicTo(32.70942F, 80.58995F, 33.587646F, 80.36512F, 33.80294F, 80.28407F);
      ((Path)localObject1).cubicTo(42.25953F, 77.2858F, 48.319057F, 69.22266F, 48.319057F, 59.73829F);
      ((Path)localObject1).lineTo(48.319057F, 59.73829F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.f(paramVarArgs);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/boot/svg/a/a/pz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */