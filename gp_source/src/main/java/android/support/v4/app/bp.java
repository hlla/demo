package android.support.v4.app;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.IBinder;

final class bp
  extends JobServiceEngine
  implements bl
{
  public final Object a = new Object();
  public JobParameters b;
  private final bj c;
  
  bp(bj parambj)
  {
    super(parambj);
    this.c = parambj;
  }
  
  public final IBinder a()
  {
    return getBinder();
  }
  
  public final bo b()
  {
    bq localbq = null;
    synchronized (this.a)
    {
      Object localObject3 = this.b;
      if (localObject3 != null)
      {
        localObject3 = ((JobParameters)localObject3).dequeueWork();
        if (localObject3 != null)
        {
          ((JobWorkItem)localObject3).getIntent().setExtrasClassLoader(this.c.getClassLoader());
          localbq = new bq(this, (JobWorkItem)localObject3);
        }
        return localbq;
      }
      return null;
    }
  }
  
  public final boolean onStartJob(JobParameters paramJobParameters)
  {
    this.b = paramJobParameters;
    this.c.a(false);
    return true;
  }
  
  public final boolean onStopJob(JobParameters arg1)
  {
    ??? = this.c.a;
    if (??? != null) {
      ???.cancel(false);
    }
    synchronized (this.a)
    {
      this.b = null;
      return true;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */