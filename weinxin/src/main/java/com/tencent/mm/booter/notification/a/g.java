package com.tencent.mm.booter.notification.a;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;

public final class g
{
  public b gLW;
  public c gLX;
  public d gLY;
  public h gLZ;
  private f gMa;
  public a gMb;
  public int gMc;
  public int gMd;
  public int gMe;
  public int gMf;
  public boolean gMg;
  private int gMh;
  private int gMi;
  public boolean gMj;
  public boolean gMk;
  public Context mContext;
  
  public g(Context paramContext)
  {
    GMTrace.i(524791316480L, 3910);
    this.gMh = -1;
    this.gMi = -1;
    this.mContext = paramContext;
    this.gLW = new b();
    this.gLX = new c();
    this.gLY = new d();
    this.gLZ = new h();
    this.gMb = new a();
    this.gMa = f.a.gLV;
    GMTrace.o(524791316480L, 3910);
  }
  
  public static String a(long[] paramArrayOfLong)
  {
    GMTrace.i(525059751936L, 3912);
    if (paramArrayOfLong == null)
    {
      GMTrace.o(525059751936L, 3912);
      return null;
    }
    String str = "";
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      str = str + String.valueOf(l) + ",";
      i += 1;
    }
    if (str.isEmpty())
    {
      GMTrace.o(525059751936L, 3912);
      return str;
    }
    paramArrayOfLong = str.substring(0, str.length() - 1);
    GMTrace.o(525059751936L, 3912);
    return paramArrayOfLong;
  }
  
  public final void dj(String paramString)
  {
    GMTrace.i(524925534208L, 3911);
    this.gMa.di(paramString);
    GMTrace.o(524925534208L, 3911);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/booter/notification/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */