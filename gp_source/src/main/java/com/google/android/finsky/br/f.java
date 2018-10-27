package com.google.android.finsky.br;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.caverock.androidsvg.au;
import com.caverock.androidsvg.r;
import com.google.android.finsky.bb.o;
import com.google.android.finsky.bw.l;
import com.google.android.finsky.ds.a.bu;
import com.google.android.finsky.dt.b;
import com.google.android.play.image.FifeImageView;

public final class f
  extends v
{
  public l a;
  
  protected final void R()
  {
    ((t)b.a(t.class)).a(this);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = (FifeImageView)paramLayoutInflater.findViewById(2131428122);
    paramBundle = this.ad.b();
    if (paramBundle != null) {
      this.a.a(paramViewGroup, paramBundle.g, paramBundle.h);
    }
    a(paramLayoutInflater, 2131428216, 5);
    a(paramLayoutInflater, 2131428215, 6);
    ((ImageView)paramLayoutInflater.findViewById(2131428120)).setImageDrawable(r.a(k(), 2131886122, new au()));
    a(paramLayoutInflater, 2131428121, 20);
    return paramLayoutInflater;
  }
  
  protected final int am()
  {
    return 2131624290;
  }
  
  protected final void an()
  {
    k localk = this.ag;
    g localg = new g();
    localg.ag = localk;
    localk.c.d().a(localg, true);
  }
  
  protected final int ao()
  {
    return 5228;
  }
  
  public final void b(int paramInt, Bundle paramBundle)
  {
    ap();
  }
  
  public final boolean z_()
  {
    String str1 = this.ad.a(17);
    String str2 = this.ad.a(22);
    if (TextUtils.isEmpty(str2))
    {
      ap();
      return true;
    }
    new o().c(str1).a(str2).d(2131951993).e(2131952239).a(this, 1, null).a().a(this.q, "FamilyLibraryStep1.confirmDialog");
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */