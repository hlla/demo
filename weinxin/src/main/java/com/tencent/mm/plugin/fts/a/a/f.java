package com.tencent.mm.plugin.fts.a.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Comparator;
import java.util.HashSet;

public final class f
{
  public String fJC;
  public String fRC;
  public ad handler;
  public int lYm;
  public int[] lYn;
  public int[] lYo;
  public int lYp;
  public HashSet<String> lYq;
  public Comparator<i> lYr;
  public j lYs;
  public int scene;
  
  public f()
  {
    GMTrace.i(18636802621440L, 138855);
    this.lYm = 0;
    this.fRC = null;
    this.fJC = null;
    this.lYn = null;
    this.lYo = null;
    this.lYp = Integer.MAX_VALUE;
    this.lYq = new HashSet();
    this.lYr = null;
    this.lYs = null;
    this.handler = null;
    this.scene = -1;
    GMTrace.o(18636802621440L, 138855);
  }
  
  public static f a(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, HashSet<String> paramHashSet, Comparator<i> paramComparator, j paramj, ad paramad)
  {
    GMTrace.i(18636936839168L, 138856);
    f localf = new f();
    localf.fRC = paramString;
    localf.fJC = null;
    localf.lYn = paramArrayOfInt1;
    localf.lYo = paramArrayOfInt2;
    localf.lYp = paramInt;
    localf.lYq = paramHashSet;
    localf.lYr = paramComparator;
    localf.lYs = paramj;
    localf.handler = paramad;
    GMTrace.o(18636936839168L, 138856);
    return localf;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */