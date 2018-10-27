package com.google.android.finsky.bu;

import android.view.ViewGroup;
import com.google.android.finsky.activities.eh;
import com.google.android.finsky.dfemodel.g;
import com.google.android.finsky.dfemodel.s;
import com.google.android.finsky.dfemodel.v;
import com.google.android.finsky.e.au;
import com.google.android.finsky.ff.c;
import com.google.android.finsky.recyclerview.PlayRecyclerView;
import com.google.android.finsky.stream.a.f;

public final class b
  extends d
  implements v
{
  public com.google.android.finsky.stream.a.d a;
  public final f b;
  public ViewGroup c;
  public boolean d;
  public final au e;
  public PlayRecyclerView f;
  public eh g;
  public final c h;
  
  public b(f paramf, au paramau, c paramc)
  {
    this.b = paramf;
    this.e = paramau;
    this.h = paramc;
  }
  
  public final void a()
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      localObject = ((s)localObject).b;
      if (localObject != null) {
        ((g)localObject).b(this);
      }
      this.j = null;
    }
  }
  
  public final void a(s params)
  {
    a();
    super.a(params);
    this.d = false;
    if (this.j != null)
    {
      params = params.b;
      if (params != null) {
        params.a(this);
      }
    }
  }
  
  public final void e()
  {
    if (!this.d)
    {
      PlayRecyclerView localPlayRecyclerView = this.f;
      if (localPlayRecyclerView != null)
      {
        localPlayRecyclerView.setEmptyView(this.c.findViewById(2131428626));
        this.d = true;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bu/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */