package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;

public class NoSpaceProfile
  extends e
{
  public static final String fvW;
  
  static
  {
    GMTrace.i(12996436819968L, 96831);
    fvW = aa.getPackageName() + ":nospace";
    GMTrace.o(12996436819968L, 96831);
  }
  
  public NoSpaceProfile()
  {
    GMTrace.i(12996034166784L, 96828);
    GMTrace.o(12996034166784L, 96828);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(12996302602240L, 96830);
    GMTrace.o(12996302602240L, 96830);
  }
  
  public final void onCreate()
  {
    GMTrace.i(12996168384512L, 96829);
    com.tencent.mm.compatible.util.k.b(a.uqc, NoSpaceProfile.class.getClassLoader());
    k.bi(fvW);
    com.tencent.mm.compatible.util.k.setupBrokenLibraryHandler();
    bf.et(aa.getContext());
    m.a(this.app);
    GMTrace.o(12996168384512L, 96829);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/NoSpaceProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */