package android.support.design.g;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

public class k
{
  public CharSequence a;
  public View b;
  public c c;
  public int d = -1;
  public CharSequence e;
  public m f;
  
  public k a(int paramInt)
  {
    return a(LayoutInflater.from(this.f.getContext()).inflate(paramInt, this.f, false));
  }
  
  public k a(View paramView)
  {
    this.b = paramView;
    b();
    return this;
  }
  
  public k a(CharSequence paramCharSequence)
  {
    if ((TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(paramCharSequence))) {
      this.f.setContentDescription(paramCharSequence);
    }
    this.e = paramCharSequence;
    b();
    return this;
  }
  
  public final void a()
  {
    c localc = this.c;
    if (localc == null) {
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    localc.a(this, true);
  }
  
  public k b(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
    b();
    return this;
  }
  
  final void b()
  {
    m localm = this.f;
    if (localm != null) {
      localm.a();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/g/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */