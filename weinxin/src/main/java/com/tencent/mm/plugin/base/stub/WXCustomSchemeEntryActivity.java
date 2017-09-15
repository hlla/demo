package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.gd;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.m;
import com.tencent.mm.u.q;
import com.tencent.mm.u.q.b;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author=50, fComment="checked", lastDate="20141016", reviewer=50, vComment={com.jg.EType.ACTIVITYCHECK})
public class WXCustomSchemeEntryActivity
  extends AutoLoginActivity
{
  private List<String> jNP;
  
  public WXCustomSchemeEntryActivity()
  {
    GMTrace.i(12826785611776L, 95567);
    GMTrace.o(12826785611776L, 95567);
  }
  
  protected final void a(AutoLoginActivity.b paramb, Intent paramIntent)
  {
    GMTrace.i(12827322482688L, 95571);
    switch (5.jNz[paramb.ordinal()])
    {
    }
    int i;
    for (;;)
    {
      finish();
      GMTrace.o(12827322482688L, 95571);
      return;
      try
      {
        paramb = getIntent().getData();
        if (paramb != null) {
          if (paramb != null)
          {
            i = 2;
            if (paramIntent != null) {
              i = r.a(paramIntent, "translate_link_scene", 2);
            }
            v.i("MicroMsg.WXCustomSchemeEntryActivity", "translateLinkScene = %d", new Object[] { Integer.valueOf(i) });
            if (!com.tencent.mm.pluginsdk.d.LC(paramb.toString())) {
              break label467;
            }
            if (!com.tencent.mm.pluginsdk.d.i(paramb)) {
              break label229;
            }
            boolean bool = com.tencent.mm.pluginsdk.d.j(paramb);
            v.i("MicroMsg.WXCustomSchemeEntryActivity", "isTicketLink uri:%s, %b", new Object[] { paramb.toString(), Boolean.valueOf(bool) });
            if (bool)
            {
              com.tencent.mm.pluginsdk.d.a(this, paramb.toString(), i, new d.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk, boolean paramAnonymousBoolean)
                {
                  GMTrace.i(12835375546368L, 95631);
                  v.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
                  if ((paramAnonymousk != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousk instanceof ah)))
                  {
                    paramAnonymousString = ((ah)paramAnonymousk).JA();
                    if ((paramAnonymousString != null) && (!WXCustomSchemeEntryActivity.this.isFinishing())) {
                      s.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(R.l.dIG) + " : " + bf.mz(paramAnonymousString.uet), 0).show();
                    }
                  }
                  WXCustomSchemeEntryActivity.this.finish();
                  GMTrace.o(12835375546368L, 95631);
                }
              });
              i = 1;
              if (i == 0) {
                continue;
              }
              GMTrace.o(12827322482688L, 95571);
              return;
            }
          }
        }
      }
      catch (Exception paramb)
      {
        for (;;)
        {
          v.e("MicroMsg.WXCustomSchemeEntryActivity", "post login get url from intent failed : %s", new Object[] { paramb.getMessage() });
          paramb = null;
        }
        com.tencent.mm.pluginsdk.d.a(this, paramb.toString(), i, new d.a()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk, boolean paramAnonymousBoolean)
          {
            GMTrace.i(12828396224512L, 95579);
            WXCustomSchemeEntryActivity.this.finish();
            GMTrace.o(12828396224512L, 95579);
          }
        });
      }
    }
    label229:
    label467:
    label806:
    label836:
    label889:
    for (;;)
    {
      i = 0;
      break;
      String str2;
      if (com.tencent.mm.pluginsdk.d.LD(paramb.toString()))
      {
        if (i == 1)
        {
          localObject1 = q.yC().fO("key_data_center_session_id");
          if (localObject1 == null)
          {
            v.e("MicroMsg.WXCustomSchemeEntryActivity", "null keyvalue for opensdk scene");
            finish();
            continue;
          }
          str1 = ((q.b)localObject1).getString("key_package_name", "");
          localObject1 = ((q.b)localObject1).getString("key_package_signature", "");
          localObject2 = paramIntent.getStringExtra("key_package_name");
          str2 = paramIntent.getStringExtra("key_package_signature");
          v.i("MicroMsg.WXCustomSchemeEntryActivity", "pkg = %s, sig = %s, intentpkg = %s, intentsig = %s", new Object[] { str1, localObject1, localObject2, str2 });
          q.yC().fP("key_data_center_session_id");
          if ((!str1.equals(localObject2)) || (!((String)localObject1).equals(str2)))
          {
            v.e("MicroMsg.WXCustomSchemeEntryActivity", "signature or package check failed");
            finish();
            continue;
          }
        }
        com.tencent.mm.pluginsdk.d.a(this, paramb.toString(), i, new d.a()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk, boolean paramAnonymousBoolean)
          {
            GMTrace.i(12829469966336L, 95587);
            v.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
            if ((paramAnonymousk != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && ((paramAnonymousk instanceof ah)))
            {
              paramAnonymousString = ((ah)paramAnonymousk).JA();
              if ((paramAnonymousString != null) && (!WXCustomSchemeEntryActivity.this.isFinishing())) {
                s.makeText(WXCustomSchemeEntryActivity.this, WXCustomSchemeEntryActivity.this.getString(R.l.dIG) + " : " + bf.mz(paramAnonymousString.uet), 0).show();
              }
            }
            WXCustomSchemeEntryActivity.this.finish();
            GMTrace.o(12829469966336L, 95587);
          }
        }, paramIntent.getStringExtra("key_package_name"), paramIntent.getStringExtra("key_package_signature"));
        i = 1;
        break;
      }
      paramIntent = m.xL();
      v.i("MicroMsg.WXCustomSchemeEntryActivity", "not TicketLink uri:%s", new Object[] { paramb.toString() });
      com.tencent.mm.pluginsdk.d.a(this, paramb.toString(), paramIntent, 23, paramb.toString(), new d.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, k paramAnonymousk, boolean paramAnonymousBoolean)
        {
          GMTrace.i(12841683779584L, 95678);
          WXCustomSchemeEntryActivity.this.finish();
          GMTrace.o(12841683779584L, 95678);
        }
      });
      continue;
      Object localObject2 = paramb.getScheme();
      String str1 = paramb.getHost();
      Object localObject1 = paramb.getQuery();
      v.i("MicroMsg.WXCustomSchemeEntryActivity", "scheme is %s, host is %s, query is %s", new Object[] { localObject2, str1, localObject1 });
      if ((!bf.mA(str1)) && (this.jNP.contains(str1)))
      {
        if ((str1.equals("cardpackage")) && (!bf.mA(paramb.getQueryParameter("encrystr"))))
        {
          paramIntent.setClassName(this, "com.tencent.mm.ui.CheckSmsCanAddCardUI");
          startActivity(paramIntent);
        }
        if (str1.equals("connectToFreeWifi"))
        {
          if ((bf.mA((String)localObject1)) || (!((String)localObject1).startsWith("apKey="))) {
            break label836;
          }
          localObject2 = paramb.getQueryParameter("apKey");
          v.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[] { localObject2 });
          str2 = paramb.getQueryParameter("ticket");
          if ((!bf.mA((String)localObject2)) && (((String)localObject2).length() < 1024))
          {
            paramIntent = new Intent();
            paramIntent.putExtra("free_wifi_schema_uri", paramb.toString());
            paramIntent.putExtra("free_wifi_ap_key", (String)localObject2);
            paramIntent.putExtra("free_wifi_source", 5);
            paramIntent.putExtra("free_wifi_threeone_startup_type", 1);
            if (!bf.mA(str2)) {
              paramIntent.putExtra("free_wifi_schema_ticket", str2);
            }
            if ((!((String)localObject2).startsWith("_")) && (!bf.mA(str2))) {
              break label806;
            }
            paramIntent.addFlags(67108864);
            com.tencent.mm.bb.d.b(this, "freewifi", ".ui.FreeWifiEntryUI", paramIntent);
          }
        }
        for (;;)
        {
          if ((!str1.equals("wap")) || (!paramb.toString().startsWith("weixin://wap/pay"))) {
            break label889;
          }
          v.i("MicroMsg.WXCustomSchemeEntryActivity", "postLogin for WX_WAP_PAY");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          e.a(this, com.tencent.mm.pluginsdk.h.a.LL((String)localObject1), false);
          break;
          localObject2 = new gd();
          ((gd)localObject2).fLk.intent = paramIntent;
          com.tencent.mm.sdk.b.a.uql.m((b)localObject2);
          continue;
          if (paramb.toString().startsWith("weixin://connectToFreeWifi/friendWifi"))
          {
            paramIntent = new Intent();
            paramIntent.putExtra("key_connected_router", paramb.toString());
            com.tencent.mm.bb.d.b(this, "exdevice", ".ui.ExdeviceConnectedRouterActivateStateUI", paramIntent);
            v.i("MicroMsg.WXCustomSchemeEntryActivity", "Jump to ExdeviceConnectedRouterUi.");
          }
        }
      }
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(12827054047232L, 95569);
    int i = R.i.cVF;
    GMTrace.o(12827054047232L, 95569);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(12826919829504L, 95568);
    v.i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
    this.jNP = new ArrayList();
    this.jNP.add("cardpackage");
    this.jNP.add("connectToFreeWifi");
    this.jNP.add("wap");
    super.onCreate(paramBundle);
    zb(0);
    GMTrace.o(12826919829504L, 95568);
  }
  
  protected final boolean u(Intent paramIntent)
  {
    GMTrace.i(12827188264960L, 95570);
    try
    {
      paramIntent = getIntent().getData();
      if (paramIntent != null) {
        if (com.tencent.mm.pluginsdk.d.LC(paramIntent.toString()))
        {
          GMTrace.o(12827188264960L, 95570);
          return true;
        }
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        v.e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", new Object[] { paramIntent.getMessage() });
        paramIntent = null;
      }
      String str3 = paramIntent.getScheme();
      String str1 = paramIntent.getHost();
      String str2 = paramIntent.getQuery();
      v.i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", new Object[] { paramIntent.toString(), str3, str1, str2 });
      if ((!bf.mA(str1)) && (this.jNP.contains(str1)))
      {
        v.i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", new Object[] { str1 });
        if (str1.equals("cardpackage"))
        {
          str3 = paramIntent.getQueryParameter("encrystr");
          v.i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", new Object[] { str3 });
          if ((!bf.mA(str3)) && (str3.length() < 1024))
          {
            GMTrace.o(12827188264960L, 95570);
            return true;
          }
        }
        if (str1.equals("connectToFreeWifi")) {
          if ((!bf.mA(str2)) && (str2.startsWith("apKey=")) && (str2.length() > 6))
          {
            str2 = str2.substring(6);
            v.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", new Object[] { str2 });
            if ((!bf.mA(str2)) && (str2.length() < 1024))
            {
              GMTrace.o(12827188264960L, 95570);
              return true;
            }
          }
          else if (paramIntent.toString().startsWith("weixin://connectToFreeWifi/friendWifi"))
          {
            GMTrace.o(12827188264960L, 95570);
            return true;
          }
        }
        if ((str1.equals("wap")) && (paramIntent.toString().startsWith("weixin://wap/pay")))
        {
          v.i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
          GMTrace.o(12827188264960L, 95570);
          return true;
        }
      }
      finish();
      GMTrace.o(12827188264960L, 95570);
    }
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/base/stub/WXCustomSchemeEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */