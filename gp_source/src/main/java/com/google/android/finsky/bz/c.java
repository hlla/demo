package com.google.android.finsky.bz;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import com.google.android.gms.feedback.FeedbackOptions;
import com.google.android.gms.feedback.b;
import com.google.android.gms.googlehelp.GoogleHelp;

public final class c
{
  public static final Uri a = Uri.parse((String)com.google.android.finsky.ag.d.jk.b());
  public final com.google.android.finsky.accounts.c b;
  
  public c(com.google.android.finsky.accounts.c paramc)
  {
    this(paramc, (byte)0);
  }
  
  private c(com.google.android.finsky.accounts.c paramc, byte paramByte)
  {
    this.b = paramc;
  }
  
  static FeedbackOptions a(Activity paramActivity)
  {
    b localb = new b().a(GoogleHelp.a(paramActivity));
    String str;
    StringBuilder localStringBuilder;
    if (com.google.android.finsky.ba.a.b(paramActivity))
    {
      str = "TV";
      paramActivity = paramActivity.getPackageName();
      localStringBuilder = new StringBuilder(String.valueOf(paramActivity).length() + 18 + String.valueOf(str).length());
      localStringBuilder.append(paramActivity);
      localStringBuilder.append(".");
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      localStringBuilder.append("ConsumerFeedback");
    }
    for (paramActivity = localStringBuilder.toString();; paramActivity = null)
    {
      localb.a = paramActivity;
      return localb.a();
      if (com.google.android.finsky.ba.a.c(paramActivity))
      {
        str = "Wear";
        break;
      }
      if (com.google.android.finsky.ba.a.d(paramActivity))
      {
        str = "Chromebook";
        break;
      }
    }
  }
  
  public final void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    paramActivity = new d(this, paramString, paramActivity);
    if (paramBoolean)
    {
      new Handler().postDelayed(paramActivity, ((Integer)com.google.android.finsky.ag.d.bu.b()).intValue());
      return;
    }
    paramActivity.run();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bz/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */