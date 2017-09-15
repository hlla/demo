package com.tencent.mm.u;

import android.content.res.Resources;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.messenger.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class n
{
  private static Set<String> hkY;
  
  static
  {
    GMTrace.i(655519383552L, 4884);
    hkY = new HashSet();
    GMTrace.o(655519383552L, 4884);
  }
  
  public static String E(String paramString1, String paramString2)
  {
    GMTrace.i(654177206272L, 4874);
    if (bf.mA(paramString2))
    {
      paramString1 = eK(paramString1);
      GMTrace.o(654177206272L, 4874);
      return paramString1;
    }
    String str = eL(paramString1);
    if (!bf.mA(str))
    {
      GMTrace.o(654177206272L, 4874);
      return str;
    }
    paramString2 = j.D(paramString1, paramString2);
    if (bf.mA(paramString2))
    {
      paramString1 = eK(paramString1);
      GMTrace.o(654177206272L, 4874);
      return paramString1;
    }
    GMTrace.o(654177206272L, 4874);
    return paramString2;
  }
  
  public static String a(x paramx, String paramString)
  {
    GMTrace.i(654714077184L, 4878);
    paramx = o.a(paramx, paramString);
    GMTrace.o(654714077184L, 4878);
    return paramx;
  }
  
  public static String a(x paramx, String paramString, boolean paramBoolean)
  {
    GMTrace.i(654848294912L, 4879);
    if (paramx == null)
    {
      GMTrace.o(654848294912L, 4879);
      return paramString;
    }
    if ((paramBoolean) && (bf.mA(paramx.field_nickname)))
    {
      paramx = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().eK(paramString);
      GMTrace.o(654848294912L, 4879);
      return paramx;
    }
    if ((paramx.tL() != null) && (paramx.tL().length() > 0))
    {
      paramx = paramx.tL();
      GMTrace.o(654848294912L, 4879);
      return paramx;
    }
    if ((bf.mA(paramx.field_nickname)) && (o.fD(paramString)))
    {
      paramx = com.tencent.mm.j.a.dM(paramString);
      GMTrace.o(654848294912L, 4879);
      return paramx;
    }
    GMTrace.o(654848294912L, 4879);
    return paramString;
  }
  
  public static String c(x paramx)
  {
    GMTrace.i(654982512640L, 4880);
    Object localObject = eK(paramx.field_username);
    if (o.dH(paramx.field_username))
    {
      if (!((String)localObject).equals(paramx.field_username))
      {
        GMTrace.o(654982512640L, 4880);
        return (String)localObject;
      }
      localObject = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fZ(paramx.field_username);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramx = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramx.add(eK((String)((Iterator)localObject).next()));
        }
        paramx = "(" + bf.c(paramx, ", ") + ")";
        GMTrace.o(654982512640L, 4880);
        return paramx;
      }
      paramx = com.tencent.mm.sdk.platformtools.aa.getResources().getString(b.a.dCj);
      GMTrace.o(654982512640L, 4880);
      return paramx;
    }
    GMTrace.o(654982512640L, 4880);
    return (String)localObject;
  }
  
  public static void c(Set<String> paramSet)
  {
    GMTrace.i(655250948096L, 4882);
    hkY = paramSet;
    GMTrace.o(655250948096L, 4882);
  }
  
  public static String eI(String paramString)
  {
    GMTrace.i(654042988544L, 4873);
    x localx = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString);
    if (localx == null)
    {
      GMTrace.o(654042988544L, 4873);
      return paramString;
    }
    if (!bf.mA(localx.field_nickname))
    {
      paramString = localx.field_nickname;
      GMTrace.o(654042988544L, 4873);
      return paramString;
    }
    GMTrace.o(654042988544L, 4873);
    return paramString;
  }
  
  public static String eJ(String paramString)
  {
    GMTrace.i(654311424000L, 4875);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(654311424000L, 4875);
      return "";
    }
    x localx = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString);
    v.d("MicroMsg.ContactCommDisplay", "username: %s", new Object[] { paramString });
    if (localx == null)
    {
      GMTrace.o(654311424000L, 4875);
      return paramString;
    }
    if ((paramString.toLowerCase().endsWith("@chatroom")) && (bf.mA(localx.field_nickname)))
    {
      String str = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().eK(paramString);
      if (!bf.mA(str))
      {
        GMTrace.o(654311424000L, 4875);
        return str;
      }
    }
    if ((localx.tK() != null) && (localx.tK().length() > 0))
    {
      paramString = localx.tK();
      GMTrace.o(654311424000L, 4875);
      return paramString;
    }
    GMTrace.o(654311424000L, 4875);
    return paramString;
  }
  
  public static String eK(String paramString)
  {
    GMTrace.i(654445641728L, 4876);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(654445641728L, 4876);
      return "";
    }
    paramString = o.a(((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString), paramString);
    GMTrace.o(654445641728L, 4876);
    return paramString;
  }
  
  public static String eL(String paramString)
  {
    GMTrace.i(655116730368L, 4881);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString);
    if (paramString == null)
    {
      GMTrace.o(655116730368L, 4881);
      return "";
    }
    if (!bf.mA(paramString.field_conRemark))
    {
      paramString = paramString.field_conRemark;
      GMTrace.o(655116730368L, 4881);
      return paramString;
    }
    GMTrace.o(655116730368L, 4881);
    return "";
  }
  
  public static String eM(String paramString)
  {
    GMTrace.i(655385165824L, 4883);
    if (hkY.contains(paramString))
    {
      GMTrace.o(655385165824L, 4883);
      return "";
    }
    GMTrace.o(655385165824L, 4883);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */