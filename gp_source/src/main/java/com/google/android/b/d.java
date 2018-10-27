package com.google.android.b;

import android.database.ContentObserver;
import java.util.concurrent.atomic.AtomicBoolean;

final class d
  extends ContentObserver
{
  d(f paramf)
  {
    super(null);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    this.a.a.set(true);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */