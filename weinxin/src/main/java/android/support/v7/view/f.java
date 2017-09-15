package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.c.a.a;
import android.support.v4.e.i;
import android.support.v7.view.menu.n;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

@TargetApi(11)
public final class f
  extends ActionMode
{
  final b OF;
  final Context mContext;
  
  public f(Context paramContext, b paramb)
  {
    this.mContext = paramContext;
    this.OF = paramb;
  }
  
  public final void finish()
  {
    this.OF.finish();
  }
  
  public final View getCustomView()
  {
    return this.OF.getCustomView();
  }
  
  public final Menu getMenu()
  {
    return n.a(this.mContext, (a)this.OF.getMenu());
  }
  
  public final MenuInflater getMenuInflater()
  {
    return this.OF.getMenuInflater();
  }
  
  public final CharSequence getSubtitle()
  {
    return this.OF.getSubtitle();
  }
  
  public final Object getTag()
  {
    return this.OF.OA;
  }
  
  public final CharSequence getTitle()
  {
    return this.OF.getTitle();
  }
  
  public final boolean getTitleOptionalHint()
  {
    return this.OF.OB;
  }
  
  public final void invalidate()
  {
    this.OF.invalidate();
  }
  
  public final boolean isTitleOptional()
  {
    return this.OF.isTitleOptional();
  }
  
  public final void setCustomView(View paramView)
  {
    this.OF.setCustomView(paramView);
  }
  
  public final void setSubtitle(int paramInt)
  {
    this.OF.setSubtitle(paramInt);
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.OF.setSubtitle(paramCharSequence);
  }
  
  public final void setTag(Object paramObject)
  {
    this.OF.OA = paramObject;
  }
  
  public final void setTitle(int paramInt)
  {
    this.OF.setTitle(paramInt);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.OF.setTitle(paramCharSequence);
  }
  
  public final void setTitleOptionalHint(boolean paramBoolean)
  {
    this.OF.setTitleOptionalHint(paramBoolean);
  }
  
  public static final class a
    implements b.a
  {
    final ActionMode.Callback OG;
    final ArrayList<f> OH;
    final i<Menu, Menu> OI;
    final Context mContext;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      this.mContext = paramContext;
      this.OG = paramCallback;
      this.OH = new ArrayList();
      this.OI = new i();
    }
    
    private Menu b(Menu paramMenu)
    {
      Menu localMenu2 = (Menu)this.OI.get(paramMenu);
      Menu localMenu1 = localMenu2;
      if (localMenu2 == null)
      {
        localMenu1 = n.a(this.mContext, (a)paramMenu);
        this.OI.put(paramMenu, localMenu1);
      }
      return localMenu1;
    }
    
    public final void a(b paramb)
    {
      this.OG.onDestroyActionMode(b(paramb));
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      return this.OG.onCreateActionMode(b(paramb), b(paramMenu));
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.OG.onActionItemClicked(b(paramb), n.a(this.mContext, (android.support.v4.c.a.b)paramMenuItem));
    }
    
    public final ActionMode b(b paramb)
    {
      int j = this.OH.size();
      int i = 0;
      while (i < j)
      {
        f localf = (f)this.OH.get(i);
        if ((localf != null) && (localf.OF == paramb)) {
          return localf;
        }
        i += 1;
      }
      paramb = new f(this.mContext, paramb);
      this.OH.add(paramb);
      return paramb;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      return this.OG.onPrepareActionMode(b(paramb), b(paramMenu));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */