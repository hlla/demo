package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

final class k
  extends s
{
  k(Fragment paramFragment) {}
  
  public final Fragment a(Context paramContext, String paramString, Bundle paramBundle)
  {
    return this.a.v.a(paramContext, paramString, paramBundle);
  }
  
  public final View a(int paramInt)
  {
    View localView = this.a.U;
    if (localView == null) {
      throw new IllegalStateException("Fragment does not have a view");
    }
    return localView.findViewById(paramInt);
  }
  
  public final boolean a()
  {
    return this.a.U != null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */