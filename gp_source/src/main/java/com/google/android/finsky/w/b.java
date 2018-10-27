package com.google.android.finsky.w;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.ai;
import android.support.v7.preference.s;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.finsky.e.a;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.e.av;
import com.google.android.finsky.e.u;
import com.google.android.finsky.navigationmanager.c;
import com.google.android.finsky.pagesystem.j;
import com.google.android.finsky.utils.FinskyLog;
import com.google.wireless.android.a.b.a.a.bt;

public abstract class b
  extends s
  implements av, j, e
{
  public af aa;
  public c ab;
  public d ac;
  public a d;
  
  public final af J_()
  {
    return this.aa;
  }
  
  public final int T()
  {
    return by_().getResources().getColor(2131100394);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater.setBackgroundColor(by_().getResources().getColor(2131100189));
    return paramLayoutInflater;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.aa = this.d.a(paramBundle);
    }
    for (;;)
    {
      super.a(paramBundle);
      return;
      if (this.aa == null)
      {
        Bundle localBundle = this.g.getBundle("SettingsFragment.loggingContext");
        this.aa = this.d.a(localBundle);
      }
    }
  }
  
  public final void a(aq paramaq)
  {
    FinskyLog.e("Not using tree impressions.", new Object[0]);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    paramString1 = (PreferenceCategory)this.b.e.c(paramString1);
    if (paramString1 != null)
    {
      paramString2 = paramString1.c(paramString2);
      if (paramString2 != null) {
        paramString1.b(paramString2);
      }
    }
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.ac.a(by_(), this);
  }
  
  public final void e(Bundle paramBundle)
  {
    this.aa.a(paramBundle);
  }
  
  public final void f()
  {
    super.f();
    this.ac.a(by_());
  }
  
  public aq getParentNode()
  {
    return null;
  }
  
  public bt getPlayStoreUiElement()
  {
    return u.a(12);
  }
  
  public final void m() {}
  
  public final void p_() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/w/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */