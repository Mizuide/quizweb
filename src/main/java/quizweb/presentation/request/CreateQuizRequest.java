package quizweb.presentation.request;

public class CreateQuizRequest {
    private CreateQuizParam createQuizParam;


    public class CreateQuizParam {
        private String category;

        private String title;

        private String description;

        private CreateQuestionParam[] questionParams;

        public class CreateQuestionParam {
            private String content;

            private String comment;

            private CreateChoiceParam[] choiceParams;

            public String getContent() {
                return content;
            }

            public CreateChoiceParam[] getChoiceParams() {
                return choiceParams;
            }

            public void setChoiceParams(CreateChoiceParam[] choiceParams) {
                this.choiceParams = choiceParams;
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

        public class CreateChoiceParam {
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

        public CreateQuestionParam[] getQuestionParams() {
            return questionParams;
        }

        public void setQuestionParams(CreateQuestionParam[] questionParams) {
            this.questionParams = questionParams;
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
