package com.tencent.mm.sandbox.updater;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.b.i;
import com.tencent.mm.b.i.a;
import com.tencent.mm.protocal.c.amz;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.protocal.c.bfb;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  public final int fileSize;
  public final Integer mKj;
  public HashMap<Integer, LinkedList<amz>> mKk;
  public final Integer mKl;
  public final Integer mKm;
  public final String mKn;
  public final String mKo;
  public final String mKp;
  public String mKq;
  public String mKr;
  public int versionCode;
  
  public e(bfd parambfd)
  {
    GMTrace.i(18997714092032L, 141544);
    this.mKk = new HashMap();
    if (parambfd == null)
    {
      this.mKj = Integer.valueOf(1);
      this.mKn = "";
      this.mKo = "";
      this.mKl = Integer.valueOf(-1);
      this.mKm = Integer.valueOf(-1);
      this.mKp = "";
      this.fileSize = 0;
      this.mKq = "";
      this.mKr = "";
      this.versionCode = 0;
      GMTrace.o(18997714092032L, 141544);
      return;
    }
    if (parambfd.uef != null)
    {
      this.mKo = parambfd.uef.tsQ;
      this.mKn = parambfd.uef.mrm;
    }
    Object localObject;
    for (this.fileSize = parambfd.uef.trj;; this.fileSize = 0)
    {
      this.mKj = Integer.valueOf(parambfd.state);
      this.mKm = Integer.valueOf(parambfd.uee);
      if ((parambfd.uec == null) || (parambfd.uec.isEmpty())) {
        break;
      }
      int j = parambfd.uec.size();
      int i = 0;
      while (i < j)
      {
        localObject = (bfc)parambfd.uec.get(i);
        if ((((bfc)localObject).ueb != null) && (!((bfc)localObject).ueb.isEmpty())) {
          this.mKk.put(Integer.valueOf(((bfc)localObject).type), ((bfc)localObject).ueb);
        }
        i += 1;
      }
      this.mKo = "";
      this.mKn = "";
    }
    this.mKl = Integer.valueOf(parambfd.ued);
    this.mKp = parambfd.tpJ;
    if ((parambfd.ueh != null) && (!parambfd.ueh.isEmpty()))
    {
      parambfd = parambfd.ueh.iterator();
      while (parambfd.hasNext())
      {
        localObject = (bfb)parambfd.next();
        if ((localObject != null) && (!bf.mA(((bfb)localObject).arH))) {
          if (((bfb)localObject).arH.equalsIgnoreCase("newApkMd5")) {
            this.mKq = ((bfb)localObject).value;
          } else if (((bfb)localObject).arH.equalsIgnoreCase("oldApkMd5")) {
            this.mKr = ((bfb)localObject).value;
          } else if (((bfb)localObject).arH.equalsIgnoreCase("versionCode")) {
            this.versionCode = bf.PX(((bfb)localObject).value);
          }
        }
      }
      GMTrace.o(18997714092032L, 141544);
      return;
    }
    this.mKq = "";
    this.mKr = "";
    this.versionCode = 0;
    GMTrace.o(18997714092032L, 141544);
  }
  
  public final String bHN()
  {
    GMTrace.i(18997848309760L, 141545);
    Object localObject = this.mKn.substring(0, this.mKn.lastIndexOf('/') + 1);
    String str = this.mKn.substring(this.mKn.lastIndexOf('/') + 1);
    localObject = new i((String)localObject, Integer.valueOf(this.versionCode).intValue());
    ((i)localObject).a(new i.a(this.mKr, this.mKq, this.mKo, str, this.fileSize));
    str = ((i)localObject).nX();
    GMTrace.o(18997848309760L, 141545);
    return str;
  }
  
  public final String toString()
  {
    GMTrace.i(18997982527488L, 141546);
    String str = "responseState:" + this.mKj + "\ncdnUrl:" + this.mKn + "\nfileMd5:" + this.mKo + "\npackageType:" + this.mKl + "\nnetworkType:" + this.mKm + "\npatchId:" + this.mKp;
    GMTrace.o(18997982527488L, 141546);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sandbox/updater/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */