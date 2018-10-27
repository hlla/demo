package android.support.v7.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DropDownPreference
  extends ListPreference
{
  private final ArrayAdapter C;
  private final Context D;
  private final AdapterView.OnItemSelectedListener E = new f(this);
  private Spinner F;
  
  public DropDownPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  private DropDownPreference(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    this(paramContext, paramAttributeSet, 2130968869);
  }
  
  private DropDownPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, 2130968869, 0);
    this.D = paramContext;
    this.C = new ArrayAdapter(this.D, 17367049);
    q();
  }
  
  private final void q()
  {
    this.C.clear();
    CharSequence[] arrayOfCharSequence = this.g;
    if (arrayOfCharSequence != null)
    {
      int j = arrayOfCharSequence.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = arrayOfCharSequence[i];
        this.C.add(localCharSequence.toString());
        i += 1;
      }
    }
  }
  
  public final void a(ao paramao)
  {
    this.F = ((Spinner)paramao.c.findViewById(2131429297));
    this.F.setAdapter(this.C);
    this.F.setOnItemSelectedListener(this.E);
    Spinner localSpinner = this.F;
    String str = this.i;
    CharSequence[] arrayOfCharSequence = this.h;
    int i;
    if (str == null) {
      i = -1;
    }
    for (;;)
    {
      localSpinner.setSelection(i);
      super.a(paramao);
      return;
      if (arrayOfCharSequence != null)
      {
        int j = arrayOfCharSequence.length - 1;
        for (;;)
        {
          if (j < 0) {
            break label111;
          }
          i = j;
          if (arrayOfCharSequence[j].equals(str)) {
            break;
          }
          j -= 1;
        }
        label111:
        i = -1;
      }
      else
      {
        i = -1;
      }
    }
  }
  
  public final void a(CharSequence[] paramArrayOfCharSequence)
  {
    super.a(paramArrayOfCharSequence);
    q();
  }
  
  protected final void b_()
  {
    super.b_();
    this.C.notifyDataSetChanged();
  }
  
  protected final void e()
  {
    this.F.performClick();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/DropDownPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */