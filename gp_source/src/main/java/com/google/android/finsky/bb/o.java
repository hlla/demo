package com.google.android.finsky.bb;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.google.android.finsky.e.af;

public class o
{
  public final Bundle a = new Bundle();
  private Fragment b = null;
  
  public i a()
  {
    i locali = new i();
    a(locali);
    return locali;
  }
  
  public final o a(int paramInt)
  {
    this.a.putInt("message_id", paramInt);
    return this;
  }
  
  public final o a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, af paramaf)
  {
    this.a.putInt("impression_type", paramInt1);
    this.a.putByteArray("impression_cookie", paramArrayOfByte);
    this.a.putInt("click_event_type_positive", paramInt2);
    this.a.putInt("click_event_type_negative", paramInt3);
    paramaf.a(this.a);
    return this;
  }
  
  public final o a(Bundle paramBundle)
  {
    this.a.putBundle("config_arguments", paramBundle);
    return this;
  }
  
  public final o a(Fragment paramFragment, int paramInt, Bundle paramBundle)
  {
    this.b = paramFragment;
    if (paramBundle != null) {}
    for (;;)
    {
      this.a.putBundle("extra_arguments", paramBundle);
      this.a.putInt("target_request_code", paramInt);
      do
      {
        return this;
      } while (paramInt == 0);
    }
  }
  
  public final o a(String paramString)
  {
    this.a.putString("message", paramString);
    return this;
  }
  
  public final o a(boolean paramBoolean)
  {
    this.a.putBoolean("cancel_on_touch_outside", paramBoolean);
    return this;
  }
  
  public final void a(i parami)
  {
    parami.f(this.a);
    Fragment localFragment = this.b;
    if (localFragment != null) {
      parami.a(localFragment, 0);
    }
  }
  
  public final o b(int paramInt)
  {
    this.a.putInt("layoutId", paramInt);
    return this;
  }
  
  public final o b(String paramString)
  {
    this.a.putString("messageHtml", paramString);
    return this;
  }
  
  public final o b(boolean paramBoolean)
  {
    this.a.putBoolean("cancel_does_negative_action", paramBoolean);
    return this;
  }
  
  public final o c(int paramInt)
  {
    this.a.putInt("title_id", paramInt);
    return this;
  }
  
  public final o c(String paramString)
  {
    this.a.putString("title", paramString);
    return this;
  }
  
  public final o d(int paramInt)
  {
    if (this.a.containsKey("positive_label")) {
      throw new IllegalStateException("Already set positive button label");
    }
    this.a.putInt("positive_id", paramInt);
    return this;
  }
  
  public final o d(String paramString)
  {
    if (this.a.containsKey("positive_id")) {
      throw new IllegalStateException("Already set positive button label");
    }
    this.a.putString("positive_label", paramString);
    return this;
  }
  
  public final o e(int paramInt)
  {
    if (this.a.containsKey("negative_label")) {
      throw new IllegalStateException("Already set negative button label");
    }
    this.a.putInt("negative_id", paramInt);
    return this;
  }
  
  public final o e(String paramString)
  {
    if (this.a.containsKey("negative_id")) {
      throw new IllegalStateException("Already set negative button label");
    }
    this.a.putString("negative_label", paramString);
    return this;
  }
  
  public final o f(int paramInt)
  {
    this.a.putInt("theme_id", paramInt);
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bb/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */