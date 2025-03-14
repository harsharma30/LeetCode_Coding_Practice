import requests
import json
import os

# Replace with your LeetCode username
LEETCODE_USERNAME = "your_username"

# Fetch user stats from LeetCode API
def fetch_leetcode_stats():
    url = "https://leetcode-stats-api.herokuapp.com/" + LEETCODE_USERNAME
    response = requests.get(url)
    
    if response.status_code == 200:
        return response.json()
    else:
        return None

# Update README.md with the latest stats
def update_readme(stats):
    readme_path = "README.md"
    
    with open(readme_path, "r", encoding="utf-8") as file:
        content = file.readlines()

    for i, line in enumerate(content):
        if line.startswith("| 🟢 Easy"):
            content[i] = f"| 🟢 Easy    | {stats['easySolved']}/{stats['totalEasy']} |\n"
        elif line.startswith("| 🟡 Medium"):
            content[i] = f"| 🟡 Medium  | {stats['mediumSolved']}/{stats['totalMedium']} |\n"
        elif line.startswith("| 🔴 Hard"):
            content[i] = f"| 🔴 Hard    | {stats['hardSolved']}/{stats['totalHard']} |\n"

    with open(readme_path, "w", encoding="utf-8") as file:
        file.writelines(content)

    print("README.md updated successfully.")

if __name__ == "__main__":
    stats = fetch_leetcode_stats()
    if stats:
        update_readme(stats)
    else:
        print("Failed to fetch LeetCode stats.")
