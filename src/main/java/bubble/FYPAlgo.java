/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bubble;

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
            for (int j = 0; j < n - 1 - i; j++) {
                if (posts.get(j).getEngagementScore() < posts.get(j + 1).getEngagementScore()) {
                    // Swap posts[j] and posts[j+1]
                    Post temp = posts.get(j);
                    posts.set(j, posts.get(j + 1));
                    posts.set(j + 1, temp);
                }
            }
        }
        return posts;
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts);
    }
}
