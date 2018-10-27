package com.google.android.finsky.ao;

import com.google.android.finsky.ag.f;
import com.google.android.finsky.ag.q;
import java.util.HashSet;

public final class b
{
  public static final q a;
  public static final q b;
  public static final q c;
  public static final q d;
  public static final q e;
  public static final q f;
  public static final q g;
  public static final q h;
  public static final q i;
  public static final q j;
  public static final q k;
  public static final q l;
  public static final q m;
  public static final q n;
  public static final q o;
  public static final q p;
  public static final q q;
  public static final q r;
  public static final q s;
  public static final f t;
  public static final q u;
  public static final q v;
  public static final q w;
  
  static
  {
    Object localObject = new f("cache_and_sync_preferences");
    t = (f)localObject;
    a = ((f)localObject).a("account-names", new HashSet());
    j = t.a("incompleted-tasks", new HashSet());
    f localf = t;
    localObject = Integer.valueOf(0);
    l = localf.a("last-cache-state", (Integer)localObject);
    b = t.a("current-sync-schedule-state", (Integer)localObject);
    m = t.a("last-dfe-sync-state", (Integer)localObject);
    n = t.a("last-images-sync-state", (Integer)localObject);
    localf = t;
    Long localLong = Long.valueOf(0L);
    v = localf.a("sync-start-timestamp-ms", localLong);
    u = t.a("sync-end-timestamp-ms", localLong);
    p = t.a("last-successful-sync-completed-timestamp", localLong);
    w = t.a("total-fetch-suggestions-enqueued", (Integer)localObject);
    d = t.a("dfe-entries-expected-last-successful-sync", (Integer)localObject);
    c = t.a("dfe-entries-expected-current-sync", (Integer)localObject);
    g = t.a("dfe-fetch-suggestions-processed", (Integer)localObject);
    f = t.a("dfe-entries-synced-last-successful-sync", (Integer)localObject);
    e = t.a("dfe-entries-synced-current-sync", (Integer)localObject);
    i = t.a("images-fetched", (Integer)localObject);
    s = t.a("expiration-timestamp", localLong);
    o = t.a("last-scheduling-timestamp", localLong);
    r = t.a("last-volley-cache-cleared-timestamp", localLong);
    q = t.a("last-volley-cache-cleared-reason", (Integer)localObject);
    k = t.a("jittering-window-end-timestamp", localLong);
    h = t.a("get-bulk-data-fetch-dfe-wait-threshold-millis", localLong);
  }
  
  public static void a(q paramq, int paramInt)
  {
    try
    {
      paramq.a(Integer.valueOf(((Integer)paramq.a()).intValue() + paramInt));
      return;
    }
    finally
    {
      paramq = finally;
      throw paramq;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ao/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */