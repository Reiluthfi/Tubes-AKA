package selection;

import java.util.ArrayList;

public class FYPAlgo {
    private ArrayList<Post> posts;

    public FYPAlgo() {
        this.posts = new ArrayList<>();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public ArrayList<Post> getRankedPosts() {
        int n = posts.size();
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (posts.get(j).getEngagementScore() > posts.get(maxIdx).getEngagementScore()) {
                    maxIdx = j;
                }
            }
            Post temp = posts.get(maxIdx);
            posts.set(maxIdx, posts.get(i));
            posts.set(i, temp);
        }
        return posts;
    }

    public ArrayList<Post> getPosts() {
        return new ArrayList<>(posts);
    }
}
