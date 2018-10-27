package com.google.android.finsky.cl.a;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.SearchRecentSuggestions;
import com.google.android.finsky.cl.d;
import com.google.android.finsky.dfemodel.DfeToc;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.y;
import com.google.android.finsky.instantlaunchapi.InstantLauncherActivity;
import com.google.android.finsky.uninstallmanager.v2.UninstallManagerActivityV2;
import com.google.wireless.android.finsky.dfe.nano.gk;
import com.google.wireless.android.finsky.dfe.nano.gn;

public final class k
  implements d
{
  private final Context a;
  private com.google.android.finsky.cl.a b;
  private final com.google.android.finsky.bo.c c;
  private com.google.android.finsky.da.a d;
  private SearchRecentSuggestions e;
  private com.google.android.finsky.ev.a f;
  
  k(com.google.android.finsky.da.a parama, com.google.android.finsky.ev.a parama1, com.google.android.finsky.cl.a parama2, SearchRecentSuggestions paramSearchRecentSuggestions, com.google.android.finsky.bo.c paramc, Context paramContext)
  {
    this.d = parama;
    this.f = parama1;
    this.b = parama2;
    this.e = paramSearchRecentSuggestions;
    this.c = paramc;
    this.a = paramContext;
  }
  
  private static void a(int paramInt, Activity paramActivity)
  {
    ((NotificationManager)paramActivity.getSystemService("notification")).cancel(paramInt);
  }
  
  private static void a(com.google.android.finsky.navigationmanager.c paramc, Intent paramIntent, boolean paramBoolean)
  {
    paramBoolean = paramIntent.getBooleanExtra("clear_back_stack", paramBoolean);
    boolean bool = paramIntent.getBooleanExtra("from_notification_center", false);
    if ((paramBoolean) && (!bool)) {
      paramc.c();
    }
  }
  
  public final void a(Activity paramActivity, af paramaf1, af paramaf2, com.google.android.finsky.navigationmanager.c paramc, int paramInt1, int paramInt2)
  {
    Intent localIntent = paramActivity.getIntent();
    this.d.a(localIntent);
    String str = localIntent.getAction();
    if (("android.intent.action.SEARCH".equals(str)) || ("com.google.android.gms.actions.SEARCH_ACTION".equals(str)))
    {
      paramActivity = localIntent.getStringExtra("query");
      this.e.saveRecentQuery(paramActivity, String.valueOf(paramInt1));
      paramc.a(paramActivity, paramInt1, paramInt2, null, 0, paramaf1);
    }
    do
    {
      do
      {
        return;
        if (("android.intent.action.VIEW".equals(str)) || ("android.nfc.action.NDEF_DISCOVERED".equals(str)) || ("afwapp.android.intent.action.VIEW".equals(str))) {
          break label733;
        }
        if ("com.google.android.finsky.DETAILS".equals(str))
        {
          a(paramc, localIntent, false);
          paramc.a(localIntent.getDataString(), localIntent.getStringExtra("continue_url"), localIntent.getStringExtra("override_account"), localIntent.getStringExtra("original_url"), paramaf1);
          return;
        }
        if ("com.google.android.finsky.VIEW_MY_DOWNLOADS".equals(str))
        {
          a(paramc, localIntent, true);
          boolean bool = localIntent.getBooleanExtra("trigger_update_all", false);
          paramc.a(this.f.a, null, bool, paramaf1);
          return;
        }
        if ("com.google.android.finsky.CORPUS_HOME".equals(str))
        {
          paramInt1 = localIntent.getIntExtra("backend_id", 0);
          if (paramInt1 == 0)
          {
            paramc.a(this.f.a, paramaf1);
            return;
          }
          paramc.a(this.f.a, paramInt1, paramaf1);
          return;
        }
        if (!"com.google.android.finsky.VIEW_BROWSE".equals(str)) {
          break;
        }
        paramInt1 = localIntent.getIntExtra("backend_id", 0);
        paramActivity = this.f.a;
      } while (paramActivity == null);
      if (paramActivity.a(paramInt1) != null)
      {
        paramActivity = localIntent.getStringExtra("title");
        paramaf2 = localIntent.getDataString();
        if (localIntent.getBooleanExtra("clear_back_stack", false)) {
          paramc.c();
        }
        paramc.a(paramaf2, paramActivity, paramInt1, paramInt2, this.f.a, null, paramaf1);
        return;
      }
      paramc.a(paramActivity, paramaf1);
      return;
      if ("com.google.android.finsky.UNINSTALL_WIZARD_FOR_MY_DOWNLOADS".equals(str))
      {
        a(localIntent.getIntExtra("notification_manager.notification_id", -1), paramActivity);
        a(paramc, localIntent, true);
        paramaf1.a(new com.google.android.finsky.e.f(new y(911, null, null)));
        paramaf2 = localIntent.getStringArrayListExtra("failed_installations_package_names");
        paramc.a(this.f.a, null, false, paramaf1);
        paramActivity.startActivity(UninstallManagerActivityV2.a(paramaf2, paramaf1, false, this.a));
        return;
      }
      if ("com.google.android.finsky.UNINSTALL_WIZARD_FOR_DETAILS".equals(str))
      {
        a(localIntent.getIntExtra("notification_manager.notification_id", -1), paramActivity);
        a(paramc, localIntent, true);
        paramaf1.a(new com.google.android.finsky.e.f(new y(910, null, null)));
        paramc.a(localIntent.getDataString(), localIntent.getStringExtra("continue_url"), localIntent.getStringExtra("override_account"), localIntent.getStringExtra("original_url"), paramaf1);
        paramActivity.startActivity(UninstallManagerActivityV2.a(localIntent.getStringArrayListExtra("failed_installations_package_names"), paramaf1, false, this.a));
        return;
      }
      if ("com.google.android.gms.actions.VIEW_REMOTE_ESCALATIONS".equals(str)) {
        break label724;
      }
      if ("com.google.android.finsky.PLAY_PASS_HOME".equals(str))
      {
        paramActivity = this.f.a;
        if (paramActivity != null)
        {
          paramaf2 = paramActivity.b.r;
          if (paramaf2 != null) {}
        }
        else
        {
          paramc.a(paramActivity, paramaf1);
          return;
        }
        paramc.b(paramActivity, paramaf2.a, paramaf1);
        return;
      }
      if ("com.google.android.finsky.PAYMENT_METHODS".equals(str)) {
        break;
      }
      if ("com.google.android.finsky.PLAY_PROTECT".equals(str))
      {
        paramc.a(com.google.android.gms.e.a.a.a(localIntent.getIntExtra("gpp_home_user_entry_point", 0)), paramaf1);
        return;
      }
    } while (!paramc.B());
    paramc.a(this.f.a, paramaf1);
    return;
    paramc.a(32, paramaf1);
    return;
    label724:
    paramc.a(null);
    return;
    label733:
    if (this.c.cY().a(12647032L)) {
      if (Uri.parse(localIntent.getDataString()).getBooleanQueryParameter("launch", false)) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        paramActivity.startActivity(InstantLauncherActivity.a(paramActivity, localIntent));
        if (!paramc.B()) {
          break label869;
        }
        paramActivity.finishAndRemoveTask();
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          break label876;
        }
        a(paramc, localIntent, true);
        if (localIntent.getBooleanExtra("dont_resolve_again", false))
        {
          if (!this.b.a(paramActivity, localIntent)) {
            break;
          }
          paramActivity.finish();
          return;
        }
        paramc.a(Uri.parse(localIntent.getDataString()), com.google.android.finsky.c.f.a(paramActivity), paramaf2);
        return;
        label869:
        paramActivity.moveTaskToBack(true);
      }
      label876:
      break;
      paramInt1 = 0;
      continue;
      paramInt1 = 0;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cl/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */