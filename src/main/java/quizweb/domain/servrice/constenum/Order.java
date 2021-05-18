package quizweb.domain.servrice.constenum;

public enum Order {
    newOrder("id DESC"),
    oldOrder("id"),
    viewOrder("answerer_num DESC");

    private String value;

    private Order(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    
    
}
