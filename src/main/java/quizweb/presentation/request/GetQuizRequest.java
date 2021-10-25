package quizweb.presentation.request;

import quizweb.domain.servrice.valueobject.SearchCondition;

public class GetQuizRequest {

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
