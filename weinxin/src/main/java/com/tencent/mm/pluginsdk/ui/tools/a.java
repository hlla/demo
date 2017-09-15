package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.d.g;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class a
{
  private static Intent sSN;
  private static WeakReference<Activity> sSO;
  private static final HashMap<String, String> sSP;
  
  static
  {
    GMTrace.i(1094411354112L, 8154);
    HashMap localHashMap = new HashMap();
    sSP = localHashMap;
    localHashMap.put("wps", "application/wps");
    sSP.put("ett", "application/ett");
    sSP.put("log", "application/log");
    sSP.put("wpt", "application/wpt");
    sSP.put("et", "application/et");
    sSP.put("ksdps", "application/ksdps");
    sSP.put("kset", "application/kset");
    sSP.put("kswps", "application/kswps");
    GMTrace.o(1094411354112L, 8154);
  }
  
  private static String Nf(String paramString)
  {
    int i = 274528;
    GMTrace.i(1094008700928L, 8151);
    ap.yY();
    t localt = c.vr();
    if (paramString != null) {
      i = 274528 + paramString.hashCode();
    }
    paramString = (String)localt.get(i, "");
    GMTrace.o(1094008700928L, 8151);
    return paramString;
  }
  
  private static String Ng(String paramString)
  {
    GMTrace.i(1094277136384L, 8153);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() > 0) {
        localObject1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      localObject2 = (String)sSP.get(paramString);
    }
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      v.w("MicroMsg.AppChooserIntentUtil", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
      localObject1 = "*/" + paramString;
    }
    GMTrace.o(1094277136384L, 8153);
    return (String)localObject1;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5)
  {
    GMTrace.i(1093471830016L, 8147);
    if (paramInt1 == 2)
    {
      if ((-1 == paramInt2) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("selectpkg");
        Object localObject2 = paramIntent.getBundleExtra("transferback");
        paramIntent = (Intent)((Bundle)localObject2).getParcelable("targetintent");
        Object localObject1 = ((Bundle)localObject2).getString("filepath");
        localObject2 = ((Bundle)localObject2).getString("fileext");
        if (paramIntent != null)
        {
          v.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI select package name %s and target intent is not null", new Object[] { str });
          if (("com.tencent.mtt".equals(str)) && (localObject1 != null))
          {
            localObject1 = ep((String)localObject1, (String)localObject2);
            ((Intent)localObject1).addFlags(524288);
            ((Intent)localObject1).putExtra("ChannelID", "com.tencent.mm");
            ((Intent)localObject1).putExtra("PosID", 4);
            if (bf.j(paramActivity, (Intent)localObject1))
            {
              v.i("MicroMsg.AppChooserIntentUtil", "user has installed new version of QQbrowser");
              paramActivity.startActivity((Intent)localObject1);
              com.tencent.mm.plugin.report.service.g.oSF.i(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt5) });
              GMTrace.o(1093471830016L, 8147);
              return;
            }
          }
          paramIntent = new Intent(paramIntent);
          paramIntent.setPackage(str);
          paramIntent.addFlags(524288);
          if (bf.j(paramActivity, paramIntent))
          {
            paramActivity.startActivity(paramIntent);
            GMTrace.o(1093471830016L, 8147);
            return;
          }
          v.e("MicroMsg.AppChooserIntentUtil", "Always Intent is not support mimetype");
          if (paramBoolean) {
            com.tencent.mm.ui.base.g.h(paramActivity, paramInt3, paramInt4);
          }
          GMTrace.o(1093471830016L, 8147);
          return;
        }
        v.e("MicroMsg.AppChooserIntentUtil", "AppChooserUI target intent is null in handlerResultOfAppChooserUI");
        if (paramBoolean) {
          com.tencent.mm.ui.base.g.h(paramActivity, paramInt3, paramInt4);
        }
        GMTrace.o(1093471830016L, 8147);
        return;
      }
      if (4098 == paramInt2)
      {
        v.e("MicroMsg.AppChooserIntentUtil", "Not Found App Support media type");
        if (paramBoolean)
        {
          com.tencent.mm.ui.base.g.h(paramActivity, paramInt3, paramInt4);
          GMTrace.o(1093471830016L, 8147);
        }
      }
      else if (4097 == paramInt2)
      {
        v.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is no choice");
        if (paramBoolean)
        {
          com.tencent.mm.ui.base.g.h(paramActivity, paramInt3, paramInt4);
          GMTrace.o(1093471830016L, 8147);
        }
      }
      else
      {
        v.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is not ok or data is null");
      }
    }
    GMTrace.o(1093471830016L, 8147);
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    GMTrace.i(1092934959104L, 8143);
    Object localObject1 = new File(paramString1);
    v.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", new Object[] { paramString1, Boolean.valueOf(((File)localObject1).exists()), Long.valueOf(((File)localObject1).length()) });
    if (!((File)localObject1).exists())
    {
      v.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      GMTrace.o(1092934959104L, 8143);
      return true;
    }
    localObject1 = Ng(paramString2);
    Object localObject2 = Nf((String)localObject1);
    if (!((String)localObject2).equals(""))
    {
      v.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject2 });
      Intent localIntent = en((String)localObject1, paramString1);
      localIntent.setPackage((String)localObject2);
      if (bf.j(paramActivity, localIntent))
      {
        v.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType");
        paramActivity.startActivity(localIntent);
        GMTrace.o(1092934959104L, 8143);
        return false;
      }
      v.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
      v.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
    }
    localObject2 = v(paramActivity, (String)localObject1, paramString1);
    v.i("MicroMsg.AppChooserIntentUtil", "QQBrowser status is %s", new Object[] { ((a)localObject2).name() });
    if (localObject2 == a.sSU)
    {
      localObject2 = ep(paramString1, paramString2);
      if (bf.j(paramActivity, (Intent)localObject2))
      {
        ((Intent)localObject2).setFlags(268435456);
        paramActivity.startActivity((Intent)localObject2);
        com.tencent.mm.plugin.report.service.g.oSF.i(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
        GMTrace.o(1092934959104L, 8143);
        return false;
      }
      ((Intent)localObject2).setFlags(268435456);
      localObject1 = eo((String)localObject1, paramString1);
      if (bf.j(paramActivity, (Intent)localObject1))
      {
        paramActivity.startActivity((Intent)localObject1);
        com.tencent.mm.plugin.report.service.g.oSF.i(11168, new Object[] { Integer.valueOf(5), Integer.valueOf(paramInt) });
        v.e("MicroMsg.AppChooserIntentUtil", "Occur error, has bugs, status is install and support but not found support activity");
      }
    }
    else
    {
      if (bf.mA(paramString2)) {
        break label449;
      }
      ap.yY();
      localObject1 = (String)c.vr().get(w.a.uCj, "");
      if ((bf.mA((String)localObject1)) || (!((String)localObject1).contains(paramString2))) {
        break label449;
      }
    }
    label449:
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      b(paramActivity, paramString1, paramString2);
      GMTrace.o(1092934959104L, 8143);
      return false;
      v.e("MicroMsg.AppChooserIntentUtil", "Occur error, has bugs, status is install and support but not found support activity");
      GMTrace.o(1092934959104L, 8143);
      return true;
    }
    GMTrace.o(1092934959104L, 8143);
    return true;
  }
  
  public static void aa(Intent paramIntent)
  {
    GMTrace.i(1093337612288L, 8146);
    boolean bool = paramIntent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
    paramIntent.getStringExtra("file_path");
    String str2 = paramIntent.getStringExtra("file_ext");
    v.i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", new Object[] { Boolean.valueOf(bool) });
    if ((ap.yQ()) || (!ap.zb()))
    {
      GMTrace.o(1093337612288L, 8146);
      return;
    }
    ap.yY();
    String str1 = (String)c.vr().get(w.a.uCj, "");
    if (!bool) {
      paramIntent = str1.replace(str2, "");
    }
    for (;;)
    {
      ap.yY();
      c.vr().a(w.a.uCj, paramIntent);
      if ((!bool) && (sSN != null) && (sSO != null) && (sSO.get() != null))
      {
        sSN.setClass((Context)sSO.get(), AppChooserUI.class);
        ((Activity)sSO.get()).startActivityForResult(sSN, 2);
      }
      sSN = null;
      GMTrace.o(1093337612288L, 8146);
      return;
      paramIntent = str1;
      if (!str1.contains(str2)) {
        paramIntent = str1.concat(str2);
      }
    }
  }
  
  private static void b(Activity paramActivity, String paramString1, String paramString2)
  {
    GMTrace.i(1093203394560L, 8145);
    Intent localIntent = new Intent();
    localIntent.putExtra("file_path", paramString1);
    localIntent.putExtra("file_ext", paramString2);
    localIntent.setComponent(new ComponentName(d.g.uMO, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
    paramActivity.sendBroadcast(localIntent);
    GMTrace.o(1093203394560L, 8145);
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    GMTrace.i(1093069176832L, 8144);
    Object localObject1 = new File(paramString1);
    v.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", new Object[] { paramString1, Boolean.valueOf(((File)localObject1).exists()), Long.valueOf(((File)localObject1).length()) });
    if (!((File)localObject1).exists())
    {
      v.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
      GMTrace.o(1093069176832L, 8144);
      return;
    }
    localObject1 = Ng(paramString2);
    Object localObject2 = Nf((String)localObject1);
    Object localObject3;
    if (!((String)localObject2).equals(""))
    {
      v.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", new Object[] { localObject2 });
      localObject3 = en((String)localObject1, paramString1);
      ((Intent)localObject3).setPackage((String)localObject2);
      if (bf.j(paramActivity, (Intent)localObject3))
      {
        v.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType");
        paramActivity.startActivity((Intent)localObject3);
        GMTrace.o(1093069176832L, 8144);
        return;
      }
      v.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
    }
    localObject2 = v(paramActivity, (String)localObject1, paramString1);
    v.i("MicroMsg.AppChooserIntentUtil", "QQBrowser status is %s", new Object[] { ((a)localObject2).name() });
    boolean bool = false;
    int i = 1;
    Object localObject4;
    switch (1.sSQ[localObject2.ordinal()])
    {
    default: 
      localObject1 = en((String)localObject1, paramString1);
      localObject2 = Ng(paramString2);
      localObject4 = Uri.fromFile(new File(paramString1));
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("targeturl", ((Uri)localObject4).toString());
      ((Bundle)localObject3).putString("filepath", paramString1);
      ((Bundle)localObject3).putString("fileext", paramString2);
      ((Bundle)localObject3).putParcelable("targetintent", (Parcelable)localObject1);
      localObject4 = new Intent();
      ((Intent)localObject4).putExtra("type", 0);
      ((Intent)localObject4).putExtra("title", paramActivity.getResources().getString(R.l.dVS));
      ((Intent)localObject4).putExtra("needupate", bool);
      if (i != 0) {
        break;
      }
    }
    for (bool = true;; bool = false)
    {
      ((Intent)localObject4).putExtra("not_show_recommend_app", bool);
      ((Intent)localObject4).putExtra("mimetype", (String)localObject2);
      ((Intent)localObject4).putExtra("targetintent", (Parcelable)localObject1);
      ((Intent)localObject4).putExtra("transferback", (Bundle)localObject3);
      ((Intent)localObject4).putExtra("scene", paramInt);
      b(paramActivity, paramString1, paramString2);
      sSN = (Intent)localObject4;
      sSO = new WeakReference(paramActivity);
      GMTrace.o(1093069176832L, 8144);
      return;
      localObject1 = en((String)localObject1, paramString1);
      break;
      localObject1 = en((String)localObject1, paramString1);
      i = 0;
      break;
      localObject1 = en((String)localObject1, paramString1);
      bool = true;
      break;
      localObject2 = ep(paramString1, paramString2);
      if (bf.j(paramActivity, (Intent)localObject2))
      {
        paramActivity.startActivity((Intent)localObject2);
        GMTrace.o(1093069176832L, 8144);
        return;
      }
      localObject1 = en((String)localObject1, paramString1);
      break;
    }
  }
  
  private static Intent en(String paramString1, String paramString2)
  {
    GMTrace.i(1093606047744L, 8148);
    paramString2 = Uri.fromFile(new File(paramString2));
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(paramString2, paramString1);
    GMTrace.o(1093606047744L, 8148);
    return localIntent;
  }
  
  private static Intent eo(String paramString1, String paramString2)
  {
    GMTrace.i(1093740265472L, 8149);
    Intent localIntent = new Intent();
    localIntent.setPackage("com.tencent.mtt");
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(new File(paramString2)), paramString1);
    GMTrace.o(1093740265472L, 8149);
    return localIntent;
  }
  
  private static Intent ep(String paramString1, String paramString2)
  {
    GMTrace.i(1093874483200L, 8150);
    Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
    File localFile = new File(paramString1);
    localIntent.setPackage("com.tencent.mtt");
    localIntent.putExtra("ChannelID", "com.tencent.mm");
    localIntent.putExtra("PosID", 4);
    localIntent.putExtra("key_reader_sdk_id", 1);
    localIntent.putExtra("key_reader_sdk_type", 0);
    localIntent.putExtra("key_reader_sdk_format", paramString2);
    localIntent.putExtra("key_reader_sdk_path", paramString1);
    localIntent.setData(Uri.fromFile(localFile));
    GMTrace.o(1093874483200L, 8150);
    return localIntent;
  }
  
  private static a v(Context paramContext, String paramString1, String paramString2)
  {
    GMTrace.i(1094142918656L, 8152);
    if (q.du(paramContext))
    {
      if (bf.j(paramContext, eo(paramString1, paramString2)))
      {
        paramContext = a.sSU;
        GMTrace.o(1094142918656L, 8152);
        return paramContext;
      }
      if (q.LT(paramString1))
      {
        paramContext = a.sSS;
        GMTrace.o(1094142918656L, 8152);
        return paramContext;
      }
      paramContext = a.sST;
      GMTrace.o(1094142918656L, 8152);
      return paramContext;
    }
    paramContext = a.sSR;
    GMTrace.o(1094142918656L, 8152);
    return paramContext;
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(1061393793024L, 7908);
      sSR = new a("NOT_INSTALL", 0);
      sSS = new a("INSTALL_BUT_NEED_UPDATE", 1);
      sST = new a("INSTALL_BUT_NOT_SUPPORT", 2);
      sSU = new a("INSTALL_AND_SUPPORT", 3);
      sSV = new a[] { sSR, sSS, sST, sSU };
      GMTrace.o(1061393793024L, 7908);
    }
    
    private a()
    {
      GMTrace.i(1061259575296L, 7907);
      GMTrace.o(1061259575296L, 7907);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */