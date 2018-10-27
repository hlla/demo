package com.google.android.finsky.br;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.snackbar.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.android.volley.w;
import com.google.android.finsky.api.o;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.e.u;
import com.google.android.finsky.e.z;
import com.google.android.finsky.pagesystem.b;
import com.google.wireless.android.a.b.a.a.bt;

public abstract class v
  extends p
  implements OnClickListener, w, aq
{
  private final bt a = u.a(ao());
  public View ae;
  public TextView af;
  public k ag;
  public View ah;
  
  protected final int V()
  {
    return 2131624289;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.ae = paramViewGroup.findViewById(2131427777);
    this.ae.setOnClickListener(this);
    this.ad.e();
    this.ae.setBackgroundColor(android.support.v4.content.a.k.b(paramViewGroup.getResources(), 2131099809, null));
    this.af = ((TextView)paramViewGroup.findViewById(2131427780));
    this.af.setText(c(2131951994).toUpperCase(k().getConfiguration().locale));
    this.ah = paramViewGroup.findViewById(2131428124);
    this.ah.setVisibility(8);
    paramBundle = (ViewGroup)paramViewGroup.findViewById(2131428663);
    paramBundle.addView(paramLayoutInflater.inflate(am(), paramBundle, false));
    return paramViewGroup;
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle == null) {
      this.bg.a(new z().b(this));
    }
  }
  
  protected final void a(View paramView, int paramInt1, int paramInt2)
  {
    ((TextView)paramView.findViewById(paramInt1)).setText(this.ad.a(paramInt2));
  }
  
  public final void a(VolleyError paramVolleyError)
  {
    paramVolleyError = o.a(this.aW, paramVolleyError);
    this.ae.setEnabled(true);
    this.ah.setVisibility(8);
    ViewGroup localViewGroup = this.aX;
    if (localViewGroup != null) {
      Snackbar.a(localViewGroup, paramVolleyError, 0).d();
    }
  }
  
  protected abstract int am();
  
  protected abstract void an();
  
  protected abstract int ao();
  
  public void f()
  {
    super.f();
    this.af = null;
    this.ah = null;
  }
  
  public bt getPlayStoreUiElement()
  {
    return this.a;
  }
  
  public void onClick(View paramView)
  {
    this.af.setEnabled(false);
    this.ah.setVisibility(0);
    an();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */