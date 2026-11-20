package Class_Problems;

import java.util.*;
import java.util.regex.*;

abstract class Question {
    protected String type;
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String type, String questionText, String correctAnswer, String studentAnswer, int points) {
        this.type = type;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public String getType() {
        return type;
    }

    public abstract double grade();
}

class MCQQuestion extends Question {
    public MCQQuestion(String q, String c, String s, int p) {
        super("MCQ", q, c, s, p);
    }

    @Override
    public double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0.0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String q, String c, String s, int p) {
        super("TF", q, c, s, p);
    }

    @Override
    public double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String q, String c, String s, int p) {
        super("ESSAY", q, c, s, p);
    }

    @Override
    public double grade() {
        String[] keywords = correctAnswer.split(",");
        String lowerAns = studentAnswer.toLowerCase();
        int matched = 0;
        for (String kw : keywords) {
            if (lowerAns.contains(kw.trim().toLowerCase())) {
                matched++;
            }
        }
        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }
        return 0.0;
    }
}

public class ExamQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> questions = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            Matcher matcher = pattern.matcher(line);
            List<String> tokens = new ArrayList<>();
            while (matcher.find()) {
                tokens.add(matcher.group(1) != null ? matcher.group(1) : matcher.group(2));
            }

            String type = tokens.get(0);
            String qText = tokens.get(1);
            String correct = tokens.get(2);
            String student = tokens.get(3);
            int points = Integer.parseInt(tokens.get(4));

            switch (type) {
                case "MCQ":
                    questions.add(new MCQQuestion(qText, correct, student, points));
                    break;
                case "TF":
                    questions.add(new TFQuestion(qText, correct, student, points));
                    break;
                case "ESSAY":
                    questions.add(new EssayQuestion(qText, correct, student, points));
                    break;
            }
        }

        double total = 0;
        for (Question q : questions) {
            double score = q.grade();
            total += score;
            System.out.printf("%s: %.2f%n", q.getType(), score);
        }
        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}