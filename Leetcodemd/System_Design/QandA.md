<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*
Design Q&A application as in Amazon has it for each product
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

import java.util.*;

public class OOPDesignQnA {

    Map<Question, Map<Integer, Answer>> questionAnswerMap;
    Map<Integer, Question> questionMap;
    Map<Integer, Map<Integer, Question>> productQnAMap;
    Map<Integer, List<Question>> productQuestions;

    public OOPDesignQnA(){
        this.questionMap = new TreeMap<>();//TreeMap, entry ia sorted by key
        this.productQnAMap = new TreeMap<>();
    }


    public void addQuestion(String text, Integer productId, Integer userId){
        Question question = new Question(productId, text, userId);
        questionMap.put(question.id, question);
        productQnAMap.put(productId, questionMap);
        if(productQuestions.containsKey(productId)) {
            List<Question> list = productQuestions.get(productId);
            list.add(question);//连带影响
            Collections.sort(list);//连带影响
        }else{
            List<Question> questions = new ArrayList<>();
            questions.add(question);
            productQuestions.put(productId, questions);
        }
    }

    public void addAnswer(Integer productId, Integer questionId, String text, Integer userId){
        Answer answer = new Answer(questionId, productId, text, userId);
        Question question = questionMap.get(questionId);
        List<Answer> answerList = question.answerList;
        answerList.add(answer);//连带影响
        Collections.sort(answerList);//连带影响

        if(questionAnswerMap.containsKey(question)){
            questionAnswerMap.get(question).put(answer.id, answer);
        }else{
            Map<Integer, Answer> answerMap = new HashMap<>();
            answerMap.put(answer.id, answer);
            questionAnswerMap.put(question, answerMap);
        }
    }

    public List<Question> getAllQuestions(Integer productId){
        return productQuestions.get(productId);
    }

    public List<Answer> getAnswersforQuestions(Integer productId, Integer questionId){
        Map<Integer, Question> qMap = productQnAMap.get(productId);
        return qMap.get(questionId).answerList;
    }

    public void upvoteQuestion(Integer productId, Integer questionId){
        Map<Integer, Question> qMap = productQnAMap.get(productId);
        qMap.get(questionId).upvotes += 1;//连带影响
        List<Question> questions = productQuestions.get(productId);
        Collections.sort(questions);//连带影响
    }

    public void upvoteAnswer(Integer productId, Integer questionId, Integer answerId){
        Map<Integer, Question> qMap = productQnAMap.get(productId);
        Question question = qMap.get(questionId);//注意, 在constructor里面自动增加id
        Answer answer = questionAnswerMap.get(question).get(answerId);//注意, 在constructor里面自动增加id
        answer.upvotes += 1;//连带影响
        Collections.sort(question.answerList);//连带影响
    }

}

class Question implements Comparable<Question>{

    static Integer count = 0;//注意, 在constructor里面自动增加id
    Integer id;
    Integer productId;
    String text;
    Integer userId;
    List<Answer> answerList;
    Integer upvotes;
    Date createdAt;


    public Question(Integer productId, String text, Integer userId){
        this.productId = productId;
        this.text = text;
        this.userId= userId;
        this.id = count++;//注意, 在constructor里面自动增加id
        answerList = new ArrayList<>();
        this.upvotes = 0;
        this.createdAt = new Date();
    }

    @Override
    public int compareTo(Question o) {
        if(this.upvotes == o.upvotes){
            return createdAt.compareTo(o.createdAt);
        }else{
            return this.upvotes - o.upvotes;
        }
    }

}


class Answer implements Comparable<Answer>{

    static Integer count = 0; //注意, 在constructor里面自动增加id

    Integer id; 
    Integer questionId;
    Integer productId;
    Integer userId;
    String text;
    Integer upvotes;
    Date createdAt;


    public Answer(Integer questionId, Integer productId, String text, Integer userId){
        this.questionId = questionId;
        this.productId = productId;
        this.text = text;
        this.userId = userId;
        this.id = count++;//注意, 在constructor里面自动增加id
        this.upvotes = 0;
        this.createdAt = new Date();
    }

    @Override
    public int compareTo(Answer o) {
        if(this.upvotes == o.upvotes){
            return createdAt.compareTo(o.createdAt);
        }else{
            return this.upvotes - o.upvotes;
        }
    }
}</code></pre>
</div>
</div>
