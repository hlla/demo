package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.LinkedList;

public class WXBizEntryActivity
  extends AutoLoginActivity
{
  private int jNx;
  
  public WXBizEntryActivity()
  {
    GMTrace.i(12828530442240L, 95580);
    GMTrace.o(12828530442240L, 95580);
  }
  
  protected final void a(AutoLoginActivity.b paramb, Intent paramIntent)
  {
    GMTrace.i(12829067313152L, 95584);
    v.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = " + paramb);
    if (getIntent() != null) {
      this.jNx = getIntent().getIntExtra("key_command_id", 0);
    }
    switch (5.jNz[paramb.ordinal()])
    {
    default: 
      v.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = " + paramb);
    }
    for (;;)
    {
      finish();
      GMTrace.o(12829067313152L, 95584);
      return;
      v.i("MicroMsg.WXBizEntryActivity", "req type = %d", new Object[] { Integer.valueOf(this.jNx) });
      switch (this.jNx)
      {
      case 10: 
      case 18: 
      default: 
        finish();
      }
      for (;;)
      {
        GMTrace.o(12829067313152L, 95584);
        return;
        com.tencent.mm.bb.d.a(this, "card", ".ui.CardAddEntranceUI", getIntent(), false);
        finish();
        GMTrace.o(12829067313152L, 95584);
        return;
        com.tencent.mm.bb.d.a(this, "card", ".ui.CardListSelectedUI", getIntent(), false);
        finish();
        GMTrace.o(12829067313152L, 95584);
        return;
        paramb = getIntent();
        paramb.setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
        startActivity(paramb);
        finish();
        GMTrace.o(12829067313152L, 95584);
        return;
        paramb = getIntent();
        paramb.putExtra("device_type", 1);
        com.tencent.mm.bb.d.a(this, "exdevice", ".ui.ExdeviceRankInfoUI", paramb, false);
        finish();
        GMTrace.o(12829067313152L, 95584);
        return;
        paramb = getIntent();
        paramb.putExtra("key_static_from_scene", 100001);
        com.tencent.mm.bb.d.a(this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", paramb, false);
        finish();
        GMTrace.o(12829067313152L, 95584);
        return;
        new a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new d.a()
        {
          public final void cP(boolean paramAnonymousBoolean)
          {
            GMTrace.i(12842623303680L, 95685);
            if (paramAnonymousBoolean) {
              com.tencent.mm.bb.d.a(WXBizEntryActivity.this, "game", ".ui.CreateOrJoinChatroomUI", WXBizEntryActivity.this.getIntent(), false);
            }
            for (;;)
            {
              WXBizEntryActivity.this.finish();
              GMTrace.o(12842623303680L, 95685);
              return;
              v.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
            }
          }
        }).acB();
        GMTrace.o(12829067313152L, 95584);
        return;
        String str1;
        String str2;
        int i;
        try
        {
          paramIntent = getIntent().getData();
          paramb = new Runnable()
          {
            public final void run()
            {
              GMTrace.i(12830946361344L, 95598);
              WXBizEntryActivity.this.findViewById(R.h.ckf).setVisibility(8);
              GMTrace.o(12830946361344L, 95598);
            }
          };
          str1 = getIntent().getStringExtra("key_package_name");
          str2 = getIntent().getStringExtra("key_package_signature");
          i = getIntent().getIntExtra("translate_link_scene", 1);
          v.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: callPackage=%s, packageSignature=%s", new Object[] { str1, str2 });
          if ((bf.mA(str1)) || (bf.mA(str2)))
          {
            v.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult:packageName or signature null");
            GMTrace.o(12829067313152L, 95584);
            return;
          }
        }
        catch (Exception paramb)
        {
          v.e("MicroMsg.WXBizEntryActivity", "get url from intent failed : %s", new Object[] { paramb.getMessage() });
          GMTrace.o(12829067313152L, 95584);
          return;
        }
        LinkedList localLinkedList = new LinkedList();
        ch localch = new ch();
        v.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", new Object[] { str1 });
        localch.tdU = str1;
        localch.signature = str2;
        localLinkedList.add(localch);
        paramIntent = new ah(paramIntent.toString(), i, localLinkedList);
        paramb = new e.1(this, paramb);
        ap.vd().a(1200, paramb);
        ap.vd().a(paramIntent, 0);
        GMTrace.o(12829067313152L, 95584);
        return;
        try
        {
          paramb = getIntent().getData();
          if ((paramb == null) || (!com.tencent.mm.pluginsdk.d.LD(paramb.toString()))) {
            continue;
          }
          q.yC().fP("key_data_center_session_id");
          com.tencent.mm.pluginsdk.d.a(this, paramb.toString(), getIntent().getIntExtra("translate_link_scene", 1), new com.tencent.mm.pluginsdk.d.a()
          {
            public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk, boolean paramAnonymousBoolean)
            {
              GMTrace.i(16286381768704L, 121343);
              v.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
              if ((paramAnonymousk != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousk instanceof ah)))
              {
                paramAnonymousString = ((ah)paramAnonymousk).JA();
                if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing())) {
                  s.makeText(WXBizEntryActivity.this, WXBizEntryActivity.this.getString(R.l.dIG) + " : " + bf.mz(paramAnonymousString.uet), 0).show();
                }
              }
              WXBizEntryActivity.this.finish();
              GMTrace.o(16286381768704L, 121343);
            }
          }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
          GMTrace.o(12829067313152L, 95584);
          return;
        }
        catch (Exception paramb)
        {
          for (;;)
          {
            v.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[] { paramb.getMessage() });
            paramb = null;
          }
        }
        try
        {
          paramb = getIntent().getData();
          if (paramb != null)
          {
            com.tencent.mm.pluginsdk.d.a(this, paramb.toString(), getIntent().getIntExtra("translate_link_scene", 1), new com.tencent.mm.pluginsdk.d.a()
            {
              public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk, boolean paramAnonymousBoolean)
              {
                GMTrace.i(18436415553536L, 137362);
                v.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogram, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                if ((paramAnonymousk != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousk instanceof ah)))
                {
                  paramAnonymousString = ((ah)paramAnonymousk).JA();
                  if ((paramAnonymousString != null) && (!WXBizEntryActivity.this.isFinishing())) {
                    s.makeText(WXBizEntryActivity.this, WXBizEntryActivity.this.getString(R.l.dIG) + " : " + bf.mz(paramAnonymousString.uet), 0).show();
                  }
                }
                WXBizEntryActivity.this.finish();
                GMTrace.o(18436415553536L, 137362);
              }
            }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
            GMTrace.o(12829067313152L, 95584);
            return;
          }
        }
        catch (Exception paramb)
        {
          for (;;)
          {
            v.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch wxminiprogram failed : %s", new Object[] { paramb.getMessage() });
            paramb = null;
          }
        }
      }
      v.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = " + paramb);
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(12828798877696L, 95582);
    int i = R.i.cVF;
    GMTrace.o(12828798877696L, 95582);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(12828664659968L, 95581);
    super.onCreate(paramBundle);
    zb(0);
    GMTrace.o(12828664659968L, 95581);
  }
  
  protected final boolean u(Intent paramIntent)
  {
    GMTrace.i(12828933095424L, 95583);
    GMTrace.o(12828933095424L, 95583);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/base/stub/WXBizEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */