package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.b.a.a;
import android.support.v4.d.f;
import android.support.v4.view.ai;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v4.widget.k;
import android.support.v4.widget.m;
import android.support.v7.a.a.a;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class ListPopupWindow
{
  private static Method XS;
  private static Method XT;
  private ListAdapter FA;
  public int Rr = 0;
  int Vf = -2;
  private int WV;
  public PopupWindow XU;
  public a XV;
  private int XW = -2;
  int XX;
  int XY;
  private int XZ = 1002;
  boolean Ya;
  private boolean Yb = false;
  private boolean Yc = false;
  int Yd = Integer.MAX_VALUE;
  private View Ye;
  int Yf = 0;
  public View Yg;
  private Drawable Yh;
  public AdapterView.OnItemClickListener Yi;
  private AdapterView.OnItemSelectedListener Yj;
  public final g Yk = new g();
  private final f Yl = new f();
  private final e Ym = new e();
  private final c Yn = new c();
  private Runnable Yo;
  private boolean Yp;
  private Rect eq = new Rect();
  private Context mContext;
  public final Handler mHandler;
  private DataSetObserver mObserver;
  
  static
  {
    try
    {
      XS = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
      try
      {
        XT = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException1) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      for (;;) {}
    }
  }
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, a.a.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ck, paramInt1, paramInt2);
    this.XX = localTypedArray.getDimensionPixelOffset(a.k.Mi, 0);
    this.XY = localTypedArray.getDimensionPixelOffset(a.k.Mj, 0);
    if (this.XY != 0) {
      this.Ya = true;
    }
    localTypedArray.recycle();
    this.XU = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1);
    this.XU.setInputMethodMode(1);
    this.WV = f.getLayoutDirectionFromLocale(this.mContext.getResources().getConfiguration().locale);
  }
  
  private int b(View paramView, int paramInt, boolean paramBoolean)
  {
    if (XT != null) {
      try
      {
        int i = ((Integer)XT.invoke(this.XU, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        return i;
      }
      catch (Exception localException) {}
    }
    return this.XU.getMaxAvailableHeight(paramView, paramInt);
  }
  
  public final void clearListSelection()
  {
    a locala = this.XV;
    if (locala != null)
    {
      a.a(locala, true);
      locala.requestLayout();
    }
  }
  
  public final void dismiss()
  {
    this.XU.dismiss();
    if (this.Ye != null)
    {
      ViewParent localViewParent = this.Ye.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.Ye);
      }
    }
    this.XU.setContentView(null);
    this.XV = null;
    this.mHandler.removeCallbacks(this.Yk);
  }
  
  public final void fe()
  {
    this.Yp = true;
    this.XU.setFocusable(true);
  }
  
  public final void ff()
  {
    this.XU.setInputMethodMode(2);
  }
  
  public final boolean isInputMethodNotNeeded()
  {
    return this.XU.getInputMethodMode() == 2;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.mObserver == null) {
      this.mObserver = new d((byte)0);
    }
    for (;;)
    {
      this.FA = paramListAdapter;
      if (this.FA != null) {
        paramListAdapter.registerDataSetObserver(this.mObserver);
      }
      if (this.XV != null) {
        this.XV.setAdapter(this.FA);
      }
      return;
      if (this.FA != null) {
        this.FA.unregisterDataSetObserver(this.mObserver);
      }
    }
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.XU.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.XU.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.eq);
      this.Vf = (this.eq.left + this.eq.right + paramInt);
      return;
    }
    this.Vf = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.XU.setOnDismissListener(paramOnDismissListener);
  }
  
  public void show()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    label246:
    int i;
    int j;
    if (this.XV == null)
    {
      localObject2 = this.mContext;
      this.Yo = new Runnable()
      {
        public final void run()
        {
          View localView = ListPopupWindow.this.Yg;
          if ((localView != null) && (localView.getWindowToken() != null)) {
            ListPopupWindow.this.show();
          }
        }
      };
      if (!this.Yp)
      {
        bool1 = true;
        this.XV = new a((Context)localObject2, bool1);
        if (this.Yh != null) {
          this.XV.setSelector(this.Yh);
        }
        this.XV.setAdapter(this.FA);
        this.XV.setOnItemClickListener(this.Yi);
        this.XV.setFocusable(true);
        this.XV.setFocusableInTouchMode(true);
        this.XV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = ListPopupWindow.this.XV;
              if (paramAnonymousAdapterView != null) {
                ListPopupWindow.a.a(paramAnonymousAdapterView, false);
              }
            }
          }
          
          public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.XV.setOnScrollListener(this.Ym);
        if (this.Yj != null) {
          this.XV.setOnItemSelectedListener(this.Yj);
        }
        localObject1 = this.XV;
        localView = this.Ye;
        if (localView == null) {
          break label1211;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.Yf)
        {
        default: 
          new StringBuilder("Invalid hint position ").append(this.Yf);
          if (this.Vf >= 0)
          {
            i = this.Vf;
            j = Integer.MIN_VALUE;
            label262:
            localView.measure(View.MeasureSpec.makeMeasureSpec(i, j), 0);
            localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
            i = localView.getMeasuredHeight();
            j = ((LinearLayout.LayoutParams)localObject1).topMargin;
            i = ((LinearLayout.LayoutParams)localObject1).bottomMargin + (i + j);
            localObject1 = localObject2;
          }
          break;
        }
      }
    }
    for (;;)
    {
      this.XU.setContentView((View)localObject1);
      for (;;)
      {
        label318:
        localObject1 = this.XU.getBackground();
        int k;
        label381:
        label395:
        int m;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.eq);
          j = this.eq.top + this.eq.bottom;
          k = j;
          if (!this.Ya)
          {
            this.XY = (-this.eq.top);
            k = j;
          }
          if (this.XU.getInputMethodMode() != 2) {
            break label714;
          }
          bool1 = true;
          m = b(this.Yg, this.XY, bool1);
          if ((!this.Yb) && (this.XW != -1)) {
            break label720;
          }
          i = k + m;
          bool1 = isInputMethodNotNeeded();
          m.a(this.XU, this.XZ);
          if (!this.XU.isShowing()) {
            break label972;
          }
          if (this.Vf != -1) {
            break label870;
          }
          j = -1;
          label468:
          if (this.XW != -1) {
            break label946;
          }
          if (!bool1) {
            break label898;
          }
          label481:
          if (!bool1) {
            break label908;
          }
          localObject1 = this.XU;
          if (this.Vf != -1) {
            break label903;
          }
          k = -1;
          label502:
          ((PopupWindow)localObject1).setWidth(k);
          this.XU.setHeight(0);
          label516:
          localObject1 = this.XU;
          if ((this.Yc) || (this.Yb)) {
            break label966;
          }
          bool1 = bool2;
          label540:
          ((PopupWindow)localObject1).setOutsideTouchable(bool1);
          localObject1 = this.XU;
          localObject2 = this.Yg;
          m = this.XX;
          int n = this.XY;
          k = j;
          if (j < 0) {
            k = -1;
          }
          j = i;
          if (i < 0) {
            j = -1;
          }
          ((PopupWindow)localObject1).update((View)localObject2, m, n, k, j);
        }
        for (;;)
        {
          return;
          bool1 = false;
          break;
          ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
          ((LinearLayout)localObject2).addView(localView);
          break label246;
          ((LinearLayout)localObject2).addView(localView);
          ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
          break label246;
          i = 0;
          j = 0;
          break label262;
          this.XU.getContentView();
          localObject1 = this.Ye;
          if (localObject1 != null)
          {
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            i = ((View)localObject1).getMeasuredHeight() + ((LinearLayout.LayoutParams)localObject2).topMargin + ((LinearLayout.LayoutParams)localObject2).bottomMargin;
            break label318;
            this.eq.setEmpty();
            k = 0;
            break label381;
            label714:
            bool1 = false;
            break label395;
            label720:
            switch (this.Vf)
            {
            default: 
              j = View.MeasureSpec.makeMeasureSpec(this.Vf, 1073741824);
            }
            for (;;)
            {
              m = this.XV.L(j, m - i);
              j = i;
              if (m > 0) {
                j = i + k;
              }
              i = m + j;
              break;
              j = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.eq.left + this.eq.right), Integer.MIN_VALUE);
              continue;
              j = View.MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.eq.left + this.eq.right), 1073741824);
            }
            label870:
            if (this.Vf == -2)
            {
              j = this.Yg.getWidth();
              break label468;
            }
            j = this.Vf;
            break label468;
            label898:
            i = -1;
            break label481;
            label903:
            k = 0;
            break label502;
            label908:
            localObject1 = this.XU;
            if (this.Vf == -1) {}
            for (k = -1;; k = 0)
            {
              ((PopupWindow)localObject1).setWidth(k);
              this.XU.setHeight(-1);
              break;
            }
            label946:
            if (this.XW == -2) {
              break label516;
            }
            i = this.XW;
            break label516;
            label966:
            bool1 = false;
            break label540;
            label972:
            if (this.Vf == -1)
            {
              j = -1;
              label982:
              if (this.XW != -1) {
                break label1178;
              }
              i = -1;
              label992:
              this.XU.setWidth(j);
              this.XU.setHeight(i);
              if (XS == null) {}
            }
            try
            {
              XS.invoke(this.XU, new Object[] { Boolean.valueOf(true) });
              localObject1 = this.XU;
              if ((!this.Yc) && (!this.Yb)) {}
              for (bool1 = bool3;; bool1 = false)
              {
                ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                this.XU.setTouchInterceptor(this.Yl);
                m.a(this.XU, this.Yg, this.XX, this.XY, this.Rr);
                this.XV.setSelection(-1);
                if ((!this.Yp) || (this.XV.isInTouchMode())) {
                  clearListSelection();
                }
                if (this.Yp) {
                  break;
                }
                this.mHandler.post(this.Yn);
                return;
                if (this.Vf == -2)
                {
                  j = this.Yg.getWidth();
                  break label982;
                }
                j = this.Vf;
                break label982;
                label1178:
                if (this.XW == -2) {
                  break label992;
                }
                i = this.XW;
                break label992;
              }
            }
            catch (Exception localException)
            {
              for (;;) {}
            }
          }
        }
        i = 0;
      }
      label1211:
      i = 0;
    }
  }
  
  private static final class a
    extends ListViewCompat
  {
    private boolean Yr;
    private boolean Ys;
    private boolean Yt;
    private ai Yu;
    private k Yv;
    
    public a(Context paramContext, boolean paramBoolean)
    {
      super(null, a.a.dropDownListViewStyle);
      this.Ys = paramBoolean;
      setCacheColorHint(0);
    }
    
    protected final boolean fg()
    {
      return (this.Yt) || (super.fg());
    }
    
    public final boolean h(MotionEvent paramMotionEvent, int paramInt)
    {
      int i = o.d(paramMotionEvent);
      label41:
      View localView;
      switch (i)
      {
      default: 
        paramInt = 0;
      case 3: 
        for (bool = true;; bool = false)
        {
          if ((!bool) || (paramInt != 0))
          {
            this.Yt = false;
            setPressed(false);
            drawableStateChanged();
            localView = getChildAt(this.YM - getFirstVisiblePosition());
            if (localView != null) {
              localView.setPressed(false);
            }
            if (this.Yu != null)
            {
              this.Yu.cancel();
              this.Yu = null;
            }
          }
          if (!bool) {
            break;
          }
          if (this.Yv == null) {
            this.Yv = new k(this);
          }
          this.Yv.s(true);
          this.Yv.onTouch(this, paramMotionEvent);
          label152:
          return bool;
          paramInt = 0;
        }
      }
      for (boolean bool = false;; bool = true)
      {
        int j = paramMotionEvent.findPointerIndex(paramInt);
        if (j < 0)
        {
          paramInt = 0;
          bool = false;
          break label41;
        }
        paramInt = (int)paramMotionEvent.getX(j);
        int k = (int)paramMotionEvent.getY(j);
        j = pointToPosition(paramInt, k);
        if (j == -1)
        {
          paramInt = 1;
          break label41;
        }
        localView = getChildAt(j - getFirstVisiblePosition());
        float f1 = paramInt;
        float f2 = k;
        this.Yt = true;
        if (Build.VERSION.SDK_INT >= 21) {
          drawableHotspotChanged(f1, f2);
        }
        if (!isPressed()) {
          setPressed(true);
        }
        layoutChildren();
        if (this.YM != -1)
        {
          localObject = getChildAt(this.YM - getFirstVisiblePosition());
          if ((localObject != null) && (localObject != localView) && (((View)localObject).isPressed())) {
            ((View)localObject).setPressed(false);
          }
        }
        this.YM = j;
        float f3 = localView.getLeft();
        float f4 = localView.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
          localView.drawableHotspotChanged(f1 - f3, f2 - f4);
        }
        if (!localView.isPressed()) {
          localView.setPressed(true);
        }
        Object localObject = getSelector();
        if ((localObject != null) && (j != -1))
        {
          paramInt = 1;
          label406:
          if (paramInt != 0) {
            ((Drawable)localObject).setVisible(false, false);
          }
          super.a(j, localView);
          if (paramInt != 0)
          {
            Rect localRect = this.YH;
            f3 = localRect.exactCenterX();
            f4 = localRect.exactCenterY();
            if (getVisibility() != 0) {
              break label541;
            }
          }
        }
        label541:
        for (bool = true;; bool = false)
        {
          ((Drawable)localObject).setVisible(bool, false);
          a.a((Drawable)localObject, f3, f4);
          localObject = getSelector();
          if ((localObject != null) && (j != -1)) {
            a.a((Drawable)localObject, f1, f2);
          }
          Q(false);
          refreshDrawableState();
          if (i != 1) {
            break;
          }
          performItemClick(localView, j, getItemIdAtPosition(j));
          break;
          paramInt = 0;
          break label406;
        }
        if (this.Yv == null) {
          break label152;
        }
        this.Yv.s(false);
        return bool;
      }
    }
    
    public final boolean hasFocus()
    {
      return (this.Ys) || (super.hasFocus());
    }
    
    public final boolean hasWindowFocus()
    {
      return (this.Ys) || (super.hasWindowFocus());
    }
    
    public final boolean isFocused()
    {
      return (this.Ys) || (super.isFocused());
    }
    
    public final boolean isInTouchMode()
    {
      return ((this.Ys) && (this.Yr)) || (super.isInTouchMode());
    }
  }
  
  public static abstract class b
    implements View.OnTouchListener
  {
    private Runnable YA;
    private Runnable YB;
    boolean YC;
    boolean YD;
    private final int[] YE = new int[2];
    private final float Yw;
    private final int Yx;
    private final int Yy;
    public final View Yz;
    private int fl;
    
    public b(View paramView)
    {
      this.Yz = paramView;
      this.Yw = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      this.Yx = ViewConfiguration.getTapTimeout();
      this.Yy = ((this.Yx + ViewConfiguration.getLongPressTimeout()) / 2);
    }
    
    private boolean l(MotionEvent paramMotionEvent)
    {
      boolean bool1 = true;
      Object localObject1 = this.Yz;
      Object localObject2 = jdMethod_do();
      if ((localObject2 == null) || (!((ListPopupWindow)localObject2).XU.isShowing())) {
        bool1 = false;
      }
      for (;;)
      {
        return bool1;
        localObject2 = ((ListPopupWindow)localObject2).XV;
        if ((localObject2 == null) || (!((ListPopupWindow.a)localObject2).isShown())) {
          return false;
        }
        MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
        int[] arrayOfInt = this.YE;
        ((View)localObject1).getLocationOnScreen(arrayOfInt);
        localMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
        localObject1 = this.YE;
        ((View)localObject2).getLocationOnScreen((int[])localObject1);
        localMotionEvent.offsetLocation(-localObject1[0], -localObject1[1]);
        boolean bool2 = ((ListPopupWindow.a)localObject2).h(localMotionEvent, this.fl);
        localMotionEvent.recycle();
        int i = o.d(paramMotionEvent);
        if ((i != 1) && (i != 3)) {}
        for (i = 1; (!bool2) || (i == 0); i = 0) {
          return false;
        }
      }
    }
    
    public abstract ListPopupWindow jdMethod_do();
    
    public boolean dp()
    {
      ListPopupWindow localListPopupWindow = jdMethod_do();
      if ((localListPopupWindow != null) && (!localListPopupWindow.XU.isShowing())) {
        localListPopupWindow.show();
      }
      return true;
    }
    
    protected boolean ea()
    {
      ListPopupWindow localListPopupWindow = jdMethod_do();
      if ((localListPopupWindow != null) && (localListPopupWindow.XU.isShowing())) {
        localListPopupWindow.dismiss();
      }
      return true;
    }
    
    void fh()
    {
      if (this.YB != null) {
        this.Yz.removeCallbacks(this.YB);
      }
      if (this.YA != null) {
        this.Yz.removeCallbacks(this.YA);
      }
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      boolean bool2 = false;
      boolean bool3 = this.YC;
      if (bool3)
      {
        if (this.YD) {
          bool1 = l(paramMotionEvent);
        }
        for (;;)
        {
          this.YC = bool1;
          if (!bool1)
          {
            bool1 = bool2;
            if (!bool3) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
          if ((l(paramMotionEvent)) || (!ea())) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
      }
      paramView = this.Yz;
      if (paramView.isEnabled()) {}
      label128:
      int i;
      switch (o.d(paramMotionEvent))
      {
      default: 
        i = 0;
        label131:
        if ((i == 0) || (!dp())) {
          break;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        if (bool1)
        {
          long l = SystemClock.uptimeMillis();
          paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          this.Yz.onTouchEvent(paramView);
          paramView.recycle();
        }
        break;
        this.fl = paramMotionEvent.getPointerId(0);
        this.YD = false;
        if (this.YA == null) {
          this.YA = new a();
        }
        paramView.postDelayed(this.YA, this.Yx);
        if (this.YB == null) {
          this.YB = new b();
        }
        paramView.postDelayed(this.YB, this.Yy);
        break label128;
        i = paramMotionEvent.findPointerIndex(this.fl);
        if (i < 0) {
          break label128;
        }
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        float f3 = this.Yw;
        if ((f1 >= -f3) && (f2 >= -f3) && (f1 < paramView.getRight() - paramView.getLeft() + f3) && (f2 < paramView.getBottom() - paramView.getTop() + f3)) {}
        for (i = 1; i == 0; i = 0)
        {
          fh();
          paramView.getParent().requestDisallowInterceptTouchEvent(true);
          i = 1;
          break label131;
        }
        fh();
        break label128;
      }
    }
    
    private final class a
      implements Runnable
    {
      public a() {}
      
      public final void run()
      {
        ListPopupWindow.b.this.Yz.getParent().requestDisallowInterceptTouchEvent(true);
      }
    }
    
    private final class b
      implements Runnable
    {
      public b() {}
      
      public final void run()
      {
        ListPopupWindow.b localb = ListPopupWindow.b.this;
        localb.fh();
        View localView = localb.Yz;
        if ((!localView.isEnabled()) || (localView.isLongClickable())) {}
        while (!localb.dp()) {
          return;
        }
        localView.getParent().requestDisallowInterceptTouchEvent(true);
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        localView.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        localb.YC = true;
        localb.YD = true;
      }
    }
  }
  
  private final class c
    implements Runnable
  {
    public c() {}
    
    public final void run()
    {
      ListPopupWindow.this.clearListSelection();
    }
  }
  
  private final class d
    extends DataSetObserver
  {
    private d() {}
    
    public final void onChanged()
    {
      if (ListPopupWindow.this.XU.isShowing()) {
        ListPopupWindow.this.show();
      }
    }
    
    public final void onInvalidated()
    {
      ListPopupWindow.this.dismiss();
    }
  }
  
  private final class e
    implements AbsListView.OnScrollListener
  {
    public e() {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!ListPopupWindow.this.isInputMethodNotNeeded()) && (ListPopupWindow.this.XU.getContentView() != null))
      {
        ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.Yk);
        ListPopupWindow.this.Yk.run();
      }
    }
  }
  
  private final class f
    implements View.OnTouchListener
  {
    public f() {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (ListPopupWindow.this.XU != null) && (ListPopupWindow.this.XU.isShowing()) && (j >= 0) && (j < ListPopupWindow.this.XU.getWidth()) && (k >= 0) && (k < ListPopupWindow.this.XU.getHeight())) {
        ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.Yk, 250L);
      }
      for (;;)
      {
        return false;
        if (i == 1) {
          ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.Yk);
        }
      }
    }
  }
  
  private final class g
    implements Runnable
  {
    public g() {}
    
    public final void run()
    {
      if ((ListPopupWindow.this.XV != null) && (z.al(ListPopupWindow.this.XV)) && (ListPopupWindow.this.XV.getCount() > ListPopupWindow.this.XV.getChildCount()) && (ListPopupWindow.this.XV.getChildCount() <= ListPopupWindow.this.Yd))
      {
        ListPopupWindow.this.XU.setInputMethodMode(2);
        ListPopupWindow.this.show();
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/ListPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */