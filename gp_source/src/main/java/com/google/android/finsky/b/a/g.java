package com.google.android.finsky.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.layout.structuredreviews.c;
import java.util.List;

public final class g
  extends a
  implements c
{
  private final int e;
  private String f;
  private boolean g;
  private String h;
  
  public g(Context paramContext, byte[] paramArrayOfByte, CharSequence paramCharSequence, int paramInt, aq paramaq)
  {
    super(paramContext, paramArrayOfByte, paramCharSequence, paramaq);
    this.e = paramInt;
  }
  
  protected final int a()
  {
    return 6004;
  }
  
  public final void a(Bundle paramBundle)
  {
    if (this.g) {
      paramBundle.putString("review_comment_question_controller.tmp_text", this.h);
    }
  }
  
  public final void a(String paramString)
  {
    this.g = (TextUtils.equals(paramString, this.f) ^ true);
    if (this.g) {
      d();
    }
    this.h = paramString;
  }
  
  public final void b(String paramString)
  {
    if (this.g)
    {
      int i = this.b.size() - 1;
      while (i >= 0)
      {
        ((k)this.b.get(i)).a(this, paramString);
        i -= 1;
      }
    }
  }
  
  public final CharSequence e()
  {
    if (this.g) {
      return this.a.getResources().getString(2131953382);
    }
    return super.e();
  }
  
  public final int i()
  {
    return 2131624931;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */