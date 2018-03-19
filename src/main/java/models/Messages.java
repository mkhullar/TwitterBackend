package models;

public class Messages {
    private Integer person_id;
    private String handle;
    private String content;

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public Messages(){}

    public Messages(Integer person_id, String handle, String content) {
        this.person_id = person_id;
        this.handle = handle;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "person_id=" + person_id +
                ", handle='" + handle + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
