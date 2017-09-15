package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.avf;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

final class e
{
  private static boolean a(int paramInt, String paramString, Map<String, String> paramMap)
  {
    GMTrace.i(856577540096L, 6382);
    if ((paramMap.get(paramString + ".resType") == null) && (paramMap.get(paramString + ".subType") == null))
    {
      GMTrace.o(856577540096L, 6382);
      return true;
    }
    int i;
    Object localObject;
    if (i.b.xd(paramInt))
    {
      v.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
      paramInt = bf.getInt((String)paramMap.get(paramString + ".resType"), -1);
      i = bf.getInt((String)paramMap.get(paramString + ".subType"), -1);
      if ((-1 == paramInt) || (-1 == i))
      {
        GMTrace.o(856577540096L, 6382);
        return false;
      }
      localObject = new avf();
      ((avf)localObject).tUe = i;
      ((avf)localObject).tXc = new avi();
      ((avf)localObject).tXc.tXm = bf.getInt((String)paramMap.get(paramString + ".resVer"), 0);
      ((avf)localObject).tXf = ((String)paramMap.get(paramString + ".sampleID"));
      ((avf)localObject).tXe = bf.getInt((String)paramMap.get(paramString + ".reportID"), 0);
      ((avf)localObject).tDn = i.b.sEn.fRM;
      b.c.sDY.a(paramInt, (avf)localObject, true);
      j.u(((avf)localObject).tXe, 40L);
      GMTrace.o(856577540096L, 6382);
      return true;
    }
    if (i.b.xb(paramInt))
    {
      v.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
      localObject = (String)paramMap.get(paramString + ".CDNUrl");
      int j = bf.getInt((String)paramMap.get(paramString + ".subType"), -1);
      int k = bf.getInt((String)paramMap.get(paramString + ".resType"), -1);
      String str = (String)paramMap.get(paramString + ".md5");
      int m = bf.getInt((String)paramMap.get(paramString + ".priority"), 0);
      if ((bf.mA((String)localObject)) || (bf.mA(str)) || (-1 == j) || (-1 == k) || (m < 0))
      {
        GMTrace.o(856577540096L, 6382);
        return false;
      }
      avf localavf = new avf();
      localavf.tXc = new avi();
      paramInt = 0;
      if (bf.getInt((String)paramMap.get(paramString + ".fileEncrypt"), 0) > 0) {
        paramInt = i.a.bDm();
      }
      i = paramInt;
      if (bf.getInt((String)paramMap.get(paramString + ".fileCompress"), 0) > 0) {
        i = i.a.wZ(paramInt);
      }
      localavf.tUe = j;
      localavf.tXh = bf.getInt((String)paramMap.get(paramString + ".networkType"), 2);
      localavf.tla = bf.getInt((String)paramMap.get(paramString + ".expireTime"), 1);
      localavf.tXc.mrm = ((String)localObject);
      localavf.tXc.tXm = bf.getInt((String)paramMap.get(paramString + ".resVer"), 0);
      localavf.tXc.tsQ = str;
      localavf.tXc.tXp = ((String)paramMap.get(paramString + ".originalmd5"));
      localavf.tXc.tXn = i;
      localavf.tXc.tXo = null;
      localavf.tXc.tsy = null;
      localavf.tII = m;
      localavf.tDn = i.b.sEl.fRM;
      localavf.tXe = bf.getInt((String)paramMap.get(paramString + ".reportID"), 0);
      localavf.tXf = ((String)paramMap.get(paramString + ".sampleID"));
      localavf.tXg = bf.getInt((String)paramMap.get(paramString + ".retryTime"), 3);
      localavf.tXi = bf.getInt((String)paramMap.get(paramString + ".retryInterval"), 0);
      localavf.sEc = 0;
      b.c.sDY.b(k, localavf, true);
      j.u(localavf.tXe, 34L);
      GMTrace.o(856577540096L, 6382);
      return true;
    }
    if (i.b.xc(paramInt))
    {
      v.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
      paramInt = bf.getInt((String)paramMap.get(paramString + ".resType"), -1);
      i = bf.getInt((String)paramMap.get(paramString + ".subType"), -1);
      if ((-1 == paramInt) || (-1 == i))
      {
        GMTrace.o(856577540096L, 6382);
        return false;
      }
      localObject = new avf();
      ((avf)localObject).tXd = new avh();
      ((avf)localObject).tUe = i;
      ((avf)localObject).tXd.tXl = ((String)paramMap.get(paramString + ".resKey"));
      ((avf)localObject).tXd.tXk = bf.getInt((String)paramMap.get(paramString + ".resKeyVersion"), 0);
      ((avf)localObject).tXf = ((String)paramMap.get(paramString + ".sampleID"));
      ((avf)localObject).tXe = bf.getInt((String)paramMap.get(paramString + ".reportID"), 0);
      ((avf)localObject).tDn = i.b.sEm.fRM;
      ((avf)localObject).tXc = new avi();
      ((avf)localObject).tXc.tXp = ((String)paramMap.get(paramString + ".originalmd5"));
      b.c.sDY.c(paramInt, (avf)localObject, true);
      j.u(((avf)localObject).tXe, 37L);
      GMTrace.o(856577540096L, 6382);
      return true;
    }
    GMTrace.o(856577540096L, 6382);
    return false;
  }
  
  static void f(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    GMTrace.i(856309104640L, 6380);
    if (n(String.format("%s.%s", new Object[] { paramString1, paramString2 }), paramMap))
    {
      GMTrace.o(856309104640L, 6380);
      return;
    }
    boolean bool = g(paramString1, paramString2, paramMap) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      if (n(String.format("%s.%s%d", new Object[] { paramString1, paramString2, Integer.valueOf(i) }), paramMap)) {
        break;
      }
      bool |= g(paramString1, paramString2, paramMap);
    }
    i = i.b.Mq(paramString2);
    if (i.b.xb(i))
    {
      j.u(0L, 32L);
      if (!bool)
      {
        j.u(0L, 33L);
        GMTrace.o(856309104640L, 6380);
      }
    }
    else if (i.b.xc(i))
    {
      j.u(0L, 35L);
      if (!bool)
      {
        j.u(0L, 36L);
        GMTrace.o(856309104640L, 6380);
      }
    }
    else if (i.b.xd(i))
    {
      j.u(0L, 38L);
      if (!bool) {
        j.u(0L, 39L);
      }
    }
    GMTrace.o(856309104640L, 6380);
  }
  
  private static boolean g(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    GMTrace.i(856443322368L, 6381);
    String str = String.format("%s.%s.%s", new Object[] { paramString1, paramString2, "Resource" });
    int j = i.b.Mq(paramString2);
    if (n(str, paramMap))
    {
      GMTrace.o(856443322368L, 6381);
      return true;
    }
    boolean bool = a(j, str, paramMap) | false;
    int i = 0;
    for (;;)
    {
      i += 1;
      str = String.format("%s.%s.%s%d", new Object[] { paramString1, paramString2, "Resource", Integer.valueOf(i) });
      if (n(str, paramMap)) {
        break;
      }
      bool |= a(j, str, paramMap);
    }
    GMTrace.o(856443322368L, 6381);
    return bool;
  }
  
  private static boolean n(String paramString, Map<String, String> paramMap)
  {
    GMTrace.i(856174886912L, 6379);
    if ((paramMap.get(paramString) == null) && (paramMap.get(paramString + ".resType") == null) && (paramMap.get(paramString + ".subType") == null))
    {
      GMTrace.o(856174886912L, 6379);
      return true;
    }
    GMTrace.o(856174886912L, 6379);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */