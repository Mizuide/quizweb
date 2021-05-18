package quizweb.domain.servrice.valueobject;

import quizweb.domain.servrice.constenum.Category;
import quizweb.domain.servrice.constenum.Order;

public class SearchCondition {
    public SearchCondition(Category category, String title, Order order) {
        this.category = category;
        this.title = title;
        this.order = order;
    }

    private Category category;
    private String title;
    private Order order;

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public Order getOrder() {
        return order;
    }
}
