package com.google.android.finsky.bw;

import android.graphics.Rect;
import android.support.v4.view.a.a;
import android.support.v4.widget.ab;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import java.util.List;

public final class x
  extends ab
{
  private final Rect f = new Rect();
  private final TextView g;
  
  public x(TextView paramTextView)
  {
    super(paramTextView);
    this.g = paramTextView;
  }
  
  private final Rect a(ClickableSpan paramClickableSpan, Rect paramRect)
  {
    Object localObject = this.g.getText();
    paramRect.setEmpty();
    if ((localObject instanceof Spanned))
    {
      localObject = (Spanned)localObject;
      int j = ((Spanned)localObject).getSpanStart(paramClickableSpan);
      int i = ((Spanned)localObject).getSpanEnd(paramClickableSpan);
      paramClickableSpan = this.g.getLayout();
      float f1 = paramClickableSpan.getPrimaryHorizontal(j);
      float f2 = paramClickableSpan.getPrimaryHorizontal(i);
      j = paramClickableSpan.getLineForOffset(j);
      i = paramClickableSpan.getLineForOffset(i);
      paramClickableSpan.getLineBounds(j, paramRect);
      paramRect.left = ((int)f1);
      if (i == j) {
        paramRect.right = ((int)f2);
      }
      paramRect.offset(this.g.getTotalPaddingLeft(), this.g.getTotalPaddingTop());
    }
    return paramRect;
  }
  
  private final CharSequence a(ClickableSpan paramClickableSpan)
  {
    CharSequence localCharSequence = this.g.getText();
    Object localObject = localCharSequence;
    if ((localCharSequence instanceof Spanned))
    {
      localObject = (Spanned)localCharSequence;
      localObject = ((Spanned)localObject).subSequence(((Spanned)localObject).getSpanStart(paramClickableSpan), ((Spanned)localObject).getSpanEnd(paramClickableSpan));
    }
    return (CharSequence)localObject;
  }
  
  private final ClickableSpan d(int paramInt)
  {
    Object localObject = this.g.getText();
    if ((localObject instanceof Spanned))
    {
      localObject = (ClickableSpan[])((Spanned)localObject).getSpans(paramInt, paramInt, ClickableSpan.class);
      if (localObject.length == 1) {}
    }
    else
    {
      return null;
    }
    return localObject[0];
  }
  
  protected final int a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.g.getText();
    if ((localObject instanceof Spanned))
    {
      localObject = (Spanned)localObject;
      int i = this.g.getOffsetForPosition(paramFloat1, paramFloat2);
      ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])((Spanned)localObject).getSpans(i, i, ClickableSpan.class);
      if (arrayOfClickableSpan.length == 1) {
        return ((Spanned)localObject).getSpanStart(arrayOfClickableSpan[0]);
      }
    }
    return Integer.MIN_VALUE;
  }
  
  protected final void a(int paramInt, a parama)
  {
    Object localObject = d(paramInt);
    if (localObject != null) {
      parama.d(a((ClickableSpan)localObject));
    }
    for (;;)
    {
      parama.c(true);
      parama.g(true);
      a((ClickableSpan)localObject, this.f);
      if (!this.f.isEmpty()) {
        parama.b(a((ClickableSpan)localObject, this.f));
      }
      for (;;)
      {
        parama.a(16);
        return;
        localObject = new StringBuilder(41);
        ((StringBuilder)localObject).append("LinkSpan bounds is empty for: ");
        ((StringBuilder)localObject).append(paramInt);
        Log.e("LinkAccessibilityHelper", ((StringBuilder)localObject).toString());
        this.f.set(0, 0, 1, 1);
        parama.b(this.f);
      }
      StringBuilder localStringBuilder = new StringBuilder(40);
      localStringBuilder.append("LinkSpan is null for offset: ");
      localStringBuilder.append(paramInt);
      Log.e("LinkAccessibilityHelper", localStringBuilder.toString());
      parama.d(this.g.getText());
    }
  }
  
  protected final void a(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    Object localObject = d(paramInt);
    if (localObject != null)
    {
      paramAccessibilityEvent.setContentDescription(a((ClickableSpan)localObject));
      return;
    }
    localObject = new StringBuilder(40);
    ((StringBuilder)localObject).append("LinkSpan is null for offset: ");
    ((StringBuilder)localObject).append(paramInt);
    Log.e("LinkAccessibilityHelper", ((StringBuilder)localObject).toString());
    paramAccessibilityEvent.setContentDescription(this.g.getText());
  }
  
  protected final void a(List paramList)
  {
    int i = 0;
    Object localObject = this.g.getText();
    if ((localObject instanceof Spanned))
    {
      localObject = (Spanned)localObject;
      ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), ClickableSpan.class);
      int j = arrayOfClickableSpan.length;
      while (i < j)
      {
        paramList.add(Integer.valueOf(((Spanned)localObject).getSpanStart(arrayOfClickableSpan[i])));
        i += 1;
      }
    }
  }
  
  protected final boolean b(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 16)
    {
      Object localObject = d(paramInt1);
      if (localObject != null)
      {
        ((ClickableSpan)localObject).onClick(this.g);
        return true;
      }
      localObject = new StringBuilder(40);
      ((StringBuilder)localObject).append("LinkSpan is null for offset: ");
      ((StringBuilder)localObject).append(paramInt1);
      Log.e("LinkAccessibilityHelper", ((StringBuilder)localObject).toString());
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */