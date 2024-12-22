package selection;

import java.util.ArrayList;
import java.util.List;

public class FYPAlgo {
    private List<Post> posts;

    public FYPAlgo() {
        this.posts = new ArrayList<>();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public List<Post> getRankedPosts() {
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

    public List<Post> getPosts() {
        return new ArrayList<>(posts);
    }
    
}


