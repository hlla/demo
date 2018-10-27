package com.google.android.finsky.b.a;

import android.content.Context;
import com.google.android.finsky.ds.a.lg;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.e.f;
import com.google.android.finsky.layout.structuredreviews.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class m
  extends a
  implements h
{
  private final af e;
  private List f;
  private final String g;
  
  public m(Context paramContext, byte[] paramArrayOfByte, CharSequence paramCharSequence, lg paramlg, aq paramaq, af paramaf)
  {
    super(paramContext, paramArrayOfByte, paramCharSequence, paramaq);
    this.g = paramlg.a;
    this.f = new ArrayList();
    this.e = paramaf;
    Collections.addAll(this.f, paramlg.c);
  }
  
  protected final int a()
  {
    return 6003;
  }
  
  public final void a(int paramInt)
  {
    this.e.a(new f(this.d).a(6005));
    a(this.g, paramInt, 0);
  }
  
  public final int i()
  {
    return 2131624949;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */