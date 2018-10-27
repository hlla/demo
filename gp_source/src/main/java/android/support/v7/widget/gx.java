package android.support.v7.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.content.d;
import android.support.v4.widget.al;
import android.support.v4.widget.l;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

final class gx
  extends al
  implements View.OnClickListener
{
  public int e = 1;
  private final int f;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private final WeakHashMap j;
  private final Context k;
  private final SearchView l;
  private final SearchableInfo m;
  private int n = -1;
  private int o = -1;
  private int p = -1;
  private ColorStateList q;
  
  public gx(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout());
    this.b.getSystemService("search");
    this.l = paramSearchView;
    this.m = paramSearchableInfo;
    this.f = paramSearchView.getSuggestionCommitIconResId();
    this.k = paramContext;
    this.j = paramWeakHashMap;
  }
  
  private final Drawable a(ComponentName paramComponentName)
  {
    Object localObject = this.b.getPackageManager();
    try
    {
      ActivityInfo localActivityInfo = ((PackageManager)localObject).getActivityInfo(paramComponentName, 128);
      int i1 = localActivityInfo.getIconResource();
      if (i1 != 0)
      {
        localObject = ((PackageManager)localObject).getDrawable(paramComponentName.getPackageName(), i1, localActivityInfo.applicationInfo);
        if (localObject == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid icon resource ");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(" for ");
          ((StringBuilder)localObject).append(paramComponentName.flattenToShortString());
          Log.w("SuggestionsAdapter", ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        return null;
      }
      return (Drawable)localObject;
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      Log.w("SuggestionsAdapter", paramComponentName.toString());
    }
    return null;
  }
  
  /* Error */
  private final Drawable a(Uri paramUri)
  {
    // Byte code:
    //   0: ldc -108
    //   2: aload_1
    //   3: invokevirtual 153	android/net/Uri:getScheme	()Ljava/lang/String;
    //   6: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifne +31 -> 40
    //   12: aload_0
    //   13: getfield 72	android/support/v7/widget/gx:k	Landroid/content/Context;
    //   16: invokevirtual 163	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: aload_1
    //   20: invokevirtual 169	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +73 -> 98
    //   28: aload_3
    //   29: aconst_null
    //   30: invokestatic 175	android/graphics/drawable/Drawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   33: astore_2
    //   34: aload_3
    //   35: invokevirtual 180	java/io/InputStream:close	()V
    //   38: aload_2
    //   39: areturn
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial 182	android/support/v7/widget/gx:b	(Landroid/net/Uri;)Landroid/graphics/drawable/Drawable;
    //   45: astore_2
    //   46: aload_2
    //   47: areturn
    //   48: astore_2
    //   49: new 110	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   56: astore_3
    //   57: aload_3
    //   58: ldc -72
    //   60: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_3
    //   65: aload_1
    //   66: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_3
    //   71: ldc -67
    //   73: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_3
    //   78: aload_2
    //   79: invokevirtual 192	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   82: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: ldc -127
    //   88: aload_3
    //   89: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 138	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   95: pop
    //   96: aconst_null
    //   97: areturn
    //   98: new 110	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   105: astore_2
    //   106: aload_2
    //   107: ldc -62
    //   109: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: aload_1
    //   115: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: new 142	java/io/FileNotFoundException
    //   122: dup
    //   123: aload_2
    //   124: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokespecial 197	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   130: athrow
    //   131: astore_2
    //   132: aload_3
    //   133: invokevirtual 180	java/io/InputStream:close	()V
    //   136: aload_2
    //   137: athrow
    //   138: astore_3
    //   139: new 110	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   146: astore 4
    //   148: aload 4
    //   150: ldc -57
    //   152: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 4
    //   158: aload_1
    //   159: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: ldc -127
    //   165: aload 4
    //   167: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: aload_3
    //   171: invokestatic 202	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   174: pop
    //   175: aload_2
    //   176: areturn
    //   177: astore_2
    //   178: new 110	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   185: astore_2
    //   186: aload_2
    //   187: ldc -52
    //   189: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_2
    //   194: aload_1
    //   195: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: new 142	java/io/FileNotFoundException
    //   202: dup
    //   203: aload_2
    //   204: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokespecial 197	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   210: athrow
    //   211: astore_3
    //   212: new 110	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   219: astore 4
    //   221: aload 4
    //   223: ldc -57
    //   225: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 4
    //   231: aload_1
    //   232: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: ldc -127
    //   238: aload 4
    //   240: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: aload_3
    //   244: invokestatic 202	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   247: pop
    //   248: goto -112 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	gx
    //   0	251	1	paramUri	Uri
    //   33	14	2	localDrawable1	Drawable
    //   48	31	2	localFileNotFoundException	FileNotFoundException
    //   105	19	2	localStringBuilder1	StringBuilder
    //   131	45	2	localDrawable2	Drawable
    //   177	1	2	localNotFoundException	Resources.NotFoundException
    //   185	19	2	localStringBuilder2	StringBuilder
    //   23	110	3	localObject	Object
    //   138	33	3	localIOException1	java.io.IOException
    //   211	33	3	localIOException2	java.io.IOException
    //   146	93	4	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	24	48	java/io/FileNotFoundException
    //   34	38	48	java/io/FileNotFoundException
    //   40	46	48	java/io/FileNotFoundException
    //   98	131	48	java/io/FileNotFoundException
    //   132	136	48	java/io/FileNotFoundException
    //   136	138	48	java/io/FileNotFoundException
    //   139	175	48	java/io/FileNotFoundException
    //   178	211	48	java/io/FileNotFoundException
    //   212	248	48	java/io/FileNotFoundException
    //   28	34	131	finally
    //   34	38	138	java/io/IOException
    //   40	46	177	android/content/res/Resources$NotFoundException
    //   132	136	211	java/io/IOException
  }
  
  private final Drawable a(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()) && (!"0".equals(paramString))) {}
    try
    {
      int i1 = Integer.parseInt(paramString);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("android.resource://");
      ((StringBuilder)localObject1).append(this.k.getPackageName());
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(i1);
      String str = ((StringBuilder)localObject1).toString();
      localDrawable = b(str);
      localObject1 = localDrawable;
      if (localDrawable == null)
      {
        localObject1 = d.a(this.k, i1);
        a(str, (Drawable)localObject1);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Drawable localDrawable;
      do
      {
        Object localObject1;
        localDrawable = b(paramString);
        localObject2 = localDrawable;
      } while (localDrawable != null);
      Object localObject2 = a(Uri.parse(paramString));
      a(paramString, (Drawable)localObject2);
      return (Drawable)localObject2;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Icon resource not found: ");
      localStringBuilder.append(paramString);
      Log.w("SuggestionsAdapter", localStringBuilder.toString());
    }
    return (Drawable)localObject1;
    return null;
    return null;
  }
  
  private static String a(Cursor paramCursor, int paramInt)
  {
    String str = null;
    if (paramInt != -1) {}
    try
    {
      str = paramCursor.getString(paramInt);
      return str;
    }
    catch (Exception paramCursor)
    {
      Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", paramCursor);
    }
    return null;
  }
  
  public static String a(Cursor paramCursor, String paramString)
  {
    return a(paramCursor, paramCursor.getColumnIndex(paramString));
  }
  
  private static void a(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      paramImageView.setVisibility(paramInt);
      return;
    }
    paramImageView.setVisibility(0);
    paramDrawable.setVisible(false, false);
    paramDrawable.setVisible(true, false);
  }
  
  private static void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
  }
  
  private final void a(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.j.put(paramString, paramDrawable.getConstantState());
    }
  }
  
  private final Drawable b(Uri paramUri)
  {
    Object localObject = paramUri.getAuthority();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No authority: ");
      ((StringBuilder)localObject).append(paramUri);
      throw new FileNotFoundException(((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        localResources = this.b.getPackageManager().getResourcesForApplication((String)localObject);
        localList = paramUri.getPathSegments();
        if (localList == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("No path: ");
          ((StringBuilder)localObject).append(paramUri);
          throw new FileNotFoundException(((StringBuilder)localObject).toString());
        }
        i1 = localList.size();
        if (i1 != 1) {}
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Resources localResources;
        List localList;
        int i1;
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("No package found for authority: ");
        localStringBuilder1.append(paramUri);
        throw new FileNotFoundException(localStringBuilder1.toString());
      }
      try
      {
        i1 = Integer.parseInt((String)localList.get(0));
        if (i1 == 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("No resource found for: ");
          ((StringBuilder)localObject).append(paramUri);
          throw new FileNotFoundException(((StringBuilder)localObject).toString());
        }
        return localResources.getDrawable(i1);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("Single path segment is not a resource ID: ");
        localStringBuilder2.append(paramUri);
        throw new FileNotFoundException(localStringBuilder2.toString());
      }
      if (i1 != 2) {
        break;
      }
      i1 = localResources.getIdentifier((String)localList.get(1), (String)localList.get(0), (String)localObject);
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("More than two path segments: ");
    localStringBuilder2.append(paramUri);
    throw new FileNotFoundException(localStringBuilder2.toString());
  }
  
  private final Drawable b(String paramString)
  {
    paramString = (Drawable.ConstantState)this.j.get(paramString);
    if (paramString != null) {
      return paramString.newDrawable();
    }
    return null;
  }
  
  private static void c(Cursor paramCursor)
  {
    if (paramCursor != null) {}
    for (paramCursor = paramCursor.getExtras();; paramCursor = null)
    {
      if ((paramCursor != null) && (!paramCursor.getBoolean("in_progress"))) {}
      return;
    }
  }
  
  public final Cursor a(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {}
    for (paramCharSequence = paramCharSequence.toString();; paramCharSequence = "")
    {
      if ((this.l.getVisibility() == 0) && (this.l.getWindowVisibility() == 0)) {
        for (;;)
        {
          Object localObject2;
          try
          {
            Object localObject1 = this.m;
            if (localObject1 == null) {
              break label202;
            }
            localObject2 = ((SearchableInfo)localObject1).getSuggestAuthority();
            if (localObject2 == null) {
              break label197;
            }
            localObject2 = new Uri.Builder().scheme("content").authority((String)localObject2).query("").fragment("");
            String str = ((SearchableInfo)localObject1).getSuggestPath();
            if (str != null) {
              ((Uri.Builder)localObject2).appendEncodedPath(str);
            }
            ((Uri.Builder)localObject2).appendPath("search_suggest_query");
            str = ((SearchableInfo)localObject1).getSuggestSelection();
            if (str == null) {
              break label186;
            }
            localObject1 = new String[1];
            localObject1[0] = paramCharSequence;
            paramCharSequence = (CharSequence)localObject1;
            ((Uri.Builder)localObject2).appendQueryParameter("limit", "50");
            localObject1 = ((Uri.Builder)localObject2).build();
            paramCharSequence = this.b.getContentResolver().query((Uri)localObject1, null, str, paramCharSequence, null);
            if (paramCharSequence != null)
            {
              paramCharSequence.getCount();
              return paramCharSequence;
            }
          }
          catch (RuntimeException paramCharSequence)
          {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", paramCharSequence);
          }
          return null;
          label186:
          ((Uri.Builder)localObject2).appendPath(paramCharSequence);
          paramCharSequence = null;
          continue;
          label197:
          paramCharSequence = null;
          continue;
          label202:
          paramCharSequence = null;
        }
      }
      return null;
    }
  }
  
  public final View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    paramContext = super.a(paramContext, paramCursor, paramViewGroup);
    paramContext.setTag(new gy(paramContext));
    ((ImageView)paramContext.findViewById(2131427989)).setImageResource(this.f);
    return paramContext;
  }
  
  public final void a(Cursor paramCursor)
  {
    try
    {
      super.a(paramCursor);
      if (paramCursor != null)
      {
        this.n = paramCursor.getColumnIndex("suggest_text_1");
        this.o = paramCursor.getColumnIndex("suggest_text_2");
        this.p = paramCursor.getColumnIndex("suggest_text_2_url");
        this.h = paramCursor.getColumnIndex("suggest_icon_1");
        this.i = paramCursor.getColumnIndex("suggest_icon_2");
        this.g = paramCursor.getColumnIndex("suggest_flags");
      }
      return;
    }
    catch (Exception paramCursor)
    {
      Log.e("SuggestionsAdapter", "error changing cursor and caching columns", paramCursor);
    }
  }
  
  public final void a(View paramView, Cursor paramCursor)
  {
    Object localObject2 = null;
    gy localgy = (gy)paramView.getTag();
    int i1 = this.g;
    if (i1 != -1) {}
    for (i1 = paramCursor.getInt(i1);; i1 = 0)
    {
      if (localgy.d != null)
      {
        paramView = a(paramCursor, this.n);
        a(localgy.d, paramView);
      }
      Object localObject1;
      if (localgy.e != null)
      {
        localObject1 = a(paramCursor, this.p);
        if (localObject1 != null) {
          break label464;
        }
        paramView = a(paramCursor, this.o);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramView))
        {
          localObject1 = localgy.d;
          if (localObject1 != null)
          {
            ((TextView)localObject1).setSingleLine(false);
            localgy.d.setMaxLines(2);
          }
        }
        for (;;)
        {
          a(localgy.e, paramView);
          ImageView localImageView = localgy.a;
          if (localImageView == null)
          {
            localObject1 = localgy.b;
            if (localObject1 == null) {}
            for (;;)
            {
              i2 = this.e;
              if (i2 == 2) {}
              for (;;)
              {
                localgy.c.setVisibility(0);
                localgy.c.setTag(localgy.d.getText());
                localgy.c.setOnClickListener(this);
                return;
                if (i2 != 1) {}
                while ((i1 & 0x1) == 0)
                {
                  localgy.c.setVisibility(8);
                  return;
                }
              }
              i2 = this.i;
              paramView = (View)localObject2;
              if (i2 != -1) {
                paramView = a(paramCursor.getString(i2));
              }
              a((ImageView)localObject1, paramView, 8);
            }
          }
          int i2 = this.h;
          String str;
          if (i2 != -1)
          {
            localObject1 = a(paramCursor.getString(i2));
            paramView = (View)localObject1;
            if (localObject1 == null)
            {
              paramView = this.m.getSearchActivity();
              str = paramView.flattenToShortString();
              if (!this.j.containsKey(str)) {
                break label392;
              }
              paramView = (Drawable.ConstantState)this.j.get(str);
              if (paramView == null) {
                break label386;
              }
              localObject1 = paramView.newDrawable(this.k.getResources());
              label357:
              paramView = (View)localObject1;
              if (localObject1 != null) {}
            }
          }
          for (paramView = this.b.getPackageManager().getDefaultActivityIcon();; paramView = null)
          {
            a(localImageView, paramView, 4);
            break;
            label386:
            localObject1 = null;
            break label357;
            label392:
            localObject1 = a(paramView);
            if (localObject1 != null) {}
            for (paramView = ((Drawable)localObject1).getConstantState();; paramView = null)
            {
              this.j.put(str, paramView);
              break;
            }
          }
          localObject1 = localgy.d;
          if (localObject1 != null)
          {
            ((TextView)localObject1).setSingleLine(true);
            localgy.d.setMaxLines(1);
          }
        }
        label464:
        if (this.q == null)
        {
          paramView = new TypedValue();
          this.b.getTheme().resolveAttribute(2130969654, paramView, true);
          this.q = this.b.getResources().getColorStateList(paramView.resourceId);
        }
        paramView = new SpannableString((CharSequence)localObject1);
        paramView.setSpan(new TextAppearanceSpan(null, 0, 0, this.q, null), 0, ((CharSequence)localObject1).length(), 33);
      }
    }
  }
  
  public final CharSequence b(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      String str = a(paramCursor, "suggest_intent_query");
      Object localObject = str;
      if (str == null) {
        if (this.m.shouldRewriteQueryFromData())
        {
          str = a(paramCursor, "suggest_intent_data");
          localObject = str;
          if (str != null) {}
        }
        else if (this.m.shouldRewriteQueryFromText())
        {
          paramCursor = a(paramCursor, "suggest_text_1");
          localObject = paramCursor;
          if (paramCursor != null) {}
        }
        else
        {
          localObject = null;
        }
      }
      return (CharSequence)localObject;
    }
    return null;
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getDropDownView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", paramView);
      paramViewGroup = b(this.b, this.c, paramViewGroup);
      if (paramViewGroup != null) {
        ((gy)paramViewGroup.getTag()).d.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", paramView);
      paramViewGroup = a(this.b, this.c, paramViewGroup);
      if (paramViewGroup != null) {
        ((gy)paramViewGroup.getTag()).d.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public final boolean hasStableIds()
  {
    return false;
  }
  
  public final void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    c(this.c);
  }
  
  public final void notifyDataSetInvalidated()
  {
    super.notifyDataSetInvalidated();
    c(this.c);
  }
  
  public final void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof CharSequence)) {
      this.l.onQueryRefine((CharSequence)paramView);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/gx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */