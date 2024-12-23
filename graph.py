import matplotlib.pyplot as plt
import time

class Post:
    def __init__(self, content, likes, comments, shares, relevance_score):
        self.content = content
        self.likes = likes
        self.comments = comments
        self.shares = shares
        self.relevance_score = relevance_score

    def get_engagement_score(self):
        return (self.likes * 2) + (self.comments * 3) + (self.shares * 5) + self.relevance_score

    def __str__(self):
        return (f"Post(content='{self.content}', likes={self.likes}, comments={self.comments}, "
                f"shares={self.shares}, relevance_score={self.relevance_score}, "
                f"engagement_score={self.get_engagement_score()})")

class FYPAlgo:
    def __init__(self, sorting_method="recursive_bubble"):
        self.posts = []
        self.sorting_method = sorting_method

    def add_post(self, post):
        self.posts.append(post)

    def recursive_bubble_sort(self, posts):
        n = len(posts)
        while n > 1:
            swapped = False
            for i in range(n - 1):
                if posts[i].get_engagement_score() < posts[i + 1].get_engagement_score():
                    posts[i], posts[i + 1] = posts[i + 1], posts[i]
                    swapped = True
            if not swapped:
                break
            n -= 1
        return posts

    def selection_sort(self):
        n = len(self.posts)
        for i in range(n - 1):
            max_idx = i
            for j in range(i + 1, n):
                if self.posts[j].get_engagement_score() > self.posts[max_idx].get_engagement_score():
                    max_idx = j
            self.posts[i], self.posts[max_idx] = self.posts[max_idx], self.posts[i]
        return self.posts

    def get_ranked_posts(self):
        if self.sorting_method == "recursive_bubble":
            self.posts = self.recursive_bubble_sort(self.posts)
        elif self.sorting_method == "selection_sort":
            self.posts = self.selection_sort()
        return self.posts

if __name__ == "__main__":
    # Running tests for both sorting methods
    sorting_methods = ["recursive_bubble", "selection_sort"]

    for method in sorting_methods:
        print(f"\nTesting {method}:")

        fyp = FYPAlgo(sorting_method=method)

        # Adding sample posts
        fyp.add_post(Post("Post 1: Cute cat video", 100, 20, 10, 50))
        fyp.add_post(Post("Post 2: Travel vlog", 200, 30, 25, 70))
        fyp.add_post(Post("Post 3: Cooking tutorial", 150, 40, 20, 60))
        fyp.add_post(Post("Post 4: Funny meme", 300, 50, 40, 80))
        fyp.add_post(Post("Post 5: Tech review", 250, 45, 30, 75))

        print("Before Sorting:")
        for post in fyp.posts:
            print(post)

        start_time = time.time()
        ranked_posts = fyp.get_ranked_posts()
        end_time = time.time()

        print("\nAfter Sorting:")
        for post in ranked_posts:
            print(post)

        print(f"Running time in milliseconds: {(end_time - start_time) * 1000:.2f} ms")

        # Plotting graph for runtime analysis
        data_sizes = [10, 100, 500, 1000]
        runtimes = []

        for size in data_sizes:
            fyp = FYPAlgo(sorting_method=method)
            for i in range(size):
                fyp.add_post(Post(f"Post {i+1}", i * 10, i * 5, i * 3, i * 2))

            start_time = time.time()
            fyp.get_ranked_posts()
            end_time = time.time()
            runtimes.append((end_time - start_time) * 1000)

        plt.plot(data_sizes, runtimes, marker='o', label=method)

    plt.title("Runtime Analysis of Sorting Methods")
    plt.xlabel("Number of Posts")
    plt.ylabel("Runtime (ms)")
    plt.legend()
    plt.grid()
    plt.show()
