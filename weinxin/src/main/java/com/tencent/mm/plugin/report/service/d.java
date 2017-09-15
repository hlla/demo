package com.tencent.mm.plugin.report.service;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.plugin.report.b.a;
import com.tencent.mm.protocal.c.aew;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class d
{
  private static Map<Long, Long> oSn;
  private static a oSo;
  private static int oSp;
  private static boolean oSq;
  
  static
  {
    GMTrace.i(13123138355200L, 97775);
    oSo = new a();
    oSp = -1;
    oSq = false;
    GMTrace.o(13123138355200L, 97775);
  }
  
  public static void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(13122333048832L, 97769);
    if (paramBoolean2) {
      try
      {
        SmcLogic.writeImportKvData(paramLong, paramString, paramBoolean1);
        GMTrace.o(13122333048832L, 97769);
        return;
      }
      catch (Exception paramString)
      {
        v.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bf.g(paramString) });
        GMTrace.o(13122333048832L, 97769);
        return;
      }
    }
    SmcLogic.writeKvData(paramLong, paramString, paramBoolean1);
    GMTrace.o(13122333048832L, 97769);
  }
  
  public static void a(long paramLong, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(13122467266560L, 97770);
    if (paramBoolean2) {
      try
      {
        SmcLogic.writeImportKvPbData(paramLong, paramArrayOfByte, paramBoolean1);
        GMTrace.o(13122467266560L, 97770);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        v.e("MicroMsg.KVEasyReport", "localReport :%s", new Object[] { bf.g(paramArrayOfByte) });
        GMTrace.o(13122467266560L, 97770);
        return;
      }
    }
    SmcLogic.writeKvPbData(paramLong, paramArrayOfByte, paramBoolean1);
    GMTrace.o(13122467266560L, 97770);
  }
  
  public static void aXz()
  {
    try
    {
      GMTrace.i(13123004137472L, 97774);
      if (oSn == null) {
        oSn = new HashMap(20);
      }
      Object localObject1 = a.aXq();
      if ((localObject1 != null) && (((aew)localObject1).tIw != oSp))
      {
        oSp = ((aew)localObject1).tIw;
        oSn.clear();
        localObject1 = ((aew)localObject1).tIx;
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            amw localamw = (amw)((Iterator)localObject1).next();
            oSn.put(new Long(localamw.tPR), new Long(localamw.tPS));
          }
        }
      }
    }
    finally {}
    tmp145_142[0] = Integer.valueOf(oSp);
    Object[] tmp154_145 = tmp145_142;
    tmp154_145[1] = Integer.valueOf(oSn.size());
    Object[] tmp168_154 = tmp154_145;
    tmp168_154[2] = oSn;
    Object[] tmp174_168 = tmp168_154;
    tmp174_168[3] = bf.bJP();
    v.i("MicroMsg.KVEasyReport", "summerhv reloadHeavyUserIDMap heavyUserIDMap[%d][%d][%s], stack[%s]", tmp174_168);
    GMTrace.o(13123004137472L, 97774);
  }
  
  public static void b(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    GMTrace.i(13122601484288L, 97771);
    long l;
    do
    {
      SmcLogic.reportIDKey(paramLong1, paramLong2, paramLong3, paramBoolean);
      if (!oSq) {
        break;
      }
      if (oSn == null) {
        aXz();
      }
      l = bf.a((Long)oSn.get(Long.valueOf(paramLong1)), 0L);
      paramLong1 = l;
    } while (l > 0L);
    GMTrace.o(13122601484288L, 97771);
  }
  
  public static void c(ArrayList<IDKey> paramArrayList, boolean paramBoolean)
  {
    GMTrace.i(13122735702016L, 97772);
    if (paramArrayList != null) {
      SmcLogic.reportListIDKey((IDKey[])paramArrayList.toArray(new IDKey[paramArrayList.size()]), paramBoolean);
    }
    GMTrace.o(13122735702016L, 97772);
  }
  
  public static void gD(boolean paramBoolean)
  {
    GMTrace.i(13122869919744L, 97773);
    v.i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", new Object[] { Boolean.valueOf(oSq), Boolean.valueOf(paramBoolean), bf.bJP() });
    oSq = paramBoolean;
    GMTrace.o(13122869919744L, 97773);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/service/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */