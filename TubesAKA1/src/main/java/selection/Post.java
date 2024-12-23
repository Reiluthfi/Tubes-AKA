package selection;

public class Post {
    private String content;
    private int likes;
    private int comments;
    private int shares;
    private int relevanceScore;

    public Post(String content, int likes, int comments, int shares, int relevanceScore) {
        this.content = content;
        this.likes = likes;
        this.comments = comments;
        this.shares = shares;
        this.relevanceScore = relevanceScore;
    }

    public int getEngagementScore() {
        return (likes * 2) + (comments * 3) + (shares * 5) + relevanceScore;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "content='" + content + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                ", shares=" + shares +
                ", relevanceScore=" + relevanceScore +
                ", engagementScore=" + getEngagementScore() +
                '}';
    }
}
