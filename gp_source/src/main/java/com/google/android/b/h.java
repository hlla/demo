package com.google.android.b;

import android.database.ContentObserver;
import java.util.concurrent.atomic.AtomicBoolean;

final class h
  extends ContentObserver
{
  h()
  {
    super(null);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    g.c.set(true);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */