document.getElementById("newsForm").addEventListener("submit", function(event) {
    event.preventDefault();
    const source = document.getElementById("source").value;
    const apiKey = "2c227bddfe844c90a139e41a104a75a1";
    console.log("Fetching news for source:", source);
    fetchNews(source, apiKey);
});

function fetchNews(source, apiKey) {
    fetch(`/api/v1/news?sources=${source}&apiKey=${apiKey}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch news.");
            }
            return response.json();
        })
        .then(data => {
            console.log("Data received:", data);
            displayNews(data.articles);
        })
        .catch(error => {
            console.error("Error fetching news:", error);
        });
}

function displayNews(articles) {
    const newsContainer = document.getElementById("newsContainer");
    newsContainer.innerHTML = "";

    if (articles && articles.length > 0) {
        articles.forEach(article => {
            const newsElement = document.createElement("div");
            newsElement.classList.add("news-article");
            newsElement.innerHTML = `
                <h3>${article.title}</h3>
                <p>${article.description || "No description available"}</p>
                <a href="${article.url}" target="_blank">Read more</a>
            `;
            newsContainer.appendChild(newsElement);
        });
    } else {
        newsContainer.innerHTML = "<p>No articles found.</p>";
    }
}
