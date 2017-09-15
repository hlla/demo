package com.c.a.a;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.SystemClock;
import java.lang.reflect.Array;
import java.util.List;

class n
  extends b
{
  private int aLA;
  private long aLB;
  private boolean aLC;
  private Location aLD;
  private int aLE;
  private float aLF;
  private float aLG;
  private float aLH;
  private int aLI;
  private int aLJ;
  private long aLK;
  private final e aLs = new e();
  public final j aLt = new j();
  private final d aLu = new d();
  private final i aLv;
  public final s aLw;
  private long aLx;
  private long aLy;
  private long aLz;
  
  n()
  {
    if (i.aJP == null) {
      i.aJP = new i();
    }
    this.aLv = i.aJP;
    this.aLC = true;
    this.aLw = new s(this);
  }
  
  private boolean a(long paramLong, int paramInt1, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, int paramInt2, float paramFloat2)
  {
    paramLong /= 1000L;
    paramDouble1 = Math.toRadians(paramDouble1);
    paramDouble2 = Math.toRadians(paramDouble2);
    if (this.aLC)
    {
      this.aLt.a(paramLong, paramDouble1, paramDouble2, paramFloat1, this.aLs.aLV, y.aPv);
      this.aLC = false;
    }
    for (boolean bool = true;; bool = false)
    {
      j.a locala = new j.a(paramInt1, paramLong, paramDouble1, paramDouble2, paramDouble3, paramFloat1, paramInt2, paramFloat2, 0, 0.0D, 0.0D);
      this.aLt.a(locala);
      if (y.aPp) {
        o.m("filter_input_log_" + y.aPw, locala.toString());
      }
      return bool;
    }
  }
  
  private void nn()
  {
    this.aLv.aJY = false;
    this.aLw.nz();
    this.aLu.reset();
    this.aLs.reset();
    nm();
    this.aLy = 0L;
    this.aLz = SystemClock.elapsedRealtime();
    this.aLF = 0.0F;
    this.aLG = 0.0F;
    this.aLH = 0.0F;
    this.aLI = 0;
    this.aLJ = 0;
    this.aLA = 0;
  }
  
  final k.a a(d.a parama)
  {
    return new k.a(0L);
  }
  
  final void a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, long paramLong1, long paramLong2)
  {
    if (paramInt2 <= 0) {
      return;
    }
    Object localObject = this.aLs;
    if (paramInt3 >= 3)
    {
      if (paramLong2 - ((e)localObject).aLU <= 5000L) {
        ((e)localObject).ai(true);
      }
      ((e)localObject).aLU = paramLong2;
    }
    int i = Math.round(paramFloat);
    if (!v.c(paramDouble1, paramDouble2)) {}
    for (localObject = "";; localObject = "&GD=" + paramDouble1 + ',' + paramDouble2 + ',' + paramInt1 + ',' + paramInt3 + ',' + paramInt5 + ',' + paramInt2 + ',' + i + ',' + paramLong1 + ',')
    {
      this.aLu.b((String)localObject, paramLong2);
      if (a(paramLong2, 1, paramDouble1, paramDouble2, paramInt1, paramInt2, paramInt5, paramInt3)) {
        this.aLv.a(paramDouble1, paramDouble2, paramInt2, this.aLF, this.aLG, this.aLH);
      }
      if (d.c(paramLong2, this.aLz)) {
        this.aLw.a(paramDouble1, paramDouble2, paramInt2, paramFloat, this.aLF, this.aLG, this.aLH, paramLong2);
      }
      if (!y.aPp) {
        break;
      }
      o.m("gps_log_" + y.aPw, String.valueOf(paramDouble1) + ',' + paramDouble2 + ',' + paramInt1 + ',' + paramInt2 + ',' + paramInt3 + ',' + paramInt4 + ',' + paramInt5 + ',' + paramFloat + ',' + paramLong1);
      return;
    }
  }
  
  final void a(float paramFloat1, float paramFloat2, int paramInt, float paramFloat3, float paramFloat4, float paramFloat5, long paramLong)
  {
    Object localObject1 = this.aLs;
    if (paramLong - ((e)localObject1).aLU > 5000L) {
      ((e)localObject1).ai(false);
    }
    if (paramLong - this.aLz > 5000L) {
      nn();
    }
    this.aLF = paramFloat1;
    this.aLG = paramFloat2;
    this.aLH = paramFloat4;
    this.aLI = paramInt;
    this.aLz = paramLong;
    boolean bool;
    if (paramFloat5 > 0.0F)
    {
      i = 1;
      this.aLJ = i;
      if ((this.aLy != 0L) || (paramLong - this.aLK >= 30000L))
      {
        if (i != 0) {
          break label327;
        }
        bool = true;
        label119:
        if ((!bool) || (!this.aLs.aLV))
        {
          ab.nJ().ah(bool);
          k.nl().ah(bool);
        }
      }
      localObject1 = new double[2];
      localObject2 = this.aLv;
      arrayOfDouble1 = new double[2];
      arrayOfDouble1[0] = paramFloat1;
      arrayOfDouble1[1] = paramFloat2;
      if (!((i)localObject2).aJY) {
        break label385;
      }
      localObject1[0] = ((i)localObject2).aJQ;
      localObject1[1] = ((i)localObject2).aJR;
      localObject1[0] += 1.0E-5D * (arrayOfDouble1[1] - ((i)localObject2).aJT) / ((i)localObject2).aJW;
      localObject1[1] += 1.0E-5D * (arrayOfDouble1[0] - ((i)localObject2).aJS) / ((i)localObject2).aJX;
      if (localObject1[0] <= 90.0D) {
        break label333;
      }
      localObject1[0] = (180.0D - localObject1[0]);
      label289:
      if (localObject1[1] <= 180.0D) {
        break label359;
      }
      localObject1[1] -= 360.0D;
    }
    label312:
    label327:
    label333:
    label359:
    label385:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label391;
      }
      return;
      i = 0;
      break;
      bool = false;
      break label119;
      if (localObject1[0] >= -90.0D) {
        break label289;
      }
      localObject1[0] = (-180.0D - localObject1[0]);
      break label289;
      if (localObject1[1] >= -180.0D) {
        break label312;
      }
      localObject1[1] += 360.0D;
      break label312;
    }
    label391:
    double d1 = localObject1[0];
    double d2 = localObject1[1];
    localObject1 = this.aLv;
    paramFloat2 = (paramFloat4 - ((i)localObject1).aJU) / 10.0F;
    paramFloat4 = ((i)localObject1).aJV;
    paramFloat1 = 0.0F;
    localObject1 = new Location("S");
    ((Location)localObject1).setLatitude(d1);
    ((Location)localObject1).setLongitude(d2);
    if (this.aLD != null) {
      paramFloat1 = this.aLD.bearingTo((Location)localObject1);
    }
    this.aLD = ((Location)localObject1);
    i = Math.max(0, paramInt - this.aLE);
    this.aLE = paramInt;
    long l = paramLong / 1000L;
    d1 = Math.toRadians(d1);
    d2 = Math.toRadians(d2);
    double d3 = Math.toRadians(paramFloat1);
    localObject1 = new j.a(3, l, d1, d2, 0.0D, paramFloat2 + paramFloat4, 0, paramFloat5, i, paramFloat3, d3);
    this.aLt.a((j.a)localObject1);
    if (y.aPp) {
      o.m("filter_input_log_" + y.aPw, ((j.a)localObject1).toString());
    }
    localObject1 = new double[4];
    l = paramLong / 1000L;
    Object localObject2 = new double[2];
    double[] arrayOfDouble1 = new double[2];
    double[] arrayOfDouble2 = new double[2];
    double[][] arrayOfDouble3 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
    double[][] arrayOfDouble4 = (double[][])Array.newInstance(Double.TYPE, new int[] { 2, 2 });
    j localj = this.aLt;
    d1 = l - localj.aKa.aKc;
    d2 = d1 * d1;
    double[] arrayOfDouble5 = new double[2];
    localObject2[0] = (localj.aKa.aKL[0] + localj.aKa.aKL[2] * d1);
    d3 = localj.aKa.aKL[1];
    localObject2[1] = (d1 * localj.aKa.aKL[3] + d3);
    arrayOfDouble2[0] = localj.aKa.aKL[2];
    arrayOfDouble2[1] = localj.aKa.aKL[3];
    int j;
    if (localj.aKa.aKt)
    {
      localObject2[0] -= localj.aKa.aKu[0];
      localObject2[1] -= localj.aKa.aKu[1];
      d1 = Math.sqrt(arrayOfDouble5[0] * arrayOfDouble5[0] + arrayOfDouble5[1] * arrayOfDouble5[1]);
      d1 = d1 * d1 * localj.aKa.aKO;
      arrayOfDouble3[0][0] = (localj.aKa.aKM[0][0] + localj.aKa.aKM[2][2] * d2 + d1);
      arrayOfDouble3[0][1] = (localj.aKa.aKM[0][1] + localj.aKa.aKM[2][3] * d2);
      arrayOfDouble3[1][0] = (localj.aKa.aKM[1][0] + localj.aKa.aKM[3][2] * d2);
      arrayOfDouble5 = arrayOfDouble3[1];
      d3 = localj.aKa.aKM[1][1];
      arrayOfDouble5[1] = (d1 + (d2 * localj.aKa.aKM[3][3] + d3));
      arrayOfDouble4[0][0] = localj.aKa.aKM[2][2];
      arrayOfDouble4[0][1] = localj.aKa.aKM[2][3];
      arrayOfDouble4[1][0] = localj.aKa.aKM[3][2];
      arrayOfDouble4[1][1] = localj.aKa.aKM[3][3];
      localj.a(1, (double[])localObject2, arrayOfDouble1);
      localObject1[0] = Math.toDegrees(arrayOfDouble1[0]);
      localObject1[1] = Math.toDegrees(arrayOfDouble1[1]);
      localObject1[2] = Math.sqrt((arrayOfDouble3[0][0] + arrayOfDouble3[1][1]) / 2.0D);
      d1 = arrayOfDouble2[0];
      d2 = arrayOfDouble2[0];
      d3 = arrayOfDouble2[1];
      localObject1[3] = Math.sqrt(d1 * d2 + arrayOfDouble2[1] * d3);
      if (y.aPp) {
        o.m("filter_output_log_" + y.aPw, String.valueOf(l) + ',' + localObject1[0] + ',' + localObject1[1] + ',' + localObject1[2] + ',' + localObject1[3]);
      }
      d1 = localObject1[0];
      d2 = localObject1[1];
      paramInt = Double.valueOf(localObject1[2]).intValue();
      i = Double.valueOf(localObject1[3]).intValue();
      j = this.aLA;
      if (v.c(d1, d2)) {
        break label1391;
      }
    }
    label1391:
    for (localObject1 = "";; localObject1 = "&SD=" + d1 + ',' + d2 + ',' + 0 + ',' + paramInt + ',' + j + ',' + 0 + ',' + i + ',' + 0 + ',' + 0 + ',' + 0)
    {
      this.aLu.c((String)localObject1, paramLong);
      c(new a(d1, d2, paramInt, this.aLA, this.aLB));
      return;
      d1 = 0.0D;
      break;
    }
  }
  
  void a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    c(new b(paramInt, paramString, (byte)0));
    if ((paramInt == -4) || (paramInt == -5)) {
      stop();
    }
  }
  
  /* Error */
  void a(android.os.Handler paramHandler, d.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: instanceof 12
    //   6: ifeq +44 -> 50
    //   9: aload_2
    //   10: checkcast 12	com/c/a/a/n$c
    //   13: astore_2
    //   14: aload_0
    //   15: aload_2
    //   16: getfield 415	com/c/a/a/n$c:aLP	J
    //   19: putfield 417	com/c/a/a/n:aLx	J
    //   22: aload_0
    //   23: invokespecial 248	com/c/a/a/n:nn	()V
    //   26: aload_0
    //   27: getfield 82	com/c/a/a/n:aLw	Lcom/c/a/a/s;
    //   30: aload_1
    //   31: putfield 421	com/c/a/a/s:aMJ	Landroid/os/Handler;
    //   34: aload_0
    //   35: invokestatic 162	android/os/SystemClock:elapsedRealtime	()J
    //   38: putfield 250	com/c/a/a/n:aLK	J
    //   41: aload_0
    //   42: aload_1
    //   43: aload_2
    //   44: invokespecial 423	com/c/a/a/b:a	(Landroid/os/Handler;Lcom/c/a/a/d$a;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_2
    //   51: ifnull +23 -> 74
    //   54: aload_2
    //   55: getfield 428	com/c/a/a/d$a:aJl	J
    //   58: lstore_3
    //   59: new 12	com/c/a/a/n$c
    //   62: dup
    //   63: lload_3
    //   64: ldc2_w 429
    //   67: invokespecial 433	com/c/a/a/n$c:<init>	(JJ)V
    //   70: astore_2
    //   71: goto -57 -> 14
    //   74: ldc2_w 187
    //   77: lstore_3
    //   78: goto -19 -> 59
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	n
    //   0	86	1	paramHandler	android.os.Handler
    //   0	86	2	parama	d.a
    //   58	20	3	l	long
    // Exception table:
    //   from	to	target	type
    //   2	14	81	finally
    //   14	47	81	finally
    //   54	59	81	finally
    //   59	71	81	finally
  }
  
  void a(x paramx, long paramLong1, long paramLong2)
  {
    this.aLy = paramx.aMy;
    this.aLA = paramx.level;
    this.aLB = paramx.aLN;
    if ((paramx.aPa.equals("W")) && (a(paramLong2, 2, paramx.latitude, paramx.longitude, paramx.altitude, paramx.aLh, paramx.aPf, paramx.aLi))) {
      this.aLv.a(paramx.latitude, paramx.longitude, paramx.aLh, this.aLF, this.aLG, this.aLH);
    }
    if (!u.nD().aNx) {
      c(new a(paramx.latitude, paramx.longitude, Float.valueOf(paramx.aLh).intValue(), this.aLA, this.aLB));
    }
  }
  
  final void a(List<ScanResult> paramList, long paramLong1, long paramLong2)
  {
    paramLong1 = aa.p(paramLong1);
    boolean bool;
    Object localObject1;
    Object localObject2;
    r localr;
    int i;
    long l1;
    if ((this.aLy != 0L) && (paramLong2 - this.aLy < this.aLx))
    {
      bool = false;
      localObject1 = v.a(paramList, bool);
      localObject2 = this.aLu.a((String)localObject1, paramLong2, bool);
      if (!bool) {
        break label306;
      }
      localr = r.np();
      i = this.aLJ;
      if (localObject2 != null)
      {
        if (!localr.aJi) {
          break label265;
        }
        if (!localr.nr()) {
          break label260;
        }
        l1 = System.currentTimeMillis();
        long l2 = SystemClock.elapsedRealtime();
        if (localr.aMj != null) {
          localr.aMj.execute(new r.e(localr, (String)localObject2, l1, l2, i, true));
        }
      }
      label136:
      if (d.c(paramLong2, this.aLz)) {
        if (bool) {
          break label324;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = v.a(paramList, false);
      }
      paramList = v.a((String)localObject2, paramLong1, "2");
      localObject1 = this.aLw;
      float f1 = this.aLF;
      float f2 = this.aLG;
      float f3 = this.aLH;
      float f4 = this.aLI;
      i = this.aLA;
      if (((s)localObject1).aME != 0.0F) {
        z.b(null).execute(new s.a((s)localObject1, f1, f2, f3, f4, i, paramList));
      }
      return;
      bool = true;
      break;
      label260:
      localr.nq();
      label265:
      l1 = aa.p(System.currentTimeMillis());
      if (localr.aMj == null) {
        break label136;
      }
      localr.aMj.execute(new r.c(localr, (String)localObject2, l1, 0));
      break label136;
      label306:
      r.np().az(v.a((String)localObject2, paramLong1, "0"));
      break label136;
      label324:
      localObject1 = null;
    }
  }
  
  public final void nm()
  {
    this.aLC = true;
    this.aLD = null;
    this.aLE = 0;
  }
  
  final void stop()
  {
    try
    {
      this.aLw.nx();
      super.stop();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  static final class a
    extends p
  {
    final int aLL;
    final int aLM;
    final long aLN;
    final double lat;
    final double lng;
    
    a(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, long paramLong)
    {
      super();
      this.lat = paramDouble1;
      this.lng = paramDouble2;
      this.aLL = paramInt1;
      this.aLM = paramInt2;
      this.aLN = paramLong;
    }
  }
  
  static final class b
    extends p
  {
    final boolean aLO;
    final int code;
    final String message;
    
    private b(int paramInt, String paramString)
    {
      super();
      this.code = paramInt;
      this.message = paramString;
      this.aLO = false;
    }
    
    b(int paramInt, String paramString, byte paramByte)
    {
      this(paramInt, paramString);
    }
  }
  
  static final class c
    extends d.a
  {
    final long aLP;
    
    c(long paramLong1, long paramLong2)
    {
      super();
      this.aLP = paramLong2;
    }
  }
  
  private static final class d
  {
    private String aLQ;
    private long aLR;
    private String aLS;
    private long aLT;
    
    public static boolean c(long paramLong1, long paramLong2)
    {
      return Math.abs(paramLong1 - paramLong2) <= 10000L;
    }
    
    public final String a(String paramString, long paramLong, boolean paramBoolean)
    {
      String str;
      if (paramBoolean) {
        str = paramString;
      }
      for (;;)
      {
        try
        {
          if (this.aLQ != null)
          {
            str = paramString;
            if (c(paramLong, this.aLR))
            {
              str = paramString + this.aLQ;
              this.aLQ = null;
            }
          }
          paramString = str;
          if (this.aLS != null)
          {
            paramString = str;
            if (c(paramLong, this.aLT))
            {
              paramString = str + this.aLS;
              this.aLS = null;
            }
          }
          return paramString;
        }
        finally {}
        str = paramString;
        if (this.aLQ != null)
        {
          str = paramString;
          if (c(paramLong, this.aLR))
          {
            str = paramString + v.aF(this.aLQ);
            this.aLQ = null;
          }
        }
        paramString = str;
        if (this.aLS != null)
        {
          paramString = str;
          if (c(paramLong, this.aLT))
          {
            paramString = str + v.aE(this.aLS);
            this.aLS = null;
          }
        }
      }
    }
    
    public final void b(String paramString, long paramLong)
    {
      try
      {
        this.aLQ = paramString;
        this.aLR = paramLong;
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public final void c(String paramString, long paramLong)
    {
      try
      {
        this.aLS = paramString;
        this.aLT = paramLong;
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public final void reset()
    {
      try
      {
        this.aLQ = null;
        this.aLS = null;
        this.aLR = 0L;
        this.aLT = 0L;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  private final class e
  {
    long aLU;
    public boolean aLV = y.aPu;
    
    public e() {}
    
    final void ai(boolean paramBoolean)
    {
      StringBuilder localStringBuilder;
      if ((this.aLV ^ paramBoolean))
      {
        if (!this.aLV) {
          break label146;
        }
        paramBoolean = false;
        this.aLV = paramBoolean;
        n.this.aLw.nx();
        n.this.aLw.nz();
        n.this.aLt.ai(this.aLV);
        n.this.nm();
        if (y.aPp)
        {
          localStringBuilder = new StringBuilder("vehicle mode: ");
          if (!this.aLV) {
            break label151;
          }
        }
      }
      label146:
      label151:
      for (String str = "enable";; str = "disable")
      {
        str = str;
        o.m("filter_input_log_" + y.aPw, str);
        o.m("filter_output_log_" + y.aPw, str);
        return;
        paramBoolean = true;
        break;
      }
    }
    
    public final void reset()
    {
      this.aLU = 0L;
      this.aLV = y.aPu;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */