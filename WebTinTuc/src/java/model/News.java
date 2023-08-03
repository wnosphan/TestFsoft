package model;

public class News {
    int ID;
   String title;
    String content;
  String author;
  String createdDate;
    int views;
   

    public News() {
    }

    public News(int ID, String title, String content, String author, String createdDate, int views) {
        this.ID = ID;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
        this.views = views;
    }

   

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    
    
}