package quizweb.presentation.request;

import quizweb.domain.repository.entity.Quiz;

public class GetQuizRequest {
    public static class SearchCondition {

        private String title;
        private String category;
        private String order;

        public String getTitle() {
            return title;
        }

        public String getCategory() {
            return category;
        }

        public String getOrder() {
            return order;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }

    private SearchCondition searchConditions;

    private Quiz lastQuiz;

    public SearchCondition getSearchCondition() {
        return searchConditions;
    }

    public Quiz getLastQuiz() {
        return lastQuiz;
    }

    public void setLastQuiz(Quiz lastQuiz) {
        this.lastQuiz = lastQuiz;
    }

    public void setSearchConditions(SearchCondition searchConditions) {
        this.searchConditions = searchConditions;
    }
}
