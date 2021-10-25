package quizweb.domain.servrice.valueobject;

import java.util.List;

import quizweb.domain.repository.entity.Tag;
import quizweb.domain.servrice.constenum.Order;

public class SearchCondition {
    public SearchCondition(String title, Order order, List<Tag> tags) {
        this.title = title;
        this.order = order;
        this.tags = tags;
    }

    private String title;

    private Order order;

    private List<Tag> tags;

    public String getTitle() {
        return title;
    }

    public Order getOrder() {
        return order;
    }

    public List<Tag> getTags() {
        return tags;
    }

}
