package com.android.ex.editstyledtext;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.NoCopySpan.Concrete;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.ArrowKeyMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EditStyledText
  extends EditText
{
  private static final boolean DBG = true;
  public static final int DEFAULT_FOREGROUND_COLOR = -16777216;
  public static final int DEFAULT_TRANSPARENT_COLOR = 16777215;
  public static final int HINT_MSG_BIG_SIZE_ERROR = 5;
  public static final int HINT_MSG_COPY_BUF_BLANK = 1;
  public static final int HINT_MSG_END_COMPOSE = 7;
  public static final int HINT_MSG_END_PREVIEW = 6;
  public static final int HINT_MSG_NULL = 0;
  public static final int HINT_MSG_PUSH_COMPETE = 4;
  public static final int HINT_MSG_SELECT_END = 3;
  public static final int HINT_MSG_SELECT_START = 2;
  private static final int ID_CLEARSTYLES = 16776962;
  private static final int ID_COPY = 16908321;
  private static final int ID_CUT = 16908320;
  private static final int ID_HIDEEDIT = 16776964;
  private static final int ID_HORIZONTALLINE = 16776961;
  private static final int ID_PASTE = 16908322;
  private static final int ID_SELECT_ALL = 16908319;
  private static final int ID_SHOWEDIT = 16776963;
  private static final int ID_START_SELECTING_TEXT = 16908328;
  private static final int ID_STOP_SELECTING_TEXT = 16908329;
  public static final char IMAGECHAR = '￼';
  private static final int MAXIMAGEWIDTHDIP = 300;
  public static final int MODE_ALIGN = 6;
  public static final int MODE_BGCOLOR = 16;
  public static final int MODE_CANCEL = 18;
  public static final int MODE_CLEARSTYLES = 14;
  public static final int MODE_COLOR = 4;
  public static final int MODE_COPY = 1;
  public static final int MODE_CUT = 7;
  public static final int MODE_END_EDIT = 21;
  public static final int MODE_HORIZONTALLINE = 12;
  public static final int MODE_IMAGE = 15;
  public static final int MODE_MARQUEE = 10;
  public static final int MODE_NOTHING = 0;
  public static final int MODE_PASTE = 2;
  public static final int MODE_PREVIEW = 17;
  public static final int MODE_RESET = 22;
  public static final int MODE_SELECT = 5;
  public static final int MODE_SELECTALL = 11;
  public static final int MODE_SHOW_MENU = 23;
  public static final int MODE_SIZE = 3;
  public static final int MODE_START_EDIT = 20;
  public static final int MODE_STOP_SELECT = 13;
  public static final int MODE_SWING = 9;
  public static final int MODE_TELOP = 8;
  public static final int MODE_TEXTVIEWFUNCTION = 19;
  private static final int PRESSED = 16777233;
  private static final NoCopySpan.Concrete SELECTING = new NoCopySpan.Concrete();
  public static final int STATE_SELECTED = 2;
  public static final int STATE_SELECT_FIX = 3;
  public static final int STATE_SELECT_OFF = 0;
  public static final int STATE_SELECT_ON = 1;
  private static CharSequence STR_CLEARSTYLES;
  private static CharSequence STR_HORIZONTALLINE;
  private static CharSequence STR_PASTE;
  private static final String TAG = "EditStyledText";
  public static final char ZEROWIDTHCHAR = '⁠';
  private StyledTextConverter mConverter;
  private Drawable mDefaultBackground;
  private StyledTextDialog mDialog;
  private ArrayList<EditStyledTextNotifier> mESTNotifiers;
  private InputConnection mInputConnection;
  private EditorManager mManager;
  private float mPaddingScale = 0.0F;
  
  public EditStyledText(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public EditStyledText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public EditStyledText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void cancelViewManagers()
  {
    if (this.mESTNotifiers != null)
    {
      Iterator localIterator = this.mESTNotifiers.iterator();
      while (localIterator.hasNext()) {
        ((EditStyledTextNotifier)localIterator.next()).cancelViewManager();
      }
    }
  }
  
  private int dipToPx(int paramInt)
  {
    if (this.mPaddingScale <= 0.0F) {
      this.mPaddingScale = getContext().getResources().getDisplayMetrics().density;
    }
    return (int)(paramInt * getPaddingScale() + 0.5D);
  }
  
  private void finishComposingText()
  {
    if ((this.mInputConnection != null) && (!this.mManager.mTextIsFinishedFlag))
    {
      this.mInputConnection.finishComposingText();
      EditorManager.access$202(this.mManager, true);
    }
  }
  
  private int getMaxImageWidthDip()
  {
    return 300;
  }
  
  private int getMaxImageWidthPx()
  {
    return dipToPx(300);
  }
  
  private float getPaddingScale()
  {
    if (this.mPaddingScale <= 0.0F) {
      this.mPaddingScale = getContext().getResources().getDisplayMetrics().density;
    }
    return this.mPaddingScale;
  }
  
  private void init()
  {
    this.mConverter = new StyledTextConverter(this, new StyledTextHtmlStandard(null));
    this.mDialog = new StyledTextDialog(this);
    this.mManager = new EditorManager(this, this.mDialog);
    setMovementMethod(new StyledTextArrowKeyMethod(this.mManager));
    this.mDefaultBackground = getBackground();
    requestFocus();
  }
  
  private void notifyStateChanged(int paramInt1, int paramInt2)
  {
    if (this.mESTNotifiers != null)
    {
      Iterator localIterator = this.mESTNotifiers.iterator();
      while (localIterator.hasNext()) {
        ((EditStyledTextNotifier)localIterator.next()).onStateChanged(paramInt1, paramInt2);
      }
    }
  }
  
  private void onRefreshStyles()
  {
    this.mManager.onRefreshStyles();
  }
  
  private void onRefreshZeoWidthChar()
  {
    this.mManager.onRefreshZeoWidthChar();
  }
  
  private void sendHintMessage(int paramInt)
  {
    if (this.mESTNotifiers != null)
    {
      Iterator localIterator = this.mESTNotifiers.iterator();
      while (localIterator.hasNext()) {
        ((EditStyledTextNotifier)localIterator.next()).sendHintMsg(paramInt);
      }
    }
  }
  
  private void sendOnTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mESTNotifiers != null)
    {
      Iterator localIterator = this.mESTNotifiers.iterator();
      while (localIterator.hasNext()) {
        ((EditStyledTextNotifier)localIterator.next()).sendOnTouchEvent(paramMotionEvent);
      }
    }
  }
  
  private void showInsertImageSelectAlertDialog()
  {
    if (this.mESTNotifiers != null)
    {
      Iterator localIterator = this.mESTNotifiers.iterator();
      while ((localIterator.hasNext()) && (!((EditStyledTextNotifier)localIterator.next()).showInsertImageSelectAlertDialog())) {}
    }
  }
  
  private void showMenuAlertDialog()
  {
    if (this.mESTNotifiers != null)
    {
      Iterator localIterator = this.mESTNotifiers.iterator();
      while ((localIterator.hasNext()) && (!((EditStyledTextNotifier)localIterator.next()).showMenuAlertDialog())) {}
    }
  }
  
  private void showPreview()
  {
    if (this.mESTNotifiers != null)
    {
      Iterator localIterator = this.mESTNotifiers.iterator();
      while ((localIterator.hasNext()) && (!((EditStyledTextNotifier)localIterator.next()).showPreview())) {}
    }
  }
  
  private static void startSelecting(View paramView, Spannable paramSpannable)
  {
    paramSpannable.setSpan(SELECTING, 0, 0, 16777233);
  }
  
  private static void stopSelecting(View paramView, Spannable paramSpannable)
  {
    paramSpannable.removeSpan(SELECTING);
  }
  
  public void addAction(int paramInt, EditStyledText.EditModeActions.EditModeActionBase paramEditModeActionBase)
  {
    this.mManager.addAction(paramInt, paramEditModeActionBase);
  }
  
  public void addEditStyledTextListener(EditStyledTextNotifier paramEditStyledTextNotifier)
  {
    if (this.mESTNotifiers == null) {
      this.mESTNotifiers = new ArrayList();
    }
    this.mESTNotifiers.add(paramEditStyledTextNotifier);
  }
  
  public void addInputExtra(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = super.getInputExtras(paramBoolean);
    if (localBundle != null) {
      localBundle.putBoolean(paramString, true);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mManager != null) {
      this.mManager.onRefreshStyles();
    }
  }
  
  public int getBackgroundColor()
  {
    return this.mManager.getBackgroundColor();
  }
  
  public int getEditMode()
  {
    return this.mManager.getEditMode();
  }
  
  public EditorManager getEditStyledTextManager()
  {
    return this.mManager;
  }
  
  public int getForegroundColor(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > getText().length())) {}
    ForegroundColorSpan[] arrayOfForegroundColorSpan;
    do
    {
      return -16777216;
      arrayOfForegroundColorSpan = (ForegroundColorSpan[])getText().getSpans(paramInt, paramInt, ForegroundColorSpan.class);
    } while (arrayOfForegroundColorSpan.length <= 0);
    return arrayOfForegroundColorSpan[0].getForegroundColor();
  }
  
  public String getHtml()
  {
    return this.mConverter.getHtml(true);
  }
  
  public String getHtml(ArrayList<Uri> paramArrayList, boolean paramBoolean)
  {
    this.mConverter.getUriArray(paramArrayList, getText());
    return this.mConverter.getHtml(paramBoolean);
  }
  
  public String getHtml(boolean paramBoolean)
  {
    return this.mConverter.getHtml(paramBoolean);
  }
  
  public String getPreviewHtml()
  {
    return this.mConverter.getPreviewHtml();
  }
  
  public int getSelectState()
  {
    return this.mManager.getSelectState();
  }
  
  public boolean isButtonsFocused()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.mESTNotifiers != null)
    {
      Iterator localIterator = this.mESTNotifiers.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
        bool1 |= ((EditStyledTextNotifier)localIterator.next()).isButtonsFocused();
      }
    }
    return bool2;
  }
  
  public boolean isEditting()
  {
    return this.mManager.isEditting();
  }
  
  public boolean isSoftKeyBlocked()
  {
    return this.mManager.isSoftKeyBlocked();
  }
  
  public boolean isStyledText()
  {
    return this.mManager.isStyledText();
  }
  
  public void onBlockSoftKey()
  {
    this.mManager.blockSoftKey();
  }
  
  public void onCancelViewManagers()
  {
    this.mManager.onCancelViewManagers();
  }
  
  public void onClearStyles()
  {
    this.mManager.onClearStyles();
  }
  
  protected void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    super.onCreateContextMenu(paramContextMenu);
    MenuHandler localMenuHandler = new MenuHandler(null);
    if (STR_HORIZONTALLINE != null) {
      paramContextMenu.add(0, 16776961, 0, STR_HORIZONTALLINE).setOnMenuItemClickListener(localMenuHandler);
    }
    if ((isStyledText()) && (STR_CLEARSTYLES != null)) {
      paramContextMenu.add(0, 16776962, 0, STR_CLEARSTYLES).setOnMenuItemClickListener(localMenuHandler);
    }
    if (this.mManager.canPaste()) {
      paramContextMenu.add(0, 16908322, 0, STR_PASTE).setOnMenuItemClickListener(localMenuHandler).setAlphabeticShortcut('v');
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    this.mInputConnection = new StyledTextInputConnection(super.onCreateInputConnection(paramEditorInfo), this);
    return this.mInputConnection;
  }
  
  public void onEndEdit()
  {
    this.mManager.onAction(21);
  }
  
  public void onFixSelectedItem()
  {
    this.mManager.onFixSelectedItem();
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (paramBoolean) {
      onStartEdit();
    }
    while (isButtonsFocused()) {
      return;
    }
    onEndEdit();
  }
  
  public void onInsertHorizontalLine()
  {
    this.mManager.onAction(12);
  }
  
  public void onInsertImage()
  {
    this.mManager.onAction(15);
  }
  
  public void onInsertImage(int paramInt)
  {
    this.mManager.onInsertImage(paramInt);
  }
  
  public void onInsertImage(Uri paramUri)
  {
    this.mManager.onInsertImage(paramUri);
  }
  
  public void onResetEdit()
  {
    this.mManager.onAction(22);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedStyledTextState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedStyledTextState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setBackgroundColor(paramParcelable.mBackgroundColor);
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedStyledTextState localSavedStyledTextState = new SavedStyledTextState(super.onSaveInstanceState());
    localSavedStyledTextState.mBackgroundColor = this.mManager.getBackgroundColor();
    return localSavedStyledTextState;
  }
  
  public void onStartAction(int paramInt, boolean paramBoolean)
  {
    this.mManager.onAction(paramInt, paramBoolean);
  }
  
  public void onStartAlign()
  {
    this.mManager.onAction(6);
  }
  
  public void onStartBackgroundColor()
  {
    this.mManager.onAction(16);
  }
  
  public void onStartColor()
  {
    this.mManager.onAction(4);
  }
  
  public void onStartCopy()
  {
    this.mManager.onAction(1);
  }
  
  public void onStartCut()
  {
    this.mManager.onAction(7);
  }
  
  public void onStartEdit()
  {
    this.mManager.onAction(20);
  }
  
  public void onStartMarquee()
  {
    this.mManager.onAction(10);
  }
  
  public void onStartPaste()
  {
    this.mManager.onAction(2);
  }
  
  public void onStartSelect()
  {
    this.mManager.onStartSelect(true);
  }
  
  public void onStartSelectAll()
  {
    this.mManager.onStartSelectAll(true);
  }
  
  public void onStartShowMenuAlertDialog()
  {
    this.mManager.onStartShowMenuAlertDialog();
  }
  
  public void onStartShowPreview()
  {
    this.mManager.onAction(17);
  }
  
  public void onStartSize()
  {
    this.mManager.onAction(3);
  }
  
  public void onStartSwing()
  {
    this.mManager.onAction(9);
  }
  
  public void onStartTelop()
  {
    this.mManager.onAction(8);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mManager != null)
    {
      this.mManager.updateSpanNextToCursor(getText(), paramInt1, paramInt2, paramInt3);
      this.mManager.updateSpanPreviousFromCursor(getText(), paramInt1, paramInt2, paramInt3);
      if (paramInt3 <= paramInt2) {
        break label92;
      }
      this.mManager.setTextComposingMask(paramInt1, paramInt1 + paramInt3);
      if (this.mManager.isWaitInput())
      {
        if (paramInt3 <= paramInt2) {
          break label108;
        }
        this.mManager.onCursorMoved();
        onFixSelectedItem();
      }
    }
    for (;;)
    {
      super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      return;
      label92:
      if (paramInt2 >= paramInt3) {
        break;
      }
      this.mManager.unsetTextComposingMask();
      break;
      label108:
      if (paramInt3 < paramInt2) {
        this.mManager.onAction(22);
      }
    }
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    int i;
    if (getSelectionStart() != getSelectionEnd()) {
      i = 1;
    }
    switch (paramInt)
    {
    default: 
    case 16908319: 
    case 16908328: 
    case 16908329: 
      for (;;)
      {
        return super.onTextContextMenuItem(paramInt);
        i = 0;
        break;
        onStartSelectAll();
        return true;
        onStartSelect();
        this.mManager.blockSoftKey();
        continue;
        onFixSelectedItem();
      }
    case 16908322: 
      onStartPaste();
      return true;
    case 16908321: 
      if (i != 0)
      {
        onStartCopy();
        return true;
      }
      this.mManager.onStartSelectAll(false);
      onStartCopy();
      return true;
    case 16908320: 
      if (i != 0)
      {
        onStartCut();
        return true;
      }
      this.mManager.onStartSelectAll(false);
      onStartCut();
      return true;
    case 16776961: 
      onInsertHorizontalLine();
      return true;
    case 16776962: 
      onClearStyles();
      return true;
    case 16776963: 
      onStartEdit();
      return true;
    }
    onEndEdit();
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    int j;
    boolean bool1;
    if (paramMotionEvent.getAction() == 1)
    {
      cancelLongPress();
      boolean bool2 = isEditting();
      if (!bool2) {
        onStartEdit();
      }
      i = Selection.getSelectionStart(getText());
      j = Selection.getSelectionEnd(getText());
      bool1 = super.onTouchEvent(paramMotionEvent);
      if ((isFocused()) && (getSelectState() == 0))
      {
        if (bool2) {
          this.mManager.showSoftKey(Selection.getSelectionStart(getText()), Selection.getSelectionEnd(getText()));
        }
      }
      else
      {
        this.mManager.onCursorMoved();
        this.mManager.unsetTextComposingMask();
      }
    }
    for (;;)
    {
      sendOnTouchEvent(paramMotionEvent);
      return bool1;
      this.mManager.showSoftKey(i, j);
      break;
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
  }
  
  public void onUnblockSoftKey()
  {
    this.mManager.unblockSoftKey();
  }
  
  public void removeEditStyledTextListener(EditStyledTextNotifier paramEditStyledTextNotifier)
  {
    if (this.mESTNotifiers != null)
    {
      int i = this.mESTNotifiers.indexOf(paramEditStyledTextNotifier);
      if (i > 0) {
        this.mESTNotifiers.remove(i);
      }
    }
  }
  
  public void setAlignAlertParams(CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence)
  {
    this.mDialog.setAlignAlertParams(paramCharSequence, paramArrayOfCharSequence);
  }
  
  public void setAlignment(Layout.Alignment paramAlignment)
  {
    this.mManager.setAlignment(paramAlignment);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (paramInt != 16777215) {
      super.setBackgroundColor(paramInt);
    }
    for (;;)
    {
      this.mManager.setBackgroundColor(paramInt);
      onRefreshStyles();
      return;
      setBackgroundDrawable(this.mDefaultBackground);
    }
  }
  
  public void setBuilder(AlertDialog.Builder paramBuilder)
  {
    this.mDialog.setBuilder(paramBuilder);
  }
  
  public void setColorAlertParams(CharSequence paramCharSequence1, CharSequence[] paramArrayOfCharSequence1, CharSequence[] paramArrayOfCharSequence2, CharSequence paramCharSequence2)
  {
    this.mDialog.setColorAlertParams(paramCharSequence1, paramArrayOfCharSequence1, paramArrayOfCharSequence2, paramCharSequence2);
  }
  
  public void setContextMenuStrings(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    STR_HORIZONTALLINE = paramCharSequence1;
    STR_CLEARSTYLES = paramCharSequence2;
    STR_PASTE = paramCharSequence3;
  }
  
  public void setHtml(String paramString)
  {
    this.mConverter.SetHtml(paramString);
  }
  
  public void setItemColor(int paramInt)
  {
    this.mManager.setItemColor(paramInt, true);
  }
  
  public void setItemSize(int paramInt)
  {
    this.mManager.setItemSize(paramInt, true);
  }
  
  public void setMarquee(int paramInt)
  {
    this.mManager.setMarquee(paramInt);
  }
  
  public void setMarqueeAlertParams(CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence)
  {
    this.mDialog.setMarqueeAlertParams(paramCharSequence, paramArrayOfCharSequence);
  }
  
  public void setSizeAlertParams(CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence1, CharSequence[] paramArrayOfCharSequence2, CharSequence[] paramArrayOfCharSequence3)
  {
    this.mDialog.setSizeAlertParams(paramCharSequence, paramArrayOfCharSequence1, paramArrayOfCharSequence2, paramArrayOfCharSequence3);
  }
  
  public void setStyledTextHtmlConverter(StyledTextHtmlConverter paramStyledTextHtmlConverter)
  {
    this.mConverter.setStyledTextHtmlConverter(paramStyledTextHtmlConverter);
  }
  
  public static class ColorPaletteDrawable
    extends ShapeDrawable
  {
    private Rect mRect;
    
    public ColorPaletteDrawable(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
      this.mRect = new Rect(paramInt4, paramInt4, paramInt2 - paramInt4, paramInt3 - paramInt4);
      getPaint().setColor(paramInt1);
    }
    
    public void draw(Canvas paramCanvas)
    {
      paramCanvas.drawRect(this.mRect, getPaint());
    }
  }
  
  public class EditModeActions
  {
    private static final boolean DBG = true;
    private static final String TAG = "EditModeActions";
    private HashMap<Integer, EditModeActionBase> mActionMap = new HashMap();
    private AlignAction mAlignAction = new AlignAction();
    private BackgroundColorAction mBackgroundColorAction = new BackgroundColorAction();
    private CancelAction mCancelEditAction = new CancelAction();
    private ClearStylesAction mClearStylesAction = new ClearStylesAction();
    private ColorAction mColorAction = new ColorAction();
    private CopyAction mCopyAction = new CopyAction();
    private CutAction mCutAction = new CutAction();
    private EditStyledText.StyledTextDialog mDialog;
    private EditStyledText mEST;
    private EndEditAction mEndEditAction = new EndEditAction();
    private HorizontalLineAction mHorizontalLineAction = new HorizontalLineAction();
    private ImageAction mImageAction = new ImageAction();
    private EditStyledText.EditorManager mManager;
    private MarqueeDialogAction mMarqueeDialogAction = new MarqueeDialogAction();
    private int mMode = 0;
    private NothingAction mNothingAction = new NothingAction();
    private PasteAction mPasteAction = new PasteAction();
    private PreviewAction mPreviewAction = new PreviewAction();
    private ResetAction mResetAction = new ResetAction();
    private SelectAction mSelectAction = new SelectAction();
    private SelectAllAction mSelectAllAction = new SelectAllAction();
    private ShowMenuAction mShowMenuAction = new ShowMenuAction();
    private SizeAction mSizeAction = new SizeAction();
    private StartEditAction mStartEditAction = new StartEditAction();
    private StopSelectionAction mStopSelectionAction = new StopSelectionAction();
    private SwingAction mSwingAction = new SwingAction();
    private TelopAction mTelopAction = new TelopAction();
    private TextViewAction mTextViewAction = new TextViewAction();
    
    EditModeActions(EditStyledText paramEditStyledText, EditStyledText.EditorManager paramEditorManager, EditStyledText.StyledTextDialog paramStyledTextDialog)
    {
      this.mEST = paramEditStyledText;
      this.mManager = paramEditorManager;
      this.mDialog = paramStyledTextDialog;
      this.mActionMap.put(Integer.valueOf(0), this.mNothingAction);
      this.mActionMap.put(Integer.valueOf(1), this.mCopyAction);
      this.mActionMap.put(Integer.valueOf(2), this.mPasteAction);
      this.mActionMap.put(Integer.valueOf(5), this.mSelectAction);
      this.mActionMap.put(Integer.valueOf(7), this.mCutAction);
      this.mActionMap.put(Integer.valueOf(11), this.mSelectAllAction);
      this.mActionMap.put(Integer.valueOf(12), this.mHorizontalLineAction);
      this.mActionMap.put(Integer.valueOf(13), this.mStopSelectionAction);
      this.mActionMap.put(Integer.valueOf(14), this.mClearStylesAction);
      this.mActionMap.put(Integer.valueOf(15), this.mImageAction);
      this.mActionMap.put(Integer.valueOf(16), this.mBackgroundColorAction);
      this.mActionMap.put(Integer.valueOf(17), this.mPreviewAction);
      this.mActionMap.put(Integer.valueOf(18), this.mCancelEditAction);
      this.mActionMap.put(Integer.valueOf(19), this.mTextViewAction);
      this.mActionMap.put(Integer.valueOf(20), this.mStartEditAction);
      this.mActionMap.put(Integer.valueOf(21), this.mEndEditAction);
      this.mActionMap.put(Integer.valueOf(22), this.mResetAction);
      this.mActionMap.put(Integer.valueOf(23), this.mShowMenuAction);
      this.mActionMap.put(Integer.valueOf(6), this.mAlignAction);
      this.mActionMap.put(Integer.valueOf(8), this.mTelopAction);
      this.mActionMap.put(Integer.valueOf(9), this.mSwingAction);
      this.mActionMap.put(Integer.valueOf(10), this.mMarqueeDialogAction);
      this.mActionMap.put(Integer.valueOf(4), this.mColorAction);
      this.mActionMap.put(Integer.valueOf(3), this.mSizeAction);
    }
    
    private EditModeActionBase getAction(int paramInt)
    {
      if (this.mActionMap.containsKey(Integer.valueOf(paramInt))) {
        return (EditModeActionBase)this.mActionMap.get(Integer.valueOf(paramInt));
      }
      return null;
    }
    
    public void addAction(int paramInt, EditModeActionBase paramEditModeActionBase)
    {
      this.mActionMap.put(Integer.valueOf(paramInt), paramEditModeActionBase);
    }
    
    public boolean doNext()
    {
      return doNext(this.mMode);
    }
    
    public boolean doNext(int paramInt)
    {
      Log.d("EditModeActions", "--- do the next action: " + paramInt + "," + this.mManager.getSelectState());
      EditModeActionBase localEditModeActionBase = getAction(paramInt);
      if (localEditModeActionBase == null)
      {
        Log.e("EditModeActions", "--- invalid action error.");
        return false;
      }
      switch (this.mManager.getSelectState())
      {
      default: 
        return false;
      case 0: 
        return localEditModeActionBase.doNotSelected();
      case 1: 
        return localEditModeActionBase.doStartPosIsSelected();
      case 2: 
        return localEditModeActionBase.doEndPosIsSelected();
      }
      if (this.mManager.isWaitInput()) {
        return localEditModeActionBase.doSelectionIsFixedAndWaitingInput();
      }
      return localEditModeActionBase.doSelectionIsFixed();
    }
    
    public void onAction(int paramInt)
    {
      onAction(paramInt, null);
    }
    
    public void onAction(int paramInt, Object paramObject)
    {
      onAction(paramInt, new Object[] { paramObject });
    }
    
    public void onAction(int paramInt, Object[] paramArrayOfObject)
    {
      getAction(paramInt).addParams(paramArrayOfObject);
      this.mMode = paramInt;
      doNext(paramInt);
    }
    
    public void onSelectAction()
    {
      doNext(5);
    }
    
    public class AlignAction
      extends EditStyledText.EditModeActions.SetSpanActionBase
    {
      public AlignAction()
      {
        super();
      }
      
      protected boolean doSelectionIsFixed()
      {
        if (super.doSelectionIsFixed()) {
          return true;
        }
        EditStyledText.StyledTextDialog.access$4600(EditStyledText.EditModeActions.this.mDialog);
        return true;
      }
    }
    
    public class BackgroundColorAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public BackgroundColorAction()
      {
        super();
      }
      
      protected boolean doNotSelected()
      {
        EditStyledText.StyledTextDialog.access$4000(EditStyledText.EditModeActions.this.mDialog);
        return true;
      }
    }
    
    public class CancelAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public CancelAction()
      {
        super();
      }
      
      protected boolean doNotSelected()
      {
        EditStyledText.this.cancelViewManagers();
        return true;
      }
    }
    
    public class ClearStylesAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public ClearStylesAction()
      {
        super();
      }
      
      protected boolean doNotSelected()
      {
        EditStyledText.EditorManager.access$3300(EditStyledText.EditModeActions.this.mManager);
        return true;
      }
    }
    
    public class ColorAction
      extends EditStyledText.EditModeActions.SetSpanActionBase
    {
      public ColorAction()
      {
        super();
      }
      
      protected boolean doSelectionIsFixed()
      {
        if (super.doSelectionIsFixed()) {
          return true;
        }
        EditStyledText.StyledTextDialog.access$4800(EditStyledText.EditModeActions.this.mDialog);
        return true;
      }
      
      protected boolean doSelectionIsFixedAndWaitingInput()
      {
        if (super.doSelectionIsFixedAndWaitingInput()) {
          return true;
        }
        int i = EditStyledText.EditModeActions.this.mManager.getSizeWaitInput();
        EditStyledText.EditModeActions.this.mManager.setItemColor(EditStyledText.EditModeActions.this.mManager.getColorWaitInput(), false);
        if (!EditStyledText.EditModeActions.this.mManager.isWaitInput())
        {
          EditStyledText.EditModeActions.this.mManager.setItemSize(i, false);
          EditStyledText.EditorManager.access$2400(EditStyledText.EditModeActions.this.mManager);
          return true;
        }
        fixSelection();
        EditStyledText.StyledTextDialog.access$4800(EditStyledText.EditModeActions.this.mDialog);
        return true;
      }
    }
    
    public class CopyAction
      extends EditStyledText.EditModeActions.TextViewActionBase
    {
      public CopyAction()
      {
        super();
      }
      
      protected boolean doEndPosIsSelected()
      {
        if (super.doEndPosIsSelected()) {
          return true;
        }
        EditStyledText.EditorManager.access$2500(EditStyledText.EditModeActions.this.mManager);
        EditStyledText.EditorManager.access$2400(EditStyledText.EditModeActions.this.mManager);
        return true;
      }
    }
    
    public class CutAction
      extends EditStyledText.EditModeActions.TextViewActionBase
    {
      public CutAction()
      {
        super();
      }
      
      protected boolean doEndPosIsSelected()
      {
        if (super.doEndPosIsSelected()) {
          return true;
        }
        EditStyledText.EditorManager.access$2600(EditStyledText.EditModeActions.this.mManager);
        EditStyledText.EditorManager.access$2400(EditStyledText.EditModeActions.this.mManager);
        return true;
      }
    }
    
    public class EditModeActionBase
    {
      private Object[] mParams;
      
      public EditModeActionBase() {}
      
      protected void addParams(Object[] paramArrayOfObject)
      {
        this.mParams = paramArrayOfObject;
      }
      
      protected boolean canOverWrap()
      {
        return false;
      }
      
      protected boolean canSelect()
      {
        return false;
      }
      
      protected boolean canWaitInput()
      {
        return false;
      }
      
      protected boolean doEndPosIsSelected()
      {
        return doStartPosIsSelected();
      }
      
      protected boolean doNotSelected()
      {
        return false;
      }
      
      protected boolean doSelectionIsFixed()
      {
        return doEndPosIsSelected();
      }
      
      protected boolean doSelectionIsFixedAndWaitingInput()
      {
        return doEndPosIsSelected();
      }
      
      protected boolean doStartPosIsSelected()
      {
        return doNotSelected();
      }
      
      protected boolean fixSelection()
      {
        EditStyledText.this.finishComposingText();
        EditStyledText.EditorManager.access$2100(EditStyledText.EditModeActions.this.mManager, 3);
        return true;
      }
      
      protected Object getParam(int paramInt)
      {
        if ((this.mParams == null) || (paramInt > this.mParams.length))
        {
          Log.d("EditModeActions", "--- Number of the parameter is out of bound.");
          return null;
        }
        return this.mParams[paramInt];
      }
      
      protected boolean isLine()
      {
        return false;
      }
      
      protected boolean needSelection()
      {
        return false;
      }
    }
    
    public class EndEditAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public EndEditAction()
      {
        super();
      }
      
      protected boolean doNotSelected()
      {
        EditStyledText.EditorManager.access$4300(EditStyledText.EditModeActions.this.mManager);
        return true;
      }
    }
    
    public class HorizontalLineAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public HorizontalLineAction()
      {
        super();
      }
      
      protected boolean doNotSelected()
      {
        EditStyledText.EditorManager.access$3200(EditStyledText.EditModeActions.this.mManager);
        return true;
      }
    }
    
    public class ImageAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public ImageAction()
      {
        super();
      }
      
      protected boolean doNotSelected()
      {
        Object localObject = getParam(0);
        if (localObject != null) {
          if ((localObject instanceof Uri)) {
            EditStyledText.EditorManager.access$3600(EditStyledText.EditModeActions.this.mManager, (Uri)localObject);
          }
        }
        for (;;)
        {
          return true;
          if ((localObject instanceof Integer))
          {
            EditStyledText.EditorManager.access$3700(EditStyledText.EditModeActions.this.mManager, ((Integer)localObject).intValue());
            continue;
            EditStyledText.this.showInsertImageSelectAlertDialog();
          }
        }
      }
    }
    
    public class MarqueeDialogAction
      extends EditStyledText.EditModeActions.SetSpanActionBase
    {
      public MarqueeDialogAction()
      {
        super();
      }
      
      protected boolean doSelectionIsFixed()
      {
        if (super.doSelectionIsFixed()) {
          return true;
        }
        EditStyledText.StyledTextDialog.access$4700(EditStyledText.EditModeActions.this.mDialog);
        return true;
      }
    }
    
    public class NothingAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public NothingAction()
      {
        super();
      }
    }
    
    public class PasteAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public PasteAction()
      {
        super();
      }
      
      protected boolean doNotSelected()
      {
        EditStyledText.EditorManager.access$3000(EditStyledText.EditModeActions.this.mManager);
        EditStyledText.EditorManager.access$2400(EditStyledText.EditModeActions.this.mManager);
        return true;
      }
    }
    
    public class PreviewAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public PreviewAction()
      {
        super();
      }
      
      protected boolean doNotSelected()
      {
        EditStyledText.this.showPreview();
        return true;
      }
    }
    
    public class ResetAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public ResetAction()
      {
        super();
      }
      
      protected boolean doNotSelected()
      {
        EditStyledText.EditorManager.access$2400(EditStyledText.EditModeActions.this.mManager);
        return true;
      }
    }
    
    public class SelectAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public SelectAction()
      {
        super();
      }
      
      protected boolean doNotSelected()
      {
        if (EditStyledText.EditorManager.access$2700(EditStyledText.EditModeActions.this.mManager)) {
          Log.e("EditModeActions", "Selection is off, but selected");
        }
        EditStyledText.EditorManager.access$2800(EditStyledText.EditModeActions.this.mManager);
        EditStyledText.this.sendHintMessage(3);
        return true;
      }
      
      protected boolean doSelectionIsFixed()
      {
        return false;
      }
      
      protected boolean doStartPosIsSelected()
      {
        if (EditStyledText.EditorManager.access$2700(EditStyledText.EditModeActions.this.mManager)) {
          Log.e("EditModeActions", "Selection now start, but selected");
        }
        EditStyledText.EditorManager.access$2900(EditStyledText.EditModeActions.this.mManager);
        EditStyledText.this.sendHintMessage(4);
        if (EditStyledText.EditModeActions.this.mManager.getEditMode() != 5) {
          EditStyledText.EditModeActions.this.doNext(EditStyledText.EditModeActions.this.mManager.getEditMode());
        }
        return true;
      }
    }
    
    public class SelectAllAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public SelectAllAction()
      {
        super();
      }
      
      protected boolean doNotSelected()
      {
        EditStyledText.EditorManager.access$3100(EditStyledText.EditModeActions.this.mManager);
        return true;
      }
    }
    
    public class SetSpanActionBase
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public SetSpanActionBase()
      {
        super();
      }
      
      protected boolean doEndPosIsSelected()
      {
        if ((EditStyledText.EditModeActions.this.mManager.getEditMode() == 0) || (EditStyledText.EditModeActions.this.mManager.getEditMode() == 5))
        {
          EditStyledText.EditorManager.access$2300(EditStyledText.EditModeActions.this.mManager, EditStyledText.EditModeActions.this.mMode);
          fixSelection();
          EditStyledText.EditModeActions.this.doNext();
          return true;
        }
        return doStartPosIsSelected();
      }
      
      protected boolean doNotSelected()
      {
        if ((EditStyledText.EditModeActions.this.mManager.getEditMode() == 0) || (EditStyledText.EditModeActions.this.mManager.getEditMode() == 5))
        {
          EditStyledText.EditorManager.access$2300(EditStyledText.EditModeActions.this.mManager, EditStyledText.EditModeActions.this.mMode);
          EditStyledText.EditorManager.access$4500(EditStyledText.EditModeActions.this.mManager, EditStyledText.this.getSelectionStart(), EditStyledText.this.getSelectionEnd());
          fixSelection();
          EditStyledText.EditModeActions.this.doNext();
          return true;
        }
        if (EditStyledText.EditModeActions.this.mManager.getEditMode() != EditStyledText.EditModeActions.this.mMode)
        {
          Log.d("EditModeActions", "--- setspanactionbase" + EditStyledText.EditModeActions.this.mManager.getEditMode() + "," + EditStyledText.EditModeActions.this.mMode);
          if (!EditStyledText.EditModeActions.this.mManager.isWaitInput())
          {
            EditStyledText.EditorManager.access$2400(EditStyledText.EditModeActions.this.mManager);
            EditStyledText.EditorManager.access$2300(EditStyledText.EditModeActions.this.mManager, EditStyledText.EditModeActions.this.mMode);
          }
          for (;;)
          {
            EditStyledText.EditModeActions.this.doNext();
            return true;
            EditStyledText.EditorManager.access$2300(EditStyledText.EditModeActions.this.mManager, 0);
            EditStyledText.EditorManager.access$2100(EditStyledText.EditModeActions.this.mManager, 0);
          }
        }
        return false;
      }
      
      protected boolean doSelectionIsFixed()
      {
        if (doEndPosIsSelected()) {
          return true;
        }
        EditStyledText.this.sendHintMessage(0);
        return false;
      }
      
      protected boolean doStartPosIsSelected()
      {
        if ((EditStyledText.EditModeActions.this.mManager.getEditMode() == 0) || (EditStyledText.EditModeActions.this.mManager.getEditMode() == 5))
        {
          EditStyledText.EditorManager.access$2300(EditStyledText.EditModeActions.this.mManager, EditStyledText.EditModeActions.this.mMode);
          EditStyledText.EditModeActions.this.onSelectAction();
          return true;
        }
        return doNotSelected();
      }
    }
    
    public class ShowMenuAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public ShowMenuAction()
      {
        super();
      }
      
      protected boolean doNotSelected()
      {
        EditStyledText.this.showMenuAlertDialog();
        return true;
      }
    }
    
    public class SizeAction
      extends EditStyledText.EditModeActions.SetSpanActionBase
    {
      public SizeAction()
      {
        super();
      }
      
      protected boolean doSelectionIsFixed()
      {
        if (super.doSelectionIsFixed()) {
          return true;
        }
        EditStyledText.StyledTextDialog.access$4900(EditStyledText.EditModeActions.this.mDialog);
        return true;
      }
      
      protected boolean doSelectionIsFixedAndWaitingInput()
      {
        if (super.doSelectionIsFixedAndWaitingInput()) {
          return true;
        }
        int i = EditStyledText.EditModeActions.this.mManager.getColorWaitInput();
        EditStyledText.EditModeActions.this.mManager.setItemSize(EditStyledText.EditModeActions.this.mManager.getSizeWaitInput(), false);
        if (!EditStyledText.EditModeActions.this.mManager.isWaitInput())
        {
          EditStyledText.EditModeActions.this.mManager.setItemColor(i, false);
          EditStyledText.EditorManager.access$2400(EditStyledText.EditModeActions.this.mManager);
          return true;
        }
        fixSelection();
        EditStyledText.StyledTextDialog.access$4900(EditStyledText.EditModeActions.this.mDialog);
        return true;
      }
    }
    
    public class StartEditAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public StartEditAction()
      {
        super();
      }
      
      protected boolean doNotSelected()
      {
        EditStyledText.EditorManager.access$4200(EditStyledText.EditModeActions.this.mManager);
        return true;
      }
    }
    
    public class StopSelectionAction
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public StopSelectionAction()
      {
        super();
      }
      
      protected boolean doNotSelected()
      {
        EditStyledText.EditorManager.access$3400(EditStyledText.EditModeActions.this.mManager);
        return true;
      }
    }
    
    public class SwingAction
      extends EditStyledText.EditModeActions.SetSpanActionBase
    {
      public SwingAction()
      {
        super();
      }
      
      protected boolean doSelectionIsFixed()
      {
        if (super.doSelectionIsFixed()) {
          return true;
        }
        EditStyledText.EditModeActions.this.mManager.setSwing();
        return true;
      }
    }
    
    public class TelopAction
      extends EditStyledText.EditModeActions.SetSpanActionBase
    {
      public TelopAction()
      {
        super();
      }
      
      protected boolean doSelectionIsFixed()
      {
        if (super.doSelectionIsFixed()) {
          return true;
        }
        EditStyledText.EditModeActions.this.mManager.setTelop();
        return true;
      }
    }
    
    public class TextViewAction
      extends EditStyledText.EditModeActions.TextViewActionBase
    {
      public TextViewAction()
      {
        super();
      }
      
      protected boolean doEndPosIsSelected()
      {
        if (super.doEndPosIsSelected()) {
          return true;
        }
        Object localObject = getParam(0);
        if ((localObject != null) && ((localObject instanceof Integer))) {
          EditStyledText.this.onTextContextMenuItem(((Integer)localObject).intValue());
        }
        EditStyledText.EditorManager.access$2400(EditStyledText.EditModeActions.this.mManager);
        return true;
      }
    }
    
    public class TextViewActionBase
      extends EditStyledText.EditModeActions.EditModeActionBase
    {
      public TextViewActionBase()
      {
        super();
      }
      
      protected boolean doEndPosIsSelected()
      {
        if ((EditStyledText.EditModeActions.this.mManager.getEditMode() == 0) || (EditStyledText.EditModeActions.this.mManager.getEditMode() == 5))
        {
          EditStyledText.EditorManager.access$2300(EditStyledText.EditModeActions.this.mManager, EditStyledText.EditModeActions.this.mMode);
          fixSelection();
          EditStyledText.EditModeActions.this.doNext();
          return true;
        }
        if (EditStyledText.EditModeActions.this.mManager.getEditMode() != EditStyledText.EditModeActions.this.mMode)
        {
          EditStyledText.EditorManager.access$2400(EditStyledText.EditModeActions.this.mManager);
          EditStyledText.EditorManager.access$2300(EditStyledText.EditModeActions.this.mManager, EditStyledText.EditModeActions.this.mMode);
          EditStyledText.EditModeActions.this.doNext();
          return true;
        }
        return false;
      }
      
      protected boolean doNotSelected()
      {
        if ((EditStyledText.EditModeActions.this.mManager.getEditMode() == 0) || (EditStyledText.EditModeActions.this.mManager.getEditMode() == 5))
        {
          EditStyledText.EditorManager.access$2300(EditStyledText.EditModeActions.this.mManager, EditStyledText.EditModeActions.this.mMode);
          EditStyledText.EditModeActions.this.onSelectAction();
          return true;
        }
        return false;
      }
    }
  }
  
  public static abstract interface EditStyledTextNotifier
  {
    public abstract void cancelViewManager();
    
    public abstract boolean isButtonsFocused();
    
    public abstract void onStateChanged(int paramInt1, int paramInt2);
    
    public abstract void sendHintMsg(int paramInt);
    
    public abstract boolean sendOnTouchEvent(MotionEvent paramMotionEvent);
    
    public abstract boolean showInsertImageSelectAlertDialog();
    
    public abstract boolean showMenuAlertDialog();
    
    public abstract boolean showPreview();
  }
  
  public static class EditStyledTextSpans
  {
    private static final String LOG_TAG = "EditStyledTextSpan";
    
    public static class HorizontalLineDrawable
      extends ShapeDrawable
    {
      private static boolean DBG_HL = false;
      private Spannable mSpannable;
      private int mWidth;
      
      public HorizontalLineDrawable(int paramInt1, int paramInt2, Spannable paramSpannable)
      {
        super();
        this.mSpannable = paramSpannable;
        this.mWidth = paramInt2;
        renewColor(paramInt1);
        renewBounds(paramInt2);
      }
      
      private EditStyledText.EditStyledTextSpans.HorizontalLineSpan getParentSpan()
      {
        Object localObject = this.mSpannable;
        localObject = (EditStyledText.EditStyledTextSpans.HorizontalLineSpan[])((Spannable)localObject).getSpans(0, ((Spannable)localObject).length(), EditStyledText.EditStyledTextSpans.HorizontalLineSpan.class);
        if (localObject.length > 0)
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            EditStyledText.EditStyledTextSpans.HorizontalLineSpan localHorizontalLineSpan = localObject[i];
            if (localHorizontalLineSpan.getDrawable() == this) {
              return localHorizontalLineSpan;
            }
            i += 1;
          }
        }
        Log.e("EditStyledTextSpan", "---renewBounds: Couldn't find");
        return null;
      }
      
      private void renewColor()
      {
        Object localObject = getParentSpan();
        Spannable localSpannable = this.mSpannable;
        localObject = (ForegroundColorSpan[])localSpannable.getSpans(localSpannable.getSpanStart(localObject), localSpannable.getSpanEnd(localObject), ForegroundColorSpan.class);
        if (DBG_HL) {
          Log.d("EditStyledTextSpan", "--- renewColor:" + localObject.length);
        }
        if (localObject.length > 0) {
          renewColor(localObject[(localObject.length - 1)].getForegroundColor());
        }
      }
      
      private void renewColor(int paramInt)
      {
        if (DBG_HL) {
          Log.d("EditStyledTextSpan", "--- renewColor:" + paramInt);
        }
        getPaint().setColor(paramInt);
      }
      
      public void draw(Canvas paramCanvas)
      {
        renewColor();
        paramCanvas.drawRect(new Rect(0, 9, this.mWidth, 11), getPaint());
      }
      
      public void renewBounds(int paramInt)
      {
        if (DBG_HL) {
          Log.d("EditStyledTextSpan", "--- renewBounds:" + paramInt);
        }
        int i = paramInt;
        if (paramInt > 20) {
          i = paramInt - 20;
        }
        this.mWidth = i;
        setBounds(0, 0, i, 20);
      }
    }
    
    public static class HorizontalLineSpan
      extends DynamicDrawableSpan
    {
      EditStyledText.EditStyledTextSpans.HorizontalLineDrawable mDrawable;
      
      public HorizontalLineSpan(int paramInt1, int paramInt2, Spannable paramSpannable)
      {
        super();
        this.mDrawable = new EditStyledText.EditStyledTextSpans.HorizontalLineDrawable(paramInt1, paramInt2, paramSpannable);
      }
      
      public int getColor()
      {
        return this.mDrawable.getPaint().getColor();
      }
      
      public Drawable getDrawable()
      {
        return this.mDrawable;
      }
      
      public void resetWidth(int paramInt)
      {
        this.mDrawable.renewBounds(paramInt);
      }
    }
    
    public static class MarqueeSpan
      extends CharacterStyle
    {
      public static final int ALTERNATE = 1;
      public static final int NOTHING = 2;
      public static final int SCROLL = 0;
      private int mMarqueeColor;
      private int mType;
      
      public MarqueeSpan(int paramInt)
      {
        this(paramInt, 16777215);
      }
      
      public MarqueeSpan(int paramInt1, int paramInt2)
      {
        this.mType = paramInt1;
        checkType(paramInt1);
        this.mMarqueeColor = getMarqueeColor(paramInt1, paramInt2);
      }
      
      private boolean checkType(int paramInt)
      {
        if ((paramInt == 0) || (paramInt == 1)) {
          return true;
        }
        Log.e("EditStyledTextSpan", "--- Invalid type of MarqueeSpan");
        return false;
      }
      
      private int getMarqueeColor(int paramInt1, int paramInt2)
      {
        int m = Color.alpha(paramInt2);
        int j = Color.red(paramInt2);
        int k = Color.green(paramInt2);
        int n = Color.blue(paramInt2);
        int i = m;
        if (m == 0) {
          i = 128;
        }
        switch (paramInt1)
        {
        default: 
          Log.e("EditStyledText", "--- getMarqueeColor: got illigal marquee ID.");
        case 2: 
          return 16777215;
        case 0: 
          if (j > 128)
          {
            paramInt2 = j / 2;
            paramInt1 = k;
          }
          break;
        }
        for (;;)
        {
          return Color.argb(i, paramInt2, paramInt1, n);
          paramInt2 = (255 - j) / 2;
          paramInt1 = k;
          continue;
          if (k > 128)
          {
            paramInt1 = k / 2;
            paramInt2 = j;
          }
          else
          {
            paramInt1 = (255 - k) / 2;
            paramInt2 = j;
          }
        }
      }
      
      public int getType()
      {
        return this.mType;
      }
      
      public void resetColor(int paramInt)
      {
        this.mMarqueeColor = getMarqueeColor(this.mType, paramInt);
      }
      
      public void updateDrawState(TextPaint paramTextPaint)
      {
        paramTextPaint.bgColor = this.mMarqueeColor;
      }
    }
    
    public static class RescalableImageSpan
      extends ImageSpan
    {
      private final int MAXWIDTH;
      Uri mContentUri;
      private Context mContext;
      private Drawable mDrawable;
      public int mIntrinsicHeight = -1;
      public int mIntrinsicWidth = -1;
      
      public RescalableImageSpan(Context paramContext, int paramInt1, int paramInt2)
      {
        super(paramInt1);
        this.mContext = paramContext;
        this.MAXWIDTH = paramInt2;
      }
      
      public RescalableImageSpan(Context paramContext, Uri paramUri, int paramInt)
      {
        super(paramUri);
        this.mContext = paramContext;
        this.mContentUri = paramUri;
        this.MAXWIDTH = paramInt;
      }
      
      private void rescaleBigImage(Drawable paramDrawable)
      {
        Log.d("EditStyledTextSpan", "--- rescaleBigImage:");
        if (this.MAXWIDTH < 0) {
          return;
        }
        int m = paramDrawable.getIntrinsicWidth();
        int k = paramDrawable.getIntrinsicHeight();
        Log.d("EditStyledTextSpan", "--- rescaleBigImage:" + m + "," + k + "," + this.MAXWIDTH);
        int j = k;
        int i = m;
        if (m > this.MAXWIDTH)
        {
          i = this.MAXWIDTH;
          j = this.MAXWIDTH * k / i;
        }
        paramDrawable.setBounds(0, 0, i, j);
      }
      
      public Uri getContentUri()
      {
        return this.mContentUri;
      }
      
      public Drawable getDrawable()
      {
        if (this.mDrawable != null) {
          return this.mDrawable;
        }
        if (this.mContentUri != null) {
          System.gc();
        }
        for (;;)
        {
          try
          {
            InputStream localInputStream = this.mContext.getContentResolver().openInputStream(this.mContentUri);
            Object localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
            BitmapFactory.decodeStream(localInputStream, null, (BitmapFactory.Options)localObject);
            localInputStream.close();
            localInputStream = this.mContext.getContentResolver().openInputStream(this.mContentUri);
            int j = ((BitmapFactory.Options)localObject).outWidth;
            int i = ((BitmapFactory.Options)localObject).outHeight;
            this.mIntrinsicWidth = j;
            this.mIntrinsicHeight = i;
            if (((BitmapFactory.Options)localObject).outWidth > this.MAXWIDTH)
            {
              j = this.MAXWIDTH;
              i = this.MAXWIDTH * i / ((BitmapFactory.Options)localObject).outWidth;
              localObject = BitmapFactory.decodeStream(localInputStream, new Rect(0, 0, j, i), null);
              this.mDrawable = new BitmapDrawable(this.mContext.getResources(), (Bitmap)localObject);
              this.mDrawable.setBounds(0, 0, j, i);
              localInputStream.close();
              return this.mDrawable;
            }
            localObject = BitmapFactory.decodeStream(localInputStream);
            continue;
            this.mDrawable = super.getDrawable();
          }
          catch (Exception localException)
          {
            Log.e("EditStyledTextSpan", "Failed to loaded content " + this.mContentUri, localException);
            return null;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            Log.e("EditStyledTextSpan", "OutOfMemoryError");
            return null;
          }
          rescaleBigImage(this.mDrawable);
          this.mIntrinsicWidth = this.mDrawable.getIntrinsicWidth();
          this.mIntrinsicHeight = this.mDrawable.getIntrinsicHeight();
        }
      }
      
      public boolean isOverSize()
      {
        return getDrawable().getIntrinsicWidth() > this.MAXWIDTH;
      }
    }
  }
  
  private class EditorManager
  {
    private static final String LOG_TAG = "EditStyledText.EditorManager";
    private EditStyledText.EditModeActions mActions;
    private int mBackgroundColor = 16777215;
    private int mColorWaitInput = 16777215;
    private BackgroundColorSpan mComposingTextMask;
    private SpannableStringBuilder mCopyBuffer;
    private int mCurEnd = 0;
    private int mCurStart = 0;
    private EditStyledText mEST;
    private boolean mEditFlag = false;
    private boolean mKeepNonLineSpan = false;
    private int mMode = 0;
    private int mSizeWaitInput = 0;
    private EditStyledText.SoftKeyReceiver mSkr;
    private boolean mSoftKeyBlockFlag = false;
    private int mState = 0;
    private boolean mTextIsFinishedFlag = false;
    private boolean mWaitInputFlag = false;
    
    EditorManager(EditStyledText paramEditStyledText, EditStyledText.StyledTextDialog paramStyledTextDialog)
    {
      this.mEST = paramEditStyledText;
      this.mActions = new EditStyledText.EditModeActions(EditStyledText.this, this.mEST, this, paramStyledTextDialog);
      this.mSkr = new EditStyledText.SoftKeyReceiver(this.mEST);
    }
    
    private void addMarquee(int paramInt)
    {
      Log.d("EditStyledText.EditorManager", "--- addMarquee:" + paramInt);
      setLineStyledTextSpan(new EditStyledText.EditStyledTextSpans.MarqueeSpan(paramInt, this.mEST.getBackgroundColor()));
    }
    
    private void addSwing()
    {
      addMarquee(0);
    }
    
    private void addTelop()
    {
      addMarquee(1);
    }
    
    private void changeAlign(Layout.Alignment paramAlignment)
    {
      setLineStyledTextSpan(new AlignmentSpan.Standard(paramAlignment));
    }
    
    private void changeColorSelectedText(int paramInt)
    {
      if (this.mCurStart != this.mCurEnd)
      {
        setStyledTextSpan(new ForegroundColorSpan(paramInt), this.mCurStart, this.mCurEnd);
        return;
      }
      Log.e("EditStyledText.EditorManager", "---changeColor: Size of the span is zero");
    }
    
    private void changeSizeSelectedText(int paramInt)
    {
      if (this.mCurStart != this.mCurEnd)
      {
        setStyledTextSpan(new AbsoluteSizeSpan(paramInt), this.mCurStart, this.mCurEnd);
        return;
      }
      Log.e("EditStyledText.EditorManager", "---changeSize: Size of the span is zero");
    }
    
    private void clearStyles()
    {
      Log.d("EditStyledText.EditorManager", "--- onClearStyles");
      clearStyles(this.mEST.getText());
      this.mEST.setBackgroundDrawable(this.mEST.mDefaultBackground);
      this.mBackgroundColor = 16777215;
      onRefreshZeoWidthChar();
    }
    
    private void clearStyles(CharSequence paramCharSequence)
    {
      Log.d("EditStyledText", "--- onClearStyles");
      int i = paramCharSequence.length();
      if ((paramCharSequence instanceof Editable))
      {
        paramCharSequence = (Editable)paramCharSequence;
        Object[] arrayOfObject = paramCharSequence.getSpans(0, i, Object.class);
        int j = arrayOfObject.length;
        i = 0;
        while (i < j)
        {
          Object localObject = arrayOfObject[i];
          if (((localObject instanceof ParagraphStyle)) || ((localObject instanceof QuoteSpan)) || (((localObject instanceof CharacterStyle)) && (!(localObject instanceof UnderlineSpan))))
          {
            if (((localObject instanceof ImageSpan)) || ((localObject instanceof EditStyledText.EditStyledTextSpans.HorizontalLineSpan))) {
              paramCharSequence.replace(paramCharSequence.getSpanStart(localObject), paramCharSequence.getSpanEnd(localObject), "");
            }
            paramCharSequence.removeSpan(localObject);
          }
          i += 1;
        }
      }
    }
    
    private void copyToClipBoard()
    {
      int i = Math.min(getSelectionStart(), getSelectionEnd());
      int j = Math.max(getSelectionStart(), getSelectionEnd());
      this.mCopyBuffer = ((SpannableStringBuilder)this.mEST.getText().subSequence(i, j));
      SpannableStringBuilder localSpannableStringBuilder = removeImageChar(this.mCopyBuffer);
      ((ClipboardManager)EditStyledText.this.getContext().getSystemService("clipboard")).setText(localSpannableStringBuilder);
      dumpSpannableString(localSpannableStringBuilder);
      dumpSpannableString(this.mCopyBuffer);
    }
    
    private void cutToClipBoard()
    {
      copyToClipBoard();
      int i = Math.min(getSelectionStart(), getSelectionEnd());
      int j = Math.max(getSelectionStart(), getSelectionEnd());
      this.mEST.getText().delete(i, j);
    }
    
    private void dumpSpannableString(CharSequence paramCharSequence)
    {
      if ((paramCharSequence instanceof Spannable))
      {
        paramCharSequence = (Spannable)paramCharSequence;
        int i = paramCharSequence.length();
        Log.d("EditStyledText", "--- dumpSpannableString, txt:" + paramCharSequence + ", len:" + i);
        Object[] arrayOfObject = paramCharSequence.getSpans(0, i, Object.class);
        int j = arrayOfObject.length;
        i = 0;
        while (i < j)
        {
          Object localObject = arrayOfObject[i];
          Log.d("EditStyledText", "--- dumpSpannableString, class:" + localObject + "," + paramCharSequence.getSpanStart(localObject) + "," + paramCharSequence.getSpanEnd(localObject) + "," + paramCharSequence.getSpanFlags(localObject));
          i += 1;
        }
      }
    }
    
    private void endEdit()
    {
      Log.d("EditStyledText.EditorManager", "--- handleCancel");
      this.mMode = 0;
      this.mState = 0;
      this.mEditFlag = false;
      this.mColorWaitInput = 16777215;
      this.mSizeWaitInput = 0;
      this.mWaitInputFlag = false;
      this.mSoftKeyBlockFlag = false;
      this.mKeepNonLineSpan = false;
      this.mTextIsFinishedFlag = false;
      unsetSelect();
      this.mEST.setOnClickListener(null);
      unblockSoftKey();
    }
    
    private int findLineEnd(Editable paramEditable, int paramInt)
    {
      int i = paramInt;
      for (;;)
      {
        int j = i;
        if (i < paramEditable.length())
        {
          if (paramEditable.charAt(i) == '\n') {
            j = i + 1;
          }
        }
        else
        {
          Log.d("EditStyledText.EditorManager", "--- findLineEnd:" + paramInt + "," + paramEditable.length() + "," + j);
          return j;
        }
        i += 1;
      }
    }
    
    private int findLineStart(Editable paramEditable, int paramInt)
    {
      int i = paramInt;
      for (;;)
      {
        if ((i <= 0) || (paramEditable.charAt(i - 1) == '\n'))
        {
          Log.d("EditStyledText.EditorManager", "--- findLineStart:" + paramInt + "," + paramEditable.length() + "," + i);
          return i;
        }
        i -= 1;
      }
    }
    
    private void fixSelectionAndDoNextAction()
    {
      Log.d("EditStyledText.EditorManager", "--- handleComplete:" + this.mCurStart + "," + this.mCurEnd);
      if (!this.mEditFlag) {
        return;
      }
      if (this.mCurStart == this.mCurEnd)
      {
        Log.d("EditStyledText.EditorManager", "--- cancel handle complete:" + this.mCurStart);
        resetEdit();
        return;
      }
      if (this.mState == 2) {
        this.mState = 3;
      }
      this.mActions.doNext(this.mMode);
      EditStyledText.stopSelecting(this.mEST, this.mEST.getText());
    }
    
    private void handleSelectAll()
    {
      if (!this.mEditFlag) {
        return;
      }
      this.mActions.onAction(11);
    }
    
    private void insertHorizontalLine()
    {
      Log.d("EditStyledText.EditorManager", "--- onInsertHorizontalLine:");
      int j = this.mEST.getSelectionStart();
      int i = j;
      if (j > 0)
      {
        i = j;
        if (this.mEST.getText().charAt(j - 1) != '\n')
        {
          this.mEST.getText().insert(j, "\n");
          i = j + 1;
        }
      }
      EditStyledText.EditStyledTextSpans.HorizontalLineSpan localHorizontalLineSpan = new EditStyledText.EditStyledTextSpans.HorizontalLineSpan(-16777216, this.mEST.getWidth(), this.mEST.getText());
      j = i + 1;
      insertImageSpan(localHorizontalLineSpan, i);
      this.mEST.getText().insert(j, "\n");
      this.mEST.setSelection(j + 1);
      this.mEST.notifyStateChanged(this.mMode, this.mState);
    }
    
    private void insertImageFromResId(int paramInt)
    {
      insertImageSpan(new EditStyledText.EditStyledTextSpans.RescalableImageSpan(this.mEST.getContext(), paramInt, this.mEST.getMaxImageWidthDip()), this.mEST.getSelectionStart());
    }
    
    private void insertImageFromUri(Uri paramUri)
    {
      insertImageSpan(new EditStyledText.EditStyledTextSpans.RescalableImageSpan(this.mEST.getContext(), paramUri, this.mEST.getMaxImageWidthPx()), this.mEST.getSelectionStart());
    }
    
    private void insertImageSpan(DynamicDrawableSpan paramDynamicDrawableSpan, int paramInt)
    {
      Log.d("EditStyledText.EditorManager", "--- insertImageSpan:");
      if ((paramDynamicDrawableSpan != null) && (paramDynamicDrawableSpan.getDrawable() != null))
      {
        this.mEST.getText().insert(paramInt, "￼");
        this.mEST.getText().setSpan(paramDynamicDrawableSpan, paramInt, paramInt + 1, 33);
        this.mEST.notifyStateChanged(this.mMode, this.mState);
        return;
      }
      Log.e("EditStyledText.EditorManager", "--- insertImageSpan: null span was inserted");
      this.mEST.sendHintMessage(5);
    }
    
    private boolean isClipBoardChanged(CharSequence paramCharSequence)
    {
      Log.d("EditStyledText", "--- isClipBoardChanged:" + paramCharSequence);
      if (this.mCopyBuffer == null) {}
      int j;
      SpannableStringBuilder localSpannableStringBuilder;
      do
      {
        return true;
        j = paramCharSequence.length();
        localSpannableStringBuilder = removeImageChar(this.mCopyBuffer);
        Log.d("EditStyledText", "--- clipBoard:" + j + "," + localSpannableStringBuilder + paramCharSequence);
      } while (j != localSpannableStringBuilder.length());
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label138;
        }
        if (paramCharSequence.charAt(i) != localSpannableStringBuilder.charAt(i)) {
          break;
        }
        i += 1;
      }
      label138:
      return false;
    }
    
    private boolean isTextSelected()
    {
      return (this.mState == 2) || (this.mState == 3);
    }
    
    private boolean isWaitingNextAction()
    {
      Log.d("EditStyledText.EditorManager", "--- waitingNext:" + this.mCurStart + "," + this.mCurEnd + "," + this.mState);
      if ((this.mCurStart == this.mCurEnd) && (this.mState == 3))
      {
        waitSelection();
        return true;
      }
      resumeSelection();
      return false;
    }
    
    private void pasteFromClipboard()
    {
      int j = Math.min(this.mEST.getSelectionStart(), this.mEST.getSelectionEnd());
      int i = Math.max(this.mEST.getSelectionStart(), this.mEST.getSelectionEnd());
      Selection.setSelection(this.mEST.getText(), i);
      Object localObject1 = (ClipboardManager)EditStyledText.this.getContext().getSystemService("clipboard");
      this.mKeepNonLineSpan = true;
      this.mEST.getText().replace(j, i, ((ClipboardManager)localObject1).getText());
      if (!isClipBoardChanged(((ClipboardManager)localObject1).getText()))
      {
        Log.d("EditStyledText", "--- handlePaste: startPasteImage");
        localObject1 = (DynamicDrawableSpan[])this.mCopyBuffer.getSpans(0, this.mCopyBuffer.length(), DynamicDrawableSpan.class);
        int k = localObject1.length;
        i = 0;
        if (i < k)
        {
          Object localObject2 = localObject1[i];
          int m = this.mCopyBuffer.getSpanStart(localObject2);
          if ((localObject2 instanceof EditStyledText.EditStyledTextSpans.HorizontalLineSpan)) {
            insertImageSpan(new EditStyledText.EditStyledTextSpans.HorizontalLineSpan(-16777216, this.mEST.getWidth(), this.mEST.getText()), j + m);
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localObject2 instanceof EditStyledText.EditStyledTextSpans.RescalableImageSpan)) {
              insertImageSpan(new EditStyledText.EditStyledTextSpans.RescalableImageSpan(this.mEST.getContext(), ((EditStyledText.EditStyledTextSpans.RescalableImageSpan)localObject2).getContentUri(), this.mEST.getMaxImageWidthPx()), j + m);
            }
          }
        }
      }
    }
    
    private SpannableStringBuilder removeImageChar(SpannableStringBuilder paramSpannableStringBuilder)
    {
      paramSpannableStringBuilder = new SpannableStringBuilder(paramSpannableStringBuilder);
      DynamicDrawableSpan[] arrayOfDynamicDrawableSpan = (DynamicDrawableSpan[])paramSpannableStringBuilder.getSpans(0, paramSpannableStringBuilder.length(), DynamicDrawableSpan.class);
      int j = arrayOfDynamicDrawableSpan.length;
      int i = 0;
      while (i < j)
      {
        DynamicDrawableSpan localDynamicDrawableSpan = arrayOfDynamicDrawableSpan[i];
        if (((localDynamicDrawableSpan instanceof EditStyledText.EditStyledTextSpans.HorizontalLineSpan)) || ((localDynamicDrawableSpan instanceof EditStyledText.EditStyledTextSpans.RescalableImageSpan))) {
          paramSpannableStringBuilder.replace(paramSpannableStringBuilder.getSpanStart(localDynamicDrawableSpan), paramSpannableStringBuilder.getSpanEnd(localDynamicDrawableSpan), "");
        }
        i += 1;
      }
      return paramSpannableStringBuilder;
    }
    
    private void resetEdit()
    {
      endEdit();
      this.mEditFlag = true;
      this.mEST.notifyStateChanged(this.mMode, this.mState);
    }
    
    private void resumeSelection()
    {
      Log.d("EditStyledText.EditorManager", "--- resumeSelection");
      this.mWaitInputFlag = false;
      this.mState = 3;
      EditStyledText.stopSelecting(this.mEST, this.mEST.getText());
    }
    
    private void selectAll()
    {
      Selection.selectAll(this.mEST.getText());
      this.mCurStart = this.mEST.getSelectionStart();
      this.mCurEnd = this.mEST.getSelectionEnd();
      this.mMode = 5;
      this.mState = 3;
    }
    
    private void setEditMode(int paramInt)
    {
      this.mMode = paramInt;
    }
    
    private void setInternalSelection(int paramInt1, int paramInt2)
    {
      this.mCurStart = paramInt1;
      this.mCurEnd = paramInt2;
    }
    
    private void setLineStyledTextSpan(Object paramObject)
    {
      int k = Math.min(this.mCurStart, this.mCurEnd);
      int j = Math.max(this.mCurStart, this.mCurEnd);
      int i = this.mEST.getSelectionStart();
      k = findLineStart(this.mEST.getText(), k);
      j = findLineEnd(this.mEST.getText(), j);
      if (k == j)
      {
        this.mEST.getText().insert(j, "\n");
        setStyledTextSpan(paramObject, k, j + 1);
      }
      for (;;)
      {
        Selection.setSelection(this.mEST.getText(), i);
        return;
        setStyledTextSpan(paramObject, k, j);
      }
    }
    
    private void setSelectEndPos()
    {
      if (this.mEST.getSelectionEnd() == this.mCurStart)
      {
        setEndPos(this.mEST.getSelectionStart());
        return;
      }
      setEndPos(this.mEST.getSelectionEnd());
    }
    
    private void setSelectStartPos()
    {
      Log.d("EditStyledText.EditorManager", "--- setSelectStartPos");
      this.mCurStart = this.mEST.getSelectionStart();
      this.mState = 1;
    }
    
    private void setSelectState(int paramInt)
    {
      this.mState = paramInt;
    }
    
    private void setSelection()
    {
      Log.d("EditStyledText.EditorManager", "--- onSelect:" + this.mCurStart + "," + this.mCurEnd);
      if ((this.mCurStart >= 0) && (this.mCurStart <= this.mEST.getText().length()) && (this.mCurEnd >= 0) && (this.mCurEnd <= this.mEST.getText().length()))
      {
        if (this.mCurStart < this.mCurEnd)
        {
          this.mEST.setSelection(this.mCurStart, this.mCurEnd);
          this.mState = 2;
          return;
        }
        if (this.mCurStart > this.mCurEnd)
        {
          this.mEST.setSelection(this.mCurEnd, this.mCurStart);
          this.mState = 2;
          return;
        }
        this.mState = 1;
        return;
      }
      Log.e("EditStyledText.EditorManager", "Select is on, but cursor positions are illigal.:" + this.mEST.getText().length() + "," + this.mCurStart + "," + this.mCurEnd);
    }
    
    private void setStyledTextSpan(Object paramObject, int paramInt1, int paramInt2)
    {
      Log.d("EditStyledText.EditorManager", "--- setStyledTextSpan:" + this.mMode + "," + paramInt1 + "," + paramInt2);
      int i = Math.min(paramInt1, paramInt2);
      paramInt1 = Math.max(paramInt1, paramInt2);
      this.mEST.getText().setSpan(paramObject, i, paramInt1, 33);
      Selection.setSelection(this.mEST.getText(), paramInt1);
    }
    
    private void startEdit()
    {
      resetEdit();
      showSoftKey();
    }
    
    private void unsetSelect()
    {
      Log.d("EditStyledText.EditorManager", "--- offSelect");
      EditStyledText.stopSelecting(this.mEST, this.mEST.getText());
      int i = this.mEST.getSelectionStart();
      this.mEST.setSelection(i, i);
      this.mState = 0;
    }
    
    private void waitSelection()
    {
      Log.d("EditStyledText.EditorManager", "--- waitSelection");
      this.mWaitInputFlag = true;
      if (this.mCurStart == this.mCurEnd) {}
      for (this.mState = 1;; this.mState = 2)
      {
        EditStyledText.startSelecting(this.mEST, this.mEST.getText());
        return;
      }
    }
    
    public void addAction(int paramInt, EditStyledText.EditModeActions.EditModeActionBase paramEditModeActionBase)
    {
      this.mActions.addAction(paramInt, paramEditModeActionBase);
    }
    
    public void blockSoftKey()
    {
      Log.d("EditStyledText.EditorManager", "--- blockSoftKey:");
      hideSoftKey();
      this.mSoftKeyBlockFlag = true;
    }
    
    public boolean canPaste()
    {
      return (this.mCopyBuffer != null) && (this.mCopyBuffer.length() > 0) && (removeImageChar(this.mCopyBuffer).length() == 0);
    }
    
    public int getBackgroundColor()
    {
      return this.mBackgroundColor;
    }
    
    public int getColorWaitInput()
    {
      return this.mColorWaitInput;
    }
    
    public int getEditMode()
    {
      return this.mMode;
    }
    
    public int getSelectState()
    {
      return this.mState;
    }
    
    public int getSelectionEnd()
    {
      return this.mCurEnd;
    }
    
    public int getSelectionStart()
    {
      return this.mCurStart;
    }
    
    public int getSizeWaitInput()
    {
      return this.mSizeWaitInput;
    }
    
    public void hideSoftKey()
    {
      Log.d("EditStyledText.EditorManager", "--- hidesoftkey");
      if (!this.mEST.isFocused()) {
        return;
      }
      this.mSkr.mNewStart = Selection.getSelectionStart(this.mEST.getText());
      this.mSkr.mNewEnd = Selection.getSelectionEnd(this.mEST.getText());
      ((InputMethodManager)this.mEST.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mEST.getWindowToken(), 0, this.mSkr);
    }
    
    public boolean isEditting()
    {
      return this.mEditFlag;
    }
    
    public boolean isSoftKeyBlocked()
    {
      return this.mSoftKeyBlockFlag;
    }
    
    public boolean isStyledText()
    {
      Editable localEditable = this.mEST.getText();
      int i = localEditable.length();
      return (((ParagraphStyle[])localEditable.getSpans(0, i, ParagraphStyle.class)).length > 0) || (((QuoteSpan[])localEditable.getSpans(0, i, QuoteSpan.class)).length > 0) || (((CharacterStyle[])localEditable.getSpans(0, i, CharacterStyle.class)).length > 0) || (this.mBackgroundColor != 16777215);
    }
    
    public boolean isWaitInput()
    {
      return this.mWaitInputFlag;
    }
    
    public void onAction(int paramInt)
    {
      onAction(paramInt, true);
    }
    
    public void onAction(int paramInt, boolean paramBoolean)
    {
      this.mActions.onAction(paramInt);
      if (paramBoolean) {
        this.mEST.notifyStateChanged(this.mMode, this.mState);
      }
    }
    
    public void onCancelViewManagers()
    {
      this.mActions.onAction(18);
    }
    
    public void onClearStyles()
    {
      this.mActions.onAction(14);
    }
    
    public void onCursorMoved()
    {
      Log.d("EditStyledText.EditorManager", "--- onClickView");
      if ((this.mState == 1) || (this.mState == 2))
      {
        this.mActions.onSelectAction();
        this.mEST.notifyStateChanged(this.mMode, this.mState);
      }
    }
    
    public void onFixSelectedItem()
    {
      Log.d("EditStyledText.EditorManager", "--- onFixSelectedItem");
      fixSelectionAndDoNextAction();
      this.mEST.notifyStateChanged(this.mMode, this.mState);
    }
    
    public void onInsertImage(int paramInt)
    {
      this.mActions.onAction(15, Integer.valueOf(paramInt));
      this.mEST.notifyStateChanged(this.mMode, this.mState);
    }
    
    public void onInsertImage(Uri paramUri)
    {
      this.mActions.onAction(15, paramUri);
      this.mEST.notifyStateChanged(this.mMode, this.mState);
    }
    
    public void onRefreshStyles()
    {
      Log.d("EditStyledText.EditorManager", "--- onRefreshStyles");
      Editable localEditable = this.mEST.getText();
      int j = localEditable.length();
      int k = this.mEST.getWidth();
      EditStyledText.EditStyledTextSpans.HorizontalLineSpan[] arrayOfHorizontalLineSpan = (EditStyledText.EditStyledTextSpans.HorizontalLineSpan[])localEditable.getSpans(0, j, EditStyledText.EditStyledTextSpans.HorizontalLineSpan.class);
      int m = arrayOfHorizontalLineSpan.length;
      int i = 0;
      while (i < m)
      {
        arrayOfHorizontalLineSpan[i].resetWidth(k);
        i += 1;
      }
      EditStyledText.EditStyledTextSpans.MarqueeSpan[] arrayOfMarqueeSpan = (EditStyledText.EditStyledTextSpans.MarqueeSpan[])localEditable.getSpans(0, j, EditStyledText.EditStyledTextSpans.MarqueeSpan.class);
      j = arrayOfMarqueeSpan.length;
      i = 0;
      while (i < j)
      {
        arrayOfMarqueeSpan[i].resetColor(this.mEST.getBackgroundColor());
        i += 1;
      }
      if (arrayOfHorizontalLineSpan.length > 0) {
        localEditable.replace(0, 1, "" + localEditable.charAt(0));
      }
    }
    
    public void onRefreshZeoWidthChar()
    {
      Editable localEditable = this.mEST.getText();
      int j;
      for (int i = 0; i < localEditable.length(); i = j + 1)
      {
        j = i;
        if (localEditable.charAt(i) == '⁠')
        {
          localEditable.replace(i, i + 1, "");
          j = i - 1;
        }
      }
    }
    
    public void onStartSelect(boolean paramBoolean)
    {
      Log.d("EditStyledText.EditorManager", "--- onClickSelect");
      this.mMode = 5;
      if (this.mState == 0) {
        this.mActions.onSelectAction();
      }
      for (;;)
      {
        if (paramBoolean) {
          this.mEST.notifyStateChanged(this.mMode, this.mState);
        }
        return;
        unsetSelect();
        this.mActions.onSelectAction();
      }
    }
    
    public void onStartSelectAll(boolean paramBoolean)
    {
      Log.d("EditStyledText.EditorManager", "--- onClickSelectAll");
      handleSelectAll();
      if (paramBoolean) {
        this.mEST.notifyStateChanged(this.mMode, this.mState);
      }
    }
    
    public void onStartShowMenuAlertDialog()
    {
      this.mActions.onAction(23);
    }
    
    public void setAlignment(Layout.Alignment paramAlignment)
    {
      if ((this.mState == 2) || (this.mState == 3))
      {
        changeAlign(paramAlignment);
        resetEdit();
      }
    }
    
    public void setBackgroundColor(int paramInt)
    {
      this.mBackgroundColor = paramInt;
    }
    
    public void setEndPos(int paramInt)
    {
      Log.d("EditStyledText.EditorManager", "--- setSelectedEndPos:" + paramInt);
      this.mCurEnd = paramInt;
      setSelection();
    }
    
    public void setItemColor(int paramInt, boolean paramBoolean)
    {
      Log.d("EditStyledText.EditorManager", "--- setItemColor");
      if (isWaitingNextAction()) {
        this.mColorWaitInput = paramInt;
      }
      do
      {
        do
        {
          return;
        } while ((this.mState != 2) && (this.mState != 3));
        if (paramInt != 16777215) {
          changeColorSelectedText(paramInt);
        }
      } while (!paramBoolean);
      resetEdit();
    }
    
    public void setItemSize(int paramInt, boolean paramBoolean)
    {
      Log.d("EditStyledText.EditorManager", "--- setItemSize");
      if (isWaitingNextAction()) {
        this.mSizeWaitInput = paramInt;
      }
      do
      {
        do
        {
          return;
        } while ((this.mState != 2) && (this.mState != 3));
        if (paramInt > 0) {
          changeSizeSelectedText(paramInt);
        }
      } while (!paramBoolean);
      resetEdit();
    }
    
    public void setMarquee(int paramInt)
    {
      if ((this.mState == 2) || (this.mState == 3))
      {
        addMarquee(paramInt);
        resetEdit();
      }
    }
    
    public void setSwing()
    {
      if ((this.mState == 2) || (this.mState == 3))
      {
        addSwing();
        resetEdit();
      }
    }
    
    public void setTelop()
    {
      if ((this.mState == 2) || (this.mState == 3))
      {
        addTelop();
        resetEdit();
      }
    }
    
    public void setTextComposingMask(int paramInt1, int paramInt2)
    {
      Log.d("EditStyledText", "--- setTextComposingMask:" + paramInt1 + "," + paramInt2);
      int i = Math.min(paramInt1, paramInt2);
      paramInt2 = Math.max(paramInt1, paramInt2);
      if ((isWaitInput()) && (this.mColorWaitInput != 16777215)) {}
      for (paramInt1 = this.mColorWaitInput;; paramInt1 = this.mEST.getForegroundColor(i))
      {
        int j = this.mEST.getBackgroundColor();
        Log.d("EditStyledText", "--- fg:" + Integer.toHexString(paramInt1) + ",bg:" + Integer.toHexString(j) + "," + isWaitInput() + "," + "," + this.mMode);
        if (paramInt1 == j)
        {
          paramInt1 = 0x80000000 | (0xFF000000 | j) ^ 0xFFFFFFFF;
          if ((this.mComposingTextMask == null) || (this.mComposingTextMask.getBackgroundColor() != paramInt1)) {
            this.mComposingTextMask = new BackgroundColorSpan(paramInt1);
          }
          this.mEST.getText().setSpan(this.mComposingTextMask, i, paramInt2, 33);
        }
        return;
      }
    }
    
    public void showSoftKey()
    {
      showSoftKey(this.mEST.getSelectionStart(), this.mEST.getSelectionEnd());
    }
    
    public void showSoftKey(int paramInt1, int paramInt2)
    {
      Log.d("EditStyledText.EditorManager", "--- showsoftkey");
      if ((!this.mEST.isFocused()) || (isSoftKeyBlocked())) {}
      do
      {
        return;
        this.mSkr.mNewStart = Selection.getSelectionStart(this.mEST.getText());
        this.mSkr.mNewEnd = Selection.getSelectionEnd(this.mEST.getText());
      } while ((!((InputMethodManager)EditStyledText.this.getContext().getSystemService("input_method")).showSoftInput(this.mEST, 0, this.mSkr)) || (this.mSkr == null));
      Selection.setSelection(EditStyledText.this.getText(), paramInt1, paramInt2);
    }
    
    public void unblockSoftKey()
    {
      Log.d("EditStyledText.EditorManager", "--- unblockSoftKey:");
      this.mSoftKeyBlockFlag = false;
    }
    
    public void unsetTextComposingMask()
    {
      Log.d("EditStyledText", "--- unsetTextComposingMask");
      if (this.mComposingTextMask != null)
      {
        this.mEST.getText().removeSpan(this.mComposingTextMask);
        this.mComposingTextMask = null;
      }
    }
    
    public void updateSpanNextToCursor(Editable paramEditable, int paramInt1, int paramInt2, int paramInt3)
    {
      Log.d("EditStyledText.EditorManager", "updateSpanNext:" + paramInt1 + "," + paramInt2 + "," + paramInt3);
      int k = paramInt1 + paramInt3;
      int j = Math.min(paramInt1, k);
      paramInt1 = Math.max(paramInt1, k);
      Object[] arrayOfObject = paramEditable.getSpans(paramInt1, paramInt1, Object.class);
      int m = arrayOfObject.length;
      paramInt1 = 0;
      if (paramInt1 < m)
      {
        Object localObject = arrayOfObject[paramInt1];
        int n;
        int i1;
        if (((localObject instanceof EditStyledText.EditStyledTextSpans.MarqueeSpan)) || ((localObject instanceof AlignmentSpan)))
        {
          n = paramEditable.getSpanStart(localObject);
          i1 = paramEditable.getSpanEnd(localObject);
          Log.d("EditStyledText.EditorManager", "spantype:" + localObject.getClass() + "," + i1);
          int i = j;
          if (((localObject instanceof EditStyledText.EditStyledTextSpans.MarqueeSpan)) || ((localObject instanceof AlignmentSpan))) {
            i = findLineStart(this.mEST.getText(), j);
          }
          if ((i < n) && (paramInt2 > paramInt3)) {
            paramEditable.removeSpan(localObject);
          }
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          if (n > j)
          {
            paramEditable.setSpan(localObject, j, i1, 33);
            continue;
            if (((localObject instanceof EditStyledText.EditStyledTextSpans.HorizontalLineSpan)) && (paramEditable.getSpanStart(localObject) == k) && (k > 0) && (this.mEST.getText().charAt(k - 1) != '\n'))
            {
              this.mEST.getText().insert(k, "\n");
              this.mEST.setSelection(k);
            }
          }
        }
      }
    }
    
    public void updateSpanPreviousFromCursor(Editable paramEditable, int paramInt1, int paramInt2, int paramInt3)
    {
      Log.d("EditStyledText.EditorManager", "updateSpanPrevious:" + paramInt1 + "," + paramInt2 + "," + paramInt3);
      int m = paramInt1 + paramInt3;
      int i = Math.min(paramInt1, m);
      int j = Math.max(paramInt1, m);
      Object[] arrayOfObject = paramEditable.getSpans(i, i, Object.class);
      int n = arrayOfObject.length;
      i = 0;
      if (i < n)
      {
        Object localObject = arrayOfObject[i];
        int k;
        if (((localObject instanceof ForegroundColorSpan)) || ((localObject instanceof AbsoluteSizeSpan)) || ((localObject instanceof EditStyledText.EditStyledTextSpans.MarqueeSpan)) || ((localObject instanceof AlignmentSpan)))
        {
          int i1 = paramEditable.getSpanStart(localObject);
          k = paramEditable.getSpanEnd(localObject);
          Log.d("EditStyledText.EditorManager", "spantype:" + localObject.getClass() + "," + i1);
          paramInt1 = j;
          if (((localObject instanceof EditStyledText.EditStyledTextSpans.MarqueeSpan)) || ((localObject instanceof AlignmentSpan)))
          {
            paramInt1 = findLineEnd(this.mEST.getText(), j);
            label231:
            if (k < paramInt1)
            {
              Log.d("EditStyledText.EditorManager", "updateSpanPrevious: extend span");
              paramEditable.setSpan(localObject, i1, paramInt1, 33);
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (!this.mKeepNonLineSpan) {
            break label231;
          }
          paramInt1 = k;
          break label231;
          if ((localObject instanceof EditStyledText.EditStyledTextSpans.HorizontalLineSpan))
          {
            paramInt1 = paramEditable.getSpanStart(localObject);
            k = paramEditable.getSpanEnd(localObject);
            if (paramInt2 > paramInt3)
            {
              paramEditable.replace(paramInt1, k, "");
              paramEditable.removeSpan(localObject);
            }
            else if ((k == m) && (m < paramEditable.length()) && (this.mEST.getText().charAt(m) != '\n'))
            {
              this.mEST.getText().insert(m, "\n");
            }
          }
        }
      }
    }
  }
  
  private class MenuHandler
    implements MenuItem.OnMenuItemClickListener
  {
    private MenuHandler() {}
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return EditStyledText.this.onTextContextMenuItem(paramMenuItem.getItemId());
    }
  }
  
  public static class SavedStyledTextState
    extends View.BaseSavedState
  {
    public int mBackgroundColor;
    
    SavedStyledTextState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "EditStyledText.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " bgcolor=" + this.mBackgroundColor + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.mBackgroundColor);
    }
  }
  
  private static class SoftKeyReceiver
    extends ResultReceiver
  {
    EditStyledText mEST;
    int mNewEnd;
    int mNewStart;
    
    SoftKeyReceiver(EditStyledText paramEditStyledText)
    {
      super();
      this.mEST = paramEditStyledText;
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      if (paramInt != 2) {
        Selection.setSelection(this.mEST.getText(), this.mNewStart, this.mNewEnd);
      }
    }
  }
  
  private static class StyledTextArrowKeyMethod
    extends ArrowKeyMovementMethod
  {
    String LOG_TAG = "StyledTextArrowKeyMethod";
    EditStyledText.EditorManager mManager;
    
    StyledTextArrowKeyMethod(EditStyledText.EditorManager paramEditorManager)
    {
      this.mManager = paramEditorManager;
    }
    
    private boolean executeDown(TextView paramTextView, Spannable paramSpannable, int paramInt)
    {
      Log.d(this.LOG_TAG, "--- executeDown: " + paramInt);
      switch (paramInt)
      {
      default: 
        return false;
      case 19: 
        return false | up(paramTextView, paramSpannable);
      case 20: 
        return false | down(paramTextView, paramSpannable);
      case 21: 
        return false | left(paramTextView, paramSpannable);
      case 22: 
        return false | right(paramTextView, paramSpannable);
      }
      this.mManager.onFixSelectedItem();
      return true;
    }
    
    private int getEndPos(TextView paramTextView)
    {
      if (paramTextView.getSelectionStart() == this.mManager.getSelectionStart()) {
        return paramTextView.getSelectionEnd();
      }
      return paramTextView.getSelectionStart();
    }
    
    protected boolean down(TextView paramTextView, Spannable paramSpannable)
    {
      Log.d(this.LOG_TAG, "--- down:");
      paramSpannable = paramTextView.getLayout();
      int i = getEndPos(paramTextView);
      int j = paramSpannable.getLineForOffset(i);
      if (j < paramSpannable.getLineCount() - 1) {
        if (paramSpannable.getParagraphDirection(j) != paramSpannable.getParagraphDirection(j + 1)) {
          break label87;
        }
      }
      label87:
      for (i = paramSpannable.getOffsetForHorizontal(j + 1, paramSpannable.getPrimaryHorizontal(i));; i = paramSpannable.getLineStart(j + 1))
      {
        this.mManager.setEndPos(i);
        this.mManager.onCursorMoved();
        return true;
      }
    }
    
    protected boolean left(TextView paramTextView, Spannable paramSpannable)
    {
      Log.d(this.LOG_TAG, "--- left:");
      int i = paramTextView.getLayout().getOffsetToLeftOf(getEndPos(paramTextView));
      this.mManager.setEndPos(i);
      this.mManager.onCursorMoved();
      return true;
    }
    
    public boolean onKeyDown(TextView paramTextView, Spannable paramSpannable, int paramInt, KeyEvent paramKeyEvent)
    {
      Log.d(this.LOG_TAG, "---onkeydown:" + paramInt);
      this.mManager.unsetTextComposingMask();
      if ((this.mManager.getSelectState() == 1) || (this.mManager.getSelectState() == 2)) {
        return executeDown(paramTextView, paramSpannable, paramInt);
      }
      return super.onKeyDown(paramTextView, paramSpannable, paramInt, paramKeyEvent);
    }
    
    protected boolean right(TextView paramTextView, Spannable paramSpannable)
    {
      Log.d(this.LOG_TAG, "--- right:");
      int i = paramTextView.getLayout().getOffsetToRightOf(getEndPos(paramTextView));
      this.mManager.setEndPos(i);
      this.mManager.onCursorMoved();
      return true;
    }
    
    protected boolean up(TextView paramTextView, Spannable paramSpannable)
    {
      Log.d(this.LOG_TAG, "--- up:");
      paramSpannable = paramTextView.getLayout();
      int i = getEndPos(paramTextView);
      int j = paramSpannable.getLineForOffset(i);
      if (j > 0) {
        if (paramSpannable.getParagraphDirection(j) != paramSpannable.getParagraphDirection(j - 1)) {
          break label81;
        }
      }
      label81:
      for (i = paramSpannable.getOffsetForHorizontal(j - 1, paramSpannable.getPrimaryHorizontal(i));; i = paramSpannable.getLineStart(j - 1))
      {
        this.mManager.setEndPos(i);
        this.mManager.onCursorMoved();
        return true;
      }
    }
  }
  
  private class StyledTextConverter
  {
    private EditStyledText mEST;
    private EditStyledText.StyledTextHtmlConverter mHtml;
    
    public StyledTextConverter(EditStyledText paramEditStyledText, EditStyledText.StyledTextHtmlConverter paramStyledTextHtmlConverter)
    {
      this.mEST = paramEditStyledText;
      this.mHtml = paramStyledTextHtmlConverter;
    }
    
    public void SetHtml(String paramString)
    {
      paramString = this.mHtml.fromHtml(paramString, new Html.ImageGetter()
      {
        public Drawable getDrawable(String paramAnonymousString)
        {
          Log.d("EditStyledText", "--- sethtml: src=" + paramAnonymousString);
          if (paramAnonymousString.startsWith("content://"))
          {
            Uri localUri = Uri.parse(paramAnonymousString);
            for (;;)
            {
              try
              {
                System.gc();
                localInputStream = EditStyledText.this.getContext().getContentResolver().openInputStream(localUri);
                paramAnonymousString = new BitmapFactory.Options();
                paramAnonymousString.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(localInputStream, null, paramAnonymousString);
                localInputStream.close();
                localInputStream = EditStyledText.this.getContext().getContentResolver().openInputStream(localUri);
                j = paramAnonymousString.outWidth;
                i = paramAnonymousString.outHeight;
                if (paramAnonymousString.outWidth > EditStyledText.this.getMaxImageWidthPx())
                {
                  j = EditStyledText.this.getMaxImageWidthPx();
                  i = EditStyledText.this.getMaxImageWidthPx() * i / paramAnonymousString.outWidth;
                  paramAnonymousString = BitmapFactory.decodeStream(localInputStream, new Rect(0, 0, j, i), null);
                  paramAnonymousString = new BitmapDrawable(EditStyledText.this.getContext().getResources(), paramAnonymousString);
                }
              }
              catch (Exception paramAnonymousString)
              {
                InputStream localInputStream;
                int j;
                int i;
                Log.e("EditStyledText", "--- set html: Failed to loaded content " + localUri, paramAnonymousString);
                return null;
              }
              catch (OutOfMemoryError paramAnonymousString) {}
              try
              {
                paramAnonymousString.setBounds(0, 0, j, i);
                localInputStream.close();
                return paramAnonymousString;
              }
              catch (OutOfMemoryError paramAnonymousString)
              {
                for (;;) {}
              }
              catch (Exception paramAnonymousString)
              {
                continue;
              }
              paramAnonymousString = BitmapFactory.decodeStream(localInputStream);
            }
            Log.e("EditStyledText", "OutOfMemoryError");
            EditStyledText.this.setHint(5);
            return null;
          }
          return null;
        }
      }, null);
      this.mEST.setText(paramString);
    }
    
    public String getHtml(boolean paramBoolean)
    {
      this.mEST.clearComposingText();
      this.mEST.onRefreshZeoWidthChar();
      String str = this.mHtml.toHtml(this.mEST.getText(), paramBoolean);
      Log.d("EditStyledText", "--- getHtml:" + str);
      return str;
    }
    
    public String getPreviewHtml()
    {
      this.mEST.clearComposingText();
      this.mEST.onRefreshZeoWidthChar();
      String str = this.mHtml.toHtml(this.mEST.getText(), true, EditStyledText.this.getMaxImageWidthDip(), EditStyledText.this.getPaddingScale());
      int i = this.mEST.getBackgroundColor();
      str = String.format("<body bgcolor=\"#%02X%02X%02X\">%s</body>", new Object[] { Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), str });
      Log.d("EditStyledText", "--- getPreviewHtml:" + str + "," + this.mEST.getWidth());
      return str;
    }
    
    public void getUriArray(ArrayList<Uri> paramArrayList, Editable paramEditable)
    {
      paramArrayList.clear();
      Log.d("EditStyledText", "--- getUriArray:");
      int k = paramEditable.length();
      int j;
      for (int i = 0; i < paramEditable.length(); i = j)
      {
        j = paramEditable.nextSpanTransition(i, k, ImageSpan.class);
        ImageSpan[] arrayOfImageSpan = (ImageSpan[])paramEditable.getSpans(i, j, ImageSpan.class);
        i = 0;
        while (i < arrayOfImageSpan.length)
        {
          Log.d("EditStyledText", "--- getUriArray: foundArray" + arrayOfImageSpan[i].getSource());
          paramArrayList.add(Uri.parse(arrayOfImageSpan[i].getSource()));
          i += 1;
        }
      }
    }
    
    public void setStyledTextHtmlConverter(EditStyledText.StyledTextHtmlConverter paramStyledTextHtmlConverter)
    {
      this.mHtml = paramStyledTextHtmlConverter;
    }
  }
  
  private static class StyledTextDialog
  {
    private static final int TYPE_BACKGROUND = 1;
    private static final int TYPE_FOREGROUND = 0;
    private AlertDialog mAlertDialog;
    private CharSequence[] mAlignNames;
    private CharSequence mAlignTitle;
    private AlertDialog.Builder mBuilder;
    private CharSequence mColorDefaultMessage;
    private CharSequence[] mColorInts;
    private CharSequence[] mColorNames;
    private CharSequence mColorTitle;
    private EditStyledText mEST;
    private CharSequence[] mMarqueeNames;
    private CharSequence mMarqueeTitle;
    private CharSequence[] mSizeDisplayInts;
    private CharSequence[] mSizeNames;
    private CharSequence[] mSizeSendInts;
    private CharSequence mSizeTitle;
    
    public StyledTextDialog(EditStyledText paramEditStyledText)
    {
      this.mEST = paramEditStyledText;
    }
    
    private void buildAndShowColorDialogue(int paramInt, CharSequence paramCharSequence, int[] paramArrayOfInt)
    {
      int j = this.mEST.dipToPx(50);
      int k = this.mEST.dipToPx(2);
      int i = this.mEST.dipToPx(15);
      this.mBuilder.setTitle(paramCharSequence);
      this.mBuilder.setIcon(0);
      this.mBuilder.setPositiveButton(null, null);
      this.mBuilder.setNegativeButton(17039360, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          EditStyledText.this.onStartEdit();
        }
      });
      this.mBuilder.setItems(null, null);
      LinearLayout localLinearLayout = new LinearLayout(this.mEST.getContext());
      localLinearLayout.setOrientation(1);
      localLinearLayout.setGravity(1);
      localLinearLayout.setPadding(i, i, i, i);
      paramCharSequence = null;
      i = 0;
      if (i < paramArrayOfInt.length)
      {
        if (i % 5 == 0)
        {
          paramCharSequence = new LinearLayout(this.mEST.getContext());
          localLinearLayout.addView(paramCharSequence);
        }
        Button localButton = new Button(this.mEST.getContext());
        localButton.setHeight(j);
        localButton.setWidth(j);
        localButton.setBackgroundDrawable(new EditStyledText.ColorPaletteDrawable(paramArrayOfInt[i], j, j, k));
        localButton.setDrawingCacheBackgroundColor(paramArrayOfInt[i]);
        if (paramInt == 0) {
          localButton.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              EditStyledText.this.setItemColor(paramAnonymousView.getDrawingCacheBackgroundColor());
              if (EditStyledText.StyledTextDialog.this.mAlertDialog != null)
              {
                EditStyledText.StyledTextDialog.this.mAlertDialog.setView(null);
                EditStyledText.StyledTextDialog.this.mAlertDialog.dismiss();
                EditStyledText.StyledTextDialog.access$1502(EditStyledText.StyledTextDialog.this, null);
                return;
              }
              Log.e("EditStyledText", "--- buildAndShowColorDialogue: can't find alertDialog");
            }
          });
        }
        for (;;)
        {
          paramCharSequence.addView(localButton);
          i += 1;
          break;
          if (paramInt == 1) {
            localButton.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymousView)
              {
                EditStyledText.this.setBackgroundColor(paramAnonymousView.getDrawingCacheBackgroundColor());
                if (EditStyledText.StyledTextDialog.this.mAlertDialog != null)
                {
                  EditStyledText.StyledTextDialog.this.mAlertDialog.setView(null);
                  EditStyledText.StyledTextDialog.this.mAlertDialog.dismiss();
                  EditStyledText.StyledTextDialog.access$1502(EditStyledText.StyledTextDialog.this, null);
                  return;
                }
                Log.e("EditStyledText", "--- buildAndShowColorDialogue: can't find alertDialog");
              }
            });
          }
        }
      }
      if (paramInt == 1) {
        this.mBuilder.setPositiveButton(this.mColorDefaultMessage, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            EditStyledText.this.setBackgroundColor(16777215);
          }
        });
      }
      for (;;)
      {
        this.mBuilder.setView(localLinearLayout);
        this.mBuilder.setCancelable(true);
        this.mBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            EditStyledText.this.onStartEdit();
          }
        });
        this.mAlertDialog = this.mBuilder.show();
        return;
        if (paramInt == 0) {
          this.mBuilder.setPositiveButton(this.mColorDefaultMessage, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              EditStyledText.this.setItemColor(-16777216);
            }
          });
        }
      }
    }
    
    private void buildDialogue(CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.mBuilder.setTitle(paramCharSequence);
      this.mBuilder.setIcon(0);
      this.mBuilder.setPositiveButton(null, null);
      this.mBuilder.setNegativeButton(17039360, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          EditStyledText.this.onStartEdit();
        }
      });
      this.mBuilder.setItems(paramArrayOfCharSequence, paramOnClickListener);
      this.mBuilder.setView(null);
      this.mBuilder.setCancelable(true);
      this.mBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          Log.d("EditStyledText", "--- oncancel");
          EditStyledText.this.onStartEdit();
        }
      });
      this.mBuilder.show();
    }
    
    private boolean checkAlignAlertParams()
    {
      Log.d("EditStyledText", "--- checkAlignAlertParams");
      if (this.mBuilder == null)
      {
        Log.e("EditStyledText", "--- builder is null.");
        return false;
      }
      if (this.mAlignTitle == null)
      {
        Log.e("EditStyledText", "--- align alert params are null.");
        return false;
      }
      return true;
    }
    
    private boolean checkColorAlertParams()
    {
      Log.d("EditStyledText", "--- checkParams");
      if (this.mBuilder == null)
      {
        Log.e("EditStyledText", "--- builder is null.");
        return false;
      }
      if ((this.mColorTitle == null) || (this.mColorNames == null) || (this.mColorInts == null))
      {
        Log.e("EditStyledText", "--- color alert params are null.");
        return false;
      }
      if (this.mColorNames.length != this.mColorInts.length)
      {
        Log.e("EditStyledText", "--- the length of color alert params are different.");
        return false;
      }
      return true;
    }
    
    private boolean checkMarqueeAlertParams()
    {
      Log.d("EditStyledText", "--- checkMarqueeAlertParams");
      if (this.mBuilder == null)
      {
        Log.e("EditStyledText", "--- builder is null.");
        return false;
      }
      if (this.mMarqueeTitle == null)
      {
        Log.e("EditStyledText", "--- Marquee alert params are null.");
        return false;
      }
      return true;
    }
    
    private boolean checkSizeAlertParams()
    {
      Log.d("EditStyledText", "--- checkParams");
      if (this.mBuilder == null)
      {
        Log.e("EditStyledText", "--- builder is null.");
        return false;
      }
      if ((this.mSizeTitle == null) || (this.mSizeNames == null) || (this.mSizeDisplayInts == null) || (this.mSizeSendInts == null))
      {
        Log.e("EditStyledText", "--- size alert params are null.");
        return false;
      }
      if ((this.mSizeNames.length != this.mSizeDisplayInts.length) && (this.mSizeSendInts.length != this.mSizeDisplayInts.length))
      {
        Log.e("EditStyledText", "--- the length of size alert params are different.");
        return false;
      }
      return true;
    }
    
    private void onShowAlignAlertDialog()
    {
      Log.d("EditStyledText", "--- onShowAlignAlertDialog");
      if (!checkAlignAlertParams()) {
        return;
      }
      buildDialogue(this.mAlignTitle, this.mAlignNames, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = Layout.Alignment.ALIGN_NORMAL;
          switch (paramAnonymousInt)
          {
          default: 
            Log.e("EditStyledText", "--- onShowAlignAlertDialog: got illigal align.");
          }
          for (;;)
          {
            EditStyledText.this.setAlignment(paramAnonymousDialogInterface);
            return;
            paramAnonymousDialogInterface = Layout.Alignment.ALIGN_NORMAL;
            continue;
            paramAnonymousDialogInterface = Layout.Alignment.ALIGN_CENTER;
            continue;
            paramAnonymousDialogInterface = Layout.Alignment.ALIGN_OPPOSITE;
          }
        }
      });
    }
    
    private void onShowBackgroundColorAlertDialog()
    {
      Log.d("EditStyledText", "--- onShowBackgroundColorAlertDialog");
      if (!checkColorAlertParams()) {
        return;
      }
      int[] arrayOfInt = new int[this.mColorInts.length];
      int i = 0;
      while (i < arrayOfInt.length)
      {
        arrayOfInt[i] = (Integer.parseInt((String)this.mColorInts[i], 16) - 16777216);
        i += 1;
      }
      buildAndShowColorDialogue(1, this.mColorTitle, arrayOfInt);
    }
    
    private void onShowForegroundColorAlertDialog()
    {
      Log.d("EditStyledText", "--- onShowForegroundColorAlertDialog");
      if (!checkColorAlertParams()) {
        return;
      }
      int[] arrayOfInt = new int[this.mColorInts.length];
      int i = 0;
      while (i < arrayOfInt.length)
      {
        arrayOfInt[i] = (Integer.parseInt((String)this.mColorInts[i], 16) - 16777216);
        i += 1;
      }
      buildAndShowColorDialogue(0, this.mColorTitle, arrayOfInt);
    }
    
    private void onShowMarqueeAlertDialog()
    {
      Log.d("EditStyledText", "--- onShowMarqueeAlertDialog");
      if (!checkMarqueeAlertParams()) {
        return;
      }
      buildDialogue(this.mMarqueeTitle, this.mMarqueeNames, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          Log.d("EditStyledText", "mBuilder.onclick:" + paramAnonymousInt);
          EditStyledText.this.setMarquee(paramAnonymousInt);
        }
      });
    }
    
    private void onShowSizeAlertDialog()
    {
      Log.d("EditStyledText", "--- onShowSizeAlertDialog");
      if (!checkSizeAlertParams()) {
        return;
      }
      buildDialogue(this.mSizeTitle, this.mSizeNames, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          Log.d("EditStyledText", "mBuilder.onclick:" + paramAnonymousInt);
          paramAnonymousInt = EditStyledText.this.dipToPx(Integer.parseInt((String)EditStyledText.StyledTextDialog.this.mSizeDisplayInts[paramAnonymousInt]));
          EditStyledText.this.setItemSize(paramAnonymousInt);
        }
      });
    }
    
    public void setAlignAlertParams(CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence)
    {
      this.mAlignTitle = paramCharSequence;
      this.mAlignNames = paramArrayOfCharSequence;
    }
    
    public void setBuilder(AlertDialog.Builder paramBuilder)
    {
      this.mBuilder = paramBuilder;
    }
    
    public void setColorAlertParams(CharSequence paramCharSequence1, CharSequence[] paramArrayOfCharSequence1, CharSequence[] paramArrayOfCharSequence2, CharSequence paramCharSequence2)
    {
      this.mColorTitle = paramCharSequence1;
      this.mColorNames = paramArrayOfCharSequence1;
      this.mColorInts = paramArrayOfCharSequence2;
      this.mColorDefaultMessage = paramCharSequence2;
    }
    
    public void setMarqueeAlertParams(CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence)
    {
      this.mMarqueeTitle = paramCharSequence;
      this.mMarqueeNames = paramArrayOfCharSequence;
    }
    
    public void setSizeAlertParams(CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence1, CharSequence[] paramArrayOfCharSequence2, CharSequence[] paramArrayOfCharSequence3)
    {
      this.mSizeTitle = paramCharSequence;
      this.mSizeNames = paramArrayOfCharSequence1;
      this.mSizeDisplayInts = paramArrayOfCharSequence2;
      this.mSizeSendInts = paramArrayOfCharSequence3;
    }
  }
  
  public static abstract interface StyledTextHtmlConverter
  {
    public abstract Spanned fromHtml(String paramString);
    
    public abstract Spanned fromHtml(String paramString, Html.ImageGetter paramImageGetter, Html.TagHandler paramTagHandler);
    
    public abstract String toHtml(Spanned paramSpanned);
    
    public abstract String toHtml(Spanned paramSpanned, boolean paramBoolean);
    
    public abstract String toHtml(Spanned paramSpanned, boolean paramBoolean, int paramInt, float paramFloat);
  }
  
  private class StyledTextHtmlStandard
    implements EditStyledText.StyledTextHtmlConverter
  {
    private StyledTextHtmlStandard() {}
    
    public Spanned fromHtml(String paramString)
    {
      return Html.fromHtml(paramString);
    }
    
    public Spanned fromHtml(String paramString, Html.ImageGetter paramImageGetter, Html.TagHandler paramTagHandler)
    {
      return Html.fromHtml(paramString, paramImageGetter, paramTagHandler);
    }
    
    public String toHtml(Spanned paramSpanned)
    {
      return Html.toHtml(paramSpanned);
    }
    
    public String toHtml(Spanned paramSpanned, boolean paramBoolean)
    {
      return Html.toHtml(paramSpanned);
    }
    
    public String toHtml(Spanned paramSpanned, boolean paramBoolean, int paramInt, float paramFloat)
    {
      return Html.toHtml(paramSpanned);
    }
  }
  
  public static class StyledTextInputConnection
    extends InputConnectionWrapper
  {
    EditStyledText mEST;
    
    public StyledTextInputConnection(InputConnection paramInputConnection, EditStyledText paramEditStyledText)
    {
      super(true);
      this.mEST = paramEditStyledText;
    }
    
    public boolean commitText(CharSequence paramCharSequence, int paramInt)
    {
      Log.d("EditStyledText", "--- commitText:");
      this.mEST.mManager.unsetTextComposingMask();
      return super.commitText(paramCharSequence, paramInt);
    }
    
    public boolean finishComposingText()
    {
      Log.d("EditStyledText", "--- finishcomposing:");
      if ((!this.mEST.isSoftKeyBlocked()) && (!this.mEST.isButtonsFocused()) && (!this.mEST.isEditting())) {
        this.mEST.onEndEdit();
      }
      return super.finishComposingText();
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/ex/editstyledtext/EditStyledText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */