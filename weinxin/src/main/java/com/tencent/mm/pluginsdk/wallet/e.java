package com.tencent.mm.pluginsdk.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class e
{
  public static void P(Context paramContext, int paramInt)
  {
    GMTrace.i(1225676292096L, 9132);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_scene", paramInt);
    com.tencent.mm.bb.d.b(paramContext, "collect", ".ui.CollectAdapterUI", localIntent);
    GMTrace.o(1225676292096L, 9132);
  }
  
  public static boolean Q(Context paramContext, int paramInt)
  {
    GMTrace.i(1226750033920L, 9140);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_bind_scene", 5);
    localIntent.putExtra("key_offline_add_fee", paramInt);
    com.tencent.mm.bb.d.b(paramContext, "wallet", ".bind.ui.WalletBindUI", localIntent);
    GMTrace.o(1226750033920L, 9140);
    return true;
  }
  
  public static boolean R(Context paramContext, int paramInt)
  {
    GMTrace.i(1226884251648L, 9141);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_scene_balance_manager", paramInt);
    if (m.xY()) {
      com.tencent.mm.bb.d.b(paramContext, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", localIntent);
    }
    for (;;)
    {
      GMTrace.o(1226884251648L, 9141);
      return true;
      com.tencent.mm.bb.d.b(paramContext, "wallet", ".balance.ui.WalletBalanceManagerUI", localIntent);
    }
  }
  
  public static PayInfo a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    GMTrace.i(1225944727552L, 9134);
    paramString3 = new PayInfo();
    paramString3.fJy = paramString1;
    paramString3.appId = paramString2;
    paramString3.rOg = null;
    paramString3.fRl = paramInt1;
    paramString3.fOW = null;
    paramString3.fRh = 0;
    GMTrace.o(1225944727552L, 9134);
    return paramString3;
  }
  
  public static boolean a(Context paramContext, int paramInt1, String paramString, int paramInt2, a parama)
  {
    GMTrace.i(1227018469376L, 9142);
    Intent localIntent = new Intent();
    localIntent.putExtra("scene", paramInt1);
    localIntent.putExtra("receiver_name", paramString);
    if (paramInt2 > 0) {
      localIntent.putExtra("pay_channel", paramInt2);
    }
    a.a(parama, localIntent);
    if (m.xY()) {
      com.tencent.mm.bb.d.b(paramContext, "wallet_payu", ".remittance.ui.PayURemittanceAdapterUI", localIntent);
    }
    for (;;)
    {
      GMTrace.o(1227018469376L, 9142);
      return true;
      if (m.xZ())
      {
        com.tencent.mm.bb.d.b(paramContext, "remittance", ".ui.RemittanceAdapterUI", localIntent);
        g.oSF.i(12097, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        g.oSF.i(11850, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
      }
      else
      {
        com.tencent.mm.bb.d.b(paramContext, "remittance", ".ui.RemittanceAdapterUI", localIntent);
        g.oSF.i(12097, new Object[] { Integer.valueOf(12), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        g.oSF.i(11850, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      }
    }
  }
  
  public static boolean a(Context paramContext, Bundle paramBundle, boolean paramBoolean)
  {
    GMTrace.i(1225407856640L, 9130);
    Intent localIntent = new Intent();
    localIntent.putExtra("orderhandlerui_checkapp_result", paramBoolean);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    com.tencent.mm.bb.d.b(paramContext, "wallet_index", ".ui.OrderHandlerUI", localIntent);
    GMTrace.o(1225407856640L, 9130);
    return true;
  }
  
  public static boolean a(Context paramContext, PayInfo paramPayInfo, int paramInt)
  {
    GMTrace.i(1226078945280L, 9135);
    boolean bool = a(paramContext, false, "", paramPayInfo, paramInt);
    GMTrace.o(1226078945280L, 9135);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    GMTrace.i(1225810509824L, 9133);
    if (bf.mA(paramString1))
    {
      GMTrace.o(1225810509824L, 9133);
      return false;
    }
    boolean bool = a(paramContext, a(paramString1, paramString2, null, null, paramInt1, 0), paramInt2);
    GMTrace.o(1225810509824L, 9133);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    GMTrace.i(17950144724992L, 133739);
    if (bf.mA(paramString2))
    {
      GMTrace.o(17950144724992L, 133739);
      return false;
    }
    boolean bool = a(paramContext, true, paramString1, a(paramString2, paramString3, null, null, paramInt1, 0), paramInt2);
    GMTrace.o(17950144724992L, 133739);
    return bool;
  }
  
  private static boolean a(Context paramContext, boolean paramBoolean, String paramString, PayInfo paramPayInfo, int paramInt)
  {
    GMTrace.i(1226213163008L, 9136);
    paramBoolean = a(paramContext, paramBoolean, paramString, paramPayInfo, null, new Intent(), paramInt);
    GMTrace.o(1226213163008L, 9136);
    return paramBoolean;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, String paramString1, PayInfo paramPayInfo, String paramString2, Intent paramIntent, int paramInt)
  {
    GMTrace.i(1226347380736L, 9137);
    paramBoolean = a(paramContext, paramBoolean, paramString1, "", paramPayInfo, paramString2, paramIntent, paramInt);
    GMTrace.o(1226347380736L, 9137);
    return paramBoolean;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, PayInfo paramPayInfo, String paramString3, Intent paramIntent, int paramInt)
  {
    GMTrace.i(1226481598464L, 9138);
    if ((2 == paramPayInfo.fRl) || (1 == paramPayInfo.fRl) || (4 == paramPayInfo.fRl) || (36 == paramPayInfo.fRl))
    {
      paramPayInfo.mpc = false;
      if ((paramPayInfo.fRl != 4) && (paramPayInfo.fRl != 1) && (36 != paramPayInfo.fRl) && (8 != paramPayInfo.fRl)) {
        break label191;
      }
      paramPayInfo.sWv = true;
      label96:
      paramIntent.putExtra("key_pay_info", paramPayInfo);
      paramIntent.putExtra("key_force_use_bind_serail", bf.mz(paramString1));
      paramIntent.putExtra("key_is_force_use_given_card", paramBoolean);
      if (!bf.mA(paramString2)) {
        paramIntent.putExtra("key_is_use_default_card", paramString2);
      }
      paramIntent.putExtra("key_receiver_true_name", paramString3);
      if (!m.xY()) {
        break label200;
      }
      com.tencent.mm.bb.d.b(paramContext, "wallet_payu", ".pay.ui.WalletPayUPayUI", paramIntent, paramInt);
    }
    for (;;)
    {
      GMTrace.o(1226481598464L, 9138);
      return true;
      paramPayInfo.mpc = true;
      break;
      label191:
      paramPayInfo.sWv = false;
      break label96;
      label200:
      com.tencent.mm.bb.d.b(paramContext, "wallet", ".pay.ui.WalletPayUI", paramIntent, paramInt);
    }
  }
  
  public static boolean a(MMActivity paramMMActivity, d paramd, int paramInt, MMActivity.a parama)
  {
    GMTrace.i(1225542074368L, 9131);
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", paramd.appId);
    localIntent.putExtra("timeStamp", paramd.timeStamp);
    localIntent.putExtra("nonceStr", paramd.nonceStr);
    localIntent.putExtra("packageExt", paramd.packageExt);
    localIntent.putExtra("signtype", paramd.signType);
    localIntent.putExtra("paySignature", paramd.fRj);
    localIntent.putExtra("url", paramd.url);
    localIntent.putExtra("bizUsername", paramd.fRk);
    localIntent.putExtra("pay_channel", paramd.fRn);
    localIntent.putExtra("pay_for_wallet_type", paramd.sWI);
    localIntent.putExtra("pay_scene", paramd.fRl);
    localIntent.putExtra("result_jump_mode", paramd.sWK);
    paramMMActivity.uRg = parama;
    com.tencent.mm.bb.d.a(paramMMActivity, "wallet_index", ".ui.WalletBrandUI", localIntent, paramInt, false);
    GMTrace.o(1225542074368L, 9131);
    return true;
  }
  
  public static boolean b(MMActivity paramMMActivity, d paramd, int paramInt, MMActivity.a parama)
  {
    GMTrace.i(1226615816192L, 9139);
    Intent localIntent = new Intent();
    localIntent.putExtra("appId", paramd.appId);
    localIntent.putExtra("timeStamp", paramd.timeStamp);
    localIntent.putExtra("nonceStr", paramd.nonceStr);
    localIntent.putExtra("packageExt", paramd.packageExt);
    localIntent.putExtra("signtype", paramd.signType);
    localIntent.putExtra("paySignature", paramd.fRj);
    localIntent.putExtra("url", paramd.url);
    localIntent.putExtra("key_bind_scene", paramd.fRm);
    paramMMActivity.uRg = parama;
    com.tencent.mm.bb.d.a(paramMMActivity, "wallet", ".bind.ui.WalletBindUI", localIntent, paramInt, false);
    GMTrace.o(1226615816192L, 9139);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/wallet/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */