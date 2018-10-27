package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public final class ce
{
  private boolean a = true;
  private final Bundle b;
  private final int c;
  private final PendingIntent d;
  private boolean e = true;
  private final CharSequence f;
  
  public ce(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle());
  }
  
  private ce(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
  {
    this.c = paramInt;
    this.f = cg.d(paramCharSequence);
    this.d = paramPendingIntent;
    this.b = paramBundle;
    this.a = true;
    this.e = true;
  }
  
  public final cd a()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    if (!((List)localObject1).isEmpty()) {}
    for (localObject1 = (co[])((List)localObject1).toArray(new co[((List)localObject1).size()]);; localObject1 = null)
    {
      if (!((List)localObject2).isEmpty()) {}
      for (localObject2 = (co[])((List)localObject2).toArray(new co[((List)localObject2).size()]);; localObject2 = null) {
        return new cd(this.c, this.f, this.d, this.b, (co[])localObject2, (co[])localObject1, this.a, 0, this.e);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */