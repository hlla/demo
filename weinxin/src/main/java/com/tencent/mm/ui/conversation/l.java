package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class l
{
  public static h wcq;
  
  static
  {
    GMTrace.i(3428726079488L, 25546);
    wcq = null;
    GMTrace.o(3428726079488L, 25546);
  }
  
  public static void bYF()
  {
    GMTrace.i(3428189208576L, 25542);
    if (wcq != null)
    {
      wcq.dismiss();
      wcq = null;
    }
    GMTrace.o(3428189208576L, 25542);
  }
  
  public static void eZ(final Context paramContext)
  {
    GMTrace.i(3427786555392L, 25539);
    if (!bf.bJU())
    {
      GMTrace.o(3427786555392L, 25539);
      return;
    }
    Object localObject = com.tencent.mm.i.g.sV().getValue("NewShowRating");
    if (bf.mA((String)localObject))
    {
      GMTrace.o(3427786555392L, 25539);
      return;
    }
    Map localMap = bg.q((String)localObject, "ShowRatingNode");
    int m;
    label114:
    int n;
    if ((localMap == null) || (localMap.get(".ShowRatingNode.MinVer") == null))
    {
      localObject = "0";
      m = Integer.decode((String)localObject).intValue();
      if ((localMap != null) && (localMap.get(".ShowRatingNode.MaxVer") != null)) {
        break label197;
      }
      localObject = "0";
      n = Integer.decode((String)localObject).intValue();
      if ((localMap != null) && (localMap.get(".ShowRatingNode.WaitDays") != null)) {
        break label214;
      }
    }
    int k;
    label197:
    label214:
    for (localObject = "0";; localObject = (String)localMap.get(".ShowRatingNode.WaitDays"))
    {
      k = Integer.decode((String)localObject).intValue();
      if ((m <= com.tencent.mm.protocal.d.sXh) && (com.tencent.mm.protocal.d.sXh <= n)) {
        break label231;
      }
      GMTrace.o(3427786555392L, 25539);
      return;
      localObject = (String)localMap.get(".ShowRatingNode.MinVer");
      break;
      localObject = (String)localMap.get(".ShowRatingNode.MaxVer");
      break label114;
    }
    label231:
    localObject = paramContext.getSharedPreferences("show_rating_preferences", 0);
    int j = ((SharedPreferences)localObject).getInt("show_rating_flag", 0);
    int i1 = ((SharedPreferences)localObject).getInt("show_rating_version", 0);
    long l1 = ((SharedPreferences)localObject).getLong("show_rating_timestamp", 0L);
    boolean bool = ((SharedPreferences)localObject).getBoolean("show_rating_again", false);
    long l2;
    if (k == 0)
    {
      i = 7;
      l2 = i * 86400000L;
      if ((i1 == 0) || (m > i1) || (i1 > n)) {
        break label634;
      }
    }
    label634:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        ((SharedPreferences)localObject).edit().putInt("show_rating_version", com.tencent.mm.protocal.d.sXh).commit();
        ((SharedPreferences)localObject).edit().putInt("show_rating_flag", 0).commit();
        j = 0;
        l1 = System.currentTimeMillis();
        ((SharedPreferences)localObject).edit().putLong("show_rating_timestamp", l1).commit();
        ((SharedPreferences)localObject).edit().putBoolean("show_rating_again", false).commit();
        ((SharedPreferences)localObject).edit().putInt("show_rating_wait_days", k).commit();
        ((SharedPreferences)localObject).edit().putInt("show_rating_first_second_time", (int)(System.currentTimeMillis() / 1000L)).commit();
        v.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]current clientVersion=%s,has rating clientVersion=%s,dynamic config showRatting min version=%s,max version:%s,waitDaysMillis:%s", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.sXh), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n), Long.valueOf(l2) });
      }
      if ((m > com.tencent.mm.protocal.d.sXh) || (com.tencent.mm.protocal.d.sXh > n) || (j != 0) || (l1 == 0L) || (System.currentTimeMillis() < l1 + l2)) {
        break label639;
      }
      v.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show enjoy app dialog.");
      wcq = com.tencent.mm.ui.base.g.a(paramContext, false, paramContext.getString(R.l.eWq), "", paramContext.getString(R.l.eWj), paramContext.getString(R.l.eWi), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3427115466752L, 25534);
          this.wcr.edit().putInt("show_rating_flag", 1).commit();
          if (paramAnonymousDialogInterface != null) {
            paramAnonymousDialogInterface.dismiss();
          }
          l.wcq = null;
          l.l(paramContext, true);
          v.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog from enjoy app dialog.");
          GMTrace.o(3427115466752L, 25534);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3376515383296L, 25157);
          this.wcr.edit().putInt("show_rating_flag", 2).commit();
          if (paramAnonymousDialogInterface != null) {
            paramAnonymousDialogInterface.dismiss();
          }
          l.wcq = null;
          l.fa(paramContext);
          v.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show feedback dialog.");
          GMTrace.o(3376515383296L, 25157);
        }
      });
      GMTrace.o(3427786555392L, 25539);
      return;
      i = k;
      break;
    }
    label639:
    if ((bool) && (l1 != 0L) && (System.currentTimeMillis() >= l1 + l2 + 345600000L))
    {
      v.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog again.");
      l(paramContext, false);
      ((SharedPreferences)localObject).edit().putInt("show_rating_flag", 3).commit();
      GMTrace.o(3427786555392L, 25539);
      return;
    }
    if (j == 1)
    {
      l(paramContext, true);
      GMTrace.o(3427786555392L, 25539);
      return;
    }
    if (j == 2)
    {
      fa(paramContext);
      GMTrace.o(3427786555392L, 25539);
      return;
    }
    if (j == 3) {
      l(paramContext, false);
    }
    GMTrace.o(3427786555392L, 25539);
  }
  
  public static void fa(final Context paramContext)
  {
    GMTrace.i(3428054990848L, 25541);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("show_rating_preferences", 0);
    final int i = localSharedPreferences.getInt("show_rating_wait_days", 0);
    final int j = localSharedPreferences.getInt("show_rating_first_second_time", 0);
    wcq = com.tencent.mm.ui.base.g.a(paramContext, false, paramContext.getString(R.l.eWt), "", paramContext.getString(R.l.eWs), paramContext.getString(R.l.eWr), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(3405237977088L, 25371);
        this.wcr.edit().putInt("show_rating_flag", 4).commit();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        com.tencent.mm.pluginsdk.d.c(paramContext, (int)System.currentTimeMillis(), "weixin://dl/feedback");
        l.wcq = null;
        com.tencent.mm.plugin.report.service.g.oSF.i(11216, new Object[] { Integer.valueOf(2), Integer.valueOf(j), Integer.valueOf(i) });
        GMTrace.o(3405237977088L, 25371);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(3420001927168L, 25481);
        this.wcr.edit().putInt("show_rating_flag", 4).commit();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.dismiss();
        }
        l.wcq = null;
        com.tencent.mm.plugin.report.service.g.oSF.i(11216, new Object[] { Integer.valueOf(1), Integer.valueOf(j), Integer.valueOf(i) });
        GMTrace.o(3420001927168L, 25481);
      }
    });
    GMTrace.o(3428054990848L, 25541);
  }
  
  public static void l(final Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(3427920773120L, 25540);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("show_rating_preferences", 0);
    final boolean bool = localSharedPreferences.getBoolean("show_rating_again", false);
    final int i = localSharedPreferences.getInt("show_rating_wait_days", 0);
    final int j = localSharedPreferences.getInt("show_rating_first_second_time", 0);
    String str1;
    String str2;
    Object localObject2;
    if (paramBoolean)
    {
      str1 = paramContext.getString(R.l.eWp);
      localObject1 = paramContext.getString(R.l.eWo);
      str2 = paramContext.getString(R.l.eWn);
      localObject2 = localObject1;
    }
    for (Object localObject1 = str2;; localObject1 = paramContext.getString(R.l.eWk))
    {
      wcq = com.tencent.mm.ui.base.g.a(paramContext, false, str1, "", (String)localObject2, (String)localObject1, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3437181796352L, 25609);
          this.wcr.edit().putInt("show_rating_flag", 4).commit();
          String str = "market://details?id=" + aa.getPackageName();
          Intent localIntent = new Intent("android.intent.action.VIEW");
          localIntent.setData(Uri.parse(str));
          paramContext.startActivity(localIntent);
          v.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]start market intent");
          if (paramAnonymousDialogInterface != null) {
            paramAnonymousDialogInterface.dismiss();
          }
          this.wcr.edit().putBoolean("show_rating_again", false).commit();
          l.wcq = null;
          if (bool)
          {
            com.tencent.mm.plugin.report.service.g.oSF.i(11216, new Object[] { Integer.valueOf(5), Integer.valueOf(j), Integer.valueOf(i) });
            GMTrace.o(3437181796352L, 25609);
            return;
          }
          com.tencent.mm.plugin.report.service.g.oSF.i(11216, new Object[] { Integer.valueOf(4), Integer.valueOf(j), Integer.valueOf(i) });
          GMTrace.o(3437181796352L, 25609);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3436913360896L, 25607);
          this.wcr.edit().putInt("show_rating_flag", 4).commit();
          if (bool)
          {
            this.wcr.edit().putBoolean("show_rating_again", false).commit();
            com.tencent.mm.plugin.report.service.g.oSF.i(11216, new Object[] { Integer.valueOf(3), Integer.valueOf(j), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (paramAnonymousDialogInterface != null) {
              paramAnonymousDialogInterface.dismiss();
            }
            l.wcq = null;
            GMTrace.o(3436913360896L, 25607);
            return;
            v.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]need to show rating dialog again.");
            this.wcr.edit().putBoolean("show_rating_again", true).commit();
            com.tencent.mm.plugin.report.service.g.oSF.i(11216, new Object[] { Integer.valueOf(6), Integer.valueOf(j), Integer.valueOf(i) });
          }
        }
      });
      GMTrace.o(3427920773120L, 25540);
      return;
      str1 = paramContext.getString(R.l.eWm);
      localObject2 = paramContext.getString(R.l.eWl);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */