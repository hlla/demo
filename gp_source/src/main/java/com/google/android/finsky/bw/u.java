package com.google.android.finsky.bw;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

final class u
  implements Runnable
{
  u(InputMethodManager paramInputMethodManager, EditText paramEditText) {}
  
  public final void run()
  {
    this.b.showSoftInput(this.a, 1);
    this.a.requestFocus();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */