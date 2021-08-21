package quizweb.domain.servrice.valueobject;

import quizweb.domain.servrice.constenum.Category;
import quizweb.domain.servrice.constenum.Order;

public class SearchCondition {
    public SearchCondition( String title, Order order) {
        this.title = title;
        this.order = order;
    }
 private String title;
    private Order order;


    public String getTitle() {
        return title;
    }

    public Order getOrder() {
        return order;
    }
}
