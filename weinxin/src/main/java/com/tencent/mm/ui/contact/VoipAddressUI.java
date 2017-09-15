package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.e.b.af;
import com.tencent.mm.i.e;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;
import java.util.List;

public class VoipAddressUI
  extends MMBaseSelectContactUI
{
  private String fJC;
  private List<String> jzO;
  private boolean vYg;
  private boolean vYh;
  private com.tencent.mm.sdk.b.c vYi;
  
  public VoipAddressUI()
  {
    GMTrace.i(1750333390848L, 13041);
    this.vYg = false;
    this.vYh = false;
    this.fJC = "";
    this.vYi = new com.tencent.mm.sdk.b.c() {};
    GMTrace.o(1750333390848L, 13041);
  }
  
  private void aTy()
  {
    GMTrace.i(1750736044032L, 13044);
    boolean bool = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
    v.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), this });
    if (!bool)
    {
      GMTrace.o(1750736044032L, 13044);
      return;
    }
    rr localrr = new rr();
    localrr.fYy.fJB = 5;
    localrr.fYy.fJC = this.fJC;
    localrr.fYy.context = this;
    if (this.vYg) {}
    for (int i = 2;; i = 1)
    {
      localrr.fYy.fYt = 3;
      com.tencent.mm.plugin.report.service.g.oSF.i(11033, new Object[] { Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0) });
      com.tencent.mm.sdk.b.a.uql.m(localrr);
      aGY();
      GMTrace.o(1750736044032L, 13044);
      return;
    }
  }
  
  private void aTz()
  {
    GMTrace.i(1750870261760L, 13045);
    boolean bool = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, "", "");
    v.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), this });
    if (!bool)
    {
      GMTrace.o(1750870261760L, 13045);
      return;
    }
    bool = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
    v.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), this });
    if (!bool)
    {
      GMTrace.o(1750870261760L, 13045);
      return;
    }
    rr localrr = new rr();
    localrr.fYy.fJB = 5;
    localrr.fYy.fJC = this.fJC;
    localrr.fYy.context = this;
    if (this.vYg) {}
    for (int i = 2;; i = 1)
    {
      localrr.fYy.fYt = 2;
      com.tencent.mm.plugin.report.service.g.oSF.i(11033, new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0) });
      com.tencent.mm.sdk.b.a.uql.m(localrr);
      aGY();
      GMTrace.o(1750870261760L, 13045);
      return;
    }
  }
  
  public static void eY(Context paramContext)
  {
    int i = 0;
    GMTrace.i(1751407132672L, 13049);
    boolean bool;
    if (1 == bf.getInt(com.tencent.mm.i.g.sV().getValue("VOIPCallType"), 0))
    {
      bool = true;
      Intent localIntent = new Intent(paramContext, VoipAddressUI.class);
      localIntent.putExtra("Add_address_titile", paramContext.getString(R.l.dCK));
      localIntent.putExtra("voip_video", bool);
      paramContext.startActivity(localIntent);
      paramContext = com.tencent.mm.plugin.report.service.g.oSF;
      if (!bool) {
        break label115;
      }
    }
    for (;;)
    {
      paramContext.i(11034, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
      GMTrace.o(1751407132672L, 13049);
      return;
      bool = false;
      break;
      label115:
      i = 1;
    }
  }
  
  protected final void Of()
  {
    GMTrace.i(1751004479488L, 13046);
    super.Of();
    String str = getIntent().getStringExtra("LauncherUI.Shortcut.LaunchType");
    this.vYh = getIntent().getBooleanExtra("voip_video", true);
    if (str != null)
    {
      this.vYg = true;
      if (!str.equals("launch_type_voip")) {
        break label107;
      }
      this.vYh = true;
    }
    for (;;)
    {
      this.jzO = new ArrayList();
      this.jzO.addAll(s.bYb());
      this.jzO.addAll(s.bYc());
      GMTrace.o(1751004479488L, 13046);
      return;
      label107:
      if (str.equals("launch_type_voip_audio")) {
        this.vYh = false;
      }
    }
  }
  
  protected final boolean Og()
  {
    GMTrace.i(1752212439040L, 13055);
    GMTrace.o(1752212439040L, 13055);
    return false;
  }
  
  protected final boolean Oh()
  {
    GMTrace.i(1751541350400L, 13050);
    GMTrace.o(1751541350400L, 13050);
    return true;
  }
  
  protected final String Oi()
  {
    GMTrace.i(1752078221312L, 13054);
    String str2 = getIntent().getStringExtra("Add_address_titile");
    String str1 = str2;
    if (!bf.mA(str2)) {
      str1 = getString(R.l.dCK);
    }
    GMTrace.o(1752078221312L, 13054);
    return str1;
  }
  
  protected final o Oj()
  {
    GMTrace.i(1751138697216L, 13047);
    Object localObject = new c.a();
    ((c.a)localObject).vUf = true;
    ((c.a)localObject).vUe = true;
    localObject = new c(this, this.jzO, false, (c.a)localObject);
    GMTrace.o(1751138697216L, 13047);
    return (o)localObject;
  }
  
  protected final m Ok()
  {
    GMTrace.i(1751272914944L, 13048);
    q localq = new q(this, this.jzO, false, this.scene);
    GMTrace.o(1751272914944L, 13048);
    return localq;
  }
  
  public final int[] aIH()
  {
    GMTrace.i(1751675568128L, 13051);
    GMTrace.o(1751675568128L, 13051);
    return new int[] { 131072 };
  }
  
  protected final void aII()
  {
    GMTrace.i(1751944003584L, 13053);
    if (this.vYg)
    {
      Intent localIntent = new Intent(this, LauncherUI.class);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    aGY();
    finish();
    GMTrace.o(1751944003584L, 13053);
  }
  
  public final void he(int paramInt)
  {
    GMTrace.i(1750601826304L, 13043);
    com.tencent.mm.ui.contact.a.a locala = (com.tencent.mm.ui.contact.a.a)this.oBp.getAdapter().getItem(paramInt);
    if (locala == null)
    {
      GMTrace.o(1750601826304L, 13043);
      return;
    }
    if (locala.jht == null)
    {
      GMTrace.o(1750601826304L, 13043);
      return;
    }
    this.fJC = locala.jht.field_username;
    if (this.vYh)
    {
      aTz();
      GMTrace.o(1750601826304L, 13043);
      return;
    }
    aTy();
    GMTrace.o(1750601826304L, 13043);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1750467608576L, 13042);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.uql.b(this.vYi);
    GMTrace.o(1750467608576L, 13042);
  }
  
  public void onDestroy()
  {
    GMTrace.i(1751809785856L, 13052);
    com.tencent.mm.sdk.b.a.uql.c(this.vYi);
    super.onDestroy();
    GMTrace.o(1751809785856L, 13052);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    GMTrace.i(1752346656768L, 13056);
    v.i("MicroMsg.VoipAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(1752346656768L, 13056);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aTz();
        GMTrace.o(1752346656768L, 13056);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = R.l.eFy;; paramInt = R.l.eFB)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.g.a(this, getString(paramInt), getString(R.l.eFE), getString(R.l.evo), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(1829790285824L, 13633);
              paramAnonymousDialogInterface.dismiss();
              VoipAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
              GMTrace.o(1829790285824L, 13633);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(1781471903744L, 13273);
              paramAnonymousDialogInterface.dismiss();
              GMTrace.o(1781471903744L, 13273);
            }
          });
        }
        GMTrace.o(1752346656768L, 13056);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        aTy();
        GMTrace.o(1752346656768L, 13056);
        return;
      }
      com.tencent.mm.ui.base.g.a(this, getString(R.l.eFA), getString(R.l.eFE), getString(R.l.evo), getString(R.l.cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(1811805110272L, 13499);
          VoipAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
          GMTrace.o(1811805110272L, 13499);
        }
      }, null);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/VoipAddressUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */