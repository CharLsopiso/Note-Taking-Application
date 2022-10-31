package Notes;

public class noteinfo {

    private String title, contents;
//
    public noteinfo(String Title, String Contents) {
        this.title = Title;
        this.contents = Contents;
    }

//
    public String setTitle(String Title) {
        this.title = Title;
        return this.title;
    }
    public String setContents(String Contents) {
        this.contents = Contents;
        return this.contents;
    }

//
    public String getTitle() {
        return this.title;
    }
    public String getContents() {
        return this.contents;
    }
}
