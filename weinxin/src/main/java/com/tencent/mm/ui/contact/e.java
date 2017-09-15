package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.ae;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.x;

public final class e
{
  public static void a(Context paramContext, au.a parama)
  {
    GMTrace.i(1781874556928L, 13276);
    a(paramContext, parama, false, false, null);
    GMTrace.o(1781874556928L, 13276);
  }
  
  public static void a(Context paramContext, au.a parama, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    GMTrace.i(1782008774656L, 13277);
    if ((paramContext == null) || (parama == null))
    {
      GMTrace.o(1782008774656L, 13277);
      return;
    }
    x localx = new x();
    localx.setUsername(parama.rTh);
    localx.bR(parama.getDisplayName());
    localx.bS(parama.hBM);
    localx.bT(parama.hBN);
    a(paramContext, localx, parama, paramBoolean1, paramBoolean2, paramBundle, parama.otA);
    GMTrace.o(1782008774656L, 13277);
  }
  
  public static void a(Context paramContext, x paramx, au.a parama)
  {
    GMTrace.i(1782142992384L, 13278);
    a(paramContext, paramx, parama, false, false, null, parama.otA);
    GMTrace.o(1782142992384L, 13278);
  }
  
  public static void a(Context paramContext, x paramx, au.a parama, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle, String paramString)
  {
    GMTrace.i(1782277210112L, 13279);
    if ((paramx == null) || (parama == null))
    {
      GMTrace.o(1782277210112L, 13279);
      return;
    }
    if ((paramx.field_username == null) || (paramx.field_username.length() <= 0))
    {
      GMTrace.o(1782277210112L, 13279);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramx.field_username);
    localIntent.putExtra("Contact_Alias", paramx.pA());
    localIntent.putExtra("Contact_Nick", paramx.tK());
    localIntent.putExtra("Contact_QuanPin", paramx.pC());
    localIntent.putExtra("Contact_PyInitial", paramx.pB());
    localIntent.putExtra("Contact_Sex", parama.gkh);
    localIntent.putExtra("Contact_Province", parama.getProvince());
    localIntent.putExtra("Contact_City", parama.getCity());
    localIntent.putExtra("Contact_Signature", parama.signature);
    localIntent.putExtra("Contact_Uin", parama.oty);
    localIntent.putExtra("Contact_Mobile_MD5", parama.uIi);
    localIntent.putExtra("Contact_full_Mobile_MD5", parama.uIj);
    localIntent.putExtra("Contact_QQNick", parama.bMx());
    localIntent.putExtra("User_From_Fmessage", true);
    localIntent.putExtra("Contact_Scene", parama.scene);
    localIntent.putExtra("Contact_from_msgType", 40);
    if (paramBoolean1) {
      localIntent.putExtra("Contact_ShowUserName", false);
    }
    if (paramBoolean2) {
      localIntent.putExtra("Contact_KSnsIFlag", 0);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("verify_gmail", paramString);
    }
    d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    GMTrace.o(1782277210112L, 13279);
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    GMTrace.i(1781740339200L, 13275);
    if ((paramIntent == null) || (paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.ContactInfoUtil", "setLocalQQMobile fail, intent = " + paramIntent + ", username = " + paramString);
      GMTrace.o(1781740339200L, 13275);
      return;
    }
    ad localad = com.tencent.mm.modelfriend.af.Ge().jl(paramString);
    if (localad != null)
    {
      paramIntent.putExtra("Contact_Uin", localad.hBJ);
      paramIntent.putExtra("Contact_QQNick", localad.getDisplayName());
    }
    paramString = com.tencent.mm.modelfriend.af.FZ().ja(paramString);
    if (paramString != null) {
      paramIntent.putExtra("Contact_Mobile_MD5", paramString.EQ());
    }
    GMTrace.o(1781740339200L, 13275);
  }
  
  public static void l(Intent paramIntent, String paramString)
  {
    GMTrace.i(1781606121472L, 13274);
    paramIntent.putExtra("Contact_User", paramString);
    GMTrace.o(1781606121472L, 13274);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */