package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import com.tencent.gmtrace.GMTrace;
import java.util.ArrayList;

public final class bd
{
  private boolean jcp;
  private String mTag;
  private String uue;
  ArrayList<Long> uuf;
  ArrayList<String> uug;
  
  public bd(String paramString1, String paramString2)
  {
    GMTrace.i(13934350303232L, 103819);
    this.mTag = paramString1;
    this.uue = paramString2;
    this.jcp = false;
    if (!this.jcp)
    {
      if (this.uuf != null) {
        break label77;
      }
      this.uuf = new ArrayList();
      this.uug = new ArrayList();
    }
    for (;;)
    {
      addSplit(null);
      GMTrace.o(13934350303232L, 103819);
      return;
      label77:
      this.uuf.clear();
      this.uug.clear();
    }
  }
  
  public final void addSplit(String paramString)
  {
    GMTrace.i(13934484520960L, 103820);
    if (this.jcp)
    {
      GMTrace.o(13934484520960L, 103820);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.uuf.add(Long.valueOf(l));
    this.uug.add(paramString);
    GMTrace.o(13934484520960L, 103820);
  }
  
  public final void dumpToLog()
  {
    GMTrace.i(13934618738688L, 103821);
    if (this.jcp)
    {
      GMTrace.o(13934618738688L, 103821);
      return;
    }
    v.d(this.mTag, this.uue + ": begin");
    long l2 = ((Long)this.uuf.get(0)).longValue();
    int i = 1;
    long l1 = l2;
    while (i < this.uuf.size())
    {
      l1 = ((Long)this.uuf.get(i)).longValue();
      String str = (String)this.uug.get(i);
      long l3 = ((Long)this.uuf.get(i - 1)).longValue();
      v.d(this.mTag, this.uue + ":      " + (l1 - l3) + " ms, " + str);
      i += 1;
    }
    v.d(this.mTag, this.uue + ": end, " + (l1 - l2) + " ms");
    GMTrace.o(13934618738688L, 103821);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */