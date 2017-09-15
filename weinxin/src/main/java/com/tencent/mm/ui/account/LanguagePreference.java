package com.tencent.mm.ui.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.Preference;

public class LanguagePreference
  extends Preference
{
  public a uWj;
  
  public LanguagePreference(Context paramContext)
  {
    this(paramContext, null);
    GMTrace.i(2735088861184L, 20378);
    GMTrace.o(2735088861184L, 20378);
  }
  
  public LanguagePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(2735223078912L, 20379);
    GMTrace.o(2735223078912L, 20379);
  }
  
  public LanguagePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(2735357296640L, 20380);
    setLayoutResource(R.i.dis);
    GMTrace.o(2735357296640L, 20380);
  }
  
  public final void a(a parama)
  {
    GMTrace.i(2735491514368L, 20381);
    if ((parama == null) || (bf.mA(parama.uWm)))
    {
      v.e("MicroMsg.LanguagePreference", "setInfo info error");
      GMTrace.o(2735491514368L, 20381);
      return;
    }
    this.uWj = parama;
    setKey(parama.uWm);
    GMTrace.o(2735491514368L, 20381);
  }
  
  protected final void onBindView(View paramView)
  {
    int j = 1;
    GMTrace.i(2735759949824L, 20383);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(R.h.cak);
    paramView = (CheckBox)paramView.findViewById(R.h.cGf);
    int i;
    if (localTextView != null)
    {
      i = 1;
      if (paramView == null) {
        break label94;
      }
    }
    for (;;)
    {
      if ((j & i) != 0)
      {
        localTextView.setText(this.uWj.uWk);
        paramView.setChecked(this.uWj.mCG);
      }
      GMTrace.o(2735759949824L, 20383);
      return;
      i = 0;
      break;
      label94:
      j = 0;
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    GMTrace.i(2735625732096L, 20382);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.diC, localViewGroup);
    GMTrace.o(2735625732096L, 20382);
    return paramViewGroup;
  }
  
  public static final class a
  {
    public boolean mCG;
    String uWk;
    private String uWl;
    public String uWm;
    
    public a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      GMTrace.i(2651202781184L, 19753);
      this.uWk = paramString1;
      this.uWl = paramString2;
      this.uWm = paramString3;
      this.mCG = paramBoolean;
      GMTrace.o(2651202781184L, 19753);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/LanguagePreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */