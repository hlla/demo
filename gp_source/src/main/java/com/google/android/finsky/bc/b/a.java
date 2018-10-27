package com.google.android.finsky.bc.b;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.e.u;
import com.google.wireless.android.a.b.a.a.bt;

public abstract class a
  extends Fragment
  implements aq
{
  private c a;
  public b ac;
  private final bt b = u.a(S());
  
  public abstract int S();
  
  public b V()
  {
    return this.ac;
  }
  
  public final void a(int paramInt)
  {
    c localc = this.a;
    if (localc == null) {
      throw new IllegalStateException("Parent activity must implement result listener.");
    }
    localc.c(paramInt);
  }
  
  public void a(Context paramContext)
  {
    ae_();
    super.a(paramContext);
  }
  
  public void a(Bundle paramBundle)
  {
    if ((j() instanceof c)) {
      this.a = ((c)j());
    }
    super.a(paramBundle);
  }
  
  public void a(aq paramaq)
  {
    throw new UnsupportedOperationException("Unwanted children.");
  }
  
  public void ae_() {}
  
  public aq getParentNode()
  {
    return null;
  }
  
  public bt getPlayStoreUiElement()
  {
    return this.b;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */