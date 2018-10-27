package com.google.android.finsky.bw;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public final class t
{
  public static void a(Context paramContext, View paramView)
  {
    if (paramView != null) {
      ((InputMethodManager)paramContext.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
  }
  
  public static void a(Context paramContext, EditText paramEditText)
  {
    a(paramContext, paramEditText, 300);
  }
  
  public static void a(Context paramContext, EditText paramEditText, int paramInt)
  {
    paramEditText.requestFocus();
    paramEditText.postDelayed(new u((InputMethodManager)paramContext.getSystemService("input_method"), paramEditText), paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */