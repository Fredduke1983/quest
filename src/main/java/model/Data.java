package model;

import java.util.HashMap;
import java.util.Map;

public class Data {
    public static Map<Integer, Question> getQuestions() {
        Map<Integer, Question> map = new HashMap<>();

        map.put(1, new Question("Ви прокинулись в незнайомому будинку. Перед вами 2 двері. В яку ви увійдете? ", new HashMap<>() {{
            put("Ліворуч", 2);
            put("Праворуч", 3);
        }}));

        map.put(2, new Question("Ви зустріли вовка. Боротися чи тікати?", new HashMap<>() {{
            put("Боротися", 4);
            put("Тікати", 5);
        }}));

        map.put(3, new Question("Ви впали в яму. Гру завершено.", Map.of()));
        map.put(4, new Question("Вовк вас переміг. Гру завершено.", Map.of()));
        map.put(5, new Question("Ви втекли і врятувались! Перемога!", Map.of()));

        return map;
    }
}
