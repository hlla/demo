package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.d;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.protocal.c.bcl;
import com.tencent.mm.protocal.c.mx;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.d.a;

public final class c
{
  public static void a(Intent paramIntent, awm paramawm, int paramInt)
  {
    GMTrace.i(1137495244800L, 8475);
    String str = n.a(paramawm.trH);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", n.a(paramawm.tJy));
    paramIntent.putExtra("Contact_PyInitial", n.a(paramawm.trx));
    paramIntent.putExtra("Contact_QuanPin", n.a(paramawm.jdField_try));
    paramIntent.putExtra("Contact_Alias", paramawm.hAq);
    paramIntent.putExtra("Contact_Sex", paramawm.hAl);
    paramIntent.putExtra("Contact_VUser_Info", paramawm.tLe);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramawm.tLd);
    paramIntent.putExtra("Contact_KWeibo_flag", paramawm.tLh);
    paramIntent.putExtra("Contact_KWeibo", paramawm.tLf);
    paramIntent.putExtra("Contact_KWeiboNick", paramawm.tLg);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(paramawm.hAu, paramawm.hAm, paramawm.hAn));
    paramIntent.putExtra("Contact_Signature", paramawm.hAo);
    paramIntent.putExtra("Contact_BrandList", paramawm.hAv);
    paramIntent.putExtra("Contact_KSnsIFlag", paramawm.tLj.hAw);
    paramIntent.putExtra("Contact_KSnsBgId", paramawm.tLj.hAy);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramawm.tLj.hAx);
    paramIntent.putExtra(d.a.uMI, paramawm.tAe);
    v.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", new Object[] { paramawm.tAe });
    paramIntent = new BizInfo();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramawm.hAv;
    paramawm = paramawm.tLk;
    if (paramawm != null)
    {
      paramIntent.field_brandFlag = paramawm.hAz;
      paramIntent.field_brandInfo = paramawm.hAB;
      paramIntent.field_extInfo = paramawm.hAA;
      paramIntent.field_brandIconURL = paramawm.hAC;
    }
    if (!w.DH().e(paramIntent)) {
      w.DH().d(paramIntent);
    }
    GMTrace.o(1137495244800L, 8475);
  }
  
  public static void a(Intent paramIntent, awo paramawo, int paramInt)
  {
    GMTrace.i(1137361027072L, 8474);
    String str = n.a(paramawo.trH);
    paramIntent.putExtra("Contact_User", str);
    paramIntent.putExtra("Contact_Nick", n.a(paramawo.tJy));
    paramIntent.putExtra("Contact_PyInitial", n.a(paramawo.trx));
    paramIntent.putExtra("Contact_QuanPin", n.a(paramawo.jdField_try));
    paramIntent.putExtra("Contact_Alias", paramawo.hAq);
    paramIntent.putExtra("Contact_Sex", paramawo.hAl);
    paramIntent.putExtra("Contact_VUser_Info", paramawo.tLe);
    paramIntent.putExtra("Contact_VUser_Info_Flag", paramawo.tLd);
    paramIntent.putExtra("Contact_KWeibo_flag", paramawo.tLh);
    paramIntent.putExtra("Contact_KWeibo", paramawo.tLf);
    paramIntent.putExtra("Contact_KWeiboNick", paramawo.tLg);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(paramawo.hAu, paramawo.hAm, paramawo.hAn));
    paramIntent.putExtra("Contact_Signature", paramawo.hAo);
    paramIntent.putExtra("Contact_BrandList", paramawo.hAv);
    paramIntent.putExtra("Contact_KSnsIFlag", paramawo.tLj.hAw);
    paramIntent.putExtra("Contact_KSnsBgId", paramawo.tLj.hAy);
    paramIntent.putExtra("Contact_KSnsBgUrl", paramawo.tLj.hAx);
    paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", paramawo.tXV);
    paramIntent.putExtra(d.a.uMI, paramawo.tAe);
    v.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", new Object[] { paramawo.tAe });
    paramIntent = new BizInfo();
    paramIntent.field_username = str;
    paramIntent.field_brandList = paramawo.hAv;
    paramIntent.field_kfWorkerId = paramawo.tXV;
    paramawo = paramawo.tLk;
    if (paramawo != null)
    {
      paramIntent.field_brandFlag = paramawo.hAz;
      paramIntent.field_brandInfo = paramawo.hAB;
      paramIntent.field_extInfo = paramawo.hAA;
      paramIntent.field_brandIconURL = paramawo.hAC;
    }
    if (!w.DH().e(paramIntent)) {
      w.DH().d(paramIntent);
    }
    GMTrace.o(1137361027072L, 8474);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */