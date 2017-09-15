package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;

public class IconPreference
  extends Preference
{
  private Context context;
  private String desc;
  public Drawable drawable;
  private int height;
  private TextView mUe;
  public ImageView nut;
  private String phj;
  private int phk;
  private int phl;
  private int voN;
  private int voO;
  private int voP;
  private ImageView voQ;
  private ViewGroup voR;
  private TextView voS;
  private int voU;
  private String voV;
  private int voW;
  private int voX;
  private int voY;
  private Bitmap voZ;
  public int vpa;
  private int vpb;
  private int vpc;
  private View vpd;
  private View vpe;
  public RelativeLayout.LayoutParams vpf;
  private TextView vpg;
  private TextView vph;
  private ImageView vpi;
  private boolean vpj;
  public boolean vpk;
  private int vpl;
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(3206461521920L, 23890);
    GMTrace.o(3206461521920L, 23890);
  }
  
  public IconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(3206595739648L, 23891);
    this.phj = "";
    this.phk = -1;
    this.phl = 8;
    this.voN = 8;
    this.voU = 8;
    this.desc = "";
    this.voV = "";
    this.voW = -1;
    this.voX = 8;
    this.voY = -1;
    this.voZ = null;
    this.vpa = -1;
    this.vpb = 8;
    this.voO = 0;
    this.voP = 8;
    this.vpc = 8;
    this.nut = null;
    this.voQ = null;
    this.voR = null;
    this.vpd = null;
    this.vpe = null;
    this.height = -1;
    this.vpj = false;
    this.vpk = false;
    this.vpl = -1;
    this.context = paramContext;
    setLayoutResource(a.h.dis);
    GMTrace.o(3206595739648L, 23891);
  }
  
  public final void An(int paramInt)
  {
    GMTrace.i(3207266828288L, 23896);
    this.phl = paramInt;
    if (this.vph != null) {
      this.vph.setVisibility(paramInt);
    }
    GMTrace.o(3207266828288L, 23896);
  }
  
  public final void Ao(int paramInt)
  {
    GMTrace.i(3207401046016L, 23897);
    this.voX = paramInt;
    if (this.vpg != null) {
      this.vpg.setVisibility(paramInt);
    }
    GMTrace.o(3207401046016L, 23897);
  }
  
  public final void Ap(int paramInt)
  {
    GMTrace.i(3207669481472L, 23899);
    this.voN = paramInt;
    if (this.voQ != null) {
      this.voQ.setVisibility(paramInt);
    }
    GMTrace.o(3207669481472L, 23899);
  }
  
  public final void Aq(int paramInt)
  {
    GMTrace.i(3207937916928L, 23901);
    this.vpa = paramInt;
    this.voZ = null;
    if (this.nut != null) {
      this.nut.setImageResource(paramInt);
    }
    GMTrace.o(3207937916928L, 23901);
  }
  
  public final void Ar(int paramInt)
  {
    GMTrace.i(3208072134656L, 23902);
    this.vpb = paramInt;
    if (this.nut != null) {
      this.nut.setVisibility(this.vpb);
    }
    GMTrace.o(3208072134656L, 23902);
  }
  
  public final void As(int paramInt)
  {
    GMTrace.i(3208206352384L, 23903);
    this.voO = paramInt;
    if (this.voR != null) {
      this.voR.setVisibility(this.voO);
    }
    GMTrace.o(3208206352384L, 23903);
  }
  
  public final void At(int paramInt)
  {
    GMTrace.i(3208340570112L, 23904);
    this.voP = paramInt;
    if (this.vpd != null) {
      this.vpd.setVisibility(this.voP);
    }
    GMTrace.o(3208340570112L, 23904);
  }
  
  public final void Au(int paramInt)
  {
    GMTrace.i(16266920198144L, 121198);
    this.vpc = paramInt;
    if (this.vpe != null) {
      this.vpe.setVisibility(paramInt);
    }
    GMTrace.o(16266920198144L, 121198);
  }
  
  public final void P(Bitmap paramBitmap)
  {
    GMTrace.i(3207803699200L, 23900);
    this.voZ = paramBitmap;
    this.vpa = -1;
    if (this.nut != null) {
      this.nut.setImageBitmap(paramBitmap);
    }
    GMTrace.o(3207803699200L, 23900);
  }
  
  public final void R(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(3207132610560L, 23895);
    this.voV = paramString;
    this.voW = paramInt1;
    this.voY = paramInt2;
    if (this.vpg != null)
    {
      this.vpg.setText(paramString);
      if (paramInt1 != -1) {
        this.vpg.setBackgroundDrawable(a.a(this.context, paramInt1));
      }
      if (paramInt2 != -1) {
        this.vpg.setTextColor(paramInt2);
      }
    }
    GMTrace.o(3207132610560L, 23895);
  }
  
  public final void cM(String paramString, int paramInt)
  {
    GMTrace.i(3206864175104L, 23893);
    this.phj = paramString;
    this.phk = paramInt;
    GMTrace.o(3206864175104L, 23893);
  }
  
  public final void cN(String paramString, int paramInt)
  {
    GMTrace.i(3206998392832L, 23894);
    R(paramString, paramInt, this.voY);
    GMTrace.o(3206998392832L, 23894);
  }
  
  public final void eb(int paramInt1, int paramInt2)
  {
    GMTrace.i(16266785980416L, 121197);
    this.voN = paramInt1;
    this.vpl = paramInt2;
    GMTrace.o(16266785980416L, 121197);
  }
  
  public final void kV(boolean paramBoolean)
  {
    GMTrace.i(3207535263744L, 23898);
    this.vpj = paramBoolean;
    if (this.vpg != null)
    {
      if (paramBoolean)
      {
        this.vpg.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.hbN, 0);
        this.vpg.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.e.aXQ));
        GMTrace.o(3207535263744L, 23898);
        return;
      }
      this.vpg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    GMTrace.o(3207535263744L, 23898);
  }
  
  public void onBindView(View paramView)
  {
    GMTrace.i(3208474787840L, 23905);
    super.onBindView(paramView);
    this.vpi = ((ImageView)paramView.findViewById(a.g.bWO));
    Object localObject;
    if (this.vpi != null)
    {
      if (this.drawable != null)
      {
        this.vpi.setImageDrawable(this.drawable);
        this.vpi.setVisibility(0);
      }
    }
    else
    {
      localObject = (LinearLayout)paramView.findViewById(a.g.ckc);
      ((LinearLayout)localObject).setMinimumHeight((int)(paramView.getResources().getDimensionPixelSize(a.e.aXP) * a.dL(this.context)));
      if (this.height != -1) {
        ((LinearLayout)localObject).setMinimumHeight(this.height);
      }
      this.vph = ((TextView)paramView.findViewById(a.g.cHC));
      if (this.vph != null)
      {
        if (!this.vpk) {
          break label652;
        }
        this.vph.setCompoundDrawablesWithIntrinsicBounds(a.f.hbN, 0, 0, 0);
        this.vph.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.e.aXQ));
        label174:
        this.vph.setVisibility(this.phl);
        this.vph.setText(this.phj);
        if (this.phk != -1) {
          this.vph.setBackgroundDrawable(a.a(this.context, this.phk));
        }
      }
      this.vpg = ((TextView)paramView.findViewById(a.g.hde));
      if (this.vpg != null)
      {
        this.vpg.setVisibility(this.voX);
        this.vpg.setText(this.voV);
        if (this.voW != -1) {
          this.vpg.setBackgroundDrawable(a.a(this.context, this.voW));
        }
        if (this.voY != -1) {
          this.vpg.setTextColor(this.voY);
        }
        if (!this.vpj) {
          break label666;
        }
        this.vpg.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.hbN, 0);
        this.vpg.setCompoundDrawablePadding((int)this.context.getResources().getDimension(a.e.aXQ));
      }
      label351:
      this.voQ = ((ImageView)paramView.findViewById(a.g.hdc));
      this.voQ.setVisibility(this.voN);
      if (this.vpl != -1) {
        this.voQ.setImageResource(this.vpl);
      }
      this.nut = ((ImageView)paramView.findViewById(a.g.hcj));
      this.voR = ((ViewGroup)paramView.findViewById(a.g.hcN));
      this.vpe = paramView.findViewById(a.g.hcM);
      this.vpe.setVisibility(this.vpc);
      this.vpd = paramView.findViewById(a.g.cyM);
      this.vpd.setVisibility(this.voP);
      if (this.voZ == null) {
        break label680;
      }
      this.nut.setImageBitmap(this.voZ);
    }
    for (;;)
    {
      this.nut.setVisibility(this.vpb);
      this.voR.setVisibility(this.voO);
      if (this.vpf != null) {
        this.nut.setLayoutParams(this.vpf);
      }
      this.voS = ((TextView)paramView.findViewById(16908310));
      this.mUe = ((TextView)paramView.findViewById(a.g.bHS));
      if (this.mUe != null)
      {
        this.mUe.setVisibility(this.voU);
        this.mUe.setText(this.desc);
      }
      GMTrace.o(3208474787840L, 23905);
      return;
      if (this.PG != 0)
      {
        localObject = this.vpi;
        Drawable localDrawable = this.mContext.getResources().getDrawable(this.PG);
        this.drawable = localDrawable;
        ((ImageView)localObject).setImageDrawable(localDrawable);
        this.vpi.setVisibility(0);
        break;
      }
      this.vpi.setVisibility(8);
      break;
      label652:
      this.vph.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label174;
      label666:
      this.vpg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label351;
      label680:
      if (this.vpa != -1) {
        this.nut.setImageResource(this.vpa);
      }
    }
  }
  
  public View onCreateView(ViewGroup paramViewGroup)
  {
    GMTrace.i(3206729957376L, 23892);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.h.hee, localViewGroup);
    GMTrace.o(3206729957376L, 23892);
    return paramViewGroup;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/preference/IconPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */