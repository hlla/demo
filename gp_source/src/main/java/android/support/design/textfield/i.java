package android.support.design.textfield;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.a;
import android.support.v4.view.b;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;

public final class i
  extends b
{
  private final TextInputLayout b;
  
  public i(TextInputLayout paramTextInputLayout)
  {
    this.b = paramTextInputLayout;
  }
  
  public final void a(View paramView, a parama)
  {
    Object localObject2 = null;
    int j = 0;
    super.a(paramView, parama);
    paramView = this.b.getEditText();
    if (paramView != null) {}
    for (Object localObject1 = paramView.getText();; localObject1 = null)
    {
      CharSequence localCharSequence2 = this.b.getHint();
      CharSequence localCharSequence1 = this.b.getError();
      Object localObject3 = this.b;
      paramView = (View)localObject2;
      if (((TextInputLayout)localObject3).b)
      {
        paramView = (View)localObject2;
        if (((TextInputLayout)localObject3).c)
        {
          localObject3 = ((TextInputLayout)localObject3).d;
          paramView = (View)localObject2;
          if (localObject3 != null) {
            paramView = ((TextView)localObject3).getContentDescription();
          }
        }
      }
      boolean bool1 = TextUtils.isEmpty((CharSequence)localObject1) ^ true;
      boolean bool2 = TextUtils.isEmpty(localCharSequence2) ^ true;
      boolean bool4 = TextUtils.isEmpty(localCharSequence1);
      int i;
      if (!(bool4 ^ true)) {
        if (TextUtils.isEmpty(paramView)) {
          i = 0;
        }
      }
      for (;;)
      {
        if (bool1) {
          parama.c((CharSequence)localObject1);
        }
        for (;;)
        {
          if (bool2)
          {
            if (Build.VERSION.SDK_INT < 26) {
              break label331;
            }
            parama.a.setHintText(localCharSequence2);
          }
          for (;;)
          {
            boolean bool3;
            if (bool1) {
              bool3 = false;
            }
            for (;;)
            {
              if (Build.VERSION.SDK_INT >= 26) {
                parama.a.setShowingHintText(bool3);
              }
              label312:
              for (;;)
              {
                if (i != 0)
                {
                  if (!bool4) {
                    paramView = localCharSequence1;
                  }
                  if (Build.VERSION.SDK_INT >= 21) {
                    parama.a.setError(paramView);
                  }
                  if (Build.VERSION.SDK_INT >= 19) {
                    parama.a.setContentInvalid(true);
                  }
                }
                return;
                if (Build.VERSION.SDK_INT >= 19) {}
                for (localObject1 = parama.a.getExtras();; localObject1 = new Bundle())
                {
                  if (localObject1 == null) {
                    break label312;
                  }
                  int k = ((Bundle)localObject1).getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0);
                  if (!bool3) {}
                  for (;;)
                  {
                    ((Bundle)localObject1).putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", j | k & 0xFFFFFFFB);
                    break;
                    j = 4;
                  }
                }
              }
              if (bool2) {
                bool3 = true;
              } else {
                bool3 = false;
              }
            }
            label331:
            if (Build.VERSION.SDK_INT >= 19) {
              parama.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", localCharSequence2);
            }
          }
          if (bool2) {
            parama.c(localCharSequence2);
          }
        }
        i = 1;
        continue;
        i = 1;
      }
    }
  }
  
  public final void b(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.b(paramView, paramAccessibilityEvent);
    paramView = this.b.getEditText();
    if (paramView != null) {}
    for (paramView = paramView.getText();; paramView = null)
    {
      Object localObject = paramView;
      if (TextUtils.isEmpty(paramView)) {
        localObject = this.b.getHint();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramAccessibilityEvent.getText().add(localObject);
      }
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/textfield/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */