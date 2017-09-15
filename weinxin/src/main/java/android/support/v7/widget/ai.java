package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.a;
import android.support.v7.a.a.d;
import android.support.v7.a.a.k;
import android.support.v7.app.ActionBar.a;
import android.support.v7.view.a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public final class ai
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  private static final Interpolator abS = new DecelerateInterpolator();
  private int RA;
  Runnable abL;
  private LinearLayoutCompat abM;
  private Spinner abN;
  boolean abO;
  int abP;
  int abQ;
  private int abR;
  
  private void bp(int paramInt)
  {
    this.abR = paramInt;
    int j = this.abM.getChildCount();
    int i = 0;
    if (i < j)
    {
      final View localView = this.abM.getChildAt(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool)
        {
          localView = this.abM.getChildAt(paramInt);
          if (this.abL != null) {
            removeCallbacks(this.abL);
          }
          this.abL = new Runnable()
          {
            public final void run()
            {
              int i = localView.getLeft();
              int j = (ai.this.getWidth() - localView.getWidth()) / 2;
              ai.this.smoothScrollTo(i - j, 0);
              ai.this.abL = null;
            }
          };
          post(this.abL);
        }
        i += 1;
        break;
      }
    }
    if ((this.abN != null) && (paramInt >= 0)) {
      this.abN.setSelection(paramInt);
    }
  }
  
  private boolean gt()
  {
    return (this.abN != null) && (this.abN.getParent() == this);
  }
  
  private boolean gu()
  {
    if (!gt()) {
      return false;
    }
    removeView(this.abN);
    addView(this.abM, new ViewGroup.LayoutParams(-2, -1));
    bp(this.abN.getSelectedItemPosition());
    return false;
  }
  
  public final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.abL != null) {
      post(this.abL);
    }
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    paramConfiguration = a.n(getContext());
    TypedArray localTypedArray = paramConfiguration.mContext.obtainStyledAttributes(null, a.k.aV, a.a.actionBarStyle, 0);
    int j = localTypedArray.getLayoutDimension(a.k.Lg, 0);
    Resources localResources = paramConfiguration.mContext.getResources();
    int i = j;
    if (!paramConfiguration.de()) {
      i = Math.min(j, localResources.getDimensionPixelSize(a.d.IQ));
    }
    localTypedArray.recycle();
    this.RA = i;
    requestLayout();
    this.abQ = paramConfiguration.mContext.getResources().getDimensionPixelSize(a.d.IR);
  }
  
  public final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.abL != null) {
      removeCallbacks(this.abL);
    }
  }
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    int i = View.MeasureSpec.getMode(paramInt1);
    boolean bool;
    if (i == 1073741824)
    {
      bool = true;
      setFillViewport(bool);
      int j = this.abM.getChildCount();
      if ((j <= 1) || ((i != 1073741824) && (i != Integer.MIN_VALUE))) {
        break label328;
      }
      if (j <= 2) {
        break label315;
      }
      this.abP = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label68:
      this.abP = Math.min(this.abP, this.abQ);
      label83:
      i = View.MeasureSpec.makeMeasureSpec(this.RA, 1073741824);
      if ((bool) || (!this.abO)) {
        break label336;
      }
      label105:
      if (paramInt2 == 0) {
        break label349;
      }
      this.abM.measure(0, i);
      if (this.abM.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label341;
      }
      if (!gt())
      {
        if (this.abN == null)
        {
          AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, a.a.actionDropDownStyle);
          localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
          localAppCompatSpinner.setOnItemSelectedListener(this);
          this.abN = localAppCompatSpinner;
        }
        removeView(this.abM);
        addView(this.abN, new ViewGroup.LayoutParams(-2, -1));
        if (this.abN.getAdapter() == null) {
          this.abN.setAdapter(new a((byte)0));
        }
        if (this.abL != null)
        {
          removeCallbacks(this.abL);
          this.abL = null;
        }
        this.abN.setSelection(this.abR);
      }
    }
    for (;;)
    {
      paramInt2 = getMeasuredWidth();
      super.onMeasure(paramInt1, i);
      paramInt1 = getMeasuredWidth();
      if ((bool) && (paramInt2 != paramInt1)) {
        bp(this.abR);
      }
      return;
      bool = false;
      break;
      label315:
      this.abP = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label68;
      label328:
      this.abP = -1;
      break label83;
      label336:
      paramInt2 = 0;
      break label105;
      label341:
      gu();
      continue;
      label349:
      gu();
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  private final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      return ai.c(ai.this).getChildCount();
    }
    
    public final Object getItem(int paramInt)
    {
      return ((ai.b)ai.c(ai.this).getChildAt(paramInt)).abW;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        return ai.a(ai.this, (ActionBar.a)getItem(paramInt));
      }
      paramViewGroup = (ai.b)paramView;
      paramViewGroup.abW = ((ActionBar.a)getItem(paramInt));
      paramViewGroup.update();
      return paramView;
    }
  }
  
  private final class b
    extends LinearLayoutCompat
    implements View.OnLongClickListener
  {
    private final int[] abV = { 16842964 };
    ActionBar.a abW;
    private View kD;
    private TextView kH;
    private ImageView kI;
    
    public b(Context paramContext, ActionBar.a parama, boolean paramBoolean)
    {
      super(null, a.a.actionBarTabStyle);
      this.abW = parama;
      this$1 = ap.a(paramContext, null, this.abV, a.a.actionBarTabStyle);
      if (ai.this.hasValue(0)) {
        setBackgroundDrawable(ai.this.getDrawable(0));
      }
      ai.this.aeG.recycle();
      setGravity(8388627);
      update();
    }
    
    public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.a.class.getName());
    }
    
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      if (Build.VERSION.SDK_INT >= 14) {
        paramAccessibilityNodeInfo.setClassName(ActionBar.a.class.getName());
      }
    }
    
    public final boolean onLongClick(View paramView)
    {
      paramView = new int[2];
      getLocationOnScreen(paramView);
      Object localObject = getContext();
      int i = getWidth();
      int j = getHeight();
      int k = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
      localObject = Toast.makeText((Context)localObject, this.abW.getContentDescription(), 0);
      ((Toast)localObject).setGravity(49, paramView[0] + i / 2 - k / 2, j);
      ((Toast)localObject).show();
      return true;
    }
    
    public final void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if ((ai.this.abP > 0) && (getMeasuredWidth() > ai.this.abP)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(ai.this.abP, 1073741824), paramInt2);
      }
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      if (isSelected() != paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean)) {
          sendAccessibilityEvent(4);
        }
        return;
      }
    }
    
    public final void update()
    {
      Object localObject1 = this.abW;
      Object localObject2 = ((ActionBar.a)localObject1).getCustomView();
      if (localObject2 != null)
      {
        localObject1 = ((View)localObject2).getParent();
        if (localObject1 != this)
        {
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)localObject2);
          }
          addView((View)localObject2);
        }
        this.kD = ((View)localObject2);
        if (this.kH != null) {
          this.kH.setVisibility(8);
        }
        if (this.kI != null)
        {
          this.kI.setVisibility(8);
          this.kI.setImageDrawable(null);
        }
        return;
      }
      if (this.kD != null)
      {
        removeView(this.kD);
        this.kD = null;
      }
      Object localObject3 = ((ActionBar.a)localObject1).getIcon();
      localObject2 = ((ActionBar.a)localObject1).getText();
      int i;
      if (localObject3 != null)
      {
        Object localObject4;
        if (this.kI == null)
        {
          localObject4 = new ImageView(getContext());
          LinearLayoutCompat.LayoutParams localLayoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
          localLayoutParams.gravity = 16;
          ((ImageView)localObject4).setLayoutParams(localLayoutParams);
          addView((View)localObject4, 0);
          this.kI = ((ImageView)localObject4);
        }
        this.kI.setImageDrawable((Drawable)localObject3);
        this.kI.setVisibility(0);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label365;
        }
        i = 1;
        label209:
        if (i == 0) {
          break label370;
        }
        if (this.kH == null)
        {
          localObject3 = new AppCompatTextView(getContext(), null, a.a.actionBarTabTextStyle);
          ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
          localObject4 = new LinearLayoutCompat.LayoutParams(-2, -2);
          ((LinearLayoutCompat.LayoutParams)localObject4).gravity = 16;
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          addView((View)localObject3);
          this.kH = ((TextView)localObject3);
        }
        this.kH.setText((CharSequence)localObject2);
        this.kH.setVisibility(0);
      }
      for (;;)
      {
        if (this.kI != null) {
          this.kI.setContentDescription(((ActionBar.a)localObject1).getContentDescription());
        }
        if ((i != 0) || (TextUtils.isEmpty(((ActionBar.a)localObject1).getContentDescription()))) {
          break label397;
        }
        setOnLongClickListener(this);
        return;
        if (this.kI == null) {
          break;
        }
        this.kI.setVisibility(8);
        this.kI.setImageDrawable(null);
        break;
        label365:
        i = 0;
        break label209;
        label370:
        if (this.kH != null)
        {
          this.kH.setVisibility(8);
          this.kH.setText(null);
        }
      }
      label397:
      setOnLongClickListener(null);
      setLongClickable(false);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */