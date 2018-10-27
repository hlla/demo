package android.support.v4.app;

import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

final class br
  extends bs
{
  private final JobInfo b;
  private final JobScheduler c;
  
  br(Context paramContext, ComponentName paramComponentName, int paramInt)
  {
    super(paramComponentName);
    a(paramInt);
    this.b = new JobInfo.Builder(paramInt, this.a).setOverrideDeadline(0L).build();
    this.c = ((JobScheduler)paramContext.getApplicationContext().getSystemService("jobscheduler"));
  }
  
  final void a(Intent paramIntent)
  {
    this.c.enqueue(this.b, new JobWorkItem(paramIntent));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */