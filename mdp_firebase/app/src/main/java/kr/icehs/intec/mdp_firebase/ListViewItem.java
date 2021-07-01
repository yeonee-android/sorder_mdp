package kr.icehs.intec.mdp_firebase;

import android.os.ParcelUuid;

public class ListViewItem {
    private int iconDrawable;
    private String contentStr;
    private String titleStr;
    private String amountStr;

    public void  setTitle(String title) {
        titleStr = title;
    }
    public void setIcon(int icon) {
        iconDrawable = icon;
    }
    public void setContent(String content) {
        contentStr = content;
    }
    public void setAmount(String amount) {
        amountStr = amount;
    }

    public int getIcon() {
        return this.iconDrawable;
    }
    public String getContent() {
        return this.contentStr;
    }
    public String getTitle() {
        return this.titleStr;
    }
    public String getAmount() {
        return this.amountStr;
    }
}
