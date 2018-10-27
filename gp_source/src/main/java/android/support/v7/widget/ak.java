package android.support.v7.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

final class ak
{
  static InputConnection a(InputConnection paramInputConnection, EditorInfo paramEditorInfo, View paramView)
  {
    if ((paramInputConnection != null) && (paramEditorInfo.hintText == null)) {}
    for (paramView = paramView.getParent();; paramView = paramView.getParent()) {
      if ((paramView instanceof View))
      {
        if ((paramView instanceof ie)) {
          paramEditorInfo.hintText = ((ie)paramView).a();
        }
      }
      else {
        return paramInputConnection;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */