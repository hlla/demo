package android.support.v7.preference;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SeekBarPreference
  extends Preference
{
  private TextView C;
  private boolean D;
  public boolean a;
  public int b;
  public SeekBar c;
  public int d;
  public boolean e;
  private int f;
  private SeekBar.OnSeekBarChangeListener g = new aq(this);
  private int h;
  private View.OnKeyListener i = new ar(this);
  
  public SeekBarPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  private SeekBarPreference(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    this(paramContext, paramAttributeSet, 2130969474);
  }
  
  private SeekBarPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, 2130969474, 0);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ap.az, 2130969474, 0);
    this.b = paramContext.getInt(ap.aC, 0);
    paramInt = paramContext.getInt(ap.aB, 100);
    int j = this.b;
    if (paramInt < j) {
      paramInt = j;
    }
    for (;;)
    {
      if (paramInt != this.f)
      {
        this.f = paramInt;
        b_();
      }
      paramInt = paramContext.getInt(ap.aD, 0);
      if (paramInt != this.h)
      {
        this.h = Math.min(this.f - this.b, Math.abs(paramInt));
        b_();
      }
      this.a = paramContext.getBoolean(ap.aA, true);
      this.D = paramContext.getBoolean(ap.aE, true);
      paramContext.recycle();
      return;
    }
  }
  
  private final void a(int paramInt, boolean paramBoolean)
  {
    int k = this.b;
    int j = paramInt;
    if (paramInt < k) {
      j = k;
    }
    k = this.f;
    paramInt = j;
    if (j > k) {
      paramInt = k;
    }
    if (paramInt != this.d)
    {
      this.d = paramInt;
      Object localObject = this.C;
      if (localObject != null) {
        ((TextView)localObject).setText(String.valueOf(this.d));
      }
      if ((k()) && (paramInt != b(paramInt ^ 0xFFFFFFFF)))
      {
        localObject = this.y.c();
        ((SharedPreferences.Editor)localObject).putInt(this.r, paramInt);
        super.a((SharedPreferences.Editor)localObject);
      }
      if (paramBoolean) {
        b_();
      }
    }
  }
  
  protected final Object a(TypedArray paramTypedArray, int paramInt)
  {
    return Integer.valueOf(paramTypedArray.getInt(paramInt, 0));
  }
  
  protected final void a(Parcelable paramParcelable)
  {
    if (!paramParcelable.getClass().equals(SeekBarPreference.SavedState.class))
    {
      super.a(paramParcelable);
      return;
    }
    paramParcelable = (SeekBarPreference.SavedState)paramParcelable;
    super.a(paramParcelable.getSuperState());
    this.d = paramParcelable.c;
    this.b = paramParcelable.b;
    this.f = paramParcelable.a;
    b_();
  }
  
  public final void a(ao paramao)
  {
    super.a(paramao);
    paramao.c.setOnKeyListener(this.i);
    this.c = ((SeekBar)paramao.a(2131429214));
    this.C = ((TextView)paramao.a(2131429215));
    if (this.D) {
      this.C.setVisibility(0);
    }
    for (;;)
    {
      paramao = this.c;
      if (paramao == null)
      {
        Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
        return;
      }
      paramao.setOnSeekBarChangeListener(this.g);
      this.c.setMax(this.f - this.b);
      int j = this.h;
      if (j != 0) {
        this.c.setKeyProgressIncrement(j);
      }
      for (;;)
      {
        this.c.setProgress(this.d - this.b);
        paramao = this.C;
        if (paramao != null) {
          paramao.setText(String.valueOf(this.d));
        }
        this.c.setEnabled(i());
        return;
        this.h = this.c.getKeyProgressIncrement();
      }
      this.C.setVisibility(8);
      this.C = null;
    }
  }
  
  final void a(SeekBar paramSeekBar)
  {
    int j = this.b + paramSeekBar.getProgress();
    if (j != this.d) {
      a(j, false);
    }
  }
  
  protected final void a(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = Integer.valueOf(0);
    }
    for (;;)
    {
      a(b(((Integer)paramObject).intValue()), true);
      return;
    }
  }
  
  protected final Parcelable d()
  {
    Object localObject = super.d();
    if (!this.x)
    {
      localObject = new SeekBarPreference.SavedState((Parcelable)localObject);
      ((SeekBarPreference.SavedState)localObject).c = this.d;
      ((SeekBarPreference.SavedState)localObject).b = this.b;
      ((SeekBarPreference.SavedState)localObject).a = this.f;
      return (Parcelable)localObject;
    }
    return (Parcelable)localObject;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/SeekBarPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */