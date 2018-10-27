package com.google.android.finsky.b.a;

import android.content.Context;
import android.widget.ImageView;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.play.layout.i;

public final class c
  implements i
{
  public ImageView a;
  private f b;
  
  public c(ImageView paramImageView, f paramf)
  {
    this.a = paramImageView;
    this.b = paramf;
  }
  
  public final void a(int paramInt)
  {
    if (this.b != null) {}
    switch (paramInt)
    {
    default: 
      FinskyLog.e("Unknown item selected on ReviewRatedCard overflow menu: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    case 2: 
      this.a.setVisibility(8);
      this.b.d();
      return;
    }
    this.a.setVisibility(8);
    this.b.b();
  }
  
  public final void a(Context paramContext, boolean paramBoolean, aq paramaq, af paramaf, f paramf)
  {
    ImageView localImageView = this.a;
    if (localImageView != null)
    {
      if (paramBoolean)
      {
        this.b = paramf;
        localImageView.setOnClickListener(new d(this, paramContext, paramaf, paramaq));
        this.a.setVisibility(0);
      }
    }
    else {
      return;
    }
    localImageView.setVisibility(8);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */