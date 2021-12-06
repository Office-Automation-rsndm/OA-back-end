package entity;

public class Note {
    private int id;
    private int noteUser;
    private String detail;

    public Note( int noteUser, String detail) {

        this.noteUser = noteUser;
        this.detail = detail;
    }

    public Note() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoteUser() {
        return noteUser;
    }

    public void setNoteUser(int noteUser) {
        this.noteUser = noteUser;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
