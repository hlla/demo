package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView
  extends LinearLayout
  implements m.a
{
  private LayoutInflater Du;
  private TextView Fy;
  private RadioButton Qa;
  private CheckBox Qb;
  private TextView Qc;
  private Drawable Qd;
  private Context Qe;
  boolean Qf;
  private int Qg;
  boolean Qh;
  private h dR;
  private int ea;
  private ImageView kI;
  private Context mContext;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.cn, paramInt, 0);
    this.Qd = paramAttributeSet.getDrawable(a.k.MH);
    this.ea = paramAttributeSet.getResourceId(a.k.MI, -1);
    this.Qf = paramAttributeSet.getBoolean(a.k.MJ, false);
    this.Qe = paramContext;
    paramAttributeSet.recycle();
  }
  
  private LayoutInflater dq()
  {
    if (this.Du == null) {
      this.Du = LayoutInflater.from(this.mContext);
    }
    return this.Du;
  }
  
  public final boolean A()
  {
    return false;
  }
  
  public final void a(h paramh)
  {
    this.dR = paramh;
    this.Qg = 0;
    int i;
    Object localObject1;
    label63:
    Object localObject2;
    label144:
    label168:
    label205:
    label233:
    char c;
    if (paramh.isVisible())
    {
      i = 0;
      setVisibility(i);
      localObject1 = paramh.a(this);
      if (localObject1 == null) {
        break label440;
      }
      this.Fy.setText((CharSequence)localObject1);
      if (this.Fy.getVisibility() != 0) {
        this.Fy.setVisibility(0);
      }
      boolean bool = paramh.isCheckable();
      if ((bool) || (this.Qa != null) || (this.Qb != null))
      {
        if (!this.dR.dG()) {
          break label464;
        }
        if (this.Qa == null)
        {
          this.Qa = ((RadioButton)dq().inflate(a.h.KK, this, false));
          addView(this.Qa);
        }
        localObject1 = this.Qa;
        localObject2 = this.Qb;
        if (!bool) {
          break label519;
        }
        ((CompoundButton)localObject1).setChecked(this.dR.isChecked());
        if (!bool) {
          break label513;
        }
        i = 0;
        if (((CompoundButton)localObject1).getVisibility() != i) {
          ((CompoundButton)localObject1).setVisibility(i);
        }
        if ((localObject2 != null) && (((CompoundButton)localObject2).getVisibility() != 8)) {
          ((CompoundButton)localObject2).setVisibility(8);
        }
      }
      bool = paramh.dF();
      paramh.dE();
      if ((!bool) || (!this.dR.dF())) {
        break label554;
      }
      i = 0;
      if (i == 0)
      {
        localObject2 = this.Qc;
        c = this.dR.dE();
        if (c != 0) {
          break label560;
        }
        localObject1 = "";
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      if (this.Qc.getVisibility() != i) {
        this.Qc.setVisibility(i);
      }
      localObject1 = paramh.getIcon();
      if ((!this.dR.dW.QE) && (!this.Qh)) {
        break label661;
      }
      i = 1;
      label313:
      if (((i != 0) || (this.Qf)) && ((this.kI != null) || (localObject1 != null) || (this.Qf)))
      {
        if (this.kI == null)
        {
          this.kI = ((ImageView)dq().inflate(a.h.KI, this, false));
          addView(this.kI, 0);
        }
        if ((localObject1 == null) && (!this.Qf)) {
          break label672;
        }
        localObject2 = this.kI;
        if (i == 0) {
          break label666;
        }
        label400:
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
        if (this.kI.getVisibility() != 0) {
          this.kI.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      setEnabled(paramh.isEnabled());
      return;
      i = 8;
      break;
      label440:
      if (this.Fy.getVisibility() == 8) {
        break label63;
      }
      this.Fy.setVisibility(8);
      break label63;
      label464:
      if (this.Qb == null)
      {
        this.Qb = ((CheckBox)dq().inflate(a.h.KH, this, false));
        addView(this.Qb);
      }
      localObject1 = this.Qb;
      localObject2 = this.Qa;
      break label144;
      label513:
      i = 8;
      break label168;
      label519:
      if (this.Qb != null) {
        this.Qb.setVisibility(8);
      }
      if (this.Qa == null) {
        break label205;
      }
      this.Qa.setVisibility(8);
      break label205;
      label554:
      i = 8;
      break label233;
      label560:
      localObject1 = new StringBuilder(h.QV);
      switch (c)
      {
      default: 
        ((StringBuilder)localObject1).append(c);
      }
      for (;;)
      {
        localObject1 = ((StringBuilder)localObject1).toString();
        break;
        ((StringBuilder)localObject1).append(h.QW);
        continue;
        ((StringBuilder)localObject1).append(h.QX);
        continue;
        ((StringBuilder)localObject1).append(h.QY);
      }
      label661:
      i = 0;
      break label313;
      label666:
      localObject1 = null;
      break label400;
      label672:
      this.kI.setVisibility(8);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setBackgroundDrawable(this.Qd);
    this.Fy = ((TextView)findViewById(a.f.title));
    if (this.ea != -1) {
      this.Fy.setTextAppearance(this.Qe, this.ea);
    }
    this.Qc = ((TextView)findViewById(a.f.Kr));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.kI != null) && (this.Qf))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.kI.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final h z()
  {
    return this.dR;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/menu/ListMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */