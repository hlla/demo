package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.z;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.b;
import android.support.v7.a.a.k;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public final class a
{
  public ListAdapter FA;
  public int FB = -1;
  int FC;
  int FD;
  public int FE;
  public int FF;
  public int FG;
  public int FH;
  int FI = 0;
  final View.OnClickListener FJ = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView == a.this.Fn) && (a.this.Fp != null)) {
        paramAnonymousView = Message.obtain(a.this.Fp);
      }
      for (;;)
      {
        if (paramAnonymousView != null) {
          paramAnonymousView.sendToTarget();
        }
        a.this.mHandler.obtainMessage(1, a.this.Fd).sendToTarget();
        return;
        if ((paramAnonymousView == a.this.Fq) && (a.this.Fs != null)) {
          paramAnonymousView = Message.obtain(a.this.Fs);
        } else if ((paramAnonymousView == a.this.Ft) && (a.this.Fv != null)) {
          paramAnonymousView = Message.obtain(a.this.Fv);
        } else {
          paramAnonymousView = null;
        }
      }
    }
  };
  public final i Fd;
  final Window Fe;
  public CharSequence Ff;
  public ListView Fg;
  public int Fh;
  public int Fi;
  public int Fj;
  public int Fk;
  public int Fl;
  public boolean Fm = false;
  public Button Fn;
  CharSequence Fo;
  public Message Fp;
  public Button Fq;
  CharSequence Fr;
  public Message Fs;
  public Button Ft;
  CharSequence Fu;
  public Message Fv;
  public NestedScrollView Fw;
  public int Fx = 0;
  TextView Fy;
  public View Fz;
  public Drawable jQ;
  public TextView jq;
  public ImageView kI;
  public final Context mContext;
  public Handler mHandler;
  public View mView;
  CharSequence uI;
  
  public a(Context paramContext, i parami, Window paramWindow)
  {
    this.mContext = paramContext;
    this.Fd = parami;
    this.Fe = paramWindow;
    this.mHandler = new b(parami);
    paramContext = paramContext.obtainStyledAttributes(null, a.k.bb, android.support.v7.a.a.a.alertDialogStyle, 0);
    this.FC = paramContext.getResourceId(a.k.Ly, 0);
    this.FD = paramContext.getResourceId(a.k.Lz, 0);
    this.FE = paramContext.getResourceId(a.k.LB, 0);
    this.FF = paramContext.getResourceId(a.k.LC, 0);
    this.FG = paramContext.getResourceId(a.k.LD, 0);
    this.FH = paramContext.getResourceId(a.k.LA, 0);
    paramContext.recycle();
    parami.cZ();
  }
  
  public static void a(View paramView1, View paramView2, View paramView3)
  {
    int j = 0;
    if (paramView2 != null)
    {
      if (z.h(paramView1, -1))
      {
        i = 0;
        paramView2.setVisibility(i);
      }
    }
    else if (paramView3 != null) {
      if (!z.h(paramView1, 1)) {
        break label48;
      }
    }
    label48:
    for (int i = j;; i = 4)
    {
      paramView3.setVisibility(i);
      return;
      i = 4;
      break;
    }
  }
  
  static boolean aI(View paramView)
  {
    if (paramView.onCheckIsTextEditor()) {
      return true;
    }
    if (!(paramView instanceof ViewGroup)) {
      return false;
    }
    paramView = (ViewGroup)paramView;
    int i = paramView.getChildCount();
    while (i > 0)
    {
      int j = i - 1;
      i = j;
      if (aI(paramView.getChildAt(j))) {
        return true;
      }
    }
    return false;
  }
  
  static ViewGroup b(View paramView1, View paramView2)
  {
    if (paramView1 == null) {
      if (!(paramView2 instanceof ViewStub)) {
        break label71;
      }
    }
    label71:
    for (paramView1 = ((ViewStub)paramView2).inflate();; paramView1 = paramView2)
    {
      return (ViewGroup)paramView1;
      if (paramView2 != null)
      {
        ViewParent localViewParent = paramView2.getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(paramView2);
        }
      }
      if ((paramView1 instanceof ViewStub)) {
        paramView1 = ((ViewStub)paramView1).inflate();
      }
      for (;;)
      {
        return (ViewGroup)paramView1;
      }
    }
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage)
  {
    if (paramOnClickListener != null) {
      paramMessage = this.mHandler.obtainMessage(paramInt, paramOnClickListener);
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Button does not exist");
    case -1: 
      this.Fo = paramCharSequence;
      this.Fp = paramMessage;
      return;
    case -2: 
      this.Fr = paramCharSequence;
      this.Fs = paramMessage;
      return;
    }
    this.Fu = paramCharSequence;
    this.Fv = paramMessage;
  }
  
  public final void setIcon(int paramInt)
  {
    this.jQ = null;
    this.Fx = paramInt;
    if (this.kI != null)
    {
      if (paramInt != 0)
      {
        this.kI.setVisibility(0);
        this.kI.setImageResource(this.Fx);
      }
    }
    else {
      return;
    }
    this.kI.setVisibility(8);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.uI = paramCharSequence;
    if (this.Fy != null) {
      this.Fy.setText(paramCharSequence);
    }
  }
  
  public static final class a
  {
    public Cursor Bo;
    public final LayoutInflater Du;
    public ListAdapter FA;
    public int FB = -1;
    public int FN = 0;
    public CharSequence FO;
    public DialogInterface.OnClickListener FP;
    public CharSequence FQ;
    public DialogInterface.OnClickListener FR;
    public CharSequence FS;
    public DialogInterface.OnClickListener FT;
    public DialogInterface.OnCancelListener FU;
    public DialogInterface.OnDismissListener FV;
    public DialogInterface.OnKeyListener FW;
    public CharSequence[] FX;
    public DialogInterface.OnClickListener FY;
    public boolean[] FZ;
    public CharSequence Ff;
    public int Fh;
    public int Fi;
    public int Fj;
    public int Fk;
    public int Fl;
    public boolean Fm = false;
    public int Fx = 0;
    public View Fz;
    public boolean Ga;
    public boolean Gb;
    public DialogInterface.OnMultiChoiceClickListener Gc;
    public String Gd;
    public String Ge;
    public AdapterView.OnItemSelectedListener Gf;
    public boolean Gg = true;
    public Drawable jQ;
    public final Context mContext;
    public View mView;
    public boolean oI;
    public CharSequence uI;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
      this.oI = true;
      this.Du = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }
  }
  
  private static final class b
    extends Handler
  {
    private WeakReference<DialogInterface> Gm;
    
    public b(DialogInterface paramDialogInterface)
    {
      this.Gm = new WeakReference(paramDialogInterface);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 0: 
      default: 
        return;
      case -3: 
      case -2: 
      case -1: 
        ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.Gm.get(), paramMessage.what);
        return;
      }
      ((DialogInterface)paramMessage.obj).dismiss();
    }
  }
  
  private static final class c
    extends ArrayAdapter<CharSequence>
  {
    public c(Context paramContext, int paramInt, CharSequence[] paramArrayOfCharSequence)
    {
      super(paramInt, 16908308, paramArrayOfCharSequence);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final boolean hasStableIds()
    {
      return true;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/app/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */