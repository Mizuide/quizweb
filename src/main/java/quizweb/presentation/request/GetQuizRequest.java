package quizweb.presentation.request;

public class GetQuizRequest {
    public static class SearchCondition {

        private String title;
        private String order;

        public String getTitle() {
            return title;
        }

        public String getOrder() {
            return order;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }

    private SearchCondition searchConditions;

    private int page;

    private int fetchSize;

    public SearchCondition getSearchCondition() {
        return searchConditions;
    }

    public void setSearchConditions(SearchCondition searchConditions) {
        this.searchConditions = searchConditions;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getFetchSize() {
        return fetchSize;
    }

    public void setFetchSize(int fetchSize) {
        this.fetchSize = fetchSize;
    }

}
