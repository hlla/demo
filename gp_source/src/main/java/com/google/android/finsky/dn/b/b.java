package com.google.android.finsky.dn.b;

import com.google.android.finsky.dn.a;
import java.util.concurrent.TimeUnit;

public final class b
  extends a
{
  protected final void a()
  {
    a("DevTriggeredUpdates", "dev_triggered_updates_package_controller", "-");
    a("DevTriggeredUpdates", "dev_triggered_updates_min_battery", Integer.valueOf(5));
    a("DevTriggeredUpdates", "dev_triggered_updates_importance_threshold", Integer.valueOf(100));
    a("DevTriggeredUpdates", "dev_triggered_updates_rate_limit_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1L)));
    a("DevTriggeredUpdates", "dev_triggered_updates_autocomplete_timeout_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(10L)));
    a("DevTriggeredUpdates", "dev_triggered_updates_gc_timeout_ms", Long.valueOf(TimeUnit.DAYS.toMillis(5L)));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */