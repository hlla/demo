package com.google.android.finsky.ad;

import com.google.android.finsky.ag.c;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.utils.i;
import com.google.android.settings.deletionservice.DeletionInfoResponse;
import com.google.android.settings.deletionservice.DeletionStatus;
import com.google.android.settings.deletionservice.d;

final class j
  extends d
{
  j(a parama) {}
  
  public final void a(DeletionInfoResponse paramDeletionInfoResponse)
  {
    int i = 0;
    if (paramDeletionInfoResponse != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        c.aj.a(Long.valueOf(paramDeletionInfoResponse.b));
        c.ai.a(Integer.valueOf(paramDeletionInfoResponse.a));
        c.u.a(Long.valueOf(i.a()));
      }
      if (paramDeletionInfoResponse != null) {}
      for (;;)
      {
        this.a.a(bool, l.b, i);
        return;
        i = 3304;
      }
    }
  }
  
  public final void a(DeletionStatus paramDeletionStatus)
  {
    int i = 0;
    boolean bool;
    if (paramDeletionStatus != null) {
      if (paramDeletionStatus.a == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      if (bool)
      {
        c.aj.a(Long.valueOf(0L));
        c.ai.a(Integer.valueOf(0));
        c.u.a(Long.valueOf(i.a()));
      }
      if (!bool) {
        i = 3304;
      }
      this.a.a(bool, l.a, i);
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ad/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */