package com.google.android.finsky.br;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import com.google.wireless.android.finsky.dfe.k.a.ai;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends v
{
  public com.google.android.finsky.e.i a;
  public int ac = 0;
  private RadioButton ai;
  public com.google.android.finsky.bq.b c;
  
  protected final void R()
  {
    ((t)com.google.android.finsky.dt.b.a(t.class)).a(this);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.ai = ((RadioButton)paramLayoutInflater.findViewById(2131429251));
    a(paramLayoutInflater, 2131428748, 7);
    a(paramLayoutInflater, 2131428747, 8);
    a(paramLayoutInflater, 2131429251, 9);
    a(paramLayoutInflater, 2131427940, 11);
    return paramLayoutInflater;
  }
  
  protected final int am()
  {
    return 2131624291;
  }
  
  protected final void an()
  {
    if (!this.ai.isChecked()) {}
    for (int i = 1;; i = 2)
    {
      this.ac = 0;
      Object localObject = new ArrayList(3);
      int j = 0;
      for (;;)
      {
        if (j >= 3)
        {
          localObject = (ai[])((List)localObject).toArray(new ai[((List)localObject).size()]);
          this.aZ.a((ai[])localObject, new h(this, i), this);
          if (this.ai.isChecked()) {
            this.aZ.a(0, true, new i(this, i), new j(this));
          }
          return;
        }
        int k = new int[] { 3, 4, 1 }[j];
        if (this.c.a(this.ad.a()).a(k)) {
          ((List)localObject).add(new ai().a(k).a(true));
        }
        j += 1;
      }
    }
  }
  
  protected final int ao()
  {
    return 5229;
  }
  
  public final void f()
  {
    super.f();
    this.ai = null;
  }
  
  public final boolean z_()
  {
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */