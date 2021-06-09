package quizweb.presentation.request;

import java.util.List;

public class CreateQuizRequest {
    private CreateQuizParam createQuizParam;


    public static class CreateQuizParam {
        private String category;

        private String title;

        private String description;

        private List<CreateQuestionParam> questions;

        public static class CreateQuestionParam {
            private String content;

            private String comment;

            private List<CreateChoiceParam> choices;

            public String getContent() {
                return content;
            }

            public List<CreateChoiceParam> getChoices() {
                return choices;
            }

            public void setChoices(List<CreateChoiceParam> choiceParams) {
                this.choices = choiceParams;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        public static class CreateChoiceParam {
            private String content;

            private boolean correctFlg;

            public String getContent() {
                return content;
            }

            public boolean getCorrectFlg() {
                return correctFlg;
            }

            public void setCorrectFlg(boolean correctFlg) {
                this.correctFlg = correctFlg;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        public String getCategory() {
            return category;
        }

        public List<CreateQuestionParam> getQuestions() {
            return questions;
        }

        public void setQuestions(List<CreateQuestionParam> questions) {
            this.questions = questions;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setCategory(String category) {
            this.category = category;
        }

    }


    public CreateQuizParam getCreateQuizParam() {
        return createQuizParam;
    }


    public void setCreateQuizParam(CreateQuizParam createQuizParam) {
        this.createQuizParam = createQuizParam;
    }
}
