package com.google.android.finsky.b.a;

import android.content.Context;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.ka;
import com.google.android.finsky.ds.a.ld;
import com.google.android.finsky.ds.a.lg;
import com.google.android.finsky.ds.a.lj;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.layout.structuredreviews.ReviewRatingQuestion;

public final class n
  extends l
{
  private final String e;
  
  public n(Context paramContext, byte[] paramArrayOfByte, CharSequence paramCharSequence, lg paramlg, int paramInt, aq paramaq, Document paramDocument, com.google.android.finsky.al.a parama)
  {
    super(paramContext, paramArrayOfByte, paramCharSequence, false, paramInt, paramaq, paramDocument, parama);
    this.e = paramlg.a;
  }
  
  protected final int a()
  {
    return 6003;
  }
  
  public final void a(int paramInt)
  {
    a(this.e, 4, paramInt);
  }
  
  public final void a(ReviewRatingQuestion paramReviewRatingQuestion, ka paramka)
  {
    CharSequence localCharSequence = this.c;
    int i;
    if (paramka != null)
    {
      Object localObject1 = paramka.p;
      if (localObject1 != null)
      {
        localObject1 = ((lj)localObject1).a;
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (!this.e.equals(((ld)localObject2).a)) {
            i += 1;
          } else {
            i = ((ld)localObject2).b;
          }
        }
      }
    }
    for (;;)
    {
      if (paramka == null) {}
      for (boolean bool = true;; bool = false)
      {
        paramReviewRatingQuestion.a(localCharSequence, i, 3, false, this, this, bool, true, this);
        return;
      }
      i = 0;
      continue;
      i = 0;
      continue;
      i = 0;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */