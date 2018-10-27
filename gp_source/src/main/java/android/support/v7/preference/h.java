package android.support.v7.preference;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public final class h
  extends r
{
  private EditText aa;
  private CharSequence ab;
  
  protected final boolean R()
  {
    return true;
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle != null)
    {
      this.ab = paramBundle.getCharSequence("EditTextPreferenceDialogFragment.text");
      return;
    }
    this.ab = ((EditTextPreference)S()).g;
  }
  
  protected final void b(View paramView)
  {
    super.b(paramView);
    this.aa = ((EditText)paramView.findViewById(16908291));
    this.aa.requestFocus();
    paramView = this.aa;
    if (paramView == null) {
      throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }
    paramView.setText(this.ab);
    paramView = this.aa;
    paramView.setSelection(paramView.getText().length());
  }
  
  public final void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.ab);
  }
  
  public final void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = this.aa.getText().toString();
      S();
      ((EditTextPreference)S()).a(str);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */