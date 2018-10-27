package com.google.android.finsky.bb;

import com.google.android.finsky.utils.FinskyLog;
import java.util.ArrayList;
import java.util.List;

public final class r
{
  public static final List a = new ArrayList();
  
  public static void a(q paramq)
  {
    if (paramq == null)
    {
      FinskyLog.e("Trying to register a null SimpleAlertDialog.Listener.", new Object[0]);
      return;
    }
    if (a.contains(paramq))
    {
      FinskyLog.e("Trying to register an already registered SimpleAlertDialog.Listener.", new Object[0]);
      return;
    }
    a.add(paramq);
  }
  
  public static void b(q paramq)
  {
    a.remove(paramq);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bb/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */