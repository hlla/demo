package com.google.android.finsky.br;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.finsky.dt.b;
import com.google.wireless.android.a.b.a.a.bt;

public final class r
  extends p
  implements OnClickListener
{
  public String a;
  
  protected final void R()
  {
    ((t)b.a(t.class)).a(this);
  }
  
  protected final int V()
  {
    return 2131624288;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    ((TextView)paramLayoutInflater.findViewById(2131428049)).setText(this.a);
    paramLayoutInflater.findViewById(2131427777).setOnClickListener(this);
    ((TextView)paramLayoutInflater.findViewById(2131427780)).setText(17039370);
    return paramLayoutInflater;
  }
  
  public final bt getPlayStoreUiElement()
  {
    return null;
  }
  
  public final void onClick(View paramView)
  {
    this.ad.d().a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */