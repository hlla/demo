package com.tencent.mm.platformtools;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;

public final class n
{
  public static avt G(byte[] paramArrayOfByte)
  {
    GMTrace.i(13452240224256L, 100227);
    if (paramArrayOfByte == null)
    {
      GMTrace.o(13452240224256L, 100227);
      return null;
    }
    avt localavt = new avt();
    localavt.bb(paramArrayOfByte);
    GMTrace.o(13452240224256L, 100227);
    return localavt;
  }
  
  public static String a(b paramb)
  {
    GMTrace.i(13452911312896L, 100232);
    if (paramb == null)
    {
      GMTrace.o(13452911312896L, 100232);
      return null;
    }
    paramb = paramb.bGP();
    GMTrace.o(13452911312896L, 100232);
    return paramb;
  }
  
  public static String a(avu paramavu)
  {
    GMTrace.i(13452642877440L, 100230);
    if (paramavu == null)
    {
      GMTrace.o(13452642877440L, 100230);
      return null;
    }
    paramavu = paramavu.tXF;
    GMTrace.o(13452642877440L, 100230);
    return paramavu;
  }
  
  public static byte[] a(avt paramavt)
  {
    GMTrace.i(13452374441984L, 100228);
    if ((paramavt == null) || (paramavt.tXD == null))
    {
      GMTrace.o(13452374441984L, 100228);
      return null;
    }
    paramavt = paramavt.tXD.toByteArray();
    GMTrace.o(13452374441984L, 100228);
    return paramavt;
  }
  
  public static byte[] a(avt paramavt, byte[] paramArrayOfByte)
  {
    GMTrace.i(13452508659712L, 100229);
    if ((paramavt == null) || (paramavt.tXD == null))
    {
      GMTrace.o(13452508659712L, 100229);
      return paramArrayOfByte;
    }
    paramavt = paramavt.tXD.toByteArray();
    GMTrace.o(13452508659712L, 100229);
    return paramavt;
  }
  
  public static String b(avt paramavt)
  {
    GMTrace.i(13453045530624L, 100233);
    if ((paramavt == null) || (paramavt.tXD == null))
    {
      GMTrace.o(13453045530624L, 100233);
      return null;
    }
    paramavt = paramavt.tXD.bGP();
    GMTrace.o(13453045530624L, 100233);
    return paramavt;
  }
  
  public static avu mw(String paramString)
  {
    GMTrace.i(13452777095168L, 100231);
    if (paramString == null)
    {
      GMTrace.o(13452777095168L, 100231);
      return null;
    }
    avu localavu = new avu();
    localavu.OU(paramString);
    GMTrace.o(13452777095168L, 100231);
    return localavu;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/platformtools/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */