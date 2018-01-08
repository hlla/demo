package com.android.common;

import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

public class Rfc822InputFilter
  implements InputFilter
{
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if ((paramInt2 - paramInt1 != 1) || (paramCharSequence.charAt(paramInt1) != ' ')) {}
    do
    {
      return null;
      paramInt2 = paramInt3;
      paramInt1 = 0;
      while (paramInt2 > 0)
      {
        paramInt2 -= 1;
        switch (paramSpanned.charAt(paramInt2))
        {
        case ',': 
        default: 
          break;
        case '.': 
          paramInt1 = 1;
        }
      }
    } while (paramInt1 == 0);
    if ((paramCharSequence instanceof Spanned))
    {
      paramSpanned = new SpannableStringBuilder(",");
      paramSpanned.append(paramCharSequence);
      return paramSpanned;
    }
    return ", ";
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/common/Rfc822InputFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */