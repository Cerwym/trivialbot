package trivialbot;

/**
 *
 * @author hussein
 */
public class Question {
    private String question;
    private String answer;

    public Question() {
    }    
    
    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }   
    

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    
}
