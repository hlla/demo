package com.google.android.finsky.k;

import android.content.pm.PackageStats;
import android.os.Environment;
import android.os.Handler;
import android.os.Process;
import com.google.android.finsky.e.af;
import com.google.android.finsky.utils.i;
import java.util.Arrays;
import java.util.Map;

final class d
  implements Runnable
{
  private final com.google.android.finsky.em.a a;
  private final af b;
  private final String c;
  
  d(a parama, com.google.android.finsky.em.a parama1, af paramaf, String paramString)
  {
    this.a = parama1;
    this.b = paramaf;
    this.c = paramString;
  }
  
  public final void run()
  {
    Process.setThreadPriority(10);
    Object localObject1 = this.a.a(this.b, Arrays.asList(new String[] { this.c }));
    if (localObject1 != null)
    {
      Object localObject2 = this.d.d;
      String str = ((PackageStats)localObject1).packageName;
      long l3 = i.a();
      long l2 = ((PackageStats)localObject1).codeSize + ((PackageStats)localObject1).dataSize;
      long l1 = l2;
      if (Environment.isExternalStorageEmulated()) {
        l1 = l2 + (((PackageStats)localObject1).externalCodeSize + ((PackageStats)localObject1).externalObbSize + (((PackageStats)localObject1).externalDataSize + ((PackageStats)localObject1).externalMediaSize));
      }
      ((Map)localObject2).put(str, new e(l3, l1));
      localObject2 = this.d;
      str = this.c;
      l1 = ((PackageStats)localObject1).codeSize;
      l1 = ((PackageStats)localObject1).dataSize;
      if (Environment.isExternalStorageEmulated())
      {
        l1 = ((PackageStats)localObject1).externalCodeSize;
        l1 = ((PackageStats)localObject1).externalObbSize;
        l1 = ((PackageStats)localObject1).externalDataSize;
        l1 = ((PackageStats)localObject1).externalMediaSize;
      }
      localObject1 = new c((a)localObject2, str);
      localObject2 = this.d;
      if (((a)localObject2).a) {
        ((a)localObject2).b.post((Runnable)localObject1);
      }
    }
    else
    {
      return;
    }
    ((Runnable)localObject1).run();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/k/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */