package android.a.b;

import android.app.Fragment;
import android.os.Bundle;

public final class ac
  extends Fragment
{
  private final void a(k paramk)
  {
    Object localObject = getActivity();
    if ((localObject instanceof r)) {
      ((r)localObject).b().a(paramk);
    }
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof n));
      localObject = ((n)localObject).P_();
    } while (!(localObject instanceof o));
    ((o)localObject).a(paramk);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a(k.b);
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    a(k.c);
  }
  
  public final void onPause()
  {
    super.onPause();
    a(k.d);
  }
  
  public final void onResume()
  {
    super.onResume();
    a(k.e);
  }
  
  public final void onStart()
  {
    super.onStart();
    a(k.f);
  }
  
  public final void onStop()
  {
    super.onStop();
    a(k.g);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/b/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */