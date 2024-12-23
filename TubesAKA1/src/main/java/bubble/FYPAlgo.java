package bubble;

import java.util.ArrayList;

public class FYPAlgo {
    private ArrayList<Post> posts;

    public FYPAlgo() {
        this.posts = new ArrayList<>();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public ArrayList<Post> getRankedPostsRecursive(ArrayList<Post> posts, int n, int currentIndex) {
        if (n == 1) {
            return posts;
        } else if (currentIndex >= n - 1) {
            return getRankedPostsRecursive(posts, n - 1, 0);
        } else {
            if (posts.get(currentIndex).getEngagementScore() < posts.get(currentIndex + 1).getEngagementScore()) {
                Post temp = posts.get(currentIndex);
                posts.set(currentIndex, posts.get(currentIndex + 1));
                posts.set(currentIndex + 1, temp);
            }
            return getRankedPostsRecursive(posts, n, currentIndex + 1);
        }
    }

    public ArrayList<Post> getRankedPosts() {
        return getRankedPostsRecursive(posts, posts.size(), 0);
    }

    public ArrayList<Post> getPosts() {
        return new ArrayList<>(posts);
    }
}
