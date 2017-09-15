package com.tencent.mm.plugin.photoedit.f;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.sdk.platformtools.aa;

public final class a
  implements Cloneable
{
  public static Rect gG;
  public static Paint okA;
  public static Paint okB;
  public static Paint okC;
  public static Paint okD;
  private static int okt;
  private static int oku;
  public static float okv;
  public static float okw;
  public static Path okx;
  public static Path oky;
  public static Paint okz;
  public Matrix mMatrix;
  public Rect ohu;
  public Rect ojB;
  public Rect ojE;
  
  static
  {
    GMTrace.i(9918555881472L, 73899);
    okt = (int)aa.getResources().getDimension(R.f.aYr);
    oku = (int)aa.getResources().getDimension(R.f.aYq);
    okv = aa.getResources().getDimension(R.f.aZn);
    okw = aa.getResources().getDimension(R.f.aZm);
    okx = new Path();
    oky = new Path();
    okz = new Paint();
    okA = new Paint();
    okB = new Paint();
    okC = new Paint();
    okD = new Paint();
    gG = new Rect();
    okB.setColor(-16777216);
    okz.setColor(-1);
    okz.setStrokeWidth(okt);
    okz.setStyle(Paint.Style.STROKE);
    okz.setAntiAlias(true);
    okC.set(okz);
    okC.setStrokeWidth(oku);
    okD.set(okz);
    okD.setStrokeWidth(okv);
    okA.set(okz);
    okA.setStrokeWidth(okt * 7);
    okA.setColor(549174203);
    GMTrace.o(9918555881472L, 73899);
  }
  
  public a()
  {
    GMTrace.i(9918019010560L, 73895);
    this.ojB = new Rect();
    this.ojE = new Rect();
    this.mMatrix = new Matrix();
    GMTrace.o(9918019010560L, 73895);
  }
  
  public a(Rect paramRect)
  {
    GMTrace.i(9917884792832L, 73894);
    this.ojB = new Rect();
    this.ojE = new Rect();
    this.mMatrix = new Matrix();
    this.ohu = paramRect;
    GMTrace.o(9917884792832L, 73894);
  }
  
  public static void qW(int paramInt)
  {
    GMTrace.i(9918153228288L, 73896);
    okD.setAlpha(paramInt);
    okz.setAlpha(paramInt);
    okC.setAlpha((int)(0.7058824F * paramInt));
    GMTrace.o(9918153228288L, 73896);
  }
  
  public static void qX(int paramInt)
  {
    GMTrace.i(9918287446016L, 73897);
    okB.setAlpha((int)(0.9019608F * paramInt));
    GMTrace.o(9918287446016L, 73897);
  }
  
  public final Object clone()
  {
    GMTrace.i(9918421663744L, 73898);
    Object localObject = super.clone();
    GMTrace.o(9918421663744L, 73898);
    return localObject;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/photoedit/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */