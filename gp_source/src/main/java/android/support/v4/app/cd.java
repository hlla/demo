package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;

public final class cd
{
  public PendingIntent a;
  public int b;
  public boolean c;
  public final co[] d;
  public final Bundle e;
  public final co[] f;
  public final int g;
  public boolean h = true;
  public CharSequence i;
  
  public cd(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle(), null, null, true, 0, true);
  }
  
  cd(int paramInt1, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, co[] paramArrayOfco1, co[] paramArrayOfco2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    this.b = paramInt1;
    this.i = cg.d(paramCharSequence);
    this.a = paramPendingIntent;
    paramCharSequence = paramBundle;
    if (paramBundle == null) {
      paramCharSequence = new Bundle();
    }
    this.e = paramCharSequence;
    this.f = paramArrayOfco1;
    this.d = paramArrayOfco2;
    this.c = paramBoolean1;
    this.g = 0;
    this.h = paramBoolean2;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */