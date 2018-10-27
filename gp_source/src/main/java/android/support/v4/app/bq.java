package android.support.v4.app;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.content.Intent;

final class bq
  implements bo
{
  private final JobWorkItem a;
  
  bq(bp parambp, JobWorkItem paramJobWorkItem)
  {
    this.a = paramJobWorkItem;
  }
  
  public final Intent a()
  {
    return this.a.getIntent();
  }
  
  public final void b()
  {
    synchronized (this.b.a)
    {
      JobParameters localJobParameters = this.b.b;
      if (localJobParameters != null) {
        localJobParameters.completeWork(this.a);
      }
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */