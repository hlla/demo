package com.tencent.mm.plugin.subapp.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import java.io.File;
import java.util.Map;
import junit.framework.Assert;

public final class h
{
  public static g Hj(String paramString)
  {
    GMTrace.i(5845584707584L, 43553);
    Object localObject2 = d.bmR();
    Object localObject1 = null;
    String str = "SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo WHERE filename= ?";
    localObject2 = ((k)localObject2).gUp.a(str, new String[] { paramString }, 2);
    paramString = (String)localObject1;
    if (((Cursor)localObject2).moveToFirst())
    {
      paramString = new g();
      paramString.b((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    GMTrace.o(5845584707584L, 43553);
    return paramString;
  }
  
  public static c Hk(String paramString)
  {
    GMTrace.i(5845987360768L, 43556);
    k localk = d.bmR();
    paramString = at(paramString, false);
    if (localk.qRU.get(paramString) == null) {
      localk.qRU.put(paramString, new c(paramString));
    }
    paramString = (c)localk.qRU.get(paramString);
    GMTrace.o(5845987360768L, 43556);
    return paramString;
  }
  
  static boolean a(g paramg)
  {
    GMTrace.i(5845853143040L, 43555);
    if (paramg == null)
    {
      GMTrace.o(5845853143040L, 43555);
      return false;
    }
    if (paramg.fRM == -1)
    {
      GMTrace.o(5845853143040L, 43555);
      return false;
    }
    k localk = d.bmR();
    String str = paramg.field_filename;
    boolean bool;
    if (str.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramg == null) {
        break label106;
      }
      bool = true;
      label68:
      Assert.assertTrue(bool);
      paramg = paramg.pv();
      if (paramg.size() > 0) {
        break label111;
      }
      v.e("MicroMsg.VoiceRemindStorage", "update failed, no values set");
    }
    label106:
    label111:
    while (localk.gUp.update("VoiceRemindInfo", paramg, "filename= ?", new String[] { str }) <= 0)
    {
      GMTrace.o(5845853143040L, 43555);
      return false;
      bool = false;
      break;
      bool = false;
      break label68;
    }
    localk.doNotify();
    GMTrace.o(5845853143040L, 43555);
    return true;
  }
  
  public static String at(String paramString, boolean paramBoolean)
  {
    GMTrace.i(5845182054400L, 43550);
    ap.yY();
    paramString = com.tencent.mm.sdk.platformtools.h.a(com.tencent.mm.u.c.xg(), "recbiz_", paramString, ".rec", 2);
    if (bf.mA(paramString))
    {
      GMTrace.o(5845182054400L, 43550);
      return null;
    }
    if (paramBoolean)
    {
      GMTrace.o(5845182054400L, 43550);
      return paramString;
    }
    if (new File(paramString).exists())
    {
      GMTrace.o(5845182054400L, 43550);
      return paramString;
    }
    GMTrace.o(5845182054400L, 43550);
    return paramString;
  }
  
  public static boolean lB(String paramString)
  {
    GMTrace.i(5845718925312L, 43554);
    if (paramString == null)
    {
      GMTrace.o(5845718925312L, 43554);
      return false;
    }
    g localg = Hj(paramString);
    if (localg == null)
    {
      v.e("MicroMsg.VoiceRemindLogic", "Set error failed file:" + paramString);
      GMTrace.o(5845718925312L, 43554);
      return false;
    }
    localg.field_status = 98;
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.fRM = 320;
    boolean bool = a(localg);
    v.d("MicroMsg.VoiceRemindLogic", "setError file:" + paramString + " msgid:" + localg.field_msglocalid + " old stat:" + localg.field_status);
    if ((localg.field_msglocalid == 0) || (bf.mA(localg.field_user)))
    {
      v.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + localg.field_msglocalid + " user:" + localg.field_user);
      GMTrace.o(5845718925312L, 43554);
      return bool;
    }
    ap.yY();
    paramString = com.tencent.mm.u.c.wT().cA(localg.field_msglocalid);
    paramString.x(localg.field_msglocalid);
    paramString.dv(5);
    paramString.cH(localg.field_user);
    paramString.setContent(f.b(localg.field_human, -1L, true));
    ap.yY();
    com.tencent.mm.u.c.wT().a(paramString.field_msgId, paramString);
    GMTrace.o(5845718925312L, 43554);
    return bool;
  }
  
  static void lX(String paramString)
  {
    GMTrace.i(5845450489856L, 43552);
    d.bmR().lX(at(paramString, false));
    GMTrace.o(5845450489856L, 43552);
  }
  
  public static boolean mb(String paramString)
  {
    GMTrace.i(5845316272128L, 43551);
    if (paramString == null)
    {
      GMTrace.o(5845316272128L, 43551);
      return false;
    }
    g localg = Hj(paramString);
    if (localg == null)
    {
      v.d("MicroMsg.VoiceRemindLogic", "cancel null record : " + paramString);
      GMTrace.o(5845316272128L, 43551);
      return true;
    }
    v.d("MicroMsg.VoiceRemindLogic", "cancel record : " + paramString + " LocalId:" + localg.field_msglocalid);
    if (localg.field_msglocalid != 0)
    {
      ap.yY();
      com.tencent.mm.u.c.wT().cB(localg.field_msglocalid);
    }
    if (paramString == null)
    {
      GMTrace.o(5845316272128L, 43551);
      return false;
    }
    d.bmR().gR(paramString);
    lX(paramString);
    boolean bool = new File(at(paramString, false)).delete();
    GMTrace.o(5845316272128L, 43551);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */