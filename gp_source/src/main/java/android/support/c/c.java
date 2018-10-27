package android.support.c;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

final class c
  extends o
{
  private Handler b = new Handler(Looper.getMainLooper());
  
  c(a parama) {}
  
  public final void a(int paramInt, Uri paramUri, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a != null) {
      this.b.post(new h());
    }
  }
  
  public final void a(int paramInt, Bundle paramBundle)
  {
    if (this.a != null) {
      this.b.post(new d(this, paramInt));
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    if (this.a != null) {
      this.b.post(new f());
    }
  }
  
  public final void a(String paramString, Bundle paramBundle)
  {
    if (this.a != null) {
      this.b.post(new e());
    }
  }
  
  public final void b(String paramString, Bundle paramBundle)
  {
    if (this.a != null) {
      this.b.post(new g());
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */