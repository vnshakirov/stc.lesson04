package part01.lesson04.task03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MathBox extends ObjectBox<Number> {

    /**
     * Создает коллекцию и инициирует ее массивом Number
     * @param numbers
     */
    public MathBox(Number[] numbers) {
        box = new HashSet<>(Arrays.asList(numbers));
    }

    /**
     * Суммирует все элементы коллекции. Сумма будет приведена к максимально широкому типу в коллекции
     * @return сумма элементов
     */
    public Number summator() {
        double resultD = 0.0;
        long resultL = 0L;
        for (Number n : box) {
            if (n instanceof Double) {
                resultD += n.doubleValue();
            } else if (n instanceof Float) {
                resultD += n.floatValue();
            } else if (n instanceof Long) {
                resultL += n.longValue();
            } else if (n instanceof Integer) {
                resultL += n.intValue();
            }else if (n instanceof Short) {
                resultL += n.shortValue();
            } else if (n instanceof Byte) {
                resultL += n.byteValue();
            }
        }
        if (resultD != 0.0) {
            return resultD + resultL;
        } else {
            return resultL;
        }
    }

    /**
     * Делит все элементы коллекции на параметр split, заменяет исходную коллекцию
     * @param split
     */
    public void splitter(double split) {
        Set<Number> temp = new HashSet<>();
        for (Number n : box) {
            temp.add(n.doubleValue() / split);
        }
        box.clear();
        box.addAll(temp);
    }


    /**
     * Удаляет из коллекции все элементы, значение которых равно value
     * @param value
     */
    public void deleteInteger(Integer value) {
        Iterator<Number> iterator = box.iterator();
        while (iterator.hasNext()) {
            Number element = iterator.next();
            if (element.intValue() == value) {
                iterator.remove();
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Number n : box) {
            hash += n.hashCode();
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        MathBox object = (MathBox) obj;
        return object.box.containsAll(box) && (object.box.size() == box.size());
    }

    @Override
    public String toString() {
        return dump();
    }
}
