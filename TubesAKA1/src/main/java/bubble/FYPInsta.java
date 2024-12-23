package bubble;

import java.util.ArrayList;

public class FYPInsta {
    public static void main(String[] args) {
        
        long start = System.nanoTime();
        FYPAlgo fyp = new FYPAlgo();

        // Adding sample posts
        fyp.addPost(new Post("Post 1: Cute cat video", 100, 20, 10, 50));
        fyp.addPost(new Post("Post 2: Travel vlog", 200, 30, 25, 70));
        fyp.addPost(new Post("Post 3: Cooking tutorial", 150, 40, 20, 60));
        fyp.addPost(new Post("Post 4: Funny meme", 300, 50, 40, 80));
        fyp.addPost(new Post("Post 5: Tech review", 250, 45, 30, 75));

        System.out.println("Before Ranking:");
        for (Post post : fyp.getPosts()) {
            System.out.println(post);
        }

        // Get ranked posts
        ArrayList<Post> rankedPosts = fyp.getRankedPosts();

        // Cetak hasilnya
        System.out.println("\nRanked FYP Posts:");
        for (Post post : rankedPosts) {
            System.out.println(post);
        }
        long duration = (System.nanoTime() - start)/1000000;
        System.out.println("Running time dalam milisecond: " + duration + " ms");
    }
}
