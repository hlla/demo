package com.google.android.finsky.br;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.finsky.bw.am;
import com.google.android.finsky.ds.a.bu;
import com.google.android.finsky.dt.b;
import com.google.android.play.image.FifeImageView;
import com.google.wireless.android.finsky.dfe.k.a.c;
import com.google.wireless.android.finsky.dfe.k.a.d;

public final class e
  extends v
  implements OnClickListener, com.google.android.play.utils.l
{
  public com.google.android.finsky.bw.l a;
  
  protected final void R()
  {
    ((t)b.a(t.class)).a(this);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramBundle = this.ad.c();
    ((TextView)paramViewGroup.findViewById(2131428110)).setText(paramBundle.e);
    am.a((TextView)paramViewGroup.findViewById(2131428108), paramBundle.d, this);
    ((TextView)paramViewGroup.findViewById(2131427780)).setText(paramBundle.a);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131427523);
    c[] arrayOfc = paramBundle.b;
    int j = arrayOfc.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfc[i];
      View localView = paramLayoutInflater.inflate(2131624275, localViewGroup, false);
      FifeImageView localFifeImageView = (FifeImageView)localView.findViewById(2131428106);
      com.google.android.finsky.bw.l locall = this.a;
      bu localbu = localc.a;
      locall.a(localFifeImageView, localbu.g, localbu.h);
      ((TextView)localView.findViewById(2131428105)).setText(localc.c);
      ((TextView)localView.findViewById(2131428107)).setText(localc.b);
      localViewGroup.addView(localView);
      i += 1;
    }
    ((s)j()).a(paramViewGroup, paramBundle, this);
    return paramViewGroup;
  }
  
  public final void a(View paramView, String paramString)
  {
    ((s)j()).v();
  }
  
  protected final int am()
  {
    return 2131624301;
  }
  
  protected final void an()
  {
    this.ad.d().b();
  }
  
  protected final int ao()
  {
    return 5227;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */