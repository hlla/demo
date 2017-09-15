package com.c.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

final class u
  extends d
  implements SensorEventListener
{
  private static final int aNc;
  private static final int aNd;
  private static u aNw;
  private SensorManager aJs = null;
  int[] aNA = new int[6];
  float[] aNB = new float[6];
  float[] aNC = new float[6];
  float[] aND = { NaN.0F, NaN.0F, NaN.0F, NaN.0F, NaN.0F, NaN.0F };
  float[][] aNE = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 20 });
  final d aNF = new d();
  final f aNG = new f();
  final a aNH = new a();
  Sensor aNe;
  Sensor aNf;
  Sensor aNg;
  Sensor aNh;
  Sensor aNi = null;
  private long aNj = 0L;
  private boolean aNk = true;
  private float[][] aNl = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 });
  float[][] aNm = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 });
  private float[][] aNn = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 });
  float[][] aNo = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  float[][] aNp = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  float[][] aNq = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  float[][] aNr = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[] aNs = new float[4];
  private float[][] aNt = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[][] aNu = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  private float[][] aNv = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 });
  boolean aNx;
  private c aNy;
  boolean[] aNz = new boolean[6];
  
  static
  {
    int i = Math.round(50000.0F);
    aNc = i;
    aNd = i;
  }
  
  private static void a(float[] paramArrayOfFloat, float[][] paramArrayOfFloat1)
  {
    paramArrayOfFloat1[0][0] = (-paramArrayOfFloat[1]);
    paramArrayOfFloat1[0][1] = paramArrayOfFloat[0];
    paramArrayOfFloat1[0][2] = paramArrayOfFloat[2];
    paramArrayOfFloat1[1][0] = paramArrayOfFloat[1];
    paramArrayOfFloat1[1][1] = (-paramArrayOfFloat[0]);
    paramArrayOfFloat1[1][2] = paramArrayOfFloat[2];
    System.arraycopy(paramArrayOfFloat, 0, paramArrayOfFloat1[2], 0, 3);
    paramArrayOfFloat1[3][0] = (-paramArrayOfFloat[0]);
    paramArrayOfFloat1[3][1] = (-paramArrayOfFloat[1]);
    paramArrayOfFloat1[3][2] = paramArrayOfFloat[2];
    paramArrayOfFloat1[4][0] = paramArrayOfFloat[0];
    paramArrayOfFloat1[4][1] = paramArrayOfFloat[2];
    paramArrayOfFloat1[4][2] = (-paramArrayOfFloat[1]);
    paramArrayOfFloat1[5][0] = paramArrayOfFloat[0];
    paramArrayOfFloat1[5][1] = (-paramArrayOfFloat[2]);
    paramArrayOfFloat1[5][2] = paramArrayOfFloat[1];
  }
  
  private static void a(float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2)
  {
    int i = 0;
    for (;;)
    {
      if (i > 5) {
        return;
      }
      SensorManager.getOrientation(paramArrayOfFloat1[i], paramArrayOfFloat2[i]);
      i += 1;
    }
  }
  
  @TargetApi(19)
  private static boolean a(SensorManager paramSensorManager, SensorEventListener paramSensorEventListener, int paramInt1, int paramInt2, Handler paramHandler, Sensor... paramVarArgs)
  {
    for (;;)
    {
      int i;
      int k;
      int j;
      try
      {
        if (Build.VERSION.SDK_INT < 19) {
          break label98;
        }
        i = 1;
        k = paramVarArgs.length;
        j = 0;
      }
      catch (Error paramSensorManager)
      {
        Sensor localSensor;
        boolean bool;
        return false;
      }
      catch (Exception paramSensorManager)
      {
        return false;
      }
      localSensor = paramVarArgs[j];
      if (i != 0)
      {
        bool = paramSensorManager.registerListener(paramSensorEventListener, localSensor, paramInt1, paramInt2, paramHandler);
        if (!bool)
        {
          paramSensorManager.unregisterListener(paramSensorEventListener);
          return false;
        }
      }
      else
      {
        bool = paramSensorManager.registerListener(paramSensorEventListener, localSensor, paramInt1, paramHandler);
        continue;
      }
      j += 1;
      if (j >= k)
      {
        return true;
        label98:
        i = 0;
      }
    }
  }
  
  static float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return new float[] { paramArrayOfFloat1[0] * paramArrayOfFloat2[0] + paramArrayOfFloat1[1] * paramArrayOfFloat2[3] + paramArrayOfFloat1[2] * paramArrayOfFloat2[6], paramArrayOfFloat1[0] * paramArrayOfFloat2[1] + paramArrayOfFloat1[1] * paramArrayOfFloat2[4] + paramArrayOfFloat1[2] * paramArrayOfFloat2[7], paramArrayOfFloat1[0] * paramArrayOfFloat2[2] + paramArrayOfFloat1[1] * paramArrayOfFloat2[5] + paramArrayOfFloat1[2] * paramArrayOfFloat2[8], paramArrayOfFloat1[3] * paramArrayOfFloat2[0] + paramArrayOfFloat1[4] * paramArrayOfFloat2[3] + paramArrayOfFloat1[5] * paramArrayOfFloat2[6], paramArrayOfFloat1[3] * paramArrayOfFloat2[1] + paramArrayOfFloat1[4] * paramArrayOfFloat2[4] + paramArrayOfFloat1[5] * paramArrayOfFloat2[7], paramArrayOfFloat1[3] * paramArrayOfFloat2[2] + paramArrayOfFloat1[4] * paramArrayOfFloat2[5] + paramArrayOfFloat1[5] * paramArrayOfFloat2[8], paramArrayOfFloat1[6] * paramArrayOfFloat2[0] + paramArrayOfFloat1[7] * paramArrayOfFloat2[3] + paramArrayOfFloat1[8] * paramArrayOfFloat2[6], paramArrayOfFloat1[6] * paramArrayOfFloat2[1] + paramArrayOfFloat1[7] * paramArrayOfFloat2[4] + paramArrayOfFloat1[8] * paramArrayOfFloat2[7], paramArrayOfFloat1[6] * paramArrayOfFloat2[2] + paramArrayOfFloat1[7] * paramArrayOfFloat2[5] + paramArrayOfFloat1[8] * paramArrayOfFloat2[8] };
  }
  
  static u nD()
  {
    if (aNw == null) {
      aNw = new u();
    }
    return aNw;
  }
  
  final void O(Context paramContext) {}
  
  final void P(Context paramContext)
  {
    if (this.aNy != null) {
      this.aNy.stop();
    }
    if (this.aJs != null) {}
    try
    {
      this.aJs.unregisterListener(this);
      this.aJs = null;
      this.aNi = null;
      this.aNh = null;
      this.aNg = null;
      this.aNf = null;
      this.aNe = null;
      this.aNj = 0L;
      this.aNk = true;
      this.aNl = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
      this.aNm = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 9 }));
      this.aNo = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.aNp = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.aNq = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 3 }));
      this.aNz = new boolean[6];
      this.aNA = new int[6];
      this.aNB = new float[6];
      this.aNC = new float[6];
      this.aND = new float[] { NaN.0F, NaN.0F, NaN.0F, NaN.0F, NaN.0F, NaN.0F };
      this.aNE = ((float[][])Array.newInstance(Float.TYPE, new int[] { 6, 20 }));
      this.aNH.reset();
      this.aNF.reset();
      this.aNG.reset();
      return;
    }
    catch (Error paramContext)
    {
      for (;;) {}
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    if (paramContext == null) {
      try
      {
        throw new Exception("SensorModule: register with null context");
      }
      catch (Exception paramContext)
      {
        this.aNx = false;
      }
    }
    label24:
    label300:
    label390:
    label394:
    for (;;)
    {
      return;
      int i = 0;
      boolean bool;
      if (i > 5)
      {
        this.aJs = ((SensorManager)paramContext.getSystemService("sensor"));
        this.aNe = this.aJs.getDefaultSensor(10);
        this.aNh = this.aJs.getDefaultSensor(9);
        if ((this.aNe == null) || (this.aNh == null)) {
          break label390;
        }
        this.aNi = this.aJs.getDefaultSensor(11);
        if (this.aNi == null) {
          break label300;
        }
        bool = a(this.aJs, this, aNc, aNd, paramHandler, new Sensor[] { this.aNe, this.aNh, this.aNi });
      }
      for (;;)
      {
        if (!bool) {
          break label394;
        }
        this.aNx = true;
        this.aNy = new c(paramHandler);
        if (this.aNy == null) {
          break;
        }
        this.aNy.b(Math.round(50.0F), 1000L);
        return;
        this.aNm[i][0] = 1065353216;
        this.aNm[i][1] = 0;
        this.aNm[i][2] = 0;
        this.aNm[i][3] = 0;
        this.aNm[i][4] = 1065353216;
        this.aNm[i][5] = 0;
        this.aNm[i][6] = 0;
        this.aNm[i][7] = 0;
        this.aNm[i][8] = 1065353216;
        i += 1;
        break label24;
        this.aNf = this.aJs.getDefaultSensor(4);
        this.aNg = this.aJs.getDefaultSensor(2);
        if ((this.aNf != null) && (this.aNg != null)) {
          bool = a(this.aJs, this, aNc, aNd, paramHandler, new Sensor[] { this.aNe, this.aNh, this.aNf, this.aNg });
        } else {
          bool = false;
        }
      }
    }
  }
  
  final void a(Handler paramHandler, d.a parama)
  {
    try
    {
      super.a(paramHandler, parama);
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  final void ne() {}
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int j = 0;
    int i = 0;
    switch (paramSensorEvent.sensor.getType())
    {
    }
    for (;;)
    {
      return;
      Object localObject3 = new float[16];
      if (this.aNi != null) {}
      float[] arrayOfFloat1;
      for (Object localObject1 = this.aNn;; localObject1 = this.aNm)
      {
        localObject1 = localObject1[2];
        arrayOfFloat1 = new float[16];
        if (localObject1.length == 9)
        {
          arrayOfFloat1[0] = localObject1[0];
          arrayOfFloat1[1] = localObject1[1];
          arrayOfFloat1[2] = localObject1[2];
          arrayOfFloat1[3] = 0.0F;
          arrayOfFloat1[4] = localObject1[3];
          arrayOfFloat1[5] = localObject1[4];
          arrayOfFloat1[6] = localObject1[5];
          arrayOfFloat1[7] = 0.0F;
          arrayOfFloat1[8] = localObject1[6];
          arrayOfFloat1[9] = localObject1[7];
          arrayOfFloat1[10] = localObject1[8];
          arrayOfFloat1[11] = 0.0F;
          arrayOfFloat1[12] = 0.0F;
          arrayOfFloat1[13] = 0.0F;
          arrayOfFloat1[14] = 0.0F;
          arrayOfFloat1[15] = 1.0F;
        }
        Matrix.invertM((float[])localObject3, 0, arrayOfFloat1, 0);
        Matrix.multiplyMV(this.aNs, 0, (float[])localObject3, 0, new float[] { paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2], 0.0F }, 0);
        this.aNF.a(this.aNs, paramSensorEvent.values, this.aNv[2]);
        return;
      }
      a(paramSensorEvent.values, this.aNv);
      if ((this.aNu[2][0] == 0.0F) && (this.aNu[2][1] == 0.0F) && (this.aNu[2][2] == 0.0F)) {
        continue;
      }
      paramSensorEvent = this.aNl;
      localObject1 = this.aNv;
      localObject3 = this.aNu;
      if ((SensorManager.getRotationMatrix(paramSensorEvent[0], null, localObject1[0], localObject3[0])) && (SensorManager.getRotationMatrix(paramSensorEvent[1], null, localObject1[1], localObject3[1])) && (SensorManager.getRotationMatrix(paramSensorEvent[2], null, localObject1[2], localObject3[2])) && (SensorManager.getRotationMatrix(paramSensorEvent[3], null, localObject1[3], localObject3[3])) && (SensorManager.getRotationMatrix(paramSensorEvent[4], null, localObject1[4], localObject3[4])) && (SensorManager.getRotationMatrix(paramSensorEvent[5], null, localObject1[5], localObject3[5]))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label596;
        }
        a(this.aNl, this.aNo);
        if ((this.aNp[2][0] != 0.0F) || (this.aNp[2][1] != 0.0F) || (this.aNp[2][2] != 0.0F)) {
          break;
        }
        paramSensorEvent = this.aNo;
        localObject1 = this.aNp;
        i = 0;
        while (i <= 5)
        {
          System.arraycopy(paramSensorEvent[i], 0, localObject1[i], 0, 3);
          i += 1;
        }
        break;
      }
      label596:
      continue;
      try
      {
        SensorManager.getRotationMatrixFromVector(this.aNn[2], paramSensorEvent.values);
        SensorManager.remapCoordinateSystem(this.aNn[2], 2, 129, this.aNn[0]);
        SensorManager.remapCoordinateSystem(this.aNn[2], 130, 1, this.aNn[1]);
        SensorManager.remapCoordinateSystem(this.aNn[2], 129, 130, this.aNn[3]);
        SensorManager.remapCoordinateSystem(this.aNn[2], 129, 3, this.aNn[4]);
        SensorManager.remapCoordinateSystem(this.aNn[2], 1, 3, this.aNn[5]);
        while (i <= 5)
        {
          SensorManager.getOrientation(this.aNn[i], this.aNr[i]);
          i += 1;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (paramSensorEvent.values.length > 3) {
            SensorManager.getRotationMatrixFromVector(this.aNn[2], new float[] { paramSensorEvent.values[0], paramSensorEvent.values[1], paramSensorEvent.values[2] });
          }
        }
      }
      if ((this.aNo[2][0] == 0.0F) && (this.aNo[2][1] == 0.0F) && (this.aNo[2][2] == 0.0F)) {
        continue;
      }
      Object localObject2;
      float f1;
      if (this.aNk)
      {
        i = 0;
        if (i > 5) {
          this.aNk = false;
        }
      }
      else
      {
        localObject2 = (float[][])Array.newInstance(Float.TYPE, new int[] { 6, 4 });
        if (this.aNj != 0L)
        {
          f1 = (float)(paramSensorEvent.timestamp - this.aNj);
          a(paramSensorEvent.values, this.aNt);
          i = 0;
        }
      }
      label933:
      float f2;
      float f3;
      for (;;)
      {
        if (i > 5)
        {
          this.aNj = paramSensorEvent.timestamp;
          i = j;
          if (i <= 5) {
            break label1170;
          }
          a(this.aNm, this.aNp);
          return;
          localObject2 = this.aNl[i];
          this.aNm[i] = a(this.aNm[i], (float[])localObject2);
          i += 1;
          break;
        }
        localObject3 = this.aNt[i];
        arrayOfFloat1 = localObject2[i];
        f2 = 1.0E-9F * f1 / 2.0F;
        float[] arrayOfFloat2 = new float[3];
        f3 = (float)Math.sqrt(localObject3[0] * localObject3[0] + localObject3[1] * localObject3[1] + localObject3[2] * localObject3[2]);
        if (f3 > 1.0E-9F)
        {
          localObject3[0] /= f3;
          localObject3[1] /= f3;
          localObject3[2] /= f3;
        }
        f3 *= f2;
        f2 = (float)Math.sin(f3);
        f3 = (float)Math.cos(f3);
        arrayOfFloat2[0] *= f2;
        arrayOfFloat2[1] *= f2;
        arrayOfFloat1[2] = (f2 * arrayOfFloat2[2]);
        arrayOfFloat1[3] = f3;
        i += 1;
      }
      label1170:
      paramSensorEvent = new float[9];
      try
      {
        SensorManager.getRotationMatrixFromVector(paramSensorEvent, localObject2[i]);
        this.aNm[i] = a(this.aNm[i], paramSensorEvent);
        i += 1;
        break label933;
        a(paramSensorEvent.values, this.aNu);
        localObject2 = this.aNH;
        paramSensorEvent = paramSensorEvent.values;
        if (paramSensorEvent.length < 3) {
          continue;
        }
        ((a)localObject2).aNI += 1;
        double d = ((a)localObject2).aNJ;
        f1 = paramSensorEvent[0];
        f2 = paramSensorEvent[0];
        f3 = paramSensorEvent[1];
        float f4 = paramSensorEvent[1];
        float f5 = paramSensorEvent[2];
        ((a)localObject2).aNJ = ((float)(Math.sqrt(f2 * f1 + f4 * f3 + paramSensorEvent[2] * f5) + d));
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  private static final class a
  {
    int aNI = 0;
    float aNJ = 0.0F;
    long aNK = 0L;
    float aNL = 0.0F;
    boolean aNM = false;
    long aNN = 0L;
    float[] aNO = new float[6];
    float[] aNP = new float[6];
    float[] aNQ = new float[6];
    float[] aNR = new float[6];
    float[] aNS = new float[6];
    float[] aNT = new float[6];
    public float[] aNU = new float[6];
    public float[] aNV = new float[6];
    public float[] aNW = new float[6];
    float aNX = 0.0F;
    float aNY = Float.NEGATIVE_INFINITY;
    float aNZ = Float.POSITIVE_INFINITY;
    public boolean aOa = false;
    
    public final void reset()
    {
      this.aNI = 0;
      this.aNJ = 0.0F;
      this.aNK = 0L;
      this.aNL = 0.0F;
      this.aNM = false;
      this.aNN = 0L;
      this.aNO = new float[6];
      this.aNP = new float[6];
      this.aNQ = new float[6];
      this.aNX = 0.0F;
      this.aNY = Float.NEGATIVE_INFINITY;
      this.aNZ = Float.POSITIVE_INFINITY;
    }
  }
  
  private static final class b
  {
    public float aOb;
    public float aOc;
    public float aOd;
    public float aOe;
    public float aOf;
    public float aOg;
    public float aOh;
    public float aOi;
    public float aOj;
    public float aOk;
    public float aOl;
    public float[] aOm = new float[6];
    public float[] aOn = new float[6];
    public float[] aOo = new float[6];
    public float[] aOp = new float[6];
    public float[] aOq = new float[6];
    public long time;
  }
  
  private final class c
    extends e
  {
    c(Handler paramHandler)
    {
      super();
    }
    
    final void ni()
    {
      u localu = u.this;
      int j;
      Object localObject2;
      if ((localu.aNe != null) && (localu.aNf != null) && (localu.aNg != null) && (localu.aNh != null))
      {
        j = 0;
        if (j <= 5) {}
      }
      else
      {
        localObject2 = localu.aNF;
        if (localu.aNi == null) {
          break label2524;
        }
      }
      label129:
      label262:
      label302:
      label341:
      label531:
      label601:
      label640:
      label685:
      label724:
      label769:
      label1129:
      label1325:
      label1468:
      label1485:
      label1527:
      label1640:
      label1811:
      label1868:
      label1876:
      label1882:
      label1907:
      label2128:
      label2247:
      label2412:
      label2417:
      label2422:
      label2439:
      label2456:
      label2473:
      label2490:
      label2507:
      label2524:
      for (Object localObject1 = localu.aNr;; localObject1 = localu.aNq)
      {
        localObject1 = ((u.d)localObject2).a((float[][])localObject1);
        if (localObject1 != null) {
          localu.aNG.a((u.b)localObject1);
        }
        return;
        int i = 0;
        float[] arrayOfFloat1;
        float[] arrayOfFloat2;
        float f2;
        float f1;
        float f3;
        boolean bool;
        if (Float.isNaN(localu.aND[j]))
        {
          localu.aND[j] = localu.aNp[j][0];
          localObject1 = localu.aNH;
          arrayOfFloat1 = localu.aNp[j];
          localObject2 = localu.aNo[j];
          arrayOfFloat2 = localu.aNq[j];
          if ((j == 0) && (((u.a)localObject1).aNI != 0))
          {
            ((u.a)localObject1).aNK += 1L;
            ((u.a)localObject1).aNX = (((u.a)localObject1).aNJ / ((u.a)localObject1).aNI);
            f2 = ((u.a)localObject1).aNX - ((u.a)localObject1).aNL;
            f1 = Math.abs(f2);
            f3 = ((u.a)localObject1).aNL;
            if ((((u.a)localObject1).aNL != 0.0F) && (((u.a)localObject1).aNK > 20L) && (f1 > 1.25F)) {
              break label1868;
            }
            f1 = 1.0F;
            ((u.a)localObject1).aNL = (f1 * (f2 / (float)((u.a)localObject1).aNK) + f3);
            if (Math.abs(((u.a)localObject1).aNX - ((u.a)localObject1).aNL) < 1.25F) {
              break label1876;
            }
            bool = true;
            ((u.a)localObject1).aNM = bool;
            if (!((u.a)localObject1).aNM) {
              break label1882;
            }
            if (((u.a)localObject1).aNN < 1200L) {
              ((u.a)localObject1).aNN += 1L;
            }
            ((u.a)localObject1).aNI = 0;
            ((u.a)localObject1).aNJ = 0.0F;
            if (((u.a)localObject1).aNX < ((u.a)localObject1).aNZ) {
              ((u.a)localObject1).aNZ = ((u.a)localObject1).aNX;
            }
            if (((u.a)localObject1).aNX > ((u.a)localObject1).aNY) {
              ((u.a)localObject1).aNY = ((u.a)localObject1).aNX;
            }
            if ((((u.a)localObject1).aNK == 20L) && (Math.max(((u.a)localObject1).aNY - ((u.a)localObject1).aNL, ((u.a)localObject1).aNL - ((u.a)localObject1).aNZ) > 5.0F)) {
              ((u.a)localObject1).reset();
            }
          }
          if (((u.a)localObject1).aNK > 20L) {
            break label1907;
          }
          arrayOfFloat1 = ((u.a)localObject1).aNU;
          arrayOfFloat2 = ((u.a)localObject1).aNV;
          ((u.a)localObject1).aNW[j] = 1.0F;
          arrayOfFloat2[j] = 1.0F;
          arrayOfFloat1[j] = 1.0F;
          arrayOfFloat1 = ((u.a)localObject1).aNR;
          arrayOfFloat2 = ((u.a)localObject1).aNS;
          ((u.a)localObject1).aNT[j] = 0.0F;
          arrayOfFloat2[j] = 0.0F;
          arrayOfFloat1[j] = 0.0F;
          ((u.a)localObject1).aNO[j] = localObject2[0];
          ((u.a)localObject1).aNP[j] = localObject2[1];
          ((u.a)localObject1).aNQ[j] = localObject2[2];
          f2 = localu.aNo[j][0] - localu.aNp[j][0];
          if (f2 >= -3.1415927F) {
            break label2422;
          }
          f1 = f2 + 6.2831855F;
          f2 = localu.aNp[j][0];
          f2 = f1 * localu.aNH.aNU[j] + f2;
          if (f2 >= -3.1415927F) {
            break label2439;
          }
          f1 = f2 + 6.2831855F;
          localu.aNq[j][0] = f1;
          f2 = localu.aNo[j][1] - localu.aNp[j][1];
          if (f2 >= -3.1415927F) {
            break label2456;
          }
          f1 = f2 + 6.2831855F;
          f2 = localu.aNp[j][1];
          f2 = f1 * localu.aNH.aNV[j] + f2;
          if (f2 >= -3.1415927F) {
            break label2473;
          }
          f1 = f2 + 6.2831855F;
          localu.aNq[j][1] = f1;
          f2 = localu.aNo[j][2] - localu.aNp[j][2];
          if (f2 >= -3.1415927F) {
            break label2490;
          }
          f1 = f2 + 6.2831855F;
          f2 = localu.aNp[j][2];
          f2 = f1 * localu.aNH.aNW[j] + f2;
          if (f2 >= -3.1415927F) {
            break label2507;
          }
          f1 = f2 + 6.2831855F;
        }
        for (;;)
        {
          localu.aNq[j][2] = f1;
          localObject1 = localu.aNm;
          localObject2 = localu.aNq[j];
          f1 = (float)Math.sin(localObject2[1]);
          f2 = (float)Math.cos(localObject2[1]);
          f3 = (float)Math.sin(localObject2[2]);
          float f4 = (float)Math.cos(localObject2[2]);
          float f5 = (float)Math.sin(localObject2[0]);
          float f6 = (float)Math.cos(localObject2[0]);
          float f7 = -f1;
          float f8 = -f3;
          float f9 = -f5;
          localObject2 = u.a(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, f2, f1, 0.0F, f7, f2 }, new float[] { f4, 0.0F, f3, 0.0F, 1.0F, 0.0F, f8, 0.0F, f4 });
          localObject1[j] = u.a(new float[] { f6, f5, 0.0F, f9, f6, 0.0F, 0.0F, 0.0F, 1.0F }, (float[])localObject2);
          System.arraycopy(localu.aNq[j], 0, localu.aNp[j], 0, 3);
          j += 1;
          break;
          f2 = localu.aNp[j][0] - localu.aNq[j][0];
          if (f2 < -3.1415927F)
          {
            f1 = f2 + 6.2831855F;
            localObject1 = localu.aNE[j];
            localObject2 = localu.aNA;
            int k = localObject2[j];
            localObject2[j] = (k + 1);
            localObject1[k] = f1;
            if (localu.aNA[j] == 20)
            {
              localu.aNA[j] = 0;
              if (localu.aNz[j] == 0) {
                localu.aNz[j] = true;
              }
            }
            localObject1 = localu.aNC;
            localObject1[j] += f1;
            localObject1 = localu.aNB;
            localObject1[j] = (f1 + localObject1[j]);
            if (localu.aNz[j] == 0) {
              break label129;
            }
            if (Math.abs(localu.aNB[j]) >= 0.08726647F) {
              break label1640;
            }
            if (Math.abs(localu.aNC[j]) >= 0.08726647F) {
              break label1527;
            }
            f2 = localu.aNp[j][0] - localu.aND[j];
            if (f2 >= -3.1415927F) {
              break label1468;
            }
            f1 = f2 + 6.2831855F;
            localObject1 = localu.aNp[j];
            f2 = localu.aND[j];
            localObject1[0] = (f1 / 2.0F + f2);
            if (localu.aNp[j][0] >= -3.1415927F) {
              break label1485;
            }
            localu.aNp[j][0] = (6.2831855F + localu.aNp[j][0]);
          }
          for (;;)
          {
            localu.aND[j] = localu.aNp[j][0];
            i = 1;
            localObject1 = localu.aNB;
            localObject1[j] -= localu.aNE[j][localu.aNA[j]];
            break;
            f1 = f2;
            if (f2 <= 3.1415927F) {
              break label1129;
            }
            f1 = f2 - 6.2831855F;
            break label1129;
            f1 = f2;
            if (f2 <= 3.1415927F) {
              break label1325;
            }
            f1 = f2 - 6.2831855F;
            break label1325;
            if (localu.aNp[j][0] > 3.1415927F) {
              localu.aNp[j][0] -= 6.2831855F;
            }
          }
          f1 = localu.aNC[j] % 1.5707964F;
          f2 = Math.abs(f1);
          if (f2 < 0.08726647F)
          {
            localObject1 = localu.aNC;
            localObject1[j] -= f1;
            localu.aND[j] = ((localu.aND[j] + localu.aNC[j]) % 6.2831855F);
            if (localu.aND[j] < -3.1415927F) {
              localu.aND[j] = (6.2831855F + localu.aND[j]);
            }
          }
          for (;;)
          {
            localu.aNC[j] = 0.0F;
            i = 0;
            break;
            if (localu.aND[j] > 3.1415927F)
            {
              localu.aND[j] -= 6.2831855F;
              continue;
              if (f2 > 1.4835299F)
              {
                if (localu.aNC[j] > 0.0F) {
                  localu.aNC[j] = (localu.aNC[j] - f1 + 1.5707964F);
                }
                for (;;)
                {
                  localu.aND[j] = ((localu.aND[j] + localu.aNC[j]) % 6.2831855F);
                  if (localu.aND[j] >= -3.1415927F) {
                    break label1811;
                  }
                  localu.aND[j] = (6.2831855F + localu.aND[j]);
                  break;
                  localu.aNC[j] = (localu.aNC[j] - f1 - 1.5707964F);
                }
                if (localu.aND[j] > 3.1415927F) {
                  localu.aND[j] -= 6.2831855F;
                }
              }
              else
              {
                localu.aND[j] = localu.aNp[j][0];
              }
            }
          }
          f1 = 1.25F / f1;
          break label262;
          bool = false;
          break label302;
          if (((u.a)localObject1).aNN <= 0L) {
            break label341;
          }
          ((u.a)localObject1).aNN -= 1L;
          break label341;
          if ((((u.a)localObject1).aNM) || (((u.a)localObject1).aOa) || (i != 0))
          {
            arrayOfFloat1 = ((u.a)localObject1).aNR;
            arrayOfFloat2 = ((u.a)localObject1).aNS;
            ((u.a)localObject1).aNT[j] = 1.0F;
            arrayOfFloat2[j] = 1.0F;
            arrayOfFloat1[j] = 1.0F;
            arrayOfFloat1 = ((u.a)localObject1).aNU;
            arrayOfFloat2 = ((u.a)localObject1).aNV;
            ((u.a)localObject1).aNW[j] = 0.0F;
            arrayOfFloat2[j] = 0.0F;
            arrayOfFloat1[j] = 0.0F;
            break label531;
          }
          if (((u.a)localObject1).aNN > 0L)
          {
            ((u.a)localObject1).aNO[j] = arrayOfFloat2[0];
            ((u.a)localObject1).aNP[j] = arrayOfFloat2[1];
            ((u.a)localObject1).aNQ[j] = arrayOfFloat2[2];
          }
          f2 = Math.abs(arrayOfFloat2[0] - arrayOfFloat1[0]);
          f1 = f2;
          if (f2 > 3.1415927F) {
            f1 = 6.2831855F - f2;
          }
          f3 = Math.abs(localObject1.aNO[j] - localObject2[0]);
          f2 = f3;
          if (f3 > 3.1415927F) {
            f2 = 6.2831855F - f3;
          }
          f3 = Math.max(f2, f1);
          if (f3 != 0.0F)
          {
            f1 = ((f2 - f1) / f3 + 1.0F) * 0.5F;
            ((u.a)localObject1).aNR[j] = ((f1 + localObject1.aNR[j]) / 2.0F);
            ((u.a)localObject1).aNU[j] = (1.0F - localObject1.aNR[j]);
            f2 = Math.abs(arrayOfFloat2[1] - arrayOfFloat1[1]);
            f1 = f2;
            if (f2 > 3.1415927F) {
              f1 = 6.2831855F - f2;
            }
            f3 = Math.abs(localObject1.aNP[j] - localObject2[1]);
            f2 = f3;
            if (f3 > 3.1415927F) {
              f2 = 6.2831855F - f3;
            }
            f3 = Math.max(f2, f1);
            if (f3 == 0.0F) {
              break label2412;
            }
            f1 = ((f2 - f1) / f3 + 1.0F) * 0.5F;
            ((u.a)localObject1).aNS[j] = ((f1 + localObject1.aNS[j]) / 2.0F);
            ((u.a)localObject1).aNV[j] = (1.0F - localObject1.aNS[j]);
            f2 = Math.abs(arrayOfFloat2[2] - arrayOfFloat1[2]);
            f1 = f2;
            if (f2 > 3.1415927F) {
              f1 = 6.2831855F - f2;
            }
            f3 = Math.abs(localObject1.aNQ[j] - localObject2[2]);
            f2 = f3;
            if (f3 > 3.1415927F) {
              f2 = 6.2831855F - f3;
            }
            f3 = Math.max(f2, f1);
            if (f3 == 0.0F) {
              break label2417;
            }
          }
          for (f1 = ((f2 - f1) / f3 + 1.0F) * 0.5F;; f1 = 1.0F)
          {
            ((u.a)localObject1).aNT[j] = ((f1 + localObject1.aNT[j]) / 2.0F);
            ((u.a)localObject1).aNW[j] = (1.0F - localObject1.aNT[j]);
            break;
            f1 = 1.0F;
            break label2128;
            f1 = 1.0F;
            break label2247;
          }
          f1 = f2;
          if (f2 <= 3.1415927F) {
            break label601;
          }
          f1 = f2 - 6.2831855F;
          break label601;
          f1 = f2;
          if (f2 <= 3.1415927F) {
            break label640;
          }
          f1 = f2 - 6.2831855F;
          break label640;
          f1 = f2;
          if (f2 <= 3.1415927F) {
            break label685;
          }
          f1 = f2 - 6.2831855F;
          break label685;
          f1 = f2;
          if (f2 <= 3.1415927F) {
            break label724;
          }
          f1 = f2 - 6.2831855F;
          break label724;
          f1 = f2;
          if (f2 <= 3.1415927F) {
            break label769;
          }
          f1 = f2 - 6.2831855F;
          break label769;
          f1 = f2;
          if (f2 > 3.1415927F) {
            f1 = f2 - 6.2831855F;
          }
        }
      }
    }
  }
  
  private static final class d
  {
    private float aOA = 0.0F;
    private float aOs = 0.0F;
    private float aOt = 0.0F;
    private float aOu = 0.0F;
    private float aOv = 0.0F;
    private float aOw = 0.0F;
    private float aOx = 0.0F;
    private float aOy = 0.0F;
    private float aOz = 0.0F;
    private int count = 0;
    
    public final u.b a(float[][] paramArrayOfFloat)
    {
      int i = 0;
      for (;;)
      {
        u.b localb;
        try
        {
          if (this.count > 0)
          {
            int j = paramArrayOfFloat.length;
            if (j >= 3) {}
          }
          else
          {
            paramArrayOfFloat = null;
            return paramArrayOfFloat;
          }
          localb = new u.b();
          localb.time = SystemClock.elapsedRealtime();
          if (i > 5)
          {
            localb.aOb = (this.aOs / this.count);
            localb.aOc = (this.aOt / this.count);
            localb.aOd = (this.aOu / this.count);
            localb.aOe = (this.aOv / this.count);
            localb.aOf = (this.aOw / this.count);
            localb.aOg = (this.aOx / this.count);
            localb.aOh = (this.aOy / this.count);
            localb.aOi = (this.aOz / this.count);
            localb.aOj = (this.aOA / this.count);
            localb.aOl = ((float)Math.sqrt(localb.aOb * localb.aOb + localb.aOc * localb.aOc));
            reset();
            paramArrayOfFloat = localb;
            continue;
          }
          localb.aOm[i] = paramArrayOfFloat[i][0];
        }
        finally {}
        localb.aOn[i] = paramArrayOfFloat[i][1];
        localb.aOo[i] = paramArrayOfFloat[i][2];
        localb.aOp[i] = ((float)Math.sin(localb.aOm[i]));
        localb.aOq[i] = ((float)Math.cos(localb.aOm[i]));
        i += 1;
      }
    }
    
    public final void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
    {
      try
      {
        if (paramArrayOfFloat1.length >= 3)
        {
          this.count += 1;
          this.aOs += paramArrayOfFloat1[0];
          this.aOt += paramArrayOfFloat1[1];
          this.aOu += paramArrayOfFloat1[2];
          this.aOv += paramArrayOfFloat2[0];
          this.aOw += paramArrayOfFloat2[1];
          this.aOx += paramArrayOfFloat2[2];
          this.aOy += paramArrayOfFloat3[0];
          this.aOz += paramArrayOfFloat3[1];
          this.aOA += paramArrayOfFloat3[2];
        }
        return;
      }
      finally
      {
        paramArrayOfFloat1 = finally;
        throw paramArrayOfFloat1;
      }
    }
    
    public final void reset()
    {
      try
      {
        this.count = 0;
        this.aOs = 0.0F;
        this.aOt = 0.0F;
        this.aOu = 0.0F;
        this.aOv = 0.0F;
        this.aOw = 0.0F;
        this.aOx = 0.0F;
        this.aOy = 0.0F;
        this.aOz = 0.0F;
        this.aOA = 0.0F;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  static final class e
    extends p
  {
    final float aLi;
    final float aOB;
    final float aOC;
    final int aOD;
    final float x;
    final float y;
    
    public e(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5)
    {
      super();
      this.x = paramFloat1;
      this.y = paramFloat2;
      this.aOD = paramInt;
      this.aOB = paramFloat3;
      this.aOC = paramFloat4;
      this.aLi = paramFloat5;
    }
  }
  
  private final class f
  {
    private ArrayList<u.b> aOE = new ArrayList();
    private a[] aOF = new a[5];
    private int aOG = 0;
    private float[][] aOH;
    private float[][] aOI;
    private float[][] aOJ;
    private int[] aOK;
    private int aOL;
    public int aOM;
    private int aON;
    
    public f()
    {
      this$1 = new float[] { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F };
      this.aOH = new float[][] { { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F }, { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F }, u.this };
      this.aOI = new float[][] { { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F }, { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F }, { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F } };
      this.aOJ = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 3 }));
      this.aOK = new int[6];
      this.aOL = 5;
      this.aOM = -1;
      this.aON = 0;
    }
    
    /* Error */
    private void a(a parama)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 42	com/c/a/a/u$f:aOF	[Lcom/c/a/a/u$f$a;
      //   6: iconst_1
      //   7: aload_0
      //   8: getfield 42	com/c/a/a/u$f:aOF	[Lcom/c/a/a/u$f$a;
      //   11: iconst_0
      //   12: iconst_4
      //   13: invokestatic 83	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   16: aload_0
      //   17: getfield 42	com/c/a/a/u$f:aOF	[Lcom/c/a/a/u$f$a;
      //   20: iconst_4
      //   21: aaload
      //   22: ifnull +138 -> 160
      //   25: invokestatic 89	android/os/SystemClock:elapsedRealtime	()J
      //   28: aload_1
      //   29: getfield 93	com/c/a/a/u$f$a:aOS	J
      //   32: lsub
      //   33: ldc2_w 94
      //   36: lcmp
      //   37: ifle +123 -> 160
      //   40: aload_0
      //   41: getfield 42	com/c/a/a/u$f:aOF	[Lcom/c/a/a/u$f$a;
      //   44: iconst_4
      //   45: aaload
      //   46: astore_2
      //   47: aload_2
      //   48: aload_2
      //   49: getfield 99	com/c/a/a/u$f$a:x	F
      //   52: aload_1
      //   53: getfield 99	com/c/a/a/u$f$a:x	F
      //   56: fadd
      //   57: fconst_2
      //   58: fdiv
      //   59: putfield 99	com/c/a/a/u$f$a:x	F
      //   62: aload_2
      //   63: aload_2
      //   64: getfield 102	com/c/a/a/u$f$a:y	F
      //   67: aload_1
      //   68: getfield 102	com/c/a/a/u$f$a:y	F
      //   71: fadd
      //   72: fconst_2
      //   73: fdiv
      //   74: putfield 102	com/c/a/a/u$f$a:y	F
      //   77: aload_2
      //   78: aload_2
      //   79: getfield 105	com/c/a/a/u$f$a:z	F
      //   82: aload_1
      //   83: getfield 105	com/c/a/a/u$f$a:z	F
      //   86: fadd
      //   87: fconst_2
      //   88: fdiv
      //   89: putfield 105	com/c/a/a/u$f$a:z	F
      //   92: aload_2
      //   93: aload_2
      //   94: getfield 108	com/c/a/a/u$f$a:aOO	I
      //   97: aload_1
      //   98: getfield 108	com/c/a/a/u$f$a:aOO	I
      //   101: iadd
      //   102: i2f
      //   103: fconst_2
      //   104: fdiv
      //   105: invokestatic 114	java/lang/Math:round	(F)I
      //   108: putfield 108	com/c/a/a/u$f$a:aOO	I
      //   111: aload_2
      //   112: aload_2
      //   113: getfield 117	com/c/a/a/u$f$a:aOP	F
      //   116: aload_1
      //   117: getfield 117	com/c/a/a/u$f$a:aOP	F
      //   120: fadd
      //   121: fconst_2
      //   122: fdiv
      //   123: putfield 117	com/c/a/a/u$f$a:aOP	F
      //   126: aload_2
      //   127: aload_2
      //   128: getfield 120	com/c/a/a/u$f$a:aOQ	F
      //   131: aload_1
      //   132: getfield 120	com/c/a/a/u$f$a:aOQ	F
      //   135: fadd
      //   136: fconst_2
      //   137: fdiv
      //   138: putfield 120	com/c/a/a/u$f$a:aOQ	F
      //   141: aload_2
      //   142: aload_1
      //   143: getfield 93	com/c/a/a/u$f$a:aOS	J
      //   146: putfield 93	com/c/a/a/u$f$a:aOS	J
      //   149: aload_2
      //   150: aload_1
      //   151: getfield 123	com/c/a/a/u$f$a:aOR	F
      //   154: putfield 123	com/c/a/a/u$f$a:aOR	F
      //   157: aload_0
      //   158: monitorexit
      //   159: return
      //   160: aload_0
      //   161: getfield 42	com/c/a/a/u$f:aOF	[Lcom/c/a/a/u$f$a;
      //   164: iconst_4
      //   165: aload_1
      //   166: aastore
      //   167: goto -10 -> 157
      //   170: astore_1
      //   171: aload_0
      //   172: monitorexit
      //   173: aload_1
      //   174: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	175	0	this	f
      //   0	175	1	parama	a
      //   46	104	2	locala	a
      // Exception table:
      //   from	to	target	type
      //   2	157	170	finally
      //   160	167	170	finally
    }
    
    /* Error */
    private boolean nE()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 44	com/c/a/a/u$f:aOG	I
      //   6: bipush 20
      //   8: if_icmplt +703 -> 711
      //   11: aload_0
      //   12: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   15: iconst_0
      //   16: aaload
      //   17: astore 17
      //   19: aload 17
      //   21: iconst_2
      //   22: aload 17
      //   24: iconst_2
      //   25: faload
      //   26: ldc 126
      //   28: fdiv
      //   29: fastore
      //   30: aload_0
      //   31: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   34: iconst_1
      //   35: aaload
      //   36: astore 17
      //   38: aload 17
      //   40: iconst_2
      //   41: aload 17
      //   43: iconst_2
      //   44: faload
      //   45: ldc 126
      //   47: fdiv
      //   48: fastore
      //   49: aload_0
      //   50: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   53: iconst_2
      //   54: aaload
      //   55: astore 17
      //   57: aload 17
      //   59: iconst_2
      //   60: aload 17
      //   62: iconst_2
      //   63: faload
      //   64: ldc 126
      //   66: fdiv
      //   67: fastore
      //   68: aload_0
      //   69: getfield 52	com/c/a/a/u$f:aOI	[[F
      //   72: iconst_0
      //   73: aaload
      //   74: astore 17
      //   76: aload 17
      //   78: iconst_2
      //   79: aload 17
      //   81: iconst_2
      //   82: faload
      //   83: ldc 126
      //   85: fdiv
      //   86: fastore
      //   87: aload_0
      //   88: getfield 52	com/c/a/a/u$f:aOI	[[F
      //   91: iconst_1
      //   92: aaload
      //   93: astore 17
      //   95: aload 17
      //   97: iconst_2
      //   98: aload 17
      //   100: iconst_2
      //   101: faload
      //   102: ldc 126
      //   104: fdiv
      //   105: fastore
      //   106: aload_0
      //   107: getfield 52	com/c/a/a/u$f:aOI	[[F
      //   110: iconst_2
      //   111: aaload
      //   112: astore 17
      //   114: aload 17
      //   116: iconst_2
      //   117: aload 17
      //   119: iconst_2
      //   120: faload
      //   121: ldc 126
      //   123: fdiv
      //   124: fastore
      //   125: aload_0
      //   126: getfield 52	com/c/a/a/u$f:aOI	[[F
      //   129: iconst_0
      //   130: aaload
      //   131: iconst_2
      //   132: faload
      //   133: fstore_1
      //   134: aload_0
      //   135: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   138: iconst_0
      //   139: aaload
      //   140: iconst_0
      //   141: faload
      //   142: fstore_2
      //   143: aload_0
      //   144: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   147: iconst_0
      //   148: aaload
      //   149: iconst_2
      //   150: faload
      //   151: fstore_3
      //   152: aload_0
      //   153: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   156: iconst_0
      //   157: aaload
      //   158: iconst_2
      //   159: faload
      //   160: fstore 4
      //   162: aload_0
      //   163: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   166: iconst_0
      //   167: aaload
      //   168: iconst_1
      //   169: faload
      //   170: fstore 5
      //   172: aload_0
      //   173: getfield 52	com/c/a/a/u$f:aOI	[[F
      //   176: iconst_1
      //   177: aaload
      //   178: iconst_2
      //   179: faload
      //   180: fstore 6
      //   182: aload_0
      //   183: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   186: iconst_1
      //   187: aaload
      //   188: iconst_0
      //   189: faload
      //   190: fstore 7
      //   192: aload_0
      //   193: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   196: iconst_1
      //   197: aaload
      //   198: iconst_2
      //   199: faload
      //   200: fstore 8
      //   202: aload_0
      //   203: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   206: iconst_1
      //   207: aaload
      //   208: iconst_2
      //   209: faload
      //   210: fstore 9
      //   212: aload_0
      //   213: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   216: iconst_1
      //   217: aaload
      //   218: iconst_1
      //   219: faload
      //   220: fstore 10
      //   222: aload_0
      //   223: getfield 52	com/c/a/a/u$f:aOI	[[F
      //   226: iconst_2
      //   227: aaload
      //   228: iconst_2
      //   229: faload
      //   230: fstore 11
      //   232: aload_0
      //   233: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   236: iconst_2
      //   237: aaload
      //   238: iconst_0
      //   239: faload
      //   240: fstore 12
      //   242: aload_0
      //   243: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   246: iconst_2
      //   247: aaload
      //   248: iconst_2
      //   249: faload
      //   250: fstore 13
      //   252: aload_0
      //   253: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   256: iconst_2
      //   257: aaload
      //   258: iconst_2
      //   259: faload
      //   260: fstore 14
      //   262: aload_0
      //   263: getfield 50	com/c/a/a/u$f:aOH	[[F
      //   266: iconst_2
      //   267: aaload
      //   268: iconst_1
      //   269: faload
      //   270: fstore 15
      //   272: aload_0
      //   273: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   276: iconst_0
      //   277: aaload
      //   278: iconst_0
      //   279: fload_1
      //   280: ldc 127
      //   282: fmul
      //   283: ldc -128
      //   285: aload_0
      //   286: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   289: iconst_0
      //   290: aaload
      //   291: iconst_0
      //   292: faload
      //   293: fmul
      //   294: fadd
      //   295: fastore
      //   296: aload_0
      //   297: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   300: iconst_0
      //   301: aaload
      //   302: iconst_1
      //   303: fload_2
      //   304: fload_3
      //   305: fsub
      //   306: ldc 127
      //   308: fmul
      //   309: ldc -128
      //   311: aload_0
      //   312: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   315: iconst_0
      //   316: aaload
      //   317: iconst_1
      //   318: faload
      //   319: fmul
      //   320: fadd
      //   321: fastore
      //   322: aload_0
      //   323: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   326: iconst_0
      //   327: aaload
      //   328: iconst_2
      //   329: fload 4
      //   331: fload 5
      //   333: fsub
      //   334: ldc 127
      //   336: fmul
      //   337: ldc -128
      //   339: aload_0
      //   340: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   343: iconst_0
      //   344: aaload
      //   345: iconst_2
      //   346: faload
      //   347: fmul
      //   348: fadd
      //   349: fastore
      //   350: aload_0
      //   351: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   354: iconst_1
      //   355: aaload
      //   356: iconst_0
      //   357: ldc -128
      //   359: aload_0
      //   360: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   363: iconst_1
      //   364: aaload
      //   365: iconst_0
      //   366: faload
      //   367: fmul
      //   368: fload 6
      //   370: ldc 127
      //   372: fmul
      //   373: fadd
      //   374: fastore
      //   375: aload_0
      //   376: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   379: iconst_1
      //   380: aaload
      //   381: iconst_1
      //   382: ldc -128
      //   384: aload_0
      //   385: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   388: iconst_1
      //   389: aaload
      //   390: iconst_1
      //   391: faload
      //   392: fmul
      //   393: ldc 127
      //   395: fload 7
      //   397: fload 8
      //   399: fsub
      //   400: fmul
      //   401: fadd
      //   402: fastore
      //   403: aload_0
      //   404: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   407: iconst_1
      //   408: aaload
      //   409: iconst_2
      //   410: ldc -128
      //   412: aload_0
      //   413: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   416: iconst_1
      //   417: aaload
      //   418: iconst_2
      //   419: faload
      //   420: fmul
      //   421: ldc 127
      //   423: fload 9
      //   425: fload 10
      //   427: fsub
      //   428: fmul
      //   429: fadd
      //   430: fastore
      //   431: aload_0
      //   432: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   435: iconst_2
      //   436: aaload
      //   437: iconst_0
      //   438: ldc -128
      //   440: aload_0
      //   441: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   444: iconst_2
      //   445: aaload
      //   446: iconst_0
      //   447: faload
      //   448: fmul
      //   449: ldc 127
      //   451: fload 11
      //   453: fmul
      //   454: fadd
      //   455: fastore
      //   456: aload_0
      //   457: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   460: iconst_2
      //   461: aaload
      //   462: iconst_1
      //   463: ldc -128
      //   465: aload_0
      //   466: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   469: iconst_2
      //   470: aaload
      //   471: iconst_1
      //   472: faload
      //   473: fmul
      //   474: ldc 127
      //   476: fload 12
      //   478: fload 13
      //   480: fsub
      //   481: fmul
      //   482: fadd
      //   483: fastore
      //   484: aload_0
      //   485: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   488: iconst_2
      //   489: aaload
      //   490: iconst_2
      //   491: ldc -128
      //   493: aload_0
      //   494: getfield 67	com/c/a/a/u$f:aOJ	[[F
      //   497: iconst_2
      //   498: aaload
      //   499: iconst_2
      //   500: faload
      //   501: fmul
      //   502: ldc 127
      //   504: fload 14
      //   506: fload 15
      //   508: fsub
      //   509: fmul
      //   510: fadd
      //   511: fastore
      //   512: aload_0
      //   513: aload_0
      //   514: invokespecial 132	com/c/a/a/u$f:nF	()Lcom/c/a/a/u$f$a;
      //   517: invokespecial 134	com/c/a/a/u$f:a	(Lcom/c/a/a/u$f$a;)V
      //   520: aload_0
      //   521: iconst_0
      //   522: putfield 44	com/c/a/a/u$f:aOG	I
      //   525: iconst_3
      //   526: newarray <illegal type>
      //   528: dup
      //   529: iconst_0
      //   530: ldc 45
      //   532: fastore
      //   533: dup
      //   534: iconst_1
      //   535: ldc 46
      //   537: fastore
      //   538: dup
      //   539: iconst_2
      //   540: fconst_0
      //   541: fastore
      //   542: astore 17
      //   544: iconst_3
      //   545: newarray <illegal type>
      //   547: dup
      //   548: iconst_0
      //   549: ldc 45
      //   551: fastore
      //   552: dup
      //   553: iconst_1
      //   554: ldc 46
      //   556: fastore
      //   557: dup
      //   558: iconst_2
      //   559: fconst_0
      //   560: fastore
      //   561: astore 18
      //   563: aload_0
      //   564: iconst_3
      //   565: anewarray 48	[F
      //   568: dup
      //   569: iconst_0
      //   570: iconst_3
      //   571: newarray <illegal type>
      //   573: dup
      //   574: iconst_0
      //   575: ldc 45
      //   577: fastore
      //   578: dup
      //   579: iconst_1
      //   580: ldc 46
      //   582: fastore
      //   583: dup
      //   584: iconst_2
      //   585: fconst_0
      //   586: fastore
      //   587: aastore
      //   588: dup
      //   589: iconst_1
      //   590: aload 17
      //   592: aastore
      //   593: dup
      //   594: iconst_2
      //   595: aload 18
      //   597: aastore
      //   598: putfield 50	com/c/a/a/u$f:aOH	[[F
      //   601: aload_0
      //   602: iconst_3
      //   603: anewarray 48	[F
      //   606: dup
      //   607: iconst_0
      //   608: iconst_3
      //   609: newarray <illegal type>
      //   611: dup
      //   612: iconst_0
      //   613: ldc 45
      //   615: fastore
      //   616: dup
      //   617: iconst_1
      //   618: ldc 46
      //   620: fastore
      //   621: dup
      //   622: iconst_2
      //   623: fconst_0
      //   624: fastore
      //   625: aastore
      //   626: dup
      //   627: iconst_1
      //   628: iconst_3
      //   629: newarray <illegal type>
      //   631: dup
      //   632: iconst_0
      //   633: ldc 45
      //   635: fastore
      //   636: dup
      //   637: iconst_1
      //   638: ldc 46
      //   640: fastore
      //   641: dup
      //   642: iconst_2
      //   643: fconst_0
      //   644: fastore
      //   645: aastore
      //   646: dup
      //   647: iconst_2
      //   648: iconst_3
      //   649: newarray <illegal type>
      //   651: dup
      //   652: iconst_0
      //   653: ldc 45
      //   655: fastore
      //   656: dup
      //   657: iconst_1
      //   658: ldc 46
      //   660: fastore
      //   661: dup
      //   662: iconst_2
      //   663: fconst_0
      //   664: fastore
      //   665: aastore
      //   666: putfield 52	com/c/a/a/u$f:aOI	[[F
      //   669: aload_0
      //   670: getfield 40	com/c/a/a/u$f:aOE	Ljava/util/ArrayList;
      //   673: invokevirtual 138	java/util/ArrayList:size	()I
      //   676: bipush 100
      //   678: if_icmplt +25 -> 703
      //   681: aload_0
      //   682: getfield 40	com/c/a/a/u$f:aOE	Ljava/util/ArrayList;
      //   685: iconst_0
      //   686: bipush 20
      //   688: invokevirtual 142	java/util/ArrayList:subList	(II)Ljava/util/List;
      //   691: invokeinterface 147 1 0
      //   696: aload_0
      //   697: getfield 40	com/c/a/a/u$f:aOE	Ljava/util/ArrayList;
      //   700: invokevirtual 150	java/util/ArrayList:trimToSize	()V
      //   703: iconst_1
      //   704: istore 16
      //   706: aload_0
      //   707: monitorexit
      //   708: iload 16
      //   710: ireturn
      //   711: iconst_0
      //   712: istore 16
      //   714: goto -8 -> 706
      //   717: astore 17
      //   719: aload_0
      //   720: monitorexit
      //   721: aload 17
      //   723: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	724	0	this	f
      //   133	147	1	f1	float
      //   142	162	2	f2	float
      //   151	154	3	f3	float
      //   160	170	4	f4	float
      //   170	162	5	f5	float
      //   180	189	6	f6	float
      //   190	206	7	f7	float
      //   200	198	8	f8	float
      //   210	214	9	f9	float
      //   220	206	10	f10	float
      //   230	222	11	f11	float
      //   240	237	12	f12	float
      //   250	229	13	f13	float
      //   260	245	14	f14	float
      //   270	237	15	f15	float
      //   704	9	16	bool	boolean
      //   17	574	17	arrayOfFloat1	float[]
      //   717	5	17	localObject	Object
      //   561	35	18	arrayOfFloat2	float[]
      // Exception table:
      //   from	to	target	type
      //   2	703	717	finally
    }
    
    private a nF()
    {
      int i2;
      int j;
      a locala;
      int k;
      Object localObject6;
      Object localObject8;
      float f1;
      float f2;
      float f7;
      float f5;
      float f3;
      label378:
      float f9;
      float f10;
      label400:
      label425:
      Object localObject2;
      label824:
      label907:
      int n;
      int m;
      label948:
      int i1;
      label989:
      label1072:
      label1201:
      label1208:
      label1215:
      label1220:
      float f12;
      for (;;)
      {
        try
        {
          if (this.aON == 0)
          {
            i2 = 1;
            if (i2 == 0) {
              continue;
            }
            if (Math.abs(this.aOJ[2][0]) < 9.3D)
            {
              i = 5;
              this.aOL = i;
              this.aOK = new int[6];
              j = 0;
              if ((this.aOM >= 0) && (this.aOM <= 5)) {
                this.aOL = this.aOM;
              }
              localObject4 = new a();
              locala = new a();
              if (this.aOF[0] != null)
              {
                ((a)localObject4).aOS = this.aOF[0].aOS;
                ((a)localObject4).aOP = this.aOF[0].aOP;
              }
              if (this.aOF[4] != null)
              {
                locala.aOS = this.aOF[4].aOS;
                locala.aOP = this.aOF[4].aOP;
              }
              if (!this.aOE.isEmpty())
              {
                k = this.aOE.size();
                localObject6 = new float[6];
                localObject7 = new float[6];
                localObject8 = this.aOE.iterator();
                f1 = 0.0F;
                f2 = 0.0F;
                if (((Iterator)localObject8).hasNext()) {
                  continue;
                }
                f7 = f2 / k;
                f5 = f1 / k;
                if (j != 0) {
                  break label1201;
                }
                f11 = f7;
                localObject8 = new float[6];
                localObject8[0] = ((float)Math.atan2(localObject6[0], localObject7[0]));
                localObject8[1] = ((float)Math.atan2(localObject6[1], localObject7[1]));
                localObject8[2] = ((float)Math.atan2(localObject6[2], localObject7[2]));
                localObject8[3] = ((float)Math.atan2(localObject6[3], localObject7[3]));
                localObject8[4] = ((float)Math.atan2(localObject6[4], localObject7[4]));
                localObject8[5] = ((float)Math.atan2(localObject6[5], localObject7[5]));
                if (j != 0) {
                  break label1208;
                }
                f3 = f7;
                break label1744;
                localObject6 = this.aOE.iterator();
                f9 = 0.0F;
                f10 = 0.0F;
                i = 0;
                f2 = f5;
                if (((Iterator)localObject6).hasNext()) {
                  break;
                }
                if (((a)localObject4).aOO > 0)
                {
                  if (j != 0) {
                    break label1713;
                  }
                  f1 = 0.0F;
                  f2 = localObject2 / ((a)localObject4).aOO;
                  f3 = ((a)localObject4).aOP;
                  f2 = f1 + ((f2 - f11) / 15.0F + 0.537F);
                  f1 = f2;
                  if (f3 != 0.0F) {
                    f1 = f2 * 0.67F + 0.33F * f3;
                  }
                  ((a)localObject4).aOP = f1;
                  ((a)localObject4).x *= ((a)localObject4).aOP;
                  ((a)localObject4).y *= ((a)localObject4).aOP;
                  ((a)localObject4).aOQ = (((a)localObject4).aOO * ((a)localObject4).aOP);
                }
              }
              ((a)localObject4).aOR = (((a)localObject4).aOQ / (this.aOE.size() / 20));
              if (this.aOF[0] != null)
              {
                ((a)localObject4).x += this.aOF[0].x;
                ((a)localObject4).y += this.aOF[0].y;
                ((a)localObject4).z += this.aOF[0].z;
                ((a)localObject4).aOO += this.aOF[0].aOO;
                ((a)localObject4).aOQ += this.aOF[0].aOQ;
              }
              if ((this.aOF[4] != null) && (locala.aOO > 0))
              {
                this.aOF[4].x = ((this.aOF[4].x + ((a)localObject4).x + locala.x * ((a)localObject4).aOP) / 2.0F);
                this.aOF[4].y = ((this.aOF[4].y + ((a)localObject4).y + locala.y * ((a)localObject4).aOP) / 2.0F);
              }
              return (a)localObject4;
            }
          }
          else
          {
            i2 = 0;
            continue;
          }
          i = 2;
          continue;
          if (Math.abs(this.aOJ[0][0]) < 7.0F) {
            break label1773;
          }
          if (this.aOJ[1][1] >= 2.3F) {
            break label1767;
          }
          if (this.aOJ[1][2] < 2.3F) {
            break label1773;
          }
          break label1767;
          if (i != 0)
          {
            this.aOL = 2;
            this.aOK = new int[6];
            j = i;
            continue;
          }
          f1 = Math.abs(this.aOJ[0][0]);
          f2 = Math.abs(this.aOJ[1][0]);
          f3 = Math.abs(this.aOJ[2][0]);
          if (f1 <= f2) {
            break label1812;
          }
          if (f1 <= f3) {
            break label1806;
          }
          j = 0;
          break label1779;
          if (k < 3) {
            break label1832;
          }
          j = n * 2 + m - 1;
          Object localObject4 = this.aOK;
          localObject4[j] += 1;
          j = 0;
          break label1793;
          f2 = f1;
          if (this.aOJ[k][n] <= f1) {
            break label1894;
          }
          f2 = this.aOJ[k][n];
          i1 = k;
          m = n;
          break label1894;
          if ((j == this.aOL) || (this.aOK[j] <= this.aOK[this.aOL])) {
            break label1906;
          }
          this.aOL = j;
          break label1906;
          u.b localb = (u.b)((Iterator)localObject8).next();
          if (j == 0)
          {
            f3 = localb.aOd;
            f3 = f2 + f3;
            if (j == 0)
            {
              f2 = localb.aOl;
              break label1915;
              Object localObject1;
              f1 = localObject1;
              f2 = f3;
              if (i > 5) {
                continue;
              }
              localObject6[i] += localb.aOp[i];
              localObject7[i] += localb.aOq[i];
              i += 1;
              continue;
            }
          }
          else
          {
            f3 = localb.aOg;
            continue;
          }
          f2 = (float)Math.sqrt(localb.aOe * localb.aOe + localb.aOf * localb.aOf + localb.aOg * localb.aOg);
          localb.aOk = f2;
        }
        finally {}
        float f11 = f5;
        continue;
        f3 = f5;
        break label1744;
        f1 = 1.0F;
        break label1755;
        f12 = 0.2617994F;
      }
      Object localObject7 = (u.b)((Iterator)localObject6).next();
      if (j == 0) {}
      label1266:
      Object localObject3;
      for (float f4 = ((u.b)localObject7).aOd;; f4 = ((u.b)localObject7).aOk)
      {
        if (j != 0) {
          break label1316;
        }
        f6 = ((u.b)localObject7).aOl;
        break label1927;
        if (i > 0) {
          break label1326;
        }
        if (f4 > localObject3) {
          break label1946;
        }
        f10 = localObject7.aOp[this.aOL];
        f9 = localObject7.aOq[this.aOL];
        break;
      }
      label1316:
      float f6 = ((u.b)localObject7).aOk;
      break label1927;
      label1326:
      if (f3 < f4) {
        if (i2 == 0)
        {
          f3 = f4 - localObject3;
          if (f3 > 2.0F * f1)
          {
            f3 /= 2.0F;
            f1 = f4;
            break label1970;
            label1367:
            f4 = localObject2;
            if (i <= 10)
            {
              k = 1;
              i = k;
              if (((a)localObject5).aOS == 0L) {
                break label2009;
              }
              i = k;
              if (((u.b)localObject7).time - ((a)localObject5).aOS >= 250L) {
                break label2009;
              }
              i = 0;
              break label2009;
            }
          }
        }
      }
      for (;;)
      {
        f4 = localObject2;
        float f8;
        if (k != 0)
        {
          ((a)localObject5).aOO += 1;
          localObject2 += f1;
          f4 = localObject7.aOp[this.aOL];
          f6 = localObject7.aOq[this.aOL];
          f6 = (float)Math.atan2(f4 + f10, f6 + f9);
          f9 = Math.abs(f6 - localObject8[this.aOL]);
          f4 = f9;
          if (f9 <= 3.1415927F) {
            break label2039;
          }
          f4 = 6.2831855F - f9;
          break label2039;
        }
        for (;;)
        {
          f9 = (float)(Math.sin(f6) * f4);
          double d = Math.cos(f6);
          f6 = (float)(f4 * d);
          ((a)localObject5).x += f9;
          ((a)localObject5).y += f6;
          f4 = f8;
          if (((u.b)localObject7).time - locala.aOS > 250L)
          {
            locala.x -= f9;
            locala.y -= f6;
            locala.aOO += 1;
            f4 = f8;
          }
          ((a)localObject5).aOS = ((u.b)localObject7).time;
          f10 = localObject7.aOp[this.aOL];
          f9 = localObject7.aOq[this.aOL];
          i = 0;
          f6 = f1;
          f8 = f4;
          f1 = f3;
          f3 = f6;
          break;
          label1701:
          f6 = localObject8[this.aOL];
        }
        label1713:
        f1 = 0.08F;
        break label425;
        label1744:
        label1755:
        label1767:
        label1773:
        label1779:
        label1793:
        label1806:
        label1812:
        label1832:
        label1894:
        label1904:
        label1906:
        label1913:
        label1915:
        label1927:
        float f13;
        for (;;)
        {
          break label1982;
          f3 = f1;
          f1 = f4;
          break label1970;
          float f14 = f3;
          f3 = f1;
          f1 = f14;
          break label1970;
          f8 = 0.0F;
          if (j != 0) {
            break label1215;
          }
          f1 = 1.2F;
          if (i2 == 0) {
            break label1220;
          }
          f12 = 0.08726647F;
          break label378;
          i = 1;
          break label824;
          i = 0;
          break label824;
          f1 = 0.0F;
          n = 0;
          m = 0;
          k = 0;
          break label907;
          for (;;)
          {
            if (j <= 5) {
              break label1913;
            }
            j = i;
            break;
            j = 2;
            break label1779;
            if (f2 > f3)
            {
              j = 1;
              break label1779;
            }
            j = 2;
            break label1779;
            int i3 = m;
            i1 = n;
            f2 = f1;
            if (k != j)
            {
              i3 = 1;
              i1 = n;
              n = i3;
            }
            for (;;)
            {
              if (n < 3) {
                break label1904;
              }
              f2 = f1;
              i3 = m;
              k += 1;
              m = i3;
              n = i1;
              f1 = f2;
              break;
              n += 1;
              f1 = f2;
            }
            break label948;
            j += 1;
          }
          break label989;
          f4 = f1 + f2;
          i = 0;
          break label1072;
          if (j == 0)
          {
            f13 = f7;
            break label1266;
          }
          f13 = f5;
          break label1266;
          label1946:
          if (f4 - f13 < f1) {
            break label400;
          }
          f2 = f6;
          f3 = f4;
          i = 1;
          break label400;
          label1970:
          if (f2 < f6) {
            f2 = f6;
          }
        }
        label1982:
        if (f4 <= f13) {
          break label1367;
        }
        i += 1;
        f4 = f1;
        f1 = f3;
        f3 = f4;
        break label400;
        label2009:
        k = i;
        if (i != 0)
        {
          k = i;
          if (f2 - f5 < 0.3F) {
            k = 0;
          }
        }
      }
      label2039:
      if (f4 >= f12) {}
      for (int i = 1;; i = 0)
      {
        f4 = 1.0F;
        if (i == 0) {
          break label1701;
        }
        f4 = 0.93F;
        break;
      }
    }
    
    /* Error */
    private a nG()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 42	com/c/a/a/u$f:aOF	[Lcom/c/a/a/u$f$a;
      //   6: iconst_4
      //   7: aaload
      //   8: ifnull +17 -> 25
      //   11: aload_0
      //   12: getfield 42	com/c/a/a/u$f:aOF	[Lcom/c/a/a/u$f$a;
      //   15: iconst_4
      //   16: aaload
      //   17: invokevirtual 237	com/c/a/a/u$f$a:nH	()Lcom/c/a/a/u$f$a;
      //   20: astore_1
      //   21: aload_0
      //   22: monitorexit
      //   23: aload_1
      //   24: areturn
      //   25: aconst_null
      //   26: astore_1
      //   27: goto -6 -> 21
      //   30: astore_1
      //   31: aload_0
      //   32: monitorexit
      //   33: aload_1
      //   34: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	35	0	this	f
      //   20	7	1	locala	a
      //   30	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	21	30	finally
    }
    
    public final void a(u.b paramb)
    {
      try
      {
        if ((this.aON > 0) && (this.aON < 101)) {
          this.aON -= 1;
        }
        this.aOE.add(paramb);
        this.aOG += 1;
        if (paramb.aOe > this.aOH[0][0]) {
          this.aOH[0][0] = paramb.aOe;
        }
        if (paramb.aOe < this.aOH[0][1]) {
          this.aOH[0][1] = paramb.aOe;
        }
        Object localObject = this.aOH[0];
        localObject[2] += paramb.aOe;
        if (paramb.aOf > this.aOH[1][0]) {
          this.aOH[1][0] = paramb.aOf;
        }
        if (paramb.aOf < this.aOH[1][1]) {
          this.aOH[1][1] = paramb.aOf;
        }
        localObject = this.aOH[1];
        localObject[2] += paramb.aOf;
        if (paramb.aOg > this.aOH[2][0]) {
          this.aOH[2][0] = paramb.aOg;
        }
        if (paramb.aOg < this.aOH[2][1]) {
          this.aOH[2][1] = paramb.aOg;
        }
        localObject = this.aOH[2];
        localObject[2] += paramb.aOg;
        if (paramb.aOh > this.aOI[0][0]) {
          this.aOI[0][0] = paramb.aOh;
        }
        if (paramb.aOh < this.aOI[0][1]) {
          this.aOI[0][1] = paramb.aOh;
        }
        localObject = this.aOI[0];
        localObject[2] += paramb.aOh;
        if (paramb.aOi > this.aOI[1][0]) {
          this.aOI[1][0] = paramb.aOi;
        }
        if (paramb.aOi < this.aOI[1][1]) {
          this.aOI[1][1] = paramb.aOi;
        }
        localObject = this.aOI[1];
        localObject[2] += paramb.aOi;
        if (paramb.aOj > this.aOI[2][0]) {
          this.aOI[2][0] = paramb.aOj;
        }
        if (paramb.aOj < this.aOI[2][1]) {
          this.aOI[2][1] = paramb.aOj;
        }
        localObject = this.aOI[2];
        localObject[2] += paramb.aOj;
        if (nE())
        {
          paramb = u.this;
          localObject = paramb.aNG.nG();
          if (localObject != null) {
            paramb.c(new u.e(((a)localObject).x, ((a)localObject).y, ((a)localObject).aOO, ((a)localObject).aOP, ((a)localObject).aOQ, ((a)localObject).aOR));
          }
        }
        return;
      }
      finally {}
    }
    
    public final void reset()
    {
      try
      {
        this.aOE.clear();
        this.aOF = new a[5];
        this.aOG = 0;
        float[] arrayOfFloat1 = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F };
        float[] arrayOfFloat2 = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F };
        this.aOH = new float[][] { { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F }, arrayOfFloat1, arrayOfFloat2 };
        arrayOfFloat1 = new float[] { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F };
        this.aOI = new float[][] { { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F }, arrayOfFloat1, { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.0F } };
        this.aOJ = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 3 }));
        this.aOK = new int[6];
        this.aOL = 5;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    private final class a
    {
      public int aOO = 0;
      public float aOP = 0.0F;
      public float aOQ = 0.0F;
      public float aOR = 0.0F;
      public long aOS = 0L;
      public float x = 0.0F;
      public float y = 0.0F;
      public float z = 0.0F;
      
      public a() {}
      
      protected final a nH()
      {
        a locala = new a(u.f.this);
        locala.x = this.x;
        locala.y = this.y;
        locala.z = this.z;
        locala.aOO = this.aOO;
        locala.aOP = this.aOP;
        locala.aOQ = this.aOQ;
        locala.aOS = this.aOS;
        locala.aOR = this.aOR;
        return locala;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */