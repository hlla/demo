package example.com.testui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengjian on 18-5-16.
 */

/**
 * @author chengjian
 *         处理欧盟政策UI
 */
public class ProtocolUIController {
    protected Context mContext;
    private ViewPager mViewpager;
    private ViewGroup mIndicator;
    private List<View> mList = new ArrayList<>();
    private ResizableBulletSpan mBulletSpan;
    private static final String STRING_APP_CHOICES = "www.aboutads.info/appchoices";

    public ProtocolUIController(Context context, ViewPager viewPager, ViewGroup indicator) {
        mContext = context;
        mIndicator = indicator;
        mViewpager = viewPager;
        initPageContent();
        initDotSnaps(indicator, mList.size());
        ViewPagerAdapter adapter = new ViewPagerAdapter(mList);
        mViewpager.setAdapter(adapter);
        mViewpager.addOnPageChangeListener(mViewPageChangeListener);
        adapter.notifyDataSetChanged();

    }

    private void initDotSnaps(ViewGroup indicator, int count) {
        for (int i = 0; i < count; i++) {
            TextView dot = new TextView(mContext);
            int size = mContext.getResources().getDimensionPixelSize(R.dimen
                    .splash_policy_desc_page_dot_height);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(size, size);
            int marginSize = size / 2;
            lp.setMargins(marginSize, 0, marginSize, 0);
            dot.setLayoutParams(lp);
            indicator.addView(dot);
            if (i == 0) {
                dot.setBackgroundResource(getHighLightDotBgResId());
            } else {
                dot.setBackgroundResource(getNormalDotBgResId());
            }
        }
    }

    private void initPageContent() {
        //告知部分
        View inform = LayoutInflater.from(mContext).inflate(
                R.layout.europe_viewapger_item, null);
        LinearLayout informContainer = (LinearLayout) inform.findViewById(R.id
                .ll_europe_viewpager_container);

        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mBulletSpan = new ResizableBulletSpan(
                mContext.getResources().getDimensionPixelSize(R.dimen.splash_dot_radius_size),
                mContext.getResources().getDimensionPixelSize(R.dimen.splash_dot_padding_left),
                mContext.getResources().getDimensionPixelSize(R.dimen.splash_dot_padding_right),
                getSymbolColor());
        llp.bottomMargin = (int) mContext.getResources().getDimension(R.dimen
                .splash_content_margin_bottom);
        TextView informTitle = new TextView(mContext);
        informTitle.setTextColor(getNormalTextColor());
        informTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimension
                (R.dimen.splash_text_size_14sp));
        informTitle.setMovementMethod(LinkMovementMethod.getInstance());
        informTitle.setText(getProtocolInformTitleText());
        informTitle.setHighlightColor(0);
        informContainer.addView(informTitle, llp);

        TextView informPurpose = new TextView(mContext);
        informPurpose.setTextColor(getNormalTextColor());
        informPurpose.setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimension
                (R.dimen.splash_text_size_12sp));
        informPurpose.setText(getProtocolPurposeCollectionText());
        informContainer.addView(informPurpose, llp);

        TextView informSharing = new TextView(mContext);
        informSharing.setTextColor(getNormalTextColor());
        informSharing.setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimension
                (R.dimen.splash_text_size_12sp));
        informSharing.setText(getProtocolThirdSharingText());
        informContainer.addView(informSharing, llp);

        TextView informRights = new TextView(mContext);
        informRights.setTextColor(getNormalTextColor());
        informRights.setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimension
                (R.dimen.splash_text_size_12sp));
        informRights.setText(getProtocolPrivacyRightsText());
        informContainer.addView(informRights, llp);


        //撤回提示
        View revoke = LayoutInflater.from(mContext).inflate(
                R.layout.europe_viewapger_item, null);
        LinearLayout revokeContainer = (LinearLayout) revoke.findViewById(R.id
                .ll_europe_viewpager_container);

        TextView revokeTitle = new TextView(mContext);
        revokeTitle.setTextColor(getNormalTextColor());
        revokeTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimension
                (R.dimen.splash_text_size_14sp));
        revokeTitle.setText(R.string.europe_policy_page_second_head);
        revokeContainer.addView(revokeTitle, llp);

        TextView revokeDownload = new TextView(mContext);
        revokeDownload.setTextColor(getNormalTextColor());
        revokeDownload.setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimension
                (R.dimen.splash_text_size_12sp));
        revokeDownload.setMovementMethod(LinkMovementMethod.getInstance());
        revokeDownload.setText(getProtocolRevokeDownloadText());
        revokeDownload.setHighlightColor(0);
        revokeContainer.addView(revokeDownload, llp);

        TextView revokeAdjust = new TextView(mContext);
        revokeAdjust.setTextColor(getNormalTextColor());
        revokeAdjust.setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimension
                (R.dimen.splash_text_size_12sp));
        revokeAdjust.setText(getProtocolAdjustingSettingsText());
        revokeContainer.addView(revokeAdjust, llp);

        TextView revokeMore = new TextView(mContext);
        revokeMore.setTextColor(getNormalTextColor());
        revokeMore.setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimension
                (R.dimen.splash_text_size_12sp));
        revokeMore.setMovementMethod(LinkMovementMethod.getInstance());
        revokeMore.setText(getProtocolRevokeLearnMoreText());
        revokeMore.setHighlightColor(0);
        revokeContainer.addView(revokeMore, llp);

        mList.add(inform);
        mList.add(revoke);
    }

    private ViewPager.OnPageChangeListener mViewPageChangeListener = new ViewPager
            .OnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            int childCount = mIndicator.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (i == position) {
                    mIndicator.getChildAt(i).setBackgroundResource(getHighLightDotBgResId());
                } else {
                    mIndicator.getChildAt(i).setBackgroundResource(getNormalDotBgResId());
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }
    };

    class ViewPagerAdapter<T extends View> extends PagerAdapter {
        private List<? extends View> mList;

        public ViewPagerAdapter(List<? extends View> list) {
            mList = list;
        }

        @Override
        public int getCount() {
            return mList == null ? 0 : mList.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            if (object instanceof View) {
                container.removeView((View) object);
            }
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View item;
            if (mList != null && position >= 0 && position < mList.size()) {
                item = mList.get(position);
                if (!isUseDefaultVerticalThumbDrawable()) {
                    setVerticalThumbDrawable(item.findViewById(R.id.scroll_container),
                            getVerticalThumbDrawable());
                }
                container.addView(item);
                return item;
            } else {
                return new View(mContext);
            }
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }

    class UrlClickableSpan extends ClickableSpan {
        private String mUrl;
        private String mTitle;

        public UrlClickableSpan(final String url, final String title) {
            mUrl = url;
            mTitle = title;
        }

        @Override
        public void onClick(View view) {
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setColor(getUrlColor());
        }
    }

    /**
     * 获取 了解更多 带Span的内容
     *
     * @return Spannable结果
     */
    private SpannableString getProtocolRevokeLearnMoreText() {
        String termOfUse = mContext.getString(R.string.terms_of_service_text);
        String privacyStr = mContext.getString(R.string.privacy_text);
        String adChoices = mContext.getString(R.string.cheetah_mobile_advertising_choices_text);
        SpannableString learnMoreContent = new SpannableString(mContext.getString(R.string
                .europe_policy_page_second_foot, adChoices, privacyStr, termOfUse));

        int adChoicesStartPos = learnMoreContent.toString().indexOf(adChoices);
        int adChoicesEndPos = adChoicesStartPos + adChoices.length();

        int termStartPos = learnMoreContent.toString().indexOf(termOfUse);
        int termEndPos = termStartPos + termOfUse.length();

        int privacyStartPos = learnMoreContent.toString().indexOf(privacyStr);
        int privacyEndPos = privacyStartPos + privacyStr.length();

        UrlClickableSpan adChoicesClickableSpan = new UrlClickableSpan(UrlConstants
                .CM_AD_CHOICES_URL, adChoices);
        UrlClickableSpan termOfUseClickableSpan = new UrlClickableSpan(UrlConstants
                .TERMSERVICE_URL, termOfUse);
        UrlClickableSpan privacyClickableSpan = new UrlClickableSpan(UrlConstants.PRIVACY_URL,
                privacyStr);

        if (adChoicesStartPos >= 0) {
            learnMoreContent.setSpan(adChoicesClickableSpan, adChoicesStartPos, adChoicesEndPos,
                    Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }

        if (termStartPos >= 0) {
            learnMoreContent.setSpan(termOfUseClickableSpan, termStartPos, termEndPos,
                    Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }

        if (privacyStartPos >= 0) {
            learnMoreContent.setSpan(privacyClickableSpan, privacyStartPos, privacyEndPos,
                    Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }
        return learnMoreContent;
    }

    /**
     * 获取 收集目的 带Span的内容
     *
     * @return Spannable结果
     */
    private SpannableString getProtocolPurposeCollectionText() {
        String purposeCollection = mContext.getString(R.string.europe_privacy_purpose_collection);
        SpannableString purposeCollectionSpan = new SpannableString(purposeCollection);
        purposeCollectionSpan.setSpan(mBulletSpan, 0, purposeCollection.length(), Spanned
                .SPAN_EXCLUSIVE_EXCLUSIVE);

        return purposeCollectionSpan;
    }

    /**
     * 获取 数据分享给第三方伙伴 带Span的内容
     *
     * @return Spannable结果
     */
    private SpannableString getProtocolThirdSharingText() {
        String thirdSharing = mContext.getString(R.string.europe_privacy_third_sharing);
        SpannableString thirdSharingSpan = new SpannableString(thirdSharing);
        thirdSharingSpan.setSpan(mBulletSpan, 0, thirdSharing.length(), Spanned
                .SPAN_EXCLUSIVE_EXCLUSIVE);

        return thirdSharingSpan;
    }

    /**
     * 获取 隐私权利 带Span的内容
     *
     * @return Spannable结果
     */
    private SpannableString getProtocolPrivacyRightsText() {
        String privacyRights = mContext.getString(R.string.europe_privacy_rights);
        SpannableString privacyRightsSpan = new SpannableString(privacyRights);
        privacyRightsSpan.setSpan(mBulletSpan, 0, privacyRights.length(), Spanned
                .SPAN_EXCLUSIVE_EXCLUSIVE);

        return privacyRightsSpan;
    }

    /**
     * 获取 告知部分 带Span的内容
     *
     * @return Spannable结果
     */
    private SpannableString getProtocolInformTitleText() {
        String termOfUse = mContext.getString(R.string.terms_of_service_text);
        String privacyStr = mContext.getString(R.string.privacy_text);
        SpannableString policyDescContent = new SpannableString(mContext.getString(R.string
                .europe_policy_page_first_head, privacyStr, termOfUse));
        int termStartPos = policyDescContent.toString().indexOf(termOfUse);
        int termEndPos = termStartPos + termOfUse.length();
        int privacyStartPos = policyDescContent.toString().indexOf(privacyStr);
        int privacyEndPos = privacyStartPos + privacyStr.length();

        UrlClickableSpan termOfUseClickableSpan = new UrlClickableSpan(UrlConstants
                .TERMSERVICE_URL, termOfUse);
        UrlClickableSpan privacyClickableSpan = new UrlClickableSpan(UrlConstants.PRIVACY_URL,
                privacyStr);

        if (termStartPos >= 0) {
            policyDescContent.setSpan(termOfUseClickableSpan, termStartPos, termEndPos,
                    Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }
        if (privacyStartPos >= 0) {
            policyDescContent.setSpan(privacyClickableSpan, privacyStartPos, privacyEndPos,
                    Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }
        return policyDescContent;
    }

    /**
     * 获取 告知部分 带Span的内容
     *
     * @return Spannable结果
     */
    private SpannableString getProtocolRevokeDownloadText() {
        String revokeDownload = mContext.getString(R.string.europe_policy_page_second_list,
                STRING_APP_CHOICES);
        SpannableString revokeDownloadContent = new SpannableString(revokeDownload);
        int appchoicesPos = revokeDownloadContent.toString().indexOf(STRING_APP_CHOICES);
        int appchoicesEndPos = appchoicesPos + STRING_APP_CHOICES.length();

        revokeDownloadContent.setSpan(mBulletSpan, 0, revokeDownload.length(), Spanned
                .SPAN_EXCLUSIVE_EXCLUSIVE);

        UrlClickableSpan appchoicesClickableSpan = new UrlClickableSpan(UrlConstants
                .APPCHOICES_URL,
                STRING_APP_CHOICES);

        if (appchoicesPos >= 0) {
            revokeDownloadContent.setSpan(appchoicesClickableSpan, appchoicesPos, appchoicesEndPos,
                    Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }
        return revokeDownloadContent;
    }

    /**
     * 获取 调整App设置 带Span的内容
     *
     * @return Spannable结果
     */
    private SpannableString getProtocolAdjustingSettingsText() {
        String adjustingSettings = mContext.getString(R.string
                .europe_policy_page_second_revoke);
        SpannableString purposeCollectionSpan = new SpannableString(adjustingSettings);
        purposeCollectionSpan.setSpan(mBulletSpan, 0, adjustingSettings.length(), Spanned
                .SPAN_EXCLUSIVE_EXCLUSIVE);

        return purposeCollectionSpan;
    }

    public int getSymbolColor() {
        return mContext.getResources().getColor(R.color.white);
    }

    public int getNormalTextColor() {
        return mContext.getResources().getColor(R.color.white);
    }

    public int getUrlColor() {
        return mContext.getResources().getColor(R.color.splash_desc_highlight_color);
    }

    public int getHighLightDotBgResId() {
        return R.drawable.dot_white;
    }

    public int getNormalDotBgResId() {
        return R.drawable.dot_gray;
    }

    public Drawable getVerticalThumbDrawable() {
        return mContext.getResources().getDrawable(R.drawable.scroll_bar_white_indicator);
    }

    public boolean isUseDefaultVerticalThumbDrawable() {
        return true;
    }

    private void setVerticalThumbDrawable(View view, Drawable drawable) {
        try {
            Field scrollCacheField = View.class.getDeclaredField("mScrollCache");
            boolean isAccess = scrollCacheField.isAccessible();
            scrollCacheField.setAccessible(true);
            Object scrollCache = scrollCacheField.get(view);
            scrollCacheField.setAccessible(isAccess);
            Field scrollBarField = scrollCache.getClass().getField("scrollBar");
            isAccess = scrollBarField.isAccessible();
            scrollBarField.setAccessible(true);
            Object scrollBar = scrollBarField.get(scrollCache);
            scrollBarField.setAccessible(isAccess);
            Method setVerticalThumbDrawableMethod = scrollBar.getClass().getMethod
                    ("setVerticalThumbDrawable", Drawable.class);
            isAccess = setVerticalThumbDrawableMethod.isAccessible();
            setVerticalThumbDrawableMethod.setAccessible(true);
            setVerticalThumbDrawableMethod.invoke(scrollBar, drawable);
            setVerticalThumbDrawableMethod.setAccessible(isAccess);
        } catch (Throwable e) {
        }
    }
}
