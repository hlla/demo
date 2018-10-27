package com.google.android.finsky.bw;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.play.utils.UrlSpanUtils;
import com.google.android.play.utils.l;

public final class am
{
  public static String a(String paramString)
  {
    return String.valueOf(paramString).concat(" ");
  }
  
  @TargetApi(24)
  public static void a(Activity paramActivity, EditText paramEditText, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (paramActivity.isInMultiWindowMode())
      {
        paramEditText.setImeOptions(paramInt2);
        paramEditText.setImeActionLabel(paramActivity.getResources().getText(2131952154), paramInt2);
      }
      return;
    }
    paramEditText.setImeOptions(0x10000000 | paramInt1);
  }
  
  public static void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setText(paramCharSequence);
    paramTextView.setVisibility(0);
  }
  
  public static void a(TextView paramTextView, String paramString)
  {
    paramString = Html.fromHtml(paramString);
    paramTextView.setText(paramString);
    if (((URLSpan[])new SpannableStringBuilder(paramString).getSpans(0, paramString.length(), URLSpan.class)).length > 0) {
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  public static void a(TextView paramTextView, String paramString, l paraml)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setText(UrlSpanUtils.b(Html.fromHtml(paramString), null, paraml));
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setVisibility(0);
  }
  
  public static void a(TextView paramTextView, String paramString1, String paramString2)
  {
    paramTextView.setError(paramString2);
    paramString1 = paramTextView.getResources().getString(2131951662, new Object[] { paramString1, paramString2 });
    a.a(paramTextView.getContext(), paramString1, paramTextView, false);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */