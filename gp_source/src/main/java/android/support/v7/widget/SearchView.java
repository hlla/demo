package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ac;
import android.support.v4.widget.l;
import android.support.v7.a.a;
import android.support.v7.view.d;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.TextView.OnEditorActionListener;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView
  extends dj
  implements d
{
  public static final boolean DBG = false;
  public static final gp HIDDEN_METHOD_INVOKER = new gp();
  public static final String IME_OPTION_NO_MICROPHONE = "nm";
  public static final String LOG_TAG = "SearchView";
  public Bundle mAppSearchData;
  public boolean mClearingFocus;
  public final ImageView mCloseButton;
  public final ImageView mCollapsedIcon;
  public int mCollapsedImeOptions;
  public final CharSequence mDefaultQueryHint;
  public final View mDropDownAnchor;
  public boolean mExpandedInActionView;
  public final ImageView mGoButton;
  public boolean mIconified;
  public boolean mIconifiedByDefault;
  public int mMaxWidth;
  public CharSequence mOldQueryText;
  public final View.OnClickListener mOnClickListener = new gk(this);
  public gq mOnCloseListener;
  public final TextView.OnEditorActionListener mOnEditorActionListener = new gm(this);
  public final AdapterView.OnItemClickListener mOnItemClickListener = new gn(this);
  public final AdapterView.OnItemSelectedListener mOnItemSelectedListener = new go(this);
  public gr mOnQueryChangeListener;
  public View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
  public View.OnClickListener mOnSearchClickListener;
  public gs mOnSuggestionListener;
  public final WeakHashMap mOutsideDrawablesCache = new WeakHashMap();
  public CharSequence mQueryHint;
  public boolean mQueryRefinement;
  public Runnable mReleaseCursorRunnable = new gh(this);
  public final ImageView mSearchButton;
  public final View mSearchEditFrame;
  public final Drawable mSearchHintIcon;
  public final View mSearchPlate;
  public final SearchView.SearchAutoComplete mSearchSrcTextView;
  public Rect mSearchSrcTextViewBounds = new Rect();
  public Rect mSearchSrtTextViewBoundsExpanded = new Rect();
  public SearchableInfo mSearchable;
  public final View mSubmitArea;
  public boolean mSubmitButtonEnabled;
  public final int mSuggestionCommitIconResId;
  public final int mSuggestionRowLayout;
  public l mSuggestionsAdapter;
  public int[] mTemp = new int[2];
  public int[] mTemp2 = new int[2];
  public View.OnKeyListener mTextKeyListener = new gl(this);
  public TextWatcher mTextWatcher = new gg(this);
  public gv mTouchDelegate;
  public final Runnable mUpdateDrawableStateRunnable = new gf(this);
  public CharSequence mUserQuery;
  public final Intent mVoiceAppSearchIntent;
  public final ImageView mVoiceButton;
  public boolean mVoiceButtonEnabled;
  public final Intent mVoiceWebSearchIntent;
  
  public SearchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969472);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = hf.a(paramContext, paramAttributeSet, a.cf, paramInt, 0);
    LayoutInflater.from(paramContext).inflate(paramAttributeSet.g(a.cp, 2131623961), this, true);
    this.mSearchSrcTextView = ((SearchView.SearchAutoComplete)findViewById(2131429164));
    this.mSearchSrcTextView.b = this;
    this.mSearchEditFrame = findViewById(2131429155);
    this.mSearchPlate = findViewById(2131429159);
    this.mSubmitArea = findViewById(2131429353);
    this.mSearchButton = ((ImageView)findViewById(2131429153));
    this.mGoButton = ((ImageView)findViewById(2131429156));
    this.mCloseButton = ((ImageView)findViewById(2131429154));
    this.mVoiceButton = ((ImageView)findViewById(2131429167));
    this.mCollapsedIcon = ((ImageView)findViewById(2131429157));
    ac.a(this.mSearchPlate, paramAttributeSet.a(a.cq));
    ac.a(this.mSubmitArea, paramAttributeSet.a(a.cu));
    this.mSearchButton.setImageDrawable(paramAttributeSet.a(a.ct));
    this.mGoButton.setImageDrawable(paramAttributeSet.a(a.cn));
    this.mCloseButton.setImageDrawable(paramAttributeSet.a(a.ck));
    this.mVoiceButton.setImageDrawable(paramAttributeSet.a(a.cw));
    this.mCollapsedIcon.setImageDrawable(paramAttributeSet.a(a.ct));
    this.mSearchHintIcon = paramAttributeSet.a(a.cs);
    hq.a(this.mSearchButton, getResources().getString(2131951649));
    this.mSuggestionRowLayout = paramAttributeSet.g(a.cv, 2131623960);
    this.mSuggestionCommitIconResId = paramAttributeSet.g(a.cl, 0);
    this.mSearchButton.setOnClickListener(this.mOnClickListener);
    this.mCloseButton.setOnClickListener(this.mOnClickListener);
    this.mGoButton.setOnClickListener(this.mOnClickListener);
    this.mVoiceButton.setOnClickListener(this.mOnClickListener);
    this.mSearchSrcTextView.setOnClickListener(this.mOnClickListener);
    this.mSearchSrcTextView.addTextChangedListener(this.mTextWatcher);
    this.mSearchSrcTextView.setOnEditorActionListener(this.mOnEditorActionListener);
    this.mSearchSrcTextView.setOnItemClickListener(this.mOnItemClickListener);
    this.mSearchSrcTextView.setOnItemSelectedListener(this.mOnItemSelectedListener);
    this.mSearchSrcTextView.setOnKeyListener(this.mTextKeyListener);
    this.mSearchSrcTextView.setOnFocusChangeListener(new gi(this));
    setIconifiedByDefault(paramAttributeSet.a(a.co, true));
    paramInt = paramAttributeSet.e(a.cj, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    this.mDefaultQueryHint = paramAttributeSet.c(a.cm);
    this.mQueryHint = paramAttributeSet.c(a.cr);
    paramInt = paramAttributeSet.a(a.ch, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = paramAttributeSet.a(a.ci, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(paramAttributeSet.a(a.cg, true));
    paramAttributeSet.c.recycle();
    this.mVoiceWebSearchIntent = new Intent("android.speech.action.WEB_SEARCH");
    this.mVoiceWebSearchIntent.addFlags(268435456);
    this.mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.mVoiceAppSearchIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.mVoiceAppSearchIntent.addFlags(268435456);
    this.mDropDownAnchor = findViewById(this.mSearchSrcTextView.getDropDownAnchor());
    paramContext = this.mDropDownAnchor;
    if (paramContext != null) {
      paramContext.addOnLayoutChangeListener(new gj(this));
    }
    updateViewsVisibility(this.mIconifiedByDefault);
    updateQueryHint();
  }
  
  private Intent createIntent(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    paramString1 = new Intent(paramString1);
    paramString1.addFlags(268435456);
    if (paramUri == null) {}
    for (;;)
    {
      paramString1.putExtra("user_query", this.mUserQuery);
      if (paramString3 != null) {
        paramString1.putExtra("query", paramString3);
      }
      if (paramString2 != null) {
        paramString1.putExtra("intent_extra_data_key", paramString2);
      }
      paramUri = this.mAppSearchData;
      if (paramUri != null) {
        paramString1.putExtra("app_data", paramUri);
      }
      if (paramInt != 0)
      {
        paramString1.putExtra("action_key", paramInt);
        paramString1.putExtra("action_msg", paramString4);
      }
      paramString1.setComponent(this.mSearchable.getSearchActivity());
      return paramString1;
      paramString1.setData(paramUri);
    }
  }
  
  private Intent createIntentFromSuggestion(Cursor paramCursor, int paramInt, String paramString)
  {
    try
    {
      localObject2 = gx.a(paramCursor, "suggest_intent_action");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label234;
      }
      localObject1 = this.mSearchable.getSuggestIntentAction();
    }
    catch (RuntimeException paramString)
    {
      for (;;)
      {
        Object localObject1;
        try
        {
          Object localObject3;
          String str;
          paramInt = paramCursor.getPosition();
          paramCursor = new StringBuilder();
          paramCursor.append("Search suggestions cursor at row ");
          paramCursor.append(paramInt);
          paramCursor.append(" returned exception.");
          Log.w("SearchView", paramCursor.toString(), paramString);
          return null;
        }
        catch (RuntimeException paramCursor)
        {
          paramInt = -1;
          continue;
        }
        label234:
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "android.intent.action.SEARCH";
        }
      }
    }
    localObject3 = gx.a(paramCursor, "suggest_intent_data");
    localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = this.mSearchable.getSuggestIntentData();
    }
    localObject3 = localObject1;
    if (localObject1 != null)
    {
      str = gx.a(paramCursor, "suggest_intent_data_id");
      localObject3 = localObject1;
      if (str != null)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("/");
        ((StringBuilder)localObject3).append(Uri.encode(str));
        localObject3 = ((StringBuilder)localObject3).toString();
      }
    }
    if (localObject3 != null) {}
    for (localObject1 = Uri.parse((String)localObject3);; localObject1 = null)
    {
      localObject3 = gx.a(paramCursor, "suggest_intent_query");
      paramString = createIntent((String)localObject2, (Uri)localObject1, gx.a(paramCursor, "suggest_intent_extra_data"), (String)localObject3, paramInt, paramString);
      return paramString;
    }
  }
  
  private Intent createVoiceAppSearchIntent(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    Object localObject3 = null;
    ComponentName localComponentName = paramSearchableInfo.getSearchActivity();
    Object localObject1 = new Intent("android.intent.action.SEARCH");
    ((Intent)localObject1).setComponent(localComponentName);
    PendingIntent localPendingIntent = PendingIntent.getActivity(getContext(), 0, (Intent)localObject1, 1073741824);
    Bundle localBundle = new Bundle();
    localObject1 = this.mAppSearchData;
    if (localObject1 != null) {
      localBundle.putParcelable("app_data", (Parcelable)localObject1);
    }
    Intent localIntent = new Intent(paramIntent);
    Object localObject2 = getResources();
    paramIntent = "free_form";
    if (paramSearchableInfo.getVoiceLanguageModeId() != 0) {
      paramIntent = ((Resources)localObject2).getString(paramSearchableInfo.getVoiceLanguageModeId());
    }
    if (paramSearchableInfo.getVoicePromptTextId() != 0) {}
    for (localObject1 = ((Resources)localObject2).getString(paramSearchableInfo.getVoicePromptTextId());; localObject1 = null)
    {
      if (paramSearchableInfo.getVoiceLanguageId() != 0) {}
      for (localObject2 = ((Resources)localObject2).getString(paramSearchableInfo.getVoiceLanguageId());; localObject2 = null)
      {
        if (paramSearchableInfo.getVoiceMaxResults() != 0) {}
        for (int i = paramSearchableInfo.getVoiceMaxResults();; i = 1)
        {
          localIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", paramIntent);
          localIntent.putExtra("android.speech.extra.PROMPT", (String)localObject1);
          localIntent.putExtra("android.speech.extra.LANGUAGE", (String)localObject2);
          localIntent.putExtra("android.speech.extra.MAX_RESULTS", i);
          paramIntent = (Intent)localObject3;
          if (localComponentName != null) {
            paramIntent = localComponentName.flattenToShortString();
          }
          localIntent.putExtra("calling_package", paramIntent);
          localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", localPendingIntent);
          localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", localBundle);
          return localIntent;
        }
      }
    }
  }
  
  private Intent createVoiceWebSearchIntent(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    Intent localIntent = new Intent(paramIntent);
    paramIntent = paramSearchableInfo.getSearchActivity();
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.flattenToShortString();; paramIntent = null)
    {
      localIntent.putExtra("calling_package", paramIntent);
      return localIntent;
    }
  }
  
  private void dismissSuggestions()
  {
    this.mSearchSrcTextView.dismissDropDown();
  }
  
  private void getChildBoundsWithinSearchView(View paramView, Rect paramRect)
  {
    paramView.getLocationInWindow(this.mTemp);
    getLocationInWindow(this.mTemp2);
    int[] arrayOfInt1 = this.mTemp;
    int i = arrayOfInt1[1];
    int[] arrayOfInt2 = this.mTemp2;
    i -= arrayOfInt2[1];
    int j = arrayOfInt1[0] - arrayOfInt2[0];
    paramRect.set(j, i, paramView.getWidth() + j, paramView.getHeight() + i);
  }
  
  private CharSequence getDecoratedHint(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (this.mIconifiedByDefault)
    {
      localObject = paramCharSequence;
      if (this.mSearchHintIcon != null)
      {
        int i = (int)(this.mSearchSrcTextView.getTextSize() * 1.25D);
        this.mSearchHintIcon.setBounds(0, 0, i, i);
        localObject = new SpannableStringBuilder("   ");
        ((SpannableStringBuilder)localObject).setSpan(new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
        ((SpannableStringBuilder)localObject).append(paramCharSequence);
      }
    }
    return (CharSequence)localObject;
  }
  
  private int getPreferredHeight()
  {
    return getContext().getResources().getDimensionPixelSize(2131165235);
  }
  
  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(2131165236);
  }
  
  private boolean hasVoiceSearch()
  {
    boolean bool2 = false;
    Object localObject = this.mSearchable;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((SearchableInfo)localObject).getVoiceSearchEnabled())
      {
        if (!this.mSearchable.getVoiceSearchLaunchWebSearch()) {
          break label66;
        }
        localObject = this.mVoiceWebSearchIntent;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (getContext().getPackageManager().resolveActivity((Intent)localObject, 65536) != null) {
          bool1 = true;
        }
      }
      return bool1;
      label66:
      if (this.mSearchable.getVoiceSearchLaunchRecognizer()) {
        localObject = this.mVoiceAppSearchIntent;
      } else {
        localObject = null;
      }
    }
  }
  
  static boolean isLandscapeMode(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
  }
  
  private boolean isSubmitAreaEnabled()
  {
    if (this.mSubmitButtonEnabled) {}
    for (;;)
    {
      if (!isIconified()) {
        return true;
      }
      do
      {
        return false;
      } while (!this.mVoiceButtonEnabled);
    }
  }
  
  private void launchIntent(Intent paramIntent)
  {
    if (paramIntent != null) {}
    try
    {
      getContext().startActivity(paramIntent);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed launch activity: ");
      localStringBuilder.append(paramIntent);
      Log.e("SearchView", localStringBuilder.toString(), localRuntimeException);
    }
  }
  
  private boolean launchSuggestion(int paramInt1, int paramInt2, String paramString)
  {
    Cursor localCursor = this.mSuggestionsAdapter.c;
    if ((localCursor != null) && (localCursor.moveToPosition(paramInt1)))
    {
      launchIntent(createIntentFromSuggestion(localCursor, paramInt2, paramString));
      return true;
    }
    return false;
  }
  
  private void postUpdateFocusedState()
  {
    post(this.mUpdateDrawableStateRunnable);
  }
  
  private void rewriteQueryFromSuggestion(int paramInt)
  {
    Editable localEditable = this.mSearchSrcTextView.getText();
    Object localObject = this.mSuggestionsAdapter.c;
    if (localObject != null)
    {
      if (!((Cursor)localObject).moveToPosition(paramInt)) {
        break label55;
      }
      localObject = this.mSuggestionsAdapter.b((Cursor)localObject);
      if (localObject != null) {
        setQuery((CharSequence)localObject);
      }
    }
    else
    {
      return;
    }
    setQuery(localEditable);
    return;
    label55:
    setQuery(localEditable);
  }
  
  private void setQuery(CharSequence paramCharSequence)
  {
    this.mSearchSrcTextView.setText(paramCharSequence);
    SearchView.SearchAutoComplete localSearchAutoComplete = this.mSearchSrcTextView;
    if (!TextUtils.isEmpty(paramCharSequence)) {}
    for (int i = paramCharSequence.length();; i = 0)
    {
      localSearchAutoComplete.setSelection(i);
      return;
    }
  }
  
  private void updateCloseButton()
  {
    int k = 1;
    int j = 0;
    boolean bool = TextUtils.isEmpty(this.mSearchSrcTextView.getText()) ^ true;
    int i = k;
    if (!bool)
    {
      if (!this.mIconifiedByDefault) {
        break label103;
      }
      i = k;
      if (!this.mExpandedInActionView) {}
    }
    label95:
    label103:
    for (i = 0;; i = 0)
    {
      Object localObject = this.mCloseButton;
      if (i == 0) {
        j = 8;
      }
      ((ImageView)localObject).setVisibility(j);
      Drawable localDrawable = this.mCloseButton.getDrawable();
      if (localDrawable != null) {
        if (bool) {
          break label95;
        }
      }
      for (localObject = EMPTY_STATE_SET;; localObject = ENABLED_STATE_SET)
      {
        localDrawable.setState((int[])localObject);
        return;
      }
    }
  }
  
  private void updateQueryHint()
  {
    CharSequence localCharSequence = getQueryHint();
    SearchView.SearchAutoComplete localSearchAutoComplete = this.mSearchSrcTextView;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    localSearchAutoComplete.setHint(getDecoratedHint((CharSequence)localObject));
  }
  
  private void updateSearchAutoComplete()
  {
    int j = 1;
    this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
    this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
    int k = this.mSearchable.getInputType();
    int i = k;
    if ((k & 0xF) == 1)
    {
      k &= 0xFFFEFFFF;
      i = k;
      if (this.mSearchable.getSuggestAuthority() != null) {
        i = k | 0x10000 | 0x80000;
      }
    }
    this.mSearchSrcTextView.setInputType(i);
    Object localObject = this.mSuggestionsAdapter;
    if (localObject != null) {
      ((l)localObject).a(null);
    }
    if (this.mSearchable.getSuggestAuthority() != null)
    {
      this.mSuggestionsAdapter = new gx(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
      this.mSearchSrcTextView.setAdapter(this.mSuggestionsAdapter);
      localObject = (gx)this.mSuggestionsAdapter;
      if (this.mQueryRefinement) {
        break label171;
      }
    }
    label171:
    for (i = j;; i = 2)
    {
      ((gx)localObject).e = i;
      return;
    }
  }
  
  private void updateSubmitArea()
  {
    int j = 0;
    int i;
    if (isSubmitAreaEnabled())
    {
      i = j;
      if (this.mGoButton.getVisibility() != 0)
      {
        if (this.mVoiceButton.getVisibility() != 0) {
          break label42;
        }
        i = j;
      }
    }
    for (;;)
    {
      this.mSubmitArea.setVisibility(i);
      return;
      label42:
      i = 8;
      continue;
      i = 8;
    }
  }
  
  private void updateSubmitButton(boolean paramBoolean)
  {
    int j = 8;
    int i = j;
    if (this.mSubmitButtonEnabled)
    {
      i = j;
      if (isSubmitAreaEnabled())
      {
        if (hasFocus()) {
          break label39;
        }
        i = j;
      }
    }
    for (;;)
    {
      this.mGoButton.setVisibility(i);
      return;
      label39:
      if (!paramBoolean)
      {
        i = j;
        if (!this.mVoiceButtonEnabled) {
          i = 0;
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private void updateViewsVisibility(boolean paramBoolean)
  {
    int j = 8;
    this.mIconified = paramBoolean;
    if (!paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      boolean bool = TextUtils.isEmpty(this.mSearchSrcTextView.getText());
      this.mSearchButton.setVisibility(i);
      updateSubmitButton(bool ^ true);
      View localView = this.mSearchEditFrame;
      if (!paramBoolean) {}
      for (i = 0;; i = 8)
      {
        localView.setVisibility(i);
        i = j;
        if (this.mCollapsedIcon.getDrawable() != null)
        {
          i = j;
          if (!this.mIconifiedByDefault) {
            i = 0;
          }
        }
        this.mCollapsedIcon.setVisibility(i);
        updateCloseButton();
        updateVoiceButton(bool);
        updateSubmitArea();
        return;
      }
    }
  }
  
  private void updateVoiceButton(boolean paramBoolean)
  {
    int j = 8;
    int i = j;
    if (this.mVoiceButtonEnabled)
    {
      if (!isIconified()) {
        break label30;
      }
      i = j;
    }
    for (;;)
    {
      this.mVoiceButton.setVisibility(i);
      return;
      label30:
      i = j;
      if (paramBoolean)
      {
        this.mGoButton.setVisibility(8);
        i = 0;
      }
    }
  }
  
  void adjustDropDownSizeAndPosition()
  {
    Resources localResources;
    int k;
    Rect localRect;
    boolean bool;
    if (this.mDropDownAnchor.getWidth() > 1)
    {
      localResources = getContext().getResources();
      k = this.mSearchPlate.getPaddingLeft();
      localRect = new Rect();
      bool = id.a(this);
      if (!this.mIconifiedByDefault) {
        break label157;
      }
      i = localResources.getDimensionPixelSize(2131165225);
    }
    label157:
    for (int i = localResources.getDimensionPixelSize(2131165226) + i;; i = 0)
    {
      this.mSearchSrcTextView.getDropDownBackground().getPadding(localRect);
      if (bool) {}
      for (int j = -localRect.left;; j = k - (localRect.left + i))
      {
        this.mSearchSrcTextView.setDropDownHorizontalOffset(j);
        j = this.mDropDownAnchor.getWidth();
        int m = localRect.left;
        int n = localRect.right;
        this.mSearchSrcTextView.setDropDownWidth(i + (j + m + n) - k);
        return;
      }
    }
  }
  
  public void clearFocus()
  {
    this.mClearingFocus = true;
    super.clearFocus();
    this.mSearchSrcTextView.clearFocus();
    this.mSearchSrcTextView.a(false);
    this.mClearingFocus = false;
  }
  
  void forceSuggestionQuery()
  {
    Object localObject = HIDDEN_METHOD_INVOKER;
    SearchView.SearchAutoComplete localSearchAutoComplete = this.mSearchSrcTextView;
    localObject = ((gp)localObject).b;
    if (localObject != null) {}
    try
    {
      ((Method)localObject).invoke(localSearchAutoComplete, new Object[0]);
      localObject = HIDDEN_METHOD_INVOKER;
      localSearchAutoComplete = this.mSearchSrcTextView;
      localObject = ((gp)localObject).a;
      if (localObject != null) {}
      try
      {
        ((Method)localObject).invoke(localSearchAutoComplete, new Object[0]);
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public int getImeOptions()
  {
    return this.mSearchSrcTextView.getImeOptions();
  }
  
  public int getInputType()
  {
    return this.mSearchSrcTextView.getInputType();
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public CharSequence getQuery()
  {
    return this.mSearchSrcTextView.getText();
  }
  
  public CharSequence getQueryHint()
  {
    CharSequence localCharSequence = this.mQueryHint;
    Object localObject = localCharSequence;
    if (localCharSequence == null)
    {
      localObject = this.mSearchable;
      if ((localObject != null) && (((SearchableInfo)localObject).getHintId() != 0)) {
        localObject = getContext().getText(this.mSearchable.getHintId());
      }
    }
    else
    {
      return (CharSequence)localObject;
    }
    return this.mDefaultQueryHint;
  }
  
  int getSuggestionCommitIconResId()
  {
    return this.mSuggestionCommitIconResId;
  }
  
  int getSuggestionRowLayout()
  {
    return this.mSuggestionRowLayout;
  }
  
  public l getSuggestionsAdapter()
  {
    return this.mSuggestionsAdapter;
  }
  
  public boolean isIconfiedByDefault()
  {
    return this.mIconifiedByDefault;
  }
  
  public boolean isIconified()
  {
    return this.mIconified;
  }
  
  public boolean isQueryRefinementEnabled()
  {
    return this.mQueryRefinement;
  }
  
  public boolean isSubmitButtonEnabled()
  {
    return this.mSubmitButtonEnabled;
  }
  
  void launchQuerySearch(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = createIntent("android.intent.action.SEARCH", null, null, paramString2, paramInt, paramString1);
    getContext().startActivity(paramString1);
  }
  
  public void onActionViewCollapsed()
  {
    setQuery("", false);
    clearFocus();
    updateViewsVisibility(true);
    this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
    this.mExpandedInActionView = false;
  }
  
  public void onActionViewExpanded()
  {
    if (!this.mExpandedInActionView)
    {
      this.mExpandedInActionView = true;
      this.mCollapsedImeOptions = this.mSearchSrcTextView.getImeOptions();
      this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions | 0x2000000);
      this.mSearchSrcTextView.setText("");
      setIconified(false);
    }
  }
  
  void onCloseClicked()
  {
    if (TextUtils.isEmpty(this.mSearchSrcTextView.getText()))
    {
      if (this.mIconifiedByDefault)
      {
        gq localgq = this.mOnCloseListener;
        if ((localgq == null) || (!localgq.a()))
        {
          clearFocus();
          updateViewsVisibility(true);
        }
      }
      return;
    }
    this.mSearchSrcTextView.setText("");
    this.mSearchSrcTextView.requestFocus();
    this.mSearchSrcTextView.a(true);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.mUpdateDrawableStateRunnable);
    post(this.mReleaseCursorRunnable);
    super.onDetachedFromWindow();
  }
  
  boolean onItemClicked(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = false;
    paramString = this.mOnSuggestionListener;
    if ((paramString == null) || (!paramString.b()))
    {
      launchSuggestion(paramInt1, 0, null);
      this.mSearchSrcTextView.a(false);
      dismissSuggestions();
      bool = true;
    }
    return bool;
  }
  
  boolean onItemSelected(int paramInt)
  {
    gs localgs = this.mOnSuggestionListener;
    if ((localgs == null) || (!localgs.a()))
    {
      rewriteQueryFromSuggestion(paramInt);
      return true;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    gv localgv;
    if (paramBoolean)
    {
      getChildBoundsWithinSearchView(this.mSearchSrcTextView, this.mSearchSrcTextViewBounds);
      this.mSearchSrtTextViewBoundsExpanded.set(this.mSearchSrcTextViewBounds.left, 0, this.mSearchSrcTextViewBounds.right, paramInt4 - paramInt2);
      localgv = this.mTouchDelegate;
      if (localgv == null)
      {
        this.mTouchDelegate = new gv(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, this.mSearchSrcTextView);
        setTouchDelegate(this.mTouchDelegate);
      }
    }
    else
    {
      return;
    }
    localgv.a(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (isIconified())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    switch (j)
    {
    default: 
      paramInt1 = i;
    }
    for (;;)
    {
      i = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      switch (i)
      {
      }
      for (;;)
      {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
        return;
        paramInt2 = Math.min(getPreferredHeight(), paramInt2);
        continue;
        paramInt2 = getPreferredHeight();
      }
      paramInt1 = this.mMaxWidth;
      if (paramInt1 > 0)
      {
        paramInt1 = Math.min(paramInt1, i);
      }
      else
      {
        paramInt1 = Math.min(getPreferredWidth(), i);
        continue;
        j = this.mMaxWidth;
        paramInt1 = i;
        if (j > 0)
        {
          paramInt1 = Math.min(j, i);
          continue;
          i = this.mMaxWidth;
          paramInt1 = i;
          if (i <= 0) {
            paramInt1 = getPreferredWidth();
          }
        }
      }
    }
  }
  
  void onQueryRefine(CharSequence paramCharSequence)
  {
    setQuery(paramCharSequence);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SearchView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SearchView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.e);
    updateViewsVisibility(paramParcelable.a);
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SearchView.SavedState localSavedState = new SearchView.SavedState(super.onSaveInstanceState());
    localSavedState.a = isIconified();
    return localSavedState;
  }
  
  void onSearchClicked()
  {
    updateViewsVisibility(false);
    this.mSearchSrcTextView.requestFocus();
    this.mSearchSrcTextView.a(true);
    View.OnClickListener localOnClickListener = this.mOnSearchClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this);
    }
  }
  
  void onSubmitQuery()
  {
    Editable localEditable = this.mSearchSrcTextView.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0))
    {
      gr localgr = this.mOnQueryChangeListener;
      if (localgr != null)
      {
        localEditable.toString();
        if (localgr.a()) {}
      }
      else
      {
        if (this.mSearchable != null) {
          launchQuerySearch(0, null, localEditable.toString());
        }
        this.mSearchSrcTextView.a(false);
        dismissSuggestions();
      }
    }
  }
  
  boolean onSuggestionsKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mSearchable != null)
    {
      bool1 = bool2;
      if (this.mSuggestionsAdapter != null)
      {
        bool1 = bool2;
        if (paramKeyEvent.getAction() == 0)
        {
          bool1 = bool2;
          if (paramKeyEvent.hasNoModifiers())
          {
            if ((paramInt != 66) && (paramInt != 84) && (paramInt != 61)) {
              break label83;
            }
            bool1 = onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, null);
          }
        }
      }
    }
    label83:
    do
    {
      do
      {
        return bool1;
        if ((paramInt == 21) || (paramInt == 22)) {
          break;
        }
        bool1 = bool2;
      } while (paramInt != 19);
      bool1 = bool2;
    } while (this.mSearchSrcTextView.getListSelection() == 0);
    return false;
    if (paramInt != 21) {}
    for (paramInt = this.mSearchSrcTextView.length();; paramInt = 0)
    {
      this.mSearchSrcTextView.setSelection(paramInt);
      this.mSearchSrcTextView.setListSelection(0);
      this.mSearchSrcTextView.clearListSelection();
      HIDDEN_METHOD_INVOKER.a(this.mSearchSrcTextView);
      return true;
    }
  }
  
  void onTextChanged(CharSequence paramCharSequence)
  {
    Object localObject = this.mSearchSrcTextView.getText();
    this.mUserQuery = ((CharSequence)localObject);
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    updateSubmitButton(bool ^ true);
    updateVoiceButton(bool);
    updateCloseButton();
    updateSubmitArea();
    if ((this.mOnQueryChangeListener != null) && (!TextUtils.equals(paramCharSequence, this.mOldQueryText)))
    {
      localObject = this.mOnQueryChangeListener;
      paramCharSequence.toString();
      ((gr)localObject).b();
    }
    this.mOldQueryText = paramCharSequence.toString();
  }
  
  void onTextFocusChanged()
  {
    updateViewsVisibility(isIconified());
    postUpdateFocusedState();
    if (this.mSearchSrcTextView.hasFocus()) {
      forceSuggestionQuery();
    }
  }
  
  void onVoiceClicked()
  {
    Object localObject = this.mSearchable;
    if (localObject != null) {
      try
      {
        if (!((SearchableInfo)localObject).getVoiceSearchLaunchWebSearch())
        {
          if (((SearchableInfo)localObject).getVoiceSearchLaunchRecognizer())
          {
            localObject = createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, (SearchableInfo)localObject);
            getContext().startActivity((Intent)localObject);
          }
        }
        else
        {
          localObject = createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, (SearchableInfo)localObject);
          getContext().startActivity((Intent)localObject);
          return;
        }
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        Log.w("SearchView", "Could not find voice search activity");
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    postUpdateFocusedState();
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (!this.mClearingFocus)
    {
      if (isFocusable())
      {
        if (!isIconified())
        {
          boolean bool = this.mSearchSrcTextView.requestFocus(paramInt, paramRect);
          if (bool) {
            updateViewsVisibility(false);
          }
          return bool;
        }
        return super.requestFocus(paramInt, paramRect);
      }
      return false;
    }
    return false;
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.mAppSearchData = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      onSearchClicked();
      return;
    }
    onCloseClicked();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.mIconifiedByDefault != paramBoolean)
    {
      this.mIconifiedByDefault = paramBoolean;
      updateViewsVisibility(paramBoolean);
      updateQueryHint();
    }
  }
  
  public void setImeOptions(int paramInt)
  {
    this.mSearchSrcTextView.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    this.mSearchSrcTextView.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(gq paramgq)
  {
    this.mOnCloseListener = paramgq;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mOnQueryTextFocusChangeListener = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(gr paramgr)
  {
    this.mOnQueryChangeListener = paramgr;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnSearchClickListener = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(gs paramgs)
  {
    this.mOnSuggestionListener = paramgs;
  }
  
  public void setQuery(CharSequence paramCharSequence, boolean paramBoolean)
  {
    this.mSearchSrcTextView.setText(paramCharSequence);
    if (paramCharSequence != null)
    {
      SearchView.SearchAutoComplete localSearchAutoComplete = this.mSearchSrcTextView;
      localSearchAutoComplete.setSelection(localSearchAutoComplete.length());
      this.mUserQuery = paramCharSequence;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramCharSequence))) {
      onSubmitQuery();
    }
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    this.mQueryHint = paramCharSequence;
    updateQueryHint();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.mQueryRefinement = paramBoolean;
    Object localObject = this.mSuggestionsAdapter;
    if ((localObject instanceof gx))
    {
      localObject = (gx)localObject;
      if (paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 1;; i = 2)
    {
      ((gx)localObject).e = i;
      return;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    this.mSearchable = paramSearchableInfo;
    if (this.mSearchable != null)
    {
      updateSearchAutoComplete();
      updateQueryHint();
    }
    this.mVoiceButtonEnabled = hasVoiceSearch();
    if (this.mVoiceButtonEnabled) {
      this.mSearchSrcTextView.setPrivateImeOptions("nm");
    }
    updateViewsVisibility(isIconified());
  }
  
  public void setSubmitButtonEnabled(boolean paramBoolean)
  {
    this.mSubmitButtonEnabled = paramBoolean;
    updateViewsVisibility(isIconified());
  }
  
  public void setSuggestionsAdapter(l paraml)
  {
    this.mSuggestionsAdapter = paraml;
    this.mSearchSrcTextView.setAdapter(this.mSuggestionsAdapter);
  }
  
  void updateFocusedState()
  {
    if (!this.mSearchSrcTextView.hasFocus()) {}
    for (int[] arrayOfInt = EMPTY_STATE_SET;; arrayOfInt = FOCUSED_STATE_SET)
    {
      Drawable localDrawable = this.mSearchPlate.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      localDrawable = this.mSubmitArea.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      invalidate();
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/SearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */