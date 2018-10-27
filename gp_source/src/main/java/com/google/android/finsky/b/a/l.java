package com.google.android.finsky.b.a;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.ka;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.frameworkviews.PlayRatingBar;
import com.google.android.finsky.frameworkviews.at;
import com.google.android.finsky.layout.structuredreviews.ReviewRatingQuestion;
import com.google.android.finsky.layout.structuredreviews.f;
import java.util.List;

public class l
  extends a
  implements at, f
{
  private int e;
  private com.google.android.finsky.al.a f;
  private Document g;
  private boolean h;
  
  public l(Context paramContext, byte[] paramArrayOfByte, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, aq paramaq, Document paramDocument, com.google.android.finsky.al.a parama)
  {
    super(paramContext, paramArrayOfByte, paramCharSequence, paramaq);
    this.h = paramBoolean;
    this.e = paramInt;
    this.f = parama;
    this.g = paramDocument;
  }
  
  protected int a()
  {
    return 6002;
  }
  
  public void a(int paramInt)
  {
    int i = this.b.size() - 1;
    while (i >= 0)
    {
      ((k)this.b.get(i)).a(this, paramInt);
      i -= 1;
    }
    this.h = false;
  }
  
  public final void a(PlayRatingBar paramPlayRatingBar, int paramInt)
  {
    d();
  }
  
  public void a(ReviewRatingQuestion paramReviewRatingQuestion, ka paramka)
  {
    CharSequence localCharSequence = this.c;
    if (paramka != null) {}
    for (int i = paramka.o;; i = 0)
    {
      paramReviewRatingQuestion.a(localCharSequence, i, this.e, this.h, this, this, false, false, this);
      return;
    }
  }
  
  public final CharSequence e()
  {
    return this.a.getResources().getString(2131953382);
  }
  
  public final int i()
  {
    if (this.f.e(this.g)) {
      return 2131624941;
    }
    return 2131624940;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */