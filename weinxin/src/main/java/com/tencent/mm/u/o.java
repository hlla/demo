package com.tencent.mm.u;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.protocal.c.amq;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class o
{
  public static final String hkZ;
  public static final String hla;
  public static final String hlb;
  public static final String hlc;
  public static final String hld;
  public static final String hle;
  public static final String hlf;
  public static final String[] hlg;
  
  static
  {
    GMTrace.i(13279904661504L, 98943);
    hkZ = c("rconversation.username", new String[] { "@chatroom", "@micromsg.qq.com" });
    hla = c("rconversation.username", new String[] { "@t.qq.com" });
    hlb = c("rconversation.username", new String[] { "@qqim" });
    hlc = c("rconversation.username", new String[] { "@chatroom_exclusive" });
    hld = c("rconversation.username", new String[] { "@micromsg.qq.com" });
    hle = c("rconversation.username", new String[] { "@app" });
    hlf = c("rconversation.username", new String[] { "@chatroom" });
    hlg = new String[] { "qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg" };
    GMTrace.o(13279904661504L, 98943);
  }
  
  public static String a(x paramx, String paramString)
  {
    GMTrace.i(18784173686784L, 139953);
    if (paramx == null)
    {
      GMTrace.o(18784173686784L, 139953);
      return paramString;
    }
    if ((paramString.toLowerCase().endsWith("@chatroom")) && (bf.mA(paramx.field_nickname)))
    {
      String str = ((com.tencent.mm.plugin.chatroom.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().eK(paramString);
      if (!bf.mA(str))
      {
        GMTrace.o(18784173686784L, 139953);
        return str;
      }
    }
    if ((paramx.tL() != null) && (paramx.tL().length() > 0))
    {
      paramx = paramx.tL();
      GMTrace.o(18784173686784L, 139953);
      return paramx;
    }
    GMTrace.o(18784173686784L, 139953);
    return paramString;
  }
  
  public static boolean a(ae paramae)
  {
    GMTrace.i(13279367790592L, 98939);
    String str = paramae.field_username;
    if (fE(str))
    {
      GMTrace.o(13279367790592L, 98939);
      return false;
    }
    if (fC(str))
    {
      GMTrace.o(13279367790592L, 98939);
      return false;
    }
    if (fu(str))
    {
      GMTrace.o(13279367790592L, 98939);
      return false;
    }
    if (fv(str))
    {
      GMTrace.o(13279367790592L, 98939);
      return false;
    }
    if (paramae.field_conversationTime == -1L)
    {
      GMTrace.o(13279367790592L, 98939);
      return false;
    }
    if (eV(str))
    {
      GMTrace.o(13279367790592L, 98939);
      return true;
    }
    GMTrace.o(13279367790592L, 98939);
    return true;
  }
  
  public static int[] a(String paramString1, String paramString2, List<String> paramList, String paramString3)
  {
    GMTrace.i(13272254251008L, 98886);
    long l = System.currentTimeMillis();
    int[] arrayOfInt = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().b(paramString1, paramString2, paramString3, paramList);
    v.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt.length <= 0)
    {
      GMTrace.o(13272254251008L, 98886);
      return null;
    }
    l = System.currentTimeMillis();
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().c(paramString1, paramString2, paramString3, paramList);
    v.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
    if (paramString1 == null)
    {
      GMTrace.o(13272254251008L, 98886);
      return null;
    }
    if (arrayOfInt.length == paramString1.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString2 = new int[paramString1.length];
      int i = 0;
      int k = 0;
      int j = 0;
      while (j < arrayOfInt.length)
      {
        paramString2[i] = k;
        k += paramString1[j];
        j += 1;
        i += 1;
      }
    }
    GMTrace.o(13272254251008L, 98886);
    return paramString2;
  }
  
  public static int[] a(String paramString1, String paramString2, List<String> paramList, String[] paramArrayOfString)
  {
    int j = 0;
    GMTrace.i(13272522686464L, 98888);
    int[] arrayOfInt = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().b(paramString1, paramString2, paramArrayOfString, paramList);
    if (arrayOfInt.length <= 0)
    {
      GMTrace.o(13272522686464L, 98888);
      return null;
    }
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().c(paramString1, paramString2, paramArrayOfString, paramList);
    if (paramString1 == null)
    {
      GMTrace.o(13272522686464L, 98888);
      return null;
    }
    if (arrayOfInt.length == paramString1.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString2 = new int[paramString1.length];
      int k = 0;
      int i = 0;
      while (j < arrayOfInt.length)
      {
        paramString2[i] = k;
        k += paramString1[j];
        j += 1;
        i += 1;
      }
    }
    GMTrace.o(13272522686464L, 98888);
    return paramString2;
  }
  
  public static String[] a(String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    int i = 0;
    GMTrace.i(13272791121920L, 98890);
    long l = System.currentTimeMillis();
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().b(paramString1, paramString2, paramString3, paramList);
    v.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramString1.length <= 0)
    {
      GMTrace.o(13272791121920L, 98890);
      return null;
    }
    paramString2 = new String[paramString1.length];
    int j = 0;
    if (j < paramString1.length)
    {
      char c = (char)paramString1[j];
      if (c == '{')
      {
        paramString2[i] = "#";
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (c == ' ')
        {
          paramString2[i] = "$";
          i += 1;
        }
        else
        {
          paramString2[i] = String.valueOf(c);
          i += 1;
        }
      }
    }
    GMTrace.o(13272791121920L, 98890);
    return paramString2;
  }
  
  public static String[] a(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    int i = 0;
    GMTrace.i(13272656904192L, 98889);
    long l = System.currentTimeMillis();
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().b(paramString1, paramString2, paramArrayOfString, paramList);
    v.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramString1.length <= 0)
    {
      GMTrace.o(13272656904192L, 98889);
      return null;
    }
    paramString2 = new String[paramString1.length];
    int j = 0;
    if (j < paramString1.length)
    {
      char c = (char)paramString1[j];
      if (c == '{')
      {
        paramString2[i] = "#";
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (c == ' ')
        {
          paramString2[i] = "$";
          i += 1;
        }
        else
        {
          paramString2[i] = String.valueOf(c);
          i += 1;
        }
      }
    }
    GMTrace.o(13272656904192L, 98889);
    return paramString2;
  }
  
  public static void b(x paramx, String paramString)
  {
    GMTrace.i(13271448944640L, 98880);
    paramx = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramx.field_username);
    if ((paramx != null) && (paramString != null)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramx.bP(paramString);
      t(paramx);
      GMTrace.o(13271448944640L, 98880);
      return;
    }
  }
  
  public static boolean b(ae paramae)
  {
    GMTrace.i(13279502008320L, 98940);
    paramae = paramae.field_username;
    if (fu(paramae))
    {
      GMTrace.o(13279502008320L, 98940);
      return false;
    }
    if (fD(paramae))
    {
      GMTrace.o(13279502008320L, 98940);
      return false;
    }
    GMTrace.o(13279502008320L, 98940);
    return true;
  }
  
  private static String c(String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(13279770443776L, 98942);
    int j = paramArrayOfString.length;
    Object localObject2 = " and ( 1 != 1 ";
    int i = 0;
    if (i < j)
    {
      String str = paramArrayOfString[i];
      Object localObject1;
      if ("@all.android".equals(str)) {
        localObject1 = (String)localObject2 + " or 1 = 1";
      }
      for (;;)
      {
        i += 1;
        localObject2 = localObject1;
        break;
        if ("@micromsg.qq.com".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + " not like '%@%'";
        }
        else if ("@chatroom".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + " like '%@chatroom'";
        }
        else if ("@talkroom".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + " like '%@talkroom'";
        }
        else if ("@t.qq.com".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + " like '%@t.qq.com'";
        }
        else if ("@qqim".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + " like '%@qqim'";
        }
        else if ("@chatroom_exclusive".equals(str))
        {
          localObject1 = (String)localObject2 + " or " + paramString + "not like %@chatroom";
        }
        else
        {
          localObject1 = localObject2;
          if ("@app".equals(str)) {
            localObject1 = (String)localObject2 + " or " + paramString + " like '%@app'";
          }
        }
      }
    }
    paramString = (String)localObject2 + " ) ";
    GMTrace.o(13279770443776L, 98942);
    return paramString;
  }
  
  public static boolean d(x paramx)
  {
    GMTrace.i(13268227719168L, 98856);
    if (paramx == null)
    {
      GMTrace.o(13268227719168L, 98856);
      return false;
    }
    if (!bf.mz(paramx.field_username).endsWith("@chatroom"))
    {
      GMTrace.o(13268227719168L, 98856);
      return false;
    }
    if (!com.tencent.mm.j.a.ez(paramx.field_type))
    {
      GMTrace.o(13268227719168L, 98856);
      return false;
    }
    GMTrace.o(13268227719168L, 98856);
    return true;
  }
  
  public static boolean dH(String paramString)
  {
    GMTrace.i(13267690848256L, 98852);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13267690848256L, 98852);
      return false;
    }
    boolean bool = paramString.endsWith("@chatroom");
    GMTrace.o(13267690848256L, 98852);
    return bool;
  }
  
  public static void e(x paramx)
  {
    GMTrace.i(13269435678720L, 98865);
    boolean bool;
    x localx2;
    if (paramx != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localx2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramx.field_username);
      localx1 = paramx;
      if (localx2 != null) {
        if (!bf.mA(localx2.field_username)) {
          break label83;
        }
      }
    }
    label83:
    for (x localx1 = paramx;; localx1 = localx2)
    {
      localx1.ti();
      t(localx1);
      GMTrace.o(13269435678720L, 98865);
      return;
      bool = false;
      break;
    }
  }
  
  public static boolean eN(String paramString)
  {
    GMTrace.i(13267556630528L, 98851);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13267556630528L, 98851);
      return false;
    }
    if ((!paramString.contains("@")) || (paramString.endsWith("@micromsg.qq.com")))
    {
      GMTrace.o(13267556630528L, 98851);
      return true;
    }
    GMTrace.o(13267556630528L, 98851);
    return false;
  }
  
  public static boolean eO(String paramString)
  {
    GMTrace.i(13267825065984L, 98853);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13267825065984L, 98853);
      return false;
    }
    boolean bool = paramString.endsWith("@bottle");
    GMTrace.o(13267825065984L, 98853);
    return bool;
  }
  
  public static boolean eP(String paramString)
  {
    GMTrace.i(13267959283712L, 98854);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13267959283712L, 98854);
      return false;
    }
    boolean bool = paramString.endsWith("@qqim");
    GMTrace.o(13267959283712L, 98854);
    return bool;
  }
  
  public static boolean eQ(String paramString)
  {
    GMTrace.i(13268093501440L, 98855);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13268093501440L, 98855);
      return false;
    }
    boolean bool = paramString.endsWith("@lbsroom");
    GMTrace.o(13268093501440L, 98855);
    return bool;
  }
  
  public static boolean eR(String paramString)
  {
    GMTrace.i(13268361936896L, 98857);
    boolean bool = "gh_43f2581f6fd6".equals(paramString);
    GMTrace.o(13268361936896L, 98857);
    return bool;
  }
  
  public static boolean eS(String paramString)
  {
    GMTrace.i(13268496154624L, 98858);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13268496154624L, 98858);
      return false;
    }
    if (!paramString.endsWith("@chatroom"))
    {
      GMTrace.o(13268496154624L, 98858);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString);
    if ((paramString == null) || (!com.tencent.mm.j.a.ez(paramString.field_type)))
    {
      GMTrace.o(13268496154624L, 98858);
      return false;
    }
    GMTrace.o(13268496154624L, 98858);
    return true;
  }
  
  public static boolean eT(String paramString)
  {
    GMTrace.i(13268630372352L, 98859);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13268630372352L, 98859);
      return false;
    }
    boolean bool = paramString.endsWith("@stranger");
    GMTrace.o(13268630372352L, 98859);
    return bool;
  }
  
  public static boolean eU(String paramString)
  {
    GMTrace.i(13269033025536L, 98862);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13269033025536L, 98862);
      return true;
    }
    boolean bool = com.tencent.mm.j.a.ez(((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString).field_type);
    GMTrace.o(13269033025536L, 98862);
    return bool;
  }
  
  public static boolean eV(String paramString)
  {
    GMTrace.i(13269167243264L, 98863);
    if (bf.mA(paramString))
    {
      GMTrace.o(13269167243264L, 98863);
      return false;
    }
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString);
    if (paramString == null)
    {
      GMTrace.o(13269167243264L, 98863);
      return false;
    }
    boolean bool = x.yx(paramString.field_verifyFlag);
    GMTrace.o(13269167243264L, 98863);
    return bool;
  }
  
  public static void eW(String paramString)
  {
    GMTrace.i(13270643638272L, 98874);
    ae localae2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rl(paramString);
    int i = 0;
    ae localae1 = localae2;
    if (localae2 == null)
    {
      localae1 = new ae();
      localae1.bLr();
      i = 1;
      localae1.setUsername(paramString);
    }
    localae1.s(System.currentTimeMillis());
    if (i != 0)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().d(localae1);
      GMTrace.o(13270643638272L, 98874);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().a(localae1, paramString);
    GMTrace.o(13270643638272L, 98874);
  }
  
  public static boolean eW(int paramInt)
  {
    GMTrace.i(13269301460992L, 98864);
    boolean bool = x.yx(paramInt);
    GMTrace.o(13269301460992L, 98864);
    return bool;
  }
  
  public static void eX(String paramString)
  {
    GMTrace.i(13272120033280L, 98885);
    if (bf.mA(paramString))
    {
      GMTrace.o(13272120033280L, 98885);
      return;
    }
    x localx = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString);
    if (localx == null)
    {
      GMTrace.o(13272120033280L, 98885);
      return;
    }
    localx.ta();
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().a(paramString, localx);
    GMTrace.o(13272120033280L, 98885);
  }
  
  public static boolean eY(String paramString)
  {
    GMTrace.i(13273059557376L, 98892);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("qqmail");
      GMTrace.o(13273059557376L, 98892);
      return bool;
    }
    GMTrace.o(13273059557376L, 98892);
    return false;
  }
  
  public static boolean eZ(String paramString)
  {
    GMTrace.i(13273193775104L, 98893);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("fmessage");
      GMTrace.o(13273193775104L, 98893);
      return bool;
    }
    GMTrace.o(13273193775104L, 98893);
    return false;
  }
  
  public static void f(x paramx)
  {
    GMTrace.i(16766210146304L, 124918);
    boolean bool;
    x localx2;
    if (paramx != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localx2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramx.field_username);
      localx1 = paramx;
      if (localx2 != null) {
        if (!bf.mA(localx2.field_username)) {
          break label83;
        }
      }
    }
    label83:
    for (x localx1 = paramx;; localx1 = localx2)
    {
      localx1.tg();
      t(localx1);
      GMTrace.o(16766210146304L, 124918);
      return;
      bool = false;
      break;
    }
  }
  
  public static boolean fA(String paramString)
  {
    GMTrace.i(13277086089216L, 98922);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("notification_messages");
      GMTrace.o(13277086089216L, 98922);
      return bool;
    }
    GMTrace.o(13277086089216L, 98922);
    return false;
  }
  
  public static boolean fB(String paramString)
  {
    GMTrace.i(13277220306944L, 98923);
    if (fC(paramString))
    {
      GMTrace.o(13277220306944L, 98923);
      return true;
    }
    if (fE(paramString))
    {
      GMTrace.o(13277220306944L, 98923);
      return true;
    }
    if (fu(paramString))
    {
      GMTrace.o(13277220306944L, 98923);
      return true;
    }
    if (fv(paramString))
    {
      GMTrace.o(13277220306944L, 98923);
      return true;
    }
    GMTrace.o(13277220306944L, 98923);
    return false;
  }
  
  public static boolean fC(String paramString)
  {
    GMTrace.i(13277354524672L, 98924);
    com.tencent.mm.kernel.h.vJ();
    String str = (String)com.tencent.mm.kernel.h.vI().vr().get(21, null);
    if (((str != null) && (str.equalsIgnoreCase(paramString))) || (paramString.equalsIgnoreCase("weixin")))
    {
      GMTrace.o(13277354524672L, 98924);
      return true;
    }
    GMTrace.o(13277354524672L, 98924);
    return false;
  }
  
  public static boolean fD(String paramString)
  {
    GMTrace.i(13277488742400L, 98925);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("appbrandcustomerservicemsg");
      GMTrace.o(13277488742400L, 98925);
      return bool;
    }
    GMTrace.o(13277488742400L, 98925);
    return false;
  }
  
  public static boolean fE(String paramString)
  {
    GMTrace.i(13277622960128L, 98926);
    String[] arrayOfString = hlg;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equalsIgnoreCase(paramString))
      {
        GMTrace.o(13277622960128L, 98926);
        return true;
      }
      i += 1;
    }
    GMTrace.o(13277622960128L, 98926);
    return false;
  }
  
  public static boolean fF(String paramString)
  {
    GMTrace.i(13277757177856L, 98927);
    if (fE(paramString))
    {
      GMTrace.o(13277757177856L, 98927);
      return true;
    }
    if (x.QN(paramString))
    {
      GMTrace.o(13277757177856L, 98927);
      return true;
    }
    if (x.QL(paramString))
    {
      GMTrace.o(13277757177856L, 98927);
      return true;
    }
    if (x.eO(paramString))
    {
      GMTrace.o(13277757177856L, 98927);
      return true;
    }
    GMTrace.o(13277757177856L, 98927);
    return false;
  }
  
  public static int fG(String paramString)
  {
    GMTrace.i(13277891395584L, 98928);
    if (bf.mz(paramString).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = paramString.trim().toLowerCase();
      if (!paramString.endsWith("@chatroom")) {
        break;
      }
      GMTrace.o(13277891395584L, 98928);
      return 1;
    }
    if (x.QL(paramString))
    {
      GMTrace.o(13277891395584L, 98928);
      return 11;
    }
    if (x.QN(paramString))
    {
      GMTrace.o(13277891395584L, 98928);
      return 36;
    }
    if (x.eO(paramString))
    {
      GMTrace.o(13277891395584L, 98928);
      return 1;
    }
    GMTrace.o(13277891395584L, 98928);
    return 1;
  }
  
  public static int fH(String paramString)
  {
    GMTrace.i(13278025613312L, 98929);
    if (bf.mz(paramString).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = paramString.trim().toLowerCase();
      if (!paramString.endsWith("@chatroom")) {
        break;
      }
      GMTrace.o(13278025613312L, 98929);
      return 3;
    }
    if (x.QL(paramString))
    {
      GMTrace.o(13278025613312L, 98929);
      return 13;
    }
    if (x.QN(paramString))
    {
      GMTrace.o(13278025613312L, 98929);
      return 39;
    }
    if (x.eO(paramString))
    {
      GMTrace.o(13278025613312L, 98929);
      return 3;
    }
    if (paramString.contains("@"))
    {
      GMTrace.o(13278025613312L, 98929);
      return 3;
    }
    GMTrace.o(13278025613312L, 98929);
    return 3;
  }
  
  public static boolean fI(String paramString)
  {
    GMTrace.i(13278159831040L, 98930);
    if (((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString).gkp != 1)
    {
      GMTrace.o(13278159831040L, 98930);
      return false;
    }
    GMTrace.o(13278159831040L, 98930);
    return true;
  }
  
  public static boolean fJ(String paramString)
  {
    GMTrace.i(13278294048768L, 98931);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString);
    if ((paramString != null) && (paramString.tD()))
    {
      GMTrace.o(13278294048768L, 98931);
      return true;
    }
    GMTrace.o(13278294048768L, 98931);
    return false;
  }
  
  public static boolean fK(String paramString)
  {
    GMTrace.i(13278428266496L, 98932);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13278428266496L, 98932);
      return false;
    }
    if ((paramString.startsWith("t.qq.com/")) || (paramString.startsWith("http://t.qq.com/")))
    {
      GMTrace.o(13278428266496L, 98932);
      return true;
    }
    GMTrace.o(13278428266496L, 98932);
    return false;
  }
  
  public static String fL(String paramString)
  {
    GMTrace.i(13278562484224L, 98933);
    if (fK(paramString))
    {
      paramString = paramString.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
      GMTrace.o(13278562484224L, 98933);
      return paramString;
    }
    GMTrace.o(13278562484224L, 98933);
    return "";
  }
  
  public static boolean fa(String paramString)
  {
    GMTrace.i(13273327992832L, 98894);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("tmessage");
      GMTrace.o(13273327992832L, 98894);
      return bool;
    }
    GMTrace.o(13273327992832L, 98894);
    return false;
  }
  
  public static boolean fb(String paramString)
  {
    GMTrace.i(13273462210560L, 98895);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("floatbottle");
      GMTrace.o(13273462210560L, 98895);
      return bool;
    }
    GMTrace.o(13273462210560L, 98895);
    return false;
  }
  
  public static boolean fc(String paramString)
  {
    GMTrace.i(13273596428288L, 98896);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("qmessage");
      GMTrace.o(13273596428288L, 98896);
      return bool;
    }
    GMTrace.o(13273596428288L, 98896);
    return false;
  }
  
  public static boolean fd(String paramString)
  {
    GMTrace.i(13273730646016L, 98897);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("facebookapp");
      GMTrace.o(13273730646016L, 98897);
      return bool;
    }
    GMTrace.o(13273730646016L, 98897);
    return false;
  }
  
  public static boolean fe(String paramString)
  {
    GMTrace.i(13273864863744L, 98898);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("masssendapp");
      GMTrace.o(13273864863744L, 98898);
      return bool;
    }
    GMTrace.o(13273864863744L, 98898);
    return false;
  }
  
  public static boolean ff(String paramString)
  {
    GMTrace.i(13274133299200L, 98900);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("feedsapp");
      GMTrace.o(13274133299200L, 98900);
      return bool;
    }
    GMTrace.o(13274133299200L, 98900);
    return false;
  }
  
  public static boolean fg(String paramString)
  {
    GMTrace.i(13274267516928L, 98901);
    boolean bool = "qqsync".equalsIgnoreCase(paramString);
    GMTrace.o(13274267516928L, 98901);
    return bool;
  }
  
  public static boolean fh(String paramString)
  {
    GMTrace.i(13274401734656L, 98902);
    if (paramString != null)
    {
      if ((paramString.equalsIgnoreCase("weixin")) || (paramString.equalsIgnoreCase("gh_9639b5a92773")))
      {
        GMTrace.o(13274401734656L, 98902);
        return true;
      }
      GMTrace.o(13274401734656L, 98902);
      return false;
    }
    GMTrace.o(13274401734656L, 98902);
    return false;
  }
  
  public static boolean fi(String paramString)
  {
    GMTrace.i(13274535952384L, 98903);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("lbsapp");
      GMTrace.o(13274535952384L, 98903);
      return bool;
    }
    GMTrace.o(13274535952384L, 98903);
    return false;
  }
  
  public static boolean fj(String paramString)
  {
    GMTrace.i(13274670170112L, 98904);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("shakeapp");
      GMTrace.o(13274670170112L, 98904);
      return bool;
    }
    GMTrace.o(13274670170112L, 98904);
    return false;
  }
  
  public static boolean fk(String paramString)
  {
    GMTrace.i(13274804387840L, 98905);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("medianote");
      GMTrace.o(13274804387840L, 98905);
      return bool;
    }
    GMTrace.o(13274804387840L, 98905);
    return false;
  }
  
  public static boolean fl(String paramString)
  {
    GMTrace.i(13274938605568L, 98906);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("newsapp");
      GMTrace.o(13274938605568L, 98906);
      return bool;
    }
    GMTrace.o(13274938605568L, 98906);
    return false;
  }
  
  public static boolean fm(String paramString)
  {
    GMTrace.i(13275072823296L, 98907);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("voipapp");
      GMTrace.o(13275072823296L, 98907);
      return bool;
    }
    GMTrace.o(13275072823296L, 98907);
    return false;
  }
  
  public static boolean fn(String paramString)
  {
    GMTrace.i(13275207041024L, 98908);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("voicevoipapp");
      GMTrace.o(13275207041024L, 98908);
      return bool;
    }
    GMTrace.o(13275207041024L, 98908);
    return false;
  }
  
  public static boolean fo(String paramString)
  {
    GMTrace.i(13275341258752L, 98909);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("voiceinputapp");
      GMTrace.o(13275341258752L, 98909);
      return bool;
    }
    GMTrace.o(13275341258752L, 98909);
    return false;
  }
  
  public static boolean fp(String paramString)
  {
    GMTrace.i(13275475476480L, 98910);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("linkedinplugin");
      GMTrace.o(13275475476480L, 98910);
      return bool;
    }
    GMTrace.o(13275475476480L, 98910);
    return false;
  }
  
  public static boolean fq(String paramString)
  {
    GMTrace.i(13275609694208L, 98911);
    boolean bool = fs(paramString);
    GMTrace.o(13275609694208L, 98911);
    return bool;
  }
  
  public static boolean fr(String paramString)
  {
    GMTrace.i(13275743911936L, 98912);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("gh_43f2581f6fd6");
      GMTrace.o(13275743911936L, 98912);
      return bool;
    }
    GMTrace.o(13275743911936L, 98912);
    return false;
  }
  
  public static boolean fs(String paramString)
  {
    GMTrace.i(13275878129664L, 98913);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("gh_22b87fa7cb3c");
      GMTrace.o(13275878129664L, 98913);
      return bool;
    }
    GMTrace.o(13275878129664L, 98913);
    return false;
  }
  
  public static boolean ft(String paramString)
  {
    GMTrace.i(13276012347392L, 98914);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("blogapp");
      GMTrace.o(13276012347392L, 98914);
      return bool;
    }
    GMTrace.o(13276012347392L, 98914);
    return false;
  }
  
  public static boolean fu(String paramString)
  {
    GMTrace.i(13276146565120L, 98915);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("officialaccounts");
      GMTrace.o(13276146565120L, 98915);
      return bool;
    }
    GMTrace.o(13276146565120L, 98915);
    return false;
  }
  
  public static boolean fv(String paramString)
  {
    GMTrace.i(13276280782848L, 98916);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("helper_entry");
      GMTrace.o(13276280782848L, 98916);
      return bool;
    }
    GMTrace.o(13276280782848L, 98916);
    return false;
  }
  
  public static boolean fw(String paramString)
  {
    GMTrace.i(13276415000576L, 98917);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("qqfriend");
      GMTrace.o(13276415000576L, 98917);
      return bool;
    }
    GMTrace.o(13276415000576L, 98917);
    return false;
  }
  
  public static boolean fx(String paramString)
  {
    GMTrace.i(13276683436032L, 98919);
    boolean bool = "filehelper".equalsIgnoreCase(paramString);
    GMTrace.o(13276683436032L, 98919);
    return bool;
  }
  
  public static boolean fy(String paramString)
  {
    GMTrace.i(13276817653760L, 98920);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("pc_share");
      GMTrace.o(13276817653760L, 98920);
      return bool;
    }
    GMTrace.o(13276817653760L, 98920);
    return false;
  }
  
  public static boolean fz(String paramString)
  {
    GMTrace.i(13276951871488L, 98921);
    if (paramString != null)
    {
      boolean bool = paramString.equalsIgnoreCase("notifymessage");
      GMTrace.o(13276951871488L, 98921);
      return bool;
    }
    GMTrace.o(13276951871488L, 98921);
    return false;
  }
  
  public static void g(x paramx)
  {
    GMTrace.i(16766344364032L, 124919);
    boolean bool;
    x localx2;
    if (paramx != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localx2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramx.field_username);
      localx1 = paramx;
      if (localx2 != null) {
        if (!bf.mA(localx2.field_username)) {
          break label83;
        }
      }
    }
    label83:
    for (x localx1 = paramx;; localx1 = localx2)
    {
      localx1.th();
      t(localx1);
      GMTrace.o(16766344364032L, 124919);
      return;
      bool = false;
      break;
    }
  }
  
  public static void h(x paramx)
  {
    GMTrace.i(13269704114176L, 98867);
    boolean bool;
    x localx2;
    if (paramx != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localx2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramx.field_username);
      localx1 = paramx;
      if (localx2 != null) {
        if (!bf.mA(localx2.field_username)) {
          break label83;
        }
      }
    }
    label83:
    for (x localx1 = paramx;; localx1 = localx2)
    {
      localx1.te();
      t(localx1);
      GMTrace.o(13269704114176L, 98867);
      return;
      bool = false;
      break;
    }
  }
  
  public static void i(x paramx)
  {
    GMTrace.i(13269838331904L, 98868);
    if (paramx != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      x localx2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramx.field_username);
      x localx1;
      if (localx2 != null)
      {
        localx1 = localx2;
        if (!bf.mA(localx2.field_username)) {}
      }
      else
      {
        localx1 = paramx;
      }
      localx1.tf();
      t(localx1);
      paramx = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rl(paramx.field_username);
      if ((paramx != null) && ("@blacklist".equals(paramx.field_parentRef))) {
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().e(new String[] { paramx.field_username }, "");
      }
      GMTrace.o(13269838331904L, 98868);
      return;
    }
  }
  
  public static void j(x paramx)
  {
    GMTrace.i(13269972549632L, 98869);
    if (paramx != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      x localx2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramx.field_username);
      x localx1;
      if (localx2 != null)
      {
        localx1 = localx2;
        if (!bf.mA(localx2.field_username)) {}
      }
      else
      {
        localx1 = paramx;
      }
      localx1.tr();
      localx1.dc(paramx.sZ());
      s(localx1);
      GMTrace.o(13269972549632L, 98869);
      return;
    }
  }
  
  public static void k(x paramx)
  {
    GMTrace.i(13270106767360L, 98870);
    if (paramx != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      x localx2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramx.field_username);
      x localx1;
      if (localx2 != null)
      {
        localx1 = localx2;
        if (!bf.mA(localx2.field_username)) {}
      }
      else
      {
        localx1 = paramx;
      }
      localx1.ts();
      localx1.dc(paramx.sZ());
      s(localx1);
      GMTrace.o(13270106767360L, 98870);
      return;
    }
  }
  
  public static void k(String paramString, boolean paramBoolean)
  {
    GMTrace.i(13269569896448L, 98866);
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString);
    if ((paramString == null) || (bf.mA(paramString.field_username)))
    {
      GMTrace.o(13269569896448L, 98866);
      return;
    }
    if (paramBoolean) {
      paramString.tr();
    }
    for (;;)
    {
      s(paramString);
      GMTrace.o(13269569896448L, 98866);
      return;
      paramString.ts();
    }
  }
  
  public static void l(x paramx)
  {
    GMTrace.i(13270240985088L, 98871);
    if (paramx != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      x localx2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramx.field_username);
      x localx1;
      if (localx2 != null)
      {
        localx1 = localx2;
        if (!bf.mA(localx2.field_username)) {}
      }
      else
      {
        localx1 = paramx;
      }
      localx1.tn();
      localx1.dc(paramx.sZ());
      t(localx1);
      GMTrace.o(13270240985088L, 98871);
      return;
    }
  }
  
  public static void l(String paramString, boolean paramBoolean)
  {
    GMTrace.i(13270509420544L, 98873);
    if (!bf.mA(paramString)) {}
    x localx;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localx = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString);
      if ((localx != null) && (!bf.mA(localx.field_username))) {
        break;
      }
      GMTrace.o(13270509420544L, 98873);
      return;
    }
    localx.setType(localx.field_type | 0x800);
    t(localx);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rq(paramString);
    }
    GMTrace.o(13270509420544L, 98873);
  }
  
  public static void m(x paramx)
  {
    GMTrace.i(13270375202816L, 98872);
    if (paramx != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      x localx2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramx.field_username);
      x localx1;
      if (localx2 != null)
      {
        localx1 = localx2;
        if (!bf.mA(localx2.field_username)) {}
      }
      else
      {
        localx1 = paramx;
      }
      localx1.to();
      localx1.dc(paramx.sZ());
      t(localx1);
      GMTrace.o(13270375202816L, 98872);
      return;
    }
  }
  
  public static void m(String paramString, boolean paramBoolean)
  {
    GMTrace.i(13270777856000L, 98875);
    if (!bf.mA(paramString)) {}
    x localx;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localx = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramString);
      if ((localx != null) && (!bf.mA(localx.field_username))) {
        break;
      }
      GMTrace.o(13270777856000L, 98875);
      return;
    }
    localx.setType(localx.field_type & 0xF7FF);
    t(localx);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rr(paramString);
    }
    GMTrace.o(13270777856000L, 98875);
  }
  
  public static void n(x paramx)
  {
    GMTrace.i(13270912073728L, 98876);
    boolean bool;
    x localx2;
    if (paramx != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localx2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramx.field_username);
      localx1 = paramx;
      if (localx2 != null) {
        if (!bf.mA(localx2.field_username)) {
          break label83;
        }
      }
    }
    label83:
    for (x localx1 = paramx;; localx1 = localx2)
    {
      localx1.tp();
      t(localx1);
      GMTrace.o(13270912073728L, 98876);
      return;
      bool = false;
      break;
    }
  }
  
  public static void o(x paramx)
  {
    GMTrace.i(13271046291456L, 98877);
    boolean bool;
    x localx2;
    if (paramx != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localx2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramx.field_username);
      localx1 = paramx;
      if (localx2 != null) {
        if (!bf.mA(localx2.field_username)) {
          break label83;
        }
      }
    }
    label83:
    for (x localx1 = paramx;; localx1 = localx2)
    {
      localx1.tq();
      t(localx1);
      GMTrace.o(13271046291456L, 98877);
      return;
      bool = false;
      break;
    }
  }
  
  public static void p(x paramx)
  {
    boolean bool2 = true;
    GMTrace.i(13271180509184L, 98878);
    if (paramx != null)
    {
      bool1 = true;
      Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", bool1);
      if ((int)paramx.gTG == 0) {
        break label103;
      }
      bool1 = true;
      label34:
      Assert.assertTrue("MicroMsg.ContactStorageLogic: contactId == 0", bool1);
      if (paramx.field_username.length() <= 0) {
        break label108;
      }
    }
    label103:
    label108:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue("MicroMsg.ContactStorageLogic: username length <= 0", bool1);
      paramx.tc();
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().a(paramx.field_username, paramx);
      GMTrace.o(13271180509184L, 98878);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label34;
    }
  }
  
  public static void q(x paramx)
  {
    boolean bool2 = true;
    GMTrace.i(13271314726912L, 98879);
    if (paramx != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramx.gTG == 0) {
        break label98;
      }
      bool1 = true;
      label31:
      Assert.assertTrue(bool1);
      if (paramx.field_username.length() <= 0) {
        break label103;
      }
    }
    label98:
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramx.tc();
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().a(paramx.field_username, paramx);
      t(paramx);
      GMTrace.o(13271314726912L, 98879);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label31;
    }
  }
  
  public static void r(x paramx)
  {
    boolean bool2 = true;
    GMTrace.i(13271583162368L, 98881);
    if (paramx != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if ((int)paramx.gTG == 0) {
        break label74;
      }
      bool1 = true;
      label31:
      Assert.assertTrue(bool1);
      if (paramx.field_username.length() <= 0) {
        break label79;
      }
    }
    label74:
    label79:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramx.tI();
      t(paramx);
      GMTrace.o(13271583162368L, 98881);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label31;
    }
  }
  
  private static void s(x paramx)
  {
    GMTrace.i(13271717380096L, 98882);
    boolean bool;
    amq localamq;
    if (paramx != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if ((int)paramx.gTG == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().S(paramx);
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramx.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().a(paramx.field_username, paramx);
      localamq = new amq();
      localamq.tPo = paramx.field_username;
      if (!paramx.tF()) {
        break label165;
      }
    }
    label165:
    for (localamq.tPA = 1;; localamq.tPA = 2)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new e.a(52, localamq));
      GMTrace.o(13271717380096L, 98882);
      return;
      bool = false;
      break;
    }
  }
  
  public static void t(x paramx)
  {
    GMTrace.i(13271851597824L, 98883);
    if (paramx != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paramx.gTG == 0)
      {
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().S(paramx);
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(paramx.field_username);
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().a(paramx.field_username, paramx);
      u(paramx);
      GMTrace.o(13271851597824L, 98883);
      return;
    }
  }
  
  public static int[] t(List<String> paramList)
  {
    int j = 0;
    GMTrace.i(13272388468736L, 98887);
    long l = System.currentTimeMillis();
    int[] arrayOfInt1 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().cl(paramList);
    v.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - l));
    if (arrayOfInt1.length <= 0)
    {
      GMTrace.o(13272388468736L, 98887);
      return null;
    }
    l = System.currentTimeMillis();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().cm(paramList);
    v.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - l));
    if (paramList == null)
    {
      GMTrace.o(13272388468736L, 98887);
      return null;
    }
    if (arrayOfInt1.length == paramList.length) {}
    int[] arrayOfInt2;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      arrayOfInt2 = new int[paramList.length];
      int k = 0;
      int i = 0;
      while (j < arrayOfInt1.length)
      {
        arrayOfInt2[i] = k;
        k += paramList[j];
        j += 1;
        i += 1;
      }
    }
    GMTrace.o(13272388468736L, 98887);
    return arrayOfInt2;
  }
  
  public static void u(x paramx)
  {
    GMTrace.i(13271985815552L, 98884);
    v.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", new Object[] { paramx.field_username, paramx.field_conRemark, Integer.valueOf(paramx.field_type) });
    amb localamb = new amb();
    localamb.trH = new avu().OU(bf.mz(paramx.field_username));
    localamb.tJy = new avu().OU(bf.mz(paramx.field_nickname));
    localamb.trx = new avu().OU(bf.mz(paramx.pB()));
    localamb.jdField_try = new avu().OU(bf.mz(paramx.pC()));
    localamb.hAl = paramx.gkh;
    localamb.tqP = 561023;
    localamb.tqQ = paramx.field_type;
    localamb.tOz = new avu().OU(bf.mz(paramx.field_conRemark));
    localamb.tOA = new avu().OU(bf.mz(paramx.field_conRemarkPYShort));
    localamb.tOB = new avu().OU(bf.mz(paramx.field_conRemarkPYFull));
    localamb.tqV = paramx.gkm;
    localamb.tOT = new avu().OU(bf.mz(paramx.field_domainList));
    localamb.tqZ = paramx.gkp;
    localamb.hAp = paramx.gkq;
    localamb.hAo = bf.mz(paramx.signature);
    localamb.hAn = bf.mz(paramx.getCityCode());
    localamb.hAm = bf.mz(paramx.bKY());
    localamb.tLf = bf.mz(paramx.gkv);
    localamb.tLh = paramx.field_weiboFlag;
    localamb.tOP = 0;
    localamb.tdB = new avt();
    localamb.hAu = bf.mz(paramx.getCountryCode());
    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new e.a(2, localamb));
    GMTrace.o(13271985815552L, 98884);
  }
  
  public static String[] u(List<String> paramList)
  {
    int i = 0;
    GMTrace.i(13272925339648L, 98891);
    long l = System.currentTimeMillis();
    paramList = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().cl(paramList);
    v.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - l));
    if (paramList.length <= 0)
    {
      GMTrace.o(13272925339648L, 98891);
      return null;
    }
    String[] arrayOfString = new String[paramList.length];
    int j = 0;
    if (j < paramList.length)
    {
      char c = (char)paramList[j];
      if (c == '{')
      {
        arrayOfString[i] = "#";
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (c == ' ')
        {
          arrayOfString[i] = "$";
          i += 1;
        }
        else
        {
          arrayOfString[i] = String.valueOf(c);
          i += 1;
        }
      }
    }
    GMTrace.o(13272925339648L, 98891);
    return arrayOfString;
  }
  
  public static boolean v(x paramx)
  {
    GMTrace.i(13278696701952L, 98934);
    if ((paramx.field_weiboFlag & 0x1) != 0)
    {
      GMTrace.o(13278696701952L, 98934);
      return true;
    }
    GMTrace.o(13278696701952L, 98934);
    return false;
  }
  
  public static List<String> yA()
  {
    GMTrace.i(13279233572864L, 98938);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().bLi();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      GMTrace.o(13279233572864L, 98938);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      x localx = new x();
      localx.b(localCursor);
      localLinkedList.add(localx.field_username);
    } while (localCursor.moveToNext());
    localCursor.close();
    v.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + localLinkedList.size());
    GMTrace.o(13279233572864L, 98938);
    return localLinkedList;
  }
  
  public static int yB()
  {
    GMTrace.i(13279636226048L, 98941);
    int i = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().b(hlg, new String[] { m.xL(), "weixin", "helper_entry", "filehelper" });
    GMTrace.o(13279636226048L, 98941);
    return i;
  }
  
  public static List<String> yu()
  {
    GMTrace.i(13268764590080L, 98860);
    List localList = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().bLg();
    GMTrace.o(13268764590080L, 98860);
    return localList;
  }
  
  public static List<x> yv()
  {
    GMTrace.i(13268898807808L, 98861);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().bLh();
    if (localCursor.moveToFirst()) {
      do
      {
        x localx = new x();
        localx.b(localCursor);
        localArrayList.add(localx);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    GMTrace.o(13268898807808L, 98861);
    return localArrayList;
  }
  
  public static boolean yw()
  {
    GMTrace.i(13273999081472L, 98899);
    GMTrace.o(13273999081472L, 98899);
    return false;
  }
  
  public static boolean yx()
  {
    GMTrace.i(13278830919680L, 98935);
    if (!m.ys())
    {
      GMTrace.o(13278830919680L, 98935);
      return false;
    }
    ay localay = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wZ().AF("@t.qq.com");
    if ((localay == null) || (bf.mA(localay.name)))
    {
      GMTrace.o(13278830919680L, 98935);
      return false;
    }
    GMTrace.o(13278830919680L, 98935);
    return true;
  }
  
  public static boolean yy()
  {
    GMTrace.i(13278965137408L, 98936);
    if (!m.ys())
    {
      GMTrace.o(13278965137408L, 98936);
      return false;
    }
    ay localay = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wZ().AF("@t.qq.com");
    if ((localay == null) || (bf.mz(localay.name).length() == 0))
    {
      GMTrace.o(13278965137408L, 98936);
      return false;
    }
    GMTrace.o(13278965137408L, 98936);
    return true;
  }
  
  public static List<x> yz()
  {
    GMTrace.i(13279099355136L, 98937);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().bLk();
    if (localCursor.getCount() == 0)
    {
      localCursor.close();
      GMTrace.o(13279099355136L, 98937);
      return localLinkedList;
    }
    localCursor.moveToFirst();
    do
    {
      x localx = new x();
      localx.b(localCursor);
      localLinkedList.add(localx);
    } while (localCursor.moveToNext());
    localCursor.close();
    v.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + localLinkedList.size());
    GMTrace.o(13279099355136L, 98937);
    return localLinkedList;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */