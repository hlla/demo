package com.google.android.finsky.br;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.o;
import android.support.v4.content.a.k;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.finsky.bw.l;
import com.google.android.finsky.ds.a.bu;
import com.google.android.finsky.dt.b;
import com.google.android.play.image.FifeImageView;

public final class n
  extends v
{
  public l a;
  private View ac;
  private TextView ai;
  private boolean c = false;
  
  protected final void R()
  {
    ((t)b.a(t.class)).a(this);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = (FifeImageView)paramLayoutInflater.findViewById(2131428126);
    paramBundle = this.ad.f();
    if (paramBundle != null) {
      this.a.a(paramViewGroup, paramBundle.g, paramBundle.h);
    }
    a(paramLayoutInflater, 2131428595, 18);
    a(paramLayoutInflater, 2131428594, 19);
    this.ac = paramLayoutInflater.findViewById(2131429573);
    this.ad.e();
    this.ac.setBackgroundColor(k.b(paramLayoutInflater.getResources(), 2131099809, null));
    this.ai = ((TextView)paramLayoutInflater.findViewById(2131429574));
    this.ai.setText(c(2131953471).toUpperCase(k().getConfiguration().locale));
    this.ac.setOnClickListener(this);
    return paramLayoutInflater;
  }
  
  public final void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1) {
        break label32;
      }
      this.ad.d().e = true;
      this.ad.d().b();
    }
    label32:
    while (paramInt2 != 0) {
      return;
    }
    if (!this.c)
    {
      this.c = true;
      this.ac.setVisibility(0);
      a(this.U, 2131428594, 21);
    }
    this.ah.setVisibility(8);
  }
  
  protected final int am()
  {
    return 2131624299;
  }
  
  protected final void an() {}
  
  protected final int ao()
  {
    return 5230;
  }
  
  public final void onClick(View paramView)
  {
    this.af.setEnabled(false);
    this.ah.setVisibility(0);
    if ((this.c) && (paramView == this.ae))
    {
      this.ai.setEnabled(false);
      this.ad.d().b();
      return;
    }
    startActivityForResult((Intent)j().getIntent().getParcelableExtra("purchase_intent"), 1);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */