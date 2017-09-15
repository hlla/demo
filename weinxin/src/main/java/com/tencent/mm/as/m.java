package com.tencent.mm.as;

import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class m
{
  private static m hPT;
  public int hPR;
  public a hPS;
  
  static
  {
    GMTrace.i(16672526172160L, 124220);
    hPT = new m();
    GMTrace.o(16672526172160L, 124220);
  }
  
  private m()
  {
    GMTrace.i(16672123518976L, 124217);
    this.hPR = -1;
    ap.yY();
    this.hPR = ((Integer)c.vr().get(w.a.uGC, Integer.valueOf(-1))).intValue();
    ap.yY();
    Object localObject = (String)c.vr().get(w.a.uGD, "");
    this.hPS = new a();
    a locala = this.hPS;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("_");
      locala.hPU = bf.PX(localObject[0]);
      locala.hPV = bf.PX(localObject[1]);
      locala.hPW = bf.PY(localObject[2]);
      locala.hPX = bf.PX(localObject[3]);
    }
    GMTrace.o(16672123518976L, 124217);
  }
  
  public static m Ix()
  {
    GMTrace.i(16671989301248L, 124216);
    m localm = hPT;
    GMTrace.o(16671989301248L, 124216);
    return localm;
  }
  
  public final void save()
  {
    GMTrace.i(16672257736704L, 124218);
    ap.yY();
    c.vr().a(w.a.uGD, this.hPS.Iy());
    ap.yY();
    c.vr().a(w.a.uGC, Integer.valueOf(this.hPR));
    GMTrace.o(16672257736704L, 124218);
  }
  
  public final boolean valid()
  {
    GMTrace.i(16672391954432L, 124219);
    if (this.hPS != null)
    {
      a locala = this.hPS;
      if (((locala.hPU != 1) || (locala.hPV != 0)) && (locala.hPX <= d.hOW))
      {
        i = 1;
        if (i == 0) {
          break label93;
        }
        locala = this.hPS;
        if (System.currentTimeMillis() <= locala.hPW) {
          break label88;
        }
      }
      label88:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label93;
        }
        GMTrace.o(16672391954432L, 124219);
        return true;
        i = 0;
        break;
      }
    }
    label93:
    GMTrace.o(16672391954432L, 124219);
    return false;
  }
  
  private final class a
  {
    public int hPU;
    public int hPV;
    public long hPW;
    public int hPX;
    
    public a()
    {
      GMTrace.i(16671183994880L, 124210);
      GMTrace.o(16671183994880L, 124210);
    }
    
    public final String Iy()
    {
      GMTrace.i(16671318212608L, 124211);
      String str = this.hPU + "_" + this.hPV + "_" + this.hPW + "_" + this.hPX;
      GMTrace.o(16671318212608L, 124211);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/as/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */