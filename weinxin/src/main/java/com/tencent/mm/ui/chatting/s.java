package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.transmit.SelectConversationUI;

public final class s
{
  public static boolean a(String paramString1, Context paramContext, q paramq, String paramString2)
  {
    GMTrace.i(2181172297728L, 16251);
    if (bf.mA(paramString1))
    {
      GMTrace.o(2181172297728L, 16251);
      return false;
    }
    Object localObject = null;
    if (paramString1.startsWith("weixin://openNativeUrl/weixinHB")) {
      localObject = new a();
    }
    label126:
    label181:
    while ((localObject != null) && (((c)localObject).a(paramString1, paramContext, paramq, paramString2)))
    {
      GMTrace.o(2181172297728L, 16251);
      return true;
      if ((paramString1 != null) && ((paramString1.startsWith("weixin://openNativeUrl/myDeviceList")) || (paramString1.startsWith("weixin://openNativeUrl/bindMyDevice")))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label126;
        }
        localObject = new b();
        break;
      }
      if ((paramString1 != null) && ((paramString1.startsWith("weixin://wesport/recommend")) || (paramString1.startsWith("weixin://openNativeUrl/rankMyHomepage")) || (paramString1.startsWith("weixin://openNativeUrl/rankSetting")))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label181;
        }
        localObject = new d();
        break;
      }
    }
    GMTrace.o(2181172297728L, 16251);
    return false;
  }
  
  static final class a
    implements s.c
  {
    a()
    {
      GMTrace.i(2149765349376L, 16017);
      GMTrace.o(2149765349376L, 16017);
    }
    
    public final boolean a(String paramString1, Context paramContext, q paramq, String paramString2)
    {
      GMTrace.i(2149899567104L, 16018);
      if (paramString1.startsWith("weixin://openNativeUrl/weixinHB/startsendnormalhbrequest"))
      {
        paramString1 = new Intent();
        paramString1.putExtra("key_type", 0);
        d.b(paramContext, "luckymoney", ".ui.LuckyMoneyPrepareUI", paramString1);
        GMTrace.o(2149899567104L, 16018);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/weixinHB/startsendrandomhbrequest"))
      {
        paramString1 = new Intent();
        paramString1.putExtra("key_type", 1);
        d.b(paramContext, "luckymoney", ".ui.LuckyMoneyPrepareUI", paramString1);
        GMTrace.o(2149899567104L, 16018);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/weixinHB/startsendhblistrequest"))
      {
        paramString1 = new Intent();
        paramString1.putExtra("key_type", 1);
        d.b(paramContext, "luckymoney", ".ui.LuckyMoneyMyRecordUI", paramString1);
        GMTrace.o(2149899567104L, 16018);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/weixinHB/startreceivehblistrequest"))
      {
        paramString1 = new Intent();
        paramString1.putExtra("key_type", 2);
        d.b(paramContext, "luckymoney", ".ui.LuckyMoneyMyRecordUI", paramString1);
        GMTrace.o(2149899567104L, 16018);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/weixinHB/openDetail"))
      {
        paramq = new Intent();
        paramq.putExtra("key_native_url", paramString1);
        d.b(paramContext, "luckymoney", ".ui.LuckyMoneyDetailUI", paramq);
        GMTrace.o(2149899567104L, 16018);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest"))
      {
        paramq = new Intent();
        paramq.putExtra("key_way", 5);
        paramq.putExtra("key_native_url", paramString1);
        paramq.putExtra("key_static_from_scene", 1);
        d.b(paramContext, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", paramq);
        GMTrace.o(2149899567104L, 16018);
        return true;
      }
      GMTrace.o(2149899567104L, 16018);
      return false;
    }
  }
  
  static final class b
    implements s.c
  {
    b()
    {
      GMTrace.i(2238214832128L, 16676);
      GMTrace.o(2238214832128L, 16676);
    }
    
    public final boolean a(String paramString1, Context paramContext, q paramq, String paramString2)
    {
      GMTrace.i(2238349049856L, 16677);
      if (bf.mA(paramString1))
      {
        GMTrace.o(2238349049856L, 16677);
        return false;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/myDeviceList"))
      {
        paramString1 = new Intent();
        paramString1.putExtra("device_brand_name", paramString2);
        d.b(paramContext, "exdevice", ".ui.ExdeviceManageDeviceUI", paramString1);
        GMTrace.o(2238349049856L, 16677);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/bindMyDevice"))
      {
        GMTrace.o(2238349049856L, 16677);
        return false;
      }
      GMTrace.o(2238349049856L, 16677);
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean a(String paramString1, Context paramContext, q paramq, String paramString2);
  }
  
  static final class d
    implements s.c
  {
    d()
    {
      GMTrace.i(2515911311360L, 18745);
      GMTrace.o(2515911311360L, 18745);
    }
    
    public final boolean a(String paramString1, Context paramContext, q paramq, String paramString2)
    {
      GMTrace.i(2516045529088L, 18746);
      if (bf.mA(paramString1))
      {
        v.d("MicroMsg.BizNativeUrlDispatcher", "nativeUrl is null.");
        GMTrace.o(2516045529088L, 18746);
        return false;
      }
      if ((paramString1.startsWith("weixin://wesport/recommend")) && (paramq != null))
      {
        paramString1 = new Intent(paramContext, SelectConversationUI.class);
        paramString1.putExtra("Select_Talker_Name", paramString2);
        paramString1.putExtra("Select_block_List", paramString2);
        paramString1.putExtra("Select_Conv_Type", 3);
        paramString1.putExtra("Select_Send_Card", true);
        paramq.startActivityForResult(paramString1, 224);
        GMTrace.o(2516045529088L, 18746);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/rankMyHomepage"))
      {
        paramString1 = m.xL();
        if (bf.mA(paramString1))
        {
          v.e("MicroMsg.BizNativeUrlDispatcher", "Get username from UserInfo return null or nil.");
          GMTrace.o(2516045529088L, 18746);
          return false;
        }
        paramq = new Intent();
        paramq.putExtra("username", paramString1);
        d.b(paramContext, "exdevice", ".ui.ExdeviceProfileUI", paramq);
        v.i("MicroMsg.BizNativeUrlDispatcher", "Jump to ExdeviceProfileUI.");
        GMTrace.o(2516045529088L, 18746);
        return true;
      }
      if (paramString1.startsWith("weixin://openNativeUrl/rankSetting"))
      {
        d.w(paramContext, "exdevice", ".ui.ExdeviceSettingUI");
        GMTrace.o(2516045529088L, 18746);
        return true;
      }
      GMTrace.o(2516045529088L, 18746);
      return false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */