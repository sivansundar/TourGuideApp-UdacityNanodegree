package tourguideapp.com.tourguideapp;

public class Content {

    private String mTitle;
    private String mLocation;
    private String mTimings;
    private String mAbout;
    private int mImageResourceId;

    public Content(String mTitle, String mLocation, String mTimings, String mAbout) {
        this.mTitle = mTitle;
        this.mLocation = mLocation;
        this.mTimings = mTimings;
        this.mAbout = mAbout;
    }

    public Content(int mImageResourceId, String mTitle, String mLocation, String mTimings, String mAbout) {
        this.mTitle = mTitle;
        this.mLocation = mLocation;
        this.mTimings = mTimings;
        this.mAbout = mAbout;
        this.mImageResourceId = mImageResourceId;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public String getmTitle() {
        return mTitle;

    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmTimings() {
        return mTimings;
    }

    public String getmAbout() {
        return mAbout;
    }
}
