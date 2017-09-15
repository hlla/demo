package com.tencent.mm.plugin.s;

import android.os.Build;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.bf;

public final class g
{
  private static final String[] nxR;
  private static PBool nxS;
  private boolean kkZ;
  public long nxD;
  public long nxE;
  public long nxF;
  public long nxG;
  public long nxH;
  public long nxI;
  public long nxJ;
  public long nxK;
  public boolean nxL;
  public boolean nxM;
  public boolean nxN;
  public boolean nxO;
  boolean nxP;
  boolean nxQ;
  
  static
  {
    GMTrace.i(18682436648960L, 139195);
    nxR = new String[] { "SonyC6602" };
    nxS = null;
    GMTrace.o(18682436648960L, 139195);
  }
  
  public g(boolean paramBoolean)
  {
    GMTrace.i(12909732167680L, 96185);
    this.nxD = 0L;
    this.nxE = 0L;
    this.nxF = -1L;
    this.nxG = 0L;
    this.nxH = 0L;
    this.nxI = 0L;
    this.nxJ = 0L;
    this.nxK = 10L;
    this.nxL = true;
    this.nxM = true;
    this.nxN = false;
    this.nxO = false;
    this.nxP = false;
    this.nxQ = false;
    this.kkZ = paramBoolean;
    GMTrace.o(12909732167680L, 96185);
  }
  
  public static boolean aKn()
  {
    boolean bool2 = false;
    GMTrace.i(18682302431232L, 139194);
    Object localObject;
    boolean bool1;
    String[] arrayOfString;
    int j;
    int i;
    if (nxS == null)
    {
      localObject = Build.BRAND + Build.MODEL;
      bool1 = bool2;
      if (!bf.mA((String)localObject))
      {
        arrayOfString = nxR;
        j = arrayOfString.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (bf.eB((String)localObject, arrayOfString[i])) {
          bool1 = true;
        }
      }
      else
      {
        localObject = new PBool();
        nxS = (PBool)localObject;
        ((PBool)localObject).value = bool1;
        bool1 = nxS.value;
        GMTrace.o(18682302431232L, 139194);
        return bool1;
      }
      i += 1;
    }
  }
  
  public final void AI(String paramString)
  {
    GMTrace.i(17458639405056L, 130077);
    if (!this.nxL)
    {
      GMTrace.o(17458639405056L, 130077);
      return;
    }
    com.tencent.mm.plugin.report.service.g.oSF.a(354L, 152L, 1L, false);
    com.tencent.mm.plugin.report.service.g.oSF.i(13836, new Object[] { Integer.valueOf(500), Long.valueOf(bf.Nz()), paramString });
    GMTrace.o(17458639405056L, 130077);
  }
  
  public final void AJ(String paramString)
  {
    GMTrace.i(17458773622784L, 130078);
    if (!this.nxL)
    {
      GMTrace.o(17458773622784L, 130078);
      return;
    }
    com.tencent.mm.plugin.report.service.g.oSF.a(354L, 153L, 1L, false);
    com.tencent.mm.plugin.report.service.g.oSF.i(13836, new Object[] { Integer.valueOf(501), Long.valueOf(bf.Nz()), paramString });
    GMTrace.o(17458773622784L, 130078);
  }
  
  public final String aKl()
  {
    GMTrace.i(12909866385408L, 96186);
    String str = hashCode();
    GMTrace.o(12909866385408L, 96186);
    return str;
  }
  
  public final void aKm()
  {
    GMTrace.i(17458907840512L, 130079);
    if (!this.nxL)
    {
      GMTrace.o(17458907840512L, 130079);
      return;
    }
    com.tencent.mm.plugin.report.service.g.oSF.a(354L, 155L, 1L, false);
    com.tencent.mm.plugin.report.service.g.oSF.i(13836, new Object[] { Integer.valueOf(503), Long.valueOf(bf.Nz()), "" });
    GMTrace.o(17458907840512L, 130079);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/s/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */