package service.QuizItem;

import service.Question.Question;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "quizitems")

//@NamedQuery(name="findByCategory", query="select a from Answer a inner join a.question q where a.question=:question")
@NamedQuery(name="findByCategory", query="select q from QuizItem q inner join q.question c where c.category=:category")
public class QuizItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id", nullable = false)
    private Integer id;


    @Column(name = "is_correct", nullable = false, length = 45)
    private String isCorrect;

    @Column(name = "answer_text1", nullable = false, length = 45)
    private String answerText1;

    @Column(name = "answer_text2", nullable = false, length = 45)
    private String answerText2;

    @Column(name = "answer_text3", length = 45)
    private String answerText3;

    @Column(name = "answer_text4", nullable = false, length = 45)
    private String answerText4;

    @OneToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "question_id")
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getAnswerText1() {
        return answerText1;
    }

    public void setAnswerText1(String answerText1) {
        this.answerText1 = answerText1;
    }

    public String getAnswerText2() {
        return answerText2;
    }

    public void setAnswerText2(String answerText2) {
        this.answerText2 = answerText2;
    }

    public String getAnswerText3() {
        return answerText3;
    }

    public void setAnswerText3(String answerText3) {
        this.answerText3 = answerText3;
    }

    public String getAnswerText4() {
        return answerText4;
    }

    public void setAnswerText4(String answerText4) {
        this.answerText4 = answerText4;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizItem quizItem = (QuizItem) o;
        return Objects.equals(id, quizItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", isCorrect='" + isCorrect + '\'' +
                ", answerText1='" + answerText1 + '\'' +
                ", answerText2='" + answerText2 + '\'' +
                ", answerText3='" + answerText3 + '\'' +
                ", answerText4='" + answerText4 + '\'' +
                ", question=" + question +
                '}';
    }
}