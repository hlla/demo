package com.tencent.mm.plugin.fts.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.loader.stub.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class c
{
  public static final int[] lXA;
  public static final int[] lXB;
  public static final Map<Integer, Integer> lXC;
  public static final int[] lXD;
  public static final int[] lXE;
  public static final int[] lXF;
  public static final int[] lXG;
  public static final int[] lXH;
  public static final int[] lXI;
  public static final String lXJ;
  public static final int[] lXq;
  public static final int[] lXr;
  public static final int[] lXs;
  public static final int[] lXt;
  public static final int[] lXu;
  public static final int[] lXv;
  public static final int[] lXw;
  public static final int[] lXx;
  public static final int[] lXy;
  public static final int[] lXz;
  
  static
  {
    int j = 0;
    GMTrace.i(18619891187712L, 138729);
    lXq = new int[] { 65536 };
    lXr = new int[] { 196608 };
    lXs = new int[] { 262144 };
    lXt = new int[] { 327680 };
    lXu = new int[] { 393216 };
    lXv = new int[] { 131073, 131074 };
    lXw = new int[] { 131072, 131075, 131076 };
    lXx = new int[] { 131072, 131075, 131076 };
    lXy = new int[] { 131072 };
    lXz = new int[] { 131073, 131074 };
    lXA = new int[] { 131077, 131078 };
    lXB = new int[] { 131079, 131080 };
    lXD = new int[] { 2, 3, 6, 7 };
    lXE = new int[] { 29, 30, 31, 34, 35, 36, 33, 32, 37 };
    Object localObject = new int[3];
    Object tmp266_265 = localObject;
    tmp266_265[0] = 8;
    Object tmp271_266 = tmp266_265;
    tmp271_266[1] = 9;
    Object tmp276_271 = tmp271_266;
    tmp276_271[2] = 10;
    tmp276_271;
    lXF = (int[])localObject;
    lXG = (int[])localObject;
    localObject = new HashMap();
    int i = 0;
    while (i < 9)
    {
      ((HashMap)localObject).put(Integer.valueOf(new int[] { 131072, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080 }[i]), Integer.valueOf(i));
      i += 1;
    }
    lXC = Collections.unmodifiableMap((Map)localObject);
    lXH = new int[43];
    i = 0;
    while (i < 43)
    {
      lXH[new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0 }[i]] = i;
      i += 1;
    }
    lXI = new int[27];
    i = j;
    while (i < 27)
    {
      lXI[new int[] { 1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0 }[i]] = i;
      i += 1;
    }
    lXJ = a.hgk + "fts/";
    GMTrace.o(18619891187712L, 138729);
  }
  
  public static final class a
  {
    public static final Pattern lXK;
    public static final Pattern lXL;
    public static final Pattern lXM;
    public static final Pattern lXN;
    public static final Pattern lXO;
    public static final Pattern lXP;
    public static final Pattern lXQ;
    public static final Pattern lXR;
    
    static
    {
      GMTrace.i(18632239218688L, 138821);
      lXK = Pattern.compile(";");
      lXL = Pattern.compile(" ");
      lXM = Pattern.compile("​");
      lXN = Pattern.compile("‌");
      Pattern localPattern = Pattern.compile("‍");
      lXO = localPattern;
      lXP = localPattern;
      lXQ = Pattern.compile("\\s+");
      lXR = Pattern.compile(",");
      GMTrace.o(18632239218688L, 138821);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */