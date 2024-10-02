<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SSAFIT video & review</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 1200px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1, h2 {
            color: rgb(33, 158, 242);
            border: 1px black;
        }
        .video-review-section {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            margin-bottom: 20px;
        }
        .video-container {
            flex: 1 1 600px;
        }
        .review-form-container {
            flex: 1 1 400px;
        }
        .video-info {
            margin-top: 10px;
        }
        .video-embed {
            position: relative;
            padding-bottom: 56.25%; /* 16:9 aspect ratio */
            height: 0;
            overflow: hidden;
        }
        .video-embed iframe {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        input, textarea {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            padding: 10px;
            background-color: rgb(33, 158, 242);
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: rgb(92, 188, 251);
        }
        .review {
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 10px;
            margin-top: 10px;
            border-radius: 4px;
        }
        .review-actions {
            margin-top: 10px;
        }
        .review-actions button {
            margin-right: 5px;
        }
        .hidden {
            display: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>SSAFIT 운동 영상 & 리뷰</h1>
        
        <div class="video-review-section">
            <div class="video-container">
                <h2>영상</h2>
                <div class="video-embed">
                    <iframe src="https://www.youtube.com/embed/${video.videoId}" width="560" height="315" frameborder="0" allowfullscreen></iframe>
                </div>
                <div class="video-info">
                    <h3 id="video-title"></h3>
                    <p>Channel: <span id="channel-name">${video.channelName}</span></p>
                    <p>Part: <span id="video-part">${video.videoPart}</span></p>
                </div>
            </div>
            
            <div class="review-form-container">
                <h2>리뷰를 쓰세요</h2>
                <form method="post" action="${pageContext.request.contextPath}/main">
                	<input type="hidden" name="action" value="writeReview">
                    <input type="text" name="reviewTitle" placeholder="리뷰 제목" required>
                    <input type="text" name="reviewContent" placeholder="리뷰 내용" required>
                    <input type="number" name="reviewScore" placeholder="별점 (0-5)" min="0" max="5" required>
                    <button type="submit">Add Review</button>
                </form>
            </div>
        </div>
    		<%-- <c:forEach var="video" items="${video}">
    			https://www.youtube.com/embed/${video.videoId}
			</c:forEach>
        <c:forEach var="b" items="${list}">
        <div id="reviewList">
        	<h3>${b.title}</h3>
            <p class="review-content hidden">${b.content}</p>
            <p class="review-rating hidden">Rating: ${b.rating}/5</p>
            <div class="review-actions">
                <button onclick="viewReview(${index})">View</button>
                <button onclick="editReview(${index})">Edit</button>
                <button onclick="deleteReview(${index})">Delete</button>
            </div>
        </div>        
        </c:forEach> --%>
    </div>
    
    
	<script>
        let reviews = [];
        let editingIndex = -1;
        let currentVideo = null;

        const reviewForm = document.getElementById('reviewForm');
        const reviewList = document.getElementById('reviewList');

        reviewForm.addEventListener('submit', handleSubmit);

        // Updated video data
        const videoData = {
            "id": "D3yExRi7EME&t=791s",
            "title": "뭉친 어깨, 뻣뻣한 골반 풀어주는 요가 | 앉아서 하는 요가 스트레칭 | 어깨 근육 풀기, 골반풀기",
            "part": "상체",
            "channelName": "Mindful Yoga with Eileen",
            "url": "https://www.youtube.com/watch?v=D3yExRi7EME&t=791s"
        };

        function loadVideo(videoData) {
            currentVideo = videoData;
            // Extract the video ID without the timestamp
            const videoId = videoData.id.split('&')[0];
            document.getElementById('youtube-player').src = `https://www.youtube.com/embed/${videoId}?start=791`;
            document.getElementById('video-title').textContent = videoData.title;
            document.getElementById('channel-name').textContent = videoData.channelName;
            document.getElementById('video-part').textContent = videoData.part;
        }

        function handleSubmit(e) {
            e.preventDefault();
            const title = document.getElementById('title').value;
            const content = document.getElementById('content').value;
            const rating = document.getElementById('rating').value;

            if (editingIndex === -1) {
                reviews.push({ title, content, rating, videoId: currentVideo.id });
            } else {
                reviews[editingIndex] = { title, content, rating, videoId: currentVideo.id };
                editingIndex = -1;
            }

            renderReviews();
            reviewForm.reset();
        }

        function renderReviews() {
            reviewList.innerHTML = '';
            reviews.filter(review => review.videoId === currentVideo.id).forEach((review, index) => {
                const reviewElement = document.createElement('div');
                reviewElement.className = 'review';
                reviewElement.innerHTML = `
                    <h3>${review.title}</h3>
                    <p class="review-content hidden">${review.content}</p>
                    <p class="review-rating hidden">Rating: ${review.rating}/5</p>
                    <div class="review-actions">
                        <button onclick="viewReview(${index})">View</button>
                        <button onclick="editReview(${index})">Edit</button>
                        <button onclick="deleteReview(${index})">Delete</button>
                    </div>
                `;
                reviewList.appendChild(reviewElement);
            });
        }

        function viewReview(index) {
            const reviewElement = reviewList.children[index];
            const content = reviewElement.querySelector('.review-content');
            const rating = reviewElement.querySelector('.review-rating');
            content.classList.toggle('hidden');
            rating.classList.toggle('hidden');
        }

        function editReview(index) {
            const review = reviews[index];
            document.getElementById('title').value = review.title;
            document.getElementById('content').value = review.content;
            document.getElementById('rating').value = review.rating;
            editingIndex = index;
        }

        function deleteReview(index) {
            reviews.splice(index, 1);
            renderReviews();
        }

        // Load the initial video when the page loads
        loadVideo(videoData);
    </script>
</body>
</html>